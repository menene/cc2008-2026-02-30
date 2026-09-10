package main;
 
import controller.OrdenController;
import view.OrdenView;

public class Main {
    public static void main(String[] args) {
        OrdenController controller = new OrdenController();
        OrdenView view = new OrdenView(controller);
        view.iniciar();
    }
}
 