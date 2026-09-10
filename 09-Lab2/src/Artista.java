public class Artista {

    // Atributos
    private String codigo;
    private String nombreArtistico;
    private String generoMusical;
    private int duracionPresentacion;
    private int cantidadEstimadaAsistentes;

    // Constructor
    public Artista(String codigo, String nombreArtistico, String generoMusical, int duracionPresentacion, int cantidadEstimadaAsistentes) {

        validarTexto(codigo, "codigo");
        validarTexto(nombreArtistico, "nombre artistico");
        validarTexto(generoMusical, "genero musical");

        this.codigo = codigo;
        this.nombreArtistico = nombreArtistico;
        this.generoMusical = generoMusical;

        setDuracionPresentacion(duracionPresentacion);
        setCantidadEstimadaAsistentes(cantidadEstimadaAsistentes);
    }

    // Getters
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

    // Setters
    public void setCodigo(String codigo) {
        validarTexto(codigo, "codigo");
        this.codigo = codigo;
    }

    public void setNombreArtistico(String nombreArtistico) {
        validarTexto(nombreArtistico, "nombre artistico");
        this.nombreArtistico = nombreArtistico;
    }

    public void setGeneroMusical(String generoMusical) {
        validarTexto(generoMusical, "genero musical");
        this.generoMusical = generoMusical;
    }

    //Setters con excepciones para validar los datos de entrada
    public void setDuracionPresentacion(int duracionPresentacion) {
        if (duracionPresentacion <= 0) {
            throw new IllegalArgumentException(
                    "La duracion de la presentacion debe ser mayor que cero."
            );
        }

        this.duracionPresentacion = duracionPresentacion;
    }

    public void setCantidadEstimadaAsistentes(
            int cantidadEstimadaAsistentes) {

        // Validación de la cantidad estimada de asistentes y excepción para el caso de que sea negativa
        if (cantidadEstimadaAsistentes < 0) {
            throw new IllegalArgumentException(
                    "La cantidad estimada de asistentes no puede ser negativa."
            );
        }

        this.cantidadEstimadaAsistentes = cantidadEstimadaAsistentes;
    }

    // Validación extra con excepción para los campos de texto
    private void validarTexto(String texto, String campo) {
        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El campo " + campo + " no puede estar vacio."
            );
        }
    }
}