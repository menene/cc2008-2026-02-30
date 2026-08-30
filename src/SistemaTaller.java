import java.util.List;
import java.util.ArrayList;

public class SistemaTaller {

    private List<OrdenServicio> ordenes;
    private VistaConsola vista;

    public SistemaTaller() {

        ordenes = new ArrayList<OrdenServicio>();
        vista = new VistaConsola();
    }

    public void iniciar() {

        int opcion = 0;

        while (opcion != 10) {

            opcion = vista.mostrarMenu();
            procesarOpcion(opcion);
        }

        vista.mostrarMensaje("Programa finalizado");
    }

    private void procesarOpcion(int opcion) {

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
                consultarOrdenesPorPlaca();
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
                break;
            
            default:
                vista.mostrarMensaje("Opcion invalida");
        }
    }

    private void registrarOrden() {

        int numeroOrden = vista.solicitarNumeroOrden();

        if (buscarOrdenPorNumero(numeroOrden) != null) {

            vista.mostrarMensaje("Ya hay una orden con ese numero");
            return;
        }

        String nombre = vista.solicitarNombrePropietario();
        String placa = vista.solicitarPlaca();
        String descripcion = vista.solicitarDescripcion();
        double costo = vista.solicitarCosto();

         if (nombre.equals("")) {
            vista.mostrarMensaje("El nombre no puede estar vacio");
            return;
        }

        if (placa.equals("")) {
            vista.mostrarMensaje("La placa no puede estar vacia");
            return;
        }

        if (descripcion.equals("")) {
            vista.mostrarMensaje("La descripcion no puede estar vacia");
            return;
        }

        if (costo <= 0) {
            vista.mostrarMensaje("El costo debe ser mayor que 0");

            return;
        }

        OrdenServicio nuevaOrden = new OrdenServicio(numeroOrden, nombre, placa, descripcion, costo);
        
        ordenes.add(nuevaOrden);

        vista.mostrarMensaje("Orden registrada");
    }

    private OrdenServicio buscarOrdenPorNumero(int numeroOrden) {

        for (OrdenServicio orden : ordenes) {

            if (orden.getNumeroOrden() == numeroOrden) {

                return orden;
            }
        }
        return null;
    }

    private void consultarOrdenes() {

        if (ordenes.isEmpty()) {

            vista.mostrarMensaje("No hay ordenes registradas");

            return;
        }

        for (OrdenServicio orden : ordenes) {

            vista.mostrarOrden(orden);
        }
    }
    private void buscarOrden() {

        int numeroOrden = vista.solicitarNumeroOrden();

        try {
            OrdenServicio orden = buscarOrdenPorNumero(numeroOrden);

            if(orden == null) {

                throw new Exception("La orden no existe");
            }
            vista.mostrarOrden(orden);

        } catch (Exception e) {
            vista.mostrarMensaje("Error: " + e.getMessage());

        } finally {
            vista.mostrarMensaje("Busqueda finalizada");
        }
    }

    private void modificarOrden() {

        int numeroOrden = vista.solicitarNumeroOrden();
        OrdenServicio orden = buscarOrdenPorNumero(numeroOrden);

        if (orden == null) {
            vista.mostrarMensaje("La orden no existe");

            return;
        }

        String nuevaDescripcion = vista.solicitarDescripcion();
        double nuevoCosto = vista.solicitarCosto();

        boolean modificada = orden.modificarServicio(nuevaDescripcion, nuevoCosto);

        if (modificada) {

            vista.mostrarMensaje("Orden modificada");
        } else {

            vista.mostrarMensaje("No se pudo modificar la orden, revise los datos");
        }
    }

    private void cancelarOrden() {

        int numeroOrden = vista.solicitarNumeroOrden();
        OrdenServicio orden = buscarOrdenPorNumero(numeroOrden);

        if (orden == null) {
            vista.mostrarMensaje("La orden no existe");

            return;
        }

        ordenes.remove(orden);

        vista.mostrarMensaje("Orden cancelada");
    }

    private List<OrdenServicio> buscarOrdenesPorPlaca(String placa) {

        List<OrdenServicio> encontradas = new ArrayList<OrdenServicio>();

        for (OrdenServicio orden : ordenes) {

            if (orden.getPlacaVehiculo().equals(placa)) {
                encontradas.add(orden);
            }
        }

        return encontradas;
    }

    private void consultarOrdenesPorPlaca() {

        String placa = vista.solicitarPlaca();

        List<OrdenServicio> encontradas = buscarOrdenesPorPlaca(placa);

        if (encontradas.isEmpty()) {
            vista.mostrarMensaje("No hay ordenes asociadas a esa placa");
            return;
        }

        for (OrdenServicio orden : encontradas) {
            vista.mostrarOrden(orden);
        }
    }

    private double calcularCostoTotal() {

        double total = 0;

        for (OrdenServicio orden : ordenes) {
            total = total + orden.getCostoEstimado();
        }

        return total;
    }

    private double calcularCostoPromedio() {

        if (ordenes.isEmpty()) {
            return 0;
        }

        return calcularCostoTotal() / ordenes.size();
    }

    private void mostrarReporteCostos() {

        if (ordenes.isEmpty()) {
            vista.mostrarMensaje("No hay ordenes registradas");

            return;
        }

        double total = calcularCostoTotal();
        double promedio = calcularCostoPromedio();

        vista.mostrarMensaje("Costo total: Q" + total);
        vista.mostrarMensaje("Costo promedio: Q" + promedio);
    }

    private OrdenServicio obtenerOrdenMayorCosto() {

        if (ordenes.isEmpty()) {

            return null;
        }

        OrdenServicio mayor = ordenes.get(0);

        for (OrdenServicio orden : ordenes) {

            if (orden.getCostoEstimado() > mayor.getCostoEstimado()) {

                mayor = orden;
            }
        }

        return mayor;
    }

    private void mostrarOrdenMayorCosto() {

        OrdenServicio mayor = obtenerOrdenMayorCosto();

        if (mayor == null) {
            vista.mostrarMensaje("No hay ordenes registradas");

            return;
        }

        vista.mostrarMensaje("Orden con mayor costo:");
        vista.mostrarOrden(mayor);
    }

    private int obtenerCantidadOrdenes() {

        return ordenes.size();
    }

    private void mostrarCantidadOrdenes() {

        int cantidad = obtenerCantidadOrdenes();

        vista.mostrarMensaje("Cantidad de ordenes registradas: " + cantidad);
    }

}