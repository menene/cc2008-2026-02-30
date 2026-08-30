import java.util.ArrayList;
import java.util.List;

public class GestorOrdenes {

    private List<OrdenServicio> ordenes;

    public GestorOrdenes() {
        ordenes = new ArrayList<>();
    }

    public void registrarOrden(int numeroOrden, Cliente cliente, Vehiculo vehiculo,
                                String descripcion, double costo)
            throws DatosInvalidosException, OrdenDuplicadaException {

        if (cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()) {
            throw new DatosInvalidosException("El nombre del propietario no puede estar vacío.");
        }
        if (vehiculo.getPlaca() == null || vehiculo.getPlaca().trim().isEmpty()) {
            throw new DatosInvalidosException("La placa del vehículo no puede estar vacía.");
        }
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new DatosInvalidosException("La descripción del servicio no puede estar vacía.");
        }
        if (costo <= 0) {
            throw new DatosInvalidosException("El costo estimado debe ser mayor que 0.");
        }

        for (OrdenServicio orden : ordenes) {
            if (orden.getNumeroOrden() == numeroOrden) {
                throw new OrdenDuplicadaException(
                        "Ya existe una orden registrada con el número " + numeroOrden + ".");
            }
        }

        OrdenServicio nuevaOrden = new OrdenServicio(numeroOrden, cliente, vehiculo, descripcion, costo);
        ordenes.add(nuevaOrden);
    }

    public List<OrdenServicio> consultarOrdenes() {
        return ordenes;
    }

    public OrdenServicio buscarOrden(int numeroOrden) throws OrdenNoEncontradaException {
        for (OrdenServicio orden : ordenes) {
            if (orden.getNumeroOrden() == numeroOrden) {
                return orden;
            }
        }
        throw new OrdenNoEncontradaException("No existe una orden con el número " + numeroOrden + ".");
    }

    public void modificarOrden(int numeroOrden, String nuevaDescripcion, double nuevoCosto)
            throws OrdenNoEncontradaException, DatosInvalidosException {

        OrdenServicio orden = buscarOrden(numeroOrden);

        if (nuevaDescripcion == null || nuevaDescripcion.trim().isEmpty()) {
            throw new DatosInvalidosException("La descripción del servicio no puede estar vacía.");
        }
        if (nuevoCosto <= 0) {
            throw new DatosInvalidosException("El costo estimado debe ser mayor que 0.");
        }

        orden.setDescripcionServicio(nuevaDescripcion);
        orden.setCostoEstimado(nuevoCosto);
    }

    public void cancelarOrden(int numeroOrden) throws OrdenNoEncontradaException {
        OrdenServicio orden = buscarOrden(numeroOrden);
        ordenes.remove(orden);
    }

    public List<OrdenServicio> consultarPorPlaca(String placa) {
        List<OrdenServicio> encontradas = new ArrayList<>();
        for (OrdenServicio orden : ordenes) {
            if (orden.getVehiculo().getPlaca().equals(placa)) {
                encontradas.add(orden);
            }
        }
        return encontradas;
    }

    public double calcularValorTotal() {
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
        return calcularValorTotal() / ordenes.size();
    }

    public OrdenServicio ordenMayorCosto() throws OrdenNoEncontradaException {
        if (ordenes.isEmpty()) {
            throw new OrdenNoEncontradaException("No hay órdenes registradas actualmente.");
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
}
