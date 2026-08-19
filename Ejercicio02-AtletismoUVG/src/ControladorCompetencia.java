public class ControladorCompetencia {

    private Atleta atletaActivo;
    private VistaCompetencia vista;

    public ControladorCompetencia() {

        this.vista = new VistaCompetencia();
        
    }

    public void iniciar() {

        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.leerOpcion();

            if (opcion >= 2 && opcion <= 8 && atletaActivo == null) {
                vista.mostrarMensaje("¡Error! Primero debes registrar un atleta (opción 1).");
                continue; 
            }

            switch (opcion) {
                case 1:
                    nuevoAtleta();
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
                    mostrarPromedio();
                    break;

                case 7:
                    mostrarMejorYMayor();
                    break;

                case 8:
                    consultarIntentosDisponibles();
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;



                default:
                    System.out.println("Opcion invalida. Intentalo nuevamente");
                
            }

            } while (opcion != 9);
    }
    
    private void nuevoAtleta() {

        String nombre = vista.leerNombreAtleta();
        int numero = vista.leerNumeroParticipante();
        int edad = vista.leerEdad();

        atletaActivo = new Atleta(nombre, numero, edad);
        vista.mostrarMensaje("¡Nuevo atleta registrado!");
    }

    private void registrarIntento() {

        int intentos = atletaActivo.getIntentosDisponibles();

        if (intentos > 0) {
           
            double tiempo = vista.leerTiempo();
            
            if (atletaActivo.validarMayorCero(tiempo)) {
                
                atletaActivo.registrarTiempo(tiempo);
                vista.mostrarMensaje("¡Tiempo registrado!");

            } else {

                vista.mostrarMensaje("¡Error! El tiempo debe de ser mayor que cero.");
            }
        } else {
            vista.mostrarMensaje("¡Error! Se ha alcanzado el límite de intentos para este atleta.");
        }
    }

    private void consultarTiempos() {
        for (int i = 0; i < atletaActivo.getCantidadIntentos(); i++) {
        double tiempo = atletaActivo.consultarTiempo(i + 1);
        vista.mostrarMensaje("Intento " + (i + 1) + ": " + tiempo);
        }
    }

    private void consultarIntento() {
        int numero = vista.leerNumeroIntento();

        if (numero < 1 || numero > 10) {
            vista.mostrarMensaje("¡Error! No hay más de 10 intentos.");
            return;
        }

        if (numero > atletaActivo.getCantidadIntentos()) {
            vista.mostrarMensaje("¡Error! Ese intento no ha sido registrado.");
            return;
        }

        double tiempo = atletaActivo.consultarTiempo(numero);
        vista.mostrarMensaje("Intento " + numero + ": " + tiempo);
    }

    private void modificarTiempo() {
        int numero = vista.leerNumeroIntento();

        if (numero < 1 || numero > 10) {
            vista.mostrarMensaje("¡Error! No hay más de 10 intentos.");
            return;
        }

        if (numero > atletaActivo.getCantidadIntentos()) {
            vista.mostrarMensaje("¡Error! Ese intento no ha sido registrado.");
            return;
        }

        double nuevoTiempo = vista.leerTiempo();

        if (!atletaActivo.validarMayorCero(nuevoTiempo)) {
            vista.mostrarMensaje("¡Error! El tiempo debe ser mayor que cero.");
            return;
        }

        atletaActivo.modificarTiempo(numero, nuevoTiempo);
        vista.mostrarMensaje("¡Tiempo modificado!");
    }

    private void mostrarPromedio() {
        if (atletaActivo.getCantidadIntentos() > 0) {
            vista.mostrarMensaje("Promedio: " + atletaActivo.calcularPromedio());
        } else {
            vista.mostrarMensaje("Aún no hay intentos registrados.");
        }
    }

    private void mostrarMejorYMayor() {
        if (atletaActivo.getCantidadIntentos() > 0) {
            vista.mostrarMensaje("Mejor tiempo: " + atletaActivo.obtenerMejorTiempo());
            vista.mostrarMensaje("Mayor tiempo: " + atletaActivo.obtenerMayorTiempo());
        } else {
            vista.mostrarMensaje("Aún no hay intentos registrados.");
        }
    }

    private void consultarIntentosDisponibles() {
        vista.mostrarMensaje("Intentos realizados: " + atletaActivo.getCantidadIntentos());
        vista.mostrarMensaje("Intentos disponibles: " + atletaActivo.getIntentosDisponibles());
    }
}