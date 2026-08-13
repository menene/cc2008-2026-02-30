import java.util.Random;

public class HabilidadEspecial {
    
    private String nombre;
    private int probabilidadActivacion; 

    public HabilidadEspecial(String nombre, int probabilidadActivacion){
        this.nombre = nombre;
        this.probabilidadActivacion = probabilidadActivacion;   
    }

    public String getNombre(){
        return nombre;
    }

    public int getProbabilidadActivacion(){
        return probabilidadActivacion;
    }

    public boolean seActiva(){
        Random random = new Random();

        int numero = random.nextInt(101);

        return numero <= probabilidadActivacion;
    }

    public int generarPotenciador(){
        Random random = new Random();

        return random.nextInt(26);
    }
}