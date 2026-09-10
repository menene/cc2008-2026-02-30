public class Jugador {
    private int NumJugador;
    private Pokemon Poke1;
    private Pokemon Poke2;
    private Pokemon Poke3;
    private Pokemon Poke4;
    private int Ganados;

    public Jugador(int NumJugador, Pokemon Poke1, Pokemon Poke2, Pokemon Poke3, Pokemon Poke4) 
    {
        this.NumJugador = NumJugador;
        this.Poke1 = Poke1;
        this.Poke2 = Poke2;
        this.Poke3 = Poke3;
        this.Poke4 = Poke4;
        this.Ganados = 0;
    }

    //getters y setters pokemon
    
    public int getNumJugador() 
    {
        return NumJugador;
    }

    public void setNumJugador(int value) 
    {
        this.NumJugador = value;
    }

    public Pokemon getPoke1() 
    {
        return Poke1;
    }

    public void setPoke1(Pokemon value) 
    {
        this.Poke1 = value;
    }

    public Pokemon getPoke2() 
    {
        return Poke2;
    }

    public void setPoke2(Pokemon value) 
    {
        this.Poke2 = value;
    }

    public Pokemon getPoke3() 
    {
        return Poke3;
    }

    public void setPoke3(Pokemon value) 
    {
        this.Poke3 = value;
    }

    public Pokemon getPoke4() 
    {
        return Poke4;
    }

    public void setPoke4(Pokemon value) 
    {
        this.Poke4 = value;
    }

    public int getGanados() 
    {
        return Ganados;
    }

    public void setGanados(int value) 
    {
        this.Ganados = value;
    }
}