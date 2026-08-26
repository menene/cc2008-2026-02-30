public class Main {

    public static void main(String[] args) {
        SistemaOrden gestor = new SistemaOrden();
        VistaOrden vista = new VistaOrden(gestor);
        vista.iniciarMenu();
    }
}
