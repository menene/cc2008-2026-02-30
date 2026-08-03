public class Usuario{

    private String nombre;
    private String email;
    private int cantidadBoleto;
    private int presupuesto;

    public Usuario(String nombre, String email, int cantidadBoleto, int presupuesto){
        this.nombre = nombre;
        this.email = email;
        this.cantidadBoleto = cantidadBoleto;
        this.presupuesto = presupuesto;
    }
    //getters
    public String getNombre(){
        return nombre;
    }

    public String getEmail(){
        return email;
    }

    public int getcantidadBoleto(){
        return cantidadBoleto;
    }

    public int getpresupuesto(){
        return presupuesto;
    }
    //setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setcantidadBoleto(int cantidadBoletos){
        this.cantidadBoleto = cantidadBoleto;
    }
    public void setpresupuesto(int presupuesto){
        this.presupuesto = presupuesto;
    }

}
