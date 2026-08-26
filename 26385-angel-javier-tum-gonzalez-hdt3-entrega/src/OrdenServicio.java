public class OrdenServicio {
    private int numeroOrden;
    private String nombreCliente;
    private String placaVehiculo;
    private String descripcionServicio;
    private double costoEstimado;

    public OrdenServicio() {
    }

    public OrdenServicio(int numeroOrden, String nombreCliente, String placaVehiculo,
                        String descripcionServicio, double costoEstimado) {
        this.numeroOrden = numeroOrden;
        this.nombreCliente = nombreCliente;
        this.placaVehiculo = placaVehiculo;
        this.descripcionServicio = descripcionServicio;
        this.costoEstimado = costoEstimado;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
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
        return "OrdenServicio{" +
                "numeroOrden=" + numeroOrden +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", placaVehiculo='" + placaVehiculo + '\'' +
                ", descripcionServicio='" + descripcionServicio + '\'' +
                ", costoEstimado=" + costoEstimado +
                '}';
    }
}
