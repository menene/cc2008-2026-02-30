import java.util.ArrayList;

public class Controlador {

    private Vista vista = new Vista();
    private Festival festival;

    public void iniciar() {
        boolean continuar = true;

        try {
            vista.mostrarMensaje("Bienvenido al sistema del festival.");
            String nombreFestival = vista.pedirTexto("Nombre del festival: ");
            String codigoFestival = vista.pedirTexto("Código del festival: ");
            String coordinador = vista.pedirTexto("Nombre del coordinador: ");
            festival = new Festival(
                nombreFestival, codigoFestival, coordinador
            );
            vista.mostrarMensaje("Festival creado correctamente.");

            while (continuar) {
                vista.mostrarMenu();
                int opcion = vista.pedirEntero("Seleccione una opción: ");

                try {
                    switch (opcion) {
                        case 1: {
                            nombreFestival = vista.pedirTexto(
                                "Nombre del festival: "
                            );
                            codigoFestival = vista.pedirTexto(
                                "Código del festival: "
                            );
                            coordinador = vista.pedirTexto(
                                "Nombre del coordinador: "
                            );
                            festival = new Festival(
                                nombreFestival, codigoFestival, coordinador
                            );
                            vista.mostrarMensaje(
                                "Festival reemplazado correctamente."
                            );
                            break;
                        }
                        case 2: {
                            int posicion = vista.pedirEntero(
                                "Posición del escenario (1-5): "
                            );
                            if (posicion < 1 || posicion > 5) {
                                vista.mostrarMensaje("La posición no es válida.");
                                break;
                            }
                            if (festival.consultarEscenario(posicion - 1) != null) {
                                vista.mostrarMensaje(
                                    "La posición seleccionada ya está ocupada."
                                );
                                break;
                            }

                            String codigo = vista.pedirTexto(
                                "Código del escenario: "
                            );
                            String nombre = vista.pedirTexto(
                                "Nombre del escenario: "
                            );
                            String ubicacion = vista.pedirTexto("Ubicación: ");
                            int capacidad = vista.pedirEntero(
                                "Capacidad máxima: "
                            );
                            String estado = vista.pedirTexto("Estado: ");
                            Escenario escenario = new Escenario(
                                codigo, nombre, ubicacion, capacidad, estado
                            );

                            if (festival.configurarEscenario(
                                    posicion - 1, escenario)) {
                                vista.mostrarMensaje(
                                    "Escenario configurado correctamente."
                                );
                            } else {
                                vista.mostrarMensaje(
                                    "No se pudo configurar el escenario."
                                );
                            }
                            break;
                        }
                        case 3: {
                            Escenario[] escenarios =
                                festival.consultarEscenarios();
                            if (escenarios.length == 0) {
                                vista.mostrarMensaje(
                                    "No hay escenarios configurados."
                                );
                                break;
                            }

                            vista.mostrarMensaje("\nEscenarios configurados:");
                            for (Escenario escenario : escenarios) {
                                int posicion = 0;
                                for (int i = 0; i < 5; i++) {
                                    if (festival.consultarEscenario(i) == escenario) {
                                        posicion = i + 1;
                                    }
                                }
                                vista.mostrarMensaje(
                                    "Posición " + posicion
                                    + " - Código: " + escenario.getCodigo()
                                    + ", nombre: " + escenario.getNombre()
                                    + ", ubicación: " + escenario.getUbicacion()
                                    + ", capacidad máxima: "
                                    + escenario.getCapacidadMaxima()
                                    + ", estado: " + escenario.getEstado()
                                );
                            }
                            break;
                        }
                        case 4: {
                            int posicion = vista.pedirEntero(
                                "Posición del escenario (1-5): "
                            );
                            if (posicion < 1 || posicion > 5) {
                                vista.mostrarMensaje("La posición no es válida.");
                                break;
                            }

                            Escenario escenario =
                                festival.consultarEscenario(posicion - 1);
                            if (escenario == null) {
                                vista.mostrarMensaje(
                                    "La posición está disponible."
                                );
                            } else {
                                vista.mostrarMensaje(
                                    "Código: " + escenario.getCodigo()
                                    + ", nombre: " + escenario.getNombre()
                                    + ", ubicación: " + escenario.getUbicacion()
                                    + ", capacidad máxima: "
                                    + escenario.getCapacidadMaxima()
                                    + ", estado: " + escenario.getEstado()
                                );
                            }
                            break;
                        }
                        case 5: {
                            int posicion = vista.pedirEntero(
                                "Posición del escenario (1-5): "
                            );
                            if (posicion < 1 || posicion > 5) {
                                vista.mostrarMensaje("La posición no es válida.");
                                break;
                            }
                            if (festival.consultarEscenario(posicion - 1) == null) {
                                vista.mostrarMensaje(
                                    "La posición no contiene un escenario."
                                );
                                break;
                            }

                            int capacidad = vista.pedirEntero(
                                "Nueva capacidad máxima: "
                            );
                            String estado = vista.pedirTexto("Nuevo estado: ");
                            festival.modificarEscenario(
                                posicion - 1, capacidad, estado
                            );
                            vista.mostrarMensaje(
                                "Escenario modificado correctamente."
                            );
                            break;
                        }
                        case 6: {
                            int posicion = vista.pedirEntero(
                                "Posición del escenario (1-5): "
                            );
                            if (posicion < 1 || posicion > 5) {
                                vista.mostrarMensaje("La posición no es válida.");
                                break;
                            }
                            if (festival.consultarEscenario(posicion - 1) == null) {
                                vista.mostrarMensaje(
                                    "La posición no contiene un escenario."
                                );
                                break;
                            }

                            festival.retirarEscenario(posicion - 1);
                            vista.mostrarMensaje(
                                "Escenario retirado correctamente."
                            );
                            break;
                        }
                        case 7: {
                            String codigo = vista.pedirTexto(
                                "Código del artista: "
                            );
                            String nombre = vista.pedirTexto(
                                "Nombre artístico: "
                            );
                            String genero = vista.pedirTexto("Género musical: ");
                            int duracion = vista.pedirEntero(
                                "Duración en minutos: "
                            );
                            int asistentes = vista.pedirEntero(
                                "Cantidad estimada de asistentes: "
                            );
                            Artista artista = new Artista(
                                codigo, nombre, genero, duracion, asistentes
                            );

                            if (festival.registrarArtista(artista)) {
                                vista.mostrarMensaje(
                                    "Artista registrado correctamente."
                                );
                            } else {
                                vista.mostrarMensaje(
                                    "Ya existe un artista con ese código."
                                );
                            }
                            break;
                        }
                        case 8: {
                            ArrayList<Artista> artistas =
                                festival.consultarArtistas();
                            if (artistas.isEmpty()) {
                                vista.mostrarMensaje(
                                    "No hay artistas registrados."
                                );
                                break;
                            }

                            vista.mostrarMensaje("\nArtistas registrados:");
                            for (Artista artista : artistas) {
                                vista.mostrarMensaje(
                                    "Código: " + artista.getCodigo()
                                    + ", nombre artístico: "
                                    + artista.getNombreArtistico()
                                    + ", género musical: "
                                    + artista.getGeneroMusical()
                                    + ", duración: "
                                    + artista.getDuracionMinutos() + " minutos"
                                    + ", asistentes estimados: "
                                    + artista.getCantidadAsistentes()
                                );
                            }
                            break;
                        }
                        case 9: {
                            String codigo = vista.pedirTexto(
                                "Código del artista: "
                            );
                            Artista artista = festival.buscarArtista(codigo);
                            if (artista == null) {
                                vista.mostrarMensaje(
                                    "No se encontró un artista con ese código."
                                );
                            } else {
                                vista.mostrarMensaje(
                                    "Código: " + artista.getCodigo()
                                    + ", nombre artístico: "
                                    + artista.getNombreArtistico()
                                    + ", género musical: "
                                    + artista.getGeneroMusical()
                                    + ", duración: "
                                    + artista.getDuracionMinutos() + " minutos"
                                    + ", asistentes estimados: "
                                    + artista.getCantidadAsistentes()
                                );
                            }
                            break;
                        }
                        case 10: {
                            String codigoActual = vista.pedirTexto(
                                "Código del artista a modificar: "
                            );
                            Artista artista =
                                festival.buscarArtista(codigoActual);
                            if (artista == null) {
                                vista.mostrarMensaje(
                                    "No se encontró un artista con ese código."
                                );
                                break;
                            }

                            String nuevoCodigo = vista.pedirTexto(
                                "Nuevo código: "
                            );
                            Artista codigoRepetido =
                                festival.buscarArtista(nuevoCodigo);
                            if (codigoRepetido != null
                                    && codigoRepetido != artista) {
                                vista.mostrarMensaje(
                                    "Ya existe otro artista con el nuevo código."
                                );
                                break;
                            }

                            String nombre = vista.pedirTexto(
                                "Nuevo nombre artístico: "
                            );
                            String genero = vista.pedirTexto(
                                "Nuevo género musical: "
                            );
                            int duracion = vista.pedirEntero(
                                "Nueva duración en minutos: "
                            );
                            int asistentes = vista.pedirEntero(
                                "Nueva cantidad estimada de asistentes: "
                            );

                            if (duracion <= 0) {
                                throw new IllegalArgumentException(
                                    "La duración debe ser mayor que 0."
                                );
                            }
                            if (asistentes < 0) {
                                throw new IllegalArgumentException(
                                    "La cantidad de asistentes no puede ser negativa."
                                );
                            }

                            artista.setCodigo(nuevoCodigo);
                            artista.setNombreArtistico(nombre);
                            artista.setGeneroMusical(genero);
                            artista.setDuracionMinutos(duracion);
                            artista.setCantidadAsistentes(asistentes);
                            vista.mostrarMensaje(
                                "Artista modificado correctamente."
                            );
                            break;
                        }
                        case 11: {
                            String codigo = vista.pedirTexto(
                                "Código del artista: "
                            );
                            if (festival.buscarArtista(codigo) == null) {
                                vista.mostrarMensaje(
                                    "No se encontró un artista con ese código."
                                );
                                break;
                            }
                            festival.cancelarParticipacion(codigo);
                            vista.mostrarMensaje(
                                "Participación cancelada correctamente."
                            );
                            break;
                        }
                        case 12: {
                            Escenario escenarioMayor =
                                festival.getEscenarioMayorCapacidad();
                            Artista artistaMayorDuracion =
                                festival.getArtistaMayorDuracion();
                            Artista artistaMayorAsistentes =
                                festival.getArtistaMayorAsistentes();
                            int cantidadArtistas =
                                festival.consultarArtistas().size();

                            vista.mostrarMensaje(
                                "\n===== REPORTE DEL FESTIVAL ====="
                            );
                            vista.mostrarMensaje(
                                "Festival: " + festival.getNombre()
                            );
                            vista.mostrarMensaje(
                                "Código: " + festival.getCodigo()
                            );
                            vista.mostrarMensaje(
                                "Coordinador: " + festival.getCoordinador()
                            );
                            vista.mostrarMensaje(
                                "Escenarios configurados: "
                                + festival.calcularEscenariosConfig()
                            );
                            vista.mostrarMensaje(
                                "Espacios disponibles: "
                                + festival.calcularEspaciosDisponibles()
                            );

                            if (escenarioMayor == null) {
                                vista.mostrarMensaje(
                                    "Escenario con mayor capacidad: no disponible."
                                );
                            } else {
                                vista.mostrarMensaje(
                                    "Escenario con mayor capacidad: "
                                    + escenarioMayor.getNombre() + " ("
                                    + escenarioMayor.getCapacidadMaxima() + ")"
                                );
                            }

                            vista.mostrarMensaje(
                                "Artistas registrados: " + cantidadArtistas
                            );
                            if (artistaMayorDuracion == null) {
                                vista.mostrarMensaje(
                                    "Artista con mayor duración: no disponible."
                                );
                            } else {
                                vista.mostrarMensaje(
                                    "Artista con mayor duración: "
                                    + artistaMayorDuracion.getNombreArtistico()
                                    + " ("
                                    + artistaMayorDuracion.getDuracionMinutos()
                                    + " minutos)"
                                );
                            }

                            if (artistaMayorAsistentes == null) {
                                vista.mostrarMensaje(
                                    "Artista con más asistentes estimados: "
                                    + "no disponible."
                                );
                            } else {
                                vista.mostrarMensaje(
                                    "Artista con más asistentes estimados: "
                                    + artistaMayorAsistentes.getNombreArtistico()
                                    + " ("
                                    + artistaMayorAsistentes
                                        .getCantidadAsistentes()
                                    + ")"
                                );
                            }

                            if (cantidadArtistas == 0) {
                                vista.mostrarMensaje(
                                    "Promedio de duración: no disponible."
                                );
                            } else {
                                vista.mostrarMensaje(
                                    String.format(
                                        "Promedio de duración: %.2f minutos.",
                                        festival.calcularPromedioDuracion()
                                    )
                                );
                            }
                            break;
                        }
                        case 13:
                            continuar = false;
                            break;
                        default:
                            vista.mostrarMensaje(
                                "Opción inválida. Intente nuevamente."
                            );
                    }
                } catch (IllegalArgumentException
                        | IndexOutOfBoundsException e) {
                    vista.mostrarMensaje("Error: " + e.getMessage());
                }
            }
        } finally {
            vista.mostrarMensaje("Programa finalizado. ¡Hasta pronto!");
        }
    }
}
