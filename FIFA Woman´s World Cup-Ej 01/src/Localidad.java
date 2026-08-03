public class Localidad {
    //ATRIBUTOS// 

    private int numero;
    private double precio;
    private int capacidad;
    private int boletosVendidos;

    //CONSTRUCTOR// 

    public Localidad(int numero, double precio) {

        this.numero = numero;
        this.precio = precio;
        this.capacidad = 20;
        this.boletosVendidos = 0;
    }

    //METODOS//
    public int getPrecio() {
        return (int) precio;
}

    public int getDisponibles() {
        return capacidad - boletosVendidos;
}

    public void venderBoletos(int cantidad) {
    boletosVendidos += cantidad;
}

    public int getBoletosVendidos() {
        return boletosVendidos;
}
}
