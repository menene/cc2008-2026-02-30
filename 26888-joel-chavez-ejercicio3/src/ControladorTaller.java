import java.util.List;
import java.util.NoSuchElementException;

public class ControladorTaller {
    private GestorOrdenes gestor;
    private VistaTaller vista;

    public ControladorTaller() {
        gestor = new GestorOrdenes();
        vista = new VistaTaller();
    }

    public void iniciar() {
        boolean continuar = true;
        while (continuar) {
            vista.mostrarMenu();
            try {
                int opcion = vista.leerEntero(
                        "Seleccione una opción: ");

                continuar = procesarOpcion(opcion);
            } catch (NumberFormatException e) {
                vista.mostrarError(
                        "Debe ingresar un número entero "
                        + "para seleccionar una opción.");
            }
        }

        vista.cerrarScanner();
        vista.mostrarMensaje("Programa finalizado. Muchas gracias por utilizarlo y esperamos que vuelva pronto :).");
    }

    private boolean procesarOpcion(int opcion) {
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

            case 0:
                return false;

            default:
                vista.mostrarError(
                        "La opción seleccionada no existe.");
        }

        return true;
    }

    private void registrarOrden() {
        try {
            int numero = vista.leerEntero(
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
                    numero,
                    propietario,
                    placa,
                    descripcion,
                    costo);
            gestor.registrarOrden(orden);
            vista.mostrarMensaje(
                    "Orden registrada correctamente.");
        } catch (NumberFormatException e) {
            vista.mostrarError(
                    "El número de orden y el costo "
                    + "deben ser valores numéricos.");

        } catch (IllegalArgumentException e) {
            vista.mostrarError(e.getMessage());
        }
    }

    private void consultarOrdenes() {
        vista.mostrarOrdenes(gestor.obtenerOrdenes());
    }

    private void buscarOrden() {
        try {
            int numero = vista.leerEntero(
                    "Número de orden que desea buscar: ");
            OrdenServicio orden =
                    gestor.buscarOrden(numero);
            vista.mostrarOrden(orden);
        } catch (NumberFormatException e) {
            vista.mostrarError(
                    "El número de orden debe ser "
                    + "un valor entero.");

        } catch (NoSuchElementException e) {
            vista.mostrarError(e.getMessage());

        } finally {
            vista.mostrarMensaje(
                    "Proceso de búsqueda finalizado.");
        }
    }

    private void modificarOrden() {
        try {
            int numero = vista.leerEntero(
                    "Número de orden que desea modificar: ");

            String descripcion = vista.leerTexto(
                    "Nueva descripción del servicio: ");

            double costo = vista.leerDouble(
                    "Nuevo costo estimado: Q");

            gestor.modificarOrden(
                    numero,
                    descripcion,
                    costo);

            vista.mostrarMensaje(
                    "Orden modificada correctamente.");

        } catch (NumberFormatException e) {
            vista.mostrarError(
                    "El número de orden y el costo "
                    + "deben ser valores numéricos.");

        } catch (IllegalArgumentException
                | NoSuchElementException e) {

            vista.mostrarError(e.getMessage());
        }
    }

    private void cancelarOrden() {
        try {
            int numero = vista.leerEntero(
                    "Número de orden que desea cancelar: ");

            gestor.cancelarOrden(numero);

            vista.mostrarMensaje(
                    "Orden cancelada correctamente.");

        } catch (NumberFormatException e) {
            vista.mostrarError(
                    "El número de orden debe ser "
                    + "un valor entero.");

        } catch (NoSuchElementException e) {
            vista.mostrarError(e.getMessage());
        }
    }

    private void consultarPorPlaca() {
        String placa = vista.leerTexto(
                "Placa del vehículo: ");

        List<OrdenServicio> coincidencias =
                gestor.buscarPorPlaca(placa);

        vista.mostrarOrdenes(coincidencias);
    }

    private void mostrarReporteCostos() {
        double total = gestor.calcularCostoTotal();
        double promedio =
                gestor.calcularCostoPromedio();

        vista.mostrarMensaje(
                String.format(
                        "Costo total: Q%.2f", total));

        vista.mostrarMensaje(
                String.format(
                        "Costo promedio: Q%.2f", promedio));
    }

    private void mostrarOrdenMayorCosto() {
        try {
            OrdenServicio orden =
                    gestor.obtenerOrdenMayorCosto();

            vista.mostrarMensaje(
                    "Orden con el costo estimado más alto:");

            vista.mostrarOrden(orden);

        } catch (NoSuchElementException e) {
            vista.mostrarError(e.getMessage());
        }
    }

    private void mostrarCantidadOrdenes() {
        int cantidad =
                gestor.obtenerCantidadOrdenes();

        vista.mostrarMensaje(
                "Cantidad de órdenes registradas: "
                + cantidad);
    }
}