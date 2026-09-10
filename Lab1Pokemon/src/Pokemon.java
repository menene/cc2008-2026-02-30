public class Pokemon {
    private String NombrePokemon;
    private String Tipo;
    private int Ataque;
    private int Defensa;
    private Especial AtaqueEspecial;

    public Pokemon(String NombrePokemon, String Tipo, int Ataque, int Defensa, Especial AtaqueEspecial) 
    {
        this.NombrePokemon = NombrePokemon;
        this.Tipo = Tipo;
        this.Ataque = Ataque;
        this.Defensa = Defensa;
        this.AtaqueEspecial = AtaqueEspecial;
    }

    //getters y setters del pokemon
    public String getNombrePokemon() 
    {
        return NombrePokemon;
    }

    public void setNombrePokemon(String value) 
    {
        this.NombrePokemon = value;
    }

    public String getTipo() 
    {
        return Tipo;
    }

    public void setTipo(String value) 
    {
        this.Tipo = value;
    }

    public int getAtaque() 
    {
        return Ataque;
    }

    public void setAtaque(int value) 
    {
        this.Ataque = value;
    }

    public int getDefensa() 
    {
        return Defensa;
    }

    public void setDefensa(int value) 
    {
        this.Defensa = value;
    }

    public Especial getAtaqueEspecial() 
    {
        return AtaqueEspecial;
    }

    public void setAtaqueEspecial(Especial value) 
    {
        this.AtaqueEspecial = value;
    }
}