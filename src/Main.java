public class Main {

    public static void main(String[] args) {
        GestorOrdenes gestor = new GestorOrdenes();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(gestor, vista);

        controlador.iniciar();
    }
}
