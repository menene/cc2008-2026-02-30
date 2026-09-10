import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
    private Scanner scanner;
    private Festival festival;

    public View(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        System.out.println(
            "=== FESTIVAL UNIVERSITARIO DE MÚSICA ==="
        );

        createFestival();

        int option;

        do {
            showMenu();
            option = readInt("Seleccione una opción: ");

            try {
                switch (option) {
                    case 1:
                        createFestival();
                        break;

                    case 2:
                        setNewScenario();
                        break;

                    case 3:
                        showScenarios();
                        break;

                    case 4:
                        showScenarioByIndex();
                        break;

                    case 5:
                        modifyScenario();
                        break;

                    case 6:
                        deleteScenario();
                        break;

                    case 7:
                        registerArtist();
                        break;

                    case 8:
                        showArtists();
                        break;

                    case 9:
                        findArtist();
                        break;

                    case 10:
                        modifyArtist();
                        break;

                    case 11:
                        cancelArtist();
                        break;

                    case 12:
                        showFestivalReport();
                        break;

                    case 13:
                        System.out.println(
                            "Finalizando el programa."
                        );
                        break;

                    default:
                        System.out.println(
                            "La opción seleccionada no existe."
                        );
                }
            } catch (
                IllegalArgumentException |
                IllegalStateException |
                IndexOutOfBoundsException exception
            ) {
                System.out.println(
                    "Error: " + exception.getMessage()
                );
            }

        } while (option != 13);
    }

    private void showMenu() {
        System.out.println();
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
        System.out.println("11. Cancelar participación");
        System.out.println("12. Mostrar reporte");
        System.out.println("13. Salir");
        System.out.println();
    }

    private void createFestival() {
        System.out.println();
        System.out.println("=== NUEVO FESTIVAL ===");

        String name = readText(
            "Nombre del festival: "
        );

        String id = readText(
            "Código del festival: "
        );

        String coordinatorName = readText(
            "Nombre del coordinador: "
        );

        this.festival = new Festival(
            name,
            id,
            coordinatorName
        );

        System.out.println(
            "Festival creado correctamente."
        );
    }

    private void setNewScenario() {
        System.out.println();
        System.out.println("=== CONFIGURAR ESCENARIO ===");

        int scenarioIndex =
            readScenarioIndex();

        String id = readText(
            "Código del escenario: "
        );

        String name = readText(
            "Nombre del escenario: "
        );

        String location = readText(
            "Ubicación: "
        );

        int capacity = readInt(
            "Capacidad máxima: "
        );

        boolean disponibility =
            readDisponibility();

        Scenario scenario = new Scenario(
            id,
            name,
            location,
            capacity,
            disponibility
        );

        this.festival.setNewScenario(
            scenarioIndex,
            scenario
        );

        System.out.println(
            "Escenario configurado correctamente."
        );
    }

    private void showScenarios() {
        System.out.println();
        System.out.println("=== ESCENARIOS ===");

        if (
            this.festival.getConfiguredScenarios() == 0
        ) {
            System.out.println(
                "No existen escenarios configurados."
            );
            return;
        }

        Scenario[] scenarios =
            this.festival.getScenarios();

        for (int index = 0; index < scenarios.length; index++) {
            if (scenarios[index] != null) {
                System.out.println(
                    "Posición: " + (index + 1)
                );

                printScenario(scenarios[index]);
                System.out.println();
            }
        }
    }

    private void showScenarioByIndex() {
        int scenarioIndex =
            readScenarioIndex();

        Scenario scenario =
            this.festival.getScenarioByIndex(
                scenarioIndex
            );

        printScenario(scenario);
    }

    private void modifyScenario() {
        int scenarioIndex =
            readScenarioIndex();

        int newCapacity = readInt(
            "Nueva capacidad máxima: "
        );

        boolean newDisponibility =
            readDisponibility();

        this.festival.modifyScenario(
            scenarioIndex,
            newCapacity,
            newDisponibility
        );

        System.out.println(
            "Escenario modificado correctamente."
        );
    }

    private void deleteScenario() {
        int scenarioIndex =
            readScenarioIndex();

        this.festival.deleteScenario(
            scenarioIndex
        );

        System.out.println(
            "Escenario retirado correctamente."
        );
    }

    private void registerArtist() {
        System.out.println();
        System.out.println("=== REGISTRAR ARTISTA ===");

        int scenarioIndex =
            readScenarioIndex();

        String artisticName = readText(
            "Nombre artístico: "
        );

        String musicalGender = readText(
            "Género musical: "
        );

        double pressentationTime = readDouble(
            "Duración de la presentación: "
        );

        int numberOfAssistants = readInt(
            "Cantidad estimada de asistentes: "
        );

        this.festival.registerArtist(
            scenarioIndex,
            artisticName,
            musicalGender,
            pressentationTime,
            numberOfAssistants
        );

        System.out.println(
            "Artista registrado correctamente."
        );
    }

    private void showArtists() {
        System.out.println();
        System.out.println("=== ARTISTAS ===");

        if (
            this.festival.getRegisteredArtist() == 0
        ) {
            System.out.println(
                "No existen artistas registrados."
            );
            return;
        }

        Scenario[] scenarios =
            this.festival.getScenarios();

        for (int index = 0; index < scenarios.length; index++) {
            Scenario scenario = scenarios[index];

            if (
                scenario != null &&
                !scenario.getArtists().isEmpty()
            ) {
                System.out.println();
                System.out.println(
                    "Escenario " + (index + 1) +
                    ": " + scenario.getName()
                );

                for (Artist artist : scenario.getArtists()) {
                    printArtist(artist);
                    System.out.println();
                }
            }
        }
    }

    private void findArtist() {
        String artistId = readText(
            "Código del artista: "
        );

        Artist artist =
            this.festival.findArtistById(artistId);

        if (artist == null) {
            throw new IllegalArgumentException(
                "No existe un artista con ese código."
            );
        }

        printArtist(artist);
    }

    private void modifyArtist() {
        String artistId = readText(
            "Código del artista: "
        );

        String artisticName = readText(
            "Nuevo nombre artístico: "
        );

        String musicalGender = readText(
            "Nuevo género musical: "
        );

        double pressentationTime = readDouble(
            "Nueva duración: "
        );

        int numberOfAssistants = readInt(
            "Nueva cantidad estimada de asistentes: "
        );

        this.festival.modifyArtist(
            artistId,
            artisticName,
            musicalGender,
            pressentationTime,
            numberOfAssistants
        );

        System.out.println(
            "Artista modificado correctamente."
        );
    }

    private void cancelArtist() {
        String artistId = readText(
            "Código del artista: "
        );

        this.festival.cancelArtist(artistId);

        System.out.println(
            "Participación cancelada correctamente."
        );
    }

    private void showFestivalReport() {
        System.out.println();
        System.out.println("=== REPORTE DEL FESTIVAL ===");

        System.out.println(
            "Escenarios configurados: " +
            this.festival.getConfiguredScenarios()
        );

        System.out.println(
            "Espacios disponibles: " +
            this.festival.getDisponibleSpaces()
        );

        Scenario largestScenario =
            this.festival
                .getScenarioWithMostNumberOfAssistants();

        if (largestScenario == null) {
            System.out.println(
                "Escenario de mayor capacidad: No disponible"
            );
        } else {
            System.out.println(
                "Escenario de mayor capacidad: " +
                largestScenario.getName() +
                " (" +
                largestScenario
                    .getMaxCapacityOfAssistants() +
                ")"
            );
        }

        System.out.println(
            "Artistas registrados: " +
            this.festival.getRegisteredArtist()
        );

        Artist longestArtist =
            this.festival
                .getArtistWithTheMostPresentationTime();

        if (longestArtist == null) {
            System.out.println(
                "Artista con mayor duración: No disponible"
            );
        } else {
            System.out.println(
                "Artista con mayor duración: " +
                longestArtist.getArtisticName() +
                " (" +
                longestArtist.getPressentationTime() +
                " minutos)"
            );
        }

        Artist largestArtist =
            this.festival
                .getArtistWithTheMostNumberOfAssistants();

        if (largestArtist == null) {
            System.out.println(
                "Artista con más asistentes: No disponible"
            );
        } else {
            System.out.println(
                "Artista con más asistentes: " +
                largestArtist.getArtisticName() +
                " (" +
                largestArtist.getNumberOfAssistants() +
                ")"
            );
        }

        System.out.printf(
            "Promedio de duración: %.2f minutos%n",
            this.festival
                .getAverageOfAllPresentation()
        );
    }

    private void printScenario(Scenario scenario) {
        System.out.println(
            "Código: " + scenario.getId()
        );

        System.out.println(
            "Nombre: " + scenario.getName()
        );

        System.out.println(
            "Ubicación: " + scenario.getLocation()
        );

        System.out.println(
            "Capacidad máxima: " +
            scenario.getMaxCapacityOfAssistants()
        );

        System.out.println(
            "Disponible: " +
            (
                scenario.getDisponibility()
                ? "Sí"
                : "No"
            )
        );
    }

    private void printArtist(Artist artist) {
        System.out.println(
            "Código: " + artist.getId()
        );

        System.out.println(
            "Nombre artístico: " +
            artist.getArtisticName()
        );

        System.out.println(
            "Género musical: " +
            artist.getMusicalGender()
        );

        System.out.println(
            "Duración: " +
            artist.getPressentationTime() +
            " minutos"
        );

        System.out.println(
            "Asistentes estimados: " +
            artist.getNumberOfAssistants()
        );
    }

    private int readScenarioIndex() {
        int position = readInt(
            "Posición del escenario (1-5): "
        );

        return position - 1;
    }

    private boolean readDisponibility() {
        while (true) {
            int option = readInt(
                "Estado (1 = disponible, 2 = no disponible): "
            );

            if (option == 1) {
                return true;
            }

            if (option == 2) {
                return false;
            }

            System.out.println(
                "Debes seleccionar 1 o 2."
            );
        }
    }

    private String readText(String message) {
        while (true) {
            System.out.print(message);
            String value = this.scanner.nextLine();

            if (!value.isBlank()) {
                return value;
            }

            System.out.println(
                "El valor no puede estar vacío."
            );
        }
    }

    private int readInt(String message) {
        while (true) {
            System.out.print(message);

            try {
                int value = this.scanner.nextInt();
                this.scanner.nextLine();
                return value;
            } catch (InputMismatchException exception) {
                System.out.println(
                    "Debes ingresar un número entero."
                );

                this.scanner.nextLine();
            }
        }
    }

    private double readDouble(String message) {
        while (true) {
            System.out.print(message);

            try {
                double value = this.scanner.nextDouble();
                this.scanner.nextLine();
                return value;
            } catch (InputMismatchException exception) {
                System.out.println(
                    "Debes ingresar un número."
                );

                this.scanner.nextLine();
            }
        }
    }
}