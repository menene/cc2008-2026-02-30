import java.util.Scanner;

public class VistaFestival {

    private Scanner scanner;

    public VistaFestival() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n========== FESTIVAL UNIVERSITARIO ==========");
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
        System.out.println("============================================");
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public int leerEntero(String mensaje) {
        System.out.print(mensaje);

        int valor = scanner.nextInt();
        scanner.nextLine();

        return valor;
    }

    public void limpiarEntrada() {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarError(String mensaje) {
        System.out.println("Error: " + mensaje);
    }

    public void mostrarFestival(Festival festival) {
        System.out.println("\n========== INFORMACIÓN DEL FESTIVAL ==========");
        System.out.println(festival);
    }

    public void mostrarEscenario(
            Escenario escenario,
            int posicion) {

        System.out.println("\nEscenario en la posición " + posicion + ":");
        System.out.println(escenario);
    }

    public void mostrarArtista(Artista artista) {
        System.out.println("\nInformación del artista:");
        System.out.println(artista);
    }

    public void mostrarReporte(
            int configurados,
            int disponibles,
            Escenario mayorCapacidad,
            int cantidadArtistas,
            Artista mayorDuracion,
            Artista mayorAsistencia,
            double promedioDuracion) {

        System.out.println("\n========== REPORTE DEL FESTIVAL ==========");

        System.out.println(
            "Escenarios configurados: " + configurados
        );

        System.out.println(
            "Espacios disponibles: " + disponibles
        );

        if (mayorCapacidad != null) {
            System.out.println(
                "\nEscenario con mayor capacidad:"
            );
            System.out.println(mayorCapacidad);
        } else {
            System.out.println(
                "\nNo existen escenarios configurados."
            );
        }

        System.out.println(
            "\nCantidad de artistas registrados: "
            + cantidadArtistas
        );

        if (mayorDuracion != null) {
            System.out.println(
                "\nArtista con la presentación de mayor duración:"
            );
            System.out.println(mayorDuracion);
        } else {
            System.out.println(
                "\nNo existen artistas registrados."
            );
        }

        if (mayorAsistencia != null) {
            System.out.println(
                "\nArtista con mayor público estimado:"
            );
            System.out.println(mayorAsistencia);
        }

        System.out.printf(
            "%nPromedio de duración: %.2f minutos%n",
            promedioDuracion
        );

        System.out.println("==========================================");
    }

    public void cerrar() {
        scanner.close();
    }
}