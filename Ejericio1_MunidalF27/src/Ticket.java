import java.util.Random;

public class Ticket {

    private int numeroTicket;
    private int numeroA;
    private int numeroB;

    public Ticket(){

    }
    
    public void generarTicket(){

        Random random = new Random();
        this.numeroTicket = random.nextInt(15000)+1;
        this.numeroA = random.nextInt(15000)+1;
        this.numeroB = random.nextInt(15000)+1;
    }

    public boolean esApto(){

        int menor;
        int mayor;

        if (numeroA > numeroB) {
            menor = numeroB;
            mayor = numeroA;
            
        } else {
            menor = numeroA;
            mayor = numeroB;
           
        }

         return numeroTicket >= menor  && numeroTicket <= mayor;
    }

}