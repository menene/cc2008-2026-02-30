import java.util.Scanner;

public class Vista {

    private Scanner scanner;
    
    public Vista() {
        scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {

        System.out.println();
        System.out.println("CONTROL DE TIEMPOS");
        System.out.println("1. Nuevo atleta");
        System.out.println("2. Registrar nuevo intento");
        System.out.println("3. Consultar tiempos");
        System.out.println("4. Consultar intento");
        System.out.println("5. Modificar tiempo");
        System.out.println("6. Mostrar promedio");
        System.out.println("7. Mostrar mayor y mejor tiempo");
        System.out.println("8. Mostrar intentos disponibles");
        System.out.println("9. Salir");
        System.out.print("Seleccione una opcion: ");
        return scanner.nextInt();
    }

    public String pedirNombre() {
        System.out.print("Ingrese el nombre: ");
        return scanner.next();
    }

    public int pedirNumeroParticipante() {
        System.out.print("Ingrese el numero de participante: ");
        return scanner.nextInt();
    }

    public int pedirEdad() {
        System.out.print("Ingrese la edad: ");
        return scanner.nextInt();
    }

    public double pedirTiempo() {
        System.out.print("Ingrese el tiempo: ");
        return scanner.nextDouble();
    }

    public int pedirNumeroIntento() {
        System.out.print("Ingrese el numero del intento: ");
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}