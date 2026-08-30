import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class GestorOrdenes {

    private List<OrdenServicio> ordenes;

    public GestorOrdenes() {
        ordenes = new ArrayList<OrdenServicio>();
    }

    public void registrarOrden(OrdenServicio orden) {
        if (orden == null) {
            throw new IllegalArgumentException(
                    "La orden no puede ser nula. -_-");
        }

        if (existeNumeroOrden(orden.getNumeroOrden())) {
            throw new IllegalArgumentException(
                    "El número de orden ya está registrado.");
        }

        ordenes.add(orden);
    }

    public List<OrdenServicio> obtenerOrdenes() {
        return new ArrayList<OrdenServicio>(ordenes);
    }

    public OrdenServicio buscarOrden(int numeroOrden) {
        for (OrdenServicio orden : ordenes) {
            if (orden.getNumeroOrden() == numeroOrden) {
                return orden;
            }
        }

        throw new NoSuchElementException(
                "No existe una orden con el número indicado.");
    }

    public void modificarOrden(int numeroOrden,
            String nuevaDescripcion, double nuevoCosto) {

        if (nuevaDescripcion == null
                || nuevaDescripcion.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "La descripción del servicio no puede estar vacía.");
        }

        if (nuevoCosto <= 0) {
            throw new IllegalArgumentException(
                    "El costo estimado debe ser mayor que cero.");
        }

        OrdenServicio orden = buscarOrden(numeroOrden);

        orden.setDescripcionServicio(nuevaDescripcion);
        orden.setCostoEstimado(nuevoCosto);
    }

    public void cancelarOrden(int numeroOrden) {
        OrdenServicio orden = buscarOrden(numeroOrden);
        ordenes.remove(orden);
    }

    public List<OrdenServicio> buscarPorPlaca(String placa) {
        List<OrdenServicio> coincidencias =
                new ArrayList<OrdenServicio>();

        if (placa == null || placa.trim().isEmpty()) {
            return coincidencias;
        }

        for (OrdenServicio orden : ordenes) {
            if (orden.getPlacaVehiculo()
                    .equalsIgnoreCase(placa.trim())) {

                coincidencias.add(orden);
            }
        }

        return coincidencias;
    }

    public double calcularCostoTotal() {
        double total = 0.0;

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

    public OrdenServicio obtenerOrdenMayorCosto() {
        if (ordenes.isEmpty()) {
            throw new NoSuchElementException(
                    "No hay órdenes registradas.");
        }

        OrdenServicio ordenMayor = ordenes.get(0);

        for (int i = 1; i < ordenes.size(); i++) {
            if (ordenes.get(i).getCostoEstimado()
                    > ordenMayor.getCostoEstimado()) {

                ordenMayor = ordenes.get(i);
            }
        }

        return ordenMayor;
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