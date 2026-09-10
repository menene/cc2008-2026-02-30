public class Main {
    public static void main(String[] args) {
        VistaFestival vista = new VistaFestival();
        ControladorFestival controlador =
            new ControladorFestival(vista);
        controlador.iniciar();
    }
}