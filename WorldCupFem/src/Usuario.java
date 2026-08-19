public class Usuario{

    private String nombre, email;
    private int noBoletos, presupuestoMax;

    public Usuario(String nombre, String email,
                   int noBoletos,
                   int presupuestoMax){

        this.nombre = nombre;
        this.email = email;
        this.noBoletos = noBoletos;
        this.presupuestoMax = presupuestoMax;
    }

    public String getNombre(){
        return nombre;
    }

    public int getNoBoletos(){
        return noBoletos;
    }

    public int getPresupuesto(){
        return presupuestoMax;
    }

    public void setPresupuesto(int presupuestoMax) {
        this.presupuestoMax = presupuestoMax;
    }
}