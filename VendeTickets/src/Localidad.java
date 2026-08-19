public class Localidad {

    private int numero;
    private double precio;
    private int capacidad;
    private int boletosVendidos;

    //Constructor
    public Localidad(int numero, double precio, int capacidad) {
        this.numero = numero;
        this.precio = precio;
        this.capacidad = capacidad;
        this.boletosVendidos = 0;
    }

    //Getters
    public int getNumero(){
        return numero;
    }

    public double getPrecio() {
    return precio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getBoletosVendidos() {
        return boletosVendidos;
    }
    //Vender Boletos
    public void venderBoletos(int cantidad){ //no devuelve nada. Su trabajo es actualizar el
                                             //numero de boletos vendidos
        boletosVendidos += cantidad;
    }

    //Boletos disponibles
    public int getDisponibles(){
        return capacidad - boletosVendidos; //calculo para boletos disponibles
    }

}

