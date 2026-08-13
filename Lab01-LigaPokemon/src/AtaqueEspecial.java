import java.util.Random;

public class AtaqueEspecial {

    private String nombre;
    private int probabilidadActivacion;

    AtaqueEspecial(String nombre, int probabilidadActivacion) {
        this.nombre = nombre;
        this.probabilidadActivacion = probabilidadActivacion;
    }

    public boolean seActiva() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(101);
        return numeroAleatorio <= probabilidadActivacion;
    }
 
    public int calcularPotenciador() {
        Random random = new Random();
        return random.nextInt(26);
    }

    public String getNombre() {
        return nombre;
    }

    public int getProbabilidadActivacion() {
        return probabilidadActivacion;
    }

}