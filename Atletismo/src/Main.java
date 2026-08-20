import controller.Controller;
import view.View;

/* Programa principal. Crea el controlador y la vista y arranca el menu. */
public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();
        View view = new View(controller);
        view.showMenu();
    }
}
