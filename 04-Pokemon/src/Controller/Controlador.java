package Controller;

import Model.Combate;
import Model.Entrenador;
import Model.Ronda;
import View.Vista;

public class Controlador {

    public void iniciarCombate(
            Combate combate,
            Vista vista) {

        vista.mostrarInicioCombate(combate);

        for (int numeroRonda = 1;
             numeroRonda <= 4;
             numeroRonda++) {

            Entrenador atacante;
            Entrenador defensor;

            if (numeroRonda % 2 != 0) {

                atacante = combate.getEntrenadorA();
                defensor = combate.getEntrenadorB();

            } else {

                atacante = combate.getEntrenadorB();
                defensor = combate.getEntrenadorA();
            }

            Ronda ronda =
                    crearRonda(
                            numeroRonda,
                            atacante,
                            defensor);

            combate.getRondas()[numeroRonda - 1] = ronda;

            vista.mostrarInicioRonda(ronda);

            int resultado = ronda.ejecutarRonda();

            vista.mostrarPokemonSeleccionados(ronda);

            procesarResultado(
                    resultado,
                    combate,
                    ronda);

            vista.mostrarResultadoRonda(
                    resultado,
                    ronda);
        }

        vista.mostrarResultadoFinal(combate);
    }

    private Ronda crearRonda(
            int numeroRonda,
            Entrenador atacante,
            Entrenador defensor) {

        return new Ronda(
                numeroRonda,
                atacante,
                defensor);
    }

    private void procesarResultado(
            int resultado,
            Combate combate,
            Ronda ronda) {

        if (resultado == 1) {

            if (ronda.getAtacante()
                    == combate.getEntrenadorA()) {

                combate.registrarVictoriaA();

            } else {

                combate.registrarVictoriaB();
            }

        } else if (resultado == -1) {

            if (ronda.getDefensor()
                    == combate.getEntrenadorA()) {

                combate.registrarVictoriaA();

            } else {

                combate.registrarVictoriaB();
            }
        }
    }
}