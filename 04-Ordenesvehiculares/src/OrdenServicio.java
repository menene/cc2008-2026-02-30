public class OrdenServicio{
    private int numeroOrden;
    private String nombrePropietario;
    private String servicio;
    private String placaVehiculo;
    private double costoEstimado;

    public OrdenServicio(int numeroOrden, String nombrePropietario, String placaVehiculo, String servicio, double costoEstimado){
        this.numeroOrden = numeroOrden;
        this.nombrePropietario = nombrePropietario;
        this.placaVehiculo = placaVehiculo;
        this.servicio = servicio;
        this.costoEstimado = costoEstimado;
    }

    public int obtenerNumeroOrden(){
        return numeroOrden;
    }
    public String obtenerPlacaVehiculo(){
        return placaVehiculo;
    }
    public double obtenerCostoEstimado(){
        return costoEstimado;
    }

    public void modificar(String servicio, double costoEstimado){
        this.servicio = servicio;
        this.costoEstimado = costoEstimado;
    }
    public String toString() {
        return "Numero de orden: " + numeroOrden
                + "\nPropietario: " + nombrePropietario
                + "\nPlaca: " + placaVehiculo
                + "\nServicio: " + servicio
                + "\nCosto estimado: Q" + costoEstimado;
    }
}