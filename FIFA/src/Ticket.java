import java.util.Random;

public class Ticket {
    private int numero;

    public Ticket() {
        Random rand = new Random();
        this.numero = rand.nextInt(15000) + 1;
    }

    public int getNumero() {
        return numero;
    }

    public boolean esElegibleParaCompra() {
        Random rand = new Random();
        int a = rand.nextInt(15000) + 1;
        int b = rand.nextInt(15000) + 1;
        
        int limiteInferior = Math.min(a, b);
        int limiteSuperior = Math.max(a, b);
        
        return numero >= limiteInferior && numero <= limiteSuperior;
    }
}