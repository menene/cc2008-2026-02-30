import java.util.ArrayList;
import java.util.List;

public class GestorOrdenes {
    private final List<OrdenServicio> ordenes;

    public GestorOrdenes() {
        this.ordenes = new ArrayList<>();
    }

    public void agregarOrden(OrdenServicio orden) {
        ordenes.add(orden);
    }

    public List<OrdenServicio> getOrdenes() {
        return ordenes;
    }

    public OrdenServicio buscarOrden(int numeroOrden) {
        for (OrdenServicio orden : ordenes) {
            if (orden.getNumeroOrden() == numeroOrden) {
                return orden;
            }
        }
        return null;
    }

    public boolean actualizarOrden(int numeroOrden, String nombreCliente, String placaVehiculo,
                                  String descripcionServicio, double costoEstimado) {
        OrdenServicio orden = buscarOrden(numeroOrden);
        if (orden == null) {
            return false;
        }

        orden.setNombreCliente(nombreCliente);
        orden.setPlacaVehiculo(placaVehiculo);
        orden.setDescripcionServicio(descripcionServicio);
        orden.setCostoEstimado(costoEstimado);
        return true;
    }

    public boolean eliminarOrden(int numeroOrden) {
        return ordenes.removeIf(orden -> orden.getNumeroOrden() == numeroOrden);
    }

    public double calcularTotal() {
        double total = 0;
        for (OrdenServicio orden : ordenes) {
            total += orden.getCostoEstimado();
        }
        return total;
    }
}
