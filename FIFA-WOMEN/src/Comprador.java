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
        return this.nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public int getCantidadBoletos() {
        return this.cantidadBoletos;
    }

    public double getPresupuestoMaximo() {
        return this.presupuestoMaximo;
    }
}
