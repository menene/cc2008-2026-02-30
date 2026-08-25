public class OrdenServicio {
    private int numeroOrden;
    private String nombrePropietario;
    private String placaVehiculo;
    private String descripcionServicio;
    private double costoEstimado;

    public OrdenServicio(int numeroOrden, String nombrePropietario,
            String placaVehiculo, String descripcionServicio,
            double costoEstimado) {

        if (!validarTexto(nombrePropietario)) {
            throw new IllegalArgumentException(
                    "El nombre del propietario no puede estar vacío.");
        }
        if (!validarTexto(placaVehiculo)) {
            throw new IllegalArgumentException(
                    "La placa del vehículo no puede estar vacía.");
        }
        if (!validarTexto(descripcionServicio)) {
            throw new IllegalArgumentException(
                    "La descripción del servicio no puede estar vacía.");
        }
        if (!validarCosto(costoEstimado)) {
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

    public void setDescripcionServicio(String nuevaDescripcion) {
        if (!validarTexto(nuevaDescripcion)) {
            throw new IllegalArgumentException(
                    "La descripción del servicio no puede estar vacía.");
        }
        this.descripcionServicio = nuevaDescripcion.trim();
    }

    public void setCostoEstimado(double nuevoCosto) {
        if (!validarCosto(nuevoCosto)) {
            throw new IllegalArgumentException(
                    "El costo estimado debe ser mayor que cero.");
        }
        this.costoEstimado = nuevoCosto;
    }

    private boolean validarTexto(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    private boolean validarCosto(double costo) {
        return costo > 0;
    }

    @Override
    public String toString() {
        return "Número de orden: " + numeroOrden
                + "\nPropietario: " + nombrePropietario
                + "\nPlaca: " + placaVehiculo
                + "\nServicio: " + descripcionServicio
                + "\nCosto estimado: Q"
                + String.format("%.2f", costoEstimado);
    }
}