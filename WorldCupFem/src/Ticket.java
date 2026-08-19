import java.util.Random;
public class Ticket {

    private int noTicket,numero1,numero2,Disponibilidad;
         
    public Ticket() {

    Random random = new Random();

        noTicket = random.nextInt(15000) + 1;
        numero1 = random.nextInt(15000) + 1;
        numero2 = random.nextInt(15000) + 1;

        Disponibilidad = 0;

    }

    public boolean validarTicket() {

        int menor = Math.min(numero1, numero2);
        int mayor = Math.max(numero1, numero2);

        System.out.println("\n Ticket: " + noTicket);
        System.out.println("Número 1: " + numero1);
        System.out.println("Número 2: " + numero2);

        if (noTicket >= menor && noTicket <= mayor) {

            System.out.println("TICKET VALIDO");

            Disponibilidad = 1;
            return true;

        } else {

            System.out.println("TICKET NO VALIDO");

            Disponibilidad = 0;
            return false;
        }
    }
}
