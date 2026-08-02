import java.util.Random;

public class Ticket {

    private static final int LIMITE_INFERIOR = 1;
    private static final int LIMITE_SUPERIOR = 15000;

    // atributos
    private int numero;
    private boolean apto;
    private int a1;
    private int a2;

    // constructor
    public Ticket() {
        this.numero = 0;
        this.apto = false;
        this.a1 = 0;
        this.a2 = 0;
    }

    // metodos
    public void generarTicket() {
        Random random = new Random();
        numero = random.nextInt(LIMITE_SUPERIOR) + LIMITE_INFERIOR;
    }

    public boolean validarTicket() {
        Random random = new Random();
        a1 = random.nextInt(LIMITE_SUPERIOR) + LIMITE_INFERIOR;
        a2 = random.nextInt(LIMITE_SUPERIOR) + LIMITE_INFERIOR;

        int rangoMinimo = Math.min(a1, a2);
        int rangoMaximo = Math.max(a1, a2);

        apto = numero >= rangoMinimo && numero <= rangoMaximo;
        return apto;
    }

    public int getNumero() {
        return numero;
    }
}
