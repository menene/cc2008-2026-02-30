import java.util.ArrayList;
import java.util.List;

public class GestorOrdenes {

    private List<OrdenServicio> ordenes;

    public GestorOrdenes() {
        ordenes = new ArrayList<>();
    }

    public void registrarOrden(OrdenServicio orden) {

        if (existeOrden(orden.getNumeroOrden())) {
            throw new IllegalArgumentException(
                    "Ya existe una orden con ese número."
            );
        }

        if (orden.getNombrePropietario() == null
                || orden.getNombrePropietario().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "El nombre del propietario no puede estar vacío."
            );
        }

        if (orden.getPlacaVehiculo() == null
                || orden.getPlacaVehiculo().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "La placa no puede estar vacía."
            );
        }

        if (orden.getDescripcionServicio() == null
                || orden.getDescripcionServicio().trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "La descripción del servicio no puede estar vacía."
            );
        }

        if (orden.getCostoEstimado() <= 0) {
            throw new IllegalArgumentException(
                    "El costo estimado debe ser mayor que 0."
            );
        }

        ordenes.add(orden);
    }

    public boolean existeOrden(int numeroOrden) {

        for (OrdenServicio orden : ordenes) {

            if (orden.getNumeroOrden() == numeroOrden) {
                return true;
            }
        }

        return false;
    }

    public List<OrdenServicio> consultarOrdenes() {
        return new ArrayList<>(ordenes);
    }

    public OrdenServicio buscarOrden(int numeroOrden) {

        for (OrdenServicio orden : ordenes) {

            if (orden.getNumeroOrden() == numeroOrden) {
                return orden;
            }
        }

        throw new IllegalArgumentException(
                "No se encontró una orden con el número " + numeroOrden + "."
        );
    }

    public void modificarOrden(int numeroOrden,
                               String nuevaDescripcion,
                               double nuevoCosto) {

        OrdenServicio orden = buscarOrden(numeroOrden);

        if (nuevaDescripcion == null
                || nuevaDescripcion.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "La descripción no puede estar vacía."
            );
        }

        if (nuevoCosto <= 0) {
            throw new IllegalArgumentException(
                    "El costo debe ser mayor que 0."
            );
        }

        orden.setDescripcionServicio(nuevaDescripcion);
        orden.setCostoEstimado(nuevoCosto);
    }

    public void cancelarOrden(int numeroOrden) {

        OrdenServicio orden = buscarOrden(numeroOrden);

        ordenes.remove(orden);
    }

    public List<OrdenServicio> buscarPorPlaca(String placa) {

        List<OrdenServicio> resultados = new ArrayList<>();

        for (OrdenServicio orden : ordenes) {

            if (orden.getPlacaVehiculo().equalsIgnoreCase(placa)) {
                resultados.add(orden);
            }
        }

        return resultados;
    }

    public double calcularTotalCostos() {

        double total = 0;

        for (OrdenServicio orden : ordenes) {
            total += orden.getCostoEstimado();
        }

        return total;
    }

    public double calcularCostoPromedio() {

        if (ordenes.isEmpty()) {
            return 0;
        }

        return calcularTotalCostos() / ordenes.size();
    }

    public OrdenServicio obtenerOrdenMayorCosto() {

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

    public int obtenerCantidadOrdenes() {
        return ordenes.size();
    }
}