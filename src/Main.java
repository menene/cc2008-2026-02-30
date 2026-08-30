import java.util.List;

public class Main {
    public static void main(String[] args) {
        VistaTaller vista = new VistaTaller();
        ControladorOrdenes controlador = new ControladorOrdenes();
        int opcion = 0;

        while (opcion != 10) {
            try {
                opcion = vista.mostrarMenu();

                switch (opcion) {
                    case 1:
                        int numeroOrden = vista.leerEntero(
                                "Ingrese el numero de orden: ");

                        String nombrePropietario = vista.leerTexto(
                                "Ingrese el nombre del propietario: ");

                        String placaVehiculo = vista.leerTexto(
                                "Ingrese la placa del vehiculo: ");

                        String descripcionServicio = vista.leerTexto(
                                "Ingrese la descripcion del servicio: ");

                        double costoEstimado = vista.leerDecimal(
                                "Ingrese el costo estimado: ");

                        OrdenServicio nuevaOrden = new OrdenServicio(
                                numeroOrden,
                                nombrePropietario,
                                placaVehiculo,
                                descripcionServicio,
                                costoEstimado);

                        controlador.registrarOrden(nuevaOrden);

                        vista.mostrarMensaje(
                                "La orden fue registrada correctamente.");
                        break;

                    case 2:
                        vista.mostrarOrdenes(
                                controlador.obtenerOrdenes());
                        break;

                    case 3:
                        try {
                            int numeroBuscado = vista.leerEntero(
                                    "Ingrese el numero de orden: ");

                            OrdenServicio ordenEncontrada =
                                    controlador.buscarOrden(numeroBuscado);

                            vista.mostrarOrden(ordenEncontrada);

                        } catch (NumberFormatException e) {
                            vista.mostrarMensaje(
                                    "Debe ingresar un numero valido.");

                        } catch (Exception e) {
                            vista.mostrarMensaje(e.getMessage());

                        } finally {
                            vista.mostrarMensaje(
                                    "Operacion de busqueda finalizada.");
                        }
                        break;

                    case 4:
                        int numeroModificar = vista.leerEntero(
                                "Ingrese el numero de la orden a modificar: ");

                        String nuevaDescripcion = vista.leerTexto(
                                "Ingrese la nueva descripcion: ");

                        double nuevoCosto = vista.leerDecimal(
                                "Ingrese el nuevo costo estimado: ");

                        controlador.modificarOrden(
                                numeroModificar,
                                nuevaDescripcion,
                                nuevoCosto);

                        vista.mostrarMensaje(
                                "La orden fue modificada correctamente.");
                        break;

                    case 5:
                        int numeroCancelar = vista.leerEntero(
                                "Ingrese el numero de la orden a cancelar: ");

                        controlador.cancelarOrden(numeroCancelar);

                        vista.mostrarMensaje(
                                "La orden fue cancelada correctamente.");
                        break;

                    case 6:
                        String placaBuscada = vista.leerTexto(
                                "Ingrese la placa que desea buscar: ");

                        List<OrdenServicio> coincidencias =
                                controlador.buscarOrdenesPorPlaca(
                                        placaBuscada);

                        vista.mostrarOrdenes(coincidencias);
                        break;

                    case 7:
                        double total =
                                controlador.calcularCostoTotal();

                        double promedio =
                                controlador.calcularCostoPromedio();

                        vista.mostrarReporteCostos(total, promedio);
                        break;

                    case 8:
                        OrdenServicio ordenMayor =
                                controlador.obtenerOrdenMayorCosto();

                        if (ordenMayor == null) {
                            vista.mostrarMensaje(
                                    "No hay ordenes registradas.");
                        } else {
                            vista.mostrarOrden(ordenMayor);
                        }
                        break;

                    case 9:
                        int cantidad =
                                controlador.obtenerCantidadOrdenes();

                        vista.mostrarMensaje(
                                "Cantidad de ordenes: " + cantidad);
                        break;

                    case 10:
                        vista.mostrarMensaje("Programa finalizado.");
                        break;

                    default:
                        vista.mostrarMensaje(
                                "La opcion seleccionada no es valida.");
                        break;
                }

            } catch (NumberFormatException e) {
                vista.mostrarMensaje(
                        "Debe ingresar un numero valido.");

            } catch (IllegalArgumentException e) {
                vista.mostrarMensaje(e.getMessage());

            } catch (Exception e) {
                vista.mostrarMensaje(e.getMessage());
            }
        }

        vista.cerrarLector();
    }
}