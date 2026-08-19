import java.util.Random;

public class Ticket {

    private int numTicket;
    private int limiteInferior;
    private int limiteSuperior;
    private boolean valido;

    // Constructor
    public Ticket() {

        generarNumeroTicket();
        generarLimites();
        validarTicket();

    }

    // Genera un número de ticket 
    public void generarNumeroTicket() {

        Random random = new Random();

        numTicket = random.nextInt(15000) + 1;

    }

    // Genera los dos números aleatorios y define el rango
    public void generarLimites() {

        Random random = new Random();

        int a = random.nextInt(15000) + 1;
        int b = random.nextInt(15000) + 1;

        limiteInferior = Math.min(a, b);
        limiteSuperior = Math.max(a, b);

    }

    // Valida el ticket 
    public boolean validarTicket() {

        if (numTicket >= limiteInferior && numTicket <= limiteSuperior) {
            valido = true;
        } else {
            valido = false;
        }

        return valido;

    }

    // Devuelve si el ticket es válido
    public boolean getValidTicket() {
        return valido;
    }

    public int getNumTicket() {
        return numTicket;
    }

    public int getLimiteInferior() {
        return limiteInferior;
    }

    public int getLimiteSuperior() {
        return limiteSuperior;
    }

}