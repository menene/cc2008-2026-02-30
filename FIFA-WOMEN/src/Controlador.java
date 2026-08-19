public class Controlador {
    private SistemaBoletos sistema;
    private Vista vista;


    public Controlador(SistemaBoletos sistema, Vista vista) {
        this.sistema = sistema;
        this.vista = vista;
    }


    public void iniciar() {
        boolean salir = false;
       
        while (!salir) {
            vista.mostrarMenu();
            int opcion = vista.leerOpcionMenu(); 
           
            if (opcion == 6) {
                salir = true;
                vista.mostrarMensaje("Saliendo del sistema. ¡Gracias!");
            } else {
                procesarOpcion(opcion);
            }
        }
    }

    public void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                Comprador nuevoComprador = vista.leerComprador();
                sistema.crearComprador(nuevoComprador);
                break;
            case 2:
                vista.mostrarMensaje("\n--- PROCESANDO COMPRA ---");
                sistema.solicitarCompra();
                break;
            case 3:
                sistema.consultarDisponibilidad();
                break;
            case 4:
                int localidadDeseada = vista.leerLocalidad();
                sistema.consultarLocalidad(localidadDeseada);
                break;
            case 5:
                double caja = sistema.reporteCaja();
                vista.mostrarMensaje("\n--- REPORTE DE CAJA ---");
                vista.mostrarMensaje("Total recaudado: $" + caja);
                break;
            default:
                vista.mostrarMensaje("Opción inválida. Intente de nuevo.");
        }
    }
}
