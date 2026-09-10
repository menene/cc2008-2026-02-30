import java.util.ArrayList;

public class Festival {

    public String nombreFestival;
    private String nombreCoordinador;
    private int codigoIdentificacion;
    public Escenario[] escenarios;
    private ArrayList<Artista> artistas;

    public Festival(String nombreFestival, String nombreCoordinador, int codigoIdentificacion) {

        validarTexto(nombreFestival, "El nombre del festival no puede estar vacio.");
        validarTexto(nombreCoordinador, "El nombre del coordinador no puede estar vacio.");

        this.nombreFestival = nombreFestival;
        this.nombreCoordinador = nombreCoordinador;
        this.codigoIdentificacion = codigoIdentificacion;
        escenarios = new Escenario[5];
        artistas = new ArrayList<Artista>();
    }

    public boolean VerificarPosicionEscenario(int posicion) {

        return posicion >= 0 && posicion < escenarios.length;
    }

    public boolean VerificarDisponibilidadEscenario(int posicion) {

        return VerificarPosicionEscenario(posicion) && escenarios[posicion] == null;
    }

    public boolean VerificarInformacionEscenario(int capacidadEscenario) {

        return capacidadEscenario > 0;
    }

    public void ConfigurarEscenario(int posicion, Escenario escenario) {

        if (!VerificarPosicionEscenario(posicion)) {
            throw new IllegalArgumentException("La posicion debe estar entre 1 y 5.");
        }

        if (!VerificarDisponibilidadEscenario(posicion)) {
            throw new IllegalArgumentException("La posicion seleccionada ya esta ocupada.");
        }

        if (escenario == null || !VerificarInformacionEscenario(escenario.capacidadEscenario)) {
            throw new IllegalArgumentException("La informacion del escenario no es valida.");
        }

        escenarios[posicion] = escenario;
    }

    public Escenario ConsultarEscenario(int posicion) {

        if (!VerificarPosicionEscenario(posicion)) {
            throw new IllegalArgumentException("La posicion debe estar entre 1 y 5.");
        }

        return escenarios[posicion];
    }

    public Escenario[] ConsultarTodosEscenarios() {

        return escenarios;
    }

    public void ModificarCapacidadEscenario(Escenario escenario, int capacidadEscenario) {

        if (escenario == null) {
            throw new IllegalArgumentException("No existe un escenario en esa posicion.");
        }

        escenario.cambiarCapacidad(capacidadEscenario);
    }

    public void ModificarEstadoEscenario(Escenario escenario, String estadoEscenario) {

        if (escenario == null) {
            throw new IllegalArgumentException("No existe un escenario en esa posicion.");
        }

        escenario.cambiarEstado(estadoEscenario);
    }

    public void RetirarEscenario(Escenario escenario) {

        if (escenario == null) {
            throw new IllegalArgumentException("No existe un escenario en esa posicion.");
        }

        for (int posicion = 0; posicion < escenarios.length; posicion++) {
            if (escenarios[posicion] == escenario) {
                escenarios[posicion] = null;
                return;
            }
        }

        throw new IllegalArgumentException("El escenario no pertenece al festival.");
    }

    public boolean VerificarDuracionArtista(Artista artista) {

        return artista != null && artista.duracionPresentacionArtista > 0;
    }

    public void RegistrarArtista(String nombreArtista, int codigoArtista, String generoMusicalArtista, int duracionPresentacionArtista, int estimacionAsistentesArtista) {

        if (BuscarArtista(codigoArtista) != null) {
            throw new IllegalArgumentException("Ya existe un artista con ese codigo.");
        }

        Artista artista = new Artista(codigoArtista, nombreArtista, generoMusicalArtista, duracionPresentacionArtista, estimacionAsistentesArtista);

        if (!VerificarDuracionArtista(artista)) {
            throw new IllegalArgumentException("La duracion de la presentacion debe ser mayor que 0.");
        }

        artistas.add(artista);
    }

    public String ConsultarTodosArtistas() {

        if (artistas.isEmpty()) {
            return "No hay artistas registrados.";
        }

        String resultado = "";

        for (int posicion = 0; posicion < artistas.size(); posicion++) {
            resultado += (posicion + 1) + ". " + artistas.get(posicion).toString();

            if (posicion < artistas.size() - 1) {
                resultado += "\n";
            }
        }

        return resultado;
    }

