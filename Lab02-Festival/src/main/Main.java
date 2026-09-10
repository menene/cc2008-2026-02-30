package main;

import controller.FestivalController;
import model.Festival;
import view.FestivalView;

public class Main {
    public static void main(String[] args) {
        FestivalView vista = new FestivalView();
        vista.mostrarMensaje("Ingrese la información inicial del festival.");
        String nombre = vista.leerTexto("Nombre del festival: ");
        String codigo = vista.leerTexto("Código de identificación: ");
        String coordinador = vista.leerTexto("Nombre del coordinador: ");
        Festival festival = new Festival(nombre, codigo, coordinador);
        FestivalController controlador = new FestivalController(festival, vista);
        controlador.iniciarPrograma();
    }
}
