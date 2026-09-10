public class ControladorFestival {
    private Festival festival;
    private VistaFestival vista;

    public ControladorFestival() {
        vista = new VistaFestival();
    }

    public void iniciar() {
        festival = vista.leerFestival();
        boolean continuar = true;

        while (continuar) {
            int opcion = vista.mostrarMenu();

            switch (opcion) {
                case 1:
                    festival = vista.leerFestival();
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
                    continuar = false;
                    vista.mostrarMensaje("Programa finalizado.");
                    break;

                default:
                    vista.mostrarMensaje("Opción inválida.");
                    break;
            }
        }
    }

    private void configurarEscenario() {
        int posicion = vista.leerPosicionEscenario();

        if (posicion == -1) {
            return;
        }

        if (festival.obtenerEscenario(posicion) != null) {
            vista.mostrarMensaje("Esa posición ya está ocupada.");
            return;
        }

        Escenario escenario = vista.leerEscenario(posicion + 1);

        if (escenario == null) {
            return;
        }

        try {
            festival.configurarEscenario(posicion, escenario);
            vista.mostrarMensaje("Escenario agregado correctamente.");

        } catch (IllegalArgumentException | IllegalStateException | IndexOutOfBoundsException e) {
            vista.mostrarMensaje(e.getMessage());
        }
    }

    private void consultarEscenarios() {
        boolean hayEscenarios = false;
        Escenario[] escenarios = festival.getEscenarios();

        for (int i = 0; i < escenarios.length; i++) {
            if (escenarios[i] != null) {
                vista.mostrarEscenario(i, escenarios[i]);
                hayEscenarios = true;
            }
        }

        if (!hayEscenarios) {
            vista.mostrarMensaje("No hay escenarios configurados.");
        }
    }

    private void consultarEscenario() {
        int posicion = vista.leerPosicionEscenario();

        if (posicion == -1) {
            return;
        }

        Escenario escenario = festival.obtenerEscenario(posicion);

        if (escenario == null) {
            vista.mostrarMensaje("La posición está vacía.");
            return;
        }

        vista.mostrarEscenario(posicion, escenario);
    }

    private void modificarEscenario() {
        int posicion = vista.leerPosicionEscenario();

        if (posicion == -1) {
            return;
        }

        Escenario escenario = festival.obtenerEscenario(posicion);

        if (escenario == null) {
            vista.mostrarMensaje("La posición está vacía.");
            return;
        }

        try {
            int opcion = vista.menuModificarEscenario();

            switch (opcion) {
                case 1:
                    int capacidad = vista.leerEntero("Nueva capacidad: ");
                    escenario.setCapacidad(capacidad);
                    break;

                case 2:
                    String estado = vista.leerTexto("Nuevo estado: ");
                    escenario.modificarEstado(estado);
                    break;

                case 3:
                    vista.mostrarMensaje("Modificación cancelada.");
                    return;

                default:
                    vista.mostrarMensaje("Opción inválida.");
                    return;
            }

            vista.mostrarMensaje("Escenario modificado correctamente.");

        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje(e.getMessage());
        }
    }

    private void retirarEscenario() {
        int posicion = vista.leerPosicionEscenario();

        if (posicion == -1) {
            return;
        }

        try {
            festival.retirarEscenario(posicion);
            vista.mostrarMensaje("Escenario retirado correctamente.");

        } catch (IllegalStateException | IndexOutOfBoundsException e) {
            vista.mostrarMensaje(e.getMessage());
        }
    }

    private Escenario solicitarEscenarioExistente() {
        int posicion = vista.leerPosicionEscenario();

        if (posicion == -1) {
            return null;
        }

        Escenario escenario = festival.obtenerEscenario(posicion);

        if (escenario == null) {
            vista.mostrarMensaje("La posición está vacía.");
        }

        return escenario;
    }

    private Artista buscarArtistaPorCodigo(String codigo) {
        for (Escenario escenario : festival.getEscenarios()) {
            if (escenario != null) {
                for (Artista artista : escenario.getArtistas()) {
                    if (artista.getCodigo().equalsIgnoreCase(codigo)) {
                        return artista;
                    }
                }
            }
        }

        return null;
    }

    private Escenario buscarEscenarioDelArtista(String codigo) {
        for (Escenario escenario : festival.getEscenarios()) {
            if (escenario != null) {
                for (Artista artista : escenario.getArtistas()) {
                    if (artista.getCodigo().equalsIgnoreCase(codigo)) {
                        return escenario;
                    }
                }
            }
        }

        return null;
    }

    private void registrarArtista() {
        Escenario escenario = solicitarEscenarioExistente();

        if (escenario == null) {
            return;
        }

        Artista artista = vista.leerArtista();

        if (artista == null) {
            return;
        }

        if (buscarArtistaPorCodigo(artista.getCodigo()) != null) {
            vista.mostrarMensaje("Ya existe un artista con ese código.");
            return;
        }

        escenario.getArtistas().add(artista);
        vista.mostrarMensaje("Artista registrado correctamente.");
    }

    private void consultarArtistas() {
        boolean hayArtistas = false;

        for (Escenario escenario : festival.getEscenarios()) {
            if (escenario != null) {
                for (Artista artista : escenario.getArtistas()) {
                    vista.mostrarMensaje("Escenario: " + escenario.getNombre());
                    vista.mostrarArtista(artista);
                    hayArtistas = true;
                }
            }
        }

        if (!hayArtistas) {
            vista.mostrarMensaje("No hay artistas registrados.");
        }
    }

    private void buscarArtista() {
        String codigo = vista.leerTexto("Código del artista: ");
        Artista artista = buscarArtistaPorCodigo(codigo);

        if (artista == null) {
            vista.mostrarMensaje("Artista no encontrado.");
            return;
        }

        vista.mostrarArtista(artista);
    }

    private void modificarArtista() {
        String codigo = vista.leerTexto("Código del artista: ");
        Artista artista = buscarArtistaPorCodigo(codigo);

        if (artista == null) {
            vista.mostrarMensaje("Artista no encontrado.");
            return;
        }

        try {
            int opcion = vista.menuModificarArtista();

            switch (opcion) {
                case 1:
                    artista.modificarNombre(vista.leerTexto("Nuevo nombre: "));
                    break;

                case 2:
                    artista.modificarGenero(vista.leerTexto("Nuevo género: "));
                    break;

                case 3:
                    artista.modificarDuracion(vista.leerDouble("Nueva duración: "));
                    break;

                case 4:
                    artista.modificarAsistentes(vista.leerEntero("Nuevos asistentes: "));
                    break;

                case 5:
                    vista.mostrarMensaje("Modificación cancelada.");
                    return;

                default:
                    vista.mostrarMensaje("Opción inválida.");
                    return;
            }

            vista.mostrarMensaje("Artista modificado correctamente.");

        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje(e.getMessage());
        }
    }

    private void cancelarParticipacion() {
        String codigo = vista.leerTexto("Código del artista: ");
        Escenario escenario = buscarEscenarioDelArtista(codigo);

        if (escenario == null) {
            vista.mostrarMensaje("Artista no encontrado.");
            return;
        }

        Artista artista = buscarArtistaPorCodigo(codigo);
        escenario.getArtistas().remove(artista);
        vista.mostrarMensaje("Participación cancelada correctamente.");
    }

    private int contarArtistas() {
        int cantidad = 0;

        for (Escenario escenario : festival.getEscenarios()) {
            if (escenario != null) {
                cantidad += escenario.getArtistas().size();
            }
        }

        return cantidad;
    }

    private Artista obtenerArtistaMayorDuracion() {
        Artista mayor = null;

        for (Escenario escenario : festival.getEscenarios()) {
            if (escenario != null) {
                for (Artista artista : escenario.getArtistas()) {
                    if (mayor == null || artista.getDuracion() > mayor.getDuracion()) {
                        mayor = artista;
                    }
                }
            }
        }

        return mayor;
    }

    private Artista obtenerArtistaMayorAsistencia() {
        Artista mayor = null;

        for (Escenario escenario : festival.getEscenarios()) {
            if (escenario != null) {
                for (Artista artista : escenario.getArtistas()) {
                    if (mayor == null || artista.getAsistentes() > mayor.getAsistentes()) {
                        mayor = artista;
                    }
                }
            }
        }

        return mayor;
    }

    private double calcularPromedioDuracion() {
        int cantidad = contarArtistas();

        if (cantidad == 0) {
            return 0;
        }

        double total = 0;

        for (Escenario escenario : festival.getEscenarios()) {
            if (escenario != null) {
                for (Artista artista : escenario.getArtistas()) {
                    total += artista.getDuracion();
                }
            }
        }

        return total / cantidad;
    }

    private void mostrarReporte() {
        vista.mostrarReporte(festival, contarArtistas(), obtenerArtistaMayorDuracion(),
                obtenerArtistaMayorAsistencia(), calcularPromedioDuracion());
    }
}