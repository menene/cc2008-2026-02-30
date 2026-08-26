import java.util.ArrayList;
import java.util.List;

public class Taller{
    private ArrayList<OrdenServicio> ordenes;

    public Taller(){
        ordenes = new ArrayList<OrdenServicio>();
    }

    public void registrarOrden(OrdenServicio orden) throws Exception{

        if (buscarOrden(orden.obtenerNumeroOrden()) != null) {
            throw new Exception("El numero de orden ya existe.");
        }

        ordenes.add(orden);
    }

    public OrdenServicio buscarOrden(int numeroOrden){
        for (OrdenServicio orden: ordenes){
            if (orden.obtenerNumeroOrden()==numeroOrden){
                return orden;
            }
        }
        return null;
    }
    public void modificarOrden(int numeroOrden, String servicio, double costoEstimado) throws Exception {
        OrdenServicio orden = buscarOrden(numeroOrden);
        if (orden == null){
           throw new Exception("la orden no existe, prueba d neuvo");
        }
        if (servicio.isEmpty()){
            throw new Exception("El servicio no puede estar vacio");
        }
        if (costoEstimado <= 0){
            throw new Exception("El costo debe ser mayor a 0");
        }
        orden.modificar(servicio,costoEstimado);
    }
    public void cancelarOrden(int numeroOrden) throws Exception{
        OrdenServicio orden = buscarOrden(numeroOrden);

        if (orden == null){
            throw new Exception("La orden no existe");
        }

        ordenes.remove(orden);
    }
    public ArrayList<OrdenServicio> buscarPorPlaca(String placa){
        ArrayList<OrdenServicio> resultados = new ArrayList<OrdenServicio>();

        for (OrdenServicio orden : ordenes) {

            if (orden.obtenerPlacaVehiculo().equalsIgnoreCase(placa)) {
                resultados.add(orden);
            }
        }

        return resultados;
    }
    public double calcularCostoTotal() {
        double total = 0;

        for (OrdenServicio orden : ordenes){
            total += orden.obtenerCostoEstimado();
        }
        return total;
    }

    public OrdenServicio obtenerOrdenMayorCosto(){
        if (ordenes.isEmpty()){
            return null;
        }

        OrdenServicio mayor = ordenes.get(0);

        for (OrdenServicio orden: ordenes){

            if (orden.obtenerCostoEstimado() > mayor.obtenerCostoEstimado()){

                mayor = orden;
            }
        }
        return mayor;

    }
    public int obtenercantidadOrdenes(){
        return ordenes.size();
    }
    public ArrayList<OrdenServicio> consultarOrdenes(){
        return ordenes;
    }

    public double calcularCostoPromedio(){
        if (ordenes.isEmpty()){
            return 0;
        }
        return calcularCostoTotal()/ordenes.size();
    }

}