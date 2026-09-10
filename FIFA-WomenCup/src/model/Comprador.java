package model;

public class Comprador {
    private String nombre;
    private String email;
    private int cantidadBoletos;
    private double presupuestoMax;

    public Comprador(String nombre, String email, int cantidadBoletos, double presupuestoMax) {
        this.nombre = nombre;
        this.email = email;
        this.cantidadBoletos = cantidadBoletos;
        this.presupuestoMax = presupuestoMax;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    public double getPresupuestoMax() {
        return presupuestoMax;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }


    public void setPresupuestoMax(double presupuestoMax) {
        this.presupuestoMax = presupuestoMax;
    }

    @Override
    public String toString() {
        return "Comprador{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", cantidadBoletos=" + cantidadBoletos +
                ", presupuestoMax=" + presupuestoMax +
                '}';
    }
}