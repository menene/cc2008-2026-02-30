import java.util.List;
import java.util.Scanner;

public class Vista {

    // Entrada de datos
    private Scanner scanner;

    // Constructor
    public Vista() {
        scanner = new Scanner(System.in);
    }

    // Menú principal
    public void mostrarMenu() {
        System.out.println("\n===== TALLER AUTOMOTRIZ =====");
        System.out.println("1. Registrar orden");
        System.out.println("2. Consultar órdenes");
        System.out.println("3. Buscar orden");
        System.out.println("4. Modificar orden");
        System.out.println("5. Cancelar orden");
        System.out.println("6. Consultar órdenes por placa");
        System.out.println("7. Reporte de costos");
        System.out.println("8. Orden de mayor costo");
        System.out.println("9. Cantidad de órdenes");
        System.out.println("10. Salir");
        System.out.println("=============================");
    }

    // Lectura de números enteros
    public int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número entero.");
            }
        }
    }

    // Lectura de números decimales
    public double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número válido.");
            }
        }
    }

    // Lectura de texto
    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    // Salida de mensajes
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Muestra una orden
    public void mostrarOrden(OrdenServicio orden) {
        System.out.println("\n----- ORDEN DE SERVICIO -----");
        System.out.println(orden);
        System.out.println("-----------------------------");
    }

    // Muestra una colección de órdenes
    public void mostrarOrdenes(List<OrdenServicio> ordenes) {
        if (ordenes.isEmpty()) {
            System.out.println("No hay órdenes para mostrar.");
            return;
        }

        for (OrdenServicio orden : ordenes) {
            mostrarOrden(orden);
        }
    }
}