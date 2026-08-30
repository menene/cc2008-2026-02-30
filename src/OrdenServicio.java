public class OrdenServicio {
    private int numeroOrden;
    private String propietario;
    private String placa;
    private String descripcionServicio;
    private double costoEstimado;

    //constructor
    public OrdenServicio(int numeroOrden, String propietario, String placa,
                         String descripcionServicio, double costoEstimado) {
        this.numeroOrden = numeroOrden;
        this.propietario = propietario;
        this.placa = placa;
        this.descripcionServicio = descripcionServicio;
        this.costoEstimado = costoEstimado;
    }

    //getters para las variables que los necesitn
    public int getNumeroOrden() {
        return numeroOrden;
    }

    public String getPropietario() {
        return propietario;
    }

    public String getPlaca() {
        return placa;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public double getCostoEstimado() {
        return costoEstimado;
    }

    //setter para los que necesitan
    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public void setCostoEstimado(double costoEstimado) {
        this.costoEstimado = costoEstimado;
    }

    //el override que basicamente sobre escribe para tener el toString como quiero
    @Override
    public String toString() {
        return "Número de orden: " + numeroOrden
                + "\nPropietario: " + propietario
                + "\nPlaca: " + placa
                + "\nDescripción del servicio: " + descripcionServicio
                + "\nCosto estimado: Q" + costoEstimado;
    }
}