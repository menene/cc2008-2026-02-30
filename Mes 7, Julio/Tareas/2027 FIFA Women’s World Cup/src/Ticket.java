import java.util.Random;
public class Ticket{
    private int numero;

    public Ticket(){
        Random r = new Random();
        this.numero= r.nextInt(15000)+1;
    }
    public int getNumero(){ return this.numero; }

}