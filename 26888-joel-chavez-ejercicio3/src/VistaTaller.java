import java.util.List;
import java.util.Scanner;

public class VistaTaller {

    private Scanner scanner;

    public VistaTaller() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n=== TALLER AUTOMOTRIZ ===");
        System.out.println("1. Registrar orden");
        System.out.println("2. Consultar órdenes");
        System.out.println("3. Buscar orden");
        System.out.println("4. Modificar orden");
        System.out.println("5. Cancelar orden");
        System.out.println("6. Consultar órdenes por placa");
        System.out.println("7. Reporte de costos");
        System.out.println("8. Orden de mayor costo");
        System.out.println("9. Cantidad de órdenes");
        System.out.println("0. Salir");
    }

    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public double leerDouble(String mensaje) {
        System.out.print(mensaje);
        return Double.parseDouble(scanner.nextLine().trim());
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public void mostrarOrden(OrdenServicio orden) {
        System.out.println("\n" + orden);
    }

    public void mostrarOrdenes(List<OrdenServicio> ordenes) {
        if (ordenes.isEmpty()) {
            System.out.println("No se encontraron órdenes.");
            return;
        }

        for (OrdenServicio orden : ordenes) {
            mostrarOrden(orden);
            System.out.println("------------------------------");
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarError(String mensaje) {
        System.out.println("Error: " + mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}