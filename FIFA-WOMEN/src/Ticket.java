import java.util.Random;


public class Ticket {
    private int numeroTicket;
    private int a;
    private int b;


    public Ticket() {
        this.numeroTicket = 0;
        this.a = 0;
        this.b = 0;
    }


    public void generarTicket() {
        Random rand = new Random();
        this.numeroTicket = rand.nextInt(15000) + 1;
        this.a = rand.nextInt(15000) + 1;
        this.b = rand.nextInt(15000) + 1;
    }


    public boolean esApto() {
        int min = Math.min(this.a, this.b);
        int max = Math.max(this.a, this.b);
       
        System.out.println("-> Tu Ticket: " + this.numeroTicket);
        System.out.println("-> Rango Ganador: [" + min + " a " + max + "]");
       
        return (this.numeroTicket >= min && this.numeroTicket <= max);
    }


    public int getNumeroTicket() {
        return this.numeroTicket;
    }
}
