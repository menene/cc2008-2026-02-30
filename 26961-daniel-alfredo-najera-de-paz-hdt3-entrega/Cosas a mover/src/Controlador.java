import java.util.List;

public class Controlador {

    // Modelo y vista
    private Taller taller;
    private Vista vista;

    // Constructor
    public Controlador(Taller taller, Vista vista) {
        this.taller = taller;
        this.vista = vista;
    }

    // Ciclo principal del programa
    public void iniciar() {
        int opcion;

        do {
            vista.mostrarMenu();
            opcion = vista.leerEntero("Seleccione una opción: ");

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
                    vista.mostrarMensaje("Opción inválida.");
            }

        } while (opcion != 10);
    }

    // Registro de una nueva orden
    private void registrarOrden() {
        int numeroOrden = vista.leerEntero("Número de orden: ");

        if (taller.buscarOrden(numeroOrden) != null) {
            vista.mostrarMensaje("Error: el número de orden ya está registrado.");
            return;
        }

        String propietario = vista.leerTexto("Nombre del propietario: ");
        String placa = vista.leerTexto("Placa del vehículo: ");
        String descripcion = vista.leerTexto("Descripción del servicio: ");
        double costo = vista.leerDouble("Costo estimado: Q");

        if (propietario.trim().isEmpty()
                || placa.trim().isEmpty()
                || descripcion.trim().isEmpty()) {
            vista.mostrarMensaje("Error: los campos de texto no pueden estar vacíos.");
            return;
        }

        if (costo <= 0) {
            vista.mostrarMensaje("Error: el costo debe ser mayor que 0.");
            return;
        }

        OrdenServicio orden = new OrdenServicio(
                numeroOrden,
                propietario,
                placa,
                descripcion,
                costo
        );

        taller.registrarOrden(orden);
        vista.mostrarMensaje("Orden registrada correctamente.");
    }

    // Consulta de todas las órdenes
    private void consultarOrdenes() {
        vista.mostrarOrdenes(taller.obtenerOrdenes());
    }

    // Búsqueda de una orden
    private void buscarOrden() {
        int numeroOrden = vista.leerEntero("Número de orden: ");

        try {
            OrdenServicio orden = taller.buscarOrden(numeroOrden);

            if (orden == null) {
                throw new IllegalArgumentException(
                        "La orden indicada no se encuentra registrada."
                );
            }

            vista.mostrarOrden(orden);

        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());

        } finally {
            vista.mostrarMensaje("Búsqueda finalizada.");
        }
    }

    // Modificación de una orden
    private void modificarOrden() {
        int numeroOrden = vista.leerEntero("Número de orden a modificar: ");

        try {
            OrdenServicio orden = taller.buscarOrden(numeroOrden);

            if (orden == null) {
                throw new IllegalArgumentException(
                        "La orden indicada no se encuentra registrada."
                );
            }

            String descripcion =
                    vista.leerTexto("Nueva descripción del servicio: ");

            double costo =
                    vista.leerDouble("Nuevo costo estimado: Q");

            if (descripcion.trim().isEmpty()) {
                vista.mostrarMensaje(
                        "Error: la descripción no puede estar vacía."
                );
                return;
            }

            if (costo <= 0) {
                vista.mostrarMensaje(
                        "Error: el costo debe ser mayor que 0."
                );
                return;
            }

            taller.modificarOrden(numeroOrden, descripcion, costo);

            vista.mostrarMensaje("Orden modificada correctamente.");

        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        }
    }

    // Cancelación de una orden
    private void cancelarOrden() {
        int numeroOrden = vista.leerEntero("Número de orden a cancelar: ");

        try {
            OrdenServicio orden = taller.buscarOrden(numeroOrden);

            if (orden == null) {
                throw new IllegalArgumentException(
                        "La orden indicada no se encuentra registrada."
                );
            }

            taller.cancelarOrden(numeroOrden);
            vista.mostrarMensaje("Orden cancelada correctamente.");

        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        }
    }

    // Consulta de órdenes por placa
    private void consultarPorPlaca() {
        String placa = vista.leerTexto("Placa del vehículo: ");

        List<OrdenServicio> ordenes =
                taller.buscarOrdenesPorPlaca(placa);

        if (ordenes.isEmpty()) {
            vista.mostrarMensaje(
                    "No se encontraron órdenes asociadas a esa placa."
            );
            return;
        }

        vista.mostrarOrdenes(ordenes);
    }

    // Reporte de costos
    private void mostrarReporteCostos() {
        double total = taller.calcularCostoTotal();
        double promedio = taller.calcularCostoPromedio();

        vista.mostrarMensaje("Costo total: Q" + total);
        vista.mostrarMensaje("Costo promedio: Q" + promedio);
    }

    // Orden con mayor costo
    private void mostrarOrdenMayorCosto() {
        OrdenServicio orden = taller.obtenerOrdenMayorCosto();

        if (orden == null) {
            vista.mostrarMensaje("No hay órdenes registradas.");
            return;
        }

        vista.mostrarOrden(orden);
    }

    // Cantidad actual de órdenes
    private void mostrarCantidadOrdenes() {
        int cantidad = taller.obtenerCantidadOrdenes();

        vista.mostrarMensaje(
                "Cantidad de órdenes registradas: " + cantidad
        );
    }
}