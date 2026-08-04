public class Localidad {

    private int precio;
    private byte disponibilidad;
    private byte boletosVendidos;

    public Localidad(int precio) {

        this.precio = precio;
        disponibilidad = 20;
        boletosVendidos = 0;

    }

    public int getPrecio() {

        return precio;

    }

    public byte getDisponibilidad() {

        return disponibilidad;

    }

    public byte getBoletosVendidos() {

        return boletosVendidos;

    }

    public void venderBoletos(byte cantidad) {

        disponibilidad -= cantidad;
        boletosVendidos += cantidad;

    }

    public int getDinero() {

        return precio * boletosVendidos;

    }

}