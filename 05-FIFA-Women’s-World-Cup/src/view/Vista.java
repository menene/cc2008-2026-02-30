package view;

import java.util.Scanner;
import model.Comprador;

public class Vista {

    private Scanner scanner;

    public Vista() {
        scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {

        System.out.println("\nFIFA Women's World Cup" );
        System.out.println("1. Nuevo comprador");
        System.out.println("2. Nueva solicitud de boletos");
        System.out.println("3. Consultar disponibilidad total");
        System.out.println("4. Consultar disponibilidad individual");
        System.out.println("5. Reporte de caja");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");

        return scanner.nextInt();
    }

    public Comprador leerComprador() {

        scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Cantidad de boletos: ");
        int cantidad = scanner.nextInt();

        System.out.print("Presupuesto máximo: ");
        double presupuesto = scanner.nextDouble();

        return new Comprador(nombre, email, cantidad, presupuesto);
    }

    public int pedirLocalidad() {

        System.out.print("Ingrese la localidad (1, 5 o 10): ");
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println("\n" + mensaje);
    }

    public void mostrarCaja(double total) {
        System.out.println("\nTotal generado: $" + total);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}