import java.util.Scanner;

public class VistaBoletos {
    private Scanner sc;

    public VistaBoletos() {
        sc = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\n=== Sistema de Boletos ===");
        System.out.println("1. Nuevo Comprador");
        System.out.println("2. Nueva Solicitud de Boletos");
        System.out.println("3. Consultar Total de Boletos Disponibles");
        System.out.println("4. Consultar Boletos por Localidad");
        System.out.println("5. Mostrar Reporte de Caja");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
        return sc.nextInt();
    }

    public Comprador leerComprador() {
        sc.nextLine();

        System.out.print("Ingrese su nombre : ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese su correo electrónico: ");
        String email = sc.nextLine();

        System.out.print("Ingrese la cantidad de boletos que desea comprar: ");
        int cantidadBoletos = sc.nextInt();

        System.out.print("Ingrese su presupuesto máximo: ");
        double presupuestoMaximo = sc.nextDouble();

        return new Comprador(nombre, email, cantidadBoletos, presupuestoMaximo);
    }

    public int leerLocalidad() {
        System.out.print("Ingrese la localidad (1, 5 o 10): ");
        return sc.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
