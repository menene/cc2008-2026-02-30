public class Artista {
    private String codigo;
    private String nombreArtistico;
    private String generoMusical;
    private int duracionPresentacion;
    private int cantidadEstimadaAsistentes;

    public Artista(String codigo, String nombreArtistico, String generoMusical,
                   int duracionPresentacion, int cantidadEstimadaAsistentes) {
        validarTexto(codigo, "código");
        validarTexto(nombreArtistico, "nombre artístico");
        validarTexto(generoMusical, "género musical");
        validarDuracion(duracionPresentacion);
        validarAsistentes(cantidadEstimadaAsistentes);

        this.codigo = codigo.trim();
        this.nombreArtistico = nombreArtistico.trim();
        this.generoMusical = generoMusical.trim();
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
        validarTexto(nombreArtistico, "nombre artístico");
        this.nombreArtistico = nombreArtistico.trim();
    }

    public void setGeneroMusical(String generoMusical) {
        validarTexto(generoMusical, "género musical");
        this.generoMusical = generoMusical.trim();
    }

    public void setDuracionPresentacion(int duracionPresentacion) {
        validarDuracion(duracionPresentacion);
        this.duracionPresentacion = duracionPresentacion;
    }

    public void setCantidadEstimadaAsistentes(int cantidadEstimadaAsistentes) {
        validarAsistentes(cantidadEstimadaAsistentes);
        this.cantidadEstimadaAsistentes = cantidadEstimadaAsistentes;
    }

    @Override
    public String toString() {
        return "Código: " + codigo
                + " | Nombre artístico: " + nombreArtistico
                + " | Género: " + generoMusical
                + " | Duración: " + duracionPresentacion + " minutos"
                + " | Asistentes estimados: " + cantidadEstimadaAsistentes;
    }

    private void validarTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El " + campo + " del artista no puede estar vacío.");
        }
    }

    private void validarDuracion(int duracionPresentacion) {
        if (duracionPresentacion <= 0) {
            throw new IllegalArgumentException("La duración debe ser mayor que 0 minutos.");
        }
    }

    private void validarAsistentes(int cantidadEstimadaAsistentes) {
        if (cantidadEstimadaAsistentes < 0) {
            throw new IllegalArgumentException("La cantidad estimada de asistentes no puede ser negativa.");
        }
    }
}
