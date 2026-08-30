import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Taller {
    // Atributo
    private ArrayList<Orden> ordenes;

    // Constructor 
    public Taller() {
        ordenes = new ArrayList<>();
    }

    // Método para agregar órden, si se repite el número se lanza una excepción
    public void agregarOrden(Orden orden) {
        ordenes.add(orden);
    }

    // Busca una orden por su número y lanza una excepción  si no se encuentra
    public Orden buscaOrden(int numeroOrden) throws NoSuchElementException {
        for (Orden orden : ordenes) {
            if (orden.getNumeroOrden() == numeroOrden) {
                return orden;
            }
        }
        throw new NoSuchElementException("No existe una orden con el número " + numeroOrden);
    }

    // Modifica orden 
    public void modificarOrden(Orden orden, String nuevaDescripcion, double nuevoCosto) {
        orden.setDescripcionServicio(nuevaDescripcion);
        orden.setCostoEstimado(nuevoCosto);
    }

    // Elimina orden, puede lanzar excepción porque llama al método buscarOrden()
    public void eliminarOrden(int numeroOrden) throws NoSuchElementException {
        Orden orden = buscaOrden(numeroOrden);
        ordenes.remove(orden);
    }

    public ArrayList<Orden> buscarOrdenesPorPlaca(String placa) {
        ArrayList<Orden> coincidencias = new ArrayList<>();

        for (Orden orden : ordenes) {
            if (orden.getPlaca().equalsIgnoreCase(placa)) {
                coincidencias.add(orden);
            }
        }

        return coincidencias;
    }

    public double calcularCostoTotal() {
        double total = 0;

        for (Orden orden : ordenes) {
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

    public Orden obtenerOrdenMayorCosto() throws NoSuchElementException {
        if (ordenes.isEmpty()) {
            throw new NoSuchElementException("No hay órdenes registradas.");
        }

        Orden ordenMayor = ordenes.get(0);

        for (Orden orden : ordenes) {
            if (orden.getCostoEstimado() > ordenMayor.getCostoEstimado()) {
                ordenMayor = orden;
            }
        }

        return ordenMayor;
    }

    public int obtenerCantidadOrdenes() {
        return ordenes.size();
    }

    public ArrayList<Orden> obtenerOrdenes() {
        return new ArrayList<>(ordenes);
    }

    // Método para comprobar si ya existe una orden con el mismo número
    public boolean existeOrden(int numeroOrden) {
        for(Orden orden : ordenes) {
            if (orden.getNumeroOrden() == numeroOrden) {
                return true;
            }
        }
        return false;
    }
}