public class Orden {
    private int numeroOrden;
    private String nombrePropietario;
    private String placa;
    private String descripcionServicio;
    private double costoEstimado;

    public Orden(int numeroOrden, String nombrePropietario, String placa, String descripcionServicio, double costoEstimado) {
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

    public String mostrarInformacion() {
    return "Número de orden: " + numeroOrden + "\nPropietario: " + nombrePropietario + "\nPlaca: " + placa 
    + "\nDescripción del servicio: " + descripcionServicio + "\nCosto estimado: Q" + String.format("%.2f", costoEstimado);
    }
}