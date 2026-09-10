public class Main {

    //Main unicamente inicia el sistema, creando una instancia de VistaFestival y ControladorFestival, y llamando al método iniciar() del controlador para comenzar la ejecución del programa.
    public static void main(String[] args) {

        VistaFestival vista = new VistaFestival();

        try {
            ControladorFestival controlador = new ControladorFestival(vista);

            controlador.iniciar();

        } finally {
            // Cierra el Scanner al finalizar la ejecución del programa para liberar recursos.
            vista.cerrar();
        }
    }
}