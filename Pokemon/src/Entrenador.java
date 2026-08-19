import java.util.ArrayList;
import java.util.List;

public class Entrenador {

    private String nombre;
    private List<Pokemon> pokemones;

    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.pokemones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pokemon> getPokemones() {
        return pokemones;
    }

    public void agregarPokemon(Pokemon pokemon) {
        pokemones.add(pokemon);
    }
}