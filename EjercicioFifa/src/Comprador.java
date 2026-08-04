public class Comprador {

    private String nombre;
    private String email;
    private int cantidadBoletos;
    private float presupuestoMax;

    public Comprador(String nombre, String email, int cantidadBoletos, float presupuestoMax) {
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

    public float getPresupuestoMax() {
        return presupuestoMax;
    }
}