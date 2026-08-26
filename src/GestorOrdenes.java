import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
 

public class GestorOrdenes {
 
    private List<OrdenServicio> listaOrdenes;
 

    public GestorOrdenes() {
        this.listaOrdenes = new ArrayList<>();
    }
 

    public void registrarOrden(int numeroOrden, String nombrePropietario, String placaVehiculo,
                                String descripcionServicio, double costoEstimado) {
 
        if (existeOrden(numeroOrden)) {
            throw new IllegalArgumentException("El número de orden " + numeroOrden + " ya se encuentra registrado.");
        }
        if (nombrePropietario == null || nombrePropietario.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del propietario no puede estar vacío.");
        }
        if (placaVehiculo == null || placaVehiculo.trim().isEmpty()) {
            throw new IllegalArgumentException("La placa del vehículo no puede estar vacía.");
        }
        if (descripcionServicio == null || descripcionServicio.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción del servicio no puede estar vacía.");
        }
        if (costoEstimado <= 0) {
            throw new IllegalArgumentException("El costo estimado debe ser mayor que 0.");
        }
 
        OrdenServicio nuevaOrden = new OrdenServicio(numeroOrden, nombrePropietario, placaVehiculo,
                descripcionServicio, costoEstimado);
        listaOrdenes.add(nuevaOrden);
    }
 

    public List<OrdenServicio> consultarOrdenes() {
        return listaOrdenes;
    }
 

    public OrdenServicio buscarOrden(int numeroOrden) {
        for (OrdenServicio orden : listaOrdenes) {
            if (orden.getNumeroOrden() == numeroOrden) {
                return orden;
            }
        }
        throw new NoSuchElementException("No existe una orden registrada con el número " + numeroOrden + ".");
    }

    public void modificarOrden(int numeroOrden, String nuevaDescripcion, double nuevoCosto) {
        OrdenServicio orden = buscarOrden(numeroOrden);
        orden.setDescripcionServicio(nuevaDescripcion);
        orden.setCostoEstimado(nuevoCosto);
    }
 

    public void cancelarOrden(int numeroOrden) {
        OrdenServicio orden = buscarOrden(numeroOrden);
        listaOrdenes.remove(orden);
    }
 

    public List<OrdenServicio> consultarPorPlaca(String placa) {
        List<OrdenServicio> resultado = new ArrayList<>();
        for (OrdenServicio orden : listaOrdenes) {
            if (orden.getPlacaVehiculo().equalsIgnoreCase(placa)) {
                resultado.add(orden);
            }
        }
        return resultado;
    }
 

    public double calcularValorTotal() {
        double total = 0;
        for (OrdenServicio orden : listaOrdenes) {
            total += orden.getCostoEstimado();
        }
        return total;
    }
 

    public double calcularCostoPromedio() {
        if (listaOrdenes.isEmpty()) {
            return 0;
        }
        return calcularValorTotal() / listaOrdenes.size();
    }
 

    public OrdenServicio obtenerOrdenMayorCosto() {
        if (listaOrdenes.isEmpty()) {
            throw new NoSuchElementException("No hay órdenes registradas actualmente.");
        }
        OrdenServicio mayor = listaOrdenes.get(0);
        for (OrdenServicio orden : listaOrdenes) {
            if (orden.getCostoEstimado() > mayor.getCostoEstimado()) {
                mayor = orden;
            }
        }
        return mayor;
    }
 

    public int cantidadOrdenes() {
        return listaOrdenes.size();
    }
 

    private boolean existeOrden(int numeroOrden) {
        for (OrdenServicio orden : listaOrdenes) {
            if (orden.getNumeroOrden() == numeroOrden) {
                return true;
            }
        }
        return false;
    }
}