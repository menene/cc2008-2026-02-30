import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class GestionOrdenes {
    private List<Orden> ordenes;

    public GestionOrdenes() {
        ordenes = new ArrayList<>();
    }

    public void registrarOrden(Orden orden) {
        if (orden == null) {
            throw new IllegalArgumentException("La orden no puede ser nula.");
        }

        if (orden.getNombrePropietario().isBlank()) {
            throw new IllegalArgumentException("El nombre del propietario no puede estar vacío.");
        }

        if (orden.getPlaca().isBlank()) {
            throw new IllegalArgumentException("La placa no puede estar vacía.");
        }

        if (orden.getDescripcionServicio().isBlank()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía.");
        }

        if (orden.getCostoEstimado() <= 0) {
            throw new IllegalArgumentException("El costo estimado debe ser mayor que cero.");
        }

        for (Orden ordenRegistrada : ordenes) {
            if (ordenRegistrada.getNumeroOrden() == orden.getNumeroOrden()) {
                throw new IllegalArgumentException("El número de orden ya está registrado.");
            }
        }

        ordenes.add(orden);
    }

    public List<Orden> obtenerOrdenes() {
        return new ArrayList<>(ordenes);
    }

    public Orden buscarPorNumero(int numeroOrden) {
        for (Orden orden : ordenes) {
            if (orden.getNumeroOrden() == numeroOrden) {
                return orden;
            }
        }

        throw new NoSuchElementException(
                "No existe una orden con el número indicado."
        );
    }

    public void modificarOrden(int numeroOrden, String nuevaDescripcion, double nuevoCosto) {
        if (nuevaDescripcion.isBlank()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía.");
        }

        if (nuevoCosto <= 0) {
            throw new IllegalArgumentException("El costo debe ser mayor que cero.");
        }

        Orden orden = buscarPorNumero(numeroOrden);
        orden.setDescripcionServicio(nuevaDescripcion);
        orden.setCostoEstimado(nuevoCosto);
    }

    public void cancelarOrden(int numeroOrden) {
        Orden orden = buscarPorNumero(numeroOrden);
        ordenes.remove(orden);
    }

    public List<Orden> buscarPorPlaca(String placa) {
        List<Orden> coincidencias = new ArrayList<>();

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

    public Orden obtenerOrdenMayorCosto() {
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
}