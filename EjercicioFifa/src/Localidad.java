public class Localidad {
    
    private int numero;
    private float precio;
    private int capacidad;
    private int boletosVendidos;

    public Localidad(int numero, float precio) {
        this.numero = numero;
        this.precio = precio;
        this.capacidad = 20;
        this.boletosVendidos = 0;
    }

    public void venderBoletos(int cantidadBoletos) {
        boletosVendidos += cantidadBoletos;
    }

    public int getBoletosDisponibles() {
        return capacidad - boletosVendidos;
    }

    public float getPrecio() {
        return precio;
    }

    public int getNumero() {
        return numero;
    }
}