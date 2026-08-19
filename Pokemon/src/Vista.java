import java.util.ArrayList;

public class Vista {

    public Vista() {

    }


    public void mostrarMenuPokemon(ArrayList<Pokemon> pokemones) {

        System.out.println("     POKEMON DISPONIBLES");
        System.out.println("============================");

        for (int i = 0; i < pokemones.size(); i++) {

            Pokemon pokemon = pokemones.get(i);

            System.out.println(
                    (i + 1) + ". " + pokemon.getNombre());

            System.out.println(
                    "   Tipo: " + pokemon.getTipo());

            System.out.println(
                    "   Ataque: " + pokemon.getAtaque());

            System.out.println(
                    "   Defensa: " + pokemon.getDefensa());

            System.out.println(
                    "   Habilidad: " + pokemon.getHabilidad());

            System.out.println(
                    "   Probabilidad: "
                    + pokemon.getProbabilidadHabilidad()
                    + "%");

            System.out.println();
        }
    }


    public void mostrarEntrenador(Entrenador entrenador) {

        System.out.println("============================");
        System.out.println(
                "Entrenador: " + entrenador.getNombre());

        System.out.println("Pokemon:");

        for (Pokemon pokemon :
                entrenador.getEleccion_pokemon()) {

            System.out.println(
                    "- " + pokemon.getNombre()
                    + " (" + pokemon.getTipo() + ")");
        }

        System.out.println();
    }


    public void mostrarInicioBatalla(
            Entrenador entrenador1,
            Entrenador entrenador2) {

        System.out.println("============================");
        System.out.println("      INICIO DE BATALLA");

        System.out.println(
                entrenador1.getNombre()
                + " VS "
                + entrenador2.getNombre());

        System.out.println();
    }


    public void mostrarRonda(
            int numeroRonda,
            Entrenador atacante,
            Entrenador defensor,
            Ronda ronda) {

        System.out.println("============================");
        System.out.println("Ronda " + numeroRonda);

        System.out.println(
                "Ataca: " + atacante.getNombre());

        System.out.println(
                "Pokemon: "
                + ronda.getPokemonAtaque().getNombre());

        System.out.println(
                "Ataque efectivo: "
                + ronda.getCantidadAtaque());

        System.out.println(
                "Bono de tipo: "
                + ronda.getBonoTipo());

        System.out.println();

        System.out.println(
                "Defiende: " + defensor.getNombre());

        System.out.println(
                "Pokemon: "
                + ronda.getPokemonDefensa().getNombre());

        System.out.println(
                "Defensa efectiva: "
                + ronda.getCantidadDefensa());

        System.out.println();

        System.out.println(
                "Resultado numerico: "
                + ronda.getResultado());

        System.out.println(
                "Ganador de ronda: "
                + ronda.getGanadorRonda());

        System.out.println();
    }


    public void mostrarBatalla(
            String ganador_perdedor) {

        System.out.println("============================");
        System.out.println("       FIN DE BATALLA");

        if (ganador_perdedor.equals("Empate")) {

            System.out.println(
                    "La batalla termino en empate.");

        } else {

            System.out.println(
                    "Ganador: "
                    + ganador_perdedor);
        }

        System.out.println("============================");
    }


    public void mostrarMarcador(
            Entrenador entrenador1,
            int victorias1,
            Entrenador entrenador2,
            int victorias2) {

        System.out.println("Marcador final:");

        System.out.println(
                entrenador1.getNombre()
                + ": "
                + victorias1);

        System.out.println(
                entrenador2.getNombre()
                + ": "
                + victorias2);

        System.out.println();
    }
}