public class ControladorMundial {
    private SistemaVentas sistemaVentas;
    private VistaMundial vista;

    public ControladorMundial() {
        sistemaVentas = new SistemaVentas();
        vista = new VistaMundial();
    }

    public void iniciar() {
        int opcion;

        do {

            vista.mostrarMenu();
            opcion = vista.leerOpcionMenu();

            switch (opcion) {

                case 1:
                    nuevoComprador();
                    break;

                case 2:
                    nuevaSolicitud();
                    break;

                case 3:
                    consultarDisponibilidadTotal();
                    break;

                case 4:
                    consultarDisponibilidadLocalidad();
                    break;

                case 5:
                    mostrarReporteCaja();
                    break;

                case 0:
                    vista.mostrarMensaje("\nGracias por utilizar el sistema ;) Que tenga un buen día.");
                    break;

                default:
                    vista.mostrarMensaje("Opción inválida -_-. Escoja nuevamente");
            }

        } while (opcion != 0);

    }

    private void nuevoComprador() {

        String nombre = vista.leerNombre();
        String email = vista.leerEmail();
        int cantidad = vista.leerCantidadBoletos();
        double presupuesto = vista.leerPresupuesto();

        sistemaVentas.crearComprador(
                nombre,
                email,
                cantidad,
                presupuesto
        );

        vista.mostrarMensaje("Comprador creado correctamente +_+.");

    }

    private void nuevaSolicitud() {

        if (sistemaVentas.getCompradorActual() == null) {
            vista.mostrarMensaje("\n    Primero debe registrar un comprador -_-.");
            return;
        }

        sistemaVentas.generarTicket();

        if (!sistemaVentas.validarTicket()) {
            vista.mostrarMensaje("El ticket no fue seleccionado para comprar.");
            return;
        }

        sistemaVentas.asignarLocalidad();

        if (!sistemaVentas.validarEspacio()) {
            vista.mostrarMensaje("No existe suficiente espacio en la localidad.");
            return;
        }

        if (!sistemaVentas.validarPresupuesto()) {
            vista.mostrarMensaje("El presupuesto es insuficiente para realizar la compra.");
            return;
        }

        Localidad localidad = sistemaVentas
                              .getCompradorActual()
                              .getTicket()
                              .getLocalidadAsignada();

        int vendidos = sistemaVentas.calcularBoletosAVender();
        boolean compraParcial = vendidos < sistemaVentas    
                                            .getCompradorActual()
                                            .getCantidadBoletos();
        double total = vendidos * localidad.getPrecio();

        sistemaVentas.venderBoletos();

        //Vista linda con buen mensaje
        String mensaje;

            if (compraParcial) {

                mensaje =
                        "\n=========================================\n"
                        + "Compra realizada parcialmente.\n\n"
                        + "Ticket: "
                        + sistemaVentas.getCompradorActual().getTicket().getNumeroAleatorio()
                        + "\n\n"
                        + "Localidad: "
                        + localidad.getNombreLocalidad()
                        + "\n"
                        + "Boletos solicitados: "
                        + sistemaVentas.getCompradorActual().getCantidadBoletos()
                        + "\n"
                        + "Boletos vendidos: "
                        + vendidos
                        + "\n"
                        + "Precio por boleto: $"
                        + localidad.getPrecio()
                        + "\n"
                        + "Total pagado: $"
                        + total
                        + "\n\n"
                        + " Solo fue posible vender "
                        + vendidos
                        + " boletos\n porque eran los últimos disponibles "
                        + "o\n porque el presupuesto no alcanzaba para más.\n\n"
                        + "¡Gracias por su compra ;)!\n"
                        + "=========================================";

            } else {

                mensaje =
                        "\n=========================================\n"
                        + "Compra realizada exitosamente.\n\n"
                        + "Ticket: "
                        + sistemaVentas.getCompradorActual().getTicket().getNumeroAleatorio()
                        + "\n\n"
                        + "Localidad: "
                        + localidad.getNombreLocalidad()
                        + "\n"
                        + "Boletos comprados: "
                        + vendidos
                        + "\n"
                        + "Precio por boleto: $"
                        + localidad.getPrecio()
                        + "\n"
                        + "Total pagado: $"
                        + total
                        + "\n\n"
                        + "¡Gracias por su compra! Esperamos que disfrute el evento :).\n"
                        + "=========================================";

            }

            vista.mostrarMensaje(mensaje);
    }

    private void consultarDisponibilidadTotal() {
        vista.mostrarDisponibilidad(
                sistemaVentas.consultarDisponibilidadTotal()
        );
    }

    private void consultarDisponibilidadLocalidad() {
        String localidad = vista.leerNombreLocalidad();
        vista.mostrarDisponibilidad(
                sistemaVentas.consultarDisponibilidadLocalidad(localidad)
        );
    }

    private void mostrarReporteCaja() {
        vista.mostrarReporteCaja(
                sistemaVentas.generarReporteCaja()
        );
    }
}