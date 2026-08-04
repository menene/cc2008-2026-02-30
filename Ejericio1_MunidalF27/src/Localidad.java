public class Localidad {

    private int numero;
    private double precio;
    private int capacidad;
    private int vendidos;

    public Localidad(int numero, double precio, int capacidad) {

        this.numero = numero;
        this.precio = precio;
        this.capacidad = capacidad;
        this.vendidos = 0;
    }

    public boolean hayEspacio(){
        return vendidos < capacidad;
    }

    public void venderBoletos(int cantidad){
        vendidos += cantidad;
    }

    public int getDisponibles(){
        return capacidad - vendidos;
    }

    public double getIngreso(){
        return vendidos * precio;
    }


}