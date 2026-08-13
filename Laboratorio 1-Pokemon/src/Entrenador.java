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

    public Pokemon seleccionarPokemon() {
        Random random = new Random();

        int posicion;

        do {
            posicion = random.nextInt(pokemones.length);
        } while (pokemones[posicion].getHaPeleado());

        pokemones[posicion].setHaPeleado(true);

        return pokemones[posicion];
    }
}
