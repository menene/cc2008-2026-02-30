/* Clase del escenario. Guarda los datos de un espacio del festival y valida su capacidad. */
public class Escenario {

    private String codigo;
    private String nombre;
    private String ubicacion;
    private int capacidadMaxima;
    private String estado;

    /* Constructor. Revisa que la capacidad sea mayor que 0 antes de guardar los datos */
    public Escenario(String codigo, String nombre, String ubicacion, int capacidadMaxima, String estado) {
        if (capacidadMaxima <= 0) {
            throw new IllegalArgumentException("La capacidad maxima debe ser mayor que 0");
        }

        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidadMaxima = capacidadMaxima;
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public String getEstado() {
        return estado;
    }

    /* Cambia la capacidad. Vuelve a revisar que el numero nuevo sea mayor que 0 */
    public void setCapacidadMaxima(int capacidadMaxima) {
        if (capacidadMaxima <= 0) {
            throw new IllegalArgumentException("La capacidad maxima debe ser mayor que 0");
        }

        this.capacidadMaxima = capacidadMaxima;
    }

    /* Cambia el estado del escenario, por ejemplo de disponible a ocupado */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /* Junta todos los datos del escenario en un solo texto */
    public String toString() {
        return codigo + " - " + nombre
                + " | Ubicacion: " + ubicacion
                + " | Capacidad: " + capacidadMaxima
                + " | Estado: " + estado;
    }
}
