import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        try {
            System.out.println("FESTIVAL UNIVERSITARIO DE MUSICA");
            Festival festival = leerFestival(entrada);

            int opcion = 0;

            while (opcion != 13) {
                try {
                    mostrarMenu();

                    opcion = entrada.nextInt();
                    entrada.nextLine();

                    switch (opcion) {
                        case 1: {
                            festival = leerFestival(entrada);
                            System.out.println(
                                "Nuevo festival creado sin escenarios ni artistas."
                            );
                            break;
                        }

                        case 2: {
                            System.out.print("Posicion del escenario (0 a 4): ");
                            int posicion = entrada.nextInt();
                            entrada.nextLine();

                            if (festival.consultarEscenario(posicion) != null) {
                                throw new IllegalStateException(
                                    "Esa posicion ya esta ocupada."
                                );
                            }

                            System.out.print("Codigo: ");
                            String codigo = entrada.nextLine();

                            System.out.print("Nombre: ");
                            String nombre = entrada.nextLine();

                            System.out.print("Ubicacion: ");
                            String ubicacion = entrada.nextLine();

                            System.out.print("Capacidad maxima: ");
                            int capacidad = entrada.nextInt();
                            entrada.nextLine();

                            System.out.print("Estado: ");
                            String estado = entrada.nextLine();

                            Escenario escenario = new Escenario(
                                codigo, nombre, ubicacion, capacidad, estado
                            );

                            festival.configurarEscenario(posicion, escenario);
                            System.out.println("Escenario configurado.");
                            break;
                        }

                        case 3: {
                            System.out.println(festival.consultarEscenarios());
                            break;
                        }

                        case 4: {
                            System.out.print("Posicion del escenario (0 a 4): ");
                            int posicion = entrada.nextInt();
                            entrada.nextLine();

                            Escenario escenario =
                                festival.consultarEscenario(posicion);

                            if (escenario == null) {
                                System.out.println("La posicion esta vacia.");
                            } else {
                                System.out.println(escenario);
                            }
                            break;
                        }

                        case 5: {
                            System.out.print("Posicion del escenario (0 a 4): ");
                            int posicion = entrada.nextInt();
                            entrada.nextLine();

                            if (festival.consultarEscenario(posicion) == null) {
                                throw new IllegalStateException(
                                    "No hay un escenario en esa posicion."
                                );
                            }

                            System.out.print("Nueva capacidad maxima: ");
                            int capacidad = entrada.nextInt();
                            entrada.nextLine();

                            System.out.print("Nuevo estado: ");
                            String estado = entrada.nextLine();

                            festival.modificarEscenario(
                                posicion, capacidad, estado
                            );

                            System.out.println("Escenario modificado.");
                            break;
                        }

                        case 6: {
                            System.out.print("Posicion del escenario (0 a 4): ");
                            int posicion = entrada.nextInt();
                            entrada.nextLine();

                            festival.retirarEscenario(posicion);
                            System.out.println("Escenario retirado.");
                            break;
                        }

                        case 7: {
                            System.out.print("Codigo del artista: ");
                            String codigo = entrada.nextLine();

                            if (festival.buscarArtista(codigo) != null) {
                                throw new IllegalArgumentException(
                                    "Ya existe un artista con ese codigo."
                                );
                            }

                            System.out.print("Nombre artistico: ");
                            String nombre = entrada.nextLine();

                            System.out.print("Genero musical: ");
                            String genero = entrada.nextLine();

                            System.out.print("Duracion en minutos: ");
                            int duracion = entrada.nextInt();
                            entrada.nextLine();

                            System.out.print("Asistentes estimados: ");
                            int asistentes = entrada.nextInt();
                            entrada.nextLine();

                            Artista artista = new Artista(
                                codigo, nombre, genero, duracion, asistentes
                            );

                            festival.registrarArtista(artista);
                            System.out.println("Artista registrado.");
                            break;
                        }

                        case 8: {
                            System.out.println(festival.consultarArtistas());
                            break;
                        }

                        case 9: {
                            System.out.print("Codigo del artista: ");
                            String codigo = entrada.nextLine();

                            Artista artista = festival.buscarArtista(codigo);

                            if (artista == null) {
                                System.out.println("Artista no encontrado.");
                            } else {
                                System.out.println(artista);
                            }
                            break;
                        }

                        case 10: {
                            System.out.print("Codigo actual del artista: ");
                            String codigoActual = entrada.nextLine();

                            if (festival.buscarArtista(codigoActual) == null) {
                                throw new IllegalArgumentException(
                                    "No existe un artista con ese codigo."
                                );
                            }

                            System.out.print("Nuevo codigo: ");
                            String nuevoCodigo = entrada.nextLine();

                            System.out.print("Nuevo nombre artistico: ");
                            String nombre = entrada.nextLine();

                            System.out.print("Nuevo genero musical: ");
                            String genero = entrada.nextLine();

                            System.out.print("Nueva duracion en minutos: ");
                            int duracion = entrada.nextInt();
                            entrada.nextLine();

                            System.out.print("Nueva cantidad de asistentes: ");
                            int asistentes = entrada.nextInt();
                            entrada.nextLine();

                            festival.modificarArtista(
                                codigoActual, nuevoCodigo, nombre,
                                genero, duracion, asistentes
                            );

                            System.out.println("Artista modificado.");
                            break;
                        }

                        case 11: {
                            System.out.print("Codigo del artista: ");
                            String codigo = entrada.nextLine();

                            if (festival.cancelarParticipacion(codigo)) {
                                System.out.println("Participacion cancelada.");
                            } else {
                                System.out.println("Artista no encontrado.");
                            }
                            break;
                        }

                        case 12: {
                            mostrarReporte(festival);
                            break;
                        }

                        case 13: {
                            System.out.println("Programa finalizado.");
                            break;
                        }

                        default: {
                            System.out.println(
                                "Selecciona una opcion entre 1 y 13."
                            );
                        }
                    }

                } catch (InputMismatchException e) {
                    System.out.println(
                        "Entrada incorrecta. Debes ingresar un numero entero."
                    );

                    entrada.nextLine();

                } catch (IllegalArgumentException e) {
                    System.out.println("Dato invalido: " + e.getMessage());

                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Posicion invalida: " + e.getMessage());

                } catch (IllegalStateException e) {
                    System.out.println("Operacion no permitida: " + e.getMessage());
                }
            }

        } finally {
            entrada.close();
        }
    }

    private static Festival leerFestival(Scanner entrada) {
        System.out.println("\nDATOS DEL FESTIVAL");

        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();

        System.out.print("Codigo de identificacion: ");
        String codigo = entrada.nextLine();

        System.out.print("Nombre del coordinador: ");
        String coordinador = entrada.nextLine();

        return new Festival(nombre, codigo, coordinador);
    }

    private static void mostrarMenu() {
        System.out.println("\n========== MENU ==========");
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
        System.out.print("Selecciona una opcion: ");
    }

    private static void mostrarReporte(Festival festival) {
        System.out.println("\n========== REPORTE ==========");
        System.out.println("Festival: " + festival.getNombre());
        System.out.println("Codigo: " + festival.getCodigo());
        System.out.println("Coordinador: " + festival.getCoordinador());

        System.out.println(
            "Escenarios configurados: " + festival.contarEscenarios()
        );

        System.out.println(
            "Espacios disponibles: " + festival.contarEspaciosLibres()
        );

        Escenario mayorEscenario = festival.escenarioMasGrande();

        if (mayorEscenario == null) {
            System.out.println("Escenario de mayor capacidad: sin datos.");
        } else {
            System.out.println(
                "Escenario de mayor capacidad: "
                + mayorEscenario.getNombre()
                + " (" + mayorEscenario.getCapacidadMaxima()
                + " asistentes)"
            );
        }

        System.out.println(
            "Artistas registrados: " + festival.contarArtistas()
        );

        if (festival.contarArtistas() == 0) {
            System.out.println("Artista de mayor duracion: sin datos.");
            System.out.println("Artista con mas asistentes: sin datos.");
            System.out.println("Promedio de duracion: sin datos.");
        } else {
            Artista mayorDuracion = festival.artistaMayorDuracion();
            Artista mayorAsistencia = festival.artistaMayorAsistencia();

            System.out.println(
                "Artista de mayor duracion: "
                + mayorDuracion.getNombreArtistico()
                + " (" + mayorDuracion.getDuracionMinutos()
                + " minutos)"
            );

            System.out.println(
                "Artista con mas asistentes: "
                + mayorAsistencia.getNombreArtistico()
                + " (" + mayorAsistencia.getAsistentesEstimados()
                + " asistentes)"
            );

            System.out.printf(
                "Promedio de duracion: %.2f minutos%n",
                festival.promedioDuracion()
            );
        }
    }
}