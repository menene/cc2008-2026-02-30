import java.util.InputMismatchException;
import java.util.Scanner;

public class VistaFestival {
    private Scanner sc;

    public VistaFestival() {
        sc = new Scanner(System.in);
    }
    
    // Muestra el menú y obtiene la opción ingresada por el usuario
    public int mostrarMenu(String msj) {
        System.out.println("""

                +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
                        FESTIVAL DE MÚSICA
                +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
                """);
        if (!msj.isEmpty()) {
            System.out.println(msj);
        }
        System.out.println(
            """
            1. Nuevo festival
            2. Configurar escenario
            3. Consultar escenarios
            4. Consultar un escenario
            5. Modificar escenario
            6. Retirar escenario
            7. Registrar artista
            8. Consultar artistas
            9. Buscar artista
            10. Modificar artista
            11. Cancelar participación
            12. Mostrar reporte del festival

            0. Salir
            +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
            """
        );

        return pedirInt("Seleccione una opción: ");
    }

    public String pedirString(String msj) {
        String entrada;
        do {
            System.out.print(msj);
            entrada = sc.nextLine().trim();
            if (entrada.isEmpty()) {
                System.out.println("Error: este campo no puede estar vacío.");
            }
        } while (entrada.isEmpty());

        return entrada;
    }

    // Estos métodos solicitan datos numéricos al usuario y maneja la posible excepción
    public int pedirInt(String msj) {
        while (true) {
            try {
                System.out.print(msj);
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: ingrese un número entero -_-");
            } finally {
                sc.nextLine();
            }
        }
    }

    public float pedirFloat(String msj) {
        while (true) {
            try {
                System.out.print(msj);
                return sc.nextFloat();
            } catch (InputMismatchException e) {
                System.out.println("Error: ingrese un número -_-");
            } finally {
                sc.nextLine();
            }
        }
    }

    // Muestra cualquier mensaje al usuario
    public void mostrarMensaje(String msj) {
        System.out.println(msj);
    }
}
