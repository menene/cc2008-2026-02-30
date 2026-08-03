public class Comprador{
    private String nombre;
    private String email;
    private int cantidadBoletos;
    private double presupuesto;
    public Comprador(String nombre, String email, int cantidadBoletos, double presupuesto){
        this.nombre=nombre;
        this.email= email;
        this.cantidadBoletos= cantidadBoletos;
        this.presupuesto= presupuesto;
    }
    public String getNombre(){ return this.nombre; }
    public String getEmail(){ return this.email; }
    public void setEmail(String email){ this.email=email; }
    public int getCantidadBoletos(){ return this.cantidadBoletos; }
    public void setCantidadBoletos(int cantidadBoletos){ this.cantidadBoletos=cantidadBoletos; }
    public double getPresupuesto(){ return this.presupuesto; }
    public void setPresupuesto(double presupuesto){ this.presupuesto=presupuesto; }
}