public class Artista {

    private String codigo;
    private String nombreArtistico;
    private String generoMusical;
    private int duracionPresentacion;
    private int cantidadEstimadaAsistentes;

    public Artista(String codigo, String nombreArtistico, String generoMusical,
                    int duracionPresentacion, int cantidadEstimadaAsistentes) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código del artista no puede estar vacío.");
        }
        if (nombreArtistico == null || nombreArtistico.isBlank()) {
            throw new IllegalArgumentException("El nombre artístico no puede estar vacío.");
        }
        if (generoMusical == null || generoMusical.isBlank()) {
            throw new IllegalArgumentException("El género musical no puede estar vacío.");
        }
        if (duracionPresentacion <= 0) {
            throw new IllegalArgumentException("La duración de la presentación debe ser mayor que 0.");
        }
        if (cantidadEstimadaAsistentes < 0) {
            throw new IllegalArgumentException("La cantidad estimada de asistentes no puede ser negativa.");
        }
        this.codigo = codigo;
        this.nombreArtistico = nombreArtistico;
        this.generoMusical = generoMusical;
        this.duracionPresentacion = duracionPresentacion;
        this.cantidadEstimadaAsistentes = cantidadEstimadaAsistentes;
    }

    public void validarNombreArtistico(String nombreArtistico) {
        if (nombreArtistico == null || nombreArtistico.isBlank()) {
            throw new IllegalArgumentException("El nombre artístico no puede estar vacío.");
        }
    }

    public void validarGeneroMusical(String generoMusical) {
        if (generoMusical == null || generoMusical.isBlank()) {
            throw new IllegalArgumentException("El género musical no puede estar vacío.");
        }
    }

    public void validarDuracionPresentacion(int duracionPresentacion) {
        if (duracionPresentacion <= 0) {
            throw new IllegalArgumentException("La duración de la presentación debe ser mayor que 0.");
        }
    }

    public void validarCantidadEstimadaAsistentes(int cantidadEstimadaAsistentes) {
        if (cantidadEstimadaAsistentes < 0) {
            throw new IllegalArgumentException("La cantidad estimada de asistentes no puede ser negativa.");
        }
    }

    @Override
    public String toString() {
        return "Código: " + codigo
                + " | Nombre artístico: " + nombreArtistico
                + " | Género: " + generoMusical
                + " | Duración: " + duracionPresentacion + " min"
                + " | Asistentes estimados: " + cantidadEstimadaAsistentes;
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
        validarNombreArtistico(nombreArtistico);
        this.nombreArtistico = nombreArtistico;
    }

    public void setGeneroMusical(String generoMusical) {
        validarGeneroMusical(generoMusical);
        this.generoMusical = generoMusical;
    }

    public void setDuracionPresentacion(int duracionPresentacion) {
        validarDuracionPresentacion(duracionPresentacion);
        this.duracionPresentacion = duracionPresentacion;
    }

    public void setCantidadEstimadaAsistentes(int cantidadEstimadaAsistentes) {
        validarCantidadEstimadaAsistentes(cantidadEstimadaAsistentes);
        this.cantidadEstimadaAsistentes = cantidadEstimadaAsistentes;
    }
}