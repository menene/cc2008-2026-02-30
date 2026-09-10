package controller;

import model.Artista;
import model.Escenario;
import model.Festival;
import view.FestivalView;

public class FestivalController {
    private Festival festival;
    private final FestivalView vista;

    public FestivalController(Festival festival, FestivalView vista) {
        this.festival = festival;
        this.vista = vista;
    }

    public void iniciarPrograma() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerEntero("Seleccione una opción: ");
            procesarOpcion(opcion);
        } while (opcion != 13);
        vista.cerrar();
    }

    private void procesarOpcion(int opcion) {
        try {
            switch (opcion) {
                case 1: nuevoFestival(); break;
                case 2: configurarEscenario(); break;
                case 3: consultarEscenarios(); break;
                case 4: consultarEscenario(); break;
                case 5: modificarEscenario(); break;
                case 6: retirarEscenario(); break;
                case 7: registrarArtista(); break;
                case 8: consultarArtistas(); break;
                case 9: buscarArtista(); break;
                case 10: modificarArtista(); break;
                case 11: cancelarArtista(); break;
                case 12: generarReporte(); break;
                case 13: vista.mostrarMensaje("Programa finalizado."); break;
                default: vista.mostrarError("Seleccione una opción entre 1 y 13.");
            }
        } catch (IllegalArgumentException | IllegalStateException e) {
            vista.mostrarError(e.getMessage());
        }
    }

    private Festival solicitarFestival() {
        String nombre = vista.leerTexto("Nombre del festival: ");
        String codigo = vista.leerTexto("Código de identificación: ");
        String coordinador = vista.leerTexto("Nombre del coordinador: ");
        return new Festival(nombre, codigo, coordinador);
    }

    public void nuevoFestival() {
        festival = solicitarFestival();
        vista.mostrarMensaje("El nuevo festival fue creado. Sus colecciones están vacías.");
    }

    public void configurarEscenario() {
        try {
            int posicion = vista.leerEntero("Posición del escenario (1-5): ") - 1;
            int codigo = vista.leerEntero("Código del escenario: ");
            String nombre = vista.leerTexto("Nombre: ");
            String ubicacion = vista.leerTexto("Ubicación: ");
            int capacidad = vista.leerEntero("Capacidad máxima: ");
            String estado = vista.leerTexto("Estado: ");
            festival.configurarEscenario(posicion,
            new Escenario(codigo, nombre, ubicacion, capacidad, estado));
            vista.mostrarMensaje("Escenario configurado correctamente.");
        } finally {
            vista.mostrarMensaje("Proceso de configuración finalizado.");
        }
    }

    public void consultarEscenarios() {
        vista.mostrarEscenarios(festival.consultarEscenarios());
    }

    public void consultarEscenario() {
        int posicion = vista.leerEntero("Posición a consultar (1-5): ") - 1;
        vista.mostrarEscenario(festival.consultarEscenario(posicion));
    }

    public void modificarEscenario() {
        int posicion = vista.leerEntero("Posición a modificar (1-5): ") - 1;
        int capacidad = vista.leerEntero("Nueva capacidad máxima: ");
        String estado = vista.leerTexto("Nuevo estado: ");
        festival.modificarEscenario(posicion, capacidad, estado);
        vista.mostrarMensaje("Escenario modificado correctamente.");
    }

    public void retirarEscenario() {
        int posicion = vista.leerEntero("Posición a retirar (1-5): ") - 1;
        festival.retirarEscenario(posicion);
        vista.mostrarMensaje("Escenario retirado correctamente.");
    }

    public void registrarArtista() {
        int codigo = vista.leerEntero("Código del artista: ");
        String nombre = vista.leerTexto("Nombre artístico: ");
        String genero = vista.leerTexto("Género musical: ");
        int duracion = vista.leerEntero("Duración en minutos: ");
        int asistentes = vista.leerEntero("Cantidad estimada de asistentes: ");
        festival.registrarArtista(new Artista(codigo, nombre, genero, duracion, asistentes));
        vista.mostrarMensaje("Artista registrado correctamente.");
    }

    public void consultarArtistas() {
        vista.mostrarArtistas(festival.consultarArtistas());
    }

    public void buscarArtista() {
        int codigo = vista.leerEntero("Código del artista: ");
        Artista artista = festival.buscarArtista(codigo);
        if (artista == null) vista.mostrarError("No se encontró el artista.");
        else vista.mostrarArtista(artista);
    }

    public void modificarArtista() {
        int codigo = vista.leerEntero("Código del artista a modificar: ");
        String nombre = vista.leerTexto("Nuevo nombre artístico: ");
        String genero = vista.leerTexto("Nuevo género musical: ");
        int duracion = vista.leerEntero("Nueva duración en minutos: ");
        int asistentes = vista.leerEntero("Nueva cantidad estimada de asistentes: ");
        festival.modificarArtista(codigo, nombre, genero, duracion, asistentes);
        vista.mostrarMensaje("Artista modificado correctamente.");
    }

    public void cancelarArtista() {
        int codigo = vista.leerEntero("Código del artista a cancelar: ");
        festival.cancelarArtista(codigo);
        vista.mostrarMensaje("Participación cancelada correctamente.");
    }

    public void generarReporte() {
        Escenario escenarioMayor = festival.escenarioMayorCapacidad();
        Artista artistaDuracion = festival.artistaMayorDuracion();
        Artista artistaAsistencia = festival.artistaMayorAsistencia();
        String reporte = "\n=== REPORTE DEL FESTIVAL ===\n"
                + "Festival: " + festival.getNombre() + " (" + festival.getCodigo() + ")\n"
                + "Coordinador: " + festival.getCoordinador() + "\n"
                + "Escenarios configurados: " + festival.cantidadEscenariosConfigurados() + "\n"
                + "Espacios disponibles: " + festival.cantidadEspaciosDisponibles() + "\n"
                + "Escenario con mayor capacidad: " + valorOAusente(escenarioMayor) + "\n"
                + "Artistas registrados: " + festival.cantidadArtistasRegistrados() + "\n"
                + "Artista con presentación más larga: " + valorOAusente(artistaDuracion) + "\n"
                + "Artista con mayor asistencia estimada: " + valorOAusente(artistaAsistencia) + "\n"
                + String.format("Promedio de duración: %.2f minutos%n",
                        festival.promedioDuracionPresentaciones());
        vista.mostrarReporte(reporte);
    }

    private String valorOAusente(Object objeto) {
        return objeto == null ? "No disponible" : objeto.toString();
    }
}
