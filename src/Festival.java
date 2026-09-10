import java.util.ArrayList;

public class Festival {
    private String nombre;
    private String codigoIdentificacion;
    private String nombreCoordinador;
    private Escenario[] escenarios;
    private ArrayList<Artista> artistas;

    public Festival(String nombre, String codigoIdentificacion, String nombreCoordinador) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del festival no puede estar vacio.");
        }
        if (codigoIdentificacion == null || codigoIdentificacion.trim().isEmpty()) {
            throw new IllegalArgumentException("El codigo del festival no puede estar vacio.");
        }
        if (nombreCoordinador == null || nombreCoordinador.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del coordinador no puede estar vacio.");
        }

        this.nombre = nombre.trim();
        this.codigoIdentificacion = codigoIdentificacion.trim();
        this.nombreCoordinador = nombreCoordinador.trim();
        escenarios = new Escenario[5];
        artistas = new ArrayList<>();
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

    public int getCantidadPosicionesEscenarios() {
        return escenarios.length;
    }

    public boolean esPosicionValida(int posicion) {
        return posicion >= 0 && posicion < escenarios.length;
    }

    public boolean configurarEscenario(int posicion, Escenario escenario) {
        if (!esPosicionValida(posicion) || escenarios[posicion] != null || escenario == null) {
            return false;
        }
        escenarios[posicion] = escenario;
        return true;
    }

    public Escenario getEscenario(int posicion) {
        if (!esPosicionValida(posicion)) {
            return null;
        }
        return escenarios[posicion];
    }

    public boolean modificarEscenario(int posicion, int nuevaCapacidad, String nuevoEstado) {
        if (!esPosicionValida(posicion) || escenarios[posicion] == null) {
            return false;
        }
        if (nuevaCapacidad <= 0) {
            throw new IllegalArgumentException("La capacidad maxima debe ser mayor que 0.");
        }
        if (nuevoEstado == null || nuevoEstado.trim().isEmpty()) {
            throw new IllegalArgumentException("El estado del escenario no puede estar vacio.");
        }
        escenarios[posicion].setCapacidadMaxima(nuevaCapacidad);
        escenarios[posicion].setEstado(nuevoEstado);
        return true;
    }

    public boolean retirarEscenario(int posicion) {
        if (!esPosicionValida(posicion) || escenarios[posicion] == null) {
            return false;
        }
        escenarios[posicion] = null;
        return true;
    }

    public int contarEscenariosConfigurados() {
        int cantidad = 0;
        for (int i = 0; i < escenarios.length; i++) {
            if (escenarios[i] != null) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public int contarEspaciosDisponibles() {
        int cantidad = 0;
        for (int i = 0; i < escenarios.length; i++) {
            if (escenarios[i] == null) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public Escenario obtenerEscenarioMayorCapacidad() {
        Escenario mayor = null;
        for (int i = 0; i < escenarios.length; i++) {
            if (escenarios[i] != null
                    && (mayor == null
                    || escenarios[i].getCapacidadMaxima() > mayor.getCapacidadMaxima())) {
                mayor = escenarios[i];
            }
        }
        return mayor;
    }

    public boolean registrarArtista(Artista artista) {
        if (artista == null || buscarArtista(artista.getCodigo()) != null) {
            return false;
        }
        artistas.add(artista);
        return true;
    }

    public Artista buscarArtista(String codigo) {
        if (codigo == null) {
            return null;
        }
        for (Artista artista : artistas) {
            if (artista.getCodigo().equalsIgnoreCase(codigo.trim())) {
                return artista;
            }
        }
        return null;
    }

    public boolean modificarArtista(String codigoActual, String nuevoCodigo,
            String nuevoNombreArtistico, String nuevoGeneroMusical,
            int nuevaDuracion, int nuevaCantidadEstimada) {
        Artista artistaEncontrado = buscarArtista(codigoActual);
        if (artistaEncontrado == null) {
            return false;
        }

        Artista artistaConNuevoCodigo = buscarArtista(nuevoCodigo);
        if (artistaConNuevoCodigo != null && artistaConNuevoCodigo != artistaEncontrado) {
            return false;
        }

        artistaEncontrado.actualizarInformacion(nuevoCodigo, nuevoNombreArtistico,
                nuevoGeneroMusical, nuevaDuracion, nuevaCantidadEstimada);
        return true;
    }

    public boolean cancelarParticipacion(String codigo) {
        if (codigo == null) {
            return false;
        }
        for (int i = 0; i < artistas.size(); i++) {
            if (artistas.get(i).getCodigo().equalsIgnoreCase(codigo.trim())) {
                artistas.remove(i);
                return true;
            }
        }
        return false;
    }

    public int getCantidadArtistas() {
        return artistas.size();
    }

    public Artista getArtista(int indice) {
        if (indice < 0 || indice >= artistas.size()) {
            return null;
        }
        return artistas.get(indice);
    }

    public Artista obtenerArtistaMayorDuracion() {
        if (artistas.isEmpty()) {
            return null;
        }

        Artista mayor = artistas.get(0);
        for (int i = 1; i < artistas.size(); i++) {
            if (artistas.get(i).getDuracionPresentacion()
                    > mayor.getDuracionPresentacion()) {
                mayor = artistas.get(i);
            }
        }
        return mayor;
    }

    public Artista obtenerArtistaMayorAsistencia() {
        if (artistas.isEmpty()) {
            return null;
        }

        Artista mayor = artistas.get(0);
        for (int i = 1; i < artistas.size(); i++) {
            if (artistas.get(i).getCantidadEstimadaAsistentes()
                    > mayor.getCantidadEstimadaAsistentes()) {
                mayor = artistas.get(i);
            }
        }
        return mayor;
    }

    public double calcularPromedioDuracion() {
        if (artistas.isEmpty()) {
            return 0.0;
        }

        int sumaDuraciones = 0;
        for (Artista artista : artistas) {
            sumaDuraciones += artista.getDuracionPresentacion();
        }
        return (double) sumaDuraciones / artistas.size();
    }
}



