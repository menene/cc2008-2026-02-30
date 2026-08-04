public class Evento {

    private String nombre;
    private Localidad localidad1;
    private Localidad localidad2;
    private Localidad localidad3;

    // Constructor
    public Evento(String nombre, Localidad loc1, Localidad loc2, Localidad loc3) {
        this.nombre = nombre;
        this.localidad1 = loc1;
        this.localidad2 = loc2;
        this.localidad3 = loc3;
    }

    // Devuelve la cantidad total de boletos disponibles
    public int disponibilidadTotal() {
        return localidad1.getBoletosDisponibles()
                + localidad2.getBoletosDisponibles()
                + localidad3.getBoletosDisponibles();
    }

    // Devuelve la disponibilidad de una localidad
    public int disponibilidadLocal(int numeroLocalidad) {

        if (numeroLocalidad == 1) {
            return localidad1.getBoletosDisponibles();
        }

        if (numeroLocalidad == 5) {
            return localidad2.getBoletosDisponibles();
        }

        if (numeroLocalidad == 10) {
            return localidad3.getBoletosDisponibles();
        }

        return -1;
    }

    // Devuelve el total de boletos vendidos
    public int vendidosTotal() {

        return localidad1.getBoletosComprados()
                + localidad2.getBoletosComprados()
                + localidad3.getBoletosComprados();

    }

    // Calcula las ganancias del evento
    public float ganancias() {

        float ganancias = 0;

        ganancias += localidad1.getBoletosComprados() * localidad1.getPrecio();
        ganancias += localidad2.getBoletosComprados() * localidad2.getPrecio();
        ganancias += localidad3.getBoletosComprados() * localidad3.getPrecio();

        return ganancias;
    }

    // Getters

    public String getNombre() {
        return nombre;
    }

    public Localidad getLocalidad1() {
        return localidad1;
    }

    public Localidad getLocalidad2() {
        return localidad2;
    }

    public Localidad getLocalidad3() {
        return localidad3;
    }

}