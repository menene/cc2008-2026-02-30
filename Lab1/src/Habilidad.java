import java.util.Random;

public class Habilidad {
    private String nombreHabilidad;
    private int probabilidadActivacion;

    public Habilidad(String nombre, int probabilidadActivacion) {
        this.nombreHabilidad = nombre;
        this.probabilidadActivacion = probabilidadActivacion;
    }

    public String getNombre() {
        return nombreHabilidad;
    }

    public int getProbabilidadActivacion() {
        return probabilidadActivacion;
    }

    public boolean intentarActivacion() {
        Random random = new Random();

        int numero = random.nextInt(101);

        return numero <= probabilidadActivacion;
    }

    public int generarPotenciador() {
        Random random = new Random();

        return random.nextInt(26);
    }
}
