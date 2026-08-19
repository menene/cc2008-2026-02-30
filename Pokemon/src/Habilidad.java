import java.util.Random;

public class Habilidad {

    private int probabilidad;
    private String nombreEnAtaque;
    private String nombreEnDefensa;
    private float potenciador;

    public Habilidad(int probabilidad, String tipo) {

        this.probabilidad = probabilidad;
        this.potenciador = 0;

        if (tipo.equalsIgnoreCase("Fuego")) {
            nombreEnAtaque = "Llamarada";
            nombreEnDefensa = "Rueda de Fuego";

        } else if (tipo.equalsIgnoreCase("Agua")) {
            nombreEnAtaque = "Hidrobomba";
            nombreEnDefensa = "Gota Vital";

        } else if (tipo.equalsIgnoreCase("Planta")) {
            nombreEnAtaque = "Rayo Solar";
            nombreEnDefensa = "Barrera Espinosa";

        } else if (tipo.equalsIgnoreCase("Electrico")) {
            nombreEnAtaque = "Rayo";
            nombreEnDefensa = "Electrotela";
        }
    }

    public boolean activarHabilidad() {

        Random random = new Random();
        int numero = random.nextInt(101);

        if (numero <= probabilidad) {
            potenciador = random.nextInt(26);
            return true;
        } else {
            potenciador = 0;
            return false;
        }
    }

    public String getNombreATK() {
        return nombreEnAtaque;
    }

    public String getNombreDFS() {
        return nombreEnDefensa;
    }

    public int getProbabilidad() {
        return probabilidad;
    }

    public float getPotenciador() {
        return potenciador;
    }

}