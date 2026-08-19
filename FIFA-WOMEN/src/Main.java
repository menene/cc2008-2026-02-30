public class Main {
    public static void main(String[] args) {
        SistemaBoletos sistema = new SistemaBoletos();
       
        Vista vista = new Vista();
       
        Controlador controlador = new Controlador(sistema, vista);
       
        controlador.iniciar();
    }
}
