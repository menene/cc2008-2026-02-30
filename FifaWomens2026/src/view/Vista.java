package view;

import java.util.Scanner;

/* Clase de la vista. Es la unica que imprime y lee datos del usuario. */
public class Vista {

    private Scanner entrada;

    /* Constructor. Prepara el Scanner */
    public Vista() {
        entrada = new Scanner(System.in);
    }

    /* Imprime las opciones del menu */
    public void mostrarMenu() {
        System.out.println("");
        System.out.println("MENU");
        System.out.println("1. Nuevo comprador");
        System.out.println("2. Nueva solicitud de boletos");
        System.out.println("3. Consultar disponibilidad total");
        System.out.println("4. Consultar disponibilidad individual");
        System.out.println("5. Reporte de caja");
        System.out.println("6. Salir");
    }

    /* Lee la opcion que eligio el usuario */
    public int leerOpcion() {
        return leerEntero("Opcion: ");
    }

    /* Imprime un mensaje */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    /* Lee un texto */
    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return entrada.nextLine();
    }

    /* Lee un numero entero */
    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        String texto = entrada.nextLine();
        return Integer.parseInt(texto);
    }

    /* Lee un numero con decimales */
    public double leerDecimal(String mensaje) {
        System.out.print(mensaje);
        String texto = entrada.nextLine();
        return Double.parseDouble(texto);
    }

    /* Cierra el Scanner */
    public void cerrar() {
        entrada.close();
    }
}
