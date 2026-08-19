public class VistaCombate {
    public void MostrarInicio() {
        System.out.println("================================");
        System.out.println("       LIGA ELEMENTAL");
        System.out.println("================================");
        System.out.println();
    }

    public void MostrarRonda(int ronda, Entrenador atacante, Entrenador defensor, Pokemon pokemonAtacante, Pokemon pokemonDefensor) {
        System.out.println("================================");
        System.out.println("            RONDA " + ronda);
        System.out.println("================================");

        System.out.println("Atacante: " + atacante.GetNombre());
        System.out.println("Pokemon: " + pokemonAtacante.GetNombre());
        System.out.println("Tipo: " + pokemonAtacante.GetTipo());
        System.out.println("Ataque base: " + pokemonAtacante.GetAtaque());

        System.out.println();

        System.out.println("Defensor: " + defensor.GetNombre());
        System.out.println("Pokemon: " + pokemonDefensor.GetNombre());
        System.out.println("Tipo: " + pokemonDefensor.GetTipo());
        System.out.println("Defensa base: " + pokemonDefensor.GetDefensa());

        System.out.println();
    }

    public void MostrarHabilidad(Pokemon pokemon, double potenciador) {
        System.out.println(pokemon.GetNombre() + " ha usado " + pokemon.GetHabilidad().GetNombre() + "!");
        System.out.println("Potenciador de " + (potenciador * 100) + "%");
        System.out.println();
    }

    public void MostrarEfectividad(int bono) {
        if (bono == 20) {
            System.out.println("Efectividad de tipo: EFECTIVO +20");
        } else if (bono == -10) {
            System.out.println("Efectividad de tipo: DEBIL (-10)");
        } else {
            System.out.println("Efectividad de tipo: NEUTRAL (0)");
        }
        System.out.println();
    }

    public void MostrarResultadoRonda(Entrenador ganador) {
        if (ganador == null) {
            System.out.println("La ronda termino en empate!");
        } else {
            System.out.println("Ganador de la ronda: " + ganador.GetNombre() + "!");
        }
        System.out.println();
    }

    public void MostrarResultadoFinal(Combate combate) {
        System.out.println("================================");
        System.out.println("        RESULTADO FINAL");
        System.out.println("================================");

        System.out.println(combate.GetEntrenador1().GetNombre() + ": " + combate.GetEntrenador1().GetVictorias() + " victorias");

        System.out.println(combate.GetEntrenador2().GetNombre() + ": " + combate.GetEntrenador2().GetVictorias() + " victorias");

        System.out.println();

        if (combate.GetEntrenador1().GetVictorias() > combate.GetEntrenador2().GetVictorias()) {
            System.out.println("GANADOR: " + combate.GetEntrenador1().GetNombre());

        } else if (combate.GetEntrenador2().GetVictorias() > combate.GetEntrenador1().GetVictorias()) {
            System.out.println("GANADOR: " + combate.GetEntrenador2().GetNombre());

        } else {
            System.out.println("LA BATALLA TERMINO EN EMPATE!");
        }
    }
}