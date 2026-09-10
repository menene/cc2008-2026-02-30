import java.util.ArrayList;
import java.util.List;

public class Festival {

    private static final int MAXIMO_ESCENARIOS = 5;

    private final String nombre;
    private final String codigo;
    private final String coordinador;
    private final Escenario[] escenarios;
    private final ArrayList<Artista> artistas;

    public Festival(String nombre, String codigo, String coordinador) {
        this.nombre = validarTexto(
                nombre,
                "El nombre del festival"
        );

        this.codigo = validarTexto(
                codigo,
                "El codigo del festival"
        );

        this.coordinador = validarTexto(
                coordinador,
                "El coordinador"
        );

        escenarios = new Escenario[MAXIMO_ESCENARIOS];
        artistas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCoordinador() {
        return coordinador;
    }

    public void configurarEscenario(int posicion,
                                    Escenario escenario) {

        int indice = convertirPosicionAIndice(posicion);

        if (escenario == null) {
            throw new IllegalArgumentException(
                    "El escenario no puede ser null."
            );
        }

        if (escenarios[indice] != null) {
            throw new IllegalStateException(
                    "La posicion " + posicion + " ya esta ocupada."
            );
        }

        if (buscarEscenarioPorCodigo(escenario.getCodigo()) != null) {
            throw new IllegalArgumentException(
                    "Ya existe un escenario con el codigo "
                            + escenario.getCodigo() + "."
            );
        }

        escenarios[indice] = escenario;
    }

    public List<Escenario> consultarEscenarios() {
        ArrayList<Escenario> copia = new ArrayList<>();

        for (Escenario escenario : escenarios) {
            copia.add(escenario);
        }

        return copia;
    }

    public Escenario consultarEscenario(int posicion) {
        int indice = convertirPosicionAIndice(posicion);
        return escenarios[indice];
    }

    public void modificarEscenario(int posicion,
                                   int capacidad,
                                   String estado) {

        Escenario escenario = consultarEscenario(posicion);

        if (escenario == null) {
            throw new IllegalStateException(
                    "No existe un escenario en la posicion "
                            + posicion + "."
            );
        }

        /*
         * Primero se validan todos los datos para evitar
         * que el escenario quede modificado parcialmente.
         */
        Escenario datosValidados = new Escenario(
                escenario.getCodigo(),
                escenario.getNombre(),
                escenario.getUbicacion(),
                capacidad,
                estado
        );

        escenario.setCapacidadMaxima(
                datosValidados.getCapacidadMaxima()
        );

        escenario.setEstado(
                datosValidados.getEstado()
        );
    }

    public void retirarEscenario(int posicion) {
        int indice = convertirPosicionAIndice(posicion);

        if (escenarios[indice] == null) {
            throw new IllegalStateException(
                    "La posicion " + posicion + " ya esta disponible."
            );
        }

        escenarios[indice] = null;
    }

    public void registrarArtista(Artista artista) {
        if (artista == null) {
            throw new IllegalArgumentException(
                    "El artista no puede ser null."
            );
        }

        if (buscarArtista(artista.getCodigo()) != null) {
            throw new IllegalArgumentException(
                    "Ya existe un artista con el codigo "
                            + artista.getCodigo() + "."
            );
        }

        artistas.add(artista);
    }

    public List<Artista> consultarArtistas() {
        return new ArrayList<>(artistas);
    }

    public Artista buscarArtista(String codigo) {
        String codigoBuscado = validarTexto(
                codigo,
                "El codigo del artista"
        );

        for (Artista artista : artistas) {
            if (artista.getCodigo()
                    .equalsIgnoreCase(codigoBuscado)) {

                return artista;
            }
        }

        return null;
    }

    public void modificarArtista(String codigo,
                                 String nombreArtistico,
                                 String generoMusical,
                                 double duracion,
                                 int asistentes) {

        Artista artista = buscarArtista(codigo);

        if (artista == null) {
            throw new IllegalArgumentException(
                    "No existe un artista con el codigo "
                            + codigo + "."
            );
        }

        Artista datosValidados = new Artista(
                artista.getCodigo(),
                nombreArtistico,
                generoMusical,
                duracion,
                asistentes
        );

        artista.setNombreArtistico(
                datosValidados.getNombreArtistico()
        );

        artista.setGeneroMusical(
                datosValidados.getGeneroMusical()
        );

        artista.setDuracionPresentacion(
                datosValidados.getDuracionPresentacion()
        );

        artista.setAsistentesEstimados(
                datosValidados.getAsistentesEstimados()
        );
    }

    public void cancelarParticipacion(String codigo) {
        Artista artista = buscarArtista(codigo);

        if (artista == null) {
            throw new IllegalArgumentException(
                    "No existe un artista con el codigo "
                            + codigo + "."
            );
        }

        artistas.remove(artista);
    }

    public int getCantidadEscenariosConfigurados() {
        int cantidad = 0;

        for (Escenario escenario : escenarios) {
            if (escenario != null) {
                cantidad++;
            }
        }

        return cantidad;
    }

    public int getCantidadPosicionesDisponibles() {
        return MAXIMO_ESCENARIOS
                - getCantidadEscenariosConfigurados();
    }

    public int getCantidadArtistas() {
        return artistas.size();
    }

    public Escenario getEscenarioMayorCapacidad() {
        Escenario mayor = null;

        for (Escenario escenario : escenarios) {
            if (escenario != null
                    && (mayor == null
                    || escenario.getCapacidadMaxima()
                    > mayor.getCapacidadMaxima())) {

                mayor = escenario;
            }
        }

        return mayor;
    }

    public Artista getArtistaMayorDuracion() {
        Artista mayor = null;

        for (Artista artista : artistas) {
            if (mayor == null
                    || artista.getDuracionPresentacion()
                    > mayor.getDuracionPresentacion()) {

                mayor = artista;
            }
        }

        return mayor;
    }

    public Artista getArtistaMayorAsistencia() {
        Artista mayor = null;

        for (Artista artista : artistas) {
            if (mayor == null
                    || artista.getAsistentesEstimados()
                    > mayor.getAsistentesEstimados()) {

                mayor = artista;
            }
        }

        return mayor;
    }

    public double getPromedioDuracion() {
        if (artistas.isEmpty()) {
            return 0;
        }

        double suma = 0;

        for (Artista artista : artistas) {
            suma += artista.getDuracionPresentacion();
        }

        return suma / artistas.size();
    }

    private Escenario buscarEscenarioPorCodigo(String codigo) {
        for (Escenario escenario : escenarios) {
            if (escenario != null
                    && escenario.getCodigo()
                    .equalsIgnoreCase(codigo)) {

                return escenario;
            }
        }

        return null;
    }

    private int convertirPosicionAIndice(int posicion) {
        if (posicion < 1 || posicion > MAXIMO_ESCENARIOS) {
            throw new IllegalArgumentException(
                    "La posicion debe estar entre 1 y 5."
            );
        }

        return posicion - 1;
    }

    private static String validarTexto(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(
                    campo + " no puede estar vacio."
            );
        }

        return valor.trim();
    }
}