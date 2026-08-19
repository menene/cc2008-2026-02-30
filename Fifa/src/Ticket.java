import java.util.Random;
public class Ticket {
    private int numeroTicket;
    private int limiteA;
    private int limiteB;


    public Ticket() {
        crearTicket();
        crearLimites(); 
    }
        
    public void crearTicket() {
        Random random = new Random(); 
        numeroTicket = random.nextInt(15001);

    }
    
    public void crearLimites() {
        Random random = new Random();
        limiteA = random.nextInt(15001);
        limiteB = random.nextInt(15001);



        if (limiteA > limiteB){
            int temporal = limiteA; 
            limiteA = limiteB;
            limiteB = temporal; 

        }

    }
    
    public boolean isValid(){
        if ((numeroTicket >= limiteA) && (numeroTicket <= limiteB)) {
            return true; 
        } else {
            return false; 
        }

    }

 
    
}