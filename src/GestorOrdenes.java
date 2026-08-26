import java.util.ArrayList;
import java.util.List;

public class GestorOrdenes {
    private List<OrdenServicio> ordenes;

    public GestorOrdenes() {
        ordenes = new ArrayList<>();
    }

    public void registrarOrden(OrdenServicio orden) {
        if (orden == null) {
            throw new IllegalArgumentException(
                    "La orden no puede ser nula.");
        }

        if (existeNumeroOrden(orden.getNumeroOrden())) {
            throw new IllegalArgumentException(
                    "El número de orden ya está registrado.");
        }

        ordenes.add(orden);
    }

    public List<OrdenServicio> consultarOrdenes() {
        return new ArrayList<>(ordenes);
    }

    public OrdenServicio buscarOrden(int numeroOrden)
            throws OrdenNoEncontradaException {

        for (OrdenServicio orden : ordenes) {
            if (orden.getNumeroOrden() == numeroOrden) {
                return orden;
            }
        }

        throw new OrdenNoEncontradaException(
                "No existe una orden con el número "
                        + numeroOrden + ".");
    }

    public void modificarOrden(
            int numeroOrden,
            String nuevaDescripcion,
            double nuevoCosto)
            throws OrdenNoEncontradaException {

        OrdenServicio orden = buscarOrden(numeroOrden);
        orden.setDescripcionServicio(nuevaDescripcion);
        orden.setCostoEstimado(nuevoCosto);
    }

    public void cancelarOrden(int numeroOrden)
            throws OrdenNoEncontradaException {

        OrdenServicio orden = buscarOrden(numeroOrden);
        ordenes.remove(orden);
    }

    public List<OrdenServicio> buscarPorPlaca(String placa) {
        if (placa == null || placa.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La placa no puede estar vacía.");
        }

        List<OrdenServicio> coincidencias = new ArrayList<>();

        for (OrdenServicio orden : ordenes) {
            if (orden.getPlacaVehiculo()
                    .equalsIgnoreCase(placa.trim())) {
                coincidencias.add(orden);
            }
        }

        return coincidencias;
    }

    public double calcularCostoTotal() {
        double total = 0;

        for (OrdenServicio orden : ordenes) {
            total += orden.getCostoEstimado();
        }

        return total;
    }

    public double calcularCostoPromedio() {
        if (ordenes.isEmpty()) {
            return 0.0;
        }

        return calcularCostoTotal() / ordenes.size();
    }

    public OrdenServicio obtenerOrdenMayorCosto()
            throws OrdenNoEncontradaException {

        if (ordenes.isEmpty()) {
            throw new OrdenNoEncontradaException(
                    "No hay órdenes registradas para calcular el mayor costo.");
        }

        OrdenServicio ordenMayorCosto = ordenes.get(0);

        for (OrdenServicio orden : ordenes) {
            if (orden.getCostoEstimado()
                    > ordenMayorCosto.getCostoEstimado()) {
                ordenMayorCosto = orden;
            }
        }

        return ordenMayorCosto;
    }

    public int obtenerCantidadOrdenes() {
        return ordenes.size();
    }

    private boolean existeNumeroOrden(int numeroOrden) {
        for (OrdenServicio orden : ordenes) {
            if (orden.getNumeroOrden() == numeroOrden) {
                return true;
            }
        }

        return false;
    }
}