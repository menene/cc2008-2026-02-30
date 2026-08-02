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
                    vista.mostrarMensaje("Gracias por utilizar el sistema ;) Que tenga un buen día.");
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
            vista.mostrarMensaje("Primero debe registrar un comprador.");
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

        sistemaVentas.venderBoletos();
        vista.mostrarMensaje("Compra realizada exitosamente. Espero que lo disfute.");

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