import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Entrenador {

    private String nombre;
    private Pokemon[] pokemones;
    private int rondasGanadas;

    public Entrenador() {
    }

    public Entrenador(String nombre, Pokemon[] pokemones) {
        this.nombre = nombre;
        this.pokemones = pokemones;
        this.rondasGanadas = 0;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPokemones(Pokemon[] pokemones) {
        this.pokemones = pokemones;
    }

    public Pokemon[] getPokemones() {
        return pokemones;
    }

    public void setRondasGanadas(int rondasGanadas) {
        this.rondasGanadas = rondasGanadas;
    }

    public int getRondasGanadas() {
        return rondasGanadas;
    }

    public void incrementarRondasGanadas() {
        this.rondasGanadas++;
    }

    public Pokemon seleccionarPokemon() {
        List<Pokemon> disponibles = new ArrayList<>();
        for (Pokemon p : pokemones) {
            if (!p.getHaPeleado()) {
                disponibles.add(p);
            }
        }

        if (disponibles.isEmpty()) {
            return null;
        }

        Random random = new Random();
        Pokemon seleccionado = disponibles.get(random.nextInt(disponibles.size()));
        seleccionado.setHaPeleado(true);
        return seleccionado;
    }
}