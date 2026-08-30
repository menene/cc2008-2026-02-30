import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class GestorOrdenes {


    private List<OrdenServicio> ordenes;

    public GestorOrdenes() {
        ordenes = new ArrayList<>();
    }


    public void agregarOrden(OrdenServicio orden) {
        for (OrdenServicio o : ordenes) {
            if (o.getNumeroOrden() == orden.getNumeroOrden()) {
                throw new IllegalArgumentException(
                        "Ya existe una orden registrada con el numero " + orden.getNumeroOrden());
            }
        }
        ordenes.add(orden);
    }


    public List<OrdenServicio> obtenerOrdenes() {
        return ordenes;
    }


    public OrdenServicio buscarOrden(int numeroOrden) {
        for (OrdenServicio o : ordenes) {
            if (o.getNumeroOrden() == numeroOrden) {
                return o;
            }
        }
        throw new NoSuchElementException("No existe una orden con el numero " + numeroOrden + ".");
    }


    public void modificarOrden(int numeroOrden, String descripcion, double costo) {
        OrdenServicio orden = buscarOrden(numeroOrden);
        orden.setDescripcionServicio(descripcion);
        orden.setCostoEstimado(costo);
    }


    public void cancelarOrden(int numeroOrden) {
        OrdenServicio orden = buscarOrden(numeroOrden);
        ordenes.remove(orden);
    }


    public List<OrdenServicio> buscarPorPlaca(String placa) {
        List<OrdenServicio> resultado = new ArrayList<>();
        for (OrdenServicio o : ordenes) {
            if (o.getPlacaVehiculo().equalsIgnoreCase(placa)) {
                resultado.add(o);
            }
        }
        return resultado;
    }


    public double calcularTotal() {
        double total = 0;
        for (OrdenServicio o : ordenes) {
            total += o.getCostoEstimado();
        }
        return total;
    }


    public double calcularPromedio() {
        if (ordenes.isEmpty()) {
            return 0;
        }
        return calcularTotal() / ordenes.size();
    }


    public OrdenServicio obtenerOrdenMayorCosto() {
        if (ordenes.isEmpty()) {
            throw new NoSuchElementException("No hay ordenes registradas.");
        }
        OrdenServicio mayor = ordenes.get(0);
        for (OrdenServicio o : ordenes) {
            if (o.getCostoEstimado() > mayor.getCostoEstimado()) {
                mayor = o;
            }
        }
        return mayor;
    }


    public int cantidadOrdenes() {
        return ordenes.size();
    }
}
