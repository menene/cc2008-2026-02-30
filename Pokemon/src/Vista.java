import java.util.Scanner;

public class Vista {

    private Scanner scanner;

    public Vista() {
        scanner = new Scanner(System.in);
    }


    public String pedirNombreJugador(int numeroJugador) {

        System.out.print("Ingrese el nombre del jugador "
                + numeroJugador + ": ");

        return scanner.nextLine();
    }

    public void mostrarRonda(int ronda,
                             Entrenador atacante,
                             Pokemon pokemonAtacante,
                             Entrenador defensor,
                             Pokemon pokemonDefensor,
                             Entrenador ganador) {

        System.out.println();
        System.out.println("===== RONDA " + ronda + " =====");

        System.out.println(
                atacante.getNombre()
                + " ataca con "
                + pokemonAtacante.getNombre()
        );

        System.out.println(
                defensor.getNombre()
                + " defiende con "
                + pokemonDefensor.getNombre()
        );

        if (ganador == null) {

            System.out.println(
                    "La ronda termina en empate"
            );

        } else {

            System.out.println(
                    "Ganador de la ronda: "
                    + ganador.getNombre()
            );
        }
    }

    

    public void mostrarResultadoFinal(String ganador) {

        System.out.println();
        System.out.println("===== RESULTADO FINAL =====");

        if (ganador.equalsIgnoreCase("Empate")) {

            System.out.println(
                    "La batalla termina en empate"
            );

        } else {

            System.out.println(
                    "Ganador de la batalla: "
                    + ganador
            );
        }
    }

    public void mostrarHabilidades(Pokemon atacante,
                               Pokemon defensor,
                               Batalla batalla) {

        if (batalla.getHabilidadAtaqueActivada()) {

            System.out.println(
                    atacante.getNombre()
                    + " activo "
                    + atacante.getHabilidad().getNombreATK()
                    + " (+"
                    + batalla.getPotenciadorAtaque()
                    + "% de ataque)"
            );
        }

        if (batalla.getHabilidadDefensaActivada()) {

            System.out.println(
                    defensor.getNombre()
                    + " activo "
                    + defensor.getHabilidad().getNombreDFS()
                    + " (+"
                    + batalla.getPotenciadorDefensa()
                    + "% de defensa)"
            );
        }
    }
}