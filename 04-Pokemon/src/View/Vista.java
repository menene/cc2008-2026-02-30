package View;

import Model.Combate;
import Model.Ronda;

public class Vista {

    public void mostrarInicioCombate(Combate combate) {

        System.out.println("===== INICIO DEL COMBATE =====");

        System.out.println(
                combate.getEntrenadorA().getNombreEntrenador()
                + " vs "
                + combate.getEntrenadorB().getNombreEntrenador()
        );
    }

    public void mostrarInicioRonda(Ronda ronda) {

        System.out.println();

        System.out.println(
                "===== RONDA "
                + ronda.getNumeroRonda()
                + " ====="
        );

        System.out.println(
                "Atacante: "
                + ronda.getAtacante().getNombreEntrenador()
        );

        System.out.println(
                "Defensor: "
                + ronda.getDefensor().getNombreEntrenador()
        );
    }

    public void mostrarPokemonSeleccionados(Ronda ronda) {

        System.out.println(
                "Pokemon atacante: "
                + ronda.getPokemonAtacante().getNombre()
        );

        System.out.println(
                "Pokemon defensor: "
                + ronda.getPokemonDefensor().getNombre()
        );
    }

    public void mostrarResultadoRonda(
            int resultado,
            Ronda ronda) {

        if (resultado == 1) {

            System.out.println(
                    "Ganador de la ronda: "
                    + ronda.getAtacante().getNombreEntrenador()
            );

        } else if (resultado == -1) {

            System.out.println(
                    "Ganador de la ronda: "
                    + ronda.getDefensor().getNombreEntrenador()
            );

        } else {

            System.out.println(
                    "La ronda termino en empate."
            );
        }
    }

    public void mostrarResultadoFinal(Combate combate) {

        System.out.println();
        System.out.println("===== RESULTADO FINAL =====");

        System.out.println(
                combate.getEntrenadorA().getNombreEntrenador()
                + ": "
                + combate.getVictoriasA()
                + " victorias"
        );

        System.out.println(
                combate.getEntrenadorB().getNombreEntrenador()
                + ": "
                + combate.getVictoriasB()
                + " victorias"
        );

        String ganador = combate.determinarGanador();

        if (ganador.equals("Empate")) {

            System.out.println(
                    "El combate termino empatado."
            );

        } else {

            System.out.println(
                    "Ganador del combate: "
                    + ganador
            );
        }
    }
} 