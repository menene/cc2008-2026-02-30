import java.util.Random;

public class HabilidadEspecial {
    private String nombre;
    private int probabilidadActivacion;
    private Random random;

    //constructor
    public HabilidadEspecial(String nombre, int probabilidadActivacion) {   
        this.nombre = nombre;
        this.probabilidadActivacion = probabilidadActivacion;
        this.random = new Random();
    }

    //G&S nombre
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //G&S probabilidad Activacion
    public int getProbabilidadActivacion() {
        return probabilidadActivacion;
    }

    public void setProbabilidadActivacion(int probabilidadActivacion) {
        this.probabilidadActivacion = probabilidadActivacion;
    }

    //metodo intentar activacion generando numero aleatorio
    public boolean intentarActivacion() {
        //rango de 0 a 100, entonces 101 porque no se toma ese ultimo
        int num1 = random.nextInt(101);

        //veo si se activa su habilidad o no
        if (num1 <= probabilidadActivacion){
            return true;
        } else {
            return false;
        }
    }

    //metodo generar potenciador
    public int generarPotenciador() {
        //rango de 0 a 25
        int num2 = random.nextInt(26);
        return num2; 
    }


}
