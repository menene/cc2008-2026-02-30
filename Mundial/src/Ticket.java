import java.util.Random;

public class Ticket {
    private int numeroTicket;
    private int limite_Superior;
    private int limite_Inferior;
    private boolean validacion;
    private Random random;
    public Ticket() {
        random = new Random();
    }

    public void generarTicket() {
        numeroTicket = random.nextInt(15000) + 1;
    }
    public void generarNumeros() {
        limite_Superior = random.nextInt(15000) + 1;
        limite_Inferior = random.nextInt(15000) + 1;
    }
    public boolean validacionTicket() {
        int menor = Math.min(limite_Inferior, limite_Superior);
        int mayor = Math.max(limite_Inferior, limite_Superior);
        return numeroTicket >= menor && numeroTicket <= mayor;
    }
    public int getNumeroTicket() {
        return numeroTicket;
    }
    public int getlimite_Superior() {
        return limite_Superior;
    }
    public int getlimite_Inferior() {
        return limite_Inferior;
    }
    public boolean getValidacion() {
        return validacion;
    }
}