    public Artista BuscarArtista(Artista artista) {

        if (artista == null) {
            return null;
        }

        return BuscarArtista(artista.codigoArtista);
    }

    public Artista BuscarArtista(int codigoArtista) {

        for (int posicion = 0; posicion < artistas.size(); posicion++) {
            if (artistas.get(posicion).codigoArtista == codigoArtista) {
                return artistas.get(posicion);
            }
        }

        return null;
    }

    public void ModificarArtista(Artista artista) {

        Artista artistaActual = BuscarArtista(artista);

        if (artistaActual == null) {
            throw new IllegalArgumentException("El artista no se encuentra registrado.");
        }

        artistaActual.nombreArtista = artista.nombreArtista;
        artistaActual.generoMusicalArtista = artista.generoMusicalArtista;
        artistaActual.duracionPresentacionArtista = artista.duracionPresentacionArtista;
        artistaActual.estimacionAsistentesArtista = artista.estimacionAsistentesArtista;
    }

    public void ModificarArtista(int codigoActual, Artista artista) {

        Artista artistaActual = BuscarArtista(codigoActual);

        if (artistaActual == null) {
            throw new IllegalArgumentException("El artista no se encuentra registrado.");
        }

        Artista artistaConMismoCodigo = BuscarArtista(artista.codigoArtista);

        if (artistaConMismoCodigo != null && artistaConMismoCodigo != artistaActual) {
            throw new IllegalArgumentException("Ya existe un artista con el nuevo codigo.");
        }

        artistaActual.codigoArtista = artista.codigoArtista;
        artistaActual.nombreArtista = artista.nombreArtista;
        artistaActual.generoMusicalArtista = artista.generoMusicalArtista;
        artistaActual.duracionPresentacionArtista = artista.duracionPresentacionArtista;
        artistaActual.estimacionAsistentesArtista = artista.estimacionAsistentesArtista;
    }

    public void CancelarArtista(Artista artista) {

        if (artista == null || !artistas.remove(artista)) {
            throw new IllegalArgumentException("El artista no se encuentra registrado.");
        }
    }

    public int cantidadEscenariosConfigurados() {

        int cantidad = 0;

        for (int posicion = 0; posicion < escenarios.length; posicion++) {
            if (escenarios[posicion] != null) {
                cantidad++;
            }
        }

        return cantidad;
    }

    public int cantidadEspaciosDisponibles() {

        return escenarios.length - cantidadEscenariosConfigurados();
    }

    public Escenario escenarioMayorCapacidad() {

        Escenario mayor = null;

        for (int posicion = 0; posicion < escenarios.length; posicion++) {
            if (escenarios[posicion] != null && (mayor == null || escenarios[posicion].capacidadEscenario > mayor.capacidadEscenario)) {
                mayor = escenarios[posicion];
            }
        }

        return mayor;
    }

    public int cantidadArtistasRegistrados() {

        return artistas.size();
    }

    public Artista artistaMayorDuracion() {

        Artista mayor = null;

        for (int posicion = 0; posicion < artistas.size(); posicion++) {
            Artista artista = artistas.get(posicion);

            if (mayor == null || artista.duracionPresentacionArtista > mayor.duracionPresentacionArtista) {
                mayor = artista;
            }
        }

        return mayor;
    }

    public Artista artistaMayorAsistencia() {

        Artista mayor = null;

        for (int posicion = 0; posicion < artistas.size(); posicion++) {
            Artista artista = artistas.get(posicion);

            if (mayor == null || artista.estimacionAsistentesArtista > mayor.estimacionAsistentesArtista) {
                mayor = artista;
            }
        }

        return mayor;
    }

    public double promedioDuracionPresentaciones() {

        if (artistas.isEmpty()) {
            return 0;
        }

        int duracionTotal = 0;

        for (int posicion = 0; posicion < artistas.size(); posicion++) {
            duracionTotal += artistas.get(posicion).duracionPresentacionArtista;
        }

        return (double) duracionTotal / artistas.size();
    }

    public String getNombreCoordinador() {

        return nombreCoordinador;
    }

    public int getCodigoIdentificacion() {

        return codigoIdentificacion;
    }

    private void validarTexto(String texto, String mensaje) {

        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException(mensaje);
        }
    }
}
