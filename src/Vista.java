import java.util.List;
import java.util.Scanner;


public class Vista {

    private Scanner scanner;


    public Vista() {
        this.scanner = new Scanner(System.in);
    }


    public void mostrarMenu() {
        System.out.println("\n===== SISTEMA DE CONTROL DE ORDENES DE SERVICIO =====");
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
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            mostrarMensaje("Opcion invalida. Debe ingresar un numero.");
            return -1;
        }
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }


    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            mostrarMensaje("Valor invalido. Debe ingresar un numero entero.");
            throw e;
        }
    }


    public double leerDecimal(String mensaje) {
        System.out.print(mensaje);
        try {
            return Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            mostrarMensaje("Valor invalido. Debe ingresar un numero decimal.");
            throw e;
        }
    }


    public void mostrarOrden(OrdenServicio orden) {
        System.out.println(orden.toString());
    }


    public void mostrarListaOrdenes(List<OrdenServicio> ordenes) {
        if (ordenes.isEmpty()) {
            mostrarMensaje("No hay ordenes para mostrar.");
            return;
        }
        for (OrdenServicio orden : ordenes) {
            mostrarOrden(orden);
        }
    }


    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}