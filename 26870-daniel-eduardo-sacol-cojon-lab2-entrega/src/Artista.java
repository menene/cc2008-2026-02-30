public class Artista {
    private int id;
    private String nombreArtistico;
    private String generoMusical;
    private double duracionPresentacion;
    private int estAsistente;

    public Artista(int id, String nombreArtistico, String generoMusical, double duracionPresentacion, int estAsistente) {
        if (duracionPresentacion <= 0) {
            throw new IllegalArgumentException("La duración de la presentación debe ser mayor que 0.");
        }
        if (estAsistente < 0) {
            throw new IllegalArgumentException("La cantidad estimada de asistentes no puede ser negativa.");
        }
        this.id = id;
        this.nombreArtistico = nombreArtistico;
        this.generoMusical = generoMusical;
        this.duracionPresentacion = duracionPresentacion;
        this.estAsistente = estAsistente;
    }

    public int getId() { return id; }
    public String getNombreArtistico() { return nombreArtistico; }
    public String getGeneroMusical() { return generoMusical; }
    public double getDuracionPresentacion() { return duracionPresentacion; }
    public int getEstAsistente() { return estAsistente; }

    public void setNombreArtistico(String nombreArtistico) { this.nombreArtistico = nombreArtistico; }
    public void setGeneroMusical(String generoMusical) { this.generoMusical = generoMusical; }
    
    public void setDuracionPresentacion(double duracionPresentacion) { 
        if (duracionPresentacion <= 0) throw new IllegalArgumentException("La duración debe ser mayor que 0.");
        this.duracionPresentacion = duracionPresentacion; 
    }
    
    public void setEstAsistente(int estAsistente) { 
        if (estAsistente < 0) throw new IllegalArgumentException("Los asistentes no pueden ser negativos.");
        this.estAsistente = estAsistente; 
    }

    @Override
    public String toString() {
        return "Artista [Código: " + id + " | Nombre: " + nombreArtistico + 
               " | Género: " + generoMusical + " | Duración: " + duracionPresentacion + " min | Asistentes: " + estAsistente + "]";
    }
}