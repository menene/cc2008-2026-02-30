import java.util.Scanner;
import java.util.InputMismatchException;

public class VistaFestival {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenuPrincipal() throws InputMismatchException {
        System.out.println("\n=== MENÚ DEL FESTIVAL UNIVERSITARIO ===");
        System.out.println("1. Nuevo festival");
        System.out.println("2. Configurar escenario");
        System.out.println("3. Consultar escenarios");
        System.out.println("4. Consultar un escenario");
        System.out.println("5. Modificar escenario");
        System.out.println("6. Retirar escenario");
        System.out.println("7. Registrar artista");
        System.out.println("8. Consultar artistas");
        System.out.println("9. Buscar artista");
        System.out.println("10. Modificar artista");
        System.out.println("11. Cancelar participación");
        System.out.println("12. Mostrar reporte del festival");
        System.out.println("13. Salir");
        System.out.print("Seleccione una opción: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    public Escenario leerNuevoEscenario() throws InputMismatchException {
        System.out.println("\n--- CONFIGURACIÓN DE ESCENARIO ---");
        int id = pedirEntero("Ingrese el código del escenario:");
        String nombre = pedirTexto("Ingrese el nombre:");
        String ubicacion = pedirTexto("Ingrese la ubicación:");
        int maxAsis = pedirEntero("Ingrese la capacidad máxima de asistentes:");
        String estado = pedirTexto("Ingrese el estado (Ej. Disponible, En mantenimiento):");
        
        return new Escenario(id, nombre, ubicacion, maxAsis, estado);
    }

    public Artista leerNuevoArtista() throws InputMismatchException {
        System.out.println("\n--- REGISTRO DE ARTISTA ---");
        int id = pedirEntero("Ingrese el código del artista:");
        String nombre = pedirTexto("Ingrese el nombre artístico:");
        String genero = pedirTexto("Ingrese el género musical:");
        double duracion = pedirDouble("Ingrese la duración (minutos):");
        int asis = pedirEntero("Ingrese cantidad estimada de asistentes:");
        
        return new Artista(id, nombre, genero, duracion, asis);
    }

    public int pedirEntero(String mensaje) throws InputMismatchException {
        System.out.println(mensaje);
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }
    
    public double pedirDouble(String mensaje) throws InputMismatchException {
        System.out.println(mensaje);
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }

    public String pedirTexto(String mensaje) {
        System.out.println(mensaje);
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void limpiarEntrada() {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}