public class ControladorWC {

    private Comprador compradorActual;
    private Vista vista;
    private Venta venta;

    public ControladorWC() {

        vista = new Vista();
        venta = new Venta();

    }

    public void iniciar() {

        int opcion;

        do {

            opcion = vista.mostrarMenu();

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
                    consultarDisponibilidadIndividual();
                    break;

                case 5:
                    reporteCaja();
                    break;

                case 6:
                    vista.mostrarMensaje("Gracias por usar el sistema.");
                    break;

                default:
                    vista.mostrarMensaje("Opción inválida.");

            }

        } while (opcion != 6);

    }

    public void nuevoComprador() {

        compradorActual = vista.crearComprador();

    }

    public void nuevaSolicitud() {

        if (compradorActual == null) {

            vista.mostrarMensaje("Primero debe registrar un comprador.");
            return;

        }

        String factura = venta.realizarVenta(compradorActual);

        vista.mostrarFactura(factura);

    }

    public void consultarDisponibilidadTotal() {

        venta.mostrarDisponibilidadTotal();

    }

    public void consultarDisponibilidadIndividual() {

        int localidad = vista.pedirLocalidad();

        venta.mostrarDisponibilidad(localidad);

    }

    public void reporteCaja() {

        venta.mostrarReporteCaja();

    }

}