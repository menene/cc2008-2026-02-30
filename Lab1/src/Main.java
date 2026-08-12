public class Main {
    public static void main(String[] args) {

        // Pokémon Disponibles
        Pokemon pokemon1 = new Pokemon("Charmander", "Fuego", 45, 30, new Habilidad("Llama Final", 30));
        Pokemon pokemon2 = new Pokemon("Squirtle", "Agua", 35, 45, new Habilidad("Escudo Natural", 40));
        Pokemon pokemon3 = new Pokemon("Bulbasaur", "Planta", 40, 40, new Habilidad("Impacto Relámpago", 20));
        Pokemon pokemon4 = new Pokemon("Pikachu", "Electrico", 50, 30, new Habilidad("Energia Elemental", 35));
        Pokemon pokemon5 = new Pokemon("Vulpix", "Fuego", 40, 35, new Habilidad("Fuego Supremo", 25));
        Pokemon pokemon6 = new Pokemon("Psyduck", "Agua", 40, 40, new Habilidad("Escudo Marino", 30));
        Pokemon pokemon7 = new Pokemon("Chikorita", "Planta", 35, 45, new Habilidad("Poder Natural", 40));
        Pokemon pokemon8 = new Pokemon("Voltorb", "Electrico", 45, 35, new Habilidad("Trueno Final", 25));

        Vista vista = new Vista();

        String nombreJugador1 = vista.pedirNombreJugador(1);
        String nombreJugador2 = vista.pedirNombreJugador(2);

        Jugador jugador1 = new Jugador(nombreJugador1);
        Jugador jugador2 = new Jugador(nombreJugador2);

        SistemaBatalla sistema = new SistemaBatalla(
                jugador1,
                jugador2);

        Controlador controlador = new Controlador(
                sistema,
                vista);

        controlador.iniciar(jugador1, jugador2, pokemon1, pokemon2, pokemon3, pokemon4, pokemon5, pokemon6, pokemon7,
                pokemon8);
    }
}
