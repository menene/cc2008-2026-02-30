import java.util.ArrayList;

public class Festival {

    // Atributos
    private String nombre;
    private String codigo;
    private String coordinador;

    // Listas
    private Escenario[] escenarios;
    private ArrayList<Artista> artistas;

    // Constructor
    public Festival(String nombre, String codigo, String coordinador) {

        //Excepciones para validar los datos de entrada
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre del festival no puede estar vacio."
            );
        }

        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El codigo del festival no puede estar vacio."
            );
        }

        if (coordinador == null || coordinador.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre del coordinador no puede estar vacio."
            );
        }

        this.nombre = nombre;
        this.codigo = codigo;
        this.coordinador = coordinador;

        // Se definen 5 posiciones para los escenarios, ya que es un número fijo.
        this.escenarios = new Escenario[5];

        // La cantidad de artistas es dinámica.
        this.artistas = new ArrayList<Artista>();
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCoordinador() {
        return coordinador;
    }

    // Administración de escenarios

    public void configurarEscenario(
            int posicion,
            Escenario escenario) {

        validarPosicion(posicion);

        //Excepciones para validar los datos de entrada
        if (escenario == null) {
            throw new IllegalArgumentException(
                    "El escenario no puede ser null."
            );
        }

        if (escenarios[posicion] != null) {
            throw new IllegalArgumentException(
                    "La posicion seleccionada ya esta ocupada."
            );
        }

        escenarios[posicion] = escenario;
    }

    public Escenario obtenerEscenario(int posicion) {
        validarPosicion(posicion);
        return escenarios[posicion];
    }

    public void modificarEscenario(int posicion, int nuevaCapacidad, String nuevoEstado) {

        validarPosicion(posicion);

        //Excepciones para validar los datos de entrada
        if (escenarios[posicion] == null) {
            throw new IllegalArgumentException(
                    "No existe un escenario en la posicion indicada."
            );
        }

        // Se validan ambos valores antes de modificar el objeto.
        if (nuevaCapacidad <= 0) {
            throw new IllegalArgumentException(
                    "La capacidad maxima debe ser mayor que cero."
            );
        }

        if (nuevoEstado == null || nuevoEstado.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El estado no puede estar vacio."
            );
        }

        escenarios[posicion].setCapacidadMaxima(nuevaCapacidad);
        escenarios[posicion].setEstado(nuevoEstado);
    }

    public void retirarEscenario(int posicion) {
        validarPosicion(posicion);

        if (escenarios[posicion] == null) {
            throw new IllegalArgumentException(
                    "No existe un escenario en la posicion indicada."
            );
        }

        escenarios[posicion] = null;
    }

    public int getCantidadPosicionesEscenarios() {
        return escenarios.length;
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
        Escenario escenarioMayor = null;

        for (int i = 0; i < escenarios.length; i++) {
            if (escenarios[i] != null) {
                if (escenarioMayor == null
                        || escenarios[i].getCapacidadMaxima()
                        > escenarioMayor.getCapacidadMaxima()) {

                    escenarioMayor = escenarios[i];
                }
            }
        }

        return escenarioMayor;
    }


    // Administración de artistas
    public void registrarArtista(Artista artista) {
        if (artista == null) {
            throw new IllegalArgumentException(
                    "El artista no puede ser null."
            );
        }

        if (existeCodigoArtista(artista.getCodigo())) {
            throw new IllegalArgumentException(
                    "Ya existe un artista con ese codigo."
            );
        }

        artistas.add(artista);
    }

    public Artista buscarArtista(String codigo) {
        int indice = buscarIndiceArtista(codigo);

        if (indice == -1) {
            return null;
        }

        return artistas.get(indice);
    }

    public void modificarArtista(String codigoActual, String nuevoCodigo, String nuevoNombre, String nuevoGenero, int nuevaDuracion, int nuevosAsistentes) {

        int indice = buscarIndiceArtista(codigoActual);

        if (indice == -1) {
            throw new IllegalArgumentException(
                    "No existe un artista con el codigo indicado."
            );
        }

        if (!codigoActual.equals(nuevoCodigo)
                && existeCodigoArtista(nuevoCodigo)) {

            throw new IllegalArgumentException(
                    "El nuevo codigo ya pertenece a otro artista."
            );
        }

        // Se crean un objeto temporal para validar los datos de entrada antes de modificar el objeto real.
        Artista datosValidados = new Artista(
                nuevoCodigo,
                nuevoNombre,
                nuevoGenero,
                nuevaDuracion,
                nuevosAsistentes
        );

        Artista artista = artistas.get(indice);

        artista.setCodigo(datosValidados.getCodigo());
        artista.setNombreArtistico(
                datosValidados.getNombreArtistico()
        );
        artista.setGeneroMusical(
                datosValidados.getGeneroMusical()
        );
        artista.setDuracionPresentacion(
                datosValidados.getDuracionPresentacion()
        );
        artista.setCantidadEstimadaAsistentes(
                datosValidados.getCantidadEstimadaAsistentes()
        );
    }

    public void cancelarParticipacion(String codigo) {
        int indice = buscarIndiceArtista(codigo);

        if (indice == -1) {
            throw new IllegalArgumentException(
                    "No existe un artista con el codigo indicado."
            );
        }

        artistas.remove(indice);
    }

    public int obtenerCantidadArtistas() {
        return artistas.size();
    }

    public Artista obtenerArtista(int indice) {
        if (indice < 0 || indice >= artistas.size()) {
            throw new IllegalArgumentException(
                    "El indice del artista no es valido."
            );
        }

        return artistas.get(indice);
    }

    public Artista obtenerArtistaMayorDuracion() {
        if (artistas.isEmpty()) {
            return null;
        }

        Artista artistaMayor = artistas.get(0);

        for (int i = 1; i < artistas.size(); i++) {
            Artista artistaActual = artistas.get(i);

            if (artistaActual.getDuracionPresentacion()
                    > artistaMayor.getDuracionPresentacion()) {

                artistaMayor = artistaActual;
            }
        }

        return artistaMayor;
    }

    public Artista obtenerArtistaMayorAsistencia() {
        if (artistas.isEmpty()) {
            return null;
        }

        Artista artistaMayor = artistas.get(0);

        for (int i = 1; i < artistas.size(); i++) {
            Artista artistaActual = artistas.get(i);

            if (artistaActual.getCantidadEstimadaAsistentes()
                    > artistaMayor.getCantidadEstimadaAsistentes()) {

                artistaMayor = artistaActual;
            }
        }

        return artistaMayor;
    }

    public double calcularPromedioDuracion() {
        if (artistas.isEmpty()) {
            return 0.0;
        }

        int sumaDuraciones = 0;

        for (int i = 0; i < artistas.size(); i++) {
            sumaDuraciones +=
                    artistas.get(i).getDuracionPresentacion();
        }

        return (double) sumaDuraciones / artistas.size();
    }

  
    // Validación con excepciones para la posición de los escenarios
    private void validarPosicion(int posicion) {
        if (posicion < 0 || posicion >= escenarios.length) {
            throw new IllegalArgumentException(
                    "La posicion debe estar entre 0 y "
                    + (escenarios.length - 1) + "."
            );
        }
    }

    private int buscarIndiceArtista(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El codigo del artista no puede estar vacio."
            );
        }

        for (int i = 0; i < artistas.size(); i++) {
            if (artistas.get(i).getCodigo().equals(codigo)) {
                return i;
            }
        }

        return -1;
    }

    private boolean existeCodigoArtista(String codigo) {
        return buscarIndiceArtista(codigo) != -1;
    }
}