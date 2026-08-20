public class Controlador {
    private final Vista vista;
    private final Torneo torneo;

    public Controlador() {
        vista = new Vista();
        torneo = new Torneo();
    }

    public void iniciar() {
        vista.mostrarAtleta(torneo.getAtletaActivo());
        vista.esperarEnter();
        boolean continuar = true;
        while (continuar) {
            vista.mostrarAtleta(torneo.getAtletaActivo());
            int opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    crearNuevoAtleta();
                    break;
                case 2:
                    registrarIntento();
                    break;
                case 3:
                    consultarTiempos();
                    break;
                case 4:
                    consultarIntento();
                    break;
                case 5:
                    modificarTiempo();
                    break;
                case 6:
                    vista.mostrarPromedio(torneo.getAtletaActivo().calcularPromedio());
                    break;
                case 7:
                    mostrarTiemposExtremos();
                    break;
                case 8:
                    mostrarIntentosDisponibles();
                    break;
                case 9:
                    continuar = false;
                    vista.mostrarMensaje("Programa finalizado.");
                    break;
                default:
                    break;
            }
            if (continuar) {
                vista.mostrarAtleta(torneo.getAtletaActivo());
                vista.esperarEnter();
            }
        }
    }

    private void crearNuevoAtleta() {
        String nombre = vista.solicitarNombre();
        int numeroParticipante = vista.solicitarNumeroParticipante();
        int edad = vista.solicitarEdad();
        Atleta nuevoAtleta = new Atleta(nombre, numeroParticipante, edad);
        vista.mostrarMensaje("Atleta creado correctamente.");
        vista.mostrarMensaje("Los tiempos continuaran asignandose al atleta por defecto:");
        vista.mostrarAtleta(torneo.getAtletaActivo());
        vista.mostrarMensaje("Nuevo atleta: " + nuevoAtleta.getNombreAtleta()
                + " | Participante: " + nuevoAtleta.getNumeroParticipante()
                + " | Edad: " + nuevoAtleta.getEdad());
    }

    private void registrarIntento() {
        Atleta atleta = torneo.getAtletaActivo();
        vista.mostrarMensaje("Registrando tiempo para el atleta activo:");
        vista.mostrarAtleta(atleta);
        if (atleta.getIntentosDisponibles() == 0) {
            vista.mostrarMensaje("Ya se registraron los 10 intentos permitidos.");
            return;
        }
        double tiempo = vista.solicitarTiempo();
        if (atleta.registrarTiempo(tiempo)) {
            vista.mostrarMensaje("Intento registrado correctamente.");
        }
    }

    private void consultarTiempos() {
        Atleta atleta = torneo.getAtletaActivo();
        if (atleta.getIntentos() == 0) {
            vista.mostrarMensaje("No hay tiempos registrados.");
            return;
        }
        for (int numeroIntento = 1; numeroIntento <= atleta.getIntentos(); numeroIntento++) {
            vista.mostrarTiempo(numeroIntento, atleta.consultarIntento(numeroIntento));
        }
    }

    private void consultarIntento() {
        Atleta atleta = torneo.getAtletaActivo();
        int numeroIntento = vista.solicitarNumeroIntento();
        Tiempo tiempo = atleta.consultarIntento(numeroIntento);
        if (tiempo == null) {
            vista.mostrarMensaje("Ese intento no ha sido registrado.");
            return;
        }
        vista.mostrarTiempo(numeroIntento, tiempo);
    }

    private void modificarTiempo() {
        Atleta atleta = torneo.getAtletaActivo();
        int numeroIntento = vista.solicitarNumeroIntento();
        if (atleta.consultarIntento(numeroIntento) == null) {
            vista.mostrarMensaje("Ese intento no ha sido registrado.");
            return;
        }
        double nuevoTiempo = vista.solicitarTiempo();
        atleta.modificarTiempo(numeroIntento, nuevoTiempo);
        vista.mostrarMensaje("Tiempo modificado correctamente.");
    }

    private void mostrarTiemposExtremos() {
        Atleta atleta = torneo.getAtletaActivo();
        Tiempo mejorTiempo = atleta.obtenerMejorTiempo();
        if (mejorTiempo == null) {
            vista.mostrarMensaje("No hay tiempos registrados.");
            return;
        }
        vista.mostrarMensaje(String.format("Mejor tiempo: %.2f segundos", mejorTiempo.getSegundos()));
        vista.mostrarMensaje(String.format("Mayor tiempo: %.2f segundos", atleta.obtenerMayorTiempo().getSegundos()));
    }

    private void mostrarIntentosDisponibles() {
        Atleta atleta = torneo.getAtletaActivo();
        vista.mostrarIntentos(atleta.getIntentos(), atleta.getIntentosDisponibles());
    }
}
