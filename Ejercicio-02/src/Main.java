public class Main {

    public static void main(String[] args) {
        Torneo torneo = new Torneo();
        VistaTorneo vista = new VistaTorneo();
        ControladorTorneo controlador = new ControladorTorneo(torneo, vista);

        controlador.iniciar();
    }
}