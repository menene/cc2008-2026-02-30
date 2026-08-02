public class Comprador {
    private String nombreComprador;
    private String email;
    private int cantidadBoletos;
    private double presupuestoMaximo;
    private Ticket ticket;

    //Constructor
    public Comprador(String nombreComprador, String email, int cantidadBoletos, double presupuestoMaximo) {
        this.nombreComprador = nombreComprador;
        this.email = email;
        this.cantidadBoletos = cantidadBoletos;
        this.presupuestoMaximo = presupuestoMaximo;
        this.ticket = new Ticket();
    }

    public String getNombreComprador() {
        return nombreComprador;
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

    public Ticket getTicket() {
        return ticket;
    }
}