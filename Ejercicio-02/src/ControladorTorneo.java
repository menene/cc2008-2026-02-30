public class ControladorTorneo {

    private Torneo torneo;
    private VistaTorneo vista;

    public ControladorTorneo(Torneo torneo, VistaTorneo vista) {
        this.torneo = torneo;
        this.vista = vista;
    }

    public void iniciar() {
        int opcion = 0;

        while (opcion != 10) {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();

            if (opcion == 1) {
                crearAtleta();
            } 
            else if (opcion == 2) {
                registrarIntento();
            } 
            else if (opcion == 3) {
                consultarTiempos();
            } 
            else if (opcion == 4) {
                consultarIntento();
            } 
            else if (opcion == 5) {
                modificarTiempo();
            } 
            else if (opcion == 6) {
                mostrarPromedio();
            } 
            else if (opcion == 7) {
                mostrarMejorYMayor();
            } 
            else if (opcion == 8) {
                mostrarIntentosDisponibles();
            } 
            else if (opcion == 9) {
                mostrarMejorAtleta();
            } 
            else if (opcion == 10) {
                vista.mostrarMensaje("Saliendo del programa...");
            } 
            else {
                vista.mostrarMensaje("Opcion invalida.");
            }
        }
    }

    private void crearAtleta() {
        String nombre = vista.solicitarNombre();
        int numero = vista.solicitarNumeroParticipante();
        int edad = vista.solicitarEdad();

        Atleta atleta = new Atleta(nombre, numero, edad);

        if (torneo.agregarAtleta(atleta)) {
            vista.mostrarMensaje("Atleta registrado correctamente.");
        } else {
            vista.mostrarMensaje("No se pueden registrar mas atletas.");
        }
    }

    private void registrarIntento() {
        Atleta atleta = torneo.getAtletaActivo();

        if (atleta == null) {
            vista.mostrarMensaje("Primero debe registrar un atleta.");
            return;
        }

        double tiempo = vista.solicitarTiempo();

        if (atleta.registrarTiempo(tiempo)) {
            vista.mostrarMensaje("Tiempo registrado correctamente.");
        } else {
            vista.mostrarMensaje("Tiempo invalido o no hay intentos disponibles.");
        }
    }

    private void consultarTiempos() {
        Atleta atleta = torneo.getAtletaActivo();

        if (atleta == null) {
            vista.mostrarMensaje("No hay un atleta activo.");
            return;
        }

        if (atleta.getCantidadIntentos() == 0) {
            vista.mostrarMensaje("El atleta no tiene intentos registrados.");
            return;
        }

        for (int i = 0; i < atleta.getCantidadIntentos(); i++) {
            vista.mostrarTiempo(i + 1, atleta.obtenerTiempo(i));
        }
    }

    private void consultarIntento() {
        Atleta atleta = torneo.getAtletaActivo();

        if (atleta == null) {
            vista.mostrarMensaje("No hay un atleta activo.");
            return;
        }

        int numeroIntento = vista.solicitarNumeroIntento();
        double tiempo = atleta.obtenerTiempo(numeroIntento - 1);

        if (tiempo == -1) {
            vista.mostrarMensaje("El intento indicado no existe.");
        } else {
            vista.mostrarTiempo(numeroIntento, tiempo);
        }
    }

    private void modificarTiempo() {
        Atleta atleta = torneo.getAtletaActivo();

        if (atleta == null) {
            vista.mostrarMensaje("No hay un atleta activo.");
            return;
        }

        int numeroIntento = vista.solicitarNumeroIntento();
        double nuevoTiempo = vista.solicitarTiempo();

        if (atleta.modificarTiempo(numeroIntento - 1, nuevoTiempo)) {
            vista.mostrarMensaje("Tiempo modificado correctamente.");
        } else {
            vista.mostrarMensaje("No se pudo modificar el tiempo.");
        }
    }

    private void mostrarPromedio() {
        Atleta atleta = torneo.getAtletaActivo();

        if (atleta == null) {
            vista.mostrarMensaje("No hay un atleta activo.");
            return;
        }

        double promedio = torneo.calcularPromedio(atleta);

        if (promedio == -1) {
            vista.mostrarMensaje("El atleta no tiene intentos registrados.");
        } else {
            vista.mostrarMensaje("Promedio: " + promedio + " segundos");
        }
    }

    private void mostrarMejorYMayor() {
        Atleta atleta = torneo.getAtletaActivo();

        if (atleta == null) {
            vista.mostrarMensaje("No hay un atleta activo.");
            return;
        }

        double mejor = torneo.obtenerMejorTiempo(atleta);
        double mayor = torneo.obtenerMayorTiempo(atleta);

        if (mejor == -1) {
            vista.mostrarMensaje("El atleta no tiene intentos registrados.");
            return;
        }

        vista.mostrarMensaje("Mejor tiempo: " + mejor + " segundos");
        vista.mostrarMensaje("Mayor tiempo: " + mayor + " segundos");
    }

    private void mostrarIntentosDisponibles() {
        Atleta atleta = torneo.getAtletaActivo();

        if (atleta == null) {
            vista.mostrarMensaje("No hay un atleta activo.");
            return;
        }

        vista.mostrarMensaje("Intentos realizados: " + atleta.getCantidadIntentos());
        vista.mostrarMensaje("Intentos disponibles: " + atleta.getIntentosDisponibles());
    }

    private void mostrarMejorAtleta() {
        Atleta atleta = torneo.obtenerMejorAtleta();

        if (atleta == null) {
            vista.mostrarMensaje("No hay atletas con tiempos registrados.");
            return;
        }

        double mejorTiempo = torneo.obtenerMejorTiempo(atleta);
        vista.mostrarMensaje("Mejor atleta: " + atleta.getNombre() + " - " + mejorTiempo + " segundos");
    }
}