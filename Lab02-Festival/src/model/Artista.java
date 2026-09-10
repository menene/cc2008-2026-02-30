package model;

public class Artista {
    private final int codigo;
    private String nombreArtistico;
    private String generoMusical;
    private int duracionPresentacion;
    private int cantidadEstimadaAsistentes;

    public Artista(int codigo, String nombreArtistico, String generoMusical,
                   int duracionPresentacion, int cantidadEstimadaAsistentes) {
        this.codigo = codigo;
        setNombreArtistico(nombreArtistico);
        setGeneroMusical(generoMusical);
        setDuracionPresentacion(duracionPresentacion);
        setCantidadEstimadaAsistentes(cantidadEstimadaAsistentes);
    }

    private static String validarTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " no puede estar vacío.");
        }
        return valor.trim();
    }

    public int getCodigo() { 
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

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = validarTexto(nombreArtistico, "El nombre artístico");
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = validarTexto(generoMusical, "El género musical");
    }

    public void setDuracionPresentacion(int duracionPresentacion) {
        if (duracionPresentacion <= 0) {
            throw new IllegalArgumentException("La duración debe ser mayor que 0 minutos.");
        }
        this.duracionPresentacion = duracionPresentacion;
    }

    public void setCantidadEstimadaAsistentes(int cantidadEstimadaAsistentes) {
        if (cantidadEstimadaAsistentes < 0) {
            throw new IllegalArgumentException("La cantidad estimada de asistentes no puede ser negativa.");
        }
        this.cantidadEstimadaAsistentes = cantidadEstimadaAsistentes;
    }

    @Override
    public String toString() {
        return String.format("Código: %d | Artista: %s | Género: %s | Duración: %d min | Asistentes: %d",
                codigo, nombreArtistico, generoMusical, duracionPresentacion,
                cantidadEstimadaAsistentes);
    }
}
