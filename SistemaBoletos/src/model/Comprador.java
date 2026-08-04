package model;

public class Comprador {
    private String nombre;
    private String correo;
    private int cantidad;
    private float presupuesto;

    public Comprador(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getCorreo() {
        return this.correo;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public float getPresupuesto() {
        return this.presupuesto;
    }

    public void setCantidadYPresupuesto(int cantidad, float presupuesto) {
        this.cantidad = cantidad;
        this.presupuesto = presupuesto;
    }
}