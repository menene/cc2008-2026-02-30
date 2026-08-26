import java.util.ArrayList;
import java.util.List;

public class OrdenArrayList {

    private List<OrdenServicio> ordenes;

    public OrdenArrayList() {
        ordenes = new ArrayList<>();
    }

    public void guardar(OrdenServicio orden) {
        if (orden == null) {
            throw new IllegalArgumentException("La orden no puede ser nula.");
        }

        ordenes.add(orden);
    }

    public List<OrdenServicio> obtenerTodas() {
        return new ArrayList<>(ordenes);
    }

    public OrdenServicio buscarPorNumero(int numeroOrden) {
        for (OrdenServicio orden : ordenes) {
            if (orden.getNumeroOrden() == numeroOrden) {
                return orden;
            }
        }

        return null;
    }

    public boolean eliminarPorNumero(
            int numeroOrden) {

        for (int i = 0; i < ordenes.size(); i++) {
            OrdenServicio orden = ordenes.get(i);

            if (orden.getNumeroOrden() == numeroOrden) {
                ordenes.remove(i);
                return true;
            }
        }

        return false;
    }

    public List<OrdenServicio> buscarPorPlaca(String placa) {
        List<OrdenServicio> resultados = new ArrayList<>();

        for (OrdenServicio orden : ordenes) {
            if (orden.getPlacaVehiculo().equalsIgnoreCase(placa.trim())) {
                resultados.add(orden);
            }
        }

        return resultados;
    }

    public int cantidad() {
        return ordenes.size();
    }
}