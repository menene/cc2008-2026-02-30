public class Artista {

    private String codigo;
    private String nombreArtistico;
    private String generoMusical;
    private int duracionPresentacion;
    private int cantidadEstimadaAsistentes;

    public Artista(String codigo, String nombreArtistico, String generoMusical,
                   int duracionPresentacion, int cantidadEstimadaAsistentes) {

        if (duracionPresentacion <= 0) {
            throw new IllegalArgumentException(
                "La duración de la presentación debe ser mayor que 0"
            );
        }

        if (cantidadEstimadaAsistentes < 0) {
            throw new IllegalArgumentException(
                "La cantidad estimada de asistentes no puede ser negativa"
            );
        }

        this.codigo = codigo;
        this.nombreArtistico = nombreArtistico;
        this.generoMusical = generoMusical;
        this.duracionPresentacion = duracionPresentacion;
        this.cantidadEstimadaAsistentes = cantidadEstimadaAsistentes;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public int getDuracionPresentacion() {
        return duracionPresentacion;
    }

    public int getCantidadEstimadaAsistentes() {
        return cantidadEstimadaAsistentes;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public void setDuracionPresentacion(int duracionPresentacion) {
        if (duracionPresentacion <= 0) {
            throw new IllegalArgumentException(
                "La duración de la presentación debe ser mayor que 0."
            );
        }

        this.duracionPresentacion = duracionPresentacion;
    }

    public void setCantidadEstimadaAsistentes(int cantidadEstimadaAsistentes) {
        if (cantidadEstimadaAsistentes < 0) {
            throw new IllegalArgumentException(
                "La cantidad estimada de asistentes no puede ser negativa."
            );
        }

        this.cantidadEstimadaAsistentes = cantidadEstimadaAsistentes;
    }

    @Override
    public String toString() {
        return "Código: " + codigo
                + "\nNombre artístico: " + nombreArtistico
                + "\nGénero musical: " + generoMusical
                + "\nDuración de la presentación: " + duracionPresentacion + " minutos"
                + "\nCantidad estimada de asistentes: " + cantidadEstimadaAsistentes;
    }
}