import java.util.ArrayList;
import java.util.List;

public class ControladorOrdenes {
    private List<OrdenServicio> ordenes;

    public ControladorOrdenes() {
        ordenes = new ArrayList<OrdenServicio>();
    }

    public void registrarOrden(OrdenServicio orden) {
        if (existeNumeroOrden(orden.getNumeroOrden())) {
            throw new IllegalArgumentException(
                    "El numero de orden ya se encuentra registrado.");
        }

        ordenes.add(orden);
    }

    public List<OrdenServicio> obtenerOrdenes() {
        return new ArrayList<OrdenServicio>(ordenes);
    }

    public OrdenServicio buscarOrden(int numeroOrden) throws Exception {
        for (OrdenServicio orden : ordenes) {
            if (orden.getNumeroOrden() == numeroOrden) {
                return orden;
            }
        }

        throw new Exception("La orden no se encuentra registrada.");
    }

    public void modificarOrden(int numeroOrden,
            String nuevaDescripcion, double nuevoCosto) throws Exception {

        OrdenServicio orden = buscarOrden(numeroOrden);

        if (nuevaDescripcion == null
                || nuevaDescripcion.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La descripcion del servicio no puede estar vacia.");
        }

        if (nuevoCosto <= 0) {
            throw new IllegalArgumentException(
                    "El costo estimado debe ser mayor que cero.");
        }

        orden.setDescripcionServicio(nuevaDescripcion);
        orden.setCostoEstimado(nuevoCosto);
    }

    public void cancelarOrden(int numeroOrden) throws Exception {
        OrdenServicio orden = buscarOrden(numeroOrden);
        ordenes.remove(orden);
    }

    public List<OrdenServicio> buscarOrdenesPorPlaca(
            String placaBuscada) {

        List<OrdenServicio> coincidencias =
                new ArrayList<OrdenServicio>();

        for (OrdenServicio orden : ordenes) {
            if (orden.getPlacaVehiculo()
                    .equalsIgnoreCase(placaBuscada)) {
                coincidencias.add(orden);
            }
        }

        return coincidencias;
    }

    public double calcularCostoTotal() {
        double total = 0.0;

        for (OrdenServicio orden : ordenes) {
            total = total + orden.getCostoEstimado();
        }

        return total;
    }

    public double calcularCostoPromedio() {
        if (ordenes.size() == 0) {
            return 0.0;
        }

        return calcularCostoTotal() / ordenes.size();
    }

    public OrdenServicio obtenerOrdenMayorCosto() {
        if (ordenes.size() == 0) {
            return null;
        }

        OrdenServicio ordenMayor = ordenes.get(0);

        for (int i = 1; i < ordenes.size(); i++) {
            OrdenServicio ordenActual = ordenes.get(i);

            if (ordenActual.getCostoEstimado()
                    > ordenMayor.getCostoEstimado()) {
                ordenMayor = ordenActual;
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
