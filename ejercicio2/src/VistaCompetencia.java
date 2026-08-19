import java.util.Scanner;

public class VistaCompetencia {

    private Scanner scanner;

    public VistaCompetencia() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n--- Torneo Universitario de Atletismo ---");
        System.out.println("1. Nuevo atleta");
        System.out.println("2. Registrar nuevo intento");
        System.out.println("3. Consultar tiempos");
        System.out.println("4. Consultar un intento");
        System.out.println("5. Modificar tiempo");
        System.out.println("6. Mostrar promedio");
        System.out.println("7. Mostrar mejor y mayor tiempo");
        System.out.println("8. Consultar intentos disponibles");
        System.out.println("0. Salir");
        System.out.print("Selecciona una opción: ");
    }

    public int leerOpcion() {
        return Integer.parseInt(scanner.nextLine());
    }

    public String leerNombreAtleta() {
        System.out.print("Nombre del atleta: ");
        return scanner.nextLine();
    }

    public int leerNumeroParticipante() {
        System.out.print("Número de participante: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public int leerEdad() {
        System.out.print("Edad: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public double leerTiempo() {
        System.out.print("Tiempo obtenido (segundos): ");
        return Double.parseDouble(scanner.nextLine());
    }

    public int leerNumeroIntento() {
        System.out.print("Número de intento: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}