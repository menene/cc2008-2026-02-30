import java.util.Random;

/**
 * Representa a un entrenador (Jugador o NPC) con sus 4 Pokemon
 * y la cantidad de rondas que ha ganado en la batalla.
 */
public class Entrenador {

    private String nombre;
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Pokemon pokemon3;
    private Pokemon pokemon4;
    private int rondasGanadas;

    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.rondasGanadas = 0;
    }

    public void asignarPokemones(Pokemon pokemon1, Pokemon pokemon2, Pokemon pokemon3, Pokemon pokemon4) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.pokemon3 = pokemon3;
        this.pokemon4 = pokemon4;
    }

    /**
     * Selecciona al azar uno de los 4 Pokemon del entrenador que todavia
     * no haya participado en una ronda y lo marca como utilizado.
     */
    public Pokemon seleccionarPokemon() {
        Pokemon[] pokemones = {pokemon1, pokemon2, pokemon3, pokemon4};
        Random random = new Random();
        Pokemon seleccionado;

        do {
            int indice = random.nextInt(4);
            seleccionado = pokemones[indice];
        } while (seleccionado.isUtilizado());

        seleccionado.setUtilizado(true);
        return seleccionado;
    }

    public void sumarRondaGanada() {
        rondasGanadas++;
    }

    public int getRondasGanadas() {
        return rondasGanadas;
    }

    public String getNombre() {
        return nombre;
    }
}
