public class Localidad {

    private String nombre;
    private int cantidadAsientos;
    private int asientosVendidos;
    private float precio;

    public Localidad(String nombre, int cantidadAsientos, float precio) {
        this.nombre = nombre;
        this.cantidadAsientos = cantidadAsientos;
        this.precio = precio;
        this.asientosVendidos = 0; 
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public int getAsientosDisponibles() {
        return cantidadAsientos - asientosVendidos;
    }

    public boolean tieneEspacio() {
        return getAsientosDisponibles() > 0;
    }

    public int venderBoletos(int cantidadDeseada) {
        int disponibles = getAsientosDisponibles();

        if (disponibles <= 0) {
            return 0;
        }

        int cantidadAVender = Math.min(cantidadDeseada, disponibles);
        asientosVendidos += cantidadAVender;

        return cantidadAVender;
    }
}