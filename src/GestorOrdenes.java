import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class GestorOrdenes {

    private List<OrdenServicio> ordenes;

    public GestorOrdenes() {
        this.ordenes = new ArrayList<>();
    }

    public void registrarOrden(int numeroOrden, String nombrePropietario, String placa,
                                String descripcionServicio, double costoEstimado) {

        if (existeNumeroOrden(numeroOrden)) {
            throw new IllegalArgumentException("Ya existe una orden registrada con el numero " + numeroOrden + ".");
        }
        if (nombrePropietario == null || nombrePropietario.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del propietario no puede estar vacio.");
        }
        if (placa == null || placa.trim().isEmpty()) {
            throw new IllegalArgumentException("La placa del vehiculo no puede estar vacia.");
        }
        if (descripcionServicio == null || descripcionServicio.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripcion del servicio no puede estar vacia.");
        }
        if (costoEstimado <= 0) {
            throw new IllegalArgumentException("El costo estimado debe ser mayor que 0.");
        }

        ordenes.add(new OrdenServicio(numeroOrden, nombrePropietario, placa, descripcionServicio, costoEstimado));
    }

    public OrdenServicio buscarPorNumero(int numeroOrden) {
        for (OrdenServicio orden : ordenes) {
            if (orden.getNumeroOrden() == numeroOrden) {
                return orden;
            }
        }
        throw new NoSuchElementException("No existe una orden registrada con el numero " + numeroOrden + ".");
    }

    public void modificarOrden(int numeroOrden, String nuevaDescripcion, double nuevoCosto) {
        OrdenServicio orden = buscarPorNumero(numeroOrden);

        if (nuevaDescripcion == null || nuevaDescripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripcion del servicio no puede estar vacia.");
        }
        if (nuevoCosto <= 0) {
            throw new IllegalArgumentException("El costo estimado debe ser mayor que 0.");
        }

        orden.setDescripcionServicio(nuevaDescripcion);
        orden.setCostoEstimado(nuevoCosto);
    }

    public void cancelarOrden(int numeroOrden) {
        OrdenServicio orden = buscarPorNumero(numeroOrden);
        ordenes.remove(orden);
    }

    public List<OrdenServicio> consultarPorPlaca(String placa) {
        List<OrdenServicio> resultado = new ArrayList<>();
        for (OrdenServicio orden : ordenes) {
            if (orden.getPlaca().equalsIgnoreCase(placa)) {
                resultado.add(orden);
            }
        }
        return resultado;
    }

    public List<OrdenServicio> consultarTodas() {
        return ordenes;
    }

    public double calcularTotal() {
        double total = 0;
        for (OrdenServicio orden : ordenes) {
            total += orden.getCostoEstimado();
        }
        return total;
    }

    public double calcularPromedio() {
        if (ordenes.isEmpty()) {
            return 0;
        }
        return calcularTotal() / ordenes.size();
    }

    public OrdenServicio obtenerMayorCosto() {
        if (ordenes.isEmpty()) {
            throw new NoSuchElementException("No hay ordenes registradas actualmente.");
        }
        OrdenServicio mayor = ordenes.get(0);
        for (OrdenServicio orden : ordenes) {
            if (orden.getCostoEstimado() > mayor.getCostoEstimado()) {
                mayor = orden;
            }
        }
        return mayor;
    }

    public int cantidadOrdenes() {
        return ordenes.size();
    }

    public boolean existeNumeroOrden(int numeroOrden) {
        for (OrdenServicio orden : ordenes) {
            if (orden.getNumeroOrden() == numeroOrden) {
                return true;
            }
        }
        return false;
    }
}