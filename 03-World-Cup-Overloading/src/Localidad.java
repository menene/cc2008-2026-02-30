public class Localidad {


    private float precio;
    private int boletosTotales;
    private int boletosDisponibles;
    private int boletosComprados;
    private String nombre;

    // Constructor
    public Localidad(String nombre, float precio, int boletosTotales) {
        this.nombre = nombre;
        this.precio = precio;
        this.boletosTotales = boletosTotales;
        this.boletosDisponibles = boletosTotales;
        this.boletosComprados = 0;
    }

    
    public float getPrecio() {
        return precio;
    }

    
    public int getBoletosTotales() {
        return boletosTotales;
    }

   
    public void setBoletosTotales(int value) {
        boletosTotales = value;
    }

    
    public int getBoletosDisponibles() {
        return boletosDisponibles;
    }

    
    public void setBoletosDisponibles(int value) {
        boletosDisponibles = value;
    }

    
    public int getBoletosComprados() {
        return boletosComprados;
    }

    
    public void setBoletosComprados(int value) {
        boletosComprados = value;
    }

   
    public String getNombre() {
        return nombre;
    }

}