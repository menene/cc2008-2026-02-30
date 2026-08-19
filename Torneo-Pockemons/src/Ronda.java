public class Ronda{

    // atributos

    int numeroRonda;
    Jugador jugadorAtacante;
    Jugador jugadorDefensor;
    Pockemon pokemonAtacante;
    Pockemon pokemonDefensor;
    int ataqueEfectivo;
    int defensaEfectiva;
    int bonoTipo;
    int ataqueTotal;
    String ganadorRonda;


    // métodos

    // Constructor
    public Ronda(int numeroRonda, Jugador jugadorAtacante, Jugador jugadorDefensor){
        this.numeroRonda = numeroRonda;
        this.jugadorAtacante = jugadorAtacante;
        this.jugadorDefensor = jugadorDefensor;
    }

    // getter de los datos de la classe "Ronda"

    public int getNumeroRonda(){
        return numeroRonda;
    }

    public Jugador getJugadorAtacante(){
        return jugadorAtacante;
    }

    public Jugador getJugadorDefensor(){
        return jugadorDefensor;
    }
    
    public Pockemon getPokemonAtacante(){
        return pokemonAtacante;
    }

    public Pockemon getPokemonDefensor(){
        return pokemonDefensor;
    }

    public int getAtaqueEfectivo(){
        return ataqueEfectivo;
    }
    
    public int getDefensaEfectiva(){
        return defensaEfectiva;
    }

    public int getBonoTipo(){
        return bonoTipo;
    }

    public int getAtaqueTotal(){
        return ataqueTotal;
    }

    public String getGanadorRonda(){
        return ganadorRonda;
    }


    // setter de los datos de la classe "Ronda"

    public void setPokemonAtacante(Pockemon pokemonAtacante){
        this.pokemonAtacante = pokemonAtacante;
    }

    public void setPokemonDefensor(Pockemon pokemonDefensor){
        this.pokemonDefensor = pokemonDefensor;
    }

    public void setAtaqueEfectivo(int ataqueEfectivo){
        this.ataqueEfectivo = ataqueEfectivo;
    }

    public void setDefensaEfectiva(int defensaEfectiva){
        this.defensaEfectiva = defensaEfectiva;
    }

    public void setBonoTipo(int bonoTipo){
        this.bonoTipo = bonoTipo;
    }

    public void setAtaqueTotal(int ataqueTotal){
        this.ataqueTotal = ataqueTotal;
    }

    public void setGanadorRonda(String ganadorRonda){
        this.ganadorRonda = ganadorRonda;
    }

    
}
