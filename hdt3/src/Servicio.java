public class Servicio {
    private int numOrden;
    private String namePropietario;
    private String placaVehiculo;
    private String descripcionServicio;
    private double costoEstimado;

    public Servicio(int numeroOrden, String nombrePropietario, String placaVehiculo, String descripcionServicio, double costoEstimado) {
        this.numOrden = numeroOrden;
        this.namePropietario = nombrePropietario;
        this.placaVehiculo = placaVehiculo;
        this.descripcionServicio = descripcionServicio;
        this.costoEstimado = costoEstimado;
    }

    public int getNumOrden() {
        return numOrden;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public double getCostoEstimado() {
        return costoEstimado;
    }

    public void setDescripcionServicios(String nuevaDescripcion) {
        this.descripcionServicio = nuevaDescripcion;
    }

    public void setCostoEstimado(double nuevoCosto) {
        this.costoEstimado = nuevoCosto;
    }

    @Override
    public String toString() {
        return "Orden #" + numOrden + " | Propietario: " + namePropietario + 
               " | Placa: " + placaVehiculo + " | Servicio: " + descripcionServicio + 
               " | Costo: Q" + costoEstimado;
    }
}