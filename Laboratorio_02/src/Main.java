import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    private static Vista vista;
    private static Festival festival;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        vista = new Vista(scanner);
        NuevoFestival();
        int opcion;
        do {
            opcion = vista.MostrarMenu();
            try {
                EjecutarOpcion(opcion);
            } catch (InputMismatchException e) {
                scanner.nextLine();
                vista.MostrarMensaje("Debe ingresar un número entero.");
            } catch (IllegalArgumentException |
                     IndexOutOfBoundsException e) {
                vista.MostrarMensaje("Error: " + e.getMessage());
            } finally {
                vista.MostrarMensaje("Operación finalizada.");
            }
        } while (opcion != 13);
        scanner.close();
    }
    private static void EjecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                NuevoFestival();
                break;
            case 2:
                ConfigurarEscenario();
                break;
            case 3:
                ConsultarEscenarios();
                break;
            case 4:
                ConsultarEscenario();
                break;
            case 5:
                ModificarEscenario();
                break;
            case 6:
                RetirarEscenario();
                break;
            case 7:
                RegistrarArtista();
                break;
            case 8:
                ConsultarArtistas();
                break;
            case 9:
                BuscarArtista();
                break;
            case 10:
                ModificarArtista();
                break;
            case 11:
                CancelarParticipacion();
                break;
            case 12:
                MostrarReporte();
                break;
            case 13:
                vista.MostrarMensaje("Programa finalizado.");
                break;
            default:
                vista.MostrarMensaje("Opción no válida.");
        }
    }
    private static void NuevoFestival() {
        System.out.print("Nombre del festival: ");
        String nombre = scanner.nextLine();
        System.out.print("Código del festival: ");
        String codigo = scanner.nextLine();
        System.out.print("Nombre del coordinador: ");
        String coordinador = scanner.nextLine();
        festival = new Festival(codigo, nombre, coordinador, new Escenario[5], new ArrayList<Artista>());
        vista.MostrarMensaje("Festival creado correctamente.");
    }
    private static void ConfigurarEscenario() {
        int posicion = vista.PedirPosicion();
        if (!festival.PosicionValida(posicion)) {
            throw new IndexOutOfBoundsException("La posición debe estar entre 0 y 4.");
        }
        if (festival.getEscenarios()[posicion] != null) {
            throw new IllegalArgumentException("La posición ya contiene un escenario.");
        }
        festival.getEscenarios()[posicion] = vista.PedirDatosEscenario();
        vista.MostrarMensaje("Escenario configurado.");
    }
    private static void ConsultarEscenarios() {
        vista.MostrarEscenarios(festival.getEscenarios());
    }
    private static void ConsultarEscenario() {
        int posicion = vista.PedirPosicion();
        if (!festival.PosicionValida(posicion)) {
            throw new IndexOutOfBoundsException("La posición debe estar entre 0 y 4.");
        }
        Escenario escenario = festival.getEscenarios()[posicion];
        if (escenario == null) {
            vista.MostrarMensaje("La posición no contiene un escenario.");
            return;
        }
        vista.MostrarMensaje(
            "Código: " + escenario.getCodigo() +
            "\nNombre: " + escenario.getNombre() +
            "\nUbicación: " + escenario.getUbicacion() +
            "\nCapacidad: " + escenario.getCapacidadMaxima() +
            "\nEstado: " + escenario.getEstado()
        );
    }
    private static void ModificarEscenario() {
        int posicion = vista.PedirPosicion();
        System.out.print("Nueva capacidad: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nuevo estado: ");
        String estado = scanner.nextLine();
        festival.ModificarEscenario(
            posicion, capacidad, estado
        );
        vista.MostrarMensaje("Escenario modificado.");
    }
    private static void RetirarEscenario() {
        int posicion = vista.PedirPosicion();
        festival.RetirarEscenario(posicion);
        vista.MostrarMensaje("Escenario retirado.");
    }
    private static void RegistrarArtista() {
        Artista artista = vista.PedirDatosArtista();
        if (festival.RegistrarArtista(artista)) {
            vista.MostrarMensaje(
                "Artista registrado correctamente."
            );
        } else {
            vista.MostrarMensaje(
                "Ya existe un artista con ese código."
            );
        }
    }
    private static void ConsultarArtistas() {
        vista.MostrarArtistas(festival.getArtistas());
    }
    private static void BuscarArtista() {
        System.out.print("Código del artista: ");
        String codigo = scanner.nextLine();
        Artista encontrado = null;
        for (Artista artista : festival.getArtistas()) {
            if (artista.getCodigo().equalsIgnoreCase(codigo)) {
                encontrado = artista;
                break;
            }
        }
        vista.MostrarArtista(encontrado);
    }
    private static void ModificarArtista() {
        System.out.print("Código del artista: ");
        String codigo = scanner.nextLine();
        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Nuevo género: ");
        String genero = scanner.nextLine();
        System.out.print("Nueva duración: ");
        int duracion = scanner.nextInt();
        System.out.print("Nueva asistencia estimada: ");
        int asistentes = scanner.nextInt();
        scanner.nextLine();
        boolean modificado = festival.ModificarArtista(
            codigo, nombre, genero, duracion, asistentes
        );
        if (modificado) {
            vista.MostrarMensaje("Artista modificado.");
        } else {
            vista.MostrarMensaje("Artista no encontrado.");
        }
    }
    private static void CancelarParticipacion() {
        System.out.print("Código del artista: ");
        String codigo = scanner.nextLine();
        if (festival.CancelarParticipacion(codigo)) {
            vista.MostrarMensaje(
                "Participación cancelada."
            );
        } else {
            vista.MostrarMensaje(
                "Artista no encontrado."
            );
        }
    }
    private static void MostrarReporte() {
        vista.MostrarReporte(festival);
    }
}