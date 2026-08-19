package pokemonbattle;

import java.util.ArrayList;
import java.util.Random;

/**
 * Representa a un entrenador con su equipo de 4 Pokémon y su marcador
 * de rondas ganadas durante la batalla.
 */
public class Entrenador {

    private String nombre;
    private ArrayList<Pokemon> pokemones;
    private int rondasGanadas;
    private static final Random RANDOM = new Random();

    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.pokemones = new ArrayList<>();
        this.rondasGanadas = 0;
    }

    public void agregarPokemon(Pokemon pokemon) {
        pokemones.add(pokemon);
    }

    /**
     * Selecciona al azar uno de los Pokémon del entrenador que todavia
     * no haya peleado en la batalla.
     */
    public Pokemon seleccionarPokemonAleatorio() {
        ArrayList<Pokemon> disponibles = new ArrayList<>();
        for (Pokemon p : pokemones) {
            if (!p.haPeleado()) {
                disponibles.add(p);
            }
        }
        if (disponibles.isEmpty()) {
            return null;
        }
        int indice = RANDOM.nextInt(disponibles.size());
        return disponibles.get(indice);
    }

    public void incrementarRondasGanadas() {
        rondasGanadas++;
    }

    public int getRondasGanadas() {
        return rondasGanadas;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Pokemon> getPokemones() {
        return pokemones;
    }
}
