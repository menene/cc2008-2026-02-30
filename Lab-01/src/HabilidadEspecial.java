import java.util.Random;

public class HabilidadEspecial {
    
    Random random = new Random();

    private String nombre;
    private int probabilidad;

    public HabilidadEspecial(String nombre, int probabilidad) {
        this.nombre = nombre;
        this.probabilidad = probabilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getProbabilidad() {
        return probabilidad;
    }

    public boolean activacion() {
        int numero = random.nextInt(100) + 1;

        return numero <= probabilidad;
    }

    public int potencia() {
        return random.nextInt(26);
    }
}