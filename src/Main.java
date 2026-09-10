public class Main {

    public static void main(String[] args) {
        Vista vista = new Vista();
        Controlador controlador = new Controlador(vista);

        try {
            controlador.iniciar();
        } 
        finally {
            vista.cerrarScanner();
            System.out.println("Programa finalizado.");
        }
    }
}