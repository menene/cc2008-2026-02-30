import java.util.Scanner;

public class VistaMenu {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n===== FIFA Women's World Cup 2027 - Venta de boletos =====");
        System.out.println("1. Nuevo comprador");
        System.out.println("2. Nueva solicitud de boletos");
        System.out.println("3. Consultar disponibilidad total");
        System.out.println("4. Consultar disponibilidad individual");
        System.out.println("5. Reporte de caja");
        System.out.println("6. Salir");
        System.out.print("Elige una opcion: ");
    }

    public int leerOpcion() {
        return Integer.parseInt(scanner.nextLine());
    }

    public String[] solicitarDatosComprador() {
        String[] datos = new String[4];

        System.out.print("Nombre: ");
        datos[0] = scanner.nextLine();

        System.out.print("Email: ");
        datos[1] = scanner.nextLine();

        System.out.print("Cantidad de boletos que deseas comprar: ");
        datos[2] = scanner.nextLine();

        System.out.print("Presupuesto maximo ($): ");
        datos[3] = scanner.nextLine();

        return datos;
    }

    public void mostrarResultado(String mensaje) {
        System.out.println(mensaje);
    }
}
