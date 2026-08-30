public class Orden {
    private int numeroOrden;
    private String nombrePropietario;
    private String placa;
    private String descripcionServicio;
    private double costoEstimado;

public Orden(int numeroOrden, String nombrePropietario, String placa, String descripcionServicio, double costoEstimado) {
    if (nombrePropietario == null || nombrePropietario.trim().isEmpty()) {
        throw new IllegalArgumentException("El nombre del propietario no puede estar vacío.");
    }
    if (costoEstimado <= 0) {
        throw new IllegalArgumentException("El costo estimado debe ser mayor a 0.");
    }
    if (placa == null || placa.trim().isEmpty()) {
        throw new IllegalArgumentException("La placa no puede estar vacía.");
    }
    if (descripcionServicio == null || descripcionServicio.trim().isEmpty()) {
        throw new IllegalArgumentException("La descripción del servicio no puede estar vacía.");
    }

    this.numeroOrden = numeroOrden;
    this.nombrePropietario = nombrePropietario;
    this.placa = placa;
    this.descripcionServicio = descripcionServicio;
    this.costoEstimado = costoEstimado;
}

    public int getNumeroOrden() { return numeroOrden; }
    public String getNombrePropietario() { return nombrePropietario; }
    public String getPlaca() { return placa; }
    public String getDescripcionServicio() { return descripcionServicio; }
    public double getCostoEstimado() { return costoEstimado; }
    public void setDescripcionServicio(String descripcionServicio) { this.descripcionServicio = descripcionServicio; }
    public void setCostoEstimado(double costoEstimado) { this.costoEstimado = costoEstimado; }

    @Override
    public String toString() {
        return "Orden #" + numeroOrden + " | Placa: " + placa + " | Propietario: " + nombrePropietario + 
               " | Servicio: " + descripcionServicio + " | Costo: Q" + costoEstimado;
    }
}