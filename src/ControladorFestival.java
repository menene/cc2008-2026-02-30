import java.util.ArrayList;
import java.util.InputMismatchException;

public class ControladorFestival {
    private Festival festival;
    private Escenario[] escenarios;
    private ArrayList<Artista> artistas;
    private VistaFestival vista;

    // Constructor de la clase que inicializa atributos
    public ControladorFestival() {
        festival = null;
        escenarios = new Escenario[5];
        artistas = new ArrayList<Artista>();
        vista = new VistaFestival();
    }

    // Mètodo que inicia la ejecución del programa
    public void iniciar() {
        nuevoFestival();
        int opcion;

        do {
            opcion = mostrarMenu();

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
                case 0:
                    vista.mostrarMensaje("\nAdióoooooos ;)");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida. Ingrese la opción otra vez :(");
                    break;
            }

        } while (opcion != 0);
        
    }

    private void nuevoFestival() {
        try {
            String nombre = vista.pedirString("Ingrese el nombre del festival: ");
            String codigo = vista.pedirString("Ingrese el código del festival: ");
            String coordinador = vista.pedirString("Ingrese el nombre del coordinador: ");

            // Para que cada que se crea un nuevo festival también se reseteen los valores de escenarios y artistas.
            Festival nuevoFestival = new Festival(nombre, codigo, coordinador);
            this.festival = nuevoFestival;
            escenarios = new Escenario[5];
            artistas = new ArrayList<Artista>();

            vista.mostrarMensaje("Festival creado exitosamente :D");
        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        }
    }

    private int mostrarMenu() {
        return vista.mostrarMenu(festival != null ? festival.toString() : "");
    }

    private void configurarEscenario() {

        int posicion = vista.pedirInt("Ingrese la posición del escenario (1-5): ");
        int index = posicion - 1;

        try {

             if (escenarios[index] != null) {
                vista.mostrarMensaje("Error: ya existe un escenario en esta posición");
                return;
            }

            String codigo = vista.pedirString("Ingrese el código del escenario: ");

            // Verificar que no exista otro escenario con el mismo código
            for (int i = 0; i < escenarios.length; i++) {
                if (escenarios[i] != null &&
                        escenarios[i].getCodigoEscenario().equalsIgnoreCase(codigo)) {

                   vista.mostrarMensaje("Error: ya existe un escenario con ese código.");
                    return;
              }
            }

            String nombre = vista.pedirString("Ingrese el nombre del escenario: ");
            String ubicacion = vista.pedirString("Ingrese la ubicación del escenario: ");
            int capacidad = vista.pedirInt("Ingrese la capacidad máxima: ");

            while (capacidad <= 0) {
                vista.mostrarMensaje("La capacidad debe ser mayor a 0");
                capacidad = vista.pedirInt("Ingrese la capacidad máxima: ");
            }

           Escenario nuevoEscenario = new Escenario(codigo, nombre, ubicacion, capacidad, false );

          escenarios[index] = nuevoEscenario;

          vista.mostrarMensaje("Escenario configurado exitosamente :D");

         } catch (IndexOutOfBoundsException e) {
            vista.mostrarMensaje("Error: la posición ingresada debe de estar entre 1 y 5 -_-");

         } catch (IllegalArgumentException e) {
             vista.mostrarMensaje("Error: " + e.getMessage());
         }
    }

    private void consultarEscenarios() {
        boolean hayEscenarios = false;
        for (int i = 0; i < escenarios.length; i++) {
             if (escenarios[i] != null) {
                vista.mostrarMensaje(String.format("""
                        Posición: %d
                        %s
                        """,
                        i + 1,
                        escenarios[i]));
                hayEscenarios = true;
             }
        }
        if (!hayEscenarios) {
            vista.mostrarMensaje("No hay escenarios configurados.");
        }
    }

