import controller.Controlador;
import model.Comprador;

/* Programa principal. Crea el comprador inicial y arranca el menu. */
public class Main {

    public static void main(String[] args) {
        Comprador compradorInicial = new Comprador("nery", "dela261233@uvg.edu.gt");
        Controlador controlador = new Controlador(compradorInicial);
        controlador.iniciar();
    }
}
