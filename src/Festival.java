import java.util.ArrayList;

public class Festival {
    private String nombre;
    private String codigo;
    private String coordinador;
    private Escenario[] escenarios;
    private ArrayList<Artista> artistas;

    public Festival(String nombre, String codigo, String coordinador) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.coordinador = coordinador;

        escenarios = new Escenario[5];
        artistas = new ArrayList<Artista>();
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

    private void validarPosicion(int posicion) {
        if (posicion < 0 || posicion >= escenarios.length) {
            throw new IndexOutOfBoundsException(
                "La posicion debe estar entre 0 y 4."
            );
        }
    }

    private Escenario exigirEscenario(int posicion) {
        validarPosicion(posicion);

        if (escenarios[posicion] == null) {
            throw new IllegalStateException(
                "No hay un escenario en esa posicion."
            );
        }

        return escenarios[posicion];
    }

    public void configurarEscenario(int posicion, Escenario escenario) {
        validarPosicion(posicion);

        if (escenarios[posicion] != null) {
            throw new IllegalStateException(
                "La posicion seleccionada ya esta ocupada."
            );
        }

        if (escenario == null) {
            throw new IllegalArgumentException(
                "El escenario no puede ser null."
            );
        }

        escenarios[posicion] = escenario;
    }

    public String consultarEscenarios() {
        String resultado = "";

        for (int i = 0; i < escenarios.length; i++) {
            if (escenarios[i] != null) {
                resultado += "Posicion " + i + ": "
                          + escenarios[i] + "\n";
            }
        }

        if (resultado.isEmpty()) {
            return "No hay escenarios configurados.";
        }

        return resultado;
    }

    public Escenario consultarEscenario(int posicion) {
        validarPosicion(posicion);
        return escenarios[posicion];
    }

    public void modificarEscenario(int posicion, int capacidadMaxima,
                                   String estado) {
        Escenario escenario = exigirEscenario(posicion);
        escenario.actualizarDatos(capacidadMaxima, estado);
    }

    public void retirarEscenario(int posicion) {
        exigirEscenario(posicion);
        escenarios[posicion] = null;
    }

    private int buscarIndiceArtista(String codigo) {
        for (int i = 0; i < artistas.size(); i++) {
            if (artistas.get(i).getCodigo().equals(codigo)) {
                return i;
            }
        }

        return -1;
    }

    public void registrarArtista(Artista artista) {
        if (artista == null) {
            throw new IllegalArgumentException(
                "El artista no puede ser null."
            );
        }

        if (buscarIndiceArtista(artista.getCodigo()) != -1) {
            throw new IllegalArgumentException(
                "Ya existe un artista con ese codigo."
            );
        }

        artistas.add(artista);
    }

    public String consultarArtistas() {
        if (artistas.isEmpty()) {
            return "No hay artistas registrados.";
        }

        String resultado = "";

        for (Artista artista : artistas) {
            resultado += artista + "\n";
        }

        return resultado;
    }

    public Artista buscarArtista(String codigo) {
        int indice = buscarIndiceArtista(codigo);

        if (indice == -1) {
            return null;
        }

        return artistas.get(indice);
    }

    public void modificarArtista(String codigoActual, String nuevoCodigo,
                                 String nombreArtistico,
                                 String generoMusical, int duracionMinutos,
                                 int asistentesEstimados) {
        int indice = buscarIndiceArtista(codigoActual);

        if (indice == -1) {
            throw new IllegalArgumentException(
                "No existe un artista con ese codigo."
            );
        }

        int indiceOtro = buscarIndiceArtista(nuevoCodigo);

        if (indiceOtro != -1 && indiceOtro != indice) {
            throw new IllegalArgumentException(
                "El nuevo codigo pertenece a otro artista."
            );
        }

        artistas.get(indice).actualizarDatos(
            nuevoCodigo, nombreArtistico, generoMusical,
            duracionMinutos, asistentesEstimados
        );
    }

    public boolean cancelarParticipacion(String codigo) {
        int indice = buscarIndiceArtista(codigo);

        if (indice == -1) {
            return false;
        }

        artistas.remove(indice);
        return true;
    }

    public int contarEscenarios() {
        int cantidad = 0;

        for (Escenario escenario : escenarios) {
            if (escenario != null) {
                cantidad++;
            }
        }

        return cantidad;
    }

    public int contarEspaciosLibres() {
        return escenarios.length - contarEscenarios();
    }

    public Escenario escenarioMasGrande() {
        Escenario mayor = null;

        for (Escenario escenario : escenarios) {
            if (escenario != null) {
                if (mayor == null
                    || escenario.getCapacidadMaxima()
                       > mayor.getCapacidadMaxima()) {
                    mayor = escenario;
                }
            }
        }

        return mayor;
    }

    public int contarArtistas() {
        return artistas.size();
    }

    public Artista artistaMayorDuracion() {
        if (artistas.isEmpty()) {
            return null;
        }

        Artista mayor = artistas.get(0);

        for (Artista artista : artistas) {
            if (artista.getDuracionMinutos()
                > mayor.getDuracionMinutos()) {
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
            if (artista.getAsistentesEstimados()
                > mayor.getAsistentesEstimados()) {
                mayor = artista;
            }
        }

        return mayor;
    }

    public double promedioDuracion() {
        if (artistas.isEmpty()) {
            throw new IllegalStateException(
                "No hay artistas para calcular el promedio."
            );
        }

        double suma = 0;

        for (Artista artista : artistas) {
            suma += artista.getDuracionMinutos();
        }

        return suma / artistas.size();
    }
}