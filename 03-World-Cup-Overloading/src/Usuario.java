public class Usuario {

    private String nombre;
    private String correo;
    private int cantidad;
    private float presupuesto;

    // Constructor
    public Usuario(String nombre, String correo, int cantidad, float presupuesto) {

        this.nombre = nombre;
        this.correo = correo;
        this.cantidad = cantidad;
        this.presupuesto = presupuesto;

    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getPresupuesto() {
        return presupuesto;
    }

}