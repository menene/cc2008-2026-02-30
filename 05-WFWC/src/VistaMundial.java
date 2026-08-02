import java.util.Scanner;

public class VistaMundial {
    private Scanner scanner;
    public VistaMundial() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n========== 2027 FIFA Women's World Cup ==========");
        System.out.println("1. Nuevo comprador");
        System.out.println("2. Nueva solicitud de boletos");
        System.out.println("3. Consultar disponibilidad total");
        System.out.println("4. Consultar disponibilidad por localidad");
        System.out.println("5. Reporte de caja");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public int leerOpcionMenu() {
        int opcion = scanner.nextInt();
        scanner.nextLine(); // limpia el Enter
        return opcion;
    }

    public String leerNombre() {
        System.out.print("Nombre: ");
        return scanner.nextLine();
    }

    public String leerEmail() {
        System.out.print("Email: ");
        return scanner.nextLine();
    }

    public int leerCantidadBoletos() {
        System.out.print("Cantidad de boletos: ");
        return scanner.nextInt();
    }

    public double leerPresupuesto() {
        System.out.print("Presupuesto máximo: ");
        double presupuesto = scanner.nextDouble();
        scanner.nextLine(); // Limpia el buffer
        return presupuesto;
    }

    public String leerNombreLocalidad() {
        System.out.print("Ingrese la localidad: ");
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarDisponibilidad(String disponibilidad) {
        System.out.println(disponibilidad);
    }

    public void mostrarReporteCaja(String reporte) {
        System.out.println(reporte);
    }
}