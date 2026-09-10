package model;

import java.util.ArrayList;
import java.util.List;

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
        List<Pokemon> disponibles = new ArrayList<>();
        for (Pokemon pokemon : pokemones) {
            if (!pokemon.isHaPeleado()) {
                disponibles.add(pokemon);
            }
        }
        int indice = (int) (Math.random() * disponibles.size());
        Pokemon seleccionado = disponibles.get(indice);
        seleccionado.setHaPeleado(true);
        return seleccionado;
    }
}
