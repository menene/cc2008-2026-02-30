public class ControladorBoletos {
    private SistemaBoletos sistema;
    private VistaBoletos vista;

    public ControladorBoletos() {
        sistema = new SistemaBoletos();
        vista = new VistaBoletos();
    }

    public void iniciar() {
        int opcion = 0;

        while (opcion != 6) {
            opcion = vista.mostrarMenu();

            switch (opcion) {
                case 1:
                    nuevoComprador();
                    break;

                case 2:
                    nuevaSolicitud();
                    break;

                case 3:
                    consultarTotal();
                    break;

                case 4:
                    consultarIndividual();
                    break;

                case 5:
                    mostrarCaja();
                    break;

                case 6:
                    vista.mostrarMensaje("Saliendo del programa...");
                    break;

                default:
                    vista.mostrarMensaje("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private void nuevoComprador() {
        Comprador comprador = vista.leerComprador();
        sistema.setCompradorActual(comprador);
        vista.mostrarMensaje("Comprador registrado exitosamente.");
    }

    private void nuevaSolicitud() {
        vista.mostrarMensaje(sistema.nuevaSolicitud());
    }

    private void consultarTotal() {
        vista.mostrarMensaje(sistema.disponibilidadTotal());
    }

    private void consultarIndividual() {
        int localidad = vista.leerLocalidad();
        vista.mostrarMensaje(sistema.disponibilidadIndividual(localidad));
    }

    private void mostrarCaja() {
        vista.mostrarMensaje("Total generado: $" + sistema.cajaTotal());
    }
}
