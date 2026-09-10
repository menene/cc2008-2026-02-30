import java.util.InputMismatchException;

public class ControladorFestival {

    private Festival festival;
    private VistaConsola vista;
    private boolean ejecutando;

    //constructor
    public ControladorFestival() {
        vista = new VistaConsola();
        ejecutando = true;
    }

    //inicia el programa y mantiene activo el menu
    public void iniciar() {
        crearFestival();

        while (ejecutando) {
            try {
                vista.mostrarMenu(festival);

                int opcion = vista.leerEntero("Seleccione una opcion: ");
                vista.limpiarEntrada();

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
                    case 13:
                        ejecutando = false;
                        vista.mostrarMensaje("Programa finalizado.");
                        break;
                    default:
                        vista.mostrarMensaje("Opcion no valida.");
                        break;
                }

            } catch (InputMismatchException e) {
                vista.mostrarMensaje("Error: debe ingresar un valor numerico.");
                vista.limpiarEntrada();

            } catch (IllegalArgumentException e) {
                vista.mostrarMensaje("Error: " + e.getMessage());
            }
        }
    }

    //crea o reemplaza el festival actual
    private void crearFestival() {
        String nombre = vista.leerTexto("Nombre del festival: ");
        String codigo = vista.leerTexto("Codigo del festival: ");
        String coordinador = vista.leerTexto("Nombre del coordinador: ");

        festival = new Festival(nombre, codigo, coordinador);

        vista.mostrarMensaje("Festival creado correctamente.");
    }

    //configura un escenario en una posicion del arreglo
    private void configurarEscenario() {
        try {
            //aca usamos -1 en la posicion para que el user no tenga que ingresar
            //0 como 1ra opcion, si no que lo hace normal como un simple mortal dijo erick
            int posicion = vista.leerEntero("Posicion del escenario (1-5): ");
            vista.limpiarEntrada();
            posicion = posicion - 1;


            String codigo = vista.leerTexto("Codigo del escenario: ");
            String nombre = vista.leerTexto("Nombre del escenario: ");
            String ubicacion = vista.leerTexto("Ubicacion: ");

            int capacidad = vista.leerEntero("Capacidad maxima: ");
            vista.limpiarEntrada();

            String estado = vista.leerTexto("Estado: ");

            Escenario escenario = new Escenario(
                    codigo, nombre, ubicacion, capacidad, estado
            );

            boolean configurado = festival.configurarEscenario(posicion, escenario);

            if (configurado) {
                vista.mostrarMensaje("Escenario configurado correctamente.");
            } else {
                vista.mostrarMensaje(
                        "No se pudo configurar el escenario. Revise la posicion."
                );
            }

        } finally {
            vista.mostrarMensaje("Proceso de configuracion de escenario finalizado.");
        }
    }

    //muestra todos los escenarios configurados
    private void consultarEscenarios() {
        boolean encontrado = false;

        for (int i = 0; i < 5; i++) {
            Escenario escenario = festival.obtenerEscenario(i);

            if (escenario != null) {
                //aca le agrego 1 para que la primera posicion no sea 0, si no 1
                //y asi con las demas posisciones
                vista.mostrarEscenario(i +1, escenario);
                encontrado = true;
            }
        }

        if (encontrado == false) {
            vista.mostrarMensaje("No hay escenarios configurados.");
        }
    }

    //consulta un escenario segun su posicion
    private void consultarEscenario() {
        int posicion = vista.leerEntero("Posicion del escenario (1-5): ");
        vista.limpiarEntrada();
        posicion = posicion - 1;

        Escenario escenario = festival.obtenerEscenario(posicion);

        if (escenario == null) {
            vista.mostrarMensaje("La posicion no contiene un escenario valido.");
        } else {
            //aca tambien le sumamaos 1 para la posicion
            vista.mostrarEscenario(posicion +1, escenario);
        }
    }

    //modifica capacidad y estado de un escenario
    private void modificarEscenario() {
        int posicion = vista.leerEntero("Posicion del escenario (1-5): ");
        vista.limpiarEntrada();
        posicion = posicion - 1;

        int capacidad = vista.leerEntero("Nueva capacidad maxima: ");
        vista.limpiarEntrada();

        String estado = vista.leerTexto("Nuevo estado: ");

        boolean modificado = festival.modificarEscenario(
                posicion, capacidad, estado
        );

        if (modificado) {
            vista.mostrarMensaje("Escenario modificado correctamente.");
        } else {
            vista.mostrarMensaje("No se pudo modificar el escenario.");
        }
    }

    //retira un escenario del arreglo
    private void retirarEscenario() {
        int posicion = vista.leerEntero("Posicion del escenario (1-5): ");
        vista.limpiarEntrada();
        posicion = posicion - 1;

        boolean retirado = festival.retirarEscenario(posicion);

        if (retirado) {
            vista.mostrarMensaje("Escenario retirado correctamente.");
        } else {
            vista.mostrarMensaje("No se pudo retirar el escenario.");
        }
    }

    //registra un artista en el ArrayList
    private void registrarArtista() {
        String codigo = vista.leerTexto("Codigo del artista: ");
        String nombreArtistico = vista.leerTexto("Nombre artistico: ");
        String generoMusical = vista.leerTexto("Genero musical: ");

        int duracion = vista.leerEntero("Duracion de la presentacion: ");
        vista.limpiarEntrada();

        int asistentes = vista.leerEntero("Cantidad estimada de asistentes: ");
        vista.limpiarEntrada();

        Artista artista = new Artista(
                codigo,
                nombreArtistico,
                generoMusical,
                duracion,
                asistentes
        );

        boolean registrado = festival.registrarArtista(artista);

        if (registrado) {
            vista.mostrarMensaje("Artista registrado correctamente.");
        } else {
            vista.mostrarMensaje("Ya existe un artista con ese codigo.");
        }
    }

    //muestra todos los artistas registrados
    private void consultarArtistas() {
        if (festival.cantidadArtistas() == 0) {
            vista.mostrarMensaje("No hay artistas registrados.");
            return;
        }

        for (Artista artista : festival.getArtistas()) {
            vista.mostrarArtista(artista);
        }
    }

    //busca un artista mediante su codigo
    private void buscarArtista() {
        String codigo = vista.leerTexto("Codigo del artista: ");

        Artista artista = festival.buscarArtista(codigo);

        if (artista == null) {
            vista.mostrarMensaje("El artista no se encuentra registrado.");
        } else {
            vista.mostrarArtista(artista);
        }
    }

    //modifica la informacion de un artista
    private void modificarArtista() {
        String codigo = vista.leerTexto("Codigo del artista a modificar: ");
        String nombreArtistico = vista.leerTexto("Nuevo nombre artistico: ");
        String generoMusical = vista.leerTexto("Nuevo genero musical: ");

        int duracion = vista.leerEntero("Nueva duracion de presentacion: ");
        vista.limpiarEntrada();

        int asistentes = vista.leerEntero("Nueva cantidad estimada de asistentes: ");
        vista.limpiarEntrada();

        boolean modificado = festival.modificarArtista(
                codigo,
                nombreArtistico,
                generoMusical,
                duracion,
                asistentes
        );

        if (modificado) {
            vista.mostrarMensaje("Artista modificado correctamente.");
        } else {
            vista.mostrarMensaje("El artista no se encuentra registrado.");
        }
    }

    //cancela la participacion de un artista
    private void cancelarParticipacion() {
        String codigo = vista.leerTexto("Codigo del artista: ");

        boolean cancelado = festival.cancelarParticipacion(codigo);

        if (cancelado) {
            vista.mostrarMensaje("Participacion cancelada correctamente.");
        } else {
            vista.mostrarMensaje("El artista no se encuentra registrado.");
        }
    }

    //muestra el reporte general
    private void mostrarReporte() {
        vista.mostrarReporte(
                festival.cantidadEscenariosConfigurados(),
                festival.cantidadEspaciosDisponibles(),
                festival.escenarioMayorCapacidad(),
                festival.cantidadArtistas(),
                festival.artistaMayorDuracion(),
                festival.artistaMayorAsistencia(),
                festival.promedioDuracion()
        );
    }
}