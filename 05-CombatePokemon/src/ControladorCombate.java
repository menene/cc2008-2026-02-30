public class ControladorCombate {

    public void iniciarCombate(Combate combate) {

        VistaCombate vista = new VistaCombate();

        // Muestra el inicio del combate
        vista.mostrarInicioCombate(
            combate.getEntrenador1(),
            combate.getEntrenador2()
        );

        // Muestra los Pokemon de cada entrenador
        vista.mostrarPokemones(
            combate.getEntrenador1()
        );

        vista.mostrarPokemones(
            combate.getEntrenador2()
        );

        // Ejecuta las 4 rondas
        while (combate.getRondaActual() <= 4) {

            ejecutarRonda(combate);

            combate.avanzarRonda();
        }

        // Determina el ganador final
        Entrenador ganador = determinarGanador(combate);

        if (ganador != null) {

            vista.mostrarGanadorFinal(
                ganador.getNombre()
            );

        } else {

            vista.mostrarEmpateFinal();
        }
    }


    public void ejecutarRonda(Combate combate) {

        VistaCombate vista = new VistaCombate();

        Entrenador atacante;
        Entrenador defensor;


        // Determina quien ataca y quien defiende
        if (combate.getRondaActual() % 2 != 0) {

            atacante = combate.getEntrenador1();
            defensor = combate.getEntrenador2();

        } else {

            atacante = combate.getEntrenador2();
            defensor = combate.getEntrenador1();
        }


        // Seleccion aleatoria de Pokemon que no haya participado
        Pokemon pokemonAtacante = atacante.seleccionarPokemon();
        Pokemon pokemonDefensor = defensor.seleccionarPokemon();


        // Muestra el enfrentamiento de la ronda
        vista.mostrarRonda(
            combate.getRondaActual(),
            pokemonAtacante,
            pokemonDefensor
        );


        // Estadisticas base
        double ataqueEfectivo = pokemonAtacante.getAtaque();
        double defensaEfectiva = pokemonDefensor.getDefensa();


        // Intenta activar la habilidad especial del atacante
        if (pokemonAtacante.getHabilidadEspecial().intentarActivar()) {

            int potenciador = pokemonAtacante
                .getHabilidadEspecial()
                .generarPotenciador();

            ataqueEfectivo = calcularEstadisticaEfectiva(
                pokemonAtacante.getAtaque(),
                potenciador
            );

            vista.mostrarHabilidadEspecial(
                pokemonAtacante,
                potenciador
            );
        }


        // Intenta activar la habilidad especial del defensor
        if (pokemonDefensor.getHabilidadEspecial().intentarActivar()) {

            int potenciador = pokemonDefensor
                .getHabilidadEspecial()
                .generarPotenciador();

            defensaEfectiva = calcularEstadisticaEfectiva(
                pokemonDefensor.getDefensa(),
                potenciador
            );

            vista.mostrarHabilidadEspecial(
                pokemonDefensor,
                potenciador
            );
        }


        // Calcula el potenciador de tipo basado en la efectividad del tipo de ataque
        int bonoTipo = calcularEfectividad(
            pokemonAtacante,
            pokemonDefensor
        );


        // Formula del resultado de la ronda
        double ataqueTotal =
            ataqueEfectivo + bonoTipo - defensaEfectiva;


        // Determina quien gano la ronda
        if (ataqueTotal > 0) {

            vista.mostrarGanadorRonda(
                atacante.getNombre()
            );

            if (atacante == combate.getEntrenador1()) {

                combate.sumarRondaE1();

            } else {

                combate.sumarRondaE2();
            }

        } else if (ataqueTotal < 0) {

            vista.mostrarGanadorRonda(
                defensor.getNombre()
            );

            if (defensor == combate.getEntrenador1()) {

                combate.sumarRondaE1();

            } else {

                combate.sumarRondaE2();
            }

        } else {

            vista.mostrarEmpateRonda();
        }
    }


    // Calcula la efectividad del tipo atacante contra el defensor
    private int calcularEfectividad(
        Pokemon atacante,
        Pokemon defensor
    ) {

        String tipoAtacante = atacante.getTipo();
        String tipoDefensor = defensor.getTipo();


        // Fuego
        if (tipoAtacante.equals("Fuego")) {

            if (tipoDefensor.equals("Agua")) {
                return -10;
            }

            if (tipoDefensor.equals("Planta")) {
                return 20;
            }
        }


        // Agua
        if (tipoAtacante.equals("Agua")) {

            if (tipoDefensor.equals("Fuego")) {
                return 20;
            }

            if (tipoDefensor.equals("Planta")) {
                return -10;
            }
        }


        // Planta
        if (tipoAtacante.equals("Planta")) {

            if (tipoDefensor.equals("Fuego")) {
                return -10;
            }

            if (tipoDefensor.equals("Agua")) {
                return 20;
            }
        }


        // Electrico
        if (tipoAtacante.equals("Electrico")) {

            if (tipoDefensor.equals("Agua")) {
                return 20;
            }
        }


        // Si no hay ventaja ni desventaja
        return 0;
    }


    // Calcula el ataque o defensa despues del potenciador
    private double calcularEstadisticaEfectiva(
        int valorBase,
        int potenciador
    ) {

        return valorBase
            + (valorBase * potenciador / 100.0);
    }


    // Determina el ganador final del combate
    private Entrenador determinarGanador(
        Combate combate
    ) {

        if (combate.getRondasGanadasE1()
                > combate.getRondasGanadasE2()) {

            return combate.getEntrenador1();

        } else if (combate.getRondasGanadasE2()
                > combate.getRondasGanadasE1()) {

            return combate.getEntrenador2();

        } else {

            return null;
        }
    }
}