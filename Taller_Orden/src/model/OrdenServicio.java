package model;
 
public class OrdenServicio {
 
    private int numeroOrden;
    private String propietario;
    private String placa;
    private String descripcionServicio;
    private double costoEstimado;
 
    public OrdenServicio(int numeroOrden, String propietario, String placa,
                          String descripcionServicio, double costoEstimado) {
        if (propietario == null || propietario.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del propietario no puede estar vacío.");
        }
        if (placa == null || placa.trim().isEmpty()) {
            throw new IllegalArgumentException("La placa del vehículo no puede estar vacía.");
        }
        if (descripcionServicio == null || descripcionServicio.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción del servicio no puede estar vacía.");
        }
        if (costoEstimado <= 0) {
            throw new IllegalArgumentException("El costo estimado debe ser mayor que 0.");
        }
 
        this.numeroOrden = numeroOrden;
        this.propietario = propietario;
        this.placa = placa;
        this.descripcionServicio = descripcionServicio;
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
 
    public String getDescripcionServicio() {
        return descripcionServicio;
    }
 
    public double getCostoEstimado() {
        return costoEstimado;
    }
 
    public void setDescripcionServicio(String nuevaDescripcion) {
        if (nuevaDescripcion == null || nuevaDescripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción del servicio no puede estar vacía.");
        }
        this.descripcionServicio = nuevaDescripcion;
    }
 
    public void setCostoEstimado(double nuevoCosto) {
        if (nuevoCosto <= 0) {
            throw new IllegalArgumentException("El costo estimado debe ser mayor que 0.");
        }
        this.costoEstimado = nuevoCosto;
    }
 
    @Override
    public String toString() {
        return "Orden #" + numeroOrden
                + "\n  Propietario    : " + propietario
                + "\n  Placa          : " + placa
                + "\n  Descripción    : " + descripcionServicio
                + "\n  Costo estimado : Q" + String.format("%.2f", costoEstimado);
    }
}