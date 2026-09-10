public class Escenario {

    // Atributos
    private String codigo;
    private String nombre;
    private String ubicacion;
    private int capacidadMaxima;
    private String estado;

    // Constructor
    public Escenario(String codigo, String nombre, String ubicacion, int capacidadMaxima, String estado) {

        validarTexto(codigo, "codigo");
        validarTexto(nombre, "nombre");
        validarTexto(ubicacion, "ubicacion");

        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;

        setCapacidadMaxima(capacidadMaxima);
        setEstado(estado);
    }

    // Getters
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

    // Setters para los atributos que se pueden modificar después de la creación del objeto
    //Contiene excepciones para validar los datos de entrada
    public void setCapacidadMaxima(int capacidadMaxima) {
        if (capacidadMaxima <= 0) {
            throw new IllegalArgumentException(
                    "La capacidad maxima debe ser mayor que cero."
            );
        }

        this.capacidadMaxima = capacidadMaxima;
    }

    public void setEstado(String estado) {
        validarTexto(estado, "estado");
        this.estado = estado;
    }

    // Validación extra con excepción para los campos de texto
    private void validarTexto(String texto, String campo) {
        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El campo " + campo + " no puede estar vacio."
            );
        }
    }
}