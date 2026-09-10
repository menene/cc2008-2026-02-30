import java.util.InputMismatchException;
import java.util.Scanner;

public class VistaFestival {
    private Scanner scanner;

    public VistaFestival() {
        scanner = new Scanner(System.in);
    }

    public int mostrarMenu() throws InputMismatchException {
        System.out.println("\n========== FESTIVAL UNIVERSITARIO DE MÚSICA ==========");
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
        return leerEntero("Seleccione una opción: ");
    }

    public int leerEntero(String mensaje) throws InputMismatchException {
        System.out.print(mensaje);
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarEscenario(int posicion, Escenario escenario) {
        System.out.println("Posición " + posicion + ": " + escenario);
    }

    public void mostrarArtista(Artista artista) {
        System.out.println(artista);
    }

    public void mostrarReporte(int escenariosConfigurados, int espaciosDisponibles,
                               Escenario mayorCapacidad, int artistasRegistrados,
                               Artista mayorDuracion, Artista mayorAsistencia,
                               double promedioDuracion) {
        System.out.println("\n========== REPORTE DEL FESTIVAL ==========");
        System.out.println("Escenarios configurados: " + escenariosConfigurados);
        System.out.println("Espacios disponibles: " + espaciosDisponibles);
        System.out.println("Escenario con mayor capacidad: "
                + (mayorCapacidad == null ? "No aplica" : mayorCapacidad));
        System.out.println("Artistas registrados: " + artistasRegistrados);
        System.out.println("Artista con presentación de mayor duración: "
                + (mayorDuracion == null ? "No aplica" : mayorDuracion));
        System.out.println("Artista con mayor asistencia estimada: "
                + (mayorAsistencia == null ? "No aplica" : mayorAsistencia));
        System.out.printf("Promedio de duración: %.2f minutos%n", promedioDuracion);
    }

    public void limpiarEntrada() {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    public void mostrarFinOperacion() {
        System.out.println("------------------------------------------------------");
    }

    public void cerrar() {
        scanner.close();
    }
}
