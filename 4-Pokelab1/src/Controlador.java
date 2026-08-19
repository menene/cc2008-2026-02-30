public class Controlador {

    private Batalla batalla;
    private Vista vista;

    public Controlador(Batalla batalla, Vista vista) {
        this.batalla = batalla;
        this.vista = vista;
    }


    public void iniciarJuego() {
        vista.mostrarInicio();

        Entrenador jugador = batalla.getJugador();
        Entrenador npc = batalla.getNpc();
        boolean turnoJugador = true;

        while (batalla.getRondaActual() <= 4) {
            vista.mostrarRonda(batalla.getRondaActual());

            if (turnoJugador) {
                ejecutarRonda(jugador, npc);
            } else {
                ejecutarRonda(npc, jugador);
            }

            turnoJugador = !turnoJugador;
            batalla.avanzarRonda();
        }

        String resultadoFinal = determinarGanadorFinal();
        vista.mostrarResultadoFinal(resultadoFinal);
    }


    private void ejecutarRonda(Entrenador atacante, Entrenador defensor) {
        Pokemon pokemonAtacante = atacante.seleccionarPokemon();
        Pokemon pokemonDefensor = defensor.seleccionarPokemon();
        vista.mostrarEnfrentamiento(pokemonAtacante, pokemonDefensor);

        boolean activaAtacante = pokemonAtacante.getHabilidad().activarHabilidad();
        int potenciadorAtacante = activaAtacante ? pokemonAtacante.getHabilidad().generarPotenciador() : 0;
        vista.mostrarHabilidad(pokemonAtacante, activaAtacante, potenciadorAtacante);

        boolean activaDefensor = pokemonDefensor.getHabilidad().activarHabilidad();
        int potenciadorDefensor = activaDefensor ? pokemonDefensor.getHabilidad().generarPotenciador() : 0;
        vista.mostrarHabilidad(pokemonDefensor, activaDefensor, potenciadorDefensor);

        double ataqueEfectivo = batalla.calcularAtaqueEfectivo(pokemonAtacante, potenciadorAtacante);
        double defensaEfectiva = batalla.calcularDefensaEfectiva(pokemonDefensor, potenciadorDefensor);
        int bonoTipo = batalla.calcularEfectividadTipo(pokemonAtacante.getTipo(), pokemonDefensor.getTipo());
        double resultado = batalla.calcularResultadoRonda(ataqueEfectivo, bonoTipo, defensaEfectiva);

        String textoResultado;
        if (resultado > 0) {
            atacante.sumarRondaGanada();
            textoResultado = "Gana la ronda " + atacante.getNombre() + " (resultado: " + resultado + ")";
        } else if (resultado < 0) {
            defensor.sumarRondaGanada();
            textoResultado = "Gana la ronda " + defensor.getNombre() + " (resultado: " + resultado + ")";
        } else {
            textoResultado = "La ronda termina en empate (resultado: " + resultado + ")";
        }

        vista.mostrarResultadoRonda(textoResultado);
    }


    private String determinarGanadorFinal() {
        Entrenador jugador = batalla.getJugador();
        Entrenador npc = batalla.getNpc();

        if (jugador.getRondasGanadas() > npc.getRondasGanadas()) {
            return jugador.getNombre() + " gana la batalla (" + jugador.getRondasGanadas()
                    + " - " + npc.getRondasGanadas() + ")";
        } else if (npc.getRondasGanadas() > jugador.getRondasGanadas()) {
            return npc.getNombre() + " gana la batalla (" + npc.getRondasGanadas()
                    + " - " + jugador.getRondasGanadas() + ")";
        } else {
            return "La batalla termina EMPATADA (" + jugador.getRondasGanadas()
                    + " - " + npc.getRondasGanadas() + ")";
        }
    }
}
