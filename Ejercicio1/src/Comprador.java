public class Comprador {
    private String nombre;
    private String email;
    private int cantidadBoletos;
    private double presupuestoMaximo;

    public Comprador(String nombre, String email, int cantidadBoletos, double presupuestoMaximo) {
        this.nombre = nombre;
        this.email = email;
        this.cantidadBoletos = cantidadBoletos;
        this.presupuestoMaximo = presupuestoMaximo;
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

    public double getPresupuestoMaximo() {
        return presupuestoMaximo;
    }
}
