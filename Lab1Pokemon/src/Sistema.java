import java.util.Random;

public class Sistema {
    private Random random;
    private int Ronda;

    public Sistema() 
    {
        this.random = new Random();
        this.Ronda = 1;
    }

    public int getRonda() 
    {
        return Ronda;
    }

    public void setRonda(int ronda) 
    {
        this.Ronda = ronda;
    }

    public int GenerarNumPorcentaje() 
    {
        return random.nextInt(101);
    }

    public int GenerarPotenciador() 
    {
        return random.nextInt(26);
    }

    //La tabla de tipos y encuentros entre cada uno
    public int BonoTipo(String tipoAtacante, String tipoDefensor) 
    {
        if (tipoAtacante.equalsIgnoreCase("Fuego")) 
        {
            if (tipoDefensor.equalsIgnoreCase("Planta")) return 20;
            if (tipoDefensor.equalsIgnoreCase("Agua")) return -10;
        } 
        else if (tipoAtacante.equalsIgnoreCase("Agua")) 
        {
            if (tipoDefensor.equalsIgnoreCase("Fuego")) return 20;
            if (tipoDefensor.equalsIgnoreCase("Planta")) return -10;
        } 
        else if (tipoAtacante.equalsIgnoreCase("Planta")) 
        {
            if (tipoDefensor.equalsIgnoreCase("Agua")) return 20;
            if (tipoDefensor.equalsIgnoreCase("Fuego")) return -10;
        } 
        else if (tipoAtacante.equalsIgnoreCase("Eléctrico")) 
        {
            if (tipoDefensor.equalsIgnoreCase("Agua")) return 20;
        }
        
        return 0;
    }

    public boolean PorcentajeValido(int numGenerado, int porcentajeAct) 
    {
        return numGenerado <= porcentajeAct;
    }

    public int ResultadoRonda(int ataqueEfectivo, int bonoTipo, int defensaEfectiva) 
    {
        return (ataqueEfectivo + bonoTipo) - defensaEfectiva;
    }

    public int ValidarGanador(int resultado) 
    {
        if (resultado > 0) 
        {
            return 1; //cuando el atacante gana
        } 
        else if (resultado < 0) 
        {
            return -1;
        } 
        else 
        {
            return 0; //empate
        }
    }
}