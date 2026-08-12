public class Main {

    public static void main(String[] args) {

        HabilidadesEspeciales flamadeira =
                new HabilidadesEspeciales("flamadeira", 30);

        HabilidadesEspeciales curalluvia =
                new HabilidadesEspeciales("curalluvia", 40);

        HabilidadesEspeciales espesura =
                new HabilidadesEspeciales("espesura", 20);

        HabilidadesEspeciales pararrayos =
                new HabilidadesEspeciales("pararrayos", 20);

        HabilidadesEspeciales velopastel =
                new HabilidadesEspeciales("velopastel", 30);

        HabilidadesEspeciales nadorapido =
                new HabilidadesEspeciales("nadorapido", 40);

        HabilidadesEspeciales fuga =
                new HabilidadesEspeciales("fuga", 20);

        HabilidadesEspeciales iman =
                new HabilidadesEspeciales("iman", 30);

        Pokemon charmander =
                new Pokemon(
                        "Charmander",
                        "Fuego",
                        40,
                        30,
                        flamadeira
                );

        Pokemon squirtle =
                new Pokemon(
                        "Squirtle",
                        "Agua",
                        35,
                        40,
                        curalluvia
                );

        Pokemon bulbasaur =
                new Pokemon(
                        "Bulbasaur",
                        "Planta",
                        30,
                        45,
                        espesura
                );

        Pokemon pikachu =
                new Pokemon(
                        "Pikachu",
                        "Eléctrico",
                        45,
                        30,
                        pararrayos
                );

        Pokemon ponyta =
                new Pokemon(
                        "Ponyta",
                        "Fuego",
                        35,
                        35,
                        velopastel
                );

        Pokemon psyduck =
                new Pokemon(
                        "Psyduck",
                        "Agua",
                        40,
                        35,
                        nadorapido
                );

        Pokemon oddish =
                new Pokemon(
                        "Oddish",
                        "Planta",
                        30,
                        40,
                        fuga
                );

        Pokemon magnemite =
                new Pokemon(
                        "Magnemite",
                        "Eléctrico",
                        45,
                        35,
                        iman
                );

        Entrenador entrenador1 =
                new Entrenador("Entrenador 1");

        Entrenador entrenador2 =
                new Entrenador("Entrenador 2");

        entrenador1.agregarPokemon(charmander);
        entrenador1.agregarPokemon(squirtle);
        entrenador1.agregarPokemon(bulbasaur);
        entrenador1.agregarPokemon(pikachu);

        entrenador2.agregarPokemon(ponyta);
        entrenador2.agregarPokemon(psyduck);
        entrenador2.agregarPokemon(oddish);
        entrenador2.agregarPokemon(magnemite);

        Combate combate =
                new Combate(entrenador1, entrenador2);
        combate.iniciarCombate();
    }
}