import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ControladorOrdenes {
    private List<Orden> ordenes;

    public ControladorOrdenes() {
        this.ordenes = new ArrayList<>();
    }

    public void registrarOrden(Orden nuevaOrden) throws Exception {
        for (Orden o: ordenes) {
            if (o.getNumeroOrden() == nuevaOrden.getNumeroOrden()) {
                throw new Exception("Ya existe una orden con el mismo número: " + nuevaOrden.getNumeroOrden());
            }
        }
        ordenes.add(nuevaOrden);
    }

    public List<Orden> consultarOrdenes() {
        return new ArrayList<>(ordenes); 
    }

    public Orden buscarOrden(int numOrden) {
        for (Orden o: ordenes) {
            if (o.getNumeroOrden() == numOrden) {
                return o;
            }
        }
        throw new NoSuchElementException("No se encontró una orden con el número: " + numOrden);
    }

    public void modificarOrden(int numOrden, String nuevaDescripcion, double nuevoCosto) {
        Orden ordenEncontrada = buscarOrden(numOrden);
        ordenEncontrada.setDescripcionServicio(nuevaDescripcion);
        ordenEncontrada.setCostoEstimado(nuevoCosto);
    }

    public void cancelarOrden(int numOrden) {
        Orden ordenEncontrada = buscarOrden(numOrden);
        ordenes.remove(ordenEncontrada);
    }

    public List<Orden> buscarOrdenesPorPlaca(String placa) {
        List<Orden> ordenesEncontradas = new ArrayList<>();
        for(Orden o: ordenes){
            if(o.getPlaca().equalsIgnoreCase(placa)){
                ordenesEncontradas.add(o);
            }
            if (ordenesEncontradas.isEmpty()) {
                throw new NoSuchElementException("No se encontraron órdenes con la placa: " + placa);
        }
    }
    return ordenesEncontradas;
}

    public double calcularTotalOrdenes() {
        double total = 0;
        for (int i = 0; i < ordenes.size(); i++) {
            total += ordenes.get(i).getCostoEstimado();
        }
        return total;
    }

    public double calcularCostoPromedio() {
        if (ordenes.isEmpty()) {
            throw new IllegalStateException("No hay órdenes registradas para calcular el promedio.");
        }
        double total = calcularTotalOrdenes();
        return total / ordenes.size();
    }

    public Orden obtenerOrdenMayorCosto() {
        if (ordenes.isEmpty()) {
            throw new IllegalStateException("No hay órdenes registradas para determinar la de mayor costo.");
        }
        Orden ordenMayor = ordenes.get(0);
        for (Orden o: ordenes) {
            if (o.getCostoEstimado() > ordenMayor.getCostoEstimado()) {
                ordenMayor = o;
            }
        }
        return ordenMayor;
    }

    public int obtenerCantidadOrdenes() {
        return ordenes.size();
    }
}

