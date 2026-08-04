public class Comprador {

    private String nombre;
    private String email;
    private int cantidadBoletos;
    private float presupuestoMaximo;
    private int ticket;
    
    //constuctor vacio primero
    //solo para crearlo
    public Comprador() {
        
    }

    //constructor ya con parametros
    //este ya recibe info
    public Comprador(String nombre, String email, int cantidadBoletos, float presupuestoMaximo){
        this.nombre = nombre;
        this.email = email;
        this.cantidadBoletos = cantidadBoletos;
        this.presupuestoMaximo = presupuestoMaximo;
    }


    //getter del nombre
    public String getNombre() {
        return nombre;
    }    
    //setter de nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    //getter email
    public String getEmail() {
        return email;
    }
    //setter email
    public void setEmail(String email) {
        this.email = email;
    }

    //getter cantidadBoletos
    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    //setter cantidadBoletos
    public void setCantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }

    //getter presupuestoMaximo
    public float getPresupuestoMaximo() {
        return presupuestoMaximo;
    }

    public void setPresupuestoMaximo(float presupuestoMaximo) {
        this.presupuestoMaximo = presupuestoMaximo;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    


}