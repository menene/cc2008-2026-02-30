public class Comprador {

    private String nombre;
    private String email;
    private int cantidadBoletos;
    private double presupuesto;

    public Comprador(String nombre, String email, int cantidadBoletos, double presupuesto){

        this.nombre = nombre;
        this.email = email;
        this.cantidadBoletos = cantidadBoletos;
        this.presupuesto = presupuesto;

    }

    public String getNombre(){
        return nombre;
    }

    public String getEmail(){
        return email;
    }

    public int getCantidadBoletos(){
        return cantidadBoletos;
    }

    public double getPresupuesto(){
        return presupuesto;
    }
}