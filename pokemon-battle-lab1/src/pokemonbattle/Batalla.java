package pokemonbattle;

import java.util.Random;


public class Batalla {

    private Entrenador jugador1;
    private Entrenador jugador2;
    private int rondaActual;
    private boolean jugador1Ataca;
    private static final Random RANDOM = new Random();

    public Batalla(Entrenador jugador1, Entrenador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.rondaActual = 0;
        this.jugador1Ataca = true; // Ronda 1: Jugador 1 ataca
    }

    public void iniciarBatalla() {
        System.out.println("=== ¡Comienza la batalla entre " + jugador1.getNombre()
                + " y " + jugador2.getNombre() + "! ===\n");

        for (rondaActual = 1; rondaActual <= 4; rondaActual++) {
            Entrenador atacante = jugador1Ataca ? jugador1 : jugador2;
            Entrenador defensor = jugador1Ataca ? jugador2 : jugador1;

            System.out.println("--- Ronda " + rondaActual + " ---");
            System.out.println(atacante.getNombre() + " ataca, " + defensor.getNombre() + " defiende.");

            ejecutarRonda(atacante, defensor);

            jugador1Ataca = !jugador1Ataca; // se alternan los roles
            System.out.println();
        }

        mostrarResultadoFinal();
    }


    private void ejecutarRonda(Entrenador atacante, Entrenador defensor) {
        Pokemon pokemonAtacante = atacante.seleccionarPokemonAleatorio();
        Pokemon pokemonDefensor = defensor.seleccionarPokemonAleatorio();

        System.out.println(atacante.getNombre() + " envía a " + pokemonAtacante.getNombre());
        System.out.println(defensor.getNombre() + " envía a " + pokemonDefensor.getNombre());

        int potenciadorAtaque = 0;
        if (pokemonAtacante.getHabilidad().intentarActivacion()) {
            potenciadorAtaque = pokemonAtacante.getHabilidad().generarPotenciador();
            System.out.println(pokemonAtacante.getNombre() + " activó " + pokemonAtacante.getHabilidad().getNombre()
                    + " (+" + potenciadorAtaque + "% ataque)");
        }

        int potenciadorDefensa = 0;
        if (pokemonDefensor.getHabilidad().intentarActivacion()) {
            potenciadorDefensa = pokemonDefensor.getHabilidad().generarPotenciador();
            System.out.println(pokemonDefensor.getNombre() + " activó " + pokemonDefensor.getHabilidad().getNombre()
                    + " (+" + potenciadorDefensa + "% defensa)");
        }

        double ataqueEfectivo = calcularAtaqueEfectivo(pokemonAtacante, potenciadorAtaque);
        double defensaEfectiva = calcularDefensaEfectiva(pokemonDefensor, potenciadorDefensa);
        int bonoTipo = calcularEfectividadTipo(pokemonAtacante.getTipo(), pokemonDefensor.getTipo());

        double ataqueTotal = ataqueEfectivo + bonoTipo - defensaEfectiva;

        System.out.printf("Ataque efectivo: %.2f | Bono de tipo: %d | Defensa efectiva: %.2f%n",
                ataqueEfectivo, bonoTipo, defensaEfectiva);
        System.out.printf("Resultado de la ronda (ataqueTotal): %.2f%n", ataqueTotal);

        Entrenador ganadorRonda = determinarGanadorRonda(ataqueTotal, atacante, defensor);
        if (ganadorRonda == null) {
            System.out.println("¡La ronda terminó en empate!");
        } else {
            System.out.println(ganadorRonda.getNombre() + " gana la ronda " + rondaActual + "!");
            ganadorRonda.incrementarRondasGanadas();
        }

        pokemonAtacante.marcarComoUsado();
        pokemonDefensor.marcarComoUsado();
    }

    private double calcularAtaqueEfectivo(Pokemon pokemon, int potenciador) {
        return pokemon.getAtaque() + (pokemon.getAtaque() * potenciador / 100.0);
    }

    private double calcularDefensaEfectiva(Pokemon pokemon, int potenciador) {
        return pokemon.getDefensa() + (pokemon.getDefensa() * potenciador / 100.0);
    }

    private int calcularEfectividadTipo(TipoPokemon atacante, TipoPokemon defensor) {
        if (atacante == defensor) {
            return 0;
        }
        switch (atacante) {
            case FUEGO:
                if (defensor == TipoPokemon.AGUA) return -10;
                if (defensor == TipoPokemon.PLANTA) return 20;
                return 0;
            case AGUA:
                if (defensor == TipoPokemon.FUEGO) return 20;
                if (defensor == TipoPokemon.PLANTA) return -10;
                return 0;
            case PLANTA:
                if (defensor == TipoPokemon.FUEGO) return -10;
                if (defensor == TipoPokemon.AGUA) return 20;
                return 0;
            case ELECTRICO:
                if (defensor == TipoPokemon.AGUA) return 20;
                return 0;
            default:
                return 0;
        }
    }


    private Entrenador determinarGanadorRonda(double ataqueTotal, Entrenador atacante, Entrenador defensor) {
        if (ataqueTotal > 0) {
            return atacante;
        } else if (ataqueTotal < 0) {
            return defensor;
        }
        return null;
    }


    private void mostrarResultadoFinal() {
        System.out.println("=== Resultado final ===");
        System.out.println(jugador1.getNombre() + ": " + jugador1.getRondasGanadas() + " rondas ganadas");
        System.out.println(jugador2.getNombre() + ": " + jugador2.getRondasGanadas() + " rondas ganadas");

        if (jugador1.getRondasGanadas() > jugador2.getRondasGanadas()) {
            System.out.println("¡" + jugador1.getNombre() + " es el campeón de la Liga Elemental!");
        } else if (jugador2.getRondasGanadas() > jugador1.getRondasGanadas()) {
            System.out.println("¡" + jugador2.getNombre() + " es el campeón de la Liga Elemental!");
        } else {
            System.out.println("¡La batalla terminó empatada!");
        }
    }
}
