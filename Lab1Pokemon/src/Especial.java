public class Especial {
    private String NombreEspecial;
    private int PorcentajeAct;
    private int NumPorcentaje;
    private int Potenciador;

    public Especial(String NombreEspecial, int PorcentajeAct) 
    {
        this.NombreEspecial = NombreEspecial;
        this.PorcentajeAct = PorcentajeAct;
        this.NumPorcentaje = 0;
        this.Potenciador = 0;
    }

    //getter y setters del ataque especial
    public String getNombreEspecial() 
    {
        return NombreEspecial;
    }

    public void setNombreEspecial(String value) 
    {
        this.NombreEspecial = value;
    }

    public int getPorcentajeAct() 
    {
        return PorcentajeAct;
    }

    public void setPorcentajeAct(int value) 
    {
        this.PorcentajeAct = value;
    }

    public int getNumPorcentaje() 
    {
        return NumPorcentaje;
    }

    public void setNumPorcentaje(int value) 
    {
        this.NumPorcentaje = value;
    }

    public int getPotenciador() 
    {
        return Potenciador;
    }

    public void setPotenciador(int value) 
    {
        this.Potenciador = value;
    }
}