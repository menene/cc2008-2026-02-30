public class Escenario {

    private final String codigo;
    private final String nombre;
    private final String ubicacion;
    private int capacidadMaxima;
    private String estado;

    public Escenario(String codigo, String nombre, String ubicacion,
                     int capacidadMaxima, String estado) {

        this.codigo = validarTexto(codigo, "El codigo");
        this.nombre = validarTexto(nombre, "El nombre");
        this.ubicacion = validarTexto(ubicacion, "La ubicacion");

        setCapacidadMaxima(capacidadMaxima);
        setEstado(estado);
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

    public void setCapacidadMaxima(int capacidadMaxima) {
        if (capacidadMaxima <= 0) {
            throw new IllegalArgumentException(
                    "La capacidad maxima debe ser mayor que cero."
            );
        }

        this.capacidadMaxima = capacidadMaxima;
    }

    public void setEstado(String estado) {
        this.estado = validarTexto(estado, "El estado");
    }

    private static String validarTexto(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(
                    campo + " no puede estar vacio."
            );
        }

        return valor.trim();
    }

    @Override
    public String toString() {
        return "Escenario{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", capacidadMaxima=" + capacidadMaxima +
                ", estado='" + estado + '\'' +
                '}';
    }
}