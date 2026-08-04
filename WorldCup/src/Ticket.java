import java.util.Random;

public class Ticket {
    
    private Random random = new Random();
    private int superior;
    private int inferior;

    //vacio primero
    public Ticket() {

    }

    public int generarTicket() {
        return random.nextInt(15000) + 1;
        //por lo que entiendo, es el numero entre 15000 y 1
    }

    public void generarRango() {
        int num1 = random.nextInt(15000) + 1;
        int num2 = random.nextInt(15000) + 1;
        //estos 2 nums no los agregue en el analisis, no sabia que los iba a usar haha

        if (num1 > num2) { //mas grande supeior
            superior = num1;
            inferior = num2;
        }
        else { // si no, al reves
            superior = num2;
            inferior = num1;
        }

    }

    public boolean validarTicket(int ticket) {
        return ticket >= inferior && ticket <= superior;
        //true, si el ticket es mas grande que el inferior
        //y mas peque que el superior. Sino false
    }


    //getters y setterss
    //superior
    public int getSuperior() {
        return superior;
    }

    public void setSuperior(int superior) {
        this.superior = superior;
    }

    // inferior
    public int getInferior() {
        return inferior;
    }

    public void setInferior(int inferior) {
        this.inferior = inferior;
    }





}
