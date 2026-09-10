package model;

public class Localidad {

    private String nombre;
    private double precio;
    private final int capacidadMax;
    private int boletosVendidos;

    public Localidad(String nombre, double precio, int capacidadMax) {
        this.nombre = nombre;
        this.precio = precio;
        this.capacidadMax = capacidadMax;
        this.boletosVendidos = 0;
    }

    public int getDisponibles() {
        return capacidadMax - boletosVendidos;
    }

    public boolean espacioDisponible() {
        return getDisponibles() > 0;
    }

    public int ventaBoletos(int cantidad) {
        int aVender = Math.min(cantidad, getDisponibles());
        boletosVendidos += aVender;
        return aVender;
    }

    // Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public int getBoletosVendidos() {
        return boletosVendidos;
    }

    public void setBoletosVendidos(int boletosVendidos) {
        this.boletosVendidos = boletosVendidos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}