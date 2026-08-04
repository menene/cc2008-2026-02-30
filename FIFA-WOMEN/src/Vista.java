 import java.util.Scanner;
import java.util.InputMismatchException;


public class Vista {
    private Scanner scanner;

    public Vista() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n=== MUNDIAL FEMENINO FIFA 2027 ===");
        System.out.println("1. Nuevo comprador");
        System.out.println("2. Nueva solicitud de boletos");
        System.out.println("3. Consultar disponibilidad total");
        System.out.println("4. Consultar disponibilidad individual");
        System.out.println("5. Reporte de caja");
        System.out.println("6. Salir");
    }

    public Comprador leerComprador() {
        System.out.println("\n--- REGISTRO DE COMPRADOR ---");
        System.out.println("Ingrese su nombre:");
        String nombre = scanner.nextLine();
       
        System.out.println("Ingrese su email:");
        String email = scanner.nextLine();
       
        int boletos = 0;
        double presupuesto = 0.0;


        while (true) {
            try {
                System.out.println("Cantidad de boletos a comprar:");
                boletos = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número entero válido.");
                scanner.nextLine();
            }
        }

        while (true) {
            try {
                System.out.println("Presupuesto máximo ($):");
                presupuesto = scanner.nextDouble();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un monto válido.");
                scanner.nextLine();
            }
        }

        return new Comprador(nombre, email, boletos, presupuesto);
    }

    public int leerLocalidad() {
        while (true) {
            try {
                System.out.println("Ingrese la localidad a consultar (1, 5 o 10):");
                int loc = scanner.nextInt();
                scanner.nextLine();
                return loc;
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.nextLine();
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
   
    public int leerOpcionMenu() {
        while (true) {
            try {
                System.out.println("Seleccione una opción (1-6):");
                int op = scanner.nextInt();
                scanner.nextLine();
                return op;
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número entero.");
                scanner.nextLine();
            }
        }
    }
}
