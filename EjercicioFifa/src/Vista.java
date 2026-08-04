import java.util.Scanner;

public class Vista {
    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {

        System.out.println("\n======== Menú principal ========");
        System.out.println("1. Registre un nuevo comprador");
        System.out.println("2. Solicitud de boletos");
        System.out.println("3. Consultar disponibilidad total");
        System.out.println("4. Consultar disponibilidad individual");
        System.out.println("5. Reporte de recaudación");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");

        return Integer.parseInt(sc.nextLine());
    }

    public Comprador leerComprador() {
        System.out.println("\n-------- Nuevo comprador --------");

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Correo electrónico: ");
        String email = sc.nextLine();

        System.out.print("Cantidad de boletos: ");
        int cantidadBoletos = Integer.parseInt(sc.nextLine());

        System.out.print("Presupuesto máximo: ");
        float presupuestoMax = Float.parseFloat(sc.nextLine());

        return new Comprador(nombre, email, cantidadBoletos, presupuestoMax);
    }

    public int leerLocalidad() {
        System.out.println("\nIngrese la localidad a consultar (1, 5 o 10): ");
        return Integer.parseInt(sc.nextLine());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}