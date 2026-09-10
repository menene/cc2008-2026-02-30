package main;
 
import controller.AtletaController;
import view.AtletaView;
 
public class Main {
    public static void main(String[] args) {
        AtletaController controller = new AtletaController();
        AtletaView view = new AtletaView(controller);
        view.mostrarMenu();
    }
}
