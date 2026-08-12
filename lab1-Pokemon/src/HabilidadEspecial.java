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

    // Getters
    public String getNombre() {
        return this.nombre;
    }

    public int getProbabilidadActivacion() {
        return this.probabilidadActivacion;
    }

    // Genera número aleatorio para determinar si la habilidad especial se activa o no.
    public boolean seActiva() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(101);
        return numeroAleatorio <= probabilidadActivacion;
    }

    // Genera el porcentaje del potenciador que va de 0 a 25
    public int generarPotenciador() {
        Random random = new Random();
        return random.nextInt(26);
    }
}
