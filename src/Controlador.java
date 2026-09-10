import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controlador {
    private Vista vista = new Vista();
    private Festival festival = null;
    private Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        int opcion = 0;
        do {
            try {
                opcion = vista.mostrarMenu();
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
                        mostrarReporte();
                        break;
                    case 13:
                        vista.mostrarMensaje("Programa finalizado.");
                        break;
                    default:
                        vista.mostrarMensaje("Opción no válida.");
                }

            } catch (InputMismatchException e) {
                vista.mostrarMensaje("Debe ingresar un valor válido.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                vista.mostrarMensaje(e.getMessage());
            } finally {
                if (opcion != 13) {
                    System.out.println();
                }
            }
        } while (opcion != 13);
    }

    public void nuevoFestival() {
        festival = vista.leerFestival();
        vista.mostrarMensaje("Festival creado correctamente.");
    }

    public void configurarEscenario() {
        if (festival == null) {
            vista.mostrarMensaje("Primero debe crear un festival.");
            return;
        }

        try {
            System.out.print("Ingrese la posición del escenario (0-4): ");
            int posicion = scanner.nextInt();
            scanner.nextLine();
            if (posicion < 0 || posicion >= festival.getEscenarios().length) {
                vista.mostrarMensaje("La posición no es válida.");
                return;
            }
            if (festival.getEscenarios()[posicion] != null) {
                vista.mostrarMensaje("La posición ya está ocupada.");
                return;
            }
            Escenario escenario = vista.leerEscenario();
            festival.agregarEscenario(posicion, escenario);
            vista.mostrarMensaje("Escenario configurado correctamente.");

        } catch (InputMismatchException e) {
            scanner.nextLine();
            vista.mostrarMensaje("La posición debe ser un número entero.");
        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje(e.getMessage());
        }
    }

    public void consultarEscenarios() {
        if (festival == null) {
            vista.mostrarMensaje("Primero debe crear un festival.");
            return;
        }

        boolean encontrado = false;
        for (int i = 0; i < festival.getEscenarios().length; i++) {
            if (festival.getEscenarios()[i] != null) {
                System.out.println("Posición: " + i);
                vista.mostrarEscenario(
                    festival.getEscenarios()[i]
                );
                encontrado = true;
            }
        }

        if (!encontrado) {
            vista.mostrarMensaje("No hay escenarios configurados.");
        }
    }

    public void consultarEscenario() {
        if (festival == null) {
            vista.mostrarMensaje("Primero debe crear un festival.");
            return;
        }
        try {
            System.out.print("Ingrese la posición del escenario (0-4): ");
            int posicion = scanner.nextInt();
            scanner.nextLine();

            if (posicion < 0 || posicion >= festival.getEscenarios().length) {
                vista.mostrarMensaje("La posición no es válida.");
                return;
            }

            if (festival.getEscenarios()[posicion] == null) {
                vista.mostrarMensaje(
                    "No hay un escenario configurado en esta posición."
                );
                return;
            }

            vista.mostrarEscenario(
                festival.getEscenarios()[posicion]
            );

        } catch (InputMismatchException e) {
            scanner.nextLine();
            vista.mostrarMensaje("La posición debe ser un número entero.");
        }
    }

    public void modificarEscenario() {
        if (festival == null) {
            vista.mostrarMensaje("Primero debe crear un festival.");
            return;
        }
        try {
            System.out.print("Ingrese la posición del escenario: ");
            int posicion = scanner.nextInt();

            if (posicion < 0 || posicion >= festival.getEscenarios().length) {
                scanner.nextLine();
                vista.mostrarMensaje("La posición no es válida.");
                return;
            }
            if (festival.getEscenarios()[posicion] == null) {
                scanner.nextLine();
                vista.mostrarMensaje(
                    "No hay un escenario configurado en esta posición."
                );
                return;
            }
            Escenario escenario = festival.getEscenarios()[posicion];
            System.out.print("Ingrese la nueva capacidad máxima: ");
            short cap_max = scanner.nextShort();
            if (cap_max <= 0) {
                throw new IllegalArgumentException(
                    "La capacidad máxima debe ser mayor que 0."
                );
            }

            System.out.print(
                "Ingrese el nuevo estado (true = ocupado, false = libre): "
            );

            boolean estado = scanner.nextBoolean();
            scanner.nextLine();

            Escenario nuevoEscenario = new Escenario(
                escenario.GetCodigo_escenario(),
                escenario.GetNombre_escenario(),
                escenario.GetUbicación(),
                cap_max
            );

            nuevoEscenario.Setestado(estado);
            festival.getEscenarios()[posicion] = nuevoEscenario;
            vista.mostrarMensaje(
                "Escenario modificado correctamente."
            );

        } catch (InputMismatchException e) {
            scanner.nextLine();
            vista.mostrarMensaje("Ingrese valores válidos.");
        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje(e.getMessage());
        }
    }

    public void retirarEscenario() {
        if (festival == null) {
            vista.mostrarMensaje("Primero debe crear un festival.");
            return;
        }
        try {
            System.out.print("Ingrese la posición del escenario: ");
            int posicion = scanner.nextInt();
            scanner.nextLine();
            if (posicion < 0 || posicion >= festival.getEscenarios().length) {
                vista.mostrarMensaje("La posición no es válida.");
                return;
            }
            if (festival.getEscenarios()[posicion] == null) {
                vista.mostrarMensaje(
                    "No hay un escenario configurado en esta posición."
                );
                return;
            }

            festival.retirarEscenario(posicion);
            vista.mostrarMensaje(
                "Escenario retirado correctamente."
            );

        } catch (InputMismatchException e) {
            scanner.nextLine();
            vista.mostrarMensaje("La posición debe ser un número entero.");
        }
    }

    public void registrarArtista() {
        if (festival == null) {
            vista.mostrarMensaje("Primero debe crear un festival.");
            return;
        }

        try {
            Artista artista = vista.leerArtista();
            ArrayList<Artista> artistas = festival.getArtistas();
            for (Artista artistaActual : artistas) {
                if (artistaActual.GetCodigo_id()
                        .equals(artista.GetCodigo_id())) {
                    vista.mostrarMensaje(
                        "Ya existe un artista con ese código."
                    );
                    return;
                }
            }

            festival.agregarArtista(artista);
            vista.mostrarMensaje(
                "Artista registrado correctamente."
            );

        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje(e.getMessage());
        }
    }

    public void consultarArtistas() {
        if (festival == null) {
            vista.mostrarMensaje("Primero debe crear un festival.");
            return;
        }
        if (festival.getArtistas().isEmpty()) {
            vista.mostrarMensaje(
                "No hay artistas registrados."
            );
            return;
        }

        for (Artista artista : festival.getArtistas()) {
            vista.mostrarArtista(artista);
        }
    }

    public void buscarArtista() {
        if (festival == null) {
            vista.mostrarMensaje("Primero debe crear un festival.");
            return;
        }

        if (festival.getArtistas().isEmpty()) {
            vista.mostrarMensaje(
                "No hay artistas registrados."
            );
            return;
        }

        System.out.print("Ingrese el código del artista: ");
        String codigo = scanner.nextLine();

        boolean encontrado = false;
        for (Artista artista : festival.getArtistas()) {
            if (artista.GetCodigo_id().equals(codigo)) {
                vista.mostrarArtista(artista);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            vista.mostrarMensaje(
                "No se encontró un artista con ese código."
            );
        }
    }

    public void modificarArtista() {
        if (festival == null) {
            vista.mostrarMensaje("Primero debe crear un festival.");
            return;
        }

        if (festival.getArtistas().isEmpty()) {
            vista.mostrarMensaje(
                "No hay artistas registrados."
            );
            return;
        }

        System.out.print(
            "Ingrese el código del artista que desea modificar: "
        );
        String codigo = scanner.nextLine();
        for (int i = 0; i < festival.getArtistas().size(); i++) {
            Artista artista = festival.getArtistas().get(i);
            if (artista.GetCodigo_id().equals(codigo)) {
                try {
                    System.out.print(
                        "Ingrese el nuevo nombre artístico: "
                    );
                    String nombre_artistico = scanner.nextLine();
                    System.out.print(
                        "Ingrese el nuevo género musical: "
                    );
                    String genero_musical = scanner.nextLine();
                    System.out.print(
                        "Ingrese la nueva duración: "
                    );
                    float duracion = scanner.nextFloat();
                    System.out.print(
                        "Ingrese la nueva asistencia estimada: "
                    );
                    short asistencia = scanner.nextShort();
                    scanner.nextLine();
                    Artista nuevoArtista = new Artista(
                        codigo,
                        nombre_artistico,
                        genero_musical,
                        duracion,
                        asistencia
                    );

                    festival.getArtistas().set(
                        i,
                        nuevoArtista
                    );

                    vista.mostrarMensaje(
                        "Artista modificado correctamente."
                    );

                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    vista.mostrarMensaje(
                        "Ingrese valores válidos."
                    );
                } catch (IllegalArgumentException e) {
                    vista.mostrarMensaje(
                        e.getMessage()
                    );
                }
                return;
            }
        }

        vista.mostrarMensaje(
            "No se encontró un artista con ese código."
        );
    }

    public void cancelarParticipacion() {
        if (festival == null) {
            vista.mostrarMensaje("Primero debe crear un festival.");
            return;
        }
        if (festival.getArtistas().isEmpty()) {
            vista.mostrarMensaje(
                "No hay artistas registrados."
            );
            return;
        }

        System.out.print("Ingrese el código del artista: ");
        String codigo = scanner.nextLine();
        for (int i = 0; i < festival.getArtistas().size(); i++) {
            if (festival.getArtistas()
                    .get(i)
                    .GetCodigo_id()
                    .equals(codigo)) {
                festival.getArtistas().remove(i);
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

    public void mostrarReporte() {
        if (festival == null) {
            vista.mostrarMensaje("Primero debe crear un festival.");
            return;
        }

        int escenariosConfigurados = 0;
        int espaciosDisponibles = 0;
        Escenario escenarioMayor = null;
        for (int i = 0;
             i < festival.getEscenarios().length;
             i++) {
            if (festival.getEscenarios()[i] != null) {
                escenariosConfigurados++;
                if (escenarioMayor == null ||
                    festival.getEscenarios()[i].GetCap_max()
                    > escenarioMayor.GetCap_max()) {
                    escenarioMayor =
                        festival.getEscenarios()[i];
                }
            } else {
                espaciosDisponibles++;
            }
        }

        System.out.println(
            "===== REPORTE DEL FESTIVAL ====="
        );
        System.out.println(
            "Cantidad de escenarios configurados: "
            + escenariosConfigurados
        );
        System.out.println(
            "Espacios disponibles para escenarios: "
            + espaciosDisponibles
        );

        if (escenarioMayor != null) {
            System.out.println(
                "Escenario con mayor capacidad: "
                + escenarioMayor.GetNombre_escenario()
            );
            System.out.println(
                "Capacidad máxima: "
                + escenarioMayor.GetCap_max()
            );
        } else {
            System.out.println(
                "No hay escenarios configurados."
            );
        }

        ArrayList<Artista> artistas =
            festival.getArtistas();
        System.out.println(
            "Cantidad de artistas registrados: "
            + artistas.size()
        );

        if (!artistas.isEmpty()) {
            Artista artistaMayorDuracion =
                artistas.get(0);
            Artista artistaMayorAsistencia =
                artistas.get(0);
            float sumaDuracion = 0;

            for (Artista artista : artistas) {
                if (artista.Getduracion()
                    > artistaMayorDuracion.Getduracion()) {
                    artistaMayorDuracion = artista;
                }

                if (artista.Getasistencia()
                    > artistaMayorAsistencia.Getasistencia()) {
                    artistaMayorAsistencia = artista;
                }
                sumaDuracion += artista.Getduracion();
            }

            float promedio =
                sumaDuracion / artistas.size();
            System.out.println(
                "Artista con mayor duración: "
                + artistaMayorDuracion.GetNombre_artistico()
            );

            System.out.println(
                "Duración: "
                + artistaMayorDuracion.Getduracion()
            );

            System.out.println(
                "Artista con mayor cantidad estimada de asistentes: "
                + artistaMayorAsistencia.GetNombre_artistico()
            );

            System.out.println(
                "Asistencia estimada: "
                + artistaMayorAsistencia.Getasistencia()
            );

            System.out.println(
                "Promedio de duración: "
                + promedio
            );

        } else {
            System.out.println(
                "No hay artistas registrados."
            );
        }
    }
}