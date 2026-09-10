import java.util.Random;

public class Sistema {
    private Random random;
    private int Localidades;

    public Sistema() 
    {
        this.random = new Random();
    }

    public int getLocalidades() 
    {
        return Localidades;
    }

    public void setLocalidades(int localidades) 
    {
        this.Localidades = localidades;
    }

    public int GenerarNumA() 
    {
        return random.nextInt(15000) + 1;
    }

    public int GenerarNumB() 
    {
        return random.nextInt(15000) + 1;
    }

    //Acá se elige el número de local aleatoriamente
    public int GenerarLoc() 
    {
        int[] LocalAleatorio = {1, 5, 10};
        this.Localidades = LocalAleatorio[random.nextInt(3)];
        return this.Localidades;
    }

    //Validaciones
    public boolean CantidadMax(int capacidadLoc, int ticketsCompr) 
    {
        return ticketsCompr <= capacidadLoc;
    }

    public boolean CantidadValida(int capacidadLoc, int ticketsCompr, int vendidos) 
    {
        return (capacidadLoc - vendidos) > 0;
    }

    public boolean PresupuestoValido(int ticketsCompr, double presupuesto, int precioLoc) 
    {
        return presupuesto >= (ticketsCompr * precioLoc);
    }
}