/* Clase de la orden de servicio. Guarda los datos de un solo trabajo del taller. */
public class OrdenServicio {

    private int numeroOrden;
    private String propietario;
    private String placa;
    private String descripcion;
    private double costoEstimado;

    /* Constructor. Recibe los cinco datos para que no se pueda crear una orden a medias */
    public OrdenServicio(int numeroOrden, String propietario, String placa,
                         String descripcion, double costoEstimado) {
        this.numeroOrden = numeroOrden;
        this.propietario = propietario;
        this.placa = placa;
        this.descripcion = descripcion;
        this.costoEstimado = costoEstimado;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public String getPropietario() {
        return propietario;
    }

    public String getPlaca() {
        return placa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCostoEstimado() {
        return costoEstimado;
    }

    /* Actualiza el detalle del trabajo cuando el diagnostico del vehiculo cambia */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /* Actualiza el costo cuando se ajusta el precio del servicio */
    public void setCostoEstimado(double costoEstimado) {
        this.costoEstimado = costoEstimado;
    }

    /* Presenta los datos de la orden en una sola linea ordenada */
    @Override
    public String toString() {
        return "Orden #" + numeroOrden
             + " | Propietario: " + propietario
             + " | Placa: " + placa
             + " | Descripcion: " + descripcion
             + " | Costo estimado: Q" + String.format("%.2f", costoEstimado);
    }
}
