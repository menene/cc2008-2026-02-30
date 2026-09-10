public class ControladorFestival {

    private Festival festival;
    private final VistaFestival vista;

    public ControladorFestival(VistaFestival vista) {
        if (vista == null) {
            throw new IllegalArgumentException(
                    "La vista no puede ser null."
            );
        }

        this.vista = vista;
    }

    public void iniciar() {
        int opcion;

        vista.mostrarMensaje(
                "SISTEMA DE GESTION DE FESTIVALES"
        );

        do {
            vista.mostrarMenu();
            opcion = vista.leerEntero(
                    "Seleccione una opcion: "
            );

            try {
                ejecutarOpcion(opcion);
            } catch (IllegalArgumentException
                     | IllegalStateException excepcion) {

                vista.mostrarError(excepcion.getMessage());
            }

        } while (opcion != 0);

        vista.mostrarMensaje("Programa finalizado.");
        vista.cerrar();
    }

    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                crearFestival();
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

            case 0:
                break;

            default:
                vista.mostrarError(
                        "Seleccione una opcion entre 0 y 12."
                );
        }
    }

    private Festival requerirFestival() {
        if (festival == null) {
            throw new IllegalStateException(
                    "Primero debe crear el festival "
                            + "mediante la opcion 1."
            );
        }

        return festival;
    }

    private void crearFestival() {
        String nombre = vista.leerTexto(
                "Nombre del festival: "
        );

        String codigo = vista.leerTexto(
                "Codigo del festival: "
        );

        String coordinador = vista.leerTexto(
                "Nombre del coordinador: "
        );

        festival = new Festival(
                nombre,
                codigo,
                coordinador
        );

        vista.mostrarMensaje(
                "Festival creado o reemplazado correctamente."
        );
    }

    private void configurarEscenario() {
        Festival festivalActual = requerirFestival();

        int posicion = vista.leerEntero(
                "Posicion disponible (1-5): "
        );

        String codigo = vista.leerTexto(
                "Codigo del escenario: "
        );

        String nombre = vista.leerTexto(
                "Nombre del escenario: "
        );

        String ubicacion = vista.leerTexto(
                "Ubicacion del escenario: "
        );

        int capacidad = vista.leerEntero(
                "Capacidad maxima: "
        );

        String estado = vista.leerTexto(
                "Estado del escenario: "
        );

        Escenario escenario = new Escenario(
                codigo,
                nombre,
                ubicacion,
                capacidad,
                estado
        );

        festivalActual.configurarEscenario(
                posicion,
                escenario
        );

        vista.mostrarMensaje(
                "Escenario configurado correctamente."
        );
    }

    private void consultarEscenarios() {
        Festival festivalActual = requerirFestival();

        vista.mostrarEscenarios(
                festivalActual.consultarEscenarios()
        );
    }

    private void consultarEscenario() {
        Festival festivalActual = requerirFestival();

        int posicion = vista.leerEntero(
                "Posicion del escenario (1-5): "
        );

        Escenario escenario =
                festivalActual.consultarEscenario(posicion);

        vista.mostrarEscenario(posicion, escenario);
    }

    private void modificarEscenario() {
        Festival festivalActual = requerirFestival();

        int posicion = vista.leerEntero(
                "Posicion del escenario (1-5): "
        );

        int capacidad = vista.leerEntero(
                "Nueva capacidad maxima: "
        );

        String estado = vista.leerTexto(
                "Nuevo estado: "
        );

        festivalActual.modificarEscenario(
                posicion,
                capacidad,
                estado
        );

        vista.mostrarMensaje(
                "Escenario modificado correctamente."
        );
    }

    private void retirarEscenario() {
        Festival festivalActual = requerirFestival();

        int posicion = vista.leerEntero(
                "Posicion que desea retirar (1-5): "
        );

        festivalActual.retirarEscenario(posicion);

        vista.mostrarMensaje(
                "Escenario retirado correctamente."
        );
    }

    private void registrarArtista() {
        Festival festivalActual = requerirFestival();

        String codigo = vista.leerTexto(
                "Codigo del artista: "
        );

        String nombre = vista.leerTexto(
                "Nombre artistico: "
        );

        String genero = vista.leerTexto(
                "Genero musical: "
        );

        double duracion = vista.leerDouble(
                "Duracion de la presentacion en minutos: "
        );

        int asistentes = vista.leerEntero(
                "Asistentes estimados: "
        );

        Artista artista = new Artista(
                codigo,
                nombre,
                genero,
                duracion,
                asistentes
        );

        festivalActual.registrarArtista(artista);

        vista.mostrarMensaje(
                "Artista registrado correctamente."
        );
    }

    private void consultarArtistas() {
        Festival festivalActual = requerirFestival();

        vista.mostrarArtistas(
                festivalActual.consultarArtistas()
        );
    }

    private void buscarArtista() {
        Festival festivalActual = requerirFestival();

        String codigo = vista.leerTexto(
                "Codigo del artista: "
        );

        Artista artista =
                festivalActual.buscarArtista(codigo);

        vista.mostrarArtista(artista);
    }

    private void modificarArtista() {
        Festival festivalActual = requerirFestival();

        String codigo = vista.leerTexto(
                "Codigo del artista que desea modificar: "
        );

        String nombre = vista.leerTexto(
                "Nuevo nombre artistico: "
        );

        String genero = vista.leerTexto(
                "Nuevo genero musical: "
        );

        double duracion = vista.leerDouble(
                "Nueva duracion en minutos: "
        );

        int asistentes = vista.leerEntero(
                "Nuevos asistentes estimados: "
        );

        festivalActual.modificarArtista(
                codigo,
                nombre,
                genero,
                duracion,
                asistentes
        );

        vista.mostrarMensaje(
                "Artista modificado correctamente."
        );
    }

    private void cancelarParticipacion() {
        Festival festivalActual = requerirFestival();

        String codigo = vista.leerTexto(
                "Codigo del artista: "
        );

        festivalActual.cancelarParticipacion(codigo);

        vista.mostrarMensaje(
                "Participacion cancelada correctamente."
        );
    }

    private void mostrarReporte() {
        Festival festivalActual = requerirFestival();
        vista.mostrarReporte(festivalActual);
    }
}