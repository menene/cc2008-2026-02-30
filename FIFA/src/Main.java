public class Main {
    public static void main(String[] args) {
        var vista = new VentasVista();
        var controlador = new VentasControlador(vista);
        controlador.iniciarSistema();
    }
}