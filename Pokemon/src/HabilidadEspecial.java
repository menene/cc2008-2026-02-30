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

    // numero random para activar la habilidad
    public boolean activarHabilidad() {
        Random random = new Random();

        // Genera un número entre 1 y 100
        int numero = random.nextInt(100) + 1;

        // Ejemplo: probabilidad 30 -> se activa si sale entre 1 y 30
        return numero <= probabilidadActivacion;
    }

    // Genera el potenciador de la habilidad.
    public int generarPotenciador() {
        Random random = new Random();

        return random.nextInt(25) + 1; //uso nextInt para determinar la cantidad de potenciador
    }
}

