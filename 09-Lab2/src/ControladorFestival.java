public class ControladorFestival {

    private Festival festivalActual;
    private VistaFestival vista;

    public ControladorFestival(VistaFestival vista) {
        if (vista == null) {
            throw new IllegalArgumentException(
                    "La vista no puede ser null."
            );
        }

        this.vista = vista;
        this.festivalActual = null;
    }

    // Inicia el programa y gestiona el flujo de ejecución
    public void iniciar() {

        vista.mostrarMensaje(
                "Bienvenido al sistema del festival universitario."
        );

        // Se asegura de que se cree un festival antes de continuar con otras opciones
        while (festivalActual == null) {
            try {
                crearNuevoFestival();
            } catch (IllegalArgumentException e) {
                vista.mostrarError(e.getMessage());
            }
        }

        // Bucle principal del programa que muestra el menú y procesa las opciones seleccionadas por el usuario
        int opcion;

        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();

            try {
                if (opcion != 13) {
                    procesarOpcion(opcion);
                }
            } catch (IllegalArgumentException e) {
                vista.mostrarError(e.getMessage());
            }

        } while (opcion != 13);

        vista.mostrarMensaje("Programa finalizado.");
    }

    //Switch para procesar la opción seleccionada por el usuario y llamar al método correspondiente
    private void procesarOpcion(int opcion) {

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
                mostrarReporteFestival();
                break;

            default:
                throw new IllegalArgumentException(
                        "La opcion seleccionada no es valida."
                );
        }
    }

    private void crearNuevoFestival() {

        vista.mostrarMensaje("\n===== NUEVO FESTIVAL =====");

        String nombre = vista.leerTexto(
                "Ingrese el nombre del festival: "
        );

        String codigo = vista.leerTexto(
                "Ingrese el codigo del festival: "
        );

        String coordinador = vista.leerTexto(
                "Ingrese el nombre del coordinador: "
        );

        // Crea un nuevo objeto Festival con los datos ingresados por el usuario y lo asigna a la variable festivalActual
        Festival nuevoFestival = new Festival(
                nombre,
                codigo,
                coordinador
        );

        festivalActual = nuevoFestival;

        vista.mostrarMensaje(
                "Festival creado correctamente."
        );

        vista.mostrarFestival(festivalActual);
    }

    //Configura un escenario en una posición específica del arreglo de escenarios del festival actual
    private void configurarEscenario() {

        vista.mostrarMensaje("\n===== CONFIGURAR ESCENARIO =====");

        int posicion = vista.leerEntero(
                "Ingrese la posicion del arreglo (0-4): "
        );

        String codigo = vista.leerTexto(
                "Ingrese el codigo del escenario: "
        );

        String nombre = vista.leerTexto(
                "Ingrese el nombre del escenario: "
        );

        String ubicacion = vista.leerTexto(
                "Ingrese la ubicacion: "
        );

        int capacidad = vista.leerEntero(
                "Ingrese la capacidad maxima: "
        );

        String estado = vista.leerTexto(
                "Ingrese el estado del escenario: "
        );

        Escenario escenario = new Escenario(codigo, nombre, ubicacion, capacidad, estado);

        festivalActual.configurarEscenario(posicion, escenario);

        vista.mostrarMensaje(
                "Escenario configurado correctamente."
        );
    }

    //Muestra la información de todos los escenarios configurados en el festival actual
    private void consultarEscenarios() {

        vista.mostrarMensaje("\n===== ESCENARIOS =====");

        boolean existenEscenarios = false;

        for (int i = 0;
                i < festivalActual
                        .getCantidadPosicionesEscenarios();
                i++) {

            Escenario escenario =
                    festivalActual.obtenerEscenario(i);

            if (escenario != null) {
                vista.mostrarEscenario(i, escenario);
                existenEscenarios = true;
            }
        }

        if (!existenEscenarios) {
            vista.mostrarMensaje(
                    "No existen escenarios configurados."
            );
        }
    }

    private void consultarEscenario() {

        int posicion = vista.leerEntero(
                "Ingrese la posicion del escenario (0-4): "
        );

        Escenario escenario =
                festivalActual.obtenerEscenario(posicion);

        if (escenario == null) {
            vista.mostrarMensaje(
                    "La posicion indicada se encuentra vacia."
            );
        } else {
            vista.mostrarEscenario(posicion, escenario);
        }
    }

    // Modifica un escenario en una posición específica del arreglo de escenarios del festival actual
    private void modificarEscenario() {

        vista.mostrarMensaje("\n===== MODIFICAR ESCENARIO =====");

        int posicion = vista.leerEntero(
                "Ingrese la posicion del escenario (0-4): "
        );

        int nuevaCapacidad = vista.leerEntero(
                "Ingrese la nueva capacidad maxima: "
        );

        String nuevoEstado = vista.leerTexto(
                "Ingrese el nuevo estado: "
        );

        festivalActual.modificarEscenario(
                posicion,
                nuevaCapacidad,
                nuevoEstado
        );

        vista.mostrarMensaje(
                "Escenario modificado correctamente."
        );
    }

    private void retirarEscenario() {

        int posicion = vista.leerEntero(
                "Ingrese la posicion del escenario (0-4): "
        );

        festivalActual.retirarEscenario(posicion);

        vista.mostrarMensaje(
                "Escenario retirado correctamente."
        );
    }

    //Registra un artista en el festival actual con los datos ingresados por el usuario
    private void registrarArtista() {

        vista.mostrarMensaje("\n===== REGISTRAR ARTISTA =====");

        String codigo = vista.leerTexto(
                "Ingrese el codigo del artista: "
        );

        String nombre = vista.leerTexto(
                "Ingrese el nombre artistico: "
        );

        String genero = vista.leerTexto(
                "Ingrese el genero musical: "
        );

        int duracion = vista.leerEntero(
                "Ingrese la duracion de la presentacion: "
        );

        int asistentes = vista.leerEntero(
                "Ingrese la cantidad estimada de asistentes: "
        );

        Artista artista = new Artista(codigo, nombre, genero, duracion, asistentes);

        festivalActual.registrarArtista(artista);

        vista.mostrarMensaje(
                "Artista registrado correctamente."
        );
    }

    //Consulta y muestra la información de todos los artistas registrados en el festival actual
    private void consultarArtistas() {

        vista.mostrarMensaje("\n===== ARTISTAS =====");

        int cantidad =
                festivalActual.obtenerCantidadArtistas();

        if (cantidad == 0) {
            vista.mostrarMensaje(
                    "No existen artistas registrados."
            );
            return;
        }

        for (int i = 0; i < cantidad; i++) {
            Artista artista =
                    festivalActual.obtenerArtista(i);

            vista.mostrarArtista(artista);
        }
    }

    //Busca un artista por su código en el festival actual y muestra su información si se encuentra
    private void buscarArtista() {

        String codigo = vista.leerTexto(
                "Ingrese el codigo del artista: "
        );

        Artista artista =
                festivalActual.buscarArtista(codigo);

        if (artista == null) {
            vista.mostrarMensaje(
                    "No se encontro un artista con ese codigo."
            );
        } else {
            vista.mostrarArtista(artista);
        }
    }

    //Modifica los datos de un artista registrado en el festival actual, solicitando al usuario el código actual del artista y los nuevos datos a modificar
    private void modificarArtista() {

        vista.mostrarMensaje("\n===== MODIFICAR ARTISTA =====");

        String codigoActual = vista.leerTexto(
                "Ingrese el codigo actual del artista: "
        );

        String nuevoCodigo = vista.leerTexto(
                "Ingrese el nuevo codigo: "
        );

        String nuevoNombre = vista.leerTexto(
                "Ingrese el nuevo nombre artistico: "
        );

        String nuevoGenero = vista.leerTexto(
                "Ingrese el nuevo genero musical: "
        );

        int nuevaDuracion = vista.leerEntero(
                "Ingrese la nueva duracion: "
        );

        int nuevosAsistentes = vista.leerEntero(
                "Ingrese la nueva cantidad estimada de asistentes: "
        );

        festivalActual.modificarArtista(codigoActual, nuevoCodigo, nuevoNombre, nuevoGenero, nuevaDuracion, nuevosAsistentes);

        vista.mostrarMensaje("Artista modificado correctamente.");
    }

    //Cancela la participación de un artista registrado en el festival actual, solicitando al usuario el código del artista a cancelar
    private void cancelarParticipacion() {

        String codigo = vista.leerTexto(
                "Ingrese el codigo del artista: "
        );

        festivalActual.cancelarParticipacion(codigo);

        vista.mostrarMensaje(
                "Participacion cancelada correctamente."
        );
    }

    private void mostrarReporteFestival() {

        vista.mostrarReporte(
                festivalActual.contarEscenariosConfigurados(),
                festivalActual.contarEspaciosDisponibles(),
                festivalActual
                        .obtenerEscenarioMayorCapacidad(),
                festivalActual.obtenerCantidadArtistas(),
                festivalActual.obtenerArtistaMayorDuracion(),
                festivalActual.obtenerArtistaMayorAsistencia(),
                festivalActual.calcularPromedioDuracion()
        );
    }
}