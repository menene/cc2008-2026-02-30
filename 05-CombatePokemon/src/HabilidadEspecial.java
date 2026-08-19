import java.util.Random;

public class HabilidadEspecial {

    // Atributos
    private String nombre;
    private int probabilidadActivacion;

    // Constructor
    public HabilidadEspecial(String nombre, int probabilidadActivacion) {
        this.nombre = nombre;
        this.probabilidadActivacion = probabilidadActivacion;
    }

    // Método que intenta activar la habilidad especial según su probabilidad de activación
    public boolean intentarActivar() {

        Random random = new Random();

        int numeroAleatorio = random.nextInt(101);

        return numeroAleatorio <= probabilidadActivacion;
    }

    // Genera un potenciador entre 0-25 para aumentar el ataque del Pokémon
    public int generarPotenciador() {

        Random random = new Random();

        return random.nextInt(26);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getProbabilidadActivacion() {
        return probabilidadActivacion;
    }
}