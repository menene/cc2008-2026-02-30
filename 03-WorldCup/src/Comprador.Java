public class Comprador{
    private Ticket Ticket;
    private String Nombre;
    private String Mail;
    private byte CantidadBoletos;
    private float Presupuesto;

    public Comprador(String n, String m, byte c, float p){
        this.Nombre=n;
        this.Mail=m;
        this.CantidadBoletos=c;
        this.Presupuesto=p;
    }
    public void generarTicket(){
        this.Ticket= new Ticket();
        double random_double= Math.random();
        int random_int = (int)(random_double*30000);
        this.Ticket.NunmeroTicket= random_int;

    }

    public String getNombre(){
        return this.Nombre;
    
    }
    public String getCorreo(){
        return this.Mail;
    }
    public byte getCantidadBoletos(){
        return this.CantidadBoletos;
    }
    public Ticket getTicket(){
        return this.Ticket;
    }

    public float getPresupuesto(){ 
        return this.Presupuesto; 
    }


    

}