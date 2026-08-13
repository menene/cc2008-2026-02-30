public class Ronda {
    private int rondaNumero;
    private Jugador turnoAtaca; 
    private Jugador turnoDefiende;
    private Pokemon atacaPokemon; 
    private Pokemon defiendePokemon; 
    private Resultado resultado; 


    //Constructor 
    public Ronda(int rondaNumero, Jugador turnoAtaca, Jugador turnoDefiende){
        this.rondaNumero = rondaNumero; 
        this.turnoAtaca = turnoAtaca; 
        this.turnoDefiende = turnoDefiende; 
    }
    
    public void inicioRonda() {
        atacaPokemon = turnoAtaca.darPokemon(); 
        defiendePokemon = turnoDefiende.darPokemon(); 
        resultado = new Resultado(); 
        resultado.calculoResultado(turnoAtaca, turnoDefiende, atacaPokemon, defiendePokemon);
    }
    //Obtener el numero de ronda 
    public int getRondaNumero() {
        return rondaNumero; 
    }
    //determinar que jugador ataca 
    public Jugador getTurnoAtaca() {
        return turnoAtaca; 
    }
    //determinar que jugador defiende 
    public Jugador getTurnoDefiende() {
        return turnoDefiende; 
    }
    //determinar con que poquemon jugara el atacante 
    public Pokemon getAtacaPokemon() { 
        return atacaPokemon;
    }
    //determinar con que poquemon jugara el que defiende
    public Pokemon getDefiendePokemon() {
        return defiendePokemon; 
    }
    // Obtener el resultado de la ronda 
    public Resultado getResultado() {
        return resultado; 
    }
}

