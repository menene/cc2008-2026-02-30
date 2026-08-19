import java.util.Random;
public class Habilidad {
    private String nombre;
    private int probabilidad;

    public Habilidad(String nombre, int probabilidad) {
        this.nombre = nombre;
        this.probabilidad = probabilidad;
    }

    public String GetNombre() {
        return this.nombre;
    }

    public boolean Activacion() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(101);
        if (numeroAleatorio <= this.probabilidad) {
            return true;
        } else {
            return false;
        }
    }

    public double Potenciador() {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(26);
        double potenciador = numeroAleatorio/100.00;
        return potenciador;
    }
}