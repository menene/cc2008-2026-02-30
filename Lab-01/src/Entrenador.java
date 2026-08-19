import java.util.ArrayList;
import java.util.Random;

public class Entrenador {
    
    private String nombre;
    private ArrayList<Pokemon> pokemones;

    public Entrenador(String nombre, ArrayList<Pokemon> pokemones) {
        this.nombre = nombre;
        this.pokemones = pokemones;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Pokemon> getPokemones() {
        return pokemones;
    }

    public Pokemon seleccionPokemon() {
        Random random = new Random();

        int indice = random.nextInt(pokemones.size());

        return pokemones.remove(indice); 
    }
}