public class Artista {

    private int codigo;
    private String nombreArtistico;
    private String generoMusical;
    private float duracion;
    private int cantidadAsist;

    public Artista(int codigo, String nombreArtistico, String generoMusical, float duracion, int cantidadAsist) {
        this.codigo = codigo;
        this.nombreArtistico = nombreArtistico;
        this.generoMusical = generoMusical;
        setDuracion(duracion);
        setCantidadAsist(cantidadAsist);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public float getDuracion() {
        return duracion;
    }

    public int getCantidadAsist() {
        return cantidadAsist;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public void setDuracion(float duracion) {
        if (duracion <= 0) {
            throw new IllegalArgumentException("La duración debe ser mayor que cero.");
        }

        this.duracion = duracion;
    }

    public void setCantidadAsist(int cantidadAsist) {
        if (cantidadAsist < 0) {
            throw new IllegalArgumentException("La cantidad de asistentes no puede ser negativa.");
        }

        this.cantidadAsist = cantidadAsist;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + "\nNombre artístico: " + nombreArtistico + "\nGénero musical: " + generoMusical 
            + "\nDuración: " + duracion + " minutos" + "\nCantidad estimada de asistentes: " + cantidadAsist;
    }
}