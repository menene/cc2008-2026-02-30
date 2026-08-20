import java.util.Scanner;

public class VistaTorneo {
    
    private Scanner scanner;
    public VistaTorneo() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n----- TORNEO DE ATLETISMO -----");
        System.out.println("1. Nuevo atleta");
        System.out.println("2. Registrar nuevo intento");
        System.out.println("3. Consultar tiempos");
        System.out.println("4. Consultar un intento");
        System.out.println("5. Modificar tiempo");
        System.out.println("6. Mostrar promedio");
        System.out.println("7. Mostrar mejor y mayor tiempo");
        System.out.println("8. Consultar intentos disponibles");
        System.out.println("9. Mostrar mejor atleta");
        System.out.println("10. Salir\n");
    }

    public int solicitarOpcion() {
        System.out.print("Seleccione una opcion: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String solicitarNombre() {
        System.out.print("Ingrese el nombre del atleta: ");
        return scanner.nextLine();
    }

    public int solicitarNumeroParticipante() {
        System.out.print("Ingrese el numero de participante: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public int solicitarEdad() {
        System.out.print("Ingrese la edad del atleta: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public double solicitarTiempo() {
        System.out.print("Ingrese el tiempo en segundos: ");
        return Double.parseDouble(scanner.nextLine());
    }

    public int solicitarNumeroIntento() {
        System.out.print("Ingrese el numero de intento: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarTiempo(int numero, double tiempo) {
        System.out.println("Intento " + numero + ": " + tiempo + " segundos");
    }
}