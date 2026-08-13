public class Main {

    public static void main(String[] args) {

        Batalla batalla = new Batalla();

        VistaBatalla vista = new VistaBatalla();

        ControladorBatalla controlador =
                new ControladorBatalla(batalla, vista);

        controlador.iniciarBatalla();
    }
}