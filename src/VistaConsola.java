import java.util.Scanner;

public class VistaConsola {

    private Scanner scanner;

    //constructor
    public VistaConsola() {
        scanner = new Scanner(System.in);
    }

    //muestra el menu principal
    public void mostrarMenu(Festival festival) {
        System.out.println("\n===== FESTIVAL UNIVERSITARIO DE MUSICA =====");

        if (festival != null) {
            System.out.println("Festival actual: " + festival.getNombre());
        }

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

    //lee un numero entero
    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    //lee texto ingresado por el usuario
    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    //muestra mensajes al usuario
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    //muestra la informacion de un escenario
    public void mostrarEscenario(int posicion, Escenario escenario) {
        System.out.println("\nPosicion: " + posicion);
        System.out.println("Codigo: " + escenario.getCodigo());
        System.out.println("Nombre: " + escenario.getNombre());
        System.out.println("Ubicacion: " + escenario.getUbicacion());
        System.out.println("Capacidad maxima: " + escenario.getCapacidadMaxima());
        System.out.println("Estado: " + escenario.getEstado());
    }

    //muestra la informacion de un artista
    public void mostrarArtista(Artista artista) {
        System.out.println("\nCodigo: " + artista.getCodigo());
        System.out.println("Nombre artistico: " + artista.getNombreArtistico());
        System.out.println("Genero musical: " + artista.getGeneroMusical());
        System.out.println("Duracion de presentacion: "
                + artista.getDuracionPresentacion() + " minutos");
        System.out.println("Cantidad estimada de asistentes: "
                + artista.getCantidadEstimadaAsistentes());
    }

    //muestra el reporte general del festival
    public void mostrarReporte(int escenariosConfigurados,
                               int espaciosDisponibles,
                               Escenario escenarioMayorCapacidad,
                               int cantidadArtistas,
                               Artista artistaMayorDuracion,
                               Artista artistaMayorAsistencia,
                               double promedioDuracion) {

        System.out.println("\n===== REPORTE DEL FESTIVAL =====");

        System.out.println("Escenarios configurados: " + escenariosConfigurados);
        System.out.println("Espacios disponibles: " + espaciosDisponibles);

        if (escenarioMayorCapacidad != null) {
            System.out.println("\nEscenario con mayor capacidad:");
            System.out.println("Codigo: " + escenarioMayorCapacidad.getCodigo());
            System.out.println("Nombre: " + escenarioMayorCapacidad.getNombre());
            System.out.println("Ubicacion: " + escenarioMayorCapacidad.getUbicacion());
            System.out.println("Capacidad maxima: "
                    + escenarioMayorCapacidad.getCapacidadMaxima());
            System.out.println("Estado: " + escenarioMayorCapacidad.getEstado());
        } else {
            System.out.println("No hay escenarios configurados.");
        }

        System.out.println("\nCantidad de artistas registrados: " + cantidadArtistas);

        if (artistaMayorDuracion != null) {
            System.out.println("\nArtista con la presentacion de mayor duracion:");
            mostrarArtista(artistaMayorDuracion);
        } else {
            System.out.println("No hay artistas registrados.");
        }

        if (artistaMayorAsistencia != null) {
            System.out.println("\nArtista con mayor cantidad estimada de asistentes:");
            mostrarArtista(artistaMayorAsistencia);
        }

        System.out.println("\nPromedio de duracion: "
                + promedioDuracion + " minutos");
    }

    //limpia una entrada incorrecta del Scanner
    public void limpiarEntrada() {
        scanner.nextLine();
    }
}