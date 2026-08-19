//Clase para generar # aleatorios//
import java.util.Random;
//CLASE//
public class Comprador {

    //ATRIBUTOS//
    private String nombre;
    private String email;
    private int cantidadBoletos;
    private double presupuestoMaximo;
    private int numeroTicket; 

    //CONSTRUCTOR//
    public Comprador(String nombre, String email, int cantidadBoletos, double presupuestoMaximo){
            //Guarda los datos recibidos en los atributos del comprador//
            this.nombre = nombre;
            this.email = email;
            this.cantidadBoletos = cantidadBoletos;
            this.presupuestoMaximo = presupuestoMaximo;
        }

    public void generarTicket() {
        Random random = new Random();
        numeroTicket = random.nextInt(15000) + 1;
    }
    //GETTERS Y SETTER//
    public int getNumeroTicket() {
        return numeroTicket;
    }

    public double getPresupuestoMaximo() {
        return presupuestoMaximo;
    }

    public int getCantidadBoletos() {
        return cantidadBoletos;
}
}
