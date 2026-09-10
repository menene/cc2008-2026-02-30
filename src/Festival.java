import java.util.ArrayList;

public class Festival {
    private String nombre;
    private String codigo;
    private String coordinador;
    private Escenario[] escenarios; //lista
    private ArrayList<Artista> artistas; //arrayslist

    //constructor
    public Festival(String nombre, String codigo, String coordinador) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.coordinador = coordinador;

        //la lista de escenarios si la puedo dejar con 5 definido
        escenarios = new Escenario[5];
        //en artistas no, porque asi se puede modificar 
        artistas = new ArrayList<Artista>();
    }

    //getters
    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCoordinador() {
        return coordinador;
    }

    //escenarios

    public boolean configurarEscenario(int posicion, Escenario escenario) {
        //recorrer la lista por posiciones
        if (!posicionValida(posicion)) {
            return false;
        }
        //comprobar antes de usar el metodo
        if (escenarios[posicion] != null) {
            return false;
        }
        escenarios[posicion] = escenario;
        return true;
    }

    public Escenario obtenerEscenario(int posicion) {
        //si la posicion no es valida le asigna null
        if (!posicionValida(posicion)) {
            return null;
        }

        return escenarios[posicion];
    }

    public boolean modificarEscenario(int posicion, int capacidadMaxima,
                                      String estado) {
        //si la posicion no es correcta regresa false
        if (!posicionValida(posicion)) {
            return false;
        }
        //puede estar bien la posicion pero estar vacio
        if (escenarios[posicion] == null) {
            return false;
        }

        escenarios[posicion].setCapacidadMaxima(capacidadMaxima);
        escenarios[posicion].setEstado(estado);

        return true;
    }

    public boolean retirarEscenario(int posicion) {
        //posicion no valida, false
        if (!posicionValida(posicion)) {
            return false;
        }
        //puede estar vacio
        if (escenarios[posicion] == null) {
            return false;
        }

        escenarios[posicion] = null;
        return true;
    }

    private boolean posicionValida(int posicion) {
        if (posicion >= 0) {
            if (posicion < escenarios.length) {
                return true;
            }
        }

        return false;
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
        return escenarios.length - cantidadEscenariosConfigurados();
    }

    public Escenario escenarioMayorCapacidad() {
        Escenario mayor = null;

        for (int i = 0; i < escenarios.length; i++) {
            if (escenarios[i] != null) {

                if (mayor == null) {
                    mayor = escenarios[i];
                } else {
                    if (escenarios[i].getCapacidadMaxima() > mayor.getCapacidadMaxima()) {
                        mayor = escenarios[i];
                    }
                }
            }
        }

        return mayor;
    }

    //artistas

    //peque;o cambio no contemplado en el analisis
    //se necesita acceder a artistas para ense;arlos en la opcion de "consultar artistas"
    public ArrayList<Artista> getArtistas() {
        return artistas;
    }

    public boolean registrarArtista(Artista artista) {
        if (buscarArtista(artista.getCodigo()) != null) {
            return false;
        }

        artistas.add(artista);
        return true;
    }

    public Artista buscarArtista(String codigo) {
        for (Artista artista : artistas) {
            if (artista.getCodigo().equalsIgnoreCase(codigo)) {
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

        if (duracionPresentacion <= 0) {
            throw new IllegalArgumentException(
                "La duración de la presentación debe ser mayor que 0."
            );
        }

        if (cantidadEstimadaAsistentes < 0) {
            throw new IllegalArgumentException(
                "La cantidad estimada de asistentes no puede ser negativa."
            );
        }

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

    public int cantidadArtistas() {
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

    public double promedioDuracion() {
        if (artistas.isEmpty()) {
            return 0;
        }

        int total = 0;

        for (Artista artista : artistas) {
            total += artista.getDuracionPresentacion();
        }

        return (double) total / artistas.size();
    }
}