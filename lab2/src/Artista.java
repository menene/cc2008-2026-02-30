public class Artista {

    private final String codigo;
    private String nombreArtistico;
    private String generoMusical;
    private double duracionPresentacion;
    private int asistentesEstimados;

    public Artista(String codigo, String nombreArtistico,
                   String generoMusical, double duracionPresentacion,
                   int asistentesEstimados) {

        this.codigo = validarTexto(codigo, "El codigo");
        setNombreArtistico(nombreArtistico);
        setGeneroMusical(generoMusical);
        setDuracionPresentacion(duracionPresentacion);
        setAsistentesEstimados(asistentesEstimados);
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

    public double getDuracionPresentacion() {
        return duracionPresentacion;
    }

    public int getAsistentesEstimados() {
        return asistentesEstimados;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = validarTexto(
                nombreArtistico,
                "El nombre artistico"
        );
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = validarTexto(
                generoMusical,
                "El genero musical"
        );
    }

    public void setDuracionPresentacion(double duracionPresentacion) {
        if (!Double.isFinite(duracionPresentacion)
                || duracionPresentacion <= 0) {

            throw new IllegalArgumentException(
                    "La duracion debe ser mayor que cero."
            );
        }

        this.duracionPresentacion = duracionPresentacion;
    }

    public void setAsistentesEstimados(int asistentesEstimados) {
        if (asistentesEstimados < 0) {
            throw new IllegalArgumentException(
                    "Los asistentes no pueden ser negativos."
            );
        }

        this.asistentesEstimados = asistentesEstimados;
    }

    private static String validarTexto(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(
                    campo + " no puede estar vacio."
            );
        }

        return valor.trim();
    }

    @Override
    public String toString() {
        return "Artista{" +
                "codigo='" + codigo + '\'' +
                ", nombreArtistico='" + nombreArtistico + '\'' +
                ", generoMusical='" + generoMusical + '\'' +
                ", duracionPresentacion=" + duracionPresentacion +
                ", asistentesEstimados=" + asistentesEstimados +
                '}';
    }
}