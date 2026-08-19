public class Localidad {

    private int numero_Localidad;
    private int capacidad;
    private int precio_Boleto;
    private int boletos_vendidos;

    public Localidad(int numero_Localidad, int capacidad, int precio_Boleto) {
        this.numero_Localidad = numero_Localidad;
        this.capacidad = capacidad;
        this.precio_Boleto = precio_Boleto;
    }

    public boolean hayLugar(int cantidad) {
        return capacidad >= cantidad;
    }
    public void vender_Boletos(int cantidad) {
        capacidad -= cantidad;
        boletos_vendidos += cantidad;
    }
    public int getNumero_Localidad() {
        return numero_Localidad;
    }
    public int getCapacidad() {
        return capacidad;
    }

    public int getPrecio_Boleto() {
        return precio_Boleto;
    }

    public int getBoletosVendidos() {
        return boletos_vendidos;
    }

}