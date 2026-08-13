public class Batalla {
    private Ronda ronda1; 
    private Ronda ronda2; 
    private Ronda ronda3; 
    private Ronda ronda4; 
    private Jugador jugador1;
    private Jugador jugador2; 


    public Batalla(Jugador jugador1, Jugador jugador2){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2; 
    } 

    public Jugador getJugador1() {
        return jugador1; 
    }

    public Jugador getJugador2() {
        return jugador2; 
    }

    public void datosRondas(Ronda ronda, int rondaNumero) {
            if (rondaNumero == 1) {
                ronda1 = ronda; 
            } else if (rondaNumero == 2) {
                ronda2 = ronda; 
            } else if (rondaNumero == 3) {
                ronda3 = ronda; 
            } else if (rondaNumero == 4) {
                ronda4 = ronda; 
            }
    }

    public Jugador darGanador() {
        if (jugador1.getRondaGanada() > jugador2.getRondaGanada()) {
            return jugador1; 
        } else if (jugador2.getRondaGanada() > jugador1.getRondaGanada()) {
            return jugador2; 
        } else {
            return null; 
        }
    }

}

