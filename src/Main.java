import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {

        VistaOrdenes vista = new VistaOrdenes();
        ControladorOrdenes controlador = new ControladorOrdenes();

        int opcion;

        do {

            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();

            switch (opcion) {

                case 1:
                    try {
                        OrdenServicio orden = vista.solicitarOrden();

                        boolean registrada = controlador.registrarOrden(orden);

                        if (registrada) {
                            vista.mostrarMensaje("Orden registrada correctamente.");
                        } else {
                            vista.mostrarMensaje(
                                "No se pudo registrar la orden. Revise los datos o el numero de orden."
                            );
                        }

                        } catch (InputMismatchException e) {
                            vista.mostrarMensaje(
                                "Error: debe ingresar valores numericos correctamente."
                            );
                        }

                break;

                case 2:
                    vista.mostrarOrdenes(
                    controlador.obtenerOrdenes()
                    );

                    break;

                case 3:
                    try {

                        int numeroBuscar = vista.solicitarNumeroOrden();

                        OrdenServicio ordenEncontrada =
                                controlador.buscarOrden(numeroBuscar);

                        if (ordenEncontrada == null) {
                            throw new Exception("La orden no existe.");
                        }

                        vista.mostrarOrden(ordenEncontrada);

                    } catch (Exception e) {

                        vista.mostrarMensaje("Error: " + e.getMessage());

                    } finally {

                        vista.mostrarMensaje("Proceso de busqueda finalizado.");
                    }

                    break;

                case 4:
                    try {
                        int numeroModificar = vista.solicitarNumeroOrden();

                        String nuevaDescripcion = vista.solicitarDescripcion();

                        double nuevoCosto = vista.solicitarCosto();

                        boolean modificada = controlador.modificarOrden(
                                numeroModificar,
                                nuevaDescripcion,
                                nuevoCosto
                        );

                        if (modificada) {
                            vista.mostrarMensaje("Orden modificada correctamente.");
                        } else {
                            vista.mostrarMensaje(
                                    "No se pudo modificar la orden. Revise el numero de orden y los datos."
                            );
                        }

                    } catch (InputMismatchException e) {
                        vista.mostrarMensaje(
                                "Error: debe ingresar valores numericos correctamente."
                        );
                    }
                    break;

                case 5:
                    try {
                        int numeroCancelar = vista.solicitarNumeroOrden();

                        boolean cancelada =
                                controlador.cancelarOrden(numeroCancelar);

                        if (cancelada) {
                            vista.mostrarMensaje("Orden cancelada correctamente.");
                        } else {
                            vista.mostrarMensaje("La orden no existe.");
                        }

                    } catch (InputMismatchException e) {
                        vista.mostrarMensaje(
                                "Error: debe ingresar un numero de orden valido."
                        );
                    }
                    break;

                case 6:

                    String placa = vista.solicitarPlaca();

                    vista.mostrarOrdenes(
                            controlador.buscarPorPlaca(placa)
                    );

                    break;

                case 7:

                    double total = controlador.calcularCostoTotal();
                    double promedio = controlador.calcularCostoPromedio();

                    vista.mostrarReporteCostos(total, promedio);

                    break;

                case 8:
                    OrdenServicio ordenMayor =
                    controlador.obtenerOrdenMayorCosto();

                    if (ordenMayor != null) {
                        vista.mostrarOrden(ordenMayor);
                    } else {
                        vista.mostrarMensaje("No hay ordenes registradas.");
                    }

                    break;

                case 9:
                    int cantidad = controlador.cantidadOrdenes();
                    vista.mostrarCantidadOrdenes(cantidad);

                    break;

                case 10:
                    vista.mostrarMensaje("Saliendo del programa...");
                    break;

                default:
                    vista.mostrarMensaje("Opcion invalida.");
            }

        } while (opcion != 10);
    }
}