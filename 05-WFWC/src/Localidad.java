public class Localidad {
    private String nombreLocalidad;
    private double precio;
    private int capacidadMaxima;
    private int boletosVendidos;

    // Constructor
    public Localidad(String nombreLocalidad, double precio) {
        this.nombreLocalidad = nombreLocalidad;
        this.precio = precio;
        this.capacidadMaxima = 20;
        this.boletosVendidos = 0;
    }

    public String getNombreLocalidad() {
        return nombreLocalidad;
    }

    public double getPrecio() {
        return precio;
    }

    public int getBoletosVendidos() {
        return boletosVendidos;
    }

    public int getBoletosDisponibles() {
        return capacidadMaxima - boletosVendidos;
    }

    public boolean tieneEspacio() {
        return boletosVendidos < capacidadMaxima;
    }

    public void venderBoletos(int cantidad) {
        boletosVendidos += cantidad; 
    }
}



