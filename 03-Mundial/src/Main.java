public class Main {
    public static void main(String[] args) {
        SistemaVenta sistemaVenta =
                new SistemaVenta();

        VistaConsola vista =
                new VistaConsola();

        ControladorVenta controlador =
                new ControladorVenta(
                        sistemaVenta,
                        vista
                );

        controlador.iniciar();
    }
}