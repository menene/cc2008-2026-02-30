import java.util.ArrayList;

public class Controlador {

    private Vista vista;
    private Festival festival;

    public Controlador(Vista vista) {
        this.vista = vista;
    }

    public void iniciar() {
        boolean continuar = true;

        vista.mostrarMensaje("Ingrese la información inicial del festival.");
        crearFestival();

        while (continuar == true) {
            vista.mostrarMenu();
            int opcion = vista.solicitarInt("Seleccione una opción: ");

            if (opcion == 1) {
                crearFestival();
            } 
            else if (opcion == 2) {
                configurarEscenario();
            } 
            else if (opcion == 3) {
                consultarEscenarios();
            } 
            else if (opcion == 4) {
                consultarEscenarioIndividual();
            } 
            else if (opcion == 5) {
                modificarEscenario();
            } 
            else if (opcion == 6) {
                retirarEscenario();
            } 
            else if (opcion == 7) {
                registrarArtista();
            } 
            else if (opcion == 8) {
                consultarArtistas();
            } 
            else if (opcion == 9) {
                buscarArtista();
            } 
            else if (opcion == 10) {
                modificarArtista();
            } 
            else if (opcion == 11) {
                cancelarParticipacion();
            } 
            else if (opcion == 12) {
                mostrarReporte();
            } 
            else if (opcion == 13) {
                continuar = false;
                vista.mostrarMensaje("Saliendo del programa...");
            } 
            else {
                vista.mostrarMensaje("Opción incorrecta.");
            }
        }
    }

    private void crearFestival() {
        String nombre = vista.solicitarString("Nombre del festival: ");
        int codigo = vista.solicitarInt("Código del festival: ");
        String nombreCoordinador = vista.solicitarString("Nombre del coordinador: ");

        festival = new Festival(nombre, codigo, nombreCoordinador);
        vista.mostrarMensaje("Festival creado correctamente.");
    }

    private void configurarEscenario() {
        int posicion = vista.solicitarInt("Posición del escenario (0-4): ");
        int codigo = vista.solicitarInt("Código del escenario: ");
        String nombre = vista.solicitarString("Nombre del escenario: ");
        String ubicacion = vista.solicitarString("Ubicación del escenario: ");
        int capacidadMax = vista.solicitarInt("Capacidad máxima: ");
        boolean estado = vista.solicitarBoolean("Estado del escenario");

        try {
            Escenario escenario = new Escenario(codigo, nombre, ubicacion, capacidadMax, estado);
            boolean registrado = festival.configurarEscenario(posicion, escenario);

            if (registrado == true) {
                vista.mostrarMensaje("Escenario configurado correctamente.");
            } 
            else {
                vista.mostrarMensaje("No fue posible configurar el escenario. La posición es incorrecta o está ocupada.");
            }
        } 
        catch (IllegalArgumentException e) {
            vista.mostrarMensaje("No fue posible configurar el escenario: " + e.getMessage());
        }
    }

    private void consultarEscenarios() {
        Escenario[] escenarios = festival.getEscenarios();
        boolean existenEscenarios = false;

        for (int i = 0; i < escenarios.length; i++) {
            if (escenarios[i] != null) {
                vista.mostrarMensaje("\nPosición: " + i);
                vista.mostrarMensaje(escenarios[i].toString());
                existenEscenarios = true;
            }
        }

        if (existenEscenarios == false) {
            vista.mostrarMensaje("No hay escenarios configurados.");
        }
    }

    private void consultarEscenarioIndividual() {
        int posicion = vista.solicitarInt("Posición del escenario (0-4): ");
        Escenario escenario = festival.obtenerEscenario(posicion);

        if (escenario == null) {
            vista.mostrarMensaje("La posición es incorrecta o no contiene un escenario.");
        } 
        else {
            vista.mostrarMensaje(escenario.toString());
        }
    }

    private void modificarEscenario() {
        int posicion = vista.solicitarInt("Posición del escenario (0-4): ");
        Escenario escenario = festival.obtenerEscenario(posicion);

        if (escenario == null) {
            vista.mostrarMensaje("La posición es incorrecta o no contiene un escenario.");
            return;
        }

        int capacidadMax = vista.solicitarInt("Nueva capacidad máxima: ");
        boolean estado = vista.solicitarBoolean("Nuevo estado del escenario");

        try {
            festival.modificarEscenario(posicion, capacidadMax, estado);
            vista.mostrarMensaje("Escenario modificado correctamente.");
        } 
        catch (IllegalArgumentException e) {
            vista.mostrarMensaje("No fue posible modificar el escenario: " + e.getMessage());
        }
    }

    private void retirarEscenario() {
        int posicion = vista.solicitarInt("Posición del escenario (0-4): ");

        if (festival.retirarEscenario(posicion) == true) {
            vista.mostrarMensaje("Escenario retirado correctamente.");
        } 
        else {
            vista.mostrarMensaje("La posición es incorrecta o no contiene un escenario.");
        }
    }

