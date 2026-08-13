public class VistaBatalla {
    public void mostrarPokemones(Pokemon[] pokemones) {
         System.out.println("Pokemons del entrenador:");

         //recorro la lista y muestro pokemon por pokemon
        for (Pokemon pokemon : pokemones) {
            System.out.println("- " + pokemon.getNombre());
        }
        
    }
    // Mostrar resultados y rondas
    public void mostrarEstadoRonda(int rondaActual, Pokemon atacante, Pokemon defensor, double resultado) {

        System.out.println("\n--- Ronda " + rondaActual + " ---");
        System.out.println("Atacante: " + atacante.getNombre());
        System.out.println("Defensor: " + defensor.getNombre());
        System.out.println("Resultado: " + resultado);
    }

    public void mostrarResultadoFinal(String ganador, int rondasGanadas1, int rondasGanadas2) {

        System.out.println("\n--- Resultado Final ---");
        System.out.println("Jugador 1: " + rondasGanadas1 + " rondas ganadas");
        System.out.println("Jugador 2: " + rondasGanadas2 + " rondas ganadas");
        System.out.println("Ganador: " + ganador);
    }


}
