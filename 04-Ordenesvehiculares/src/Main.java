public class Main{
    public static void main(String[] args){
        Taller taller = new Taller();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(taller,vista);

        controlador.iniciar();

    }
}