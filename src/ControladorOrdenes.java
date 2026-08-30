import java.util.ArrayList;
import java.util.List;
public class ControladorOrdenes {
    //Array dinamico de Ordenes. :O
    private List<OrdenServicio> ordenes; //No existe limite fijo, no se cuantas ordenes voy a tener
    //Inicializo la coleccion
    public ControladorOrdenes(){
        ordenes= new ArrayList<>();

    }

    //Validar numero de orden
    private boolean numeroOrdenExiste(int numeroOrden) {

        for (OrdenServicio orden : ordenes) {

            if (orden.getNumeroOrden() == numeroOrden) {
                return true;
            }
        }

        return false;
    }

    //Validar orden
    private boolean validarOrden(OrdenServicio orden) {

        if (orden.getNombrePropietario().isEmpty()) {
            return false;
        }

        if (orden.getPlacaVehiculo().isEmpty()) {
            return false;
        }

        if (orden.getDescripcionServicio().isEmpty()) {
            return false;
        }

        if (orden.getCostoEstimado() <= 0) {
            return false;
        }

        return true;
    }

    //Registrar orden
    public boolean registrarOrden(OrdenServicio orden) {

        if (!validarOrden(orden)) {
            return false;
        }

        if (numeroOrdenExiste(orden.getNumeroOrden())) { 
            return false;
        }

        ordenes.add(orden);

        return true;
    }

    public OrdenServicio buscarOrden(int numeroOrden){
        for (OrdenServicio orden: ordenes){
             if (orden.getNumeroOrden() == numeroOrden) {
            return orden;
            }
        }

        return null;
    }

    public boolean modificarOrden(int numeroOrden, String descripcion, double costo) {

        OrdenServicio orden = buscarOrden(numeroOrden);

        if (orden == null) {
            return false;
        }

        if (descripcion.isEmpty() || costo <= 0) {
            return false;
        }

        orden.setDescripcionServicio(descripcion);
        orden.setCostoEstimado(costo);

        return true;
    }
    public boolean cancelarOrden(int numeroOrden) {

        OrdenServicio orden = buscarOrden(numeroOrden);

        if (orden == null) {
            return false;
        }

        ordenes.remove(orden);

        return true;
    }

    public List<OrdenServicio> buscarPorPlaca(String placa) {

        List<OrdenServicio> coincidencias = new ArrayList<>();

        for (OrdenServicio orden : ordenes) {

            if (orden.getPlacaVehiculo().equalsIgnoreCase(placa)) {
                coincidencias.add(orden);
            }
        }

        return coincidencias;
    }

    public List<OrdenServicio> obtenerOrdenes() {
        return ordenes;
    }
    
    public double calcularCostoTotal() {

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

        return calcularCostoTotal() / ordenes.size();
    }

    public OrdenServicio obtenerOrdenMayorCosto() {

        if (ordenes.isEmpty()) {
            return null;
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