    private void consultarEscenario() {
        int posicion = vista.pedirInt("Ingrese la posición del escenario (1-5): ");

        int indice = posicion - 1;

        try {
            if (escenarios[indice] == null) {
                vista.mostrarMensaje("No hay escenario en esa posición.");
                return;
            }
            vista.mostrarMensaje(escenarios[indice].toString());
        } catch (IndexOutOfBoundsException e) {
            vista.mostrarMensaje("Error: la posición debe ser entre 1 y 5.");
        }
    }

    private void modificarEscenario() {
        int posicion = vista.pedirInt("Ingrese la posición del escenario que desea modificar (1-5): ");
        int indice = posicion - 1;

        try {
            if (escenarios[indice] == null) {
                vista.mostrarMensaje("No hay ningún escenario en esa posición.");
                return;
            }

            int capacidad = vista.pedirInt("Ingrese la nueva capacidad máxima: ");
            while (capacidad <= 0) {
                vista.mostrarMensaje("La capacidad debe ser mayor a 0");
                capacidad = vista.pedirInt("Ingrese la nueva capacidad máxima: ");
            }

            int estado = vista.pedirInt("""
                    Ingrese el nuevo estado:
                    1. Ocupado
                    2. Libre
                    Opción: 
                    """);

            while (estado != 1 && estado != 2) {
                vista.mostrarMensaje("Error: el estado ingresado no es válido.");
                estado = vista.pedirInt("""
                    Ingrese el nuevo estado:
                    1. Ocupado
                    2. Libre
                    Opción: 
                    """);
            }

            escenarios[indice].setCapacidadMax(capacidad);
            escenarios[indice].setEstado(estado == 1);

            vista.mostrarMensaje("Escenario modificado exitosamente.");

        } catch (IndexOutOfBoundsException e) {
            vista.mostrarMensaje("Error: la posición debe estar entre 1 y 5 -_-");
        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        }
    }

    private void retirarEscenario() {
        int posicion = vista.pedirInt("Ingrese la posición del escenario que desea retirar (1-5): ");
        int indice = posicion - 1;

        try {
            if (escenarios[indice] == null) {
                vista.mostrarMensaje("No hay ningún escenario configurado en esa posición.");
                return;
            }
            escenarios[indice] = null;
            vista.mostrarMensaje("Escenario retirado correctamente.");
        } catch (IndexOutOfBoundsException e) {
            vista.mostrarMensaje("Error: la posición debe estar entre 1 y 5.");
        }
    }

    private void registrarArtista() {

        try {

            String codigo =
                    vista.pedirString(
                            "Ingrese el código del artista: "
                    );

            // Verificar que el código no esté repetido
            for (int i = 0; i < artistas.size(); i++) {

                if (artistas.get(i)
                        .getCodigoArtista()
                        .equalsIgnoreCase(codigo)) {

                    vista.mostrarMensaje(
                            "Error: ya existe un artista con ese código."
                    );

                    return;
                }
            }

            String nombre = vista.pedirString("Ingrese el nombre artístico: ");

            String genero = vista.pedirString( "Ingrese el género musical: ");

            float duracion = vista.pedirFloat("Ingrese la duración de la presentación en minutos: ");

            while (duracion <= 0) {
                vista.mostrarMensaje("La duración debe ser mayor a 0");
                duracion = vista.pedirFloat("Ingrese la duración de la presentación en minutos: ");
            }

            int asistentes = vista.pedirInt("Ingrese la cantidad estimada de asistentes: ");
            while (asistentes < 0) {
                vista.mostrarMensaje("El número debe ser positivo");
                asistentes = vista.pedirInt("Ingrese la cantidad estimada de asistentes: ");
            }
            

            String escenario = vista.pedirString("Ingrese el código del escenario: ");

            Artista nuevoArtista =
                    new Artista(
                            codigo,
                            nombre,
                            genero,
                            duracion,
                            asistentes,
                            escenario
                    );

            artistas.add(nuevoArtista);

            vista.mostrarMensaje("Artista registrado exitosamente :D");

        } catch (IllegalArgumentException e) {

            vista.mostrarMensaje(
                    "Error: " + e.getMessage()
            );
        }
    }

