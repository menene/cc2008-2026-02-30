public class Localidad{
    private int numero;
    private int capacidad=20;
    private int vendidos;
    private double precio;

    public Localidad(int numero, double precio){
        this.numero=numero;
        this.precio=precio;
    }
    public boolean hayEspacio(){ return capacidad>vendidos; }
    public void venderBoletos(int cantidad){ this.vendidos+=cantidad; }
    public int disponibles(){ return this.capacidad-this.vendidos; }
    public int getNumero(){ return this.numero; }
    public double getRecaudacion(){ return this.vendidos*this.precio; }
    public double getPrecio(){ return this.precio; }
    public int getVendidos(){ return this.vendidos; }
}