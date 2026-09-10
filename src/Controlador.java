import java.util.Scanner;

public class Controlador {

    private Festival festival;
    private Vista vista = new Vista();
    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {

        vista.mostrarInicio();
        crearFestivalInicial();

        int opcion = 0;

        while (opcion != 13) {
            vista.mostrarMenu(festival.nombreFestival);
            opcion = leerEntero("Seleccione una opcion: ");

            if (opcion == 13) {
                break;
            }

            try {
                ejecutarOpcion(opcion);
            } catch (IllegalArgumentException excepcion) {
                vista.mostrarMensaje("Error: " + excepcion.getMessage());
            } finally {
                vista.mostrarFinOperacion();
            }
        }

        scanner.close();
        vista.mostrarDespedida();
    }

    public void InicioFestival(String nombreFestival, String nombreCoordinador, int codigoIdentificacion) {

        festival = new Festival(nombreFestival, nombreCoordinador, codigoIdentificacion);
    }

    public String ResumenFestival() {

        Escenario mayorCapacidad = festival.escenarioMayorCapacidad();
        Artista mayorDuracion = festival.artistaMayorDuracion();
        Artista mayorAsistencia = festival.artistaMayorAsistencia();

        String reporte = "Festival: " + festival.nombreFestival
            + "\nCoordinador: " + festival.getNombreCoordinador()
            + "\nCodigo de identificacion: " + festival.getCodigoIdentificacion()
            + "\nEscenarios configurados: " + festival.cantidadEscenariosConfigurados()
            + "\nEspacios disponibles: " + festival.cantidadEspaciosDisponibles();

        if (mayorCapacidad == null) {
            reporte += "\nEscenario con mayor capacidad: No hay escenarios configurados.";
        } else {
            reporte += "\nEscenario con mayor capacidad: " + mayorCapacidad.toString();
        }

        reporte += "\nArtistas registrados: " + festival.cantidadArtistasRegistrados();

        if (mayorDuracion == null) {
            reporte += "\nArtista con mayor duracion: No hay artistas registrados.";
            reporte += "\nArtista con mayor asistencia estimada: No hay artistas registrados.";
            reporte += "\nPromedio de duracion: No disponible.";
        } else {
            reporte += "\nArtista con mayor duracion: " + mayorDuracion.toString();
            reporte += "\nArtista con mayor asistencia estimada: " + mayorAsistencia.toString();
            reporte += "\nPromedio de duracion: " + festival.promedioDuracionPresentaciones() + " minutos";
        }

        return reporte;
    }

    public boolean VerificarInput(Scanner scanner) {

        return scanner.hasNextInt();
    }

    public boolean VerificarPosicionArrayList(int posicion) {

        return posicion >= 0 && posicion < festival.cantidadArtistasRegistrados();
    }

    private void crearFestivalInicial() {

        boolean creado = false;

        while (!creado) {
            try {
                nuevoFestival();
                creado = true;
            } catch (IllegalArgumentException excepcion) {
                vista.mostrarMensaje("Error: " + excepcion.getMessage());
            }
        }
    }

    private void ejecutarOpcion(int opcion) {

        switch (opcion) {
            case 1:
                nuevoFestival();
                break;
            case 2:
                configurarEscenario();
                break;
            case 3:
                consultarEscenarios();
                break;
            case 4:
                consultarUnEscenario();
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
                cancelarArtista();
                break;
            case 12:
                vista.mostrarReporte(ResumenFestival());
                break;
            default:
                vista.mostrarMensaje("La opcion debe estar entre 1 y 13.");
        }
    }

    private void nuevoFestival() {

        String nombreFestival = leerTexto("Nombre del festival: ");
        int codigoIdentificacion = leerEntero("Codigo de identificacion: ");
        String nombreCoordinador = leerTexto("Nombre del coordinador: ");

        InicioFestival(nombreFestival, nombreCoordinador, codigoIdentificacion);
        vista.mostrarMensaje("Festival creado correctamente.");
    }

    private void configurarEscenario() {

        int posicion = leerEntero("Posicion del escenario (1-5): ") - 1;

        if (!festival.VerificarPosicionEscenario(posicion)) {
            throw new IllegalArgumentException("La posicion debe estar entre 1 y 5.");
        }

        if (!festival.VerificarDisponibilidadEscenario(posicion)) {
            throw new IllegalArgumentException("La posicion seleccionada ya esta ocupada.");
        }

        int codigoEscenario = leerEntero("Codigo del escenario: ");
        String nombreEscenario = leerTexto("Nombre del escenario: ");
        String ubicacionEscenario = leerTexto("Ubicacion del escenario: ");
        int capacidadEscenario = leerEntero("Capacidad maxima: ");
        String estadoEscenario = leerTexto("Estado del escenario: ");

        Escenario escenario = new Escenario(codigoEscenario, nombreEscenario, ubicacionEscenario, capacidadEscenario, estadoEscenario);
        festival.ConfigurarEscenario(posicion, escenario);
        vista.mostrarMensaje("Escenario configurado correctamente.");
    }

