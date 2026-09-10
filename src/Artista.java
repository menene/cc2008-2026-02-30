public class Artista {

    public int codigoArtista;
    public String nombreArtista;
    public String generoMusicalArtista;
    public int duracionPresentacionArtista;
    public int estimacionAsistentesArtista;

    public Artista(int codigoArtista, String nombreArtista, String generoMusicalArtista, int duracionPresentacionArtista, int estimacionAsistentesArtista) {

        validarTexto(nombreArtista, "El nombre del artista no puede estar vacio.");
        validarTexto(generoMusicalArtista, "El genero musical no puede estar vacio.");

        if (duracionPresentacionArtista <= 0) {
            throw new IllegalArgumentException("La duracion de la presentacion debe ser mayor que 0.");
        }

        if (estimacionAsistentesArtista < 0) {
            throw new IllegalArgumentException("La estimacion de asistentes no puede ser negativa.");
        }

        this.codigoArtista = codigoArtista;
        this.nombreArtista = nombreArtista;
        this.generoMusicalArtista = generoMusicalArtista;
        this.duracionPresentacionArtista = duracionPresentacionArtista;
        this.estimacionAsistentesArtista = estimacionAsistentesArtista;
    }

    private void validarTexto(String texto, String mensaje) {

        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException(mensaje);
        }
    }

    public String toString() {

        return "Codigo: " + codigoArtista
            + " | Artista: " + nombreArtista
            + " | Genero: " + generoMusicalArtista
            + " | Duracion: " + duracionPresentacionArtista + " minutos"
            + " | Asistentes estimados: " + estimacionAsistentesArtista;
    }
}
