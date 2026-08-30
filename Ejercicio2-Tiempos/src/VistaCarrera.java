import java.util.Scanner;

public class VistaCarrera {
    //scanner utilizado para leer todos los datos ingresados por el usuario
    private Scanner scanner;

    //constructor que prepara la lectura desde la consola
    public VistaCarrera() {
        scanner = new Scanner(System.in);
    }

    //muestra las nueve opciones disponibles en el sistema
    public void mostrarMenu() {
        System.out.println("\n--- Control de tiempos ---");
        System.out.println("1. Nuevo atleta");
        System.out.println("2. Registrar nuevo intento");
        System.out.println("3. Consultar tiempos");
        System.out.println("4. Consultar un intento");
        System.out.println("5. Modificar tiempo");
        System.out.println("6. Mostrar promedio");
        System.out.println("7. Mostrar mejor y mayor tiempo");
        System.out.println("8. Consultar intentos disponibles");
        System.out.println("9. Salir");
    }

    //solicita y devuelve la opcion seleccionada en el menu
    public int solicitarOpcionMenu() {
        return leerEntero("Seleccione una opcion: ");
    }

    //solicita un nombre y evita que se ingrese una cadena vacia
    public String solicitarNombreAtleta() {
        String nombre;

        do {
            System.out.print("Ingrese el nombre del atleta: ");
            nombre = scanner.nextLine().trim();

            if (nombre.isEmpty()) {
                mostrarMensaje("El nombre no puede estar vacio.");
            }
        } while (nombre.isEmpty());

        return nombre;
    }

    //metodos para solicitar los datos necesarios al usuario
    public int solicitarNumeroParticipante() {
        return leerEntero("Ingrese el numero de participante: ");
    }

    public int solicitarEdad() {
        return leerEntero("Ingrese la edad del atleta: ");
    }

    public double solicitarTiempo() {
        return leerDouble("Ingrese el tiempo en segundos: ");
    }

    public int solicitarNumeroIntento() {
        return leerEntero("Ingrese el numero de intento: ");
    }

    //muestra cualquier resultado o notificacion del controlador
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    //lee un entero y repite la solicitud cuando el formato es incorrecto
    private int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException excepcion) {
                mostrarMensaje("Entrada invalida. Debe ingresar un numero entero.");
            }
        }
    }

    //lee un numero decimal y repite la solicitud si no se puede convertir
    private double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();

            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException excepcion) {
                mostrarMensaje("Entrada invalida. Debe ingresar un numero.");
            }
        }
    }
}