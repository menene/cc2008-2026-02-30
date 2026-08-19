public class Controlador {

    private Vista vista;
    private Batalla modelo;

    public Controlador(Vista vista, Batalla modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    public void setVista(Vista vista) {
        this.vista = vista;
    }

    public void setModelo(Batalla modelo) {
        this.modelo = modelo;
    }

    public void iniciarJuego() {
        vista.mostrarEntrenadores(modelo.getJugador1(), modelo.getJugador2());
        vista.mostrarInicioBatalla();
        modelo.iniciarBatalla();
    }
}