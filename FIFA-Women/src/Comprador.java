public class Comprador {
    private String nombre;
    private String email;
    private double presupuesto;
    private int ticketsCompr;

    //todos los getters y setters del comprador
    public Comprador(String nombre, String email, int ticketsCompr, double presupuesto) 
    {
        this.nombre = nombre;
        this.email = email;
        this.ticketsCompr = ticketsCompr;
        this.presupuesto = presupuesto;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public double getPresupuesto() 
    {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) 
    {
        this.presupuesto = presupuesto;
    }

    public int getTicketsCompr() 
    {
        return ticketsCompr;
    }

    public void setTicketsCompr(int ticketsCompr) 
    {
        this.ticketsCompr = ticketsCompr;
    }
}