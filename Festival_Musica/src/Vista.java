import java.util.InputMismatchException;
import java.util.Scanner;

public class Vista {

    private Scanner scanner = new Scanner(System.in);

    public String pedirTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public int pedirEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                int numero = scanner.nextInt();
                scanner.nextLine();
                return numero;

            } catch (InputMismatchException e) {
                System.out.println(
                    "Error: debe ingresar un número entero."
                );

                scanner.nextLine();
            }
        }
    }

    public void mostrarMenu() {
        System.out.println("\n===== FESTIVAL UNIVERSITARIO DE MÚSICA =====");
        System.out.println("1. Nuevo festival");
        System.out.println("2. Configurar escenario");
        System.out.println("3. Consultar escenarios");
        System.out.println("4. Consultar un escenario");
        System.out.println("5. Modificar escenario");
        System.out.println("6. Retirar escenario");
        System.out.println("7. Registrar artista");
        System.out.println("8. Consultar artistas");
        System.out.println("9. Buscar artista");
        System.out.println("10. Modificar artista");
        System.out.println("11. Cancelar participación");
        System.out.println("12. Mostrar reporte del festival");
        System.out.println("13. Salir");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

}
