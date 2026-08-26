// Clase que representa una orden de servicio del taller
public class OrdenServicio {

    private int numeroOrden;
    private String nombrePropietario;
    private String placaVehiculo;
    private String descripcionServicio;
    private double costoEstimado;

    // Constructor: recibe los datos y los guarda en el objeto
    public OrdenServicio(int numeroOrden, String nombrePropietario, String placaVehiculo,
                          String descripcionServicio, double costoEstimado) {
        this.numeroOrden = numeroOrden;
        this.nombrePropietario = nombrePropietario;
        this.placaVehiculo = placaVehiculo;
        this.descripcionServicio = descripcionServicio;
        this.costoEstimado = costoEstimado;
    }

    // Getters
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

    // Setters (solo de lo que se puede modificar)
    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public void setCostoEstimado(double costoEstimado) {
        this.costoEstimado = costoEstimado;
    }

    // Muestra la informacion de la orden en un solo texto
    public String toString() {
        return "Orden #" + numeroOrden + " - Propietario: " + nombrePropietario
                + " - Placa: " + placaVehiculo + " - Servicio: " + descripcionServicio
                + " - Costo: Q" + costoEstimado;
    }
}
