import java.util.Random;

public class Ticket {

    private int numeroTicket;
    private int limiteInf;
    private int limiteSup;
    private Random rd;

    public Ticket() {
        rd = new Random();
    }

    public Ticket(int numeroTicket, int limiteInf, int limiteSup, Random rd) {
        this.numeroTicket = numeroTicket;
        this.limiteInf = limiteInf;
        this.limiteSup = limiteSup;
        this.rd = rd;
    }

    public int getNumeroTicket() {
        return numeroTicket;
    }

    public void setNumeroTicket(int numeroTicket) {
        this.numeroTicket = numeroTicket;
    }

    public int getLimiteInf() {
        return limiteInf;
    }

    public void setLimiteInf(int limiteInf) {
        this.limiteInf = limiteInf;
    }

    public int getLimiteSup() {
        return limiteSup;
    }

    public void setLimiteSup(int limiteSup) {
        this.limiteSup = limiteSup;
    }

    public Random getRd() {
        return rd;
    }

    public void setRd(Random rd) {
        this.rd = rd;
    }
}