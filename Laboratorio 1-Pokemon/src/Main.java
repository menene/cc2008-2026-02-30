public class Main {

    public static void main(String[] args) {


        HabilidadEspecial habilidad1 =
                new HabilidadEspecial("Llama Final", 30);

        HabilidadEspecial habilidad2 =
                new HabilidadEspecial("Escudo Natural", 40);

        HabilidadEspecial habilidad3 =
                new HabilidadEspecial("Impacto Relampago", 20);

        HabilidadEspecial habilidad4 =
                new HabilidadEspecial("Fuerza Natural", 35);

        Pokemon pokemon1 =
                new Pokemon(
                        "Charmander",
                        "Fuego",
                        40,
                        30,
                        habilidad1
                );

        Pokemon pokemon2 =
                new Pokemon(
                        "Squirtle",
                        "Agua",
                        35,
                        45,
                        habilidad2
                );

        Pokemon pokemon3 =
                new Pokemon(
                        "Pikachu",
                        "Electrico",
                        45,
                        30,
                        habilidad3
                );

        Pokemon pokemon4 =
                new Pokemon(
                        "Bulbasaur",
                        "Planta",
                        35,
                        40,
                        habilidad4
                );

        Pokemon[] equipo1 = {
                pokemon1,
                pokemon2,
                pokemon3,
                pokemon4
        };

        Entrenador entrenador1 =
                new Entrenador("Jugador 1", equipo1);

        HabilidadEspecial habilidad5 =
                new HabilidadEspecial("Llama Poderosa", 30);

        HabilidadEspecial habilidad6 =
                new HabilidadEspecial("Defensa Marina", 40);

        HabilidadEspecial habilidad7 =
                new HabilidadEspecial("Rayo Veloz", 20);

        HabilidadEspecial habilidad8 =
                new HabilidadEspecial("Poder Verde", 35);

        Pokemon pokemon5 =
                new Pokemon(
                        "Vulpix",
                        "Fuego",
                        38,
                        32,
                        habilidad5
                );

        Pokemon pokemon6 =
                new Pokemon(
                        "Psyduck",
                        "Agua",
                        37,
                        40,
                        habilidad6
                );

        Pokemon pokemon7 =
                new Pokemon(
                        "Oddish",
                        "Planta",
                        34,
                        42,
                        habilidad7
                );

        Pokemon pokemon8 =
                new Pokemon(
                        "Voltorb",
                        "Electrico",
                        44,
                        31,
                        habilidad8
                );

        Pokemon[] equipo2 = {
                pokemon5,
                pokemon6,
                pokemon7,
                pokemon8
        };

        Entrenador entrenador2 =
                new Entrenador("Jugador 2", equipo2);

        Batalla batalla =
                new Batalla(entrenador1, entrenador2);

        Vista vista = new Vista();

        Controlador controlador =
                new Controlador(batalla, vista);

        controlador.iniciarBatalla();
    }
}
