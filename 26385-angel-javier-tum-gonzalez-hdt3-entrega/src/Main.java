public class Main {
    public static void main(String[] args) {
        GestorOrdenes modelo = new GestorOrdenes();
        VistaTaller vista = new VistaTaller();
        ControladorTaller controlador = new ControladorTaller(modelo, vista);
        controlador.iniciar();
    }
}
