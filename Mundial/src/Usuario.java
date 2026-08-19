public class Usuario{
    private String nombre;
    private String email;
    private int cantidad_boletos;
    private double presupuesto;

    public Usuario(String nombre, String email, int cantidad_boletos, double presupuesto){
        this.nombre= nombre;
        this.email= email;
        this.cantidad_boletos= cantidad_boletos;
        this.presupuesto= presupuesto;
    }
    public String getNombre(){
        return nombre;
    }
    public String getEmail(){
        return email;
    }
    public int getCantidad_Boletos(){
        return cantidad_boletos;
    }
    public double getPresupuesto(){
        return presupuesto;
    }
    public void actualizar_Presupuesto(double monto) {
        presupuesto -= monto;
    }
}