public class Localidad {
    private int numero;
    private double precio;
    private int capacidadMaxima;
    private int boletosVendidos;


    public Localidad(int numero, double precio) {
        this.numero = numero;
        this.precio = precio;
        this.capacidadMaxima = 20; // Requerimiento del PDF
        this.boletosVendidos = 0;
    }

    public boolean hayEspacio() {
        return this.boletosVendidos < this.capacidadMaxima;
    }

    public void venderBoletos(int cantidad) {
        this.boletosVendidos += cantidad;
    }

    public int boletosDisponibles() {
        return this.capacidadMaxima - this.boletosVendidos;
    }

    public double getPrecio() {
        return this.precio;
    }

    public int getNumero() {
        return this.numero;
    }
}
