public class PokeVista {


    public void mostrarInicioBatalla(){
        System.out.println("La batalla ha iniciado");
    }

    public void mostrarEstadoBatalla(Ronda ronda){
        System.out.println("Ronda:" + ronda.getRondaNumero());
        System.out.println("Atacante: " + ronda.getTurnoAtaca().getNombreJugador()); 
        System.out.println("Defensor: " + ronda.getTurnoDefiende().getNombreJugador());
        System.out.println("Atacará con: " + ronda.getAtacaPokemon().getNombre());
        System.out.println("Defenderá con: " + ronda.getDefiendePokemon().getNombre());
    }

    public void mostrarResultadosRondas(Resultado resultado) { 
        System.out.println("Ataque final: " + resultado.getAtaqueFinal());
        System.out.println("Defensa final: " + resultado.getDefensaFinal());
        if (resultado.getGanador() == null){
            System.out.println("Empate");
        } else { 
            System.out.println("El ganador de la ronda es: " + resultado.getGanador().getNombreJugador());
        }
    }

    public void mostrarGanadorBatalla(Jugador ganador) {
        if (ganador == null){
            System.out.println("EMPATE");
        } else {
            System.out.println("Ganador batalla: " + ganador.getNombreJugador());
        }
    }
}