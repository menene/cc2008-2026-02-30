import java.util.Scanner;

public class VistaConsola {
    private Scanner scanner;

    public VistaConsola() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println(
                "\n--- SISTEMA DE VENTA DE BOLETOS ---"
        );
        System.out.println("1. Nuevo comprador");
        System.out.println("2. Nueva solicitud de boletos");
        System.out.println(
                "3. Consultar disponibilidad total"
        );
        System.out.println(
                "4. Consultar disponibilidad individual"
        );
        System.out.println("5. Reporte de caja");
        System.out.println("6. Salir");
    }

    public int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(
                        "Ingrese un número entero válido."
                );
            }
        }
    }

    public double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(
                        scanner.nextLine()
                );
            } catch (NumberFormatException e) {
                System.out.println(
                        "Ingrese un número válido."
                );
            }
        }
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}