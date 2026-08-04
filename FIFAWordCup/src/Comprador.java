public class Comprador {
    private String nombre;
    private String email;
    private int cantidadDeseada;
    private double presupuestoMaximo;

    public Comprador(String nombre, String email, int cantidadDeseada, double presupuestoMaximo) {
        this.nombre = nombre;
        this.email = email;
        this.cantidadDeseada = cantidadDeseada;
        this.presupuestoMaximo = presupuestoMaximo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getCantidadDeseada() {
        return cantidadDeseada;
    }

    public double getPresupuestoMaximo() {
        return presupuestoMaximo;
    }
}
