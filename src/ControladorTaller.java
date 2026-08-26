import java.util.List;

public class ControladorTaller {

    private ServicioOrdenes servicio;
    private VistaTaller vista;
    private boolean ejecutando;

    public ControladorTaller(
            ServicioOrdenes servicio,
            VistaTaller vista) {

        if (servicio == null || vista == null) {
            throw new IllegalArgumentException(
                    "El servicio y la vista "
                            + "son obligatorios.");
        }

        this.servicio = servicio;
        this.vista = vista;
        this.ejecutando = false;
    }

    public void iniciar() {
        ejecutando = true;

        try {
            while (ejecutando) {
                try {
                    vista.mostrarMenu();

                    int opcion = vista.leerEntero(
                            "Seleccione una opción: ");

                    procesarOpcion(opcion);

                } catch (NumberFormatException e) {
                    vista.mostrarError(
                            "Debe ingresar un número válido.");

                } catch (IllegalArgumentException e) {
                    vista.mostrarError(
                            e.getMessage());
                }
            }

        } catch (Exception e) {
            vista.mostrarError(
                    "Ocurrió un error inesperado: "
                            + e.getMessage());

        } finally {
            vista.cerrar();

            System.out.println(
                    "El sistema del taller ha finalizado.");
        }
    }

    private void procesarOpcion(int opcion) {
        try {
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
                    finalizarPrograma();
                    break;

                default:
                    vista.mostrarError(
                            "La opción seleccionada no existe.");
            }

        } catch (OrdenDuplicadaException
                | OrdenNoEncontradaException e) {

            vista.mostrarError(e.getMessage());
        }
    }

    private void registrarOrden()
            throws OrdenDuplicadaException {

        vista.mostrarMensaje("REGISTRO DE ORDEN");

        int numeroOrden = vista.leerEntero(
                "Número de orden: ");

        String propietario = vista.leerTexto(
                "Nombre del propietario: ");

        String placa = vista.leerTexto(
                "Placa del vehículo: ");

        String descripcion = vista.leerTexto(
                "Descripción del servicio: ");

        double costo = vista.leerDouble(
                "Costo estimado: Q");

        OrdenServicio orden = new OrdenServicio(
                numeroOrden,
                propietario,
                placa,
                descripcion,
                costo);

        servicio.registrarOrden(orden);

        vista.mostrarMensaje(
                "La orden fue registrada correctamente.");
    }

    private void consultarOrdenes() {
        List<OrdenServicio> ordenes = servicio.listarOrdenes();

        vista.mostrarOrdenes(ordenes);
    }

    private void buscarOrden()
            throws OrdenNoEncontradaException {

        int numeroOrden = vista.leerEntero(
                "Número de orden que desea buscar: ");

        OrdenServicio orden = servicio.buscarOrden(numeroOrden);

        vista.mostrarOrden(orden);
    }

    private void modificarOrden()
            throws OrdenNoEncontradaException {

        int numeroOrden = vista.leerEntero(
                "Número de orden que desea modificar: ");

        OrdenServicio orden = servicio.buscarOrden(numeroOrden);

        vista.mostrarMensaje("Orden encontrada:");
        vista.mostrarOrden(orden);

        String nuevaDescripcion = vista.leerTexto(
                "Nueva descripción del servicio: ");

        double nuevoCosto = vista.leerDouble(
                "Nuevo costo estimado: Q");

        servicio.modificarOrden(
                numeroOrden,
                nuevaDescripcion,
                nuevoCosto);

        vista.mostrarMensaje(
                "La orden fue modificada correctamente.");
    }

    private void cancelarOrden()
            throws OrdenNoEncontradaException {

        int numeroOrden = vista.leerEntero(
                "Número de orden que desea cancelar: ");

        servicio.cancelarOrden(numeroOrden);

        vista.mostrarMensaje(
                "La orden fue cancelada correctamente.");
    }

    private void consultarPorPlaca() {
        String placa = vista.leerTexto(
                "Placa que desea consultar: ");

        List<OrdenServicio> ordenes = servicio.buscarOrdenesPorPlaca(placa);

        if (ordenes.isEmpty()) {
            vista.mostrarMensaje(
                    "No se encontraron órdenes para la placa "
                            + placa.toUpperCase() + ".");
        } else {
            vista.mostrarOrdenes(ordenes);
        }
    }

    private void mostrarReporteCostos() {
        double total = servicio.calcularCostoTotal();

        double promedio = servicio.calcularCostoPromedio();

        vista.mostrarReporteCostos(
                total,
                promedio);
    }

    private void mostrarOrdenMayorCosto() {
        OrdenServicio ordenMayor = servicio.obtenerOrdenMayorCosto();

        if (ordenMayor == null) {
            vista.mostrarMensaje(
                    "No existen órdenes registradas.");
        } else {
            vista.mostrarMensaje(
                    "ORDEN CON MAYOR COSTO");

            vista.mostrarOrden(ordenMayor);
        }
    }

    private void mostrarCantidadOrdenes() {
        int cantidad = servicio.obtenerCantidadOrdenes();

        vista.mostrarMensaje(
                "Cantidad de órdenes activas: "
                        + cantidad);
    }

    private void finalizarPrograma() {
        ejecutando = false;

        vista.mostrarMensaje(
                "Saliendo del sistema...");
    }
}
