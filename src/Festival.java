import java.util.ArrayList;

public class Festival {

    private String nombre;
    private int codigo;
    private String nombreCoordinador;
    private Escenario[] escenarios;
    private ArrayList<Artista> artistas;

    public Festival(String nombre, int codigo, String nombreCoordinador) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.nombreCoordinador = nombreCoordinador;
        this.escenarios = new Escenario[5];
        this.artistas = new ArrayList<Artista>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombreCoordinador() {
        return nombreCoordinador;
    }

    private boolean posicionValida(int posicion) {
        return posicion >= 0 && posicion < escenarios.length;
    }

    public boolean posicionDisponible(int posicion) {
        if (posicionValida(posicion) == false) {
            return false;
        }

        return escenarios[posicion] == null;
    }

    public boolean configurarEscenario(int posicion, Escenario escenario) {
        if (posicionDisponible(posicion) == false || escenario == null) {
            return false;
        }

        escenarios[posicion] = escenario;
        return true;
    }

    public Escenario obtenerEscenario(int posicion) {
        if (posicionValida(posicion) == false) {
            return null;
        }

        return escenarios[posicion];
    }

    public boolean modificarEscenario(int posicion, int capacidadMax, boolean estado) {
        Escenario escenario = obtenerEscenario(posicion);

        if (escenario == null) {
            return false;
        }

        escenario.setCapacidadMax(capacidadMax);
        escenario.setEstado(estado);
        return true;
    }

    public boolean retirarEscenario(int posicion) {
        if (posicionValida(posicion) == false || escenarios[posicion] == null) {
            return false;
        }

        escenarios[posicion] = null;
        return true;
    }

    public int cantidadEscenariosConfigurados() {
        int cantidad = 0;

        for (int i = 0; i < escenarios.length; i++) {
            if (escenarios[i] != null) {
                cantidad++;
            }
        }

        return cantidad;
    }

    public int cantidadEspaciosDisponibles() {
        int cantidad = 0;

        for (int i = 0; i < escenarios.length; i++) {
            if (escenarios[i] == null) {
                cantidad++;
            }
        }

        return cantidad;
    }

    public Escenario escenarioMayorCapacidad() {
        Escenario mayor = null;

        for (int i = 0; i < escenarios.length; i++) {
            if (escenarios[i] != null) {
                if (mayor == null || escenarios[i].getCapacidadMax() > mayor.getCapacidadMax()) {
                    mayor = escenarios[i];
                }
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

    public Artista buscarArtista(int codigo) {
        for (int i = 0; i < artistas.size(); i++) {
            Artista artista = artistas.get(i);

            if (artista.getCodigo() == codigo) {
                return artista;
            }
        }

        return null;
    }

    public boolean modificarArtista(int codigo, String nombreArtistico, String generoMusical, float duracion, int cantidadAsist) {
        Artista artista = buscarArtista(codigo);

        if (artista == null) {
            return false;
        }

        if (duracion <= 0) {
            throw new IllegalArgumentException("La duración debe ser mayor que cero.");
        }

        if (cantidadAsist < 0) {
            throw new IllegalArgumentException("La cantidad de asistentes no puede ser negativa.");
        }

        artista.setNombreArtistico(nombreArtistico);
        artista.setGeneroMusical(generoMusical);
        artista.setDuracion(duracion);
        artista.setCantidadAsist(cantidadAsist);
        return true;
    }

    public boolean cancelarParticipacion(int codigo) {
        for (int i = 0; i < artistas.size(); i++) {
            if (artistas.get(i).getCodigo() == codigo) {
                artistas.remove(i);
                return true;
            }
        }

        return false;
    }

    public int cantidadArtistas() {
        return artistas.size();
    }

    public Artista artistaMayorDuracion() {
        if (artistas.isEmpty()) {
            return null;
        }

        Artista mayor = artistas.get(0);

        for (int i = 1; i < artistas.size(); i++) {
            if (artistas.get(i).getDuracion() > mayor.getDuracion()) {
                mayor = artistas.get(i);
            }
        }

        return mayor;
    }

    public Artista artistaMayorAsistentes() {
        if (artistas.isEmpty()) {
            return null;
        }

        Artista mayor = artistas.get(0);

        for (int i = 1; i < artistas.size(); i++) {
            if (artistas.get(i).getCantidadAsist() > mayor.getCantidadAsist()) {
                mayor = artistas.get(i);
            }
        }

        return mayor;
    }

    public float promedioDuracion() {
        if (artistas.isEmpty()) {
            return 0;
        }

        float suma = 0;

        for (int i = 0; i < artistas.size(); i++) {
            suma += artistas.get(i).getDuracion();
        }

        return suma / artistas.size();
    }

    public ArrayList<Artista> getArtistas() {
        return new ArrayList<Artista>(artistas);
    }

    public Escenario[] getEscenarios() {
        Escenario[] copia = new Escenario[escenarios.length];

        for (int i = 0; i < escenarios.length; i++) {
            copia[i] = escenarios[i];
        }

        return copia;
    }
}