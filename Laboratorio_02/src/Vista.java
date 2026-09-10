import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Vista {
    private Scanner scanner;
    public Vista(Scanner scanner) {
        this.scanner = scanner;
    }
    public int MostrarMenu() {
        System.out.println(
            "\n===== FESTIVAL UNIVERSITARIO =====" +
            "\n1. Nuevo festival" +
            "\n2. Configurar escenario" +
            "\n3. Consultar escenarios" +
            "\n4. Consultar un escenario" +
            "\n5. Modificar escenario" +
            "\n6. Retirar escenario" +
            "\n7. Registrar artista" +
            "\n8. Consultar artistas" +
            "\n9. Buscar artista" +
            "\n10. Modificar artista" +
            "\n11. Cancelar participación" +
            "\n12. Mostrar reporte" +
            "\n13. Salir"
        );
        System.out.print("Seleccione una opción: ");
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            return opcion;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Debe ingresar un número entero.");
            return -1;
        }
    }
    public int PedirPosicion() {
        System.out.print("Ingrese la posición (0-4): ");
        try {
            int posicion = scanner.nextInt();
            scanner.nextLine();
            return posicion;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw new InputMismatchException(
                "La posición debe ser un número entero."
            );
        }
    }
    public Escenario PedirDatosEscenario() {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ubicación: ");
        String ubicacion = scanner.nextLine();
        try {
            System.out.print("Capacidad máxima: ");
            int capacidad = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Estado: ");
            String estado = scanner.nextLine();
            return new Escenario(
                codigo, nombre, ubicacion, capacidad, estado
            );
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw new InputMismatchException(
                "La capacidad debe ser un número entero."
            );
        }
    }
    public Artista PedirDatosArtista() {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Género musical: ");
        String genero = scanner.nextLine();
        try {
            System.out.print("Duración en minutos: ");
            int duracion = scanner.nextInt();
            System.out.print("Asistentes estimados: ");
            int asistentes = scanner.nextInt();
            scanner.nextLine();
            return new Artista(
                codigo, nombre, genero, duracion, asistentes
            );
        } catch (InputMismatchException e) {
            scanner.nextLine();
            throw new InputMismatchException(
                "La duración y los asistentes deben ser números enteros."
            );
        }
    }
    public void MostrarEscenarios(Escenario[] escenarios) {
        boolean existenEscenarios = false;
        System.out.println("\n===== ESCENARIOS =====");
        for (int i = 0; i <escenarios.length; i++) {
            if (escenarios[i] != null) {
                existenEscenarios = true;
                Escenario escenario = escenarios[i];
                System.out.println(
                    "\nPosición: " + i +
                    "\nCódigo: " + escenario.getCodigo() +
                    "\nNombre: " + escenario.getNombre() +
                    "\nUbicación: " + escenario.getUbicacion() +
                    "\nCapacidad: " + escenario.getCapacidadMaxima() +
                    "\nEstado: " + escenario.getEstado()
                );
            }
        }
        if (!existenEscenarios) {
            System.out.println("No existen escenarios configurados.");
        }
    }
    public void MostrarArtista(Artista artista) {
        if (artista == null) {
            System.out.println("El artista no fue encontrado.");
            return;
        }
        System.out.println(
            "\nCódigo: " + artista.getCodigo() +
            "\nNombre: " + artista.getNombre() +
            "\nGénero: " + artista.getGenero() +
            "\nDuración: " + artista.getDuracion() + " minutos" +
            "\nAsistentes estimados: " + artista.getAsistencia()
        );
    }
    public void MostrarArtistas(ArrayList<Artista> artistas) {
        if (artistas.isEmpty()) {
            System.out.println("No existen artistas registrados.");
            return;
        }
        System.out.println("\n===== ARTISTAS =====");
        for (Artista artista : artistas) {
            MostrarArtista(artista);
        }
    }
    public void MostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    public void MostrarReporte(Festival festival) {
        System.out.println(
            "\n===== REPORTE DEL FESTIVAL =====" +
            "\nNombre: " + festival.getNombre() +
            "\nCódigo: " + festival.getCodigo() +
            "\nCoordinador: " + festival.getNombreCoordinador() +
            "\nEscenarios configurados: " +
            festival.ContarEscenarios() +
            "\nEspacios disponibles: " +
            festival.EspaciosDisponibles() +
            "\nArtistas registrados: " +
            festival.ContarArtistas());
        Escenario escenario = festival.EscenarioMayor();
        Artista artista = festival.ArtistaMayorDuracion();
        if (escenario != null) {
            System.out.println(
                "Escenario con mayor capacidad: " +
                escenario.getNombre()
            );
        } else {
            System.out.println("No hay escenarios configurados.");
        }
        if (artista != null) {
            System.out.println(
                "Artista con mayor duración: " +
                artista.getNombre() +
                "\nPromedio de duración: " +
                festival.CalcularPromedioDuracion() + " minutos"
            );
        } else {
            System.out.println("No hay artistas registrados.");
        }
    }
}