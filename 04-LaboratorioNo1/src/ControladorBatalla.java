public class ControladorBatalla {

    private Entrenador jugador1;
    private Entrenador jugador2;
    private VistaBatalla vista;
    private int rondaActual;

    public ControladorBatalla(Entrenador jugador1,
                              Entrenador jugador2,
                              VistaBatalla vista) {

        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.vista = vista;
        this.rondaActual = 1;
    }

    public void iniciarBatalla() {

        vista.mostrarMensaje("=================================");
        vista.mostrarMensaje("        LIGA ELEMENTAL");
        vista.mostrarMensaje("=================================");
        vista.mostrarMensaje("");

        for (rondaActual = 1; rondaActual <= 4; rondaActual++) {

            vista.mostrarMensaje("---------- RONDA " + rondaActual + " ----------");

            if (rondaActual % 2 != 0) {

                jugarRonda(jugador1, jugador2);

            } else {

                jugarRonda(jugador2, jugador1);
            }

            vista.mostrarMensaje("");
        }

        mostrarResultadoFinal();
    }

    private void jugarRonda(Entrenador atacante, Entrenador defensor) {

        Pokemon pokemonAtacante = atacante.seleccionarPokemonAleatorio();
        Pokemon pokemonDefensor = defensor.seleccionarPokemonAleatorio();

        vista.mostrarMensaje(
                atacante.getNombre()
                + " ataca con "
                + pokemonAtacante.getNombre()
        );

        vista.mostrarMensaje(
                defensor.getNombre()
                + " defiende con "
                + pokemonDefensor.getNombre()
        );

        vista.mostrarMensaje("");

        int potenciadorAtaque = 0;
        int potenciadorDefensa = 0;

        // Habilidad del atacante

        if (pokemonAtacante.getHabilidadEspecial().seActiva()) {

            potenciadorAtaque =
                    pokemonAtacante.getHabilidadEspecial().generarPotenciador();

            vista.mostrarMensaje(
                    "¡Se activó "
                    + pokemonAtacante.getHabilidadEspecial().getNombre()
                    + "!"
            );

            vista.mostrarMensaje(
                    "Potenciador de ataque: "
                    + potenciadorAtaque
                    + "%"
            );

        } else {

            vista.mostrarMensaje(
                    pokemonAtacante.getHabilidadEspecial().getNombre()
                    + " no se activó."
            );
        }


        // Habilidad del defensor

        if (pokemonDefensor.getHabilidadEspecial().seActiva()) {

            potenciadorDefensa =
                    pokemonDefensor.getHabilidadEspecial().generarPotenciador();

            vista.mostrarMensaje(
                    "¡Se activó "
                    + pokemonDefensor.getHabilidadEspecial().getNombre()
                    + "!"
            );

            vista.mostrarMensaje(
                    "Potenciador de defensa: "
                    + potenciadorDefensa
                    + "%"
            );

        } else {

            vista.mostrarMensaje(
                    pokemonDefensor.getHabilidadEspecial().getNombre()
                    + " no se activó."
            );
        }

        double ataqueEfectivo =
                pokemonAtacante.calcularAtaqueEfectivo(potenciadorAtaque);

        double defensaEfectiva =
                pokemonDefensor.calcularDefensaEfectiva(potenciadorDefensa);

        int bonoTipo =
                calcularBonoTipo(pokemonAtacante, pokemonDefensor);

        double ataqueTotal =
                ataqueEfectivo + bonoTipo - defensaEfectiva;

        vista.mostrarMensaje("");
        vista.mostrarMensaje("Ataque efectivo: " + ataqueEfectivo);
        vista.mostrarMensaje("Defensa efectiva: " + defensaEfectiva);
        vista.mostrarMensaje("Bono de tipo: " + bonoTipo);
        vista.mostrarMensaje("Ataque total: " + ataqueTotal);

        resolverRonda(ataqueTotal, atacante, defensor);
    }

    private int calcularBonoTipo(Pokemon atacante, Pokemon defensor) {

        String tipoAtacante = atacante.getTipo();
        String tipoDefensor = defensor.getTipo();

        // FUEGO

        if (tipoAtacante.equalsIgnoreCase("Fuego")) {

            if (tipoDefensor.equalsIgnoreCase("Agua")) {
                return -10;
            }

            if (tipoDefensor.equalsIgnoreCase("Planta")) {
                return 20;
            }
        }


        // AGUA

        if (tipoAtacante.equalsIgnoreCase("Agua")) {

            if (tipoDefensor.equalsIgnoreCase("Fuego")) {
                return 20;
            }

            if (tipoDefensor.equalsIgnoreCase("Planta")) {
                return -10;
            }
        }


        // PLANTA

        if (tipoAtacante.equalsIgnoreCase("Planta")) {

            if (tipoDefensor.equalsIgnoreCase("Fuego")) {
                return -10;
            }

            if (tipoDefensor.equalsIgnoreCase("Agua")) {
                return 20;
            }
        }


        // ELÉCTRICO

        if (tipoAtacante.equalsIgnoreCase("Electrico")) {

            if (tipoDefensor.equalsIgnoreCase("Agua")) {
                return 20;
            }
        }

        return 0;
    }

    private void resolverRonda(double ataqueTotal,
                               Entrenador atacante,
                               Entrenador defensor) {

        vista.mostrarMensaje("");

        if (ataqueTotal > 0) {

            vista.mostrarMensaje(
                    "Ganador de la ronda: "
                    + atacante.getNombre()
            );

            atacante.sumarVictoria();

        } else if (ataqueTotal < 0) {

            vista.mostrarMensaje(
                    "Ganador de la ronda: "
                    + defensor.getNombre()
            );

            defensor.sumarVictoria();

        } else {

            vista.mostrarMensaje("La ronda terminó en empate.");
        }
    }

    private void mostrarResultadoFinal() {

        vista.mostrarMensaje("=================================");
        vista.mostrarMensaje("       RESULTADO FINAL");
        vista.mostrarMensaje("=================================");

        vista.mostrarMensaje(
                jugador1.getNombre()
                + ": "
                + jugador1.getRondasGanadas()
                + " rondas ganadas"
        );

        vista.mostrarMensaje(
                jugador2.getNombre()
                + ": "
                + jugador2.getRondasGanadas()
                + " rondas ganadas"
        );

        vista.mostrarMensaje("");

        if (jugador1.getRondasGanadas()
                > jugador2.getRondasGanadas()) {

            vista.mostrarMensaje(
                    "¡"
                    + jugador1.getNombre()
                    + " gana la batalla!"
            );

        } else if (jugador2.getRondasGanadas()
                > jugador1.getRondasGanadas()) {

            vista.mostrarMensaje(
                    "¡"
                    + jugador2.getNombre()
                    + " gana la batalla!"
            );

        } else {

            vista.mostrarMensaje(
                    "La batalla terminó en empate."
            );
        }
    }
}