import java.util.Random;

public class Ticket {

    // Atributos
    private int numeroTicket;
    private int numeroA;
    private int numeroB;

    // Constructor
    public Ticket() {
    }

    // Genera un número de ticket entre 1 y 15000
    private int generarNumeroTicket() {
        Random random = new Random();
        return random.nextInt(1, 15001);
    }

    // Genera el primer límite del rango
    private int generarNumeroA() {
        Random random = new Random();
        return random.nextInt(1, 15001);
    }

    // Genera el segundo límite del rango
    private int generarNumeroB() {
        Random random = new Random();
        return random.nextInt(1, 15001);
    }

    // Valida que el ticket esté dentro del rango generado
    private boolean validarNumeroTicket() {

        int menor = Math.min(numeroA, numeroB);
        int mayor = Math.max(numeroA, numeroB);

        return numeroTicket >= menor && numeroTicket <= mayor;
    }

    // Getter
    public int getNumeroTicket() {
        return numeroTicket;
    }

    // Setter
    public void setNumeroTicket(int numeroTicket) {
        this.numeroTicket = numeroTicket;
    }

    // Genera y valida el ticket
    public boolean generarTicket() {

        numeroTicket = generarNumeroTicket();
        numeroA = generarNumeroA();
        numeroB = generarNumeroB();

        boolean ticketValido = validarNumeroTicket();

        if (ticketValido == true) {

            return true;

        } else {

            return false;

        }

    }

}