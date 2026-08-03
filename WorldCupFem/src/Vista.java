import java.util.Scanner;
public class Vista {

    private Scanner sc = new Scanner(System.in);

    public int Menu() {

        System.out.println("\n===== MENU VENTAS =====");
        System.out.println("1. Nuevo Usuario");
        System.out.println("2. Nueva solicitud de boletos");
        System.out.println("3. Disponibilidad de boletos totales");
        System.out.println("4. Disponibilidad de boletos por localidad");
        System.out.println("5. Reporte de ventas");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");

        return Integer.parseInt(sc.nextLine());
    }

    public Usuario leerComprador() {

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Correo: ");
        String email = sc.nextLine();

        System.out.print("Cantidad de boletos: ");
        int boletos = Integer.parseInt(sc.nextLine());

        System.out.print("Presupuesto máximo: ");
        int presupuesto = Integer.parseInt(sc.nextLine());

        return new Usuario(nombre, email, boletos, presupuesto);
    }

    public int leerLocalidad() {

        System.out.println("\nSeleccione una localidad");
        System.out.println("1. Localidad 1");
        System.out.println("2. Localidad 5");
        System.out.println("3. Localidad 10");

        return Integer.parseInt(sc.nextLine());
    }

    public void Resumen(Venta venta) {

        venta.Mostrar();
    }

    public void mostrarCaja(String localidad, int total) {

        System.out.println(localidad + ": Q" + total);
    }

    public void mensaje(String texto) {

        System.out.println(texto);
    }

}