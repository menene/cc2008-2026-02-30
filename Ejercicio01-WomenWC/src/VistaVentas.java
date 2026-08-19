import java.util.Scanner;

public class VistaVentas {

    private Scanner scanner;

    public VistaVentas() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\n--- Sistema de Venta de Boletos - Women's World Cup 2027 ---");
        System.out.println("1. Nuevo comprador");
        System.out.println("2. Nueva solicitud de boletos");
        System.out.println("3. Consultar disponibilidad total");
        System.out.println("4. Consultar disponibilidad individual");
        System.out.println("5. Reporte de caja");
        System.out.println("6. Salir");
        System.out.print("Elige una opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    // Los siguientes cuatro métodos en mi diseño eran 2, los cambié porque creo que se sobrecomplicaba todo
    // de forma innecesaria. 

    public String pedirNombreComprador() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        return nombre;
    }

    public String pedirEmailComprador() {
        System.out.print("Email: ");
        String email = scanner.nextLine();

        return email;
    }

    public int pedirCantidadBoletos() {
        System.out.print("Cantidad de boletos deseados: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();
        return cantidad;
    }

    public float pedirPresupuesto() {
        System.out.print("Presupuesto máximo: ");
        float presupuesto = scanner.nextFloat();
        scanner.nextLine();
        return presupuesto;
    }

    public String pedirNombreLocalidad() {
        System.out.print("Nombre de la localidad (Localidad 1, Localidad 5, Localidad 10): ");
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}