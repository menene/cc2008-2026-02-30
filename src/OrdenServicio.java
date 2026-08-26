public class OrdenServicio {

    private int numeroOrden;
    private String nombrePropietario;
    private String placa;
    private String descripcionServicio;
    private double costoEstimado;

    public OrdenServicio(int numeroOrden, String nombrePropietario, String placa,
                          String descripcionServicio, double costoEstimado) {
        this.numeroOrden = numeroOrden;
        this.nombrePropietario = nombrePropietario;
        this.placa = placa;
        this.descripcionServicio = descripcionServicio;
        this.costoEstimado = costoEstimado;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public String getPlaca() {
        return placa;
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
        return "Orden #" + numeroOrden
                + " | Propietario: " + nombrePropietario
                + " | Placa: " + placa
                + " | Servicio: " + descripcionServicio
                + " | Costo estimado: Q" + costoEstimado;
    }
}