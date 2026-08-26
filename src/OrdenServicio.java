public class OrdenServicio {
    private int numeroOrden;
    private String nombrePropietario;
    private String placaVehiculo;
    private String descripcionServicio;
    private double costoEstimado;

    public OrdenServicio(int numeroOrden, String nombrePropietario, String placaVehiculo, String descripcionServicio,
            double costoEstimado) {

        if (numeroOrden <= 0) {
            throw new IllegalArgumentException("El número de orden debe de ser mayor a cero.");
        }

        if (nombrePropietario == null || nombrePropietario.isEmpty()) {
            throw new IllegalArgumentException("El nombre del propietario es obligatorio.");
        }

        if (placaVehiculo == null || placaVehiculo.isEmpty()) {
            throw new IllegalArgumentException("La placa del vehículo es obligatoria.");
        }

        if (descripcionServicio == null || descripcionServicio.isEmpty()) {
            throw new IllegalArgumentException("La descripción del servicio es obligatoria.");
        }

        if (costoEstimado < 0) {
            throw new IllegalArgumentException("El costo estimado no puede ser negativo.");
        }

        this.numeroOrden = numeroOrden;
        this.nombrePropietario = nombrePropietario;
        this.placaVehiculo = placaVehiculo.toUpperCase();
        this.descripcionServicio = descripcionServicio;
        this.costoEstimado = costoEstimado;
    }

    public int getNumeroOrden() {
        return this.numeroOrden;
    }

    public String getNombrePropietario() {
        return this.nombrePropietario;
    }

    public String getPlacaVehiculo() {
        return this.placaVehiculo;
    }

    public String getDescripcionServicio() {
        return this.descripcionServicio;
    }

    public double getCostoEstimado() {
        return this.costoEstimado;
    }

    public void actualizarServicio(String nuevaDescripcion, double nuevoCosto) {
        if (nuevaDescripcion == null || nuevaDescripcion.isEmpty()) {
            throw new IllegalArgumentException("La descripción del servicio es obligatoria.");
        }

        if (nuevoCosto < 0) {
            throw new IllegalArgumentException("El costo estimado no puede ser negativo.");
        }

        this.descripcionServicio = nuevaDescripcion;
        this.costoEstimado = nuevoCosto;
    }
}
