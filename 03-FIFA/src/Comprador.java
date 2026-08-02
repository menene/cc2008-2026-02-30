public class Comprador {

    // Atributos
    private String nombre;
    private String email;
    private int cantidadTickets;
    private double presupuestoMaximo;

    // Constructor
    public Comprador() {
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getCantidadTickets() {
        return cantidadTickets;
    }

    public double getPresupuestoMaximo() {
        return presupuestoMaximo;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCantidadTickets(int cantidadTickets) {
        this.cantidadTickets = cantidadTickets;
    }

    public void setPresupuestoMaximo(double presupuestoMaximo) {
        this.presupuestoMaximo = presupuestoMaximo;
    }
}