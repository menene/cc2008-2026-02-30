import java.util.List;

public class ServicioOrdenes {
    private OrdenArrayList repositorio;

    public ServicioOrdenes(
            OrdenArrayList repositorio) {

        if (repositorio == null) {
            throw new IllegalArgumentException("El almacenamiento de órdenes es obligatorio.");
        }

        this.repositorio = repositorio;
    }

    public void registrarOrden(OrdenServicio orden) throws OrdenDuplicadaException {
        if (orden == null) {
            throw new IllegalArgumentException("La orden no puede ser nula.");
        }

        OrdenServicio ordenExistente = repositorio.buscarPorNumero(orden.getNumeroOrden());

        if (ordenExistente != null) {
            throw new OrdenDuplicadaException("Ya existe una orden con el número " + orden.getNumeroOrden() + ".");
        }

        repositorio.guardar(orden);
    }

    public List<OrdenServicio> listarOrdenes() {
        return repositorio.obtenerTodas();
    }

    public OrdenServicio buscarOrden(int numeroOrden) throws OrdenNoEncontradaException {
        OrdenServicio orden = repositorio.buscarPorNumero(numeroOrden);

        if (orden == null) {
            throw new OrdenNoEncontradaException("No se encontró la orden número " + numeroOrden + ".");
        }

        return orden;
    }

    public void modificarOrden(int numeroOrden, String nuevaDescripcion, double nuevoCosto)
            throws OrdenNoEncontradaException {

        OrdenServicio orden = buscarOrden(numeroOrden);

        orden.actualizarServicio(
                nuevaDescripcion,
                nuevoCosto);
    }

    public void cancelarOrden(int numeroOrden)
            throws OrdenNoEncontradaException {

        boolean eliminada = repositorio.eliminarPorNumero(numeroOrden);

        if (!eliminada) {
            throw new OrdenNoEncontradaException("No se encontró la orden número " + numeroOrden + ".");
        }
    }

    public List<OrdenServicio> buscarOrdenesPorPlaca(String placa) {

        if (placa == null || placa.trim().isEmpty()) {
            throw new IllegalArgumentException("La placa no puede estar vacía.");
        }

        return repositorio.buscarPorPlaca(placa);
    }

    public double calcularCostoTotal() {
        double total = 0;

        for (OrdenServicio orden : repositorio.obtenerTodas()) {
            total += orden.getCostoEstimado();
        }

        return total;
    }

    public double calcularCostoPromedio() {
        int cantidadOrdenes = repositorio.cantidad();

        if (cantidadOrdenes == 0) {
            return 0.0;
        }

        return calcularCostoTotal() / cantidadOrdenes;
    }

    public OrdenServicio obtenerOrdenMayorCosto() {
        List<OrdenServicio> ordenes = repositorio.obtenerTodas();

        if (ordenes.isEmpty()) {
            return null;
        }

        OrdenServicio ordenMayor = ordenes.get(0);

        for (OrdenServicio orden : ordenes) {
            if (orden.getCostoEstimado() > ordenMayor.getCostoEstimado()) {
                ordenMayor = orden;
            }
        }

        return ordenMayor;
    }

    public int obtenerCantidadOrdenes() {
        return repositorio.cantidad();
    }
}
