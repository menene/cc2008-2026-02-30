import java.util.InputMismatchException;
import java.util.Scanner;

public class Vista {

    private Scanner scanner;

    public Vista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n===== FESTIVAL UNIVERSITARIO =====");
        System.out.println("1. Nuevo festival");
        System.out.println("2. Configurar escenario");
        System.out.println("3. Consultar escenarios");
        System.out.println("4. Consultar un escenario");
        System.out.println("5. Modificar escenario");
        System.out.println("6. Retirar escenario");
        System.out.println("--------------------");
        System.out.println("7. Registrar artista");
        System.out.println("8. Consultar artistas");
        System.out.println("9. Buscar artista");
        System.out.println("10. Modificar artista");
        System.out.println("11. Cancelar participación de un artista");
        System.out.println("--------------------");
        System.out.println("12. Mostrar reporte del festival");
        System.out.println("13. Salir");
    }

    public String solicitarString(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public int solicitarInt(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                int numero = scanner.nextInt();
                scanner.nextLine();
                return numero;
            } 
            catch (InputMismatchException e) {
                System.out.println("Entrada incorrecta. Debe ingresar un número entero.");
                scanner.nextLine();
            }
        }
    }

    public float solicitarFloat(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                float numero = scanner.nextFloat();
                scanner.nextLine();
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("Entrada incorrecta. Debe ingresar un número.");
                scanner.nextLine();
            }
        }
    }

    public boolean solicitarBoolean(String mensaje) {
        while (true) {
            int opcion = solicitarInt(mensaje + " (1. Activo | 2. Inactivo): ");

            if (opcion == 1) {
                return true;
            }

            if (opcion == 2) {
                return false;
            }

            mostrarMensaje("Opción incorrecta. Ingrese 1 o 2.");
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}