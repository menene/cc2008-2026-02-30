import java.util.ArrayList;
import java.util.List;

public class Taller {

    // Colección dinámica de órdenes
    private List<OrdenServicio> ordenes;

    // Constructor
    public Taller() {
        ordenes = new ArrayList<>();
    }

    // Registro de órdenes
    public void registrarOrden(OrdenServicio orden) {
        ordenes.add(orden);
    }

    // Búsqueda por número de orden
    public OrdenServicio buscarOrden(int numeroOrden) {
        for (OrdenServicio orden : ordenes) {
            if (orden.getNumeroOrden() == numeroOrden) {
                return orden;
            }
        }

        return null;
    }

    // Consulta de todas las órdenes
    public List<OrdenServicio> obtenerOrdenes() {
        return ordenes;
    }

    // Modificación de una orden
    public void modificarOrden(int numeroOrden, String nuevaDescripcion,
                               double nuevoCosto) {
        OrdenServicio orden = buscarOrden(numeroOrden);

        if (orden != null) {
            orden.setDescripcionServicio(nuevaDescripcion);
            orden.setCostoEstimado(nuevoCosto);
        }
    }

    // Cancelación de una orden
    public void cancelarOrden(int numeroOrden) {
        OrdenServicio orden = buscarOrden(numeroOrden);

        if (orden != null) {
            ordenes.remove(orden);
        }
    }

    // Búsqueda de órdenes asociadas a una placa
    public List<OrdenServicio> buscarOrdenesPorPlaca(String placa) {
        List<OrdenServicio> coincidencias = new ArrayList<>();

        for (OrdenServicio orden : ordenes) {
            if (orden.getPlacaVehiculo().equalsIgnoreCase(placa)) {
                coincidencias.add(orden);
            }
        }

        return coincidencias;
    }

    // Cálculos de costos
    public double calcularCostoTotal() {
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

        return calcularCostoTotal() / ordenes.size();
    }

    // Búsqueda de la orden con mayor costo
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

    // Cantidad de órdenes almacenadas
    public int obtenerCantidadOrdenes() {
        return ordenes.size();
    }
}