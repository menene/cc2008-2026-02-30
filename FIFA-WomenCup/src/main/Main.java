package main;
import controller.GestorVentas;
import model.Localidad;
import view.Menu;

public class Main {
    public static void main(String[] args) {
        Localidad localidad1 = new Localidad("Localidad 1", 100, 20);
        Localidad localidad2 = new Localidad("Localidad 5", 500, 20);
        Localidad localidad3 = new Localidad("Localidad 10", 1000, 20);

        Localidad[] localidades = {localidad1, localidad2, localidad3};

        GestorVentas gestor = new GestorVentas(localidades);
        Menu menu = new Menu(gestor);
        menu.ejecutar();
    }
}