import java.util.ArrayList;

public class ControladorFestival {

    private Festival festivalActual;
    private VistaFestival vista;

    public ControladorFestival() {
        this.vista = new VistaFestival();
    }

    public void iniciar() {
        vista.mostrarMensaje("=== Creación del festival inicial ===");
        nuevoFestival();

        boolean salir = false;
        while (!salir) {
            vista.mostrarMenu();
            int opcion = vista.leerEntero("Seleccione una opción: ");
            try {
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
                    case 0:
                        salir = true;
                        vista.mostrarMensaje("Gracias por usar el sistema. ¡Hasta pronto!");
                        break;
                    default:
                        vista.mostrarMensaje("Opción inválida. Intente de nuevo.");
                }
            } catch (IllegalArgumentException e) {
                vista.mostrarMensaje("Dato inválido: " + e.getMessage());
            } catch (IndexOutOfBoundsException e) {
                vista.mostrarMensaje("Posición inválida: " + e.getMessage());
            } finally {
                if (!salir) {
                    vista.mostrarMensaje("--- Fin de la operación ---");
                }
            }
        }
        vista.cerrar();
    }

    private void nuevoFestival() {
        String nombre = vista.leerTextoNoVacio("Nombre del festival: ");
        String codigo = vista.leerTextoNoVacio("Código de identificación: ");
        String coordinador = vista.leerTextoNoVacio("Nombre del coordinador: ");
        festivalActual = new Festival(nombre, codigo, coordinador);
        vista.mostrarMensaje("Festival '" + nombre + "' creado. Sin escenarios ni artistas configurados.");
    }

    private void configurarEscenario() {
        int posicion = vista.leerEnteroEnRango("Posición del escenario (1-5): ", 1, 5);
        if (festivalActual.obtenerEscenario(posicion) != null) {
            vista.mostrarMensaje("La posición " + posicion + " ya está ocupada.");
            return;
        }
        String codigo = vista.leerTextoNoVacio("Código del escenario: ");
        String nombre = vista.leerTextoNoVacio("Nombre del escenario: ");
        String ubicacion = vista.leerTextoNoVacio("Ubicación: ");
        int capacidad = vista.leerEnteroPositivo("Capacidad máxima de asistentes: ");
        String estado = vista.leerTextoNoVacio("Estado (Activo/Inactivo/Mantenimiento): ");

        Escenario escenario = new Escenario(codigo, nombre, ubicacion, capacidad, estado);
        boolean exito = festivalActual.configurarEscenario(posicion, escenario);
        if (exito) {
            vista.mostrarMensaje("Escenario configurado correctamente en la posición " + posicion + ".");
        } else {
            vista.mostrarMensaje("La posición " + posicion + " ya está ocupada.");
        }
    }

    private void consultarEscenarios() {
        Escenario[] escenarios = festivalActual.getEscenarios();
        boolean hayAlguno = false;
        for (int i = 0; i < escenarios.length; i++) {
            if (escenarios[i] != null) {
                vista.mostrarEscenario(i + 1, escenarios[i]);
                hayAlguno = true;
            }
        }
        if (!hayAlguno) {
            vista.mostrarMensaje("No hay escenarios configurados.");
        }
    }

    private void consultarEscenario() {
        int posicion = vista.leerEnteroEnRango("Posición a consultar (1-5): ", 1, 5);
        Escenario escenario = festivalActual.obtenerEscenario(posicion);
        if (escenario == null) {
            vista.mostrarMensaje("La posición " + posicion + " está vacía.");
        } else {
            vista.mostrarEscenario(posicion, escenario);
        }
    }

    private void modificarEscenario() {
        int posicion = vista.leerEnteroEnRango("Posición del escenario a modificar (1-5): ", 1, 5);
        int capacidad = vista.leerEnteroPositivo("Nueva capacidad máxima: ");
        String estado = vista.leerTextoNoVacio("Nuevo estado: ");
        boolean exito = festivalActual.modificarEscenario(posicion, capacidad, estado);
        if (exito) {
            vista.mostrarMensaje("Escenario modificado correctamente.");
        } else {
            vista.mostrarMensaje("No existe un escenario configurado en la posición " + posicion + ".");
        }
    }

    private void retirarEscenario() {
        int posicion = vista.leerEnteroEnRango("Posición del escenario a retirar (1-5): ", 1, 5);
        boolean exito = festivalActual.retirarEscenario(posicion);
        if (exito) {
            vista.mostrarMensaje("Escenario retirado. La posición vuelve a estar disponible.");
        } else {
            vista.mostrarMensaje("No había ningún escenario configurado en esa posición.");
        }
    }

    private void registrarArtista() {
        String codigo = vista.leerTextoNoVacio("Código del artista: ");
        String nombreArtistico = vista.leerTextoNoVacio("Nombre artístico: ");
        String genero = vista.leerTextoNoVacio("Género musical: ");
        int duracion = vista.leerEnteroPositivo("Duración de la presentación (minutos): ");
        int asistentes = vista.leerEnteroNoNegativo("Cantidad estimada de asistentes: ");

        Artista artista = new Artista(codigo, nombreArtistico, genero, duracion, asistentes);
        boolean exito = festivalActual.registrarArtista(artista);
        if (exito) {
            vista.mostrarMensaje("Artista registrado correctamente.");
        } else {
            vista.mostrarMensaje("Ya existe un artista registrado con el código " + codigo + ".");
        }
    }

    private void consultarArtistas() {
        ArrayList<Artista> artistas = festivalActual.getArtistas();
        if (artistas.isEmpty()) {
            vista.mostrarMensaje("No hay artistas registrados.");
        } else {
            for (Artista artista : artistas) {
                vista.mostrarArtista(artista);
            }
        }
    }

    private void buscarArtista() {
        String codigo = vista.leerTextoNoVacio("Código del artista a buscar: ");
        Artista artista = festivalActual.buscarArtista(codigo);
        if (artista == null) {
            vista.mostrarMensaje("No se encontró ningún artista con el código " + codigo + ".");
        } else {
            vista.mostrarArtista(artista);
        }
    }

    private void modificarArtista() {
        String codigo = vista.leerTextoNoVacio("Código del artista a modificar: ");
        String nombreArtistico = vista.leerTextoNoVacio("Nuevo nombre artístico: ");
        String genero = vista.leerTextoNoVacio("Nuevo género musical: ");
        int duracion = vista.leerEnteroPositivo("Nueva duración (minutos): ");
        int asistentes = vista.leerEnteroNoNegativo("Nueva cantidad estimada de asistentes: ");

        boolean exito = festivalActual.modificarArtista(codigo, nombreArtistico, genero, duracion, asistentes);
        if (exito) {
            vista.mostrarMensaje("Artista modificado correctamente.");
        } else {
            vista.mostrarMensaje("No se encontró ningún artista con el código " + codigo + ".");
        }
    }

    private void cancelarParticipacion() {
        String codigo = vista.leerTextoNoVacio("Código del artista a cancelar: ");
        boolean exito = festivalActual.cancelarParticipacion(codigo);
        if (exito) {
            vista.mostrarMensaje("Participación cancelada correctamente.");
        } else {
            vista.mostrarMensaje("No se encontró ningún artista con el código " + codigo + ".");
        }
    }

    private void mostrarReporte() {
        int configurados = festivalActual.cantidadEscenariosConfigurados();
        int disponibles = festivalActual.cantidadEspaciosDisponibles();
        Escenario mayorCapacidad = festivalActual.escenarioMayorCapacidad();
        int artistasRegistrados = festivalActual.cantidadArtistasRegistrados();
        Artista mayorDuracion = festivalActual.artistaMayorDuracion();
        Artista mayorAsistencia = festivalActual.artistaMayorAsistencia();
        double promedio = festivalActual.promedioDuracionPresentaciones();

        vista.mostrarReporte(configurados, disponibles, mayorCapacidad,
                artistasRegistrados, mayorDuracion, mayorAsistencia, promedio);
    }
}