public class Artista {
    private String codigo;
    private String nombre;
    private String generoMusical;
    private double duracion;
    private int asistentes;

    public Artista(String codigo, String nombre, String generoMusical, double duracion, int asistentes) {
        validarTexto(codigo, "El código");
        this.codigo = codigo;
        modificarNombre(nombre);
        modificarGenero(generoMusical);
        modificarDuracion(duracion);
        modificarAsistentes(asistentes);
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

    public String getGenero() {
        return generoMusical;
    }

    public double getDuracion() {
        return duracion;
    }

    public int getAsistentes() {
        return asistentes;
    }

    public void modificarNombre(String nuevoNombre) {
        validarTexto(nuevoNombre, "El nombre");
        nombre = nuevoNombre;
    }

    public void modificarGenero(String nuevoGenero) {
        validarTexto(nuevoGenero, "El género musical");
        generoMusical = nuevoGenero;
    }

    public void modificarDuracion(double nuevaDuracion) {
        if (nuevaDuracion <= 0) {
            throw new IllegalArgumentException("La duración debe ser mayor que 0");
        }

        duracion = nuevaDuracion;
    }

    public void modificarAsistentes(int nuevosAsistentes) {
        if (nuevosAsistentes < 0) {
            throw new IllegalArgumentException("Los asistentes no pueden ser negativos");
        }

        asistentes = nuevosAsistentes;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nombre: " + nombre + ", Género musical: " + generoMusical
                + ", Duración: " + duracion + " minutos, Asistentes: " + asistentes;
    }
}