public class Usuario {
    //atributos
    private String Nombre;
    private String Correo;
    private int Boletos_A_Comprar;
    private float Presupuesto;


//Constructor User
    public Usuario(String nombre, String correo, int boletos, float presupuesto) {
        this.Nombre = nombre;
        this.Correo = correo;
        this.Boletos_A_Comprar = boletos;
        this.Presupuesto = presupuesto;
    }

//Metodos para leer la informacion

    public String getNombre() {
        return this.Nombre;
    }

    public String getCorreo() {
        return this.Correo;
    }

    public int getBoletos_A_Comprar() {
        return this.Boletos_A_Comprar;
    }
    
    public float getPresupuesto() {
        return this.Presupuesto;
    }
}