    private void registrarArtista() {
        int codigo = vista.solicitarInt("Código del artista: ");
        String nombreArtistico = vista.solicitarString("Nombre artístico: ");
        String generoMusical = vista.solicitarString("Género musical: ");
        float duracion = vista.solicitarFloat("Duración de la presentación: ");
        int cantidadAsist = vista.solicitarInt("Cantidad estimada de asistentes: ");

        try {
            Artista artista = new Artista(codigo, nombreArtistico, generoMusical, duracion, cantidadAsist);

            if (festival.registrarArtista(artista) == true) {
                vista.mostrarMensaje("Artista registrado correctamente.");
            } 
            else {
                vista.mostrarMensaje("No fue posible registrar al artista: el código ya existe.");
            }
        } 
        catch (IllegalArgumentException e) {
            vista.mostrarMensaje("No fue posible registrar al artista: " + e.getMessage());
        }
    }

    private void consultarArtistas() {
        ArrayList<Artista> artistas = festival.getArtistas();

        if (artistas.isEmpty()) {
            vista.mostrarMensaje("No hay artistas registrados.");
            return;
        }

        for (int i = 0; i < artistas.size(); i++) {
            vista.mostrarMensaje("\n" + artistas.get(i).toString());
        }
    }

    private void buscarArtista() {
        int codigo = vista.solicitarInt("Código del artista: ");
        Artista artista = festival.buscarArtista(codigo);

        if (artista == null) {
            vista.mostrarMensaje("No se encontró un artista con ese código.");
        } 
        else {
            vista.mostrarMensaje(artista.toString());
        }
    }

    private void modificarArtista() {
        int codigo = vista.solicitarInt("Código del artista que desea modificar: ");
        Artista artista = festival.buscarArtista(codigo);

        if (artista == null) {
            vista.mostrarMensaje("No se encontró un artista con ese código.");
            return;
        }

        String nombreArtistico = vista.solicitarString("Nuevo nombre artístico: ");
        String generoMusical = vista.solicitarString("Nuevo género musical: ");
        float duracion = vista.solicitarFloat("Nueva duración de la presentación: ");
        int cantidadAsist = vista.solicitarInt("Nueva cantidad estimada de asistentes: ");

        try {
            festival.modificarArtista(codigo, nombreArtistico, generoMusical, duracion, cantidadAsist);
            vista.mostrarMensaje("Artista modificado correctamente.");
        } 
        catch (IllegalArgumentException e) {
            vista.mostrarMensaje("No fue posible modificar al artista: " + e.getMessage());
        }
    }

    private void cancelarParticipacion() {
        int codigo = vista.solicitarInt("Código del artista: ");

        if (festival.cancelarParticipacion(codigo) == true) {
            vista.mostrarMensaje("Participación cancelada correctamente.");
        } 
        else {
            vista.mostrarMensaje("No se encontró un artista con ese código.");
        }
    }

    private void mostrarReporte() {
        vista.mostrarMensaje("\n===== REPORTE DEL FESTIVAL =====\n");

        vista.mostrarMensaje("--- INFORMACIÓN GENERAL ---");
        vista.mostrarMensaje("Festival: " + festival.getNombre());
        vista.mostrarMensaje("Código: " + festival.getCodigo());
        vista.mostrarMensaje("Coordinador: " + festival.getNombreCoordinador());

        vista.mostrarMensaje("\n--- ESCENARIOS ---");
        vista.mostrarMensaje("Escenarios configurados: " + festival.cantidadEscenariosConfigurados());
        vista.mostrarMensaje("Espacios disponibles: " + festival.cantidadEspaciosDisponibles());

        Escenario escenarioMayor = festival.escenarioMayorCapacidad();

        if (escenarioMayor == null) {
            vista.mostrarMensaje("No hay escenarios configurados.");
        } else {
            vista.mostrarMensaje("\nEscenario con mayor capacidad:");
            vista.mostrarMensaje(escenarioMayor.toString());
        }

        vista.mostrarMensaje("\n--- ARTISTAS ---");
        vista.mostrarMensaje("Artistas registrados: " + festival.cantidadArtistas());

        if (festival.cantidadArtistas() == 0) {
            vista.mostrarMensaje("No hay artistas registrados para realizar los cálculos.");
            return;
        }

        vista.mostrarMensaje("\nArtista con mayor duración:");
        vista.mostrarMensaje(festival.artistaMayorDuracion().toString());

        vista.mostrarMensaje("\nArtista con mayor asistencia estimada:");
        vista.mostrarMensaje(festival.artistaMayorAsistentes().toString());

        vista.mostrarMensaje("\nPromedio de duración: " + festival.promedioDuracion() + " minutos");
    }
}