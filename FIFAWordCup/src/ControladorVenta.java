public class ControladorVenta {
    private Localidad loc1;
    private Localidad loc2;
    private Localidad loc3;
    private Comprador compradorActivo;
    private VistaMenu vista = new VistaMenu();

    public ControladorVenta() {
        loc1 = new Localidad(1, 100.0, 20);
        loc2 = new Localidad(5, 500.0, 20);
        loc3 = new Localidad(10, 1000.0, 20);
    }

    public void iniciar() {
        boolean continuar = true;

        while (continuar) {
            vista.mostrarMenu();
            int opcion = vista.leerOpcion();

            if (opcion == 1) {
                String[] datos = vista.solicitarDatosComprador();
                String nombre = datos[0];
                String email = datos[1];
                int cantidad = Integer.parseInt(datos[2]);
                double presupuesto = Double.parseDouble(datos[3]);

                registrarComprador(nombre, email, cantidad, presupuesto);
                vista.mostrarResultado("Comprador registrado con exito. Ya puedes usar la opcion 2.");
            }
            else if (opcion == 2) {
                vista.mostrarResultado(procesarSolicitud());
            }
            else if (opcion == 3) {
                vista.mostrarResultado(consultarDisponibilidadTotal());
            }
            else if (opcion == 4) {
                vista.mostrarResultado("Escribe el numero de la localidad (1, 5 o 10):");
                int idLocalidad = vista.leerOpcion();
                vista.mostrarResultado(consultarDisponibilidadIndividual(idLocalidad));
            }
            else if (opcion == 5) {
                vista.mostrarResultado("Total generado en caja: $" + generarReporteCaja());
            }
            else if (opcion == 6) {
                vista.mostrarResultado("Gracias por usar el sistema. Hasta luego.");
                continuar = false;
            }
            else {
                vista.mostrarResultado("Opcion invalida. Elige un numero del 1 al 6.");
            }
        }
    }

    public void registrarComprador(String nombre, String email, int cantidad, double presupuesto) {
        compradorActivo = new Comprador(nombre, email, cantidad, presupuesto);
    }

    public String procesarSolicitud() {
        if (compradorActivo == null) {
            return "Primero debes registrar un comprador (opcion 1).";
        }

        Ticket ticket = new Ticket();
        ticket.generarNumeroTicket();
        ticket.generarRangoAB();
        boolean apto = ticket.validarRango();

        if (!apto) {
            return "Tu numero de ticket fue " + ticket.getNumeroTicket()
                    + ", pero no cayo dentro del rango ganador (" + ticket.getNumeroA()
                    + " - " + ticket.getNumeroB() + "). No puedes comprar boletos esta vez.";
        }

        ticket.asignarLocalidadAleatoria(loc1, loc2, loc3);
        Localidad localidad = ticket.getLocalidadAsignada();

        // Validacion de espacio disponible en la localidad
        if (!localidad.hayEspacio(1)) {
            return "Tu ticket fue apto y te toco la localidad " + localidad.getIdLocalidad()
                    + ", pero ya no hay espacio disponible ahi. Lo sentimos.";
        }


        int cantidadAVender = Math.min(compradorActivo.getCantidadDeseada(), localidad.getDisponibles());

        if (!validarPresupuesto(localidad)) {
            return "Tu ticket fue apto y te toco la localidad " + localidad.getIdLocalidad()
                    + " (precio $" + localidad.getPrecio() + "), pero supera tu presupuesto de $"
                    + compradorActivo.getPresupuestoMaximo() + ". No se realizo la compra.";
        }

        int vendidos = localidad.venderBoletos(cantidadAVender);

        return "Felicidades " + compradorActivo.getNombre() + ", tu ticket #" + ticket.getNumeroTicket()
                + " fue apto. Te toco la localidad " + localidad.getIdLocalidad()
                + " a $" + localidad.getPrecio() + " cada boleto. Se te vendieron " + vendidos + " boleto(s).";
    }

    private boolean validarPresupuesto(Localidad localidad) {
        return localidad.getPrecio() <= compradorActivo.getPresupuestoMaximo();
    }

    public String consultarDisponibilidadTotal() {
        String texto = "Disponibilidad de boletos:\n";
        texto += "Localidad " + loc1.getIdLocalidad() + " -> vendidos: " + loc1.getBoletosVendidos()
                + " / disponibles: " + loc1.getDisponibles() + "\n";
        texto += "Localidad " + loc2.getIdLocalidad() + " -> vendidos: " + loc2.getBoletosVendidos()
                + " / disponibles: " + loc2.getDisponibles() + "\n";
        texto += "Localidad " + loc3.getIdLocalidad() + " -> vendidos: " + loc3.getBoletosVendidos()
                + " / disponibles: " + loc3.getDisponibles();

        return texto;
    }

    public String consultarDisponibilidadIndividual(int idLocalidad) {
        if (idLocalidad == loc1.getIdLocalidad()) {
            return "Localidad " + loc1.getIdLocalidad() + " -> disponibles: " + loc1.getDisponibles();
        }
        if (idLocalidad == loc2.getIdLocalidad()) {
            return "Localidad " + loc2.getIdLocalidad() + " -> disponibles: " + loc2.getDisponibles();
        }
        if (idLocalidad == loc3.getIdLocalidad()) {
            return "Localidad " + loc3.getIdLocalidad() + " -> disponibles: " + loc3.getDisponibles();
        }

        return "No existe una localidad con ese numero. Las localidades validas son 1, 5 y 10.";
    }

    public double generarReporteCaja() {
        double total = loc1.calcularIngreso() + loc2.calcularIngreso() + loc3.calcularIngreso();
        return total;
    }
}
