package pokemonbattle;

import java.util.ArrayList;
import java.util.Collections;


public class PokemonService {

    private ArrayList<Pokemon> pokemonesDisponibles;

    public PokemonService() {
        pokemonesDisponibles = new ArrayList<>();
        cargarPokemones();
    }


    public void cargarPokemones() {
        pokemonesDisponibles.add(new Pokemon("Charmander", TipoPokemon.FUEGO, 45, 35,
                new HabilidadEspecial("Llama Final", 30)));
        pokemonesDisponibles.add(new Pokemon("Growlithe", TipoPokemon.FUEGO, 50, 32,
                new HabilidadEspecial("Furia Ardiente", 25)));
        pokemonesDisponibles.add(new Pokemon("Vulpix", TipoPokemon.FUEGO, 41, 40,
                new HabilidadEspecial("Cola Incendio", 35)));

        pokemonesDisponibles.add(new Pokemon("Squirtle", TipoPokemon.AGUA, 42, 45,
                new HabilidadEspecial("Escudo Natural", 40)));
        pokemonesDisponibles.add(new Pokemon("Psyduck", TipoPokemon.AGUA, 38, 39,
                new HabilidadEspecial("Onda Confusa", 30)));
        pokemonesDisponibles.add(new Pokemon("Totodile", TipoPokemon.AGUA, 47, 41,
                new HabilidadEspecial("Mordida Feroz", 28)));

        pokemonesDisponibles.add(new Pokemon("Bulbasaur", TipoPokemon.PLANTA, 40, 46,
                new HabilidadEspecial("Latigo Cepa", 32)));
        pokemonesDisponibles.add(new Pokemon("Oddish", TipoPokemon.PLANTA, 37, 42,
                new HabilidadEspecial("Polen Toxico", 27)));
        pokemonesDisponibles.add(new Pokemon("Bellsprout", TipoPokemon.PLANTA, 43, 33,
                new HabilidadEspecial("Hojas Navaja", 33)));

        pokemonesDisponibles.add(new Pokemon("Pikachu", TipoPokemon.ELECTRICO, 46, 34,
                new HabilidadEspecial("Impacto Relampago", 20)));
        pokemonesDisponibles.add(new Pokemon("Magnemite", TipoPokemon.ELECTRICO, 39, 44,
                new HabilidadEspecial("Campo Magnetico", 24)));
        pokemonesDisponibles.add(new Pokemon("Voltorb", TipoPokemon.ELECTRICO, 44, 30,
                new HabilidadEspecial("Sobrecarga", 38)));
    }


    public void asignarEquipoAleatorio(Entrenador entrenador) {
        Collections.shuffle(pokemonesDisponibles);
        int cantidad = Math.min(4, pokemonesDisponibles.size());
        for (int i = 0; i < cantidad; i++) {
            Pokemon seleccionado = pokemonesDisponibles.remove(0);
            entrenador.agregarPokemon(seleccionado);
        }
    }
}
