public class OrdenServicio {
    private int numeroOrden;
    private String nombrePropietario;
    private String placaVehiculo;
    private String descripcionServicio;
    private double costoEstimado;

    public OrdenServicio(int numeroOrden, String nombrePropietario, String placaVehiculo,
                         String descripcionServicio, double costoEstimado) {
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

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public double getCostoEstimado() {
        return costoEstimado;
    }

    public void setCostoEstimado(double costoEstimado) {
        this.costoEstimado = costoEstimado;
    }

    @Override
    public String toString() {
        return "Numero de orden: " + numeroOrden
                + "\nPropietario: " + nombrePropietario
                + "\nPlaca: " + placaVehiculo
                + "\nServicio: " + descripcionServicio
                + String.format("\nCosto estimado: Q%.2f", costoEstimado);
    }
}
