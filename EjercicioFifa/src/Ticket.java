import java.util.Random;

public class Ticket {

    private int ticket;
    private int a;
    private int b;

    public Ticket() {
        Random random = new Random();

        ticket = random.nextInt(15000) + 1;
        a = random.nextInt(15000) + 1;
        b = random.nextInt(15000) + 1;

    }

    public boolean verificarTicket() {
        int menor = Math.min(a, b);
        int mayor = Math.max(a, b);

        return ticket >= menor && ticket <= mayor;
    }

}