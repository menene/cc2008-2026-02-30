package modelo;

import java.util.Random;

// Guarda a un entrenador con su equipo de 4 Pokemon y sus rondas ganadas.
public class Entrenador {

    private String nombre;
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Pokemon pokemon3;
    private Pokemon pokemon4;
    private int rondasGanadas;

    public Entrenador(String nombre, Pokemon pokemon1, Pokemon pokemon2, Pokemon pokemon3, Pokemon pokemon4) {
        this.nombre = nombre;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.pokemon3 = pokemon3;
        this.pokemon4 = pokemon4;
        this.rondasGanadas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getRondasGanadas() {
        return rondasGanadas;
    }

    public void sumarRondaGanada() {
        this.rondasGanadas = this.rondasGanadas + 1;
    }

    // Escoge al azar un Pokemon que no haya peleado y lo marca como usado.
    public Pokemon seleccionarPokemonAleatorio(Random aleatorio) {
        // Si ya pelearon todos no hay nada que devolver.
        if (!tienePokemonDisponible()) {
            return null;
        }

        Pokemon elegido = null;

        // Sortea un numero del 1 al 4 hasta que salga uno que no haya peleado.
        while (elegido == null) {
            int indice = aleatorio.nextInt(4) + 1;
            Pokemon candidato = obtenerPokemonPorIndice(indice);
            if (candidato != null && !candidato.getYaPeleo()) {
                elegido = candidato;
            }
        }

        elegido.marcarComoPeleado();
        return elegido;
    }

    // Devuelve el Pokemon del equipo segun el numero que se le pida.
    private Pokemon obtenerPokemonPorIndice(int indice) {
        if (indice == 1) {
            return pokemon1;
        }
        if (indice == 2) {
            return pokemon2;
        }
        if (indice == 3) {
            return pokemon3;
        }
        if (indice == 4) {
            return pokemon4;
        }
        return null;
    }

    // Dice si al entrenador le queda al menos un Pokemon sin pelear.
    public boolean tienePokemonDisponible() {
        for (int i = 1; i <= 4; i++) {
            Pokemon actual = obtenerPokemonPorIndice(i);
            if (actual != null && !actual.getYaPeleo()) {
                return true;
            }
        }
        return false;
    }
}
