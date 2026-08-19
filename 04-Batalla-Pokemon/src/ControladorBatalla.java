public class ControladorBatalla {

    // Atributos
    private Batalla batalla;
    private VistaBatalla vista;

    // Constructor
    public ControladorBatalla(Batalla batalla, VistaBatalla vista) {
        this.batalla = batalla;
        this.vista = vista;
    }

    // Coordina el desarrollo completo de la batalla
    public void iniciarBatalla() {

        // Mostrar inicio
        vista.mostrarInicio();

        // Ejecutar las 4 rondas
        for (int i = 1; i <= 4; i++) {

            batalla.ejecutarRonda(i);

            vista.mostrarRonda(
                    i,
                    batalla.getRonda(i)
            );
        }

        // Determinar ganador final
        String ganador = batalla.determinarGanador();

        // Mostrar ganador final
        vista.mostrarGanador(ganador);
    }
}