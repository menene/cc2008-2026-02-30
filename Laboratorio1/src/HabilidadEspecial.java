import java.util.Random;

public class HabilidadEspecial {

    private String nombre;
    private int probabilidadActivacion;

    public HabilidadEspecial() {
    }

    public HabilidadEspecial(String nombre, int probabilidadActivacion) {
        this.nombre = nombre;
        this.probabilidadActivacion = probabilidadActivacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setProbabilidadActivacion(int probabilidadActivacion) {
        this.probabilidadActivacion = probabilidadActivacion;
    }

    public int getProbabilidadActivacion() {
        return probabilidadActivacion;
    }


    public boolean intentarActivacion() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(101); // 0 a 100 inclusive
        return numeroAleatorio <= probabilidadActivacion;
    }


    public int generarPotenciador() {
        Random random = new Random();
        return random.nextInt(26); // 0 a 25 inclusive
    }
}