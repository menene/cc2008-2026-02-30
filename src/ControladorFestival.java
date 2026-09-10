import java.util.ArrayList;
import java.util.InputMismatchException;

public class ControladorFestival {
    private Festival festival;
    private VistaFestival vista;

    public ControladorFestival(VistaFestival vista) {
        if (vista == null) {
            throw new IllegalArgumentException("La vista no puede ser null.");
        }
        this.vista = vista;
    }

    public void iniciar() {
        vista.mostrarMensaje("Bienvenido. Primero debe ingresar los datos del festival.");
        solicitarFestivalInicial();

        boolean continuar = true;
        while (continuar) {
            try {
                int opcion = vista.mostrarMenu();
                continuar = ejecutarOpcion(opcion);
            } catch (InputMismatchException e) {
                vista.mostrarMensaje("Error: debe ingresar un número entero.");
                vista.limpiarEntrada();
            } catch (IllegalArgumentException | IndexOutOfBoundsException
                     | IllegalStateException e) {
                vista.mostrarMensaje("Error: " + e.getMessage());
            } finally {
                vista.mostrarFinOperacion();
            }
        }
    }

    public void cerrarRecursos() {
        vista.cerrar();
    }

    private void solicitarFestivalInicial() {
        while (festival == null) {
            try {
                crearNuevoFestival();
            } catch (IllegalArgumentException e) {
                vista.mostrarMensaje("Error: " + e.getMessage());
                vista.mostrarMensaje("Intente ingresar nuevamente los datos.");
            } finally {
                vista.mostrarFinOperacion();
            }
        }
    }

