public class Artista {
    private String codigo;
    private String nombreArtistico;
    private String generoMusical;
    private int duracionMinutos;
    private int asistentesEstimados;

    public Artista(String codigo, String nombreArtistico,
                   String generoMusical, int duracionMinutos,
                   int asistentesEstimados) {
        actualizarDatos(codigo, nombreArtistico, generoMusical,
                        duracionMinutos, asistentesEstimados);
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

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public int getAsistentesEstimados() {
        return asistentesEstimados;
    }

    public void actualizarDatos(String codigo, String nombreArtistico,
                                String generoMusical, int duracionMinutos,
                                int asistentesEstimados) {
        if (duracionMinutos <= 0) {
            throw new IllegalArgumentException(
                "La duracion debe ser mayor que 0."
            );
        }

        if (asistentesEstimados < 0) {
            throw new IllegalArgumentException(
                "La cantidad de asistentes no puede ser negativa."
            );
        }

        this.codigo = codigo;
        this.nombreArtistico = nombreArtistico;
        this.generoMusical = generoMusical;
        this.duracionMinutos = duracionMinutos;
        this.asistentesEstimados = asistentesEstimados;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo
            + " | Nombre artistico: " + nombreArtistico
            + " | Genero: " + generoMusical
            + " | Duracion: " + duracionMinutos + " minutos"
            + " | Asistentes estimados: " + asistentesEstimados;
    }
}