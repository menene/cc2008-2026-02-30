public class Artista {

    private String codigoArt;
    private String nombreArt;
    private String generoArt;
    private int duracionArt;
    private int asistentesArt;

    public Artista(String codigoArt, String nombreArt, String generoArt,
                    int duracionArt, int asistentesArt) {
        if (duracionArt <= 0) {
            throw new IllegalArgumentException("La duración de la presentación debe ser mayor que 0");
        }
        if (asistentesArt < 0) {
            throw new IllegalArgumentException("La cantidad estimada de asistentes no puede ser negativa");
        }
        this.codigoArt = codigoArt;
        this.nombreArt = nombreArt;
        this.generoArt = generoArt;
        this.duracionArt = duracionArt;
        this.asistentesArt = asistentesArt;
    }

//getters y setters de artista
    public String getCodigo() {
        return codigoArt;
    }

    public String getNombreArtistico() {
        return nombreArt;
    }

    public String getGeneroMusical() {
        return generoArt;
    }

    public int getDuracionPresentacion() {
        return duracionArt;
    }

    public int getCantidadEstimadaAsistentes() {
        return asistentesArt;
    }

    public void setNombreArtistico(String nombreArt) {
        this.nombreArt = nombreArt;
    }

    public void setGeneroMusical(String generoArt) {
        this.generoArt = generoArt;
    }

    public void setDuracionPresentacion(int duracionArt) {
        if (duracionArt <= 0) {
            throw new IllegalArgumentException("La duración de la presentación debe ser mayor que 0");
        }
        this.duracionArt = duracionArt;
    }

    public void setCantidadAsistentes(int asistentesArt) {
        if (asistentesArt < 0) {
            throw new IllegalArgumentException("La cantidad estimada de asistentes no puede ser negativa");
        }
        this.asistentesArt = asistentesArt;
    }
}
