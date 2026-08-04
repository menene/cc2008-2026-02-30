public class ControladorVenta {

    private SistemaVenta sistema;
    private VistaConsola vista;
    private Comprador compradorActual;

    public ControladorVenta(){

        sistema = new SistemaVenta();
        vista = new VistaConsola();

    }
    public void iniciar(){
        
        vista.mostrarMenu();
        
    }
}