    private void consultarArtistas() {

        if (artistas.isEmpty()) {

            vista.mostrarMensaje(
                    "No hay artistas registrados."
            );

            return;
        }

        for (int i = 0; i < artistas.size(); i++) {
            vista.mostrarMensaje("Posición: " + (i+1));
            vista.mostrarMensaje(
                    artistas.get(i).toString()
            );
        }
    }

    private void buscarArtista() {

        if (artistas.isEmpty()) {

            vista.mostrarMensaje(
                    "No hay artistas registrados."
            );

            return;
        }

        String codigo =
                vista.pedirString(
                        "Ingrese el código del artista que desea buscar: "
                );

        for (int i = 0; i < artistas.size(); i++) {

            if (artistas.get(i)
                    .getCodigoArtista()
                    .equalsIgnoreCase(codigo)) {

                vista.mostrarMensaje(
                        artistas.get(i).toString()
                );

                return;
            }
        }

        vista.mostrarMensaje(
                "No se encontró un artista con ese código."
        );
    }

    private void modificarArtista() {

        if (artistas.isEmpty()) {

            vista.mostrarMensaje(
                    "No hay artistas registrados."
            );

            return;
        }

        String codigo =
                vista.pedirString(
                        "Ingrese el código del artista que desea modificar: "
                );

        for (int i = 0; i < artistas.size(); i++) {

            Artista artista = artistas.get(i);

            if (artista
                    .getCodigoArtista()
                    .equalsIgnoreCase(codigo)) {

                try {

                    String nombre =
                            vista.pedirString(
                                    "Ingrese el nuevo nombre artístico: "
                            );

                    String genero =
                            vista.pedirString(
                                    "Ingrese el nuevo género musical: "
                            );

                    float duracion =
                            vista.pedirFloat(
                                    "Ingrese la nueva duración de la presentación: "
                            );
                    while (duracion <= 0) {
                        vista.mostrarMensaje("La duración debe ser mayor a 0");
                        duracion = vista.pedirFloat("Ingrese la duración de la presentación en minutos: ");
                    }

                    int asistentes =
                            vista.pedirInt(
                                    "Ingrese la nueva cantidad estimada de asistentes: "
                            );
                    while (asistentes < 0) {
                        vista.mostrarMensaje("El número debe ser positivo");
                        asistentes = vista.pedirInt("Ingrese la cantidad estimada de asistentes: ");
                    }

                    String escenario =
                            vista.pedirString(
                                    "Ingrese el nuevo código del escenario: "
                            );

                    artista.setNombreArtistico(nombre);
                    artista.setGeneroMusical(genero);
                    artista.setDuracionPresentacion(duracion);
                    artista.setAsistentes(asistentes);
                    artista.setCodigoEscenario(escenario);

                    vista.mostrarMensaje(
                            "Artista modificado exitosamente :D"
                    );

                } catch (IllegalArgumentException e) {

                    vista.mostrarMensaje(
                            "Error: " + e.getMessage()
                    );
                }

                return;
            }
        }

        vista.mostrarMensaje(
                "No se encontró un artista con ese código."
        );
    }

    private void cancelarParticipacion() {

        if (artistas.isEmpty()) {

            vista.mostrarMensaje(
                    "No hay artistas registrados."
            );

            return;
        }

        String codigo =
                vista.pedirString(
                        "Ingrese el código del artista que desea eliminar: "
                );

        for (int i = 0; i < artistas.size(); i++) {

            if (artistas.get(i)
                    .getCodigoArtista()
                    .equalsIgnoreCase(codigo)) {

                artistas.remove(i);

                vista.mostrarMensaje(
                        "Participación cancelada correctamente."
                );

                return;
            }
        }

        vista.mostrarMensaje(
                "No se encontró un artista con ese código."
        );
    }

