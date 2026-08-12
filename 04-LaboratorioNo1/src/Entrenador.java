import java.util.Random;

public class Entrenador {

    private String nombre;
    private Pokemon[] equipo;
    private int rondasGanadas;

    public Entrenador(String nombre, Pokemon[] equipo) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.rondasGanadas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public Pokemon[] getEquipo() {
        return equipo;
    }

    public int getRondasGanadas() {
        return rondasGanadas;
    }

    public Pokemon seleccionarPokemonAleatorio() {

        Random random = new Random();

        Pokemon pokemonSeleccionado;

        do {

            int posicion = random.nextInt(equipo.length);

            pokemonSeleccionado = equipo[posicion];

        } while (pokemonSeleccionado.estaUsado());

        pokemonSeleccionado.marcarComoUsado();

        return pokemonSeleccionado;
    }

    public void sumarVictoria() {
        rondasGanadas++;
    }
}