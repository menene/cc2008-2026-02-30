public class Artista {
    private String codigoArtista;
    private String nombreArtistico;
    private String generoMusical;
    private float duracionPresentacion;
    private int asistentes;
    private String escenario;

    public Artista(String codigoArtista, String nombreArtistico, String generoMusical, float duracionPresentacion, int asistentes, String escenario) {
        if (codigoArtista.isEmpty()) {
            throw new IllegalArgumentException("El código del artista no puede estar vacío");
        }
        
        if (nombreArtistico.isEmpty()) {
            throw new IllegalArgumentException("El nombre artístico no puede estar vacío");
        }

        if (nombreArtistico.isEmpty()) {
            throw new IllegalArgumentException("El género musical no puede estar vacío");
        }

        validarDuracion(duracionPresentacion);
        validarAsistentes(asistentes);

        this.codigoArtista = codigoArtista;
        this.nombreArtistico = nombreArtistico;
        this.generoMusical = generoMusical;
        this.duracionPresentacion = duracionPresentacion;
        this.asistentes = asistentes;
        this.escenario = escenario;
    }

    public String getCodigoArtista() {
        return codigoArtista;
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public float getDuracionPresentacion() {
        return duracionPresentacion;
    }

    public int getAsistentes() {
        return asistentes;
    }

    public String getCodigoEscenario() {
        return escenario;
    }

    public void setNombreArtistico(String nombreArtistico) {
        if (nombreArtistico == null || nombreArtistico.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "El nombre artístico no puede estar vacío."
            );
        }

        this.nombreArtistico = nombreArtistico;
    }

    public void setGeneroMusical(String generoMusical) {
        if (generoMusical == null || generoMusical.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "El género musical no puede estar vacío."
            );
        }

        this.generoMusical = generoMusical;
    }

    public void setDuracionPresentacion(float duracionPresentacion) {
        validarDuracion(duracionPresentacion);
        this.duracionPresentacion = duracionPresentacion;
    }

    public void setAsistentes(int asistentes) {
        validarAsistentes(asistentes);
        this.asistentes = asistentes;
    }

    public void setCodigoEscenario(String codigo) {
        this.escenario = codigo;
    }

    private void validarDuracion(float numero) {
        if (numero <= 0) {
            throw new IllegalArgumentException("La duración debe ser mayor que 0.");
        }
    }

    private void validarAsistentes(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException(
                "La cantidad de asistentes no puede ser negativa."
            );
        }
    }

    @Override
    public String toString() {
        return String.format("""
                +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-
                Código: %s
                Nombre artístico: %s
                Género musical: %s
                Duración: %.2f minutos
                Asistentes estimados: %d
                Escenario: %s
                +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-
                """,
            codigoArtista,
            nombreArtistico,
            generoMusical,
            duracionPresentacion,
            asistentes,
            escenario.isEmpty()
                ? "Sin asignar"
                : escenario
        );
    }
}
