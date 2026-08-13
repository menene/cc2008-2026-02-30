import java.util.ArrayList;
import java.util.Random;

public class Entrenador {

    private String nombre;
    private Pokemon[] pokemones;

    public Entrenador(String nombre, Pokemon[] pokemones) {
        this.nombre = nombre;
        this.pokemones = pokemones;
    }

    public String getNombre() {
        return nombre;
    }

    public Pokemon[] getPokemones() {
        return pokemones;
    }

    public Pokemon seleccionarPokemonDisponible() {

        ArrayList<Pokemon> disponibles = new ArrayList<>();

        for (Pokemon pokemon : pokemones) {
            if (!pokemon.isHaPeleado()) {
                disponibles.add(pokemon);
            }
        }

        if (disponibles.isEmpty()) {
            return null;
        }

        Random random = new Random();

        Pokemon seleccionado =
            disponibles.get(random.nextInt(disponibles.size()));

        seleccionado.setHaPeleado(true);

        return seleccionado;
    }
}