    // REPORTE DEL FESTIVAL
    

    private void mostrarReporteFestival() {

        int totalEscenarios = calcularTotalEscenarios();

        int espaciosDisponibles = escenarios.length - totalEscenarios;

        vista.mostrarMensaje(
                "\n===== REPORTE DEL FESTIVAL ====="
        );

        vista.mostrarMensaje(
                "Cantidad de escenarios configurados: "
                        + totalEscenarios
        );

        vista.mostrarMensaje(
                "Espacios disponibles para escenarios: "
                        + espaciosDisponibles
        );

        Escenario escenarioMayor =
                calcularEscenarioMayorCapacidad();

        if (escenarioMayor != null) {

            vista.mostrarMensaje(
                    "Escenario con mayor capacidad:\n"
                            + escenarioMayor
            );

        } else {

            vista.mostrarMensaje(
                    "Escenario con mayor capacidad: No hay escenarios configurados."
            );
        }

        vista.mostrarMensaje(
                "Cantidad de artistas registrados: "
                        + calcularTotalArtistas()
        );

        // Evitar cálculos sobre un ArrayList vacío
        if (artistas.isEmpty()) {

            vista.mostrarMensaje(
                    "No hay artistas registrados para realizar los cálculos."
            );

            return;
        }

        Artista artistaMayorDuracion =
                getArtistaMayorDuracion();

        Artista artistaMayorAsistentes =
                getArtistaMayorAsistentes();

        vista.mostrarMensaje(
                "Artista con mayor duración:\n"
                        + artistaMayorDuracion
        );

        vista.mostrarMensaje(
                "Artista con mayor cantidad de asistentes:\n"
                        + artistaMayorAsistentes
        );

        vista.mostrarMensaje(
                "Promedio de duración de las presentaciones: "
                        + calcularPromedioDuracion()
                        + " minutos"
        );
    }

    // CÁLCULOS


    private int calcularTotalEscenarios() {

        int contador = 0;

        for (int i = 0; i < escenarios.length; i++) {

            if (escenarios[i] != null) {
                contador++;
            }
        }

        return contador;
    }

    private Escenario calcularEscenarioMayorCapacidad() {

        Escenario escenarioMayor = null;

        for (int i = 0; i < escenarios.length; i++) {

            if (escenarios[i] != null) {

                if (escenarioMayor == null || escenarios[i].getCapacidadMax() > escenarioMayor.getCapacidadMax()) {

                    escenarioMayor = escenarios[i];
                }
            }
        }

        return escenarioMayor;
    }

    private int calcularTotalArtistas() {

        return artistas.size();
    }

    private Artista getArtistaMayorDuracion() {

        if (artistas.isEmpty()) {
            return null;
        }

        Artista artistaMayor =
                artistas.get(0);

        for (int i = 1; i < artistas.size(); i++) {

            if (artistas.get(i).getDuracionPresentacion()
                    > artistaMayor.getDuracionPresentacion()) {

                artistaMayor = artistas.get(i);
            }
        }

        return artistaMayor;
    }

    private Artista getArtistaMayorAsistentes() {

        if (artistas.isEmpty()) {
            return null;
        }

        Artista artistaMayor =
                artistas.get(0);

        for (int i = 1; i < artistas.size(); i++) {

            if (artistas.get(i).getAsistentes()
                    > artistaMayor.getAsistentes()) {

                artistaMayor = artistas.get(i);
            }
        }

        return artistaMayor;
    }

    private float calcularPromedioDuracion() {

        if (artistas.isEmpty()) {
            return 0;
        }

        float suma = 0;

        for (int i = 0; i < artistas.size(); i++) {

            suma +=
                    artistas.get(i)
                            .getDuracionPresentacion();
        }

        return suma / artistas.size();
    }
    
}