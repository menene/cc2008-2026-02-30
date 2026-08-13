import java.util.Random;

public class Entrenador {

    private String nombre;
    private Pokemon[] pokemones;

    private static final Random random = new Random();

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

    //Elige al azar uno de los Pokemones del entrenador que todavia aún no haya peleado
    public Pokemon seleccionarPokemonAleatorio() {
        Pokemon seleccionado;
        do {
            int indice = random.nextInt(pokemones.length);
            seleccionado = pokemones[indice];
        } while (seleccionado.isHaPeleado());
        return seleccionado;
    }
}