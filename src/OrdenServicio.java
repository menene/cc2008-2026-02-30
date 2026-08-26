public class OrdenServicio {
    private int numeroOrden;
    private String nombrePropietario;
    private String placaVehiculo;
    private String descripcionServicio;
    private double costoEstimado;

    public OrdenServicio(
            int numeroOrden,
            String nombrePropietario,
            String placaVehiculo,
            String descripcionServicio,
            double costoEstimado) {

        validarTexto(nombrePropietario, "nombre del propietario");
        validarTexto(placaVehiculo, "placa del vehículo");
        validarTexto(descripcionServicio, "descripción del servicio");

        if (costoEstimado <= 0) {
            throw new IllegalArgumentException(
                    "El costo estimado debe ser mayor que cero.");
        }

        this.numeroOrden = numeroOrden;
        this.nombrePropietario = nombrePropietario.trim();
        this.placaVehiculo = placaVehiculo.trim();
        this.descripcionServicio = descripcionServicio.trim();
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
        validarTexto(descripcionServicio, "descripción del servicio");
        this.descripcionServicio = descripcionServicio.trim();
    }

    public void setCostoEstimado(double costoEstimado) {
        if (costoEstimado <= 0) {
            throw new IllegalArgumentException(
                    "El costo estimado debe ser mayor que cero.");
        }

        this.costoEstimado = costoEstimado;
    }

    private void validarTexto(String valor, String nombreCampo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El campo " + nombreCampo + " no puede estar vacío.");
        }
    }

    @Override
    public String toString() {
        return "Número de orden: " + numeroOrden
                + "\nPropietario: " + nombrePropietario
                + "\nPlaca: " + placaVehiculo
                + "\nServicio: " + descripcionServicio
                + String.format("\nCosto estimado: Q%.2f", costoEstimado);
    }
}