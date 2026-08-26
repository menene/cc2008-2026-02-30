public class Orden { 
    private int numeroOrden; 
    private String nombrePropietario;
    private String placaVehiculo; 
    private String infoServicio; 
    private double costoEstimado; 

    //constructor 
    public Orden(int numeroOrden, String nombrePropietario, String placaVehiculo, String infoServicio, double costoEstimado) {
        this.numeroOrden = numeroOrden; 
        this.nombrePropietario = nombrePropietario; 
        this.placaVehiculo = placaVehiculo;
        this.infoServicio = infoServicio; 
        this.costoEstimado = costoEstimado; 
    }

    public int getNumeroOrden() {
        return numeroOrden; 
        
    }

    public String getNombrePropietario() {
        if (nombrePropietario == null){
            throw new IllegalArgumentException("Debe ingresar el nombre del propietario");
        }
        return nombrePropietario; 
    }

    public String getPlacaVehiculo() {
        if (placaVehiculo == null){
            throw new IllegalArgumentException("Debe ingresar la placa del vehículo");
        }
        return placaVehiculo; 

    }

    public String getInfoServicio() {
        return infoServicio; 

    }

    public double getCostoEstimado() {
        return costoEstimado; 

    }

    public void setInfoServicio(String infoServicio) {
        if (infoServicio == null){
            throw new IllegalArgumentException("La descripción no puede quedar vacía"); 
        }

        this.infoServicio = infoServicio; 
    }

    public void setCostoEstimado(double costoEstimado) {
        if (costoEstimado <= 0){
            throw new IllegalArgumentException("El costo debe ser mayor a 0"); 
        }
        this.costoEstimado = costoEstimado; 
    }

}