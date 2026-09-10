import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Festival festival;

    public static void main(String[] args) {

        int opcion = 0;
        System.out.println();
        System.out.println("Festival Universitario de Música ");

        crearFestival();

        do {
            try {
                mostrarMenu();

                System.out.print("Seleccione una opcion: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

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
                        System.out.println("Saliendo del programa");
                        break;

                    default:
                        System.out.println("Opción no válida");
                }

            } catch (InputMismatchException e) {

                System.out.println(
                    "Error, debe ingresar un valor numérico"
                );

                scanner.nextLine();

            } catch (IllegalArgumentException e) {

                System.out.println("Error, " + e.getMessage());

            } finally {

                System.out.println("------------");
            }

        } while (opcion != 13);

        scanner.close();
    }

    private static void mostrarMenu() {

        System.out.println();
        System.out.println("Menú");
        System.out.println("1. Nuevo festival");
        System.out.println("2. Configurar escenario");
        System.out.println("3. Consultar escenarios");
        System.out.println("4. Consultar un escenario");
        System.out.println("5. Modificar escenario");
        System.out.println("6. Retirar escenario");
        System.out.println("7. Registrar artista");
        System.out.println("8. Consultar artistas");
        System.out.println("9. Buscar artista");
        System.out.println("10. Modificar artista");
        System.out.println("11. Cancelar participacion");
        System.out.println("12. Mostrar reporte del festival");
        System.out.println("13. Salir");
        System.out.println("====================================");
    }

    private static void crearFestival() {

        System.out.println();
        System.out.println("Nuevo Festival");

        System.out.print("Nombre del festival: ");
        String nombre = scanner.nextLine();

        System.out.print("Codigo de identificación: ");
        String codigo = scanner.nextLine();

        System.out.print("Nombre del coordinador: ");
        String coordinador = scanner.nextLine();

        festival = new Festival(
            nombre,
            codigo,
            coordinador
        );

        System.out.println(
            "Festival creado correctamente"
        );
    }

    private static void configurarEscenario() {

        System.out.println();
        System.out.println("Configurar Escenario");

        System.out.print("Posicion del escenario (1-5): ");
        int posicionUsuario = scanner.nextInt();
        scanner.nextLine();

        if (posicionUsuario < 1 || posicionUsuario > 5) {
            System.out.println("La posición indicada no es válida");
            return;
        }

        int posicion = posicionUsuario - 1;

        if (festival.obtenerEscenario(posicion) != null) {
            System.out.println(
                "La posición seleccionada ya esta ocupada"
            );
            return;
        }

        System.out.print("Código: ");
        String codigo = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ubicación: ");
        String ubicacion = scanner.nextLine();

        System.out.print("Capacidad máxima: ");
        int capacidadMaxima = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Estado: ");
        String estado = scanner.nextLine();

        Escenario escenario = new Escenario(
            codigo,
            nombre,
            ubicacion,
            capacidadMaxima,
            estado
        );

        boolean configurado =
            festival.configurarEscenario(posicion, escenario);

        if (configurado) {
            System.out.println(
                "Escenario configurado correctamente"
            );
        } else {
            System.out.println(
                "No se pudo configurar el escenario"
            );
        }
    }

    private static void consultarEscenarios() {

        System.out.println();
        System.out.println("Escenarios Configurados");

        boolean hayEscenarios = false;

        for (int i = 0; i < 5; i++) {

            Escenario escenario =
                festival.obtenerEscenario(i);

            if (escenario != null) {

                hayEscenarios = true;

                System.out.println();
                System.out.println("Posición: " + (i + 1));
                System.out.println(escenario);
            }
        }

        if (!hayEscenarios) {
            System.out.println(
                "No hay escenarios configurados"
            );
        }
    }

    private static void consultarEscenario() {

        System.out.println();
        System.out.println("Consultar Escenario");

        System.out.print("Ingrese la posición (1-5): ");
        int posicionUsuario = scanner.nextInt();
        scanner.nextLine();

        if (posicionUsuario < 1 || posicionUsuario > 5) {
            System.out.println(
                "La posición indicada no es válida"
            );
            return;
        }

        int posicion = posicionUsuario - 1;

        Escenario escenario =
            festival.obtenerEscenario(posicion);

        if (escenario == null) {

            System.out.println(
                "La posición no tiene un escenario"
            );

        } else {

            System.out.println();
            System.out.println(escenario);
        }
    }

    private static void modificarEscenario() {

        System.out.println();
        System.out.println("Modificar Escenario");

        System.out.print("Ingrese la posición (1-5): ");
        int posicionUsuario = scanner.nextInt();
        scanner.nextLine();

        if (posicionUsuario < 1 || posicionUsuario > 5) {
            System.out.println(
                "La posición indicada no es válida"
            );
            return;
        }

        int posicion = posicionUsuario - 1;

        Escenario escenario =
            festival.obtenerEscenario(posicion);

        if (escenario == null) {

            System.out.println(
                "La posición no tiene un escenario"
            );

            return;
        }

        System.out.print("Nueva capacidad máxima: ");
        int capacidadMaxima = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuevo estado: ");
        String estado = scanner.nextLine();

        boolean modificado =
            festival.modificarEscenario(
                posicion,
                capacidadMaxima,
                estado
            );

        if (modificado) {

            System.out.println(
                "Escenario modificado correctamente"
            );

        } else {

            System.out.println(
                "No se pudo modificar el escenario"
            );
        }
    }

    private static void retirarEscenario() {

        System.out.println();
        System.out.println("Retirar Escenario");

        System.out.print("Ingrese la posición (1-5): ");
        int posicionUsuario = scanner.nextInt();
        scanner.nextLine();

        if (posicionUsuario < 1 || posicionUsuario > 5) {
            System.out.println(
                "La posición indicada no es válida"
            );
            return;
        }

        int posicion = posicionUsuario - 1;

        boolean retirado =
            festival.retirarEscenario(posicion);

        if (retirado) {

            System.out.println(
                "Escenario retirado correctamente"
            );

        } else {

            System.out.println(
                "La posición no contiene un escenario"
            );
        }
    }

    private static void registrarArtista() {

        System.out.println();
        System.out.println("Registrar Artista");

        System.out.print("Código: ");
        String codigo = scanner.nextLine();

        if (festival.buscarArtista(codigo) != null) {

            System.out.println(
                "Ya hay un artista con ese código"
            );

            return;
        }

        System.out.print("Nombre artístico: ");
        String nombreArtistico = scanner.nextLine();

        System.out.print("Género musical: ");
        String generoMusical = scanner.nextLine();

        System.out.print(
            "Duración de la presentación en minutos: "
        );
        int duracionPresentacion = scanner.nextInt();
        scanner.nextLine();

        System.out.print(
            "Cantidad estimada de asistentes: "
        );
        int cantidadEstimadaAsistentes =
            scanner.nextInt();
        scanner.nextLine();

        Artista artista = new Artista(
            codigo,
            nombreArtistico,
            generoMusical,
            duracionPresentacion,
            cantidadEstimadaAsistentes
        );

        boolean registrado =
            festival.registrarArtista(artista);

        if (registrado) {

            System.out.println(
                "Artista registrado correctamente"
            );

        } else {

            System.out.println(
                "No se pudo registrar el artista"
            );
        }
    }

    private static void consultarArtistas() {

        System.out.println();
        System.out.println("Artistas Registrados");

        festival.mostrarArtistas();
    }

    private static void buscarArtista() {

        System.out.println();
        System.out.println("Buscar Artista");

        System.out.print("Código del artista: ");
        String codigo = scanner.nextLine();

        Artista artista =
            festival.buscarArtista(codigo);

        if (artista == null) {

            System.out.println(
                "No se encontró un artista con ese código"
            );

        } else {

            System.out.println();
            System.out.println(artista);
        }
    }

    private static void modificarArtista() {

        System.out.println();
        System.out.println("Modificar Artista");

        System.out.print("Código del artista: ");
        String codigo = scanner.nextLine();

        Artista artista =
            festival.buscarArtista(codigo);

        if (artista == null) {

            System.out.println(
                "No se encontró un artista con ese código"
            );

            return;
        }

        System.out.print("Nuevo nombre artístico: ");
        String nombreArtistico = scanner.nextLine();

        System.out.print("Nuevo género musical: ");
        String generoMusical = scanner.nextLine();

        System.out.print(
            "Nueva duración de la presentación: "
        );
        int duracionPresentacion = scanner.nextInt();
        scanner.nextLine();

        System.out.print(
            "Nueva cantidad estimada de asistentes: "
        );
        int cantidadEstimadaAsistentes =
            scanner.nextInt();
        scanner.nextLine();

        if (duracionPresentacion <= 0) {
            throw new IllegalArgumentException(
                "La duración de la presentación debe ser mayor que 0"
            );
        }

        if (cantidadEstimadaAsistentes < 0) {
            throw new IllegalArgumentException(
                "La cantidad estimada de asistentes no puede ser negativa"
            );
        }

        artista.setNombreArtistico(nombreArtistico);
        artista.setGeneroMusical(generoMusical);
        artista.setDuracionPresentacion(
            duracionPresentacion
        );
        artista.setCantidadEstimadaAsistentes(
            cantidadEstimadaAsistentes
        );

        System.out.println(
            "Artista modificado correctamente"
        );
    }

    private static void cancelarParticipacion() {

        System.out.println();
        System.out.println("Cancelar Participación");

        System.out.print("Código del artista: ");
        String codigo = scanner.nextLine();

        boolean eliminado =
            festival.eliminarArtista(codigo);

        if (eliminado) {

            System.out.println(
                "Participación cancelada correctamente"
            );

        } else {

            System.out.println(
                "No se encontró un artista con ese código"
            );
        }
    }

    private static void mostrarReporte() {

        System.out.println();
        System.out.println(
            "Reporte del Festival"
        );

        System.out.println(
            "Festival: " + festival.getNombre()
        );

        System.out.println(
            "Codigo: "
            + festival.getCodigoIdentificacion()
        );

        System.out.println(
            "Coordinador: "
            + festival.getNombreCoordinador()
        );

        System.out.println();

        System.out.println(
            "Escenarios configurados: "
            + festival.cantidadEscenariosConfigurados()
        );

        System.out.println(
            "Espacios disponibles: "
            + festival.cantidadEspaciosDisponibles()
        );

        Escenario escenarioMayor =
            festival.escenarioMayorCapacidad();

        if (escenarioMayor == null) {

            System.out.println(
                "No hay escenarios configurados"
            );

        } else {

            System.out.println();
            System.out.println(
                "Escenario con mayor capacidad:"
            );
            System.out.println(escenarioMayor);
        }

        System.out.println();

        System.out.println(
            "Artistas registrados: "
            + festival.cantidadArtistas()
        );

        if (festival.cantidadArtistas() == 0) {

            System.out.println(
                "No hay artistas para realizar cálculos"
            );

        } else {

            System.out.println();
            System.out.println(
                "Artista con la presentación de mayor duración:"
            );
            System.out.println(
                festival.artistaMayorDuracion()
            );

            System.out.println();
            System.out.println(
                "Artista con mayor cantidad estimada de asistentes:"
            );
            System.out.println(
                festival.artistaMayorAsistencia()
            );

            System.out.println();

            System.out.println(
                "Promedio de duración de las presentaciones: "
                + festival.promedioDuracion()
                + " minutos"
            );
        }
    }
}