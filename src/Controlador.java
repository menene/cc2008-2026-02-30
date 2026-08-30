import java.util.List;
import java.util.NoSuchElementException;


public class Controlador {

    private GestorOrdenes gestorOrdenes;
    private Vista vista;


    public Controlador() {
        this.gestorOrdenes = new GestorOrdenes();
        this.vista = new Vista();
    }


    public void iniciar() {
        int opcion = 0;
        do {
            vista.mostrarMenu();
            opcion = vista.leerOpcion();

            switch (opcion) {
                case 1:
                    procesarRegistro();
                    break;
                case 2:
                    procesarConsulta();
                    break;
                case 3:
                    procesarBusqueda();
                    break;
                case 4:
                    procesarModificacion();
                    break;
                case 5:
                    procesarCancelacion();
                    break;
                case 6:
                    procesarConsultaPorPlaca();
                    break;
                case 7:
                    procesarReporteCostos();
                    break;
                case 8:
                    procesarOrdenMayorCosto();
                    break;
                case 9:
                    procesarCantidadOrdenes();
                    break;
                case 10:
                    vista.mostrarMensaje("Finalizando el programa...");
                    break;
                default:
                    vista.mostrarMensaje("Opcion no valida. Intente nuevamente.");
            }
        } while (opcion != 10);
    }


    private void procesarRegistro() {
        try {
            int numeroOrden = vista.leerEntero("Numero de orden: ");
            String nombrePropietario = vista.leerTexto("Nombre del propietario: ");
            String placaVehiculo = vista.leerTexto("Placa del vehiculo: ");
            String descripcionServicio = vista.leerTexto("Descripcion del servicio: ");
            double costoEstimado = vista.leerDecimal("Costo estimado: ");

            gestorOrdenes.registrarOrden(numeroOrden, nombrePropietario, placaVehiculo,
                    descripcionServicio, costoEstimado);
            vista.mostrarMensaje("Orden registrada exitosamente.");

        } catch (NumberFormatException e) {
            vista.mostrarMensaje("No se pudo registrar la orden: dato numerico invalido.");
        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje("No se pudo registrar la orden: " + e.getMessage());
        } finally {
            vista.mostrarMensaje("Proceso de registro finalizado.");
        }
    }

    private void procesarConsulta() {
        List<OrdenServicio> ordenes = gestorOrdenes.consultarOrdenes();
        vista.mostrarListaOrdenes(ordenes);
    }

 
    private void procesarBusqueda() {
        try {
            int numeroOrden = vista.leerEntero("Numero de orden a buscar: ");
            OrdenServicio orden = gestorOrdenes.buscarOrden(numeroOrden);
            vista.mostrarOrden(orden);
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("No se pudo realizar la busqueda: dato numerico invalido.");
        } catch (NoSuchElementException e) {
            vista.mostrarMensaje(e.getMessage());
        }
    }


    private void procesarModificacion() {
        try {
            int numeroOrden = vista.leerEntero("Numero de orden a modificar: ");
            String nuevaDescripcion = vista.leerTexto("Nueva descripcion del servicio: ");
            double nuevoCosto = vista.leerDecimal("Nuevo costo estimado: ");

            gestorOrdenes.modificarOrden(numeroOrden, nuevaDescripcion, nuevoCosto);
            vista.mostrarMensaje("Orden modificada exitosamente.");
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("No se pudo modificar la orden: dato numerico invalido.");
        } catch (NoSuchElementException e) {
            vista.mostrarMensaje(e.getMessage());
        }
    }


    private void procesarCancelacion() {
        try {
            int numeroOrden = vista.leerEntero("Numero de orden a cancelar: ");
            gestorOrdenes.cancelarOrden(numeroOrden);
            vista.mostrarMensaje("Orden cancelada exitosamente.");
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("No se pudo cancelar la orden: dato numerico invalido.");
        } catch (NoSuchElementException e) {
            vista.mostrarMensaje(e.getMessage());
        }
    }

 
    private void procesarConsultaPorPlaca() {
        String placa = vista.leerTexto("Placa del vehiculo: ");
        List<OrdenServicio> ordenes = gestorOrdenes.consultarPorPlaca(placa);
        vista.mostrarListaOrdenes(ordenes);
    }


    private void procesarReporteCostos() {
        double total = gestorOrdenes.calcularValorTotal();
        double promedio = gestorOrdenes.calcularCostoPromedio();
        vista.mostrarMensaje("Valor total de ordenes activas: Q" + total);
        vista.mostrarMensaje("Costo promedio de ordenes activas: Q" + promedio);
    }


    private void procesarOrdenMayorCosto() {
        try {
            OrdenServicio orden = gestorOrdenes.obtenerOrdenMayorCosto();
            vista.mostrarOrden(orden);
        } catch (NoSuchElementException e) {
            vista.mostrarMensaje(e.getMessage());
        }
    }

    private void procesarCantidadOrdenes() {
        int cantidad = gestorOrdenes.cantidadOrdenes();
        vista.mostrarMensaje("Cantidad de ordenes registradas: " + cantidad);
    }
}