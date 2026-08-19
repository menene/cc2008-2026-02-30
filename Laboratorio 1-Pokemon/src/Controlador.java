public class Controlador {

    private Batalla batalla;
    private Vista vista;

    public Controlador(Batalla batalla, Vista vista) {
        this.batalla = batalla;
        this.vista = vista;
    }

    public void iniciarBatalla() {

        vista.mostrarInicioBatalla();

        for (int ronda = 1; ronda <= 4; ronda++) {

            vista.mostrarRonda(ronda);

            int resultado;

            // Rondas 1 y 3
            if (ronda % 2 != 0) {

                Entrenador atacante = batalla.getEntrenador1();
                Entrenador defensor = batalla.getEntrenador2();

                vista.mostrarRoles(atacante, defensor);

                resultado = batalla.realizarRonda(
                        atacante,
                        defensor
                );

                if (resultado == 1) {
                    vista.mostrarResultadoRonda(
                            atacante.getNombre() + " gana la ronda"
                    );

                } else if (resultado == 2) {
                    vista.mostrarResultadoRonda(
                            defensor.getNombre() + " gana la ronda"
                    );

                } else {
                    vista.mostrarResultadoRonda("Empate");
                }

            // Rondas 2 y 4
            } else {

                Entrenador atacante = batalla.getEntrenador2();
                Entrenador defensor = batalla.getEntrenador1();

                vista.mostrarRoles(atacante, defensor);

                resultado = batalla.realizarRonda(
                        atacante,
                        defensor
                );

                if (resultado == 1) {
                    vista.mostrarResultadoRonda(
                            atacante.getNombre() + " gana la ronda"
                    );

                } else if (resultado == 2) {
                    vista.mostrarResultadoRonda(
                            defensor.getNombre() + " gana la ronda"
                    );

                } else {
                    vista.mostrarResultadoRonda("Empate");
                }
            }

            vista.mostrarMarcador(
                    batalla.getVictoriasEntrenador1(),
                    batalla.getVictoriasEntrenador2()
            );
        }

        String ganador = batalla.determinarGanador();

        vista.mostrarResultadoFinal(ganador);
    }
}