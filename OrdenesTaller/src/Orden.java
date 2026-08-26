public class Orden {

    private int numOrden;
    private String nombre;
    private String placa;
    private String descripcion;
    private double costo;

    public Orden(int numOrden, String nombre, String placa, String descripcion, double costo) {
        this.numOrden = numOrden;
        this.nombre = nombre;
        this.placa = placa;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    //getters y setters del modelo

    public int getNumOrden() 
    {
        return numOrden;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public String getPlaca() 
    {
        return placa;
    }

    public String getDescripcion() 
    {
        return descripcion;
    }

    public double getCosto() 
    {
        return costo;
    }

    public void setDescripcion(String descripcion) 
    {
        this.descripcion = descripcion;
    }

    public void setCosto(double costo) 
    {
        this.costo = costo;
    }

    //esta parte del override es para definir como se va a imprimir en pantalla
    @Override
    public String toString() {
        return String.format(
                "Orden #%d | Propietario: %s | Placa: %s | Servicio: %s | Costo estimado: Q%.2f",
                numOrden, nombre, placa, descripcion, costo);
    }
}
