public class Controlador {

    private Combate combate;

    public void iniciarCombate() {
        Pokemon[] equipo1 = {
            new Pokemon("Charmander", "Fuego", 45, 30, new Habilidad("Llama Final", 30)),
            new Pokemon("Squirtle", "Agua", 40, 35, new Habilidad("Escudo Natural", 40)),
            new Pokemon("Bulbasaur", "Planta", 42, 32, new Habilidad("Latigo Cepa", 25)),
            new Pokemon("Pikachu", "Electrico", 50, 25, new Habilidad("Impacto Relampago", 20))
        };

        Pokemon[] equipo2 = {
            new Pokemon("Vulpix", "Fuego", 38, 28, new Habilidad("Ascuas", 35)),
            new Pokemon("Psyduck", "Agua", 35, 38, new Habilidad("Confusion", 30)),
            new Pokemon("Oddish", "Planta", 40, 34, new Habilidad("Somnifero", 28)),
            new Pokemon("Magnemite", "Electrico", 44, 30, new Habilidad("Chispazo", 22))
        };

        Entrenador jugador1 = new Entrenador("David", equipo1);
        Entrenador jugador2 = new Entrenador("Rival", equipo2);

        combate = new Combate(jugador1, jugador2);
        combate.jugarBatalla();
    }


    // Imprime en consola el detalle de cada ronda
    public void mostrarResultados() {
        for (ResultadoRonda resultado : combate.getResultados()) {
            System.out.println("Ronda " + resultado.getNumeroRonda() + ":");
            System.out.println("  Atacante: " + resultado.getPokemonAtacante().getNombre());
            System.out.println("  Defensor: " + resultado.getPokemonDefensor().getNombre());
            System.out.println("  Ataque total: " + resultado.getAtaqueTotal());
            System.out.println("  Gano la ronda: " + resultado.getGanadorRonda());
            System.out.println();
        }

        System.out.println("Ganador de la batalla: " + combate.determinarGanadorBatalla());
    }
}