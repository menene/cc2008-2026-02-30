public class ControladorArtista {

    // Valida que el codigo, el nombre artistico y el genero musical no esten vacios, que la duracion sea mayor que 0 y que la cantidad estimada de asistentes no sea negativa; lanza IllegalArgumentException si alguna validacion falla, evitando registrar un artista con datos incorrectos.
    public void validarDatosArtista(String codigo, String nombreArtistico, String generoMusical, int duracionPresentacion, int cantidadEstimadaAsistentes) {
        if (codigo == null || codigo.trim().isEmpty()){
            throw new IllegalArgumentException("Codigo vacio");
        }
        if (nombreArtistico == null || nombreArtistico.trim().isEmpty()){
            throw new IllegalArgumentException("Nombre artistico vacio");
        }
        if (generoMusical == null || generoMusical.trim().isEmpty()){
            throw new IllegalArgumentException("Genero musical vacio");
        }
        if (duracionPresentacion <= 0){
            throw new IllegalArgumentException("La duracion debe ser mayor que 0");
        }
        if (cantidadEstimadaAsistentes < 0){
            throw new IllegalArgumentException("La cantidad estimada de asistentes no puede ser negativa");
        }
    }

    // Valida que la nueva duracion sea mayor que 0 y que la nueva cantidad de asistentes no sea negativa, lanzando IllegalArgumentException en caso contrario; si la validacion es correcta, actualiza el artista llamando a sus metodos set correspondientes.
    public void modificarDatosArtista(Artista artista, String nuevoNombreArtistico, String nuevoGeneroMusical, int nuevaDuracion, int nuevaCantidadAsistentes) {
        if (artista == null){
            throw new IllegalArgumentException("No existe un artista para modificar");
        }
        validarDatosArtista(artista.getCodigo(), nuevoNombreArtistico, nuevoGeneroMusical, nuevaDuracion, nuevaCantidadAsistentes);

        artista.setNombreArtistico(nuevoNombreArtistico);
        artista.setGeneroMusical(nuevoGeneroMusical);
        artista.setDuracionPresentacion(nuevaDuracion);
        artista.setCantidadEstimadaAsistentes(nuevaCantidadAsistentes);
    }
}
