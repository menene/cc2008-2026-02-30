public class OrdenServicio {
    private int numeroOrden;
    private String nombrePropietario;
    private String placaVehiculo;
    private String descripcionServicio;
    private double costoEstimado;

    public OrdenServicio(int numeroOrden, String nombrePropietario,
            String placaVehiculo, String descripcionServicio,
            double costoEstimado) {

        if (nombrePropietario == null || nombrePropietario.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre del propietario no puede estar vacio.");
        }

        if (placaVehiculo == null || placaVehiculo.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La placa del vehiculo no puede estar vacia.");
        }

        if (descripcionServicio == null
                || descripcionServicio.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La descripcion del servicio no puede estar vacia.");
        }

        if (costoEstimado <= 0) {
            throw new IllegalArgumentException(
                    "El costo estimado debe ser mayor que cero.");
        }

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

    public double getCostoEstimado() {
        return costoEstimado;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        if (descripcionServicio == null
                || descripcionServicio.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La descripcion del servicio no puede estar vacia.");
        }

        this.descripcionServicio = descripcionServicio;
    }

    public void setCostoEstimado(double costoEstimado) {
        if (costoEstimado <= 0) {
            throw new IllegalArgumentException(
                    "El costo estimado debe ser mayor que cero.");
        }

        this.costoEstimado = costoEstimado;
    }
}
