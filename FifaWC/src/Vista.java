import java.util.Scanner;

public class Vista {

    private Scanner scanner;

    public Vista() {
        scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {

        System.out.println("\n----- MENÚ -----");
        System.out.println("1. Nuevo comprador");
        System.out.println("2. Nueva solicitud");
        System.out.println("3. Consultar disponibilidad total");
        System.out.println("4. Consultar disponibilidad individual");
        System.out.println("5. Reporte de caja");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");

        return scanner.nextInt();
    }

    public Comprador crearComprador() {

        scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Cantidad de boletos: ");
        byte cantidad = scanner.nextByte();

        System.out.print("Presupuesto: ");
        short presupuesto = scanner.nextShort();

        return new Comprador(nombre, email, cantidad, presupuesto);
    }

    public int pedirLocalidad() {

        System.out.print("Ingrese la localidad (1, 5 o 10): ");
        return scanner.nextInt();

    }

    public void mostrarFactura(String factura) {

        System.out.println("\n----- FACTURA -----");
        System.out.println(factura);

    }

    public void mostrarMensaje(String mensaje) {

        System.out.println(mensaje);

    }

}