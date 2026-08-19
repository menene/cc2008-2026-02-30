public class Comprador {

    private String nombre;
    private int cantidadBoletos;
    private double presupuesto;
    private String email;

    
    public Comprador() {

    }

    public Comprador(String nombre, String email, int cantidadBoletos, double presupuesto) {
        this.nombre = nombre;
        this.email = email;
        this.cantidadBoletos = cantidadBoletos;
        this.presupuesto = presupuesto;
    }

    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    public void setCantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}