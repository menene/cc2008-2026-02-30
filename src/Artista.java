public class Artista {
    private String codigo;
    private String nombreArtistico;
    private String generoMusical;
    private int duracionPresentacion;
    private int cantidadEstimadaAsistentes;

    // Crea un artista con sus datos iniciales; el usuario indica el codigo, que debe ser unico entre los artistas registrados.
    public Artista(String codigo, String nombreArtistico, String generoMusical, int duracionPresentacion, int cantidadEstimadaAsistentes) {
        this.codigo = codigo;
        this.nombreArtistico = nombreArtistico;
        this.generoMusical = generoMusical;
        this.duracionPresentacion = duracionPresentacion;
        this.cantidadEstimadaAsistentes = cantidadEstimadaAsistentes;
    }

    // Retorna el codigo del artista; es el valor que se usa para buscar, modificar y cancelar la participacion de un artista dentro de la coleccion dinamica.
    public String getCodigo() {
        return codigo;
    }

    // Retorna el nombre artistico registrado.
    public String getNombreArtistico() {
        return nombreArtistico;
    }

    // Permite modificar el nombre artistico de un artista ya registrado.
    public void setNombreArtistico(String nuevoNombre) {
        this.nombreArtistico = nuevoNombre;
    }

    // Retorna el genero musical registrado.
    public String getGeneroMusical() {
        return generoMusical;
    }

    // Permite modificar el genero musical de un artista ya registrado.
    public void setGeneroMusical(String nuevoGenero) {
        this.generoMusical = nuevoGenero;
    }

    // Retorna la duracion actual de la presentacion; es el valor que se recorre para calcular el promedio de duracion y el artista con la presentacion mas larga.
    public int getDuracionPresentacion() {
        return duracionPresentacion;
    }

    // Permite modificar la duracion de la presentacion de un artista ya registrado.
    public void setDuracionPresentacion(int nuevaDuracion) {
        this.duracionPresentacion = nuevaDuracion;
    }

    // Retorna la cantidad estimada de asistentes actual; es el valor que se recorre para determinar el artista con mayor cantidad estimada de asistentes.
    public int getCantidadEstimadaAsistentes() {
        return cantidadEstimadaAsistentes;
    }

    // Permite modificar la cantidad estimada de asistentes de un artista ya registrado.
    public void setCantidadEstimadaAsistentes(int nuevaCantidad) {
        this.cantidadEstimadaAsistentes = nuevaCantidad;
    }
}
