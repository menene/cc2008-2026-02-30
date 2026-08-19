import java.util.Random;

public class HabilidadEspecial {

    // Atributos
    private String nombre;
    private int activacion;
    private float potenciador;

    // Constructor
    public HabilidadEspecial(String nombre, int activacion) {
        this.nombre = nombre;
        this.activacion = activacion;
        this.potenciador = 0;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getActivacion() {
        return activacion;
    }

    public float getPotenciador() {
        return potenciador;
    }

    // Determina si la habilidad se activa
    public boolean intentarActivacion() {
        Random random = new Random();

        int numero = random.nextInt(101);

        if (numero <= activacion) {
            return true;
        } else {
            return false;
        }
    }

    // Genera un potenciador entre 0% y 25%
    public float generarPotenciador() {
        Random random = new Random();

        potenciador = random.nextInt(26);

        return potenciador;
    }
}