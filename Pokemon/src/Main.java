public class Main {
    public static void main(String[] args) {

        Habilidad habilidad1 = new Habilidad(30, "Fuego");
        Habilidad habilidad2 = new Habilidad(30, "Agua");
        Habilidad habilidad3 = new Habilidad(30, "Planta");
        Habilidad habilidad4 = new Habilidad(30, "Electrico");

    // POKEMON JUGADOR 1
        Pokemon pokemon1 = new Pokemon(
                "Raichu",
                habilidad4,
                90,
                55,
                "Electrico"
        );    

        Pokemon pokemon2 = new Pokemon(
                "Jolteon",
                habilidad4,
                110,
                95,
                "Electrico"
        );    

        Pokemon pokemon3 = new Pokemon(
                "Zapdos",
                habilidad4,
                120,
                125,
                "Electrico"
        );

        Pokemon pokemon4 = new Pokemon(
                "Electrode",
                habilidad4,
                80,
                80,
                "Electrico"
        );

        Entrenador jugador1 =
                new Entrenador("Andrés", pokemon1, pokemon2, pokemon3, pokemon4);

    // POKEMON JUGADOR 2
        Pokemon pokemon5 = new Pokemon(
                "Charizard",
                habilidad1,
                109,
                85,
                "Fuego"
        );

        Pokemon pokemon6 = new Pokemon(
                "Lapras",
                habilidad2,
                85,
                95,
                "Agua"
        );

        Pokemon pokemon7 = new Pokemon(
                "Venusaur",
                habilidad3,
                100,
                115,
                "Planta"
        );

        Pokemon pokemon8 = new Pokemon(
                "Seadra",
                habilidad2,
                95,
                95,
                "Agua"
        );

        Entrenador jugador2 =
                new Entrenador("Erik", pokemon5, pokemon6, pokemon7, pokemon8);

        Batalla batalla = new Batalla(jugador1, jugador2);
        Vista vista = new Vista();

        Controlador controlador = new Controlador(
                batalla,
                vista   
        );

        controlador.iniciar();
    }
}