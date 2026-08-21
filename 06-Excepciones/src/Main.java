import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            menu();
        } catch (RuntimeException e) {
            System.out.println("\n[main] Llego una excepcion que nadie manejo antes.");
            System.out.println("[main] Tipo:    " + e.getClass().getSimpleName());
            System.out.println("[main] Mensaje: " + e.getMessage());
            System.out.println("[main] De donde vino:");
            for (StackTraceElement linea : e.getStackTrace()) {
                System.out.println("      " + linea);
            }
        } finally {
            System.out.println("\n[main] Fin del programa.");
        }
    }

    private static void menu() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n===== DEMOSTRACION DE EXCEPCIONES =====");
            System.out.println("1. Excepcion MANEJADA        (try / catch / finally)");
            System.out.println("2. Excepcion PROPAGADA       (nace abajo y se atrapa arriba)");
            System.out.println("3. Excepcion PERSONALIZADA   (SaldoInsuficienteException)");
            System.out.println("4. Excepcion SIN MANEJAR     (viaja hasta main y termina el programa)");
            System.out.println("0. Salir");

            int opcion = leerEntero("Seleccione una opcion: ");

            if (opcion == 1) {
                DemoExcepciones.manejada();
            } else if (opcion == 2) {
                DemoExcepciones.propagada();
            } else if (opcion == 3) {
                DemoExcepciones.personalizada();
            } else if (opcion == 4) {
                DemoExcepciones.sinManejar();
                System.out.println("Esta linea jamas se ejecuta.");
            } else if (opcion == 0) {
                continuar = false;
                System.out.println("Hasta luego.");
            } else {
                System.out.println("Opcion invalida. Intentalo nuevamente");
            }
        }
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine();

            try {
                return Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                System.out.println("  [!] \"" + entrada + "\" no es un numero entero. Intente de nuevo.");
            }
        }
    }
}
