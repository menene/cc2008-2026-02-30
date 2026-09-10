public class Artista {
    private String codigo;
    private String nombreArtistico;
    private String generoMusical;
    private int duracionPresentacion;
    private int cantidadEstimadaAsistentes;

    public Artista(String codigo, String nombreArtistico, String generoMusical,
            int duracionPresentacion, int cantidadEstimadaAsistentes) {
        actualizarInformacion(codigo, nombreArtistico, generoMusical,
                duracionPresentacion, cantidadEstimadaAsistentes);
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

    public int getDuracionPresentacion() {
        return duracionPresentacion;
    }

    public int getCantidadEstimadaAsistentes() {
        return cantidadEstimadaAsistentes;
    }

    public void actualizarInformacion(String nuevoCodigo, String nuevoNombreArtistico,
            String nuevoGeneroMusical, int nuevaDuracion, int nuevaCantidadEstimada) {
        if (nuevoCodigo == null || nuevoCodigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El codigo del artista no puede estar vacio.");
        }
        if (nuevoNombreArtistico == null || nuevoNombreArtistico.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre artistico no puede estar vacio.");
        }
        if (nuevoGeneroMusical == null || nuevoGeneroMusical.trim().isEmpty()) {
            throw new IllegalArgumentException("El genero musical no puede estar vacio.");
        }
        if (nuevaDuracion <= 0) {
            throw new IllegalArgumentException("La duracion debe ser mayor que 0.");
        }
        if (nuevaCantidadEstimada < 0) {
            throw new IllegalArgumentException("La cantidad estimada de asistentes no puede ser negativa.");
        }

        codigo = nuevoCodigo.trim();
        nombreArtistico = nuevoNombreArtistico.trim();
        generoMusical = nuevoGeneroMusical.trim();
        duracionPresentacion = nuevaDuracion;
        cantidadEstimadaAsistentes = nuevaCantidadEstimada;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo
                + "\nNombre artistico: " + nombreArtistico
                + "\nGenero musical: " + generoMusical
                + "\nDuracion: " + duracionPresentacion + " minutos"
                + "\nCantidad estimada de asistentes: " + cantidadEstimadaAsistentes;
    }
}
