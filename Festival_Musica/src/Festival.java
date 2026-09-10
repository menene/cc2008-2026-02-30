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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(String coordinador) {
        this.coordinador = coordinador;
    }

    public boolean configurarEscenario(int posicion, Escenario escenario) {
        if (posicion < 0 || posicion >= escenarios.length
                || escenario == null || escenarios[posicion] != null) {
            return false;
        }
        escenarios[posicion] = escenario;
        return true;
    }

    public Escenario[] consultarEscenarios() {
        int cantidad = calcularEscenariosConfig();
        Escenario[] configurados = new Escenario[cantidad];
        int indice = 0;

        for (Escenario escenario : escenarios) {
            if (escenario != null) {
                configurados[indice] = escenario;
                indice++;
            }
        }
        return configurados;
    }

    public Escenario consultarEscenario(int posicion) {
        if (posicion < 0 || posicion >= escenarios.length) {
            return null;
        }
        return escenarios[posicion];
    }

    public void modificarEscenario(int posicion, int capacidad, String estado) {
        if (posicion < 0 || posicion >= escenarios.length) {
            throw new IndexOutOfBoundsException("La posición no es válida.");
        }
        if (escenarios[posicion] == null) {
            throw new IllegalArgumentException(
                "La posición no contiene un escenario."
            );
        }
        escenarios[posicion].setCapacidadMaxima(capacidad);
        escenarios[posicion].setEstado(estado);
    }

    public void retirarEscenario(int posicion) {
        if (posicion < 0 || posicion >= escenarios.length) {
            throw new IndexOutOfBoundsException("La posición no es válida.");
        }
        if (escenarios[posicion] == null) {
            throw new IllegalArgumentException(
                "La posición no contiene un escenario."
            );
        }
        escenarios[posicion] = null;
    }

    public boolean registrarArtista(Artista artista) {
        if (artista == null || buscarArtista(artista.getCodigo()) != null) {
            return false;
        }
        artistas.add(artista);
        return true;
    }

    public ArrayList<Artista> consultarArtistas() {
        return new ArrayList<Artista>(artistas);
    }

    public Artista buscarArtista(String codigo) {
        for (Artista artista : artistas) {
            if (artista.getCodigo().equalsIgnoreCase(codigo)) {
                return artista;
            }
        }
        return null;
    }

    public void cancelarParticipacion(String codigo) {
        for (int i = 0; i < artistas.size(); i++) {
            if (artistas.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                artistas.remove(i);
                return;
            }
        }
    }

    public int calcularEscenariosConfig() {
        int cantidad = 0;
        for (Escenario escenario : escenarios) {
            if (escenario != null) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public int calcularEspaciosDisponibles() {
        return escenarios.length - calcularEscenariosConfig();
    }

    public Escenario getEscenarioMayorCapacidad() {
        Escenario mayor = null;
        for (Escenario escenario : escenarios) {
            if (escenario != null
                    && (mayor == null
                    || escenario.getCapacidadMaxima() > mayor.getCapacidadMaxima())) {
                mayor = escenario;
            }
        }
        return mayor;
    }

    public Artista getArtistaMayorDuracion() {
        Artista mayor = null;
        for (Artista artista : artistas) {
            if (mayor == null
                    || artista.getDuracionMinutos() > mayor.getDuracionMinutos()) {
                mayor = artista;
            }
        }
        return mayor;
    }

    public Artista getArtistaMayorAsistentes() {
        Artista mayor = null;
        for (Artista artista : artistas) {
            if (mayor == null
                    || artista.getCantidadAsistentes() > mayor.getCantidadAsistentes()) {
                mayor = artista;
            }
        }
        return mayor;
    }

    public double calcularPromedioDuracion() {
        if (artistas.isEmpty()) {
            return 0;
        }
        double total = 0;
        for (Artista artista : artistas) {
            total += artista.getDuracionMinutos();
        }
        return total / artistas.size();
    }

}
