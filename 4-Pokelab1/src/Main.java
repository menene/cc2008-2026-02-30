import java.util.Random;

/**
 * Crea las habilidades, los 8 Pokemon, realiza la asignacion aleatoria
 * 4 y 4 entre Jugador y NPC, crea los demas objetos e inicia el programa.
 */
public class Main {

    public static void main(String[] args) {

        // Habilidades especiales (nombre, probabilidad de activacion)
        HabilidadEspecial llamaFinal = new HabilidadEspecial("Llama Final", 30);
        HabilidadEspecial escudoNatural = new HabilidadEspecial("Escudo Natural", 30);
        HabilidadEspecial impactoRelampago = new HabilidadEspecial("Impacto Relampago", 30);
        HabilidadEspecial hojaCortante = new HabilidadEspecial("Hoja Cortante", 30);
        HabilidadEspecial olaDeCalor = new HabilidadEspecial("Ola de Calor", 30);
        HabilidadEspecial corazaDeHielo = new HabilidadEspecial("Coraza de Hielo", 30);
        HabilidadEspecial rugidoElectrico = new HabilidadEspecial("Rugido Electrico", 30);
        HabilidadEspecial raicesProfundas = new HabilidadEspecial("Raices Profundas", 30);

        // Los 8 Pokemon (nombre, tipo, ataque, defensa, habilidad)
        Pokemon[] todosLosPokemon = new Pokemon[8];
        todosLosPokemon[0] = new Pokemon("Charmeleon", "Fuego", 45, 30, llamaFinal);
        todosLosPokemon[1] = new Pokemon("Blastoise", "Agua", 40, 45, escudoNatural);
        todosLosPokemon[2] = new Pokemon("Raichu", "Electrico", 50, 25, impactoRelampago);
        todosLosPokemon[3] = new Pokemon("Venusaur", "Planta", 42, 38, hojaCortante);
        todosLosPokemon[4] = new Pokemon("Arcanine", "Fuego", 48, 32, olaDeCalor);
        todosLosPokemon[5] = new Pokemon("Gyarados", "Agua", 44, 40, corazaDeHielo);
        todosLosPokemon[6] = new Pokemon("Jolteon", "Electrico", 46, 28, rugidoElectrico);
        todosLosPokemon[7] = new Pokemon("Sceptile", "Planta", 41, 36, raicesProfundas);

        mezclarPokemones(todosLosPokemon);

        // Entrenadores
        Entrenador jugador = new Entrenador("ASH");
        Entrenador npc = new Entrenador("NPC");

        // Asignacion aleatoria: los primeros 4 para el jugador, los ultimos 4 para el NPC
        jugador.asignarPokemones(todosLosPokemon[0], todosLosPokemon[1], todosLosPokemon[2], todosLosPokemon[3]);
        npc.asignarPokemones(todosLosPokemon[4], todosLosPokemon[5], todosLosPokemon[6], todosLosPokemon[7]);

        // Modelo, vista y controlador
        Batalla batalla = new Batalla(jugador, npc);
        Vista vista = new Vista();
        Controlador controlador = new Controlador(batalla, vista);

        controlador.iniciarJuego();
    }

    /**
     * Mezcla aleatoriamente el arreglo de 8 Pokemon (algoritmo Fisher-Yates)
     * para repartir 4 y 4 de forma aleatoria entre los dos entrenadores.
     */
    private static void mezclarPokemones(Pokemon[] pokemones) {
        Random random = new Random();
        for (int i = pokemones.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Pokemon temporal = pokemones[i];
            pokemones[i] = pokemones[j];
            pokemones[j] = temporal;
        }
    }
}
