public class Main {

    public static void main(String[] args) {

        GestorOrdenes gestor = new GestorOrdenes();
        TallerVista vista = new TallerVista();

        TallerControlador controlador = new TallerControlador(gestor, vista);

        controlador.iniciar();
    }
}