    private void consultarEscenarios() {

        Escenario[] escenarios = festival.ConsultarTodosEscenarios();
        boolean existeEscenario = false;

        for (int posicion = 0; posicion < escenarios.length; posicion++) {
            if (escenarios[posicion] != null) {
                vista.mostrarEscenario(posicion, escenarios[posicion]);
                existeEscenario = true;
            }
        }

        if (!existeEscenario) {
            vista.mostrarMensaje("No hay escenarios configurados.");
        }
    }

    private void consultarUnEscenario() {

        int posicion = leerEntero("Posicion del escenario (1-5): ") - 1;
        Escenario escenario = festival.ConsultarEscenario(posicion);

        if (escenario == null) {
            vista.mostrarMensaje("La posicion se encuentra vacia.");
        } else {
            vista.mostrarEscenario(posicion, escenario);
        }
    }

    private void modificarEscenario() {

        int posicion = leerEntero("Posicion del escenario (1-5): ") - 1;
        Escenario escenario = festival.ConsultarEscenario(posicion);

        if (escenario == null) {
            throw new IllegalArgumentException("No existe un escenario en esa posicion.");
        }

        int capacidadEscenario = leerEntero("Nueva capacidad maxima: ");
        String estadoEscenario = leerTexto("Nuevo estado: ");

        festival.ModificarCapacidadEscenario(escenario, capacidadEscenario);
        festival.ModificarEstadoEscenario(escenario, estadoEscenario);
        vista.mostrarMensaje("Escenario modificado correctamente.");
    }

    private void retirarEscenario() {

        int posicion = leerEntero("Posicion del escenario (1-5): ") - 1;
        Escenario escenario = festival.ConsultarEscenario(posicion);
        festival.RetirarEscenario(escenario);
        vista.mostrarMensaje("Escenario retirado correctamente.");
    }

    private void registrarArtista() {

        int codigoArtista = leerEntero("Codigo del artista: ");
        String nombreArtista = leerTexto("Nombre artistico: ");
        String generoMusicalArtista = leerTexto("Genero musical: ");
        int duracionPresentacionArtista = leerEntero("Duracion de la presentacion en minutos: ");
        int estimacionAsistentesArtista = leerEntero("Cantidad estimada de asistentes: ");

        festival.RegistrarArtista(nombreArtista, codigoArtista, generoMusicalArtista, duracionPresentacionArtista, estimacionAsistentesArtista);
        vista.mostrarMensaje("Artista registrado correctamente.");
    }

    private void consultarArtistas() {

        vista.mostrarMensaje(festival.ConsultarTodosArtistas());
    }

    private void buscarArtista() {

        int codigoArtista = leerEntero("Codigo del artista: ");
        Artista artista = festival.BuscarArtista(codigoArtista);

        if (artista == null) {
            vista.mostrarMensaje("El artista no se encuentra registrado.");
        } else {
            vista.mostrarArtista(artista);
        }
    }

    private void modificarArtista() {

        int codigoActual = leerEntero("Codigo actual del artista: ");

        if (festival.BuscarArtista(codigoActual) == null) {
            throw new IllegalArgumentException("El artista no se encuentra registrado.");
        }

        int codigoArtista = leerEntero("Nuevo codigo del artista: ");
        String nombreArtista = leerTexto("Nuevo nombre artistico: ");
        String generoMusicalArtista = leerTexto("Nuevo genero musical: ");
        int duracionPresentacionArtista = leerEntero("Nueva duracion en minutos: ");
        int estimacionAsistentesArtista = leerEntero("Nueva estimacion de asistentes: ");

        Artista artista = new Artista(codigoArtista, nombreArtista, generoMusicalArtista, duracionPresentacionArtista, estimacionAsistentesArtista);
        festival.ModificarArtista(codigoActual, artista);
        vista.mostrarMensaje("Artista modificado correctamente.");
    }

    private void cancelarArtista() {

        int codigoArtista = leerEntero("Codigo del artista: ");
        Artista artista = festival.BuscarArtista(codigoArtista);
        festival.CancelarArtista(artista);
        vista.mostrarMensaje("Participacion cancelada correctamente.");
    }

    private int leerEntero(String mensaje) {

        while (true) {
            try {
                vista.solicitar(mensaje);
                int numero = scanner.nextInt();
                scanner.nextLine();
                return numero;
            } catch (java.util.InputMismatchException excepcion) {
                scanner.nextLine();
                vista.mostrarMensaje("Entrada incorrecta. Debe ingresar un numero entero.");
            }
        }
    }

    private String leerTexto(String mensaje) {

        vista.solicitar(mensaje);
        return scanner.nextLine();
    }
}
