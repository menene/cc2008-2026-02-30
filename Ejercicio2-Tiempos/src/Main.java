public class Main {
    //metodo principal que crea los objetos necesarios e inicia el programa
    public static void main(String[] args) {
        //la vista se encarga de la entrada y salida de datos
        VistaCarrera vista = new VistaCarrera();

        //el controlador coordina la vista con el atleta activo
        ControladorCarrera controlador = new ControladorCarrera(vista);
        controlador.iniciar();
    }
}