public class Localidad{

    // atributos
    private String nombre;
    private int precio;
    private int capacidad;
    private int boletosDisponibles;
    private int boletosVendidos;

    // métodos
    public Localidad(String nombre, int precio, int capacidad){
        this.nombre = nombre;
        this.precio = precio;
        this.capacidad = capacidad;
        // al iniciar, todos los boletos de la localidad están disponibles
        this.boletosDisponibles = capacidad;
        this.boletosVendidos = 0;
    }

    public String getNombre(){
        return nombre;
    }

    public int getPrecio(){
        return precio;
    }

    public int getCapacidad(){
        return capacidad;
    }

    public int getBoletosDisponibles(){
        return boletosDisponibles;
    }

    public int getBoletosVendidos(){
        return boletosVendidos;
    }

    public void venderBoletos(int boletos){
        // procesamiento propio de la localidad: actualiza vendidos y disponibles
        boletosVendidos = boletosVendidos + boletos;
        boletosDisponibles = boletosDisponibles - boletos;
    }


}
