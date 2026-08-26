import java.util.List;

public class ControladorTaller {
    private final GestorOrdenes modelo;
    private final VistaTaller vista;

    public ControladorTaller(GestorOrdenes modelo, VistaTaller vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion;

        do {
            vista.mostrarMenu();
            opcion = vista.leerOpcion();

            switch (opcion) {
                case 1:
                    listarOrdenes();
                    break;
                case 2:
                    crearOrden();
                    break;
                case 3:
                    actualizarOrden();
                    break;
                case 4:
                    eliminarOrden();
                    break;
                case 5:
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 5);
    }

    private void listarOrdenes() {
        List<OrdenServicio> ordenes = modelo.getOrdenes();
        vista.mostrarOrdenes(ordenes);
        vista.mostrarTotal(modelo.calcularTotal());
    }

    private void crearOrden() {
        OrdenServicio nuevaOrden = vista.pedirDatosOrden();
        modelo.agregarOrden(nuevaOrden);
        vista.mostrarMensaje("Orden creada correctamente.");
    }

    private void actualizarOrden() {
        int numeroOrden = vista.leerNumeroOrden("Ingrese el número de orden a actualizar: ");
        OrdenServicio orden = modelo.buscarOrden(numeroOrden);

        if (orden == null) {
            vista.mostrarMensaje("No se encontró una orden con ese número.");
            return;
        }

        String nuevoNombre = vista.leerTexto("Nuevo nombre del cliente: ");
        String nuevaPlaca = vista.leerTexto("Nueva placa del vehículo: ");
        String nuevaDescripcion = vista.leerTexto("Nueva descripción del servicio: ");
        double nuevoCosto = vista.leerDouble("Nuevo costo estimado: ");

        boolean actualizado = modelo.actualizarOrden(
                numeroOrden,
                nuevoNombre,
                nuevaPlaca,
                nuevaDescripcion,
                nuevoCosto
        );

        if (actualizado) {
            vista.mostrarMensaje("Orden actualizada correctamente.");
        } else {
            vista.mostrarMensaje("No se pudo actualizar la orden.");
        }
    }

    private void eliminarOrden() {
        int numeroOrden = vista.leerNumeroOrden("Ingrese el número de orden a eliminar: ");
        boolean eliminado = modelo.eliminarOrden(numeroOrden);

        if (eliminado) {
            vista.mostrarMensaje("Orden eliminada correctamente.");
        } else {
            vista.mostrarMensaje("No se encontró la orden indicada.");
        }
    }
}
