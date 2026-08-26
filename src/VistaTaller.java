import java.util.List;
import java.util.Scanner;

public class VistaTaller {

    private Scanner scanner;

    public VistaTaller() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n===== Sistema de Control de Ordenes de Servicio =====");
        System.out.println("1. Registrar orden");
        System.out.println("2. Consultar ordenes");
        System.out.println("3. Buscar orden");
        System.out.println("4. Modificar orden");
        System.out.println("5. Cancelar orden");
        System.out.println("6. Consultar ordenes por placa");
        System.out.println("7. Reporte de costos");
        System.out.println("8. Orden de mayor costo");
        System.out.println("9. Cantidad de ordenes");
        System.out.println("10. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    public int leerOpcion() {
        String entrada = scanner.nextLine();
        try {
            return Integer.parseInt(entrada.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public String leerLinea(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public void mostrarOrden(OrdenServicio orden) {
        System.out.println(orden.toString());
    }

    public void mostrarListaOrdenes(List<OrdenServicio> ordenes) {
        if (ordenes.isEmpty()) {
            System.out.println("No hay ordenes para mostrar.");
            return;
        }
        for (OrdenServicio orden : ordenes) {
            System.out.println(orden.toString());
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}