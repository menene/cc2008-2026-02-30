public class OrdenServicio {

    private int numeroOrden;
    private String nombrePropietario;
    private String placaVehiculo;
    private String descripcionServicio;
    private double costoEstimado;

    public OrdenServicio(int numeroOrden, String nombrePropietario, String placaVehiculo, String descripcionServicio, double costoEstimado){

        this.numeroOrden = numeroOrden;
        this.nombrePropietario = nombrePropietario;
        this.placaVehiculo = placaVehiculo;
        this.descripcionServicio = descripcionServicio;
        this.costoEstimado = costoEstimado;
    }

    public int getNumeroOrden() {

        return numeroOrden;
    }

    public String getNombrePropietario() {

        return nombrePropietario;
    }

    public String getPlacaVehiculo() {

        return placaVehiculo;
    }

    public String getDescripcionServicio() {

        return descripcionServicio;
    }

    public double getCostoEstimado() {

        return costoEstimado;
    }

    public boolean modificarServicio(String nuevaDescripcion, double nuevoCosto) {

        if (nuevaDescripcion.equals("")) {
        return false;
        }

        if (nuevoCosto <= 0) {
        return false;
        }

        descripcionServicio = nuevaDescripcion;
        costoEstimado = nuevoCosto;

        return true;
    }

}