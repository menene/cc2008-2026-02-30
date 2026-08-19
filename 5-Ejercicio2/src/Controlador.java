
public class Controlador {

    private Atleta atletaActivo;
    private Vista vista;

    public Controlador(Vista vista) {
        this.vista = vista;
        this.atletaActivo = null;
    }


    public void iniciar() {
        vista.mostrarMensaje("Sistema de control de tiempos");
        nuevoAtleta();

        int opcion;
        do {
            opcion = vista.mostrarMenu();
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
                    mostrarMejorYMayorTiempo();
                    break;
                case 8:
                    consultarIntentosDisponibles();
                    break;
                case 9:
                    vista.mostrarMensaje("Gracias por usar el sistema.");
                    break;
                default:
                    vista.mostrarMensaje("Opcion invalida, intente de nuevo.");
            }
        } while (opcion != 9);
    }


    public void nuevoAtleta() {
        String nombre = vista.pedirNombre();
        int numeroParticipante = vista.pedirNumeroParticipante();
        int edad = vista.pedirEdad();
        atletaActivo = new Atleta(nombre, numeroParticipante, edad);
        vista.mostrarMensaje("Atleta " + nombre + " registrado correctamente.");
    }

    private void registrarIntento() {
        double tiempo = vista.pedirTiempo();
        boolean exito = atletaActivo.registrarTiempo(tiempo);

        if (exito) {
            vista.mostrarMensaje("Intento registrado correctamente.");
        } else if (atletaActivo.getIntentosDisponibles() == 0) {
            vista.mostrarMensaje("No se pudo registrar: ya se alcanzaron los 10 intentos permitidos.");
        } else {
            vista.mostrarMensaje("No se pudo registrar: el tiempo debe ser mayor que 0.");
        }
    }

    private void consultarTiempos() {
        int cantidad = atletaActivo.getCantidadIntentos();
        if (cantidad == 0) {
            vista.mostrarMensaje("El atleta todavia no tiene intentos registrados.");
            return;
        }
        for (int i = 1; i <= cantidad; i++) {
            double tiempo = atletaActivo.consultarTiempo(i);
            vista.mostrarTiempo(i, tiempo);
        }
    }

    private void consultarIntento() {
        int numeroIntento = vista.pedirNumeroIntento();
        double tiempo = atletaActivo.consultarTiempo(numeroIntento);

        if (tiempo == -1) {
            vista.mostrarMensaje("Ese numero de intento no ha sido registrado.");
        } else {
            vista.mostrarTiempo(numeroIntento, tiempo);
        }
    }

    private void modificarTiempo() {
        int numeroIntento = vista.pedirNumeroIntento();
        double nuevoTiempo = vista.pedirTiempo();
        boolean exito = atletaActivo.modificarTiempo(numeroIntento, nuevoTiempo);

        if (exito) {
            vista.mostrarMensaje("Tiempo modificado correctamente.");
        } else {
            vista.mostrarMensaje("No se pudo modificar: verifique que el intento exista "
                    + "y que el nuevo tiempo sea mayor que 0.");
        }
    }

    private void mostrarPromedio() {
        if (atletaActivo.getCantidadIntentos() == 0) {
            vista.mostrarMensaje("Todavia no hay intentos registrados.");
            return;
        }
        double promedio = atletaActivo.calcularPromedio();
        vista.mostrarPromedio(promedio);
    }

    private void mostrarMejorYMayorTiempo() {
        if (atletaActivo.getCantidadIntentos() == 0) {
            vista.mostrarMensaje("Todavia no hay intentos registrados.");
            return;
        }
        double mejor = atletaActivo.obtenerMejorTiempo();
        double mayor = atletaActivo.obtenerMayorTiempo();
        vista.mostrarMejorYMayorTiempo(mejor, mayor);
    }

    private void consultarIntentosDisponibles() {
        int realizados = atletaActivo.getCantidadIntentos();
        int disponibles = atletaActivo.getIntentosDisponibles();
        vista.mostrarIntentosDisponibles(realizados, disponibles);
    }
}
