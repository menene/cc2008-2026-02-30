public class Main {
    public static void main(String[] args) {
        GestionOrdenes gestionOrdenes = new GestionOrdenes();
        OrdenView vista = new OrdenView();
        OrdenController controlador = new OrdenController(gestionOrdenes, vista);

        controlador.iniciar();
    }
}