public class Combate {
    // Atributos
    private Ronda ronda1;
    private Ronda ronda2;
    private Ronda ronda3;
    private Ronda ronda4;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador ganador;

    // Constructor de la clase
    public Combate(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;

        this.ronda1 = null;
        this.ronda2 = null;
        this.ronda3 = null;
        this.ronda4 = null;

        this.ganador = null;
    }

    // Setters
    public void setRonda1(Ronda ronda) {
        this.ronda1 = ronda;
    }

    public void setRonda2(Ronda ronda) {
        this.ronda2 = ronda;
    }

    public void setRonda3(Ronda ronda) {
        this.ronda3 = ronda;
    }

    public void setRonda4(Ronda ronda) {
        this.ronda4 = ronda;
    }

    // Compara las rondas ganadas de los jugadores para determinar un ganador.
    public Jugador determinarGanador() {

        if (jugador1.getRondasGanadas() > jugador2.getRondasGanadas()) {
            ganador = jugador1;
        } else if (jugador2.getRondasGanadas() > jugador1.getRondasGanadas()) {
            ganador = jugador2;
        } else {
            ganador = null;
        }
        return ganador;
    }

    // Getters
    public Jugador getGanador() {
        return ganador;
    }
    public Jugador getJugador1() {
        return jugador1;
    }
    public Jugador getJugador2() {
        return jugador2;
    }
}
