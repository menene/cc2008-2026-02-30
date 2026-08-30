package controller;
 
import model.OrdenServicio;
 
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
 
public class OrdenController {
 
    private List<OrdenServicio> ordenes;
 
    public OrdenController() {
        this.ordenes = new ArrayList<>();
    }
 
    public void registrarOrden(int numeroOrden, String propietario, String placa,
                                String descripcion, double costo) {
        for (OrdenServicio orden : ordenes) {
            if (orden.getNumeroOrden() == numeroOrden) {
                throw new IllegalArgumentException(
                        "Ya existe una orden registrada con el número " + numeroOrden + ".");
            }
        }
        OrdenServicio nuevaOrden = new OrdenServicio(numeroOrden, propietario, placa, descripcion, costo);
        ordenes.add(nuevaOrden);
    }
 
    public OrdenServicio buscarPorNumero(int numeroOrden) {
        for (OrdenServicio orden : ordenes) {
            if (orden.getNumeroOrden() == numeroOrden) {
                return orden;
            }
        }
        throw new NoSuchElementException("No existe una orden registrada con el número " + numeroOrden + ".");
    }
 
    public void modificarOrden(int numeroOrden, String nuevaDescripcion, double nuevoCosto) {
        OrdenServicio orden = buscarPorNumero(numeroOrden);
        orden.setDescripcionServicio(nuevaDescripcion);
        orden.setCostoEstimado(nuevoCosto);
    }
 
    public void cancelarOrden(int numeroOrden) {
        OrdenServicio orden = buscarPorNumero(numeroOrden);
        ordenes.remove(orden);
    }
 
    public List<OrdenServicio> consultarPorPlaca(String placa) {
        List<OrdenServicio> coincidencias = new ArrayList<>();
        for (OrdenServicio orden : ordenes) {
            if (orden.getPlaca().equalsIgnoreCase(placa)) {
                coincidencias.add(orden);
            }
        }
        return coincidencias;
    }
 
    public List<OrdenServicio> listarOrdenes() {
        return new ArrayList<>(ordenes);
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
            throw new IllegalStateException("No hay órdenes registradas para calcular el promedio.");
        }
        return calcularValorTotal() / ordenes.size();
    }
 
    public OrdenServicio obtenerOrdenMayorCosto() {
        if (ordenes.isEmpty()) {
            throw new IllegalStateException("No hay órdenes registradas.");
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