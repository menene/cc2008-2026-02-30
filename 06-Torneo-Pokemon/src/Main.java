public class Main {

    public static void main(String[] args) {

        Pokemon[] equipo1 = {
            new Pokemon(
                "Charizard",
                TipoPokemon.FUEGO,
                45,
                30,
                "Llama Final",
                30
            ),

            new Pokemon(
                "Squirtle",
                TipoPokemon.AGUA,
                35,
                40,
                "Escudo Natural",
                40
            ),

            new Pokemon(
                "Bulbasaur",
                TipoPokemon.PLANTA,
                38,
                35,
                "Escudo Natural",
                40
            ),

            new Pokemon(
                "Pikachu",
                TipoPokemon.ELECTRICO,
                42,
                30,
                "Impacto Relampago",
                20
            )
        };

        Pokemon[] equipo2 = {
            new Pokemon(
                "Charmander",
                TipoPokemon.FUEGO,
                40,
                32,
                "Llama Final",
                30
            ),

            new Pokemon(
                "Blastoise",
                TipoPokemon.AGUA,
                38,
                45,
                "Escudo Natural",
                40
            ),

            new Pokemon(
                "Treecko",
                TipoPokemon.PLANTA,
                40,
                33,
                "Escudo Natural",
                40
            ),

            new Pokemon(
                "Electabuzz",
                TipoPokemon.ELECTRICO,
                44,
                31,
                "Impacto Relampago",
                20
            )
        };

        Entrenador entrenador1 =
            new Entrenador("Jugador 1", equipo1);

        Entrenador entrenador2 =
            new Entrenador("Jugador 2", equipo2);

        GestorCombate gestor =
            new GestorCombate(entrenador1, entrenador2);

        Menu menu = new Menu();

        gestor.iniciarCombate();

        for (Ronda ronda : gestor.getRondas()) {
            menu.mostrarResultadoRonda(ronda);
        }

        String ganador = gestor.obtenerGanadorCombate();

        menu.mostrarResultadoFinal(ganador);
    }
}