import java.util.ArrayList;

public class Entrenador {

    private String nombre;
    private ArrayList<Pokemon> eleccion_pokemon;

    public Entrenador() {
        this.nombre = "";
        this.eleccion_pokemon = new ArrayList<>();
    }

    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.eleccion_pokemon = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Pokemon> getEleccion_pokemon() {
        return eleccion_pokemon;
    }

    public void agregarPokemon(Pokemon pokemon) {

        if (pokemon != null
                && eleccion_pokemon.size() < 4
                && !eleccion_pokemon.contains(pokemon)) {

            eleccion_pokemon.add(pokemon);
        }
    }
}