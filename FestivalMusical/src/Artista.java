/* Clase del artista. Guarda los datos de su presentacion y valida duracion y asistentes. */
public class Artista {

    private String codigo;
    private String nombreArtistico;
    private String generoMusical;
    private int duracionMinutos;
    private int asistentesEstimados;

    /* Constructor. Revisa que la duracion sea mayor que 0 y que los asistentes no sean negativos */
    public Artista(String codigo, String nombreArtistico, String generoMusical, int duracionMinutos, int asistentesEstimados) {
        if (duracionMinutos <= 0) {
            throw new IllegalArgumentException("La duracion de la presentacion debe ser mayor que 0");
        }

        if (asistentesEstimados < 0) {
            throw new IllegalArgumentException("Los asistentes estimados no pueden ser negativos");
        }

        this.codigo = codigo;
        this.nombreArtistico = nombreArtistico;
        this.generoMusical = generoMusical;
        this.duracionMinutos = duracionMinutos;
        this.asistentesEstimados = asistentesEstimados;
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

    /* Cambia el nombre artistico de un artista ya registrado */
    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    /* Cambia el genero musical de un artista ya registrado */
    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    /* Cambia la duracion. Vuelve a revisar que sea mayor que 0, igual que en el constructor */
    public void setDuracionMinutos(int duracionMinutos) {
        if (duracionMinutos <= 0) {
            throw new IllegalArgumentException("La duracion de la presentacion debe ser mayor que 0");
        }

        this.duracionMinutos = duracionMinutos;
    }

    /* Cambia los asistentes esperados. Vuelve a revisar que no sean negativos */
    public void setAsistentesEstimados(int asistentesEstimados) {
        if (asistentesEstimados < 0) {
            throw new IllegalArgumentException("Los asistentes estimados no pueden ser negativos");
        }

        this.asistentesEstimados = asistentesEstimados;
    }

    /* Junta todos los datos del artista en un solo texto */
    public String toString() {
        return codigo + " - " + nombreArtistico
                + " | Genero: " + generoMusical
                + " | Duracion: " + duracionMinutos + " minutos"
                + " | Asistentes estimados: " + asistentesEstimados;
    }
}
