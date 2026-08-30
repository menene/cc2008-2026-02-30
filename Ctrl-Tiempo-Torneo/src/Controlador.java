public class Controlador {

    private Vista vista;
    private Atleta atletaActivo;

    public Controlador() {
        vista = new Vista();
        atletaActivo = null;
    }

    public void iniciar() {

        int opcion;

        do {

            opcion = vista.mostrarMenu();

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
                    mostrarPromedio();
                    break;

                case 7:
                    mostrarMayorYMejor();
                    break;

                case 8:
                    mostrarIntentosDisponibles();
                    break;

                case 9:
                    vista.mostrarMensaje("Programa finalizado.");
                    break;

                default:
                    vista.mostrarMensaje("Opcion invalida.");
            }

        } while (opcion != 9);
    }

    public void crearNuevoAtleta() {

        String nombre;
        int numeroParticipante;
        int edad;
        nombre = vista.pedirNombre();
        numeroParticipante = vista.pedirNumeroParticipante();
        edad = vista.pedirEdad();
        atletaActivo = new Atleta(nombre, numeroParticipante, edad);
        vista.mostrarMensaje("Atleta creado correctamente.");
    }

    public void registrarIntento() {

        if (atletaActivo == null) {
            vista.mostrarMensaje("Primero debe crear un atleta.");

        } else {
            double tiempo;
            tiempo = vista.pedirTiempo();
            atletaActivo.registrarTiempo(tiempo);
            vista.mostrarMensaje("Intento registrado correctamente.");
        }
    }

    public void consultarTiempos() {

        if (atletaActivo == null) {
            vista.mostrarMensaje("Primero debe crear un atleta.");

        } else {
            atletaActivo.mostrarTiempos();
        }
    }

    public void consultarIntento() {

        if (atletaActivo == null) {
            vista.mostrarMensaje("Primero debe crear un atleta.");

        } else {

            int numeroIntento;
            double tiempo;
            numeroIntento = vista.pedirNumeroIntento();
            tiempo = atletaActivo.getTiempo(numeroIntento);

            if (tiempo == -1) {
                vista.mostrarMensaje("Ese intento no ha sido registrado.");

            } else {

                vista.mostrarMensaje(
                        "Intento " + numeroIntento + ": "
                        + tiempo + " segundos"
                );
            }
        }
    }

    public void modificarTiempo() {

        if (atletaActivo == null) {
            vista.mostrarMensaje("Primero debe crear un atleta.");

        } else {

            int numeroIntento;
            double nuevoTiempo;
            numeroIntento = vista.pedirNumeroIntento();
            nuevoTiempo = vista.pedirTiempo();
            atletaActivo.modificarTiempo(numeroIntento, nuevoTiempo);
            vista.mostrarMensaje("Tiempo cambiado correctamente.");
        }
    }

    public void mostrarPromedio() {

        if (atletaActivo == null) {
            vista.mostrarMensaje("Primero debe crear un atleta.");

        } else {

            double promedio;
            promedio = atletaActivo.calcularPromedio();
            vista.mostrarMensaje(
                    "Tiempo promedio: " + promedio + " segundos"
            );
        }
    }

    public void mostrarMayorYMejor() {

        if (atletaActivo == null) {
            vista.mostrarMensaje("Primero debe crear un atleta.");

        } else {

            double mejor;
            double mayor;
            mejor = atletaActivo.obtenerMejorTiempo();
            mayor = atletaActivo.obtenerMayorTiempo();
            vista.mostrarMensaje(
                    "Mejor tiempo: " + mejor + " segundos"
            );
            vista.mostrarMensaje(
                    "Mayor tiempo: " + mayor + " segundos"
            );
        }
    }

    public void mostrarIntentosDisponibles() {

        if (atletaActivo == null) {
            vista.mostrarMensaje("Primero debe crear un atleta.");

        } else {

            int realizados;
            int disponibles;
            realizados = atletaActivo.getCantidadIntentos();
            disponibles = atletaActivo.getIntentosRestantes();
            vista.mostrarMensaje(
                    "Intentos realizados: " + realizados
            );

            vista.mostrarMensaje(
                    "Intentos disponibles: " + disponibles
            );
        }
    }
}