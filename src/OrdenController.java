import java.util.List;
import java.util.NoSuchElementException;

public class OrdenController {
    private GestionOrdenes gestionOrdenes;
    private OrdenView vista;

    public OrdenController(GestionOrdenes gestionOrdenes, OrdenView vista) {
        this.gestionOrdenes = gestionOrdenes;
        this.vista = vista;
    }

    public void iniciar() {
        boolean continuar = true;

        while (continuar) {
            vista.mostrarMenu();

            try {
                int opcion = Integer.parseInt(vista.solicitarDato("Seleccione una opción: "));

                if (opcion == 1) {
                    registrarOrden();
                } else if (opcion == 2) {
                    consultarOrdenes();
                } else if (opcion == 3) {
                    buscarOrden();
                } else if (opcion == 4) {
                    modificarOrden();
                } else if (opcion == 5) {
                    cancelarOrden();
                } else if (opcion == 6) {
                    consultarOrdenesPorPlaca();
                } else if (opcion == 7) {
                    mostrarReporteCostos();
                } else if (opcion == 8) {
                    mostrarOrdenMayorCosto();
                } else if (opcion == 9) {
                    mostrarCantidadOrdenes();
                } else if (opcion == 10) {
                    continuar = false;
                    vista.mostrarMensaje("Programa finalizado.");
                } else {
                    vista.mostrarMensaje("La opción seleccionada no es válida.");
                }

            } catch (NumberFormatException e) {
                vista.mostrarMensaje("Error: debe ingresar un valor numérico válido.");
            } catch (IllegalArgumentException e) {
                vista.mostrarMensaje("Error: " + e.getMessage());
            } catch (NoSuchElementException e) {
                vista.mostrarMensaje("Error: " + e.getMessage());
            }
        }
    }

    private void registrarOrden() {
        int numeroOrden = Integer.parseInt(vista.solicitarDato("Número de orden: "));
        String nombrePropietario = vista.solicitarDato("Nombre del propietario: ");
        String placa = vista.solicitarDato("Placa del vehículo: ");
        String descripcionServicio = vista.solicitarDato("Descripción del servicio: ");
        double costoEstimado = Double.parseDouble(vista.solicitarDato("Costo estimado: "));

        Orden orden = new Orden(numeroOrden, nombrePropietario, placa, descripcionServicio, costoEstimado);
        gestionOrdenes.registrarOrden(orden);
        vista.mostrarMensaje("Orden registrada correctamente.");
    }

    private void consultarOrdenes() {
        vista.mostrarOrdenes(gestionOrdenes.obtenerOrdenes());
    }

    private void buscarOrden() {
        try {
            int numeroOrden = Integer.parseInt(vista.solicitarDato("Número de orden: "));
            Orden orden = gestionOrdenes.buscarPorNumero(numeroOrden);
            vista.mostrarOrden(orden);
        } finally {
            vista.mostrarMensaje("Proceso de búsqueda finalizado. Regresando al menú principal.");
        }
    }

    private void modificarOrden() {
        int numeroOrden = Integer.parseInt(vista.solicitarDato("Número de orden que desea modificar: "));
        String nuevaDescripcion = vista.solicitarDato("Nueva descripción del servicio: ");
        double nuevoCosto = Double.parseDouble(vista.solicitarDato("Nuevo costo estimado: "));

        gestionOrdenes.modificarOrden(numeroOrden, nuevaDescripcion, nuevoCosto);
        vista.mostrarMensaje("Orden modificada correctamente.");
    }

    private void cancelarOrden() {
        int numeroOrden = Integer.parseInt(vista.solicitarDato("Número de orden que desea cancelar: "));
        gestionOrdenes.cancelarOrden(numeroOrden);
        vista.mostrarMensaje("Orden cancelada correctamente.");
    }

    private void consultarOrdenesPorPlaca() {
        String placa = vista.solicitarDato("Placa del vehículo: ");
        List<Orden> coincidencias = gestionOrdenes.buscarPorPlaca(placa);
        vista.mostrarOrdenes(coincidencias);
    }

    private void mostrarReporteCostos() {
        double total = gestionOrdenes.calcularCostoTotal();
        double promedio = gestionOrdenes.calcularCostoPromedio();
        vista.mostrarReporteCostos(total, promedio);
    }

    private void mostrarOrdenMayorCosto() {
        Orden ordenMayor = gestionOrdenes.obtenerOrdenMayorCosto();
        vista.mostrarOrden(ordenMayor);
    }

    private void mostrarCantidadOrdenes() {
        int cantidad = gestionOrdenes.obtenerCantidadOrdenes();
        vista.mostrarMensaje("Cantidad de órdenes registradas: " + cantidad);
    }
}