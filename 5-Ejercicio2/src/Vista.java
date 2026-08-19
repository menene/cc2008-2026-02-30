import java.util.Scanner;


public class Vista {

    private Scanner scanner;

    public Vista() {
        scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\n TORNEO DE ATLETISMO ");
        System.out.println("1. Nuevo atleta");
        System.out.println("2. Registrar nuevo intento");
        System.out.println("3. Consultar tiempos");
        System.out.println("4. Consultar un intento");
        System.out.println("5. Modificar tiempo");
        System.out.println("6. Mostrar promedio");
        System.out.println("7. Mostrar mejor y mayor tiempo");
        System.out.println("8. Consultar intentos");
        System.out.println("9. Salir");
        System.out.print("Seleccione una opcion: ");
        return leerEntero();
    }

    public String pedirNombre() {
        System.out.print("Ingrese el nombre del atleta: ");
        return scanner.nextLine();
    }

    public int pedirNumeroParticipante() {
        System.out.print("Ingrese el numero de participante: ");
        return leerEntero();
    }

    public int pedirEdad() {
        System.out.print("Ingrese la edad del atleta: ");
        return leerEntero();
    }

    public double pedirTiempo() {
        System.out.print("Ingrese el tiempo obtenido en segundos: ");
        return leerDouble();
    }

    public int pedirNumeroIntento() {
        System.out.print("Ingrese el numero de intento: ");
        return leerEntero();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarTiempo(int numeroIntento, double tiempo) {
        System.out.println("Intento " + numeroIntento + ": " + tiempo + " segundos");
    }

    public void mostrarPromedio(double promedio) {
        System.out.println("Tiempo promedio: " + promedio + " segundos");
    }

    public void mostrarMejorYMayorTiempo(double mejor, double mayor) {
        System.out.println("Mejor tiempo (el mas bajo): " + mejor + " segundos");
        System.out.println("Mayor tiempo (el mas alto): " + mayor + " segundos");
    }

    public void mostrarIntentosDisponibles(int realizados, int disponibles) {
        System.out.println("Intentos realizados: " + realizados);
        System.out.println("Intentos disponibles: " + disponibles);
    }


    private int leerEntero() {
        while (!scanner.hasNextInt()) {
            System.out.print("Dato invalido, ingrese un numero entero: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); 
        return valor;
    }


    private double leerDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Dato invalido, ingrese un numero: ");
            scanner.next();
        }
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }
}
