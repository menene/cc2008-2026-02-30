package main;
 
import controller.GestorCombate;
import model.Entrenador;
import model.Pokemon;
import model.Pokemon.TipoPokemon;
import model.Ronda;
import view.Menu;
 
public class Main {
 
    public static void main(String[] args) {
 
        // ---- Pokemon del Entrenador 1 ----
        Pokemon charizardito = new Pokemon("Charizardito", TipoPokemon.FUEGO, 45, 30, "Llama Final", 30);
        Pokemon tortuguix = new Pokemon("Tortuguix", TipoPokemon.AGUA, 38, 42, "Escudo Natural", 40);
        Pokemon hojarin = new Pokemon("Hojarin", TipoPokemon.PLANTA, 40, 35, "Espinas Filosas", 25);
        Pokemon voltix = new Pokemon("Voltix", TipoPokemon.ELECTRICO, 42, 28, "Impacto Relampago", 20);
 
        Pokemon[] pokemonesEntrenador1 = { charizardito, tortuguix, hojarin, voltix };
        Entrenador entrenador1 = new Entrenador("Ash", pokemonesEntrenador1);
 
        // ---- Pokemon del Entrenador 2 ----
        Pokemon flamitar = new Pokemon("Flamitar", TipoPokemon.FUEGO, 40, 32, "Furia Ardiente", 35);
        Pokemon acualix = new Pokemon("Acualix", TipoPokemon.AGUA, 36, 40, "Ola Protectora", 30);
        Pokemon florania = new Pokemon("Florania", TipoPokemon.PLANTA, 44, 30, "Enredadera Veloz", 28);
        Pokemon chispix = new Pokemon("Chispix", TipoPokemon.ELECTRICO, 39, 33, "Chispa Certera", 22);
 
        Pokemon[] pokemonesEntrenador2 = { flamitar, acualix, florania, chispix };
        Entrenador entrenador2 = new Entrenador("Misty", pokemonesEntrenador2);
 
        // ---- Combate ----
        GestorCombate gestorCombate = new GestorCombate(entrenador1, entrenador2);
        gestorCombate.iniciarCombate();
 
        // ---- Mostrar resultados ----
        Menu menu = new Menu();
        for (Ronda ronda : gestorCombate.getRondas()) {
            menu.mostrarResultadoRonda(ronda);
        }
        menu.mostrarResultadoFinal(gestorCombate.obtenerGanadorCombate());
    }
}
