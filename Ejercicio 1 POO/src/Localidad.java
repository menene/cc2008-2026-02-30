public class Localidad {

    private int numero;
    private double precio;
    private int boletosDisponibles;
    private int boletosVendidos;

    public Localidad() {

    }

    public Localidad(int numero, double precio, int boletosDisponibles, int boletosVendidos) {
        this.numero = numero;
        this.precio = precio;
        this.boletosDisponibles = boletosDisponibles;
        this.boletosVendidos = boletosVendidos;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getBoletosDisponibles() {
        return boletosDisponibles;
    }

    public void setBoletosDisponibles(int boletosDisponibles) {
        this.boletosDisponibles = boletosDisponibles;
    }

    public int getBoletosVendidos() {
        return boletosVendidos;
    }

    public void setBoletosVendidos(int boletosVendidos) {
        this.boletosVendidos = boletosVendidos;
    }

    public void venderBoletos(int cantidad) {
        boletosDisponibles -= cantidad;
        boletosVendidos += cantidad;
    }

}