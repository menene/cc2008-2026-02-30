import java.util.Random; // Generar numeros aleatorios

public class Habilidad {

    private String nombre;
    private int probabilidadActivacion; // valor entre 0 y 100

    // Generador de numeros aleatorios
    private static final Random random = new Random();

    public Habilidad(String nombre, int probabilidadActivacion) {
        this.nombre = nombre;
        this.probabilidadActivacion = probabilidadActivacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getProbabilidadActivacion() {
        return probabilidadActivacion;
    }

    // Probabilidad de activacion
    public boolean intentarActivacion() {
        int numeroAleatorio = random.nextInt(101); // 0 a 100
        return numeroAleatorio <= probabilidadActivacion;
    }

    //Porcentaje del potenciador para esta ronda.
    public int calcularMagnitud() {
        return random.nextInt(26); // 0 a 25 inclusive
    }
}