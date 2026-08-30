public class OrdenServicio {
    //Atributos
    private int numeroOrden;
    private String nombrePropietario;
    private String placaVehiculo;
    private String descripcionServicio;
    private double costoEstimado;

    public OrdenServicio(int numeroOrden, String nombrePropietario, String palacaVehiculo, String descripcionServicio, double costoEstimado ){
        this.numeroOrden= numeroOrden;
        this.nombrePropietario= nombrePropietario;
        this.placaVehiculo= placaVehiculo;
        this. descripcionServicio= descripcionServicio;
        this.costoEstimado= costoEstimado; 
    }
    
    //Getters
    public int getNumeroOrden(){
        return numeroOrden;

    }

    public String getNombrePropietario(){
        return nombrePropietario;
    }

    public String getPlacaVehiculo(){
        return placaVehiculo;
    }

    public String getDescripcionServicio(){
        return descripcionServicio;
    }

    public double getCostoEstimado(){
        return costoEstimado;
    }


    // Setters
    public void setDescripcionServicio(String descripcion) {
        this.descripcionServicio = descripcion;
    }

    public void setCostoEstimado(double costo) {
        this.costoEstimado = costo;
}
}
