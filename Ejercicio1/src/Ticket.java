public class Ticket {
    private int idTicket;
    private int limiteSuperior;
    private int limiteInferior;

    public Ticket(int idTicket, int a, int b) {
        this.idTicket = idTicket;
        
        if (a > b) {
            this.limiteSuperior = a;
            this.limiteInferior = b;
        } else {
            this.limiteSuperior = b;
            this.limiteInferior = a;
        }
    }

    public int getIdTicket() {
        return idTicket;
    }

    public int getLimiteSuperior() {
        return limiteSuperior;
    }

    public int getLimiteInferior() {
        return limiteInferior;
    }

    public boolean esValido() {
        return idTicket >= limiteInferior && idTicket <= limiteSuperior;
    }
}
