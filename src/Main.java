public class Main {
    public static void main(String[] args) {
        VistaFestival vista = new VistaFestival();
        ControladorFestival controlador = new ControladorFestival(vista);

        try {
            controlador.iniciar();
        } finally {
            controlador.cerrarRecursos();
        }
    }
}
