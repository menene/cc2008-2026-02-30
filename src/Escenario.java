public class Escenario {
    private String codigo;
    private String nombre;
    private String ubicacion;
    private int capacidadMaxima;
    private String estado;

    // Crea un escenario con sus datos iniciales; el usuario indica todos los valores al momento de configurarlo.
    public Escenario(String codigo, String nombre, String ubicacion, int capacidadMaxima, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidadMaxima = capacidadMaxima;
        this.estado = estado;
    }

    // Retorna el codigo del escenario; se usa para identificarlo al mostrarlo en los reportes.
    public String getCodigo() {
        return codigo;
    }

    // Retorna el nombre del escenario.
    public String getNombre() {
        return nombre;
    }

    // Retorna la ubicacion del escenario.
    public String getUbicacion() {
        return ubicacion;
    }

    // Retorna la capacidad maxima actual del escenario; es el valor que se recorre para determinar el escenario de mayor capacidad.
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    // Permite modificar la capacidad maxima de un escenario ya configurado.
    public void setCapacidadMaxima(int nuevaCapacidad) {
        this.capacidadMaxima = nuevaCapacidad;
    }

    // Retorna el estado actual del escenario.
    public String getEstado() {
        return estado;
    }

    // Permite modificar el estado de un escenario ya configurado.
    public void setEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }
}
