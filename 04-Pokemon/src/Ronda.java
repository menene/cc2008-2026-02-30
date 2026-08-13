public class Ronda{
    byte nronda;
    Jugador entrenador;
    Jugador entrenador1;
    
    public Ronda (byte nronda, Jugador jugador, Jugador jugador1){
        this.nronda=nronda;
        this.entrenador=jugador;
        this.entrenador1=jugador1;
    }


    public Pokemon Ganador(Pokemon pokemon, Pokemon pokemon1){
        byte movimiento = pokemon.Movimiento(true);
        byte movimiento1 = pokemon1.Movimiento(true);

        if (movimiento> movimiento1){
            return pokemon;
        }else if(movimiento1>movimiento) {
            return pokemon1;
        }else {
            return null;
        }
    }

    public Pokemon Combate(Pokemon pokeA, Pokemon pokeB) {

        Pokemon ganador = Ganador(pokeA, pokeB);

        if (ganador == pokeA) {
            entrenador.Victoria();
        } else if (ganador == pokeB) {
            entrenador1.Victoria();
        }

        return ganador;
    }
    

}