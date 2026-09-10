public class Artista {

    private String codigo;
    private String nombreArtistico;
    private String generoMusical;
    private float duracionMinutos;
    private int cantidadAsistentes;

    public Artista(String codigo, String nombreArtistico,
                   String generoMusical, int duracionMinutos,
                   int cantidadAsistentes) {
        this.codigo = codigo;
        this.nombreArtistico = nombreArtistico;
        this.generoMusical = generoMusical;
        setDuracionMinutos(duracionMinutos);
        setCantidadAsistentes(cantidadAsistentes);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public int getDuracionMinutos() {
        return (int) duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        if (duracionMinutos <= 0) {
            throw new IllegalArgumentException(
                "La duración debe ser mayor que 0."
            );
        }
        this.duracionMinutos = duracionMinutos;
    }

    public int getCantidadAsistentes() {
        return cantidadAsistentes;
    }

    public void setCantidadAsistentes(int cantidadAsistentes) {
        if (cantidadAsistentes < 0) {
            throw new IllegalArgumentException(
                "La cantidad de asistentes no puede ser negativa."
            );
        }
        this.cantidadAsistentes = cantidadAsistentes;
    }
}
