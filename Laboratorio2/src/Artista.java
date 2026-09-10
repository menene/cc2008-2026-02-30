public class Artista {

    private String codigo;
    private String nombreArtistico;
    private String generoMusical;
    private int tiempoPresentacion;
    private int publico;

    public Artista(
            String codigo,
            String nombreArtistico,
            String generoMusical,
            int tiempoPresentacion,
            int publico) {

        validarDuracion(tiempoPresentacion);
        validarAsistentes(publico);

        this.codigo = codigo;
        this.nombreArtistico = nombreArtistico;
        this.generoMusical = generoMusical;
        this.tiempoPresentacion = tiempoPresentacion;
        this.publico = publico;
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

    public int getTiempoPresentacion() {
        return tiempoPresentacion;
    }

    public int getPublico() {
        return publico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public void setTiempoPresentacion(int tiempoPresentacion) {
        validarDuracion(tiempoPresentacion);
        this.tiempoPresentacion = tiempoPresentacion;
    }

    public void setPublico(int publico) {
        validarAsistentes(publico);
        this.publico = publico;
    }

    private void validarDuracion(int duracion) {
        if (duracion <= 0) {
            throw new IllegalArgumentException(
                "El tiempo de presentación debe ser mayor que cero."
            );
        }
    }

    private void validarAsistentes(int asistentes) {
        if (asistentes < 0) {
            throw new IllegalArgumentException(
                "La cantidad estimada de público no puede ser negativa."
            );
        }
    }

    @Override
    public String toString() {
        return "Código: " + codigo
                + "\nNombre artístico: " + nombreArtistico
                + "\nGénero musical: " + generoMusical
                + "\nTiempo de presentación: "
                + tiempoPresentacion + " minutos"
                + "\nPúblico estimado: " + publico;
    }
}