    private boolean ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                crearNuevoFestival();
                break;
            case 2:
                configurarEscenario();
                break;
            case 3:
                consultarEscenarios();
                break;
            case 4:
                consultarEscenario();
                break;
            case 5:
                modificarEscenario();
                break;
            case 6:
                retirarEscenario();
                break;
            case 7:
                registrarArtista();
                break;
            case 8:
                consultarArtistas();
                break;
            case 9:
                buscarArtista();
                break;
            case 10:
                modificarArtista();
                break;
            case 11:
                cancelarParticipacion();
                break;
            case 12:
                mostrarReporte();
                break;
            case 13:
                vista.mostrarMensaje("Programa finalizado. ¡Hasta pronto!");
                return false;
            default:
                throw new IllegalArgumentException("La opción debe estar entre 1 y 13.");
        }
        return true;
    }

    private void crearNuevoFestival() {
        String nombre = vista.leerTexto("Nombre del festival: ");
        String codigo = vista.leerTexto("Código de identificación: ");
        String coordinador = vista.leerTexto("Nombre del coordinador: ");
        Festival nuevoFestival = new Festival(nombre, codigo, coordinador);
        festival = nuevoFestival;
        vista.mostrarMensaje("Festival creado correctamente. Los registros anteriores fueron reemplazados.");
    }

    private void configurarEscenario() {
        int posicion = vista.leerEntero("Posición del arreglo (0-4): ");
        String codigo = vista.leerTexto("Código del escenario: ");
        String nombre = vista.leerTexto("Nombre del escenario: ");
        String ubicacion = vista.leerTexto("Ubicación: ");
        int capacidad = vista.leerEntero("Capacidad máxima: ");
        String estado = vista.leerTexto("Estado: ");

        Escenario escenario = new Escenario(codigo, nombre, ubicacion, capacidad, estado);
        festival.configurarEscenario(posicion, escenario);
        vista.mostrarMensaje("Escenario configurado correctamente en la posición " + posicion + ".");
    }

    private void consultarEscenarios() {
        boolean encontro = false;
        for (int i = 0; i < festival.getTotalPosiciones(); i++) {
            Escenario escenario = festival.obtenerEscenario(i);
            if (escenario != null) {
                vista.mostrarEscenario(i, escenario);
                encontro = true;
            }
        }
        if (!encontro) {
            vista.mostrarMensaje("No hay escenarios configurados.");
        }
    }

    private void consultarEscenario() {
        int posicion = vista.leerEntero("Posición del escenario (0-4): ");
        Escenario escenario = festival.obtenerEscenario(posicion);
        if (escenario == null) {
            vista.mostrarMensaje("La posición " + posicion + " está disponible.");
        } else {
            vista.mostrarEscenario(posicion, escenario);
        }
    }

    private void modificarEscenario() {
        int posicion = vista.leerEntero("Posición del escenario (0-4): ");
        int capacidad = vista.leerEntero("Nueva capacidad máxima: ");
        String estado = vista.leerTexto("Nuevo estado: ");
        festival.modificarEscenario(posicion, capacidad, estado);
        vista.mostrarMensaje("Escenario modificado correctamente.");
    }

    private void retirarEscenario() {
        int posicion = vista.leerEntero("Posición del escenario a retirar (0-4): ");
        festival.retirarEscenario(posicion);
        vista.mostrarMensaje("Escenario retirado. La posición " + posicion + " está disponible.");
    }

    private void registrarArtista() {
        String codigo = vista.leerTexto("Código del artista: ");
        String nombre = vista.leerTexto("Nombre artístico: ");
        String genero = vista.leerTexto("Género musical: ");
        int duracion = vista.leerEntero("Duración de la presentación en minutos: ");
        int asistentes = vista.leerEntero("Cantidad estimada de asistentes: ");

        Artista artista = new Artista(codigo, nombre, genero, duracion, asistentes);
        festival.registrarArtista(artista);
        vista.mostrarMensaje("Artista registrado correctamente.");
    }

    private void consultarArtistas() {
        ArrayList<Artista> artistas = festival.obtenerArtistas();
        if (artistas.isEmpty()) {
            vista.mostrarMensaje("No hay artistas registrados.");
            return;
        }
        for (Artista artista : artistas) {
            vista.mostrarArtista(artista);
        }
    }

    private void buscarArtista() {
        String codigo = vista.leerTexto("Código del artista: ");
        Artista artista = festival.buscarArtista(codigo);
        if (artista == null) {
            vista.mostrarMensaje("No se encontró un artista con ese código.");
        } else {
            vista.mostrarArtista(artista);
        }
    }

    private void modificarArtista() {
        String codigo = vista.leerTexto("Código del artista a modificar: ");
        String nombre = vista.leerTexto("Nuevo nombre artístico: ");
        String genero = vista.leerTexto("Nuevo género musical: ");
        int duracion = vista.leerEntero("Nueva duración en minutos: ");
        int asistentes = vista.leerEntero("Nueva cantidad estimada de asistentes: ");

        boolean modificado = festival.modificarArtista(codigo, nombre, genero, duracion, asistentes);
        vista.mostrarMensaje(modificado
                ? "Artista modificado correctamente."
                : "No se encontró un artista con ese código.");
    }

    private void cancelarParticipacion() {
        String codigo = vista.leerTexto("Código del artista que cancelará: ");
        boolean eliminado = festival.cancelarParticipacion(codigo);
        vista.mostrarMensaje(eliminado
                ? "Participación cancelada correctamente."
                : "No se encontró un artista con ese código.");
    }

    private void mostrarReporte() {
        vista.mostrarMensaje("Festival: " + festival.getNombre()
                + " (" + festival.getCodigo() + ") - Coordinador: "
                + festival.getNombreCoordinador());
        vista.mostrarReporte(
                festival.contarEscenariosConfigurados(),
                festival.contarEspaciosDisponibles(),
                festival.obtenerEscenarioMayorCapacidad(),
                festival.contarArtistas(),
                festival.obtenerArtistaMayorDuracion(),
                festival.obtenerArtistaMayorAsistencia(),
                festival.calcularPromedioDuracion());
    }
}
