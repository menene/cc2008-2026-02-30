import java.util.Scanner;

/**
 * Clase Main
 * Inicia el programa, solicita los datos, muestra el menú y coordina
 * las operaciones del sistema de control de tiempos del torneo.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Atleta atleta = null;
        ControlTiempos control = null;

        // Al iniciar el programa se solicita la información del atleta.
        System.out.println("=== Control de Tiempos - Torneo Universitario de Atletismo ===");
        atleta = crearAtleta(sc);
        control = new ControlTiempos();

        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = leerEntero(sc, "Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    atleta = crearAtleta(sc);
                    control = new ControlTiempos();
                    System.out.println("Nuevo atleta registrado correctamente.\n");
                    break;

                case 2:
                    registrarIntento(sc, control);
                    break;

                case 3:
                    consultarTiempos(control);
                    break;

                case 4:
                    consultarIntento(sc, control);
                    break;

                case 5:
                    modificarTiempo(sc, control);
                    break;

                case 6:
                    mostrarPromedio(control);
                    break;

                case 7:
                    mostrarMejorYMayor(control);
                    break;

                case 8:
                    consultarIntentosDisponibles(control);
                    break;

                case 9:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.\n");
            }
        }

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("---------------------------------------------");
        System.out.println("Atleta actual: (usa la opción 1 para reemplazarlo)");
        System.out.println("1. Nuevo atleta");
        System.out.println("2. Registrar nuevo intento");
        System.out.println("3. Consultar tiempos");
        System.out.println("4. Consultar un intento");
        System.out.println("5. Modificar tiempo");
        System.out.println("6. Mostrar promedio");
        System.out.println("7. Mostrar mejor y mayor tiempo");
        System.out.println("8. Consultar intentos disponibles");
        System.out.println("9. Salir");
        System.out.println("---------------------------------------------");
    }

    private static Atleta crearAtleta(Scanner sc) {
        System.out.println("\n--- Datos del atleta ---");

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        int numeroParticipante = leerEntero(sc, "Número de participante: ");
        int edad = leerEntero(sc, "Edad: ");

        return new Atleta(nombre, numeroParticipante, edad);
    }

    private static void registrarIntento(Scanner sc, ControlTiempos control) {
        if (!control.hayEspacioDisponible()) {
            System.out.println("No hay espacio disponible. Ya se registraron los 10 intentos permitidos.\n");
            return;
        }

        double tiempo = leerDouble(sc, "Ingrese el tiempo obtenido (segundos): ");

        boolean registrado = control.registrarTiempo(tiempo);
        if (registrado) {
            System.out.println("Tiempo registrado correctamente.\n");
        } else {
            System.out.println("No se pudo registrar el tiempo. Verifique que sea mayor que 0.\n");
        }
    }

    private static void consultarTiempos(ControlTiempos control) {
        int cantidad = control.getCantidadIntentos();

        if (cantidad == 0) {
            System.out.println("Todavía no se han registrado intentos.\n");
            return;
        }

        double[] tiempos = control.getTiempos();
        System.out.println("\n--- Tiempos registrados ---");
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Intento " + (i + 1) + ": " + tiempos[i] + " segundos");
        }
        System.out.println();
    }

    private static void consultarIntento(Scanner sc, ControlTiempos control) {
        if (control.getCantidadIntentos() == 0) {
            System.out.println("Todavía no se han registrado intentos.\n");
            return;
        }

        int numeroIntento = leerEntero(sc, "Ingrese el número de intento a consultar: ");

        if (numeroIntento < 1 || numeroIntento > control.getCantidadIntentos()) {
            System.out.println("Ese intento no ha sido registrado todavía.\n");
            return;
        }

        double tiempo = control.consultarTiempo(numeroIntento);
        System.out.println("El tiempo del intento " + numeroIntento + " es: " + tiempo + " segundos\n");
    }

    private static void modificarTiempo(Scanner sc, ControlTiempos control) {
        if (control.getCantidadIntentos() == 0) {
            System.out.println("Todavía no se han registrado intentos.\n");
            return;
        }

        int numeroIntento = leerEntero(sc, "Ingrese el número de intento a modificar: ");

        if (numeroIntento < 1 || numeroIntento > control.getCantidadIntentos()) {
            System.out.println("No se puede modificar un intento que todavía no ha sido registrado.\n");
            return;
        }

        double nuevoTiempo = leerDouble(sc, "Ingrese el nuevo tiempo (segundos): ");

        boolean modificado = control.modificarTiempo(numeroIntento, nuevoTiempo);
        if (modificado) {
            System.out.println("Tiempo modificado correctamente.\n");
        } else {
            System.out.println("No se pudo modificar el tiempo. Verifique que sea mayor que 0.\n");
        }
    }

    private static void mostrarPromedio(ControlTiempos control) {
        if (control.getCantidadIntentos() == 0) {
            System.out.println("Todavía no se han registrado intentos.\n");
            return;
        }
        System.out.printf("Promedio de tiempos: %.2f segundos%n%n", control.calcularPromedio());
    }

    private static void mostrarMejorYMayor(ControlTiempos control) {
        if (control.getCantidadIntentos() == 0) {
            System.out.println("Todavía no se han registrado intentos.\n");
            return;
        }
        System.out.printf("Mejor tiempo (más bajo): %.2f segundos%n", control.obtenerMejorTiempo());
        System.out.printf("Mayor tiempo (más alto): %.2f segundos%n%n", control.obtenerMayorTiempo());
    }

    private static void consultarIntentosDisponibles(ControlTiempos control) {
        System.out.println("Intentos registrados: " + control.getCantidadIntentos());
        System.out.println("Intentos disponibles: " + control.getIntentosDisponibles() + "\n");
    }

    // ----- Métodos auxiliares para lectura segura de datos -----

    private static int leerEntero(Scanner sc, String mensaje) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine();
            try {
                valor = Integer.parseInt(entrada.trim());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número entero.");
            }
        }
    }

    private static double leerDouble(Scanner sc, String mensaje) {
        double valor;
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine();
            try {
                valor = Double.parseDouble(entrada.trim());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número (puede tener decimales).");
            }
        }
    }
}