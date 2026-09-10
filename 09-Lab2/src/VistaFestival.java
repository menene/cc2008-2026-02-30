import java.util.Scanner;
import java.util.InputMismatchException;    

public class VistaFestival {

    private final Scanner scanner;

    public VistaFestival() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n===== FESTIVAL =====");
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
        System.out.println("11. Cancelar participacion");
        System.out.println("12. Mostrar reporte del festival");
        System.out.println("13. Salir");
    }

    // Métodos para leer datos de entrada y mostrar mensajes
    public int solicitarOpcion() {
        return leerEntero("Seleccione una opcion: ");
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public int leerEntero(String mensaje) {
    while (true) {
        try {
            System.out.print(mensaje);

            int valor = scanner.nextInt();
            scanner.nextLine();

            return valor;

        } catch (InputMismatchException e) {
            System.out.println(
                    "Error: debe ingresar un numero entero."
            );

            // Elimina la entrada incorrecta del Scanner.
            scanner.nextLine();
            }
        }
    }


    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarError(String mensaje) {
        System.out.println("Error: " + mensaje);
    }

    //Muestra la información de un festival, escenario o artista en la consola
    public void mostrarFestival(Festival festival) {
        System.out.println("\n===== INFORMACION DEL FESTIVAL =====");
        System.out.println("Nombre: " + festival.getNombre());
        System.out.println("Codigo: " + festival.getCodigo());
        System.out.println(
                "Coordinador: " + festival.getCoordinador()
        );
    }

    public void mostrarEscenario(
            int posicion,
            Escenario escenario) {

        System.out.println("\nPosicion del arreglo: " + posicion);
        System.out.println("Codigo: " + escenario.getCodigo());
        System.out.println("Nombre: " + escenario.getNombre());
        System.out.println("Ubicacion: " + escenario.getUbicacion());
        System.out.println(
                "Capacidad maxima: "
                + escenario.getCapacidadMaxima()
        );
        System.out.println("Estado: " + escenario.getEstado());
    }

    //Muestra la información de un artista en la consola
    public void mostrarArtista(Artista artista) {
        System.out.println("\nCodigo: " + artista.getCodigo());
        System.out.println(
                "Nombre artistico: "
                + artista.getNombreArtistico()
        );
        System.out.println(
                "Genero musical: "
                + artista.getGeneroMusical()
        );
        System.out.println(
                "Duracion: "
                + artista.getDuracionPresentacion()
                + " minutos"
        );
        System.out.println(
                "Asistentes estimados: "
                + artista.getCantidadEstimadaAsistentes()
        );
    }

    public void mostrarReporte(int escenariosConfigurados, int espaciosDisponibles, Escenario escenarioMayorCapacidad,
            int cantidadArtistas, Artista artistaMayorDuracion, Artista artistaMayorAsistencia, double promedioDuracion) {

        System.out.println("\n===== REPORTE DEL FESTIVAL =====");
        System.out.println(
                "Escenarios configurados: "
                + escenariosConfigurados
        );
        System.out.println(
                "Espacios disponibles: "
                + espaciosDisponibles
        );

        if (escenarioMayorCapacidad != null) {
            System.out.println(
                    "Escenario con mayor capacidad: "
                    + escenarioMayorCapacidad.getNombre()
                    + " ("
                    + escenarioMayorCapacidad.getCapacidadMaxima()
                    + " asistentes)"
            );
        } else {
            System.out.println(
                    "Escenario con mayor capacidad: no disponible"
            );
        }

        System.out.println(
                "Artistas registrados: " + cantidadArtistas
        );

        if (artistaMayorDuracion != null) {
            System.out.println(
                    "Artista con mayor duracion: "
                    + artistaMayorDuracion.getNombreArtistico()
                    + " ("
                    + artistaMayorDuracion.getDuracionPresentacion()
                    + " minutos)"
            );
        } else {
            System.out.println(
                    "Artista con mayor duracion: no disponible"
            );
        }

        if (artistaMayorAsistencia != null) {
            System.out.println(
                    "Artista con mayor asistencia estimada: "
                    + artistaMayorAsistencia.getNombreArtistico()
                    + " ("
                    + artistaMayorAsistencia
                            .getCantidadEstimadaAsistentes()
                    + " asistentes)"
            );
        } else {
            System.out.println(
                    "Artista con mayor asistencia: no disponible"
            );
        }

        System.out.printf(
                "Promedio de duracion: %.2f minutos%n",
                promedioDuracion
        );
    }

    public void cerrar() {
        scanner.close();
    }
}