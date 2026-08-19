public class Comprador {
    private String nombre;
    private String email;
    private int cantidadBoletos;
    private double presupuesto;
    private Ticket ticketAsignado;

    public Comprador(String nombre, String email, int cantidadBoletos, double presupuesto) {
        this.nombre = nombre;
        this.email = email;
        this.cantidadBoletos = cantidadBoletos;
        this.presupuesto = presupuesto;
    }

    public boolean tienePresupuestoSuficiente(double costoTotal) {
        return this.presupuesto >= costoTotal;
    }

    public boolean puedePagar(double costoTotal) {
        return tienePresupuestoSuficiente(costoTotal);
    }

    public void descontarPresupuesto(double costoTotal) {
        this.presupuesto -= costoTotal;
    }

    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public int getCantidadBoletos() { return cantidadBoletos; }
    public double getPresupuesto() { return presupuesto; }
    public void setPresupuesto(double presupuesto) { this.presupuesto = presupuesto; }

    public Ticket getTicketAsignado() { return ticketAsignado; }
    public void setTicketAsignado(Ticket ticketAsignado) { this.ticketAsignado = ticketAsignado; }
}