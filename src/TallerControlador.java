public class TallerControlador {

    private GestorOrdenes gestor;
    private TallerVista vista;

    public TallerControlador(GestorOrdenes gestor, TallerVista vista) {
        this.gestor = gestor;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion = 0;

        do {
            try {
                vista.mostrarMenu();
                opcion = vista.solicitarEntero("Seleccione una opción: ");

                switch (opcion) {
                    case 1:
                        registrarOrden();
                        break;
                    case 2:
                        consultarOrdenes();
                        break;
                    case 3:
                        buscarOrden();
                        break;
                    case 4:
                        modificarOrden();
                        break;
                    case 5:
                        cancelarOrden();
                        break;
                    case 6:
                        consultarPorPlaca();
                        break;
                    case 7:
                        mostrarReporteCostos();
                        break;
                    case 8:
                        mostrarOrdenMayorCosto();
                        break;
                    case 9:
                        mostrarCantidadOrdenes();
                        break;
                    case 10:
                        vista.mostrarMensaje("Programa finalizado.");
                        break;
                    default:
                        vista.mostrarMensaje("Opción no válida.");
                }

            } catch (NumberFormatException e) {
                vista.mostrarMensaje("Error: debe ingresar un valor numérico válido.");
            } catch (IllegalArgumentException e) {
                vista.mostrarMensaje("Error: " + e.getMessage());
            }

        } while (opcion != 10);
    }


    private void registrarOrden() {
        int numeroOrden = vista.solicitarEntero("Número de orden: ");
        String propietario = vista.solicitarDato("Nombre del propietario: ");
        String placa = vista.solicitarDato("Placa del vehículo: ");
        String descripcion = vista.solicitarDato("Descripción del servicio: ");
        double costo = vista.solicitarDouble("Costo estimado: ");

        OrdenServicio orden = new OrdenServicio(
                numeroOrden,
                propietario,
                placa,
                descripcion,
                costo
        );

        gestor.agregarOrden(orden);

        vista.mostrarMensaje("Orden registrada correctamente.");
    }

    private void consultarOrdenes() {
        vista.mostrarOrdenes(gestor.obtenerOrdenes());
    }


    private void buscarOrden() {
        try {
            int numeroOrden = vista.solicitarEntero("Número de orden a buscar: ");

            OrdenServicio orden = gestor.buscarOrden(numeroOrden);

            if (orden == null) {
                throw new IllegalArgumentException("La orden no se encuentra registrada.");
            }

            vista.mostrarOrden(orden);

        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());

        } finally {
            vista.mostrarMensaje("Proceso de búsqueda finalizado.");
        }
    }


    private void modificarOrden() {
        int numeroOrden = vista.solicitarEntero("Número de orden a modificar: ");
        String descripcion = vista.solicitarDato("Nueva descripción del servicio: ");
        double costo = vista.solicitarDouble("Nuevo costo estimado: ");

        gestor.modificarOrden(numeroOrden, descripcion, costo);

        vista.mostrarMensaje("Orden modificada correctamente.");
    }


    private void cancelarOrden() {
        int numeroOrden = vista.solicitarEntero("Número de orden a cancelar: ");

        gestor.cancelarOrden(numeroOrden);

        vista.mostrarMensaje("Orden cancelada correctamente.");
    }


    private void consultarPorPlaca() {
        String placa = vista.solicitarDato("Placa del vehículo: ");

        vista.mostrarOrdenes(gestor.buscarPorPlaca(placa));
    }


    private void mostrarReporteCostos() {
        double total = gestor.calcularTotal();
        double promedio = gestor.calcularPromedio();

        vista.mostrarMensaje("Valor total de las órdenes: Q" + total);
        vista.mostrarMensaje("Costo promedio de las órdenes: Q" + promedio);
    }


    private void mostrarOrdenMayorCosto() {
        OrdenServicio orden = gestor.obtenerOrdenMayorCosto();

        if (orden == null) {
            vista.mostrarMensaje("No hay órdenes registradas.");
            return;
        }

        vista.mostrarMensaje("Orden con el costo estimado más alto:");
        vista.mostrarOrden(orden);
    }


    private void mostrarCantidadOrdenes() {
        int cantidad = gestor.cantidadOrdenes();

        vista.mostrarMensaje("Cantidad de órdenes registradas: " + cantidad);
    }

}