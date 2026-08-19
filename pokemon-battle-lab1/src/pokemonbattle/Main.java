package pokemonbattle;


public class Main {
    public static void main(String[] args) {
        PokemonService pokemonService = new PokemonService();

        Entrenador jugador1 = new Entrenador("Ash");
        Entrenador jugador2 = new Entrenador("Gary");

        pokemonService.asignarEquipoAleatorio(jugador1);
        pokemonService.asignarEquipoAleatorio(jugador2);

        System.out.println("Equipo de " + jugador1.getNombre() + ": " + jugador1.getPokemones());
        System.out.println("Equipo de " + jugador2.getNombre() + ": " + jugador2.getPokemones());
        System.out.println();

        Batalla batalla = new Batalla(jugador1, jugador2);
        batalla.iniciarBatalla();
    }
}
