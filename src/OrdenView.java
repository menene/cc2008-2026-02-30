import java.util.List;
import java.util.Scanner;

public class OrdenView {
    private Scanner scanner;

    public OrdenView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n====== SISTEMA DE ÓRDENES ======");
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
        System.out.println("==============================");
    }

    public String solicitarDato(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarOrden(Orden orden) {
        System.out.println("\n------ INFORMACIÓN DE LA ORDEN ------");
        System.out.println(orden.mostrarInformacion());
        System.out.println("-----------------------------------");
    }

    public void mostrarOrdenes(List<Orden> ordenes) {
        if (ordenes.isEmpty()) {
            System.out.println("No hay órdenes para mostrar.");
            return;
        }

        for (Orden orden : ordenes) {
            mostrarOrden(orden);
        }
    }

    public void mostrarReporteCostos(double total, double promedio) {
        System.out.println("\n------ REPORTE DE COSTOS ------");
        System.out.printf("Costo total: Q%.2f%n", total);
        System.out.printf("Costo promedio: Q%.2f%n", promedio);
        System.out.println("-----------------------------");
    }
}