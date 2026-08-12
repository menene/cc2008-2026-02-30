public class Controlador {
    private SistemaBatalla sistema;
    private Vista vista;

    public Controlador(SistemaBatalla sistema, Vista vista) {
        this.sistema = sistema;
        this.vista = vista;
    }

    public void iniciar(Jugador jugador1, Jugador jugador2, Pokemon pokemon1, Pokemon pokemon2, Pokemon pokemon3,
            Pokemon pokemon4, Pokemon pokemon5, Pokemon pokemon6, Pokemon pokemon7, Pokemon pokemon8) {
        vista.mostrarInicio();

        seleccionarEquipos(jugador1, jugador2, pokemon1, pokemon2, pokemon3, pokemon4, pokemon5, pokemon6, pokemon7,
                pokemon8);

        vista.mostrarEquipo(jugador1);
        vista.mostrarEquipo(jugador2);
        vista.pausar();

        for (int ronda = 1; ronda <= 4; ronda++) {
            String resultado;

            if (ronda % 2 != 0) {
                resultado = sistema.ejecutarRonda(jugador1, jugador2);
            } else {
                resultado = sistema.ejecutarRonda(jugador2, jugador1);
            }

            vista.mostrarRonda(ronda, resultado);
        }

        String resultadoFinal = sistema.determinarGanadorBatalla();

        vista.mostrarResultadoFinal(resultadoFinal);
    }

    private void seleccionarEquipos(Jugador jugador1, Jugador jugador2, Pokemon pokemon1, Pokemon pokemon2,
            Pokemon pokemon3,
            Pokemon pokemon4, Pokemon pokemon5, Pokemon pokemon6, Pokemon pokemon7, Pokemon pokemon8) {
        
            for (int posicion = 1; posicion <= 4; posicion++) {
                seleccionarPokemonJugador(jugador1, posicion, pokemon1, pokemon2, pokemon3, pokemon4, pokemon5, pokemon6, pokemon7, pokemon8);
                seleccionarPokemonJugador(jugador2, posicion, pokemon1, pokemon2, pokemon3, pokemon4, pokemon5, pokemon6, pokemon7, pokemon8);
            }
    }

    private void seleccionarPokemonJugador(Jugador jugador, int posicion, Pokemon pokemon1, Pokemon pokemon2,
            Pokemon pokemon3, Pokemon pokemon4, Pokemon pokemon5, Pokemon pokemon6, Pokemon pokemon7,
            Pokemon pokemon8) {
        boolean seleccionCorrecta = false;

        while (!seleccionCorrecta) {
            vista.mostrarPokemonDisponibles(pokemon1, pokemon2, pokemon3, pokemon4, pokemon5, pokemon6, pokemon7,
                    pokemon8);

            int opcion = vista.pedirPokemon(jugador.getNombre(), posicion);

            Pokemon seleccionado = obtenerPokemon(opcion, pokemon1, pokemon2, pokemon3, pokemon4, pokemon5, pokemon6,
                    pokemon7, pokemon8);

            if (seleccionado != null && !seleccionado.getAsignado()) {
                jugador.asignarPokemon(posicion, seleccionado);
                seleccionado.setAsignado(true);

                seleccionCorrecta = true;
            } else {
                vista.mostrarErrorSeleccion();
            }
        }
    }

    private Pokemon obtenerPokemon(int opcion, Pokemon pokemon1, Pokemon pokemon2, Pokemon pokemon3,
            Pokemon pokemon4, Pokemon pokemon5, Pokemon pokemon6, Pokemon pokemon7, Pokemon pokemon8) {

        switch (opcion) {
            case 1:
                return pokemon1;
            case 2:
                return pokemon2;
            case 3:
                return pokemon3;
            case 4:
                return pokemon4;
            case 5:
                return pokemon5;
            case 6:
                return pokemon6;
            case 7:
                return pokemon7;
            case 8:
                return pokemon8;

            default:
                return null;
        }
    }
}
