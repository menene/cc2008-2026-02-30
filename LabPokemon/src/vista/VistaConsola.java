package vista;

import java.util.Scanner;

// Es la unica clase que muestra mensajes y pide datos por teclado.
public class VistaConsola {

    private Scanner entrada;

    public VistaConsola() {
        this.entrada = new Scanner(System.in);
    }

    public void mostrarBienvenida() {
        System.out.println("=============================================");
        System.out.println("        LIGA ELEMENTAL - COMBATE POKEMON     ");
        System.out.println("=============================================");
        System.out.println("Dos entrenadores, 4 Pokemon cada uno, 4 rondas.");
        System.out.println("Los equipos se sortean al azar desde la PokeAPI.");
        System.out.println("");
    }

    public void mostrarMenu() {
        System.out.println("");
        System.out.println("--------------- MENU ---------------");
        System.out.println("1. Iniciar un nuevo combate");
        System.out.println("2. Salir");
        System.out.print("Elija una opcion: ");
    }

    // Lee la opcion del menu y devuelve 0 si el usuario no escribio un numero.
    public int leerOpcion() {
        String texto = entrada.nextLine();
        int opcion = 0;

        try {
            opcion = Integer.parseInt(texto.trim());
        } catch (NumberFormatException error) {
            opcion = 0;
        }

        return opcion;
    }

    // Muestra un mensaje y devuelve lo que escriba el usuario.
    public String leerTexto(String mensaje) {
        System.out.print(mensaje + " ");
        String texto = entrada.nextLine();

        return texto.trim();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrar() {
        entrada.close();
    }
}
