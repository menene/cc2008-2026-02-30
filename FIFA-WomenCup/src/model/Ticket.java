package model;
import java.util.Random;

public class Ticket {
    private static final int RANGO_MIN = 1;
    private static final int RANGO_MAX = 15000;
    private static final Random RANDOM = new Random();

    private int numeroTicket;
    private int numeroA;
    private int numeroB;
    private boolean valid;
    private Localidad localidadAsig;

    public int randomNumbers(){
        return RANGO_MIN + RANDOM.nextInt(RANGO_MAX);
    }

    public boolean validarRango() {
        int limiteInferior = Math.min(numeroA, numeroB);
        int limiteSuperior = Math.max(numeroA, numeroB);
        valid = numeroTicket >= limiteInferior && numeroTicket <= limiteSuperior;
        return valid;
    }

    public void generarNumeros() {
        this.numeroTicket = randomNumbers();
        this.numeroA = randomNumbers();
        this.numeroB = randomNumbers();
        this.valid = validarRango();
    }

    public Ticket() {
        generarNumeros();
    }

    public int getNumeroTicket() {
        return numeroTicket;
    }

    public int getNumeroA() {
        return numeroA;
    }

    public int getNumeroB() {
        return numeroB;
    }

    public boolean isValid() {
        return valid;
    }

    public Localidad getLocalidadAsig() {
        return localidadAsig;
    }

    public void setLocalidadAsig(Localidad localidadAsig) {
        this.localidadAsig = localidadAsig;
    }
}
