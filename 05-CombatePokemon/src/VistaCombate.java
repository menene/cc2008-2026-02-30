public class VistaCombate {

    // Muestra los Pokemon de un entrenador
    public void mostrarPokemones(Entrenador entrenador) {

        System.out.println("Pokemon de " + entrenador.getNombre() + ":");

        System.out.println("1. " + entrenador.getPokemon1().getNombre());
        System.out.println("2. " + entrenador.getPokemon2().getNombre());
        System.out.println("3. " + entrenador.getPokemon3().getNombre());
        System.out.println("4. " + entrenador.getPokemon4().getNombre());
    }


    // Muestra el inicio del combate
    public void mostrarInicioCombate(Entrenador entrenador1,
                                     Entrenador entrenador2) {

        System.out.println("================================");
        System.out.println("       BATALLA POKEMON");
        System.out.println("================================");

        System.out.println(
            entrenador1.getNombre()
            + " VS "
            + entrenador2.getNombre()
        );

        System.out.println();
    }


    // Muestra los Pokemon que participan en una ronda
    public void mostrarRonda(int ronda, Pokemon atacante,
                             Pokemon defensor) {

        System.out.println("================================");
        System.out.println("Ronda " + ronda);
        System.out.println("================================");

        System.out.println(
            "Atacante: " + atacante.getNombre()
        );

        System.out.println(
            "Defensor: " + defensor.getNombre()
        );
    }


    // Muestra la activacion de una habilidad especial
    public void mostrarHabilidadEspecial(Pokemon pokemon,
                                         int potenciador) {

        System.out.println(
            pokemon.getNombre()
            + " activo "
            + pokemon.getHabilidadEspecial().getNombre()
        );

        System.out.println(
            "Potenciador: +" + potenciador + "%"
        );
    }


    // Muestra el ganador de una ronda
    public void mostrarGanadorRonda(String nombre) {

        System.out.println(
            "Ganador de la ronda: " + nombre
        );

        System.out.println();
    }


    // Muestra un empate en una ronda
    public void mostrarEmpateRonda() {

        System.out.println("La ronda termino en empate.");
        System.out.println();
    }


    // Muestra el ganador final
    public void mostrarGanadorFinal(String nombre) {

        System.out.println("================================");
        System.out.println("       FIN DEL COMBATE");
        System.out.println("================================");

        System.out.println(
            "Ganador del combate: " + nombre
        );
    }


    // Muestra un empate final
    public void mostrarEmpateFinal() {

        System.out.println("================================");
        System.out.println("       FIN DEL COMBATE");
        System.out.println("================================");

        System.out.println(
            "El combate termino en empate."
        );
    }
}