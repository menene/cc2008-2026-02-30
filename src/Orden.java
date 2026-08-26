public class Orden {

    // Atributos
    private int numeroOrden;
    private String nombrePropietario;
    private String placa;
    private String descripcion;
    private double costoEstimado;

    // Constructor
    public Orden(int numeroOrden, String nombrePropietario, String placa, String descripcion, double costoEstimado) {
        this.numeroOrden = numeroOrden;
        this.nombrePropietario = nombrePropietario;
        this.placa = placa;
        this.descripcion = descripcion;
        this.costoEstimado = costoEstimado;
    }

    // Métodos

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public String getPlaca() {
        return placa;
    }

    public double getCostoEstimado() {
        return costoEstimado;
    }

    public void setDescripcionServicio(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCostoEstimado(double costoEstimado) {
        this.costoEstimado = costoEstimado;
    }

    // se sobreescribe el método toString para tener una manera de representar la órden
    @Override
    public String toString() {
        return String.format(
            "Número de orden: %d%n" +
            "Propietario: %s%n" +
            "Placa: %s%n" +
            "Servicio: %s%n" +
            "Costo estimado: Q%.2f",
            numeroOrden,
            nombrePropietario,
            placa,
            descripcion,
            costoEstimado
        );
    }
}