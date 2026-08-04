package main;
import controller.GestorVentas;
import model.Localidad;
import view.Menu;

public class Main {
    public static void main(String[] args) {
        Localidad localidad1 = new Localidad("A", 50, 100);
        Localidad localidad2 = new Localidad("B", 75, 50);
        Localidad localidad3 = new Localidad("C", 40, 120);

        Localidad[] localidades = {localidad1, localidad2, localidad3};

        GestorVentas gestor = new GestorVentas(localidades);
        Menu menu = new Menu(gestor);
        menu.ejecutar();
    }
}