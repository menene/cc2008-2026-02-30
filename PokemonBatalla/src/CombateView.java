public class CombateView {

    public CombateView() {
    }

    public void mostrarInicioBatalla() {
        System.out.println("\n=================================");
        System.out.println("       INICIO DE LA BATALLA");
        System.out.println("=================================");
    }

    public void mostrarRonda(int numeroRonda) {
        System.out.println("\n=================================");
        System.out.println("            RONDA " + numeroRonda);
        System.out.println("=================================");
    }

    public void mostrarEnfrentamiento(Pokemon atacante, Pokemon defensor) {
        System.out.println("\nPokemon atacante:");
        System.out.println("Nombre: " + atacante.getName());
        System.out.println("Tipo: " + atacante.getTipo());
        System.out.println("Vida: " + atacante.getVida());
        System.out.println("Ataque: " + atacante.getAtaque());
        System.out.println("Defensa: " + atacante.getDefensa());

        System.out.println("\nPokemon defensor:");
        System.out.println("Nombre: " + defensor.getName());
        System.out.println("Tipo: " + defensor.getTipo());
        System.out.println("Vida: " + defensor.getVida());
        System.out.println("Ataque: " + defensor.getAtaque());
        System.out.println("Defensa: " + defensor.getDefensa());
    }

    public void mostrarHabilidad(
            Pokemon pokemon,
            boolean activada,
            int potenciador) {

        System.out.println("\nHabilidad de " + pokemon.getName() + ": "
                + pokemon.getHabilidadEspecial().getNombre());

        if (activada) {
            System.out.println("La habilidad se activo.");
            System.out.println("Potenciador obtenido: " + potenciador + "%");
        } else {
            System.out.println("La habilidad no se activo.");
        }
    }

    public void mostrarCalculos(
            int ataqueEfectivo,
            int defensaEfectiva,
            int efectividadTipo,
            int ataqueTotal) {

        System.out.println("\n--- Calculos de la ronda ---");
        System.out.println("Ataque efectivo: " + ataqueEfectivo);
        System.out.println("Defensa efectiva: " + defensaEfectiva);
        System.out.println("Bono de efectividad de tipo: " + efectividadTipo);
        System.out.println("Ataque total: " + ataqueTotal);
    }

    public void mostrarResultadoRonda(
            int resultado,
            Pokemon atacante,
            Pokemon defensor) {

        if (resultado == 1) {
            System.out.println("\nGanador de la ronda: " + atacante.getName());
        } else if (resultado == -1) {
            System.out.println("\nGanador de la ronda: " + defensor.getName());
        } else {
            System.out.println("\nLa ronda termino en empate.");
        }
    }

    public void mostrarGanadorBatalla(
            int resultado,
            String entrenador1,
            String entrenador2,
            int victorias1,
            int victorias2) {

        System.out.println("\n=================================");
        System.out.println("       RESULTADO DE BATALLA");
        System.out.println("=================================");

        System.out.println(entrenador1 + ": " + victorias1 + " rondas ganadas");
        System.out.println(entrenador2 + ": " + victorias2 + " rondas ganadas");

        if (resultado == 1) {
            System.out.println("\nGanador final: " + entrenador1);
        } else if (resultado == 2) {
            System.out.println("\nGanador final: " + entrenador2);
        } else {
            System.out.println("\nLa batalla termino en empate.");
        }
    }
}