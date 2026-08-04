import java.util.Random;

public class Ticket {
    private int numTicket;
    private int numA;
    private int numB;

    public Ticket() {
    }

    //getters y setters de ticket
    public int getNumTicket() 
    {
        return numTicket;
    }

    public void setNumTicket(int numTicket) 
    {
        this.numTicket = numTicket;
    }

    public int getNumA() 
    {
        return numA;
    }

    public void setNumA(int numA) 
    {
        this.numA = numA;
    }

    public int getNumB() 
    {
        return numB;
    }

    public void setNumB(int numB) 
    {
        this.numB = numB;
    }

    //Numero del ticket generado aleatoriamente
    public int GenerarTicket() 
    {
        Random random = new Random();
        this.numTicket = random.nextInt(15000) + 1;
        return this.numTicket;
    }

    public int getCantTickets(Localidad localidad) 
    {
        return localidad.getCapacidad() - localidad.getVendidos();
    }

    //validación
    public boolean TicketValido() 
    {
        int min = Math.min(numA, numB);
        int max = Math.max(numA, numB);
        return (numTicket >= min && numTicket <= max);
    }
}