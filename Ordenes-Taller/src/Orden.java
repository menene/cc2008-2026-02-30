public class Orden {

    private int noOrden;
    private String nombre;
    private String placa;
    private String servicio;
    private double costo;

    public Orden(
            int noOrden,
            String nombre,
            String placa,
            String descripcion,
            double costo
    ) {
        this.noOrden = noOrden;
        this.nombre = nombre;
        this.placa = placa;
        this.servicio = descripcion;
        this.costo = costo;
    }

    public int getNoOrden() {
        return noOrden;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPlaca() {
        return placa;
    }

    public String getDescripcion() {
        return servicio;
    }

    public double getCosto() {
        return costo;
    }

    public void setDescripcion(String nuevaDescripcion) {
        this.servicio = nuevaDescripcion;
    }

    public void setCosto(double nuevoCosto) {
        this.costo = nuevoCosto;
    }

    @Override
    public String toString() {
        return "Número de orden: " + noOrden
                + "\nPropietario: " + nombre
                + "\nPlaca: " + placa
                + "\nServicio: " + servicio
                + "\nCosto estimado: Q"
                + String.format("%.2f", costo);
    }
}