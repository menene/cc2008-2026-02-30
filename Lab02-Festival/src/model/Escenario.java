package model;
 
public class Escenario {
    private final int codigo;
    private final String nombre;
    private final String ubicacion;
    private int capacidadMaxima;
    private String estado;

    public Escenario(int codigo, String nombre, String ubicacion,
                     int capacidadMaxima, String estado) {
        this.codigo = codigo;
        this.nombre = validarTexto(nombre, "El nombre del escenario");
        this.ubicacion = validarTexto(ubicacion, "La ubicación");
        setCapacidadMaxima(capacidadMaxima);
        setEstado(estado);
    }

    private static String validarTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " no puede estar vacío.");
        }
        return valor.trim();
    }

    public int getCodigo() { 
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
            throw new IllegalArgumentException("La capacidad máxima debe ser mayor que 0.");
        }
        this.capacidadMaxima = capacidadMaxima;
    }

    public void setEstado(String estado) {
        this.estado = validarTexto(estado, "El estado");
    }

    @Override
    public String toString() {
        return String.format("Código: %d | Nombre: %s | Ubicación: %s | Capacidad: %d | Estado: %s",
                codigo, nombre, ubicacion, capacidadMaxima, estado);
    }
}