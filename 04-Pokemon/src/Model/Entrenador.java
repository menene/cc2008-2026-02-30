package Model;

import java.util.Random;

public class Entrenador {

    private String nombreEntrenador;
    private Pokemon[] pokemones;

    public Entrenador(String nombreEntrenador, Pokemon[] pokemones) {
        this.nombreEntrenador = nombreEntrenador;
        this.pokemones = pokemones;
    }

    public String getNombreEntrenador() {
        return nombreEntrenador;
    }

    public Pokemon[] getPokemones() {
        return pokemones;
    }

    public Pokemon seleccionarPokemon() {

        Random random = new Random();
        Pokemon seleccionado;

        do {
            int indice = random.nextInt(pokemones.length);
            seleccionado = pokemones[indice];
        } while (seleccionado.isHaPeleado());

        seleccionado.setHaPeleado(true);

        return seleccionado;
    }
}