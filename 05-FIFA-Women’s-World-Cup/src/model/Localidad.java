package model;

public class Localidad {

    private int numero;
    private double precio;
    private int capacidad;
    private int vendidos;

    public Localidad(int numero, double precio) {
        this.numero = numero;
        this.precio = precio;
        this.capacidad = 20;
        this.vendidos = 0;
    }

    public int getNumero() {
        return numero;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getVendidos() {
        return vendidos;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setVendidos(int vendidos) {
        this.vendidos = vendidos;
    }

    public boolean hayEspacio() {
        return vendidos < capacidad;
    }

    public int getDisponibles() {
        return capacidad - vendidos;
    }

    public int cantidadDisponibleParaVenta(int cantidadSolicitada) {

        if (!hayEspacio()) {
            return 0;
        }

        return Math.min(cantidadSolicitada, getDisponibles());
    }

    public void venderBoletos(int cantidad) {
        vendidos += cantidad;
    }

    public double getIngresos() {
        return vendidos * precio;
    }
}