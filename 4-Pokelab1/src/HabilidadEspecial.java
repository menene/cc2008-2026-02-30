import java.util.Random;

/**
 * Representa la habilidad especial de un Pokemon.
 * Toda habilidad funciona igual: es un potenciador de hasta 25%
 * que se activa segun una probabilidad definida al crearla.
 */
public class HabilidadEspecial {

    private String nombreH;
    private int probabilidadActivacion;

    public HabilidadEspecial(String nombre, int probabilidadActivacion) {
        this.nombreH = nombre;
        this.probabilidadActivacion = probabilidadActivacion;
    }

    public String getNombre() {
        return nombreH;
    }

    /**
     * Genera un numero aleatorio entre 0 y 100.
     * Si cae dentro del rango [0, probabilidadActivacion], la habilidad se activa.
     */
    public boolean activarHabilidad() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(101); // 0 a 100
        return numeroAleatorio <= probabilidadActivacion;
    }

    /**
     * Genera aleatoriamente el porcentaje de potenciacion, entre 1% y 25%.
     */
    public int generarPotenciador() {
        Random random = new Random();
        return random.nextInt(25) + 1; // 1 a 25
    }
}
