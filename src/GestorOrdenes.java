import java.util.ArrayList;
import java.util.List;

public class GestorOrdenes {
    private final List<OrdenServicio> ordenes;

    public GestorOrdenes() {
        ordenes = new ArrayList<>();
    }

    public void registrarOrden(OrdenServicio orden) {
        if (orden == null) {
            throw new IllegalArgumentException("La orden no puede ser nula.");
        }
        validarDatos(orden.getNumeroOrden(), orden.getNombrePropietario(),
                orden.getPlacaVehiculo(), orden.getDescripcionServicio(), orden.getCostoEstimado());
        if (existeNumeroOrden(orden.getNumeroOrden())) {
            throw new IllegalArgumentException("El numero de orden ya esta registrado.");
        }
        ordenes.add(orden);
    }

    private void validarDatos(int numeroOrden, String propietario, String placa,
                              String descripcion, double costo) {
        if (numeroOrden <= 0) {
            throw new IllegalArgumentException("El numero de orden debe ser mayor que 0.");
        }
        if (propietario == null || propietario.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del propietario no puede estar vacio.");
        }
        if (placa == null || placa.trim().isEmpty()) {
            throw new IllegalArgumentException("La placa no puede estar vacia.");
        }
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripcion no puede estar vacia.");
        }
        if (costo <= 0) {
            throw new IllegalArgumentException("El costo estimado debe ser mayor que 0.");
        }
    }

    private boolean existeNumeroOrden(int numeroOrden) {
        for (OrdenServicio orden : ordenes) {
            if (orden.getNumeroOrden() == numeroOrden) {
                return true;
            }
        }
        return false;
    }

    public OrdenServicio buscarOrden(int numeroOrden) throws OrdenNoEncontradaException {
        for (OrdenServicio orden : ordenes) {
            if (orden.getNumeroOrden() == numeroOrden) {
                return orden;
            }
        }
        throw new OrdenNoEncontradaException("No existe la orden numero " + numeroOrden + ".");
    }

    public void modificarOrden(int numeroOrden, String nuevaDescripcion, double nuevoCosto)
            throws OrdenNoEncontradaException {
        if (nuevaDescripcion == null || nuevaDescripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripcion no puede estar vacia.");
        }
        if (nuevoCosto <= 0) {
            throw new IllegalArgumentException("El costo debe ser mayor que 0.");
        }
        OrdenServicio orden = buscarOrden(numeroOrden);
        orden.setDescripcionServicio(nuevaDescripcion.trim());
        orden.setCostoEstimado(nuevoCosto);
    }

    public void cancelarOrden(int numeroOrden) throws OrdenNoEncontradaException {
        OrdenServicio orden = buscarOrden(numeroOrden);
        ordenes.remove(orden);
    }

    public List<OrdenServicio> obtenerOrdenes() {
        return new ArrayList<>(ordenes);
    }

    public List<OrdenServicio> buscarPorPlaca(String placa) {
        if (placa == null || placa.trim().isEmpty()) {
            throw new IllegalArgumentException("La placa no puede estar vacia.");
        }
        List<OrdenServicio> coincidencias = new ArrayList<>();
        for (OrdenServicio orden : ordenes) {
            if (orden.getPlacaVehiculo().equalsIgnoreCase(placa.trim())) {
                coincidencias.add(orden);
            }
        }
        return coincidencias;
    }

    public double calcularTotal() {
        double total = 0;
        for (OrdenServicio orden : ordenes) {
            total += orden.getCostoEstimado();
        }
        return total;
    }

    public double calcularPromedio() {
        return ordenes.isEmpty() ? 0 : calcularTotal() / ordenes.size();
    }

    public OrdenServicio obtenerOrdenMayorCosto() throws OrdenNoEncontradaException {
        if (ordenes.isEmpty()) {
            throw new OrdenNoEncontradaException("No hay ordenes registradas.");
        }
        OrdenServicio mayor = ordenes.get(0);
        for (OrdenServicio orden : ordenes) {
            if (orden.getCostoEstimado() > mayor.getCostoEstimado()) {
                mayor = orden;
            }
        }
        return mayor;
    }
    
    public int obtenerCantidadOrdenes() {
        return ordenes.size();
    }
}
