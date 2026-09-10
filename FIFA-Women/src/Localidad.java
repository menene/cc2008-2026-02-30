public class Localidad {
    private int capacidad;
    private int vendidos;
    private int numLoc;
    private int precioLoc;

    //todos los getters y setters de localidad
    public Localidad(int numLoc, int precioLoc, int capacidad) 
    {
        this.numLoc = numLoc;
        this.precioLoc = precioLoc;
        this.capacidad = capacidad;
        this.vendidos = 0;
    }

    public int getCapacidad() 
    {
        return capacidad;
    }

    public void setCapacidad(int capacidad) 
    {
        this.capacidad = capacidad;
    }

    public int getVendidos() 
    {
        return vendidos;
    }

    public void setVendidos(int vendidos) 
    {
        this.vendidos = vendidos;
    }

    public int getNumLoc() 
    {
        return numLoc;
    }

    public void setNumLoc(int numLoc) 
    {
        this.numLoc = numLoc;
    }

    public int getPrecioLoc() 
    {
        return precioLoc;
    }

    public void setPrecioLoc(int precioLoc) 
    {
        this.precioLoc = precioLoc;
    }
}