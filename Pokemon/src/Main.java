public class Main {

    public static void main(String[] args) {

        // Habilidades del entrenador 1
        HabilidadEspecial habilidad1 =
                new HabilidadEspecial("Intimidación", 30);

        HabilidadEspecial habilidad2 =
                new HabilidadEspecial("Herbívoro", 30);

        HabilidadEspecial habilidad3 =
                new HabilidadEspecial("Caparazón", 30);

        HabilidadEspecial habilidad4 =
                new HabilidadEspecial("Canto", 30);


        // Habilidades del entrenador 2
        HabilidadEspecial habilidad5 =
                new HabilidadEspecial("Absorbe Fuego", 30);

        HabilidadEspecial habilidad6 =
                new HabilidadEspecial("Humedad", 30);

        HabilidadEspecial habilidad7 =
                new HabilidadEspecial("Clorofila", 30);

        HabilidadEspecial habilidad8 =
                new HabilidadEspecial("Electro Motor", 30);


        // Pokemon del entrenador 1
        Pokemon pokemon1 =
                new Pokemon("Luxray", "Electrico", 85, 75, habilidad1);

        Pokemon pokemon2 =
                new Pokemon("Gogoat", "Planta", 70, 60, habilidad2);

        Pokemon pokemon3 =
                new Pokemon("Samurott", "Agua", 80, 70, habilidad3);

        Pokemon pokemon4 =
                new Pokemon("Jigglypuff", "Agua", 50, 25, habilidad4);


        // Pokemon del entrenador 2
        Pokemon pokemon5 =
                new Pokemon("Vulpix", "Fuego", 50, 40, habilidad5);

        Pokemon pokemon6 =
                new Pokemon("Psyduck", "Agua", 60, 50, habilidad6);

        Pokemon pokemon7 =
                new Pokemon("Leafeon", "Planta", 80, 85, habilidad7);

        Pokemon pokemon8 =
                new Pokemon("Electivire", "Electrico", 90, 70, habilidad8);


        // Equipos
        Pokemon[] equipo1 = {
                pokemon1,
                pokemon2,
                pokemon3,
                pokemon4
        };

        Pokemon[] equipo2 = {
                pokemon5,
                pokemon6,
                pokemon7,
                pokemon8
        };


        // Entrenadores
        Entrenador entrenador1 =
                new Entrenador("Jugador 1", equipo1);

        Entrenador entrenador2 =
                new Entrenador("Jugador 2", equipo2);


        // Crear e iniciar batalla
        Batalla batalla =
                new Batalla(entrenador1, entrenador2);

        batalla.iniciarBatalla();
    }
}