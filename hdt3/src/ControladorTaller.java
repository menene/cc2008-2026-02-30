import java.util.ArrayList;
import java.util.List;

public class ControladorTaller {
    private List<Servicio> listaOrdenes;

    public ControladorTaller() {
        listaOrdenes = new ArrayList<>();
    }

    public void registrarOrden(Servicio nuevaOrden) throws Exception {
        for (Servicio servicio : listaOrdenes) {
            if (servicio.getNumOrden() == nuevaOrden.getNumOrden()) {
                throw new Exception("Error: El numero de orden ya se encuentra registrado.");
            }
        }
        listaOrdenes.add(nuevaOrden);
    }

    public List<Servicio> consultarOrden() {
        return listaOrdenes;
    }

    public Servicio buscarOrden(int numeroOrden) throws Exception {
        for (Servicio servicio : listaOrdenes) {
            if (servicio.getNumOrden() == numeroOrden) {
                return servicio;
            }
        }
        throw new Exception("Error: La orden #" + numeroOrden + " no existe.");
    }

    public void modificarOrden(int numeroOrden, String nuevaDescripcion, double nuevoCosto) throws Exception {
        Servicio servicio = buscarOrden(numeroOrden);
        servicio.setDescripcionServicios(nuevaDescripcion);
        servicio.setCostoEstimado(nuevoCosto);
    }

    public void cancelarOrden(int numeroOrden) throws Exception {
        Servicio servicio = buscarOrden(numeroOrden);
        listaOrdenes.remove(servicio);
    }

    public List<Servicio> buscarPorPlaca(String placa) {
        List<Servicio> coincidencias = new ArrayList<>();
        for (Servicio servicio : listaOrdenes) {
            if (servicio.getPlacaVehiculo().equalsIgnoreCase(placa)) {
                coincidencias.add(servicio);
            }
        }
        return coincidencias;
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Servicio servicio : listaOrdenes) {
            total += servicio.getCostoEstimado();
        }
        return total;
    }

    public double calcularCostoPromedio() {
        if (listaOrdenes.isEmpty()) {
            return 0;
        }
        return calcularValorTotal() / listaOrdenes.size();
    }

    public Servicio obtenerOrdenMayorCosto() throws Exception {
        if (listaOrdenes.isEmpty()) {
            throw new Exception("No hay ordenes registradas para evaluar.");
        }
        Servicio mayor = listaOrdenes.get(0);
        for (Servicio servicio : listaOrdenes) {
            if (servicio.getCostoEstimado() > mayor.getCostoEstimado()) {
                mayor = servicio;
            }
        }
        return mayor;
    }

    public int obtenerCantidadOrdenes() {
        return listaOrdenes.size();
    }
}