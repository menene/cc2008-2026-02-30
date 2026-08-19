public class Controlador {
    private SistemaVentas sistema;
    private Vista vista = new Vista();
    private Comprador compradorActual;

    public void iniciar() {
        sistema = new SistemaVentas();

        boolean continuar = true;

        while (continuar) {
            int opcion = vista.mostrarMenu();

            if (opcion == 1) {
                nuevoComprador();
            }
            else if (opcion == 2) {
                nuevaSolicitud();
            }
            else if (opcion == 3) {
                disponibilidadTotal();
            }
            else if (opcion == 4) {
                disponibilidadIndividual();
            }
            else if (opcion == 5) {
                reporteRecaudacion();
            }
            else if (opcion == 6) {
                continuar = false;
            }
            else {
                System.out.println("\nOpción inválida.");
            }
        }
    }

    private void nuevoComprador() {
        compradorActual = vista.leerComprador();
    }

    private void nuevaSolicitud() {

        if (compradorActual == null) {
            System.out.println("\nPrimero registre un comprador.");
            return;
        }

        String proceso = sistema.procesarCompra(compradorActual);
        vista.mostrarMensaje(proceso);
    }

    private void disponibilidadTotal() {
        System.out.println("\nLa disponibilidad total es de: " + sistema.disponibilidadTotal());
    }

    private void disponibilidadIndividual() {
        int numero = vista.leerLocalidad();
        System.out.println("\nLa disponibilidad individual es de: " + sistema.disponibilidadIndividual(numero));
    }

    private void reporteRecaudacion() {
        System.out.println("\nRecaudación total: Q" + sistema.reporteRecaudacion());
    }
}