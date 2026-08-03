public class Comprador {
    //atributos
    private String nombre; 
    private String email;
    private int cantidadBoletos;
    private double presupuestoMaximo;
    private int ticket;

    //constructor
    public Comprador(String nombre, String email, int cantidadBoletos, double presupuestoMaximo) {
        this.nombre = nombre;
        this.email = email;
        this.cantidadBoletos = cantidadBoletos;
        this.presupuestoMaximo = presupuestoMaximo;
        this.ticket = 0;
    }

    //getters
    public String getNombre(){
        return nombre;
    }
    public String getEmail(){
        return email;
    }
    public int getCantidadBoletos() {
    return cantidadBoletos;
    }

    public double getPresupuestoMaximo() {
        return presupuestoMaximo;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket){
        this.ticket= ticket;
    }

}
