import java.util.ArrayList;

public class Festival {

    private String nombre;
    private String codigoIdentificacion;
    private String nombreCoordinador;
    private Escenario[] escenarios;
    private ArrayList<Artista> artistas;

    public Festival(String nombre, String codigoIdentificacion, String nombreCoordinador) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del festival no puede estar vacío.");
        }
        if (codigoIdentificacion == null || codigoIdentificacion.isBlank()) {
            throw new IllegalArgumentException("El código de identificación no puede estar vacío.");
        }
        if (nombreCoordinador == null || nombreCoordinador.isBlank()) {
            throw new IllegalArgumentException("El nombre del coordinador no puede estar vacío.");
        }
        this.nombre = nombre;
        this.codigoIdentificacion = codigoIdentificacion;
        this.nombreCoordinador = nombreCoordinador;
        this.escenarios = new Escenario[5];
        this.artistas = new ArrayList<>();
    }

    private void validarPosicion(int posicion) {
        if (posicion < 1 || posicion > escenarios.length) {
            throw new IndexOutOfBoundsException(
                    "La posición debe estar entre 1 y " + escenarios.length + ".");
        }
    }

    public boolean configurarEscenario(int posicion, Escenario escenario) {
        validarPosicion(posicion);
        if (escenario == null) {
            throw new IllegalArgumentException("El escenario no puede ser nulo.");
        }
        if (escenarios[posicion - 1] != null) {
            return false;
        }
        escenarios[posicion - 1] = escenario;
        return true;
    }

    public Escenario obtenerEscenario(int posicion) {
        validarPosicion(posicion);
        return escenarios[posicion - 1];
    }

    public boolean modificarEscenario(int posicion, int capacidad, String estado) {
        validarPosicion(posicion);
        Escenario escenario = escenarios[posicion - 1];
        if (escenario == null) {
            return false;
        }
        escenario.validarCapacidadMaxima(capacidad);
        escenario.validarEstado(estado);
        escenario.setCapacidadMaxima(capacidad);
        escenario.setEstado(estado);
        return true;
    }

    public boolean retirarEscenario(int posicion) {
        validarPosicion(posicion);
        if (escenarios[posicion - 1] == null) {
            return false;
        }
        escenarios[posicion - 1] = null;
        return true;
    }

    public boolean registrarArtista(Artista artista) {
        if (artista == null) {
            throw new IllegalArgumentException("El artista no puede ser nulo.");
        }
        if (buscarArtista(artista.getCodigo()) != null) {
            return false;
        }
        artistas.add(artista);
        return true;
    }

    public Artista buscarArtista(String codigo) {
        for (Artista artista : artistas) {
            if (artista.getCodigo().equals(codigo)) {
                return artista;
            }
        }
        return null;
    }

    public boolean modificarArtista(String codigo, String nombreArtistico, String generoMusical,
                                     int duracionPresentacion, int cantidadEstimadaAsistentes) {
        Artista artista = buscarArtista(codigo);
        if (artista == null) {
            return false;
        }
        artista.validarNombreArtistico(nombreArtistico);
        artista.validarGeneroMusical(generoMusical);
        artista.validarDuracionPresentacion(duracionPresentacion);
        artista.validarCantidadEstimadaAsistentes(cantidadEstimadaAsistentes);
        artista.setNombreArtistico(nombreArtistico);
        artista.setGeneroMusical(generoMusical);
        artista.setDuracionPresentacion(duracionPresentacion);
        artista.setCantidadEstimadaAsistentes(cantidadEstimadaAsistentes);
        return true;
    }

    public boolean cancelarParticipacion(String codigo) {
        Artista artista = buscarArtista(codigo);
        if (artista == null) {
            return false;
        }
        artistas.remove(artista);
        return true;
    }

    public int cantidadEscenariosConfigurados() {
        int cuenta = 0;
        for (Escenario escenario : escenarios) {
            if (escenario != null) {
                cuenta++;
            }
        }
        return cuenta;
    }

    public int cantidadEspaciosDisponibles() {
        return escenarios.length - cantidadEscenariosConfigurados();
    }

    public Escenario escenarioMayorCapacidad() {
        Escenario mayor = null;
        for (Escenario escenario : escenarios) {
            if (escenario != null && (mayor == null || escenario.getCapacidadMaxima() > mayor.getCapacidadMaxima())) {
                mayor = escenario;
            }
        }
        return mayor;
    }

    public int cantidadArtistasRegistrados() {
        return artistas.size();
    }

    public Artista artistaMayorDuracion() {
        if (artistas.isEmpty()) {
            return null;
        }
        Artista mayor = artistas.get(0);
        for (Artista artista : artistas) {
            if (artista.getDuracionPresentacion() > mayor.getDuracionPresentacion()) {
                mayor = artista;
            }
        }
        return mayor;
    }

    public Artista artistaMayorAsistencia() {
        if (artistas.isEmpty()) {
            return null;
        }
        Artista mayor = artistas.get(0);
        for (Artista artista : artistas) {
            if (artista.getCantidadEstimadaAsistentes() > mayor.getCantidadEstimadaAsistentes()) {
                mayor = artista;
            }
        }
        return mayor;
    }

    public double promedioDuracionPresentaciones() {
        if (artistas.isEmpty()) {
            return 0.0;
        }
        int sumaDuraciones = 0;
        for (Artista artista : artistas) {
            sumaDuraciones += artista.getDuracionPresentacion();
        }
        return (double) sumaDuraciones / artistas.size();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigoIdentificacion() {
        return codigoIdentificacion;
    }

    public String getNombreCoordinador() {
        return nombreCoordinador;
    }

    public Escenario[] getEscenarios() {
        Escenario[] copia = new Escenario[escenarios.length];
        for (int i = 0; i < escenarios.length; i++) {
            copia[i] = escenarios[i];
        }
        return copia;
    }

    public ArrayList<Artista> getArtistas() {
        return new ArrayList<>(artistas);
    }
}