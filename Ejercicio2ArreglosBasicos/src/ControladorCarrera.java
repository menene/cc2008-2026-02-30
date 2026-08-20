public class ControladorCarrera {
    //modelo activo y vista utilizada para interactuar con el usuario
    private Atleta atleta;
    private VistaCarrera vista;

    //constructor que recibe la vista que utilizara el controlador
    public ControladorCarrera(VistaCarrera vista) {
        this.vista = vista;
    }

    //inicializa al primer atleta y mantiene activo el menu principal
    public void iniciar() {
        vista.mostrarMensaje("Bienvenido al sistema de control de tiempos.");
        crearNuevoAtleta();

        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcionMenu();
            ejecutarOpcion(opcion);
        } while (opcion != 9);
    }

    //dirige cada opcion del menu al metodo que le corresponde
    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                crearNuevoAtleta();
                break;
            case 2:
                registrarNuevoIntento();
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
                mostrarPromedio();
                break;
            case 7:
                mostrarMejorYMayorTiempo();
                break;
            case 8:
                consultarIntentosDisponibles();
                break;
            case 9:
                vista.mostrarMensaje("Programa finalizado.");
                break;
            default:
                vista.mostrarMensaje("Opcion invalida. Seleccione un numero del 1 al 9.");
        }
    }

    //reemplaza al atleta activo por uno nuevo sin tiempos registrados
    private void crearNuevoAtleta() {
        String nombre = vista.solicitarNombreAtleta();
        int numeroParticipante = solicitarNumeroParticipanteValido();
        int edad = solicitarEdadValida();

        atleta = new Atleta(nombre, numeroParticipante, edad);
        vista.mostrarMensaje("Atleta creado correctamente: " + atleta.getNombre());
    }

    //solicita el numero hasta que sea mayor que 0
    private int solicitarNumeroParticipanteValido() {
        int numeroParticipante;

        do {
            numeroParticipante = vista.solicitarNumeroParticipante();
            if (numeroParticipante <= 0) {
                vista.mostrarMensaje("El numero de participante debe ser mayor que 0.");
            }
        } while (numeroParticipante <= 0);

        return numeroParticipante;
    }

    //solicita la edad hasta que sea mayor que 0
    private int solicitarEdadValida() {
        int edad;

        do {
            edad = vista.solicitarEdad();
            if (edad <= 0) {
                vista.mostrarMensaje("La edad debe ser mayor que 0.");
            }
        } while (edad <= 0);

        return edad;
    }

    //solicita un tiempo y delega su registro al atleta
    private void registrarNuevoIntento() {
        //se revisa el espacio antes de pedir un nuevo tiempo
        if (atleta.obtenerIntentosDisponibles() == 0) {
            vista.mostrarMensaje("No hay espacio para registrar mas intentos.");
            return;
        }

        double tiempo = vista.solicitarTiempo();
        if (atleta.registrarIntento(tiempo)) {
            vista.mostrarMensaje("Intento registrado correctamente.");
        } else {
            vista.mostrarMensaje("El tiempo debe ser un numero finito mayor que 0.");
        }
    }

    //muestra solamente las posiciones utilizadas del arreglo
    private void consultarTiempos() {
        double[] tiempos = atleta.obtenerTiemposRegistrados();

        if (tiempos.length == 0) {
            vista.mostrarMensaje("El atleta todavia no tiene intentos registrados.");
            return;
        }

        vista.mostrarMensaje("Tiempos registrados:");
        for (int i = 0; i < tiempos.length; i++) {
            vista.mostrarMensaje("Intento " + (i + 1) + ": " + tiempos[i] + " segundos");
        }
    }

    //consulta un intento especifico indicado por el usuario
    private void consultarIntento() {
        int numeroIntento = vista.solicitarNumeroIntento();
        double tiempo = atleta.getTiempo(numeroIntento);

        if (tiempo < 0) {
            vista.mostrarMensaje("Ese intento no ha sido registrado.");
        } else {
            vista.mostrarMensaje("Tiempo del intento " + numeroIntento + ": "
                    + tiempo + " segundos");
        }
    }

    //modifica un intento solamente si ya fue registrado
    private void modificarTiempo() {
        int numeroIntento = vista.solicitarNumeroIntento();

        //primero se valida el intento para no solicitar un tiempo innecesario
        if (atleta.getTiempo(numeroIntento) < 0) {
            vista.mostrarMensaje("No se puede modificar un intento que no ha sido registrado.");
            return;
        }

        double nuevoTiempo = vista.solicitarTiempo();
        if (atleta.modificarTiempo(numeroIntento, nuevoTiempo)) {
            vista.mostrarMensaje("Tiempo modificado correctamente.");
        } else {
            vista.mostrarMensaje("El tiempo debe ser un numero finito mayor que 0.");
        }
    }

    //muestra el promedio cuando existe por lo menos un intento
    private void mostrarPromedio() {
        if (!hayIntentosRegistrados()) {
            return;
        }

        vista.mostrarMensaje("Tiempo promedio: " + atleta.calcularPromedio() + " segundos");
    }

    //muestra el menor tiempo y el tiempo mas alto registrado
    private void mostrarMejorYMayorTiempo() {
        if (!hayIntentosRegistrados()) {
            return;
        }

        vista.mostrarMensaje("Mejor tiempo: " + atleta.obtenerMejorTiempo() + " segundos");
        vista.mostrarMensaje("Mayor tiempo: " + atleta.obtenerMayorTiempo() + " segundos");
    }

    //muestra las posiciones utilizadas y disponibles del arreglo
    private void consultarIntentosDisponibles() {
        vista.mostrarMensaje("Intentos registrados: " + atleta.getIntentosRegistrados());
        vista.mostrarMensaje("Intentos disponibles: " + atleta.obtenerIntentosDisponibles());
    }

    //verifica si existen datos antes de realizar calculos estadisticos
    private boolean hayIntentosRegistrados() {
        if (atleta.getIntentosRegistrados() == 0) {
            vista.mostrarMensaje("El atleta todavia no tiene intentos registrados.");
            return false;
        }

        return true;
    }
}
