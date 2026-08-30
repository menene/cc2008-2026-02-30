import java.util.Scanner;

public class VistaAtleta {
    private Scanner scanner;

    public VistaAtleta() {
        this.scanner = new Scanner(System.in);
    }

    //con esto se depliega todo el menú
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
        System.out.println("9. Salir");
    }

    //para mostrar y leer mensajes
    public void mostrarMensaje(String mensaje) 
    {
        System.out.println(mensaje);
    }

    public String pedirCadena(String mensaje) 
    {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public int pedirEntero(String mensaje) 
    {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Error. Ingrese un número entero válido: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

    public double pedirDouble(String mensaje) 
    {
        System.out.print(mensaje);
        while (!scanner.hasNextDouble()) {
            System.out.print("Error. Ingrese un número decimal válido: ");
            scanner.next();
        }
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }

    public void mostrarListaTiempos(double[] tiempos, int cantidad) 
    {
        if (cantidad == 0) {
            System.out.println("No hay tiempos registrados para mostrar.");
            return;
        }
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Intento " + (i + 1) + ": " + tiempos[i] + " segundos");
        }
    }
}