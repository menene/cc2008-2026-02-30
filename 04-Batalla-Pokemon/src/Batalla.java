public class Batalla {

    // Atributos
    private Jugador jugador1;
    private Jugador jugador2;

    private Ronda ronda1;
    private Ronda ronda2;
    private Ronda ronda3;
    private Ronda ronda4;

    private String ganador;

    // Constructor
    public Batalla() {

    jugador1 = new Jugador("Jugador 1", 1);
    jugador2 = new Jugador("Jugador 2", 2);

    ronda1 = null;
    ronda2 = null;
    ronda3 = null;
    ronda4 = null;

    ganador = "Empate";
}


    // Crea y ejecuta una ronda
    public void ejecutarRonda(int numeroRonda) {

        Pokemon atacante;
        Pokemon defensor;

        Jugador jugadorAtacante;
        Jugador jugadorDefensor;

        // Rondas impares: Jugador 1 ataca
        if (numeroRonda == 1 || numeroRonda == 3) {

            jugadorAtacante = jugador1;
            jugadorDefensor = jugador2;

        } else {

            // Rondas pares: Jugador 2 ataca
            jugadorAtacante = jugador2;
            jugadorDefensor = jugador1;
        }

        // Cada jugador selecciona un Pokemon disponible
        atacante = jugadorAtacante.seleccionarPokemon();
        defensor = jugadorDefensor.seleccionarPokemon();

        // Crear la ronda
        Ronda nuevaRonda = new Ronda(atacante, defensor);

        // Ejecutar el enfrentamiento
        String ganadorRonda = nuevaRonda.ejecutarRonda();

        // Guardar la ronda en el atributo correspondiente
        if (numeroRonda == 1) {
            ronda1 = nuevaRonda;

        } else if (numeroRonda == 2) {
            ronda2 = nuevaRonda;

        } else if (numeroRonda == 3) {
            ronda3 = nuevaRonda;

        } else if (numeroRonda == 4) {
            ronda4 = nuevaRonda;
        }

        // Sumar una victoria al jugador correspondiente
        if (ganadorRonda.equals(atacante.getNombre())) {

            jugadorAtacante.setRondasGanadas(
                    jugadorAtacante.getRondasGanadas() + 1
            );

        } else if (ganadorRonda.equals(defensor.getNombre())) {

            jugadorDefensor.setRondasGanadas(
                    jugadorDefensor.getRondasGanadas() + 1
            );
        }
    }

    // Determina al ganador de la batalla
    public String determinarGanador() {

        if (jugador1.getRondasGanadas()
                > jugador2.getRondasGanadas()) {

            ganador = jugador1.getNombre();

        } else if (jugador2.getRondasGanadas()
                > jugador1.getRondasGanadas()) {

            ganador = jugador2.getNombre();

        } else {

            ganador = "Empate";
        }

        return ganador;
    }

    // Getters

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public Ronda getRonda(int numeroRonda) {

        if (numeroRonda == 1) {
            return ronda1;

        } else if (numeroRonda == 2) {
            return ronda2;

        } else if (numeroRonda == 3) {
            return ronda3;

        } else if (numeroRonda == 4) {
            return ronda4;
        }

        return null;
    }

    public String getGanador() {
        return ganador;
    }
}