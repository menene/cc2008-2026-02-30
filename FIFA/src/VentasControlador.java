import java.util.Random;

public class VentasControlador {
    private Comprador compradorActivo;
    private Localidad[] localidades;
    private Random random;
    private VentasVista vista;

    public VentasControlador(VentasVista vista) {
        this.vista = vista;
        this.random = new Random();
        this.localidades = new Localidad[3];
        
        localidades[0] = new Localidad(1, "Localidad 1", 100.0, 20);
        localidades[1] = new Localidad(5, "Localidad 5", 500.0, 20);
        localidades[2] = new Localidad(10, "Localidad 10", 1000.0, 20);
    }

    public void iniciarSistema() {
        boolean ejecutando = true;
        vista.mostrarMensaje("¡Bienvenido al sistema de boletos!");

        while (ejecutando) {
            int opcion = vista.mostrarMenu();

            switch (opcion) {
                case 1 -> {
                    Comprador nuevo = vista.leerComprador();
                    registrarComprador(nuevo);
                    vista.mostrarMensaje("Comprador registrado exitosamente.");
                }
                case 2 -> {
                    String resultado = procesarSolicitudBoletos();
                    vista.mostrarMensaje(resultado);
                }
                case 3 -> {
                    String reporteDisponibilidad = obtenerDisponibilidadTotal();
                    vista.mostrarMensaje(reporteDisponibilidad);
                }
                case 4 -> {
                    int idConsulta = vista.pedirIdLocalidad();
                    String resultadoIndividual = obtenerDisponibilidadIndividual(idConsulta);
                    vista.mostrarMensaje(resultadoIndividual);
                }
                case 5 -> {
                    String reporteCaja = obtenerReporteCaja();
                    vista.mostrarMensaje(reporteCaja);
                }
                case 6 -> {
                    vista.mostrarMensaje("Saliendo del sistema. ¡Hasta pronto!");
                    ejecutando = false;
                }
                default -> vista.mostrarMensaje("Opción no válida. Intente de nuevo.");
            }
        }
    }

    public void registrarComprador(Comprador nuevoComprador) {
        this.compradorActivo = nuevoComprador;
    }

public String procesarSolicitudBoletos() {
    if (compradorActivo == null) {
        return "Error: No hay un comprador registrado. Ejecute la Opción 1 primero.";
    }

    Ticket nuevoTicket = new Ticket();
    compradorActivo.setTicketAsignado(nuevoTicket);

    if (!nuevoTicket.esElegibleParaCompra()) {
        return "Lo sentimos. El ticket #" + nuevoTicket.getNumero() + " no salió sorteado en el rango.";
    }

    Localidad locSeleccionada = localidades[random.nextInt(localidades.length)];
    int cantidad = compradorActivo.getCantidadBoletos();
    double costoTotal = locSeleccionada.calcularCosto(cantidad);

    if (!locSeleccionada.puedeVender(cantidad)) {
        return "Fallo en compra: No hay espacio suficiente en " + locSeleccionada.getNombre() +
               ". Espacio actual: " + locSeleccionada.getBoletosDisponibles();
    }

    if (!compradorActivo.puedePagar(costoTotal)) {
        return "Fallo en compra: Presupuesto insuficiente. Costo total: $" + costoTotal +
               ", Presupuesto: $" + compradorActivo.getPresupuesto();
    }

    compradorActivo.descontarPresupuesto(costoTotal);
    locSeleccionada.venderBoletos(cantidad);

    return "¡Compra exitosa! Ticket #" + nuevoTicket.getNumero() + " adquirió " +
           cantidad + " boletos en " + locSeleccionada.getNombre() + ".";
}

    public String obtenerDisponibilidadTotal() {
        String reporte = "\n--- DISPONIBILIDAD TOTAL ---\n";
        for (Localidad loc : localidades) {
            reporte += loc.getNombre() 
                    + " | Vendidos: " + loc.getBoletosVendidos() 
                    + " | Disponibles: " + loc.getBoletosDisponibles() 
                    + "\n";
        }
        return reporte;
    }

    public String obtenerDisponibilidadIndividual(int idLocalidad) {
        for (Localidad loc : localidades) {
            if (loc.getIdLocalidad() == idLocalidad) {
                return "\n" + loc.getNombre() + ": " + loc.getBoletosDisponibles() + " boletos disponibles.";
            }
        }
        return "Error: No existe una localidad con el ID " + idLocalidad + ".";
    }

    public String obtenerReporteCaja() {
        double totalRecaudado = 0;
        String reporte = "\n--- REPORTE DE CAJA ---\n";
        for (Localidad loc : localidades) {
            double recaudacionLocalidad = loc.getRecaudacion();
            totalRecaudado += recaudacionLocalidad;
            reporte += loc.getNombre() + ": $" + recaudacionLocalidad + "\n";
        }
        reporte += "Total General Recaudado: $" + totalRecaudado;
        return reporte;
    }
}