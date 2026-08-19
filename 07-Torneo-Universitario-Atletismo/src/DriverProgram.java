import java.util.Scanner;

public class DriverProgram {

    private static Atleta atletaActivo;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        crearAtleta();

        int opcion = 0;

        do {
            System.out.println("\nTorneo Universitario de Atletismo");
            System.out.println("1. Nuevo atleta");
            System.out.println("2. Registrar nuevo intento");
            System.out.println("3. Consultar tiempos");
            System.out.println("4. Consultar un intento");
            System.out.println("5. Modificar tiempo");
            System.out.println("6. Mostrar promedio");
            System.out.println("7. Mostrar mejor y mayor tiempo");
            System.out.println("8. Consultar intentos disponibles");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
            } else {
                System.out.println("Error, debe ingresar un número");
                scanner.next();
                continue;
            }

            switch (opcion) {

                case 1:
                    crearAtleta();
                    break;

                case 2:
                    registrarIntento();
                    break;

                case 3:
                    consultarTiempos();
                    break;

                case 4:
                    consultarIntento();
                    break;

                case 5:
                    modificarTiempo();
                    break;

                case 6:
                    mostrarPromedio();
                    break;

                case 7:
                    mostrarExtremos();
                    break;

                case 8:
                    mostrarIntentosDisponibles();
                    break;

                case 9:
                    System.out.println("Programa terminado");
                    break;

                default:
                    System.out.println("Error, opción inválida");
            }

        } while (opcion != 9);

        scanner.close();
    }

    private static void crearAtleta() {

        scanner.nextLine();

        System.out.print("Ingrese el nombre del atleta: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el número de participante: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Error, debe ingresar un número entero");
            scanner.next();
            System.out.print("Ingrese el número de participante: ");
        }

        int numeroParticipante = scanner.nextInt();

        System.out.print("Ingrese la edad: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Error, debe ingresar un número entero");
            scanner.next();
            System.out.print("Ingrese la edad: ");
        }

        int edad = scanner.nextInt();

        atletaActivo = new Atleta(nombre, numeroParticipante, edad);

        System.out.println("Atleta creado correctamente");
    }

    private static void registrarIntento() {

        System.out.print("Ingrese el tiempo obtenido en segundos: ");

        while (!scanner.hasNextDouble()) {
            System.out.println("Error, debe ingresar un número");
            scanner.next();
            System.out.print("Ingrese el tiempo obtenido en segundos: ");
        }

        double tiempo = scanner.nextDouble();

        boolean registrado = atletaActivo.registrarIntento(tiempo);

        if (registrado) {
            System.out.println("Intento registrado correctamente");
        } else {
            System.out.println(
                    "Error, el tiempo debe ser mayor que 0 y debe haber espacio disponible"
            );
        }
    }

    private static void consultarTiempos() {

        if (atletaActivo.getCantidadIntentos() == 0) {
            System.out.println("No hay intentos registrados");
            return;
        }

        System.out.println("\nTiempos registrados");

        for (int i = 1; i <= atletaActivo.getCantidadIntentos(); i++) {

            double tiempo = atletaActivo.consultarTiempo(i);

            System.out.println(
                    "Intento " + i + ": " + tiempo + " segundos"
            );
        }
    }

    private static void consultarIntento() {

        System.out.print("Ingrese el número de intento: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Error, debe ingresar un número entero");
            scanner.next();
            System.out.print("Ingrese el número de intento: ");
        }

        int numeroIntento = scanner.nextInt();

        double tiempo = atletaActivo.consultarTiempo(numeroIntento);

        if (tiempo == -1) {
            System.out.println(
                    "Error, el intento no ha sido registrado"
            );
        } else {
            System.out.println(
                    "Tiempo del intento " + numeroIntento
                    + ": " + tiempo + " segundos"
            );
        }
    }

    private static void modificarTiempo() {

        System.out.print("Ingrese el número de intento que desea modificar: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Error, debe ingresar un número entero");
            scanner.next();
            System.out.print("Ingrese el número de intento que desea modificar: ");
        }

        int numeroIntento = scanner.nextInt();

        System.out.print("Ingrese el nuevo tiempo: ");

        while (!scanner.hasNextDouble()) {
            System.out.println("Error, debe ingresar un número");
            scanner.next();
            System.out.print("Ingrese el nuevo tiempo: ");
        }

        double nuevoTiempo = scanner.nextDouble();

        boolean modificado =
                atletaActivo.modificarTiempo(numeroIntento, nuevoTiempo);

        if (modificado) {
            System.out.println("Tiempo modificado correctamente");
        } else {
            System.out.println(
                    "Error, el intento no existe o el nuevo tiempo no es válido"
            );
        }
    }

    private static void mostrarPromedio() {

        double promedio = atletaActivo.calcularPromedio();

        if (promedio == -1) {
            System.out.println(
                    "Error, todavía no hay intentos registrados"
            );
        } else {
            System.out.println(
                    "Tiempo promedio: " + promedio + " segundos"
            );
        }
    }

    private static void mostrarExtremos() {

        double mejorTiempo = atletaActivo.obtenerMejorTiempo();
        double mayorTiempo = atletaActivo.obtenerMayorTiempo();

        if (mejorTiempo == -1) {
            System.out.println(
                    "Error, todavía no hay intentos registrados"
            );
        } else {
            System.out.println(
                    "Mejor tiempo: " + mejorTiempo + " segundos"
            );

            System.out.println(
                    "Tiempo más alto: " + mayorTiempo + " segundos"
            );
        }
    }

    private static void mostrarIntentosDisponibles() {

        System.out.println(
                "Intentos realizados: "
                + atletaActivo.getCantidadIntentos()
        );

        System.out.println(
                "Intentos disponibles: "
                + atletaActivo.getIntentosDisponibles()
        );
    }
}