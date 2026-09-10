import java.util.ArrayList;

public class Escenario {
    private String codigo;
    private String nombre;
    private int ubicacion;
    private int capacidad;
    private String estado;
    private ArrayList<Artista> artistas;

    public Escenario(String codigo, String nombre, int ubicacion, int capacidad, String estado) {
        validarTexto(codigo, "El código");
        this.codigo = codigo;
        modificarNombre(nombre);
        setUbicacion(ubicacion);
        setCapacidad(capacidad);
        modificarEstado(estado);
        artistas = new ArrayList<>();
    }

    private void validarTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " no puede estar vacío");
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getEstado() {
        return estado;
    }

    public ArrayList<Artista> getArtistas() {
        return artistas;
    }

    public void modificarNombre(String nuevoNombre) {
        validarTexto(nuevoNombre, "El nombre");
        nombre = nuevoNombre;
    }

    public void setNombre(String nuevoNombre) {
        modificarNombre(nuevoNombre);
    }

    public void setUbicacion(int ubicacion) {
        if (ubicacion < 1 || ubicacion > 5) {
            throw new IllegalArgumentException("La ubicación debe estar entre 1 y 5");
        }

        this.ubicacion = ubicacion;
    }

    public void setCapacidad(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que 0");
        }

        this.capacidad = capacidad;
    }

    public void modificarCapacidad(int nuevaCapacidad) {
        setCapacidad(nuevaCapacidad);
    }

    public void modificarEstado(String nuevoEstado) {
        validarTexto(nuevoEstado, "El estado");
        estado = nuevoEstado;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nombre: " + nombre + ", Ubicación: " + ubicacion
                + ", Capacidad: " + capacidad + ", Estado: " + estado;
    }
}