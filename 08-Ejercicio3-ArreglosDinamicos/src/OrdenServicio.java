public class OrdenServicio {

    // Atributos
    private int numeroOrden;
    private String nombrePropietario;
    private String placaVehiculo;
    private String descripcionServicio;
    private double costoEstimado;

    // Constructor que inicializa todos los atributos de la clase y crea la orden con todos los datos iniciales.
    public OrdenServicio(int numeroOrden, String nombrePropietario,
            String placaVehiculo, String descripcionServicio,
            double costoEstimado) {
        this.numeroOrden = numeroOrden;
        this.nombrePropietario = nombrePropietario;
        this.placaVehiculo = placaVehiculo;
        this.descripcionServicio = descripcionServicio;
        this.costoEstimado = costoEstimado;
    }

    // Métodos de acceso (getters y setters)
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

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public void setCostoEstimado(double costoEstimado) {
        this.costoEstimado = costoEstimado;
    }

    //Método toString() que devuelve una representación en forma de cadena de la orden de servicio, incluyendo todos sus atributos.
    @Override
    public String toString() {
        return "Numero de orden: " + numeroOrden
                + "\nPropietario: " + nombrePropietario
                + "\nPlaca: " + placaVehiculo   
                + "\nServicio: " + descripcionServicio
                + String.format("\nCosto estimado: Q%.2f", costoEstimado);
    }
}