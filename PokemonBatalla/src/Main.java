import java.util.Random;

public class Main {

    public static void main(String[] args) {
    Pokemon pokemon1 = crearPokemon("Charmander", "Fuego", 82, 65, 110, "Llamarada crítica", 30);
    Pokemon pokemon2 = crearPokemon("Squirtle", "Agua", 78, 72, 115, "Ola curativa", 35);
    Pokemon pokemon3 = crearPokemon("Bulbasaur", "Planta", 74, 70, 108, "Raices firmes", 28);
    Pokemon pokemon4 = crearPokemon("Pikachu", "Eléctrico", 80, 60, 102, "Descarga veloz", 32);
    Pokemon pokemon5 = crearPokemon("Charmeleon", "Fuego", 79, 68, 112, "Ascuas furiosas", 29);
    Pokemon pokemon6 = crearPokemon("Wartortle", "Agua", 76, 74, 116, "Burbuja protectora", 34);
    Pokemon pokemon7 = crearPokemon("Ivysaur", "Planta", 77, 69, 109, "Espinas vivas", 27);
    Pokemon pokemon8 = crearPokemon("Raichu", "Eléctrico", 83, 63, 105, "Chispa relampago", 31);

    Entrenador entrenador1 = new Entrenador();
    entrenador1.setNombre("Entrenador Rojo");

    Entrenador entrenador2 = new Entrenador();
    entrenador2.setNombre("Entrenadora Azul");

        asignarPokemonAleatorio(pokemon1, entrenador1, entrenador2);
        asignarPokemonAleatorio(pokemon2, entrenador1, entrenador2);
        asignarPokemonAleatorio(pokemon3, entrenador1, entrenador2);
        asignarPokemonAleatorio(pokemon4, entrenador1, entrenador2);
        asignarPokemonAleatorio(pokemon5, entrenador1, entrenador2);
        asignarPokemonAleatorio(pokemon6, entrenador1, entrenador2);
        asignarPokemonAleatorio(pokemon7, entrenador1, entrenador2);
        asignarPokemonAleatorio(pokemon8, entrenador1, entrenador2);

        System.out.println("\nEquipo de " + entrenador1.getNombre() + ":");
        mostrarEquipo(entrenador1);

        System.out.println("\nEquipo de " + entrenador2.getNombre() + ":");
        mostrarEquipo(entrenador2);

        CombateView combateView = new CombateView();
        CombateController combateController = new CombateController(
                entrenador1,
                entrenador2,
                combateView);

        combateController.iniciarBatalla();
    }

    private static Pokemon crearPokemon(
            String nombre,
            String tipo,
            int ataque,
            int defensa,
            int vida,
            String habilidad,
            int probabilidadEspecial) {

        Pokemon pokemon = new Pokemon(nombre, tipo, ataque, defensa, vida);
        pokemon.setHabilidadEspecial(new HabilidadEspecial(habilidad, probabilidadEspecial));
        return pokemon;
    }

    private static void asignarPokemonAleatorio(
            Pokemon pokemon,
            Entrenador entrenador1,
            Entrenador entrenador2) {

        if (new Random().nextBoolean()) {
            if (tieneEspacio(entrenador1)) {
                agregarPokemon(entrenador1, pokemon);
            } else {
                agregarPokemon(entrenador2, pokemon);
            }
        } else {
            if (tieneEspacio(entrenador2)) {
                agregarPokemon(entrenador2, pokemon);
            } else {
                agregarPokemon(entrenador1, pokemon);
            }
        }
    }

    private static boolean tieneEspacio(Entrenador entrenador) {
        return entrenador.getPokemon1() == null
                || entrenador.getPokemon2() == null
                || entrenador.getPokemon3() == null
                || entrenador.getPokemon4() == null;
    }

    private static void agregarPokemon(Entrenador entrenador, Pokemon pokemon) {
        if (entrenador.getPokemon1() == null) {
            entrenador.setPokemon1(pokemon);
            return;
        }

        if (entrenador.getPokemon2() == null) {
            entrenador.setPokemon2(pokemon);
            return;
        }

        if (entrenador.getPokemon3() == null) {
            entrenador.setPokemon3(pokemon);
            return;
        }

        entrenador.setPokemon4(pokemon);
    }

    private static void mostrarEquipo(Entrenador entrenador) {
        mostrarPokemon(entrenador.getPokemon1());
        mostrarPokemon(entrenador.getPokemon2());
        mostrarPokemon(entrenador.getPokemon3());
        mostrarPokemon(entrenador.getPokemon4());
    }

    private static void mostrarPokemon(Pokemon pokemon) {
        System.out.println("- " + pokemon.getName()
                + " | Tipo: " + pokemon.getTipo()
                + " | Vida: " + pokemon.getVida()
                + " | Ataque: " + pokemon.getAtaque()
                + " | Defensa: " + pokemon.getDefensa()
                + " | Habilidad: " + pokemon.getHabilidadEspecial().getNombre()
                + " (" + pokemon.getHabilidadEspecial().getProbabilidadEspecial() + "%)");
    }
}