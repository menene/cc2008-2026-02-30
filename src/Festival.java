import java.util.ArrayList;

public class Festival {
    private static final int MAX_ESCENARIOS = 5;

    private String nombre;
    private String codigo;
    private String nombreCoordinador;
    private Escenario[] escenarios;
    private ArrayList<Artista> artistas;

    public Festival(String nombre, String codigo, String nombreCoordinador) {
        validarTexto(nombre, "nombre del festival");
        validarTexto(codigo, "código del festival");
        validarTexto(nombreCoordinador, "nombre del coordinador");

        this.nombre = nombre.trim();
        this.codigo = codigo.trim();
        this.nombreCoordinador = nombreCoordinador.trim();
        this.escenarios = new Escenario[MAX_ESCENARIOS];
        this.artistas = new ArrayList<Artista>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombreCoordinador() {
        return nombreCoordinador;
    }

    public int getTotalPosiciones() {
        return escenarios.length;
    }

    public void configurarEscenario(int posicion, Escenario escenario) {
        validarPosicion(posicion);
        if (escenario == null) {
            throw new IllegalArgumentException("El escenario no puede ser null.");
        }
        if (escenarios[posicion] != null) {
            throw new IllegalStateException("La posición " + posicion + " ya está ocupada.");
        }
        escenarios[posicion] = escenario;
    }

    public Escenario obtenerEscenario(int posicion) {
        validarPosicion(posicion);
        return escenarios[posicion];
    }

    public void modificarEscenario(int posicion, int capacidadMaxima, String estado) {
        validarPosicion(posicion);
        Escenario escenario = escenarios[posicion];
        if (escenario == null) {
            throw new IllegalStateException("No hay un escenario configurado en la posición " + posicion + ".");
        }

        // Valida todos los datos antes de modificar el objeto original.
        Escenario datosValidados = new Escenario(
                escenario.getCodigo(), escenario.getNombre(), escenario.getUbicacion(),
                capacidadMaxima, estado);
        escenario.setCapacidadMaxima(datosValidados.getCapacidadMaxima());
        escenario.setEstado(datosValidados.getEstado());
    }

    public void retirarEscenario(int posicion) {
        validarPosicion(posicion);
        if (escenarios[posicion] == null) {
            throw new IllegalStateException("No hay un escenario configurado en la posición " + posicion + ".");
        }
        escenarios[posicion] = null;
    }

    public int contarEscenariosConfigurados() {
        int cantidad = 0;
        for (Escenario escenario : escenarios) {
            if (escenario != null) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public int contarEspaciosDisponibles() {
        return MAX_ESCENARIOS - contarEscenariosConfigurados();
    }

    public Escenario obtenerEscenarioMayorCapacidad() {
        Escenario mayor = null;
        for (Escenario escenario : escenarios) {
            if (escenario != null
                    && (mayor == null || escenario.getCapacidadMaxima() > mayor.getCapacidadMaxima())) {
                mayor = escenario;
            }
        }
        return mayor;
    }

    public void registrarArtista(Artista artista) {
        if (artista == null) {
            throw new IllegalArgumentException("El artista no puede ser null.");
        }
        if (buscarArtista(artista.getCodigo()) != null) {
            throw new IllegalArgumentException("Ya existe un artista con el código " + artista.getCodigo() + ".");
        }
        artistas.add(artista);
    }

    public ArrayList<Artista> obtenerArtistas() {
        return new ArrayList<Artista>(artistas);
    }

    public Artista buscarArtista(String codigo) {
        validarTexto(codigo, "código del artista");
        for (Artista artista : artistas) {
            if (artista.getCodigo().equalsIgnoreCase(codigo.trim())) {
                return artista;
            }
        }
        return null;
    }

    public boolean modificarArtista(String codigo, String nombreArtistico,
                                    String generoMusical, int duracion, int asistentes) {
        Artista artista = buscarArtista(codigo);
        if (artista == null) {
            return false;
        }

        // El objeto temporal hace que la operación sea atómica.
        Artista datosValidados = new Artista(
                artista.getCodigo(), nombreArtistico, generoMusical, duracion, asistentes);
        artista.setNombreArtistico(datosValidados.getNombreArtistico());
        artista.setGeneroMusical(datosValidados.getGeneroMusical());
        artista.setDuracionPresentacion(datosValidados.getDuracionPresentacion());
        artista.setCantidadEstimadaAsistentes(datosValidados.getCantidadEstimadaAsistentes());
        return true;
    }

    public boolean cancelarParticipacion(String codigo) {
        validarTexto(codigo, "código del artista");
        for (int i = 0; i < artistas.size(); i++) {
            if (artistas.get(i).getCodigo().equalsIgnoreCase(codigo.trim())) {
                artistas.remove(i);
                return true;
            }
        }
        return false;
    }

    public int contarArtistas() {
        return artistas.size();
    }

    public Artista obtenerArtistaMayorDuracion() {
        if (artistas.isEmpty()) {
            return null;
        }
        Artista mayor = artistas.get(0);
        for (int i = 1; i < artistas.size(); i++) {
            if (artistas.get(i).getDuracionPresentacion() > mayor.getDuracionPresentacion()) {
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
        int suma = 0;
        for (Artista artista : artistas) {
            suma += artista.getDuracionPresentacion();
        }
        return (double) suma / artistas.size();
    }

    private void validarPosicion(int posicion) {
        if (posicion < 0 || posicion >= escenarios.length) {
            throw new IndexOutOfBoundsException(
                    "La posición debe estar entre 0 y " + (escenarios.length - 1) + ".");
        }
    }

    private void validarTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El " + campo + " no puede estar vacío.");
        }
    }
}
