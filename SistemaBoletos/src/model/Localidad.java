package model;

public class Localidad {
    private String nombre;
    private float precio;
    private int capacidad;
    private int boletosVendidos;
    
    public Localidad(String nombre, float precio, int capacidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.capacidad = capacidad;
        this.boletosVendidos = 0;
    }

    public String getNombre() {
        return this.nombre;
    }

    public float getPrecio() {
        return this.precio;
    }

    public int getBoletosVendidos() {
        return this.boletosVendidos;
    }

    public int getBoletosDisponibles() {
        return this.capacidad - this.boletosVendidos;
    }

    public void venderBoletos(int cantidad) {
        this.boletosVendidos += cantidad;
    }

    public float getGanancia() {
        return this.precio * this.boletosVendidos;
    }
}