public class Artista {
    private String codigo;
    private String nombreArtistico;
    private String generoMusical;
    private int duracionPresentacion;
    private int cantidadEstimadaAsistentes;

    //constructor
    public Artista(String codigo, String nombreArtistico, String generoMusical,
                   int duracionPresentacion, int cantidadEstimadaAsistentes) {

        //no puede ser menor que 0
        if (duracionPresentacion <= 0) {
            throw new IllegalArgumentException(
                "La duración de la presentación debe ser mayor que 0."
            );
        }

        //tampoco puede ser menor que 0, pero si pueden ser 0 asistentes
        if (cantidadEstimadaAsistentes < 0) {
            throw new IllegalArgumentException(
                "La cantidad estimada de asistentes no puede ser negativa."
            );
        }

        this.codigo = codigo;
        this.nombreArtistico = nombreArtistico;
        this.generoMusical = generoMusical;
        this.duracionPresentacion = duracionPresentacion;
        this.cantidadEstimadaAsistentes = cantidadEstimadaAsistentes;
    }

    //getters
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

    //setters
    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public void setDuracionPresentacion(int duracionPresentacion) {
        
        //tiene que ser mayor que 0
        if (duracionPresentacion <= 0) {
            throw new IllegalArgumentException(
                "La duración de la presentación debe ser mayor que 0."
            );
        }

        this.duracionPresentacion = duracionPresentacion;
    }

    public void setCantidadEstimadaAsistentes(int cantidadEstimadaAsistentes) {
        
        //puede ser 0 pero no menor
        if (cantidadEstimadaAsistentes < 0) {
            throw new IllegalArgumentException(
                "La cantidad estimada de asistentes no puede ser negativa."
            );
        }

        this.cantidadEstimadaAsistentes = cantidadEstimadaAsistentes;
    }
}