package Main;

import Controller.Controlador;
import Model.Combate;
import Model.Entrenador;
import Model.Pokedex;
import Model.Pokemon;
import View.Vista;

public class Main {

    public static void main(String[] args) {

        Pokedex pokedex = new Pokedex();

        Pokemon[] seleccionados =
                pokedex.seleccionarPokemonesAleatorios(8);

        Pokemon[] pokemonesA = new Pokemon[4];
        Pokemon[] pokemonesB = new Pokemon[4];

        for (int i = 0; i < 4; i++) {
            pokemonesA[i] = seleccionados[i];
            pokemonesB[i] = seleccionados[i + 4];
        }

        Entrenador entrenadorA =
                new Entrenador("Entrenador 1", pokemonesA);

        Entrenador entrenadorB =
                new Entrenador("Entrenador 2", pokemonesB);

        Combate combate =
                new Combate(entrenadorA, entrenadorB);

        Vista vista = new Vista();

        Controlador controlador =
                new Controlador();

        controlador.iniciarCombate(combate, vista);
    }
} 