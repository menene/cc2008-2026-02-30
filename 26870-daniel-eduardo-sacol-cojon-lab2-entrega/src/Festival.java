import java.util.ArrayList;

public class Festival {
    private int id;
    private String nombre;
    private String nombreCoordinador;
    private Escenario[] escenarios;
    private ArrayList<Artista> artistas;

    public Festival(int id, String nombre, String nombreCoordinador) {
        this.id = id;
        this.nombre = nombre;
        this.nombreCoordinador = nombreCoordinador;
        this.escenarios = new Escenario[5];
        this.artistas = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getNombreCoordinador() { return nombreCoordinador; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setNombreCoordinador(String nombreCoordinador) { this.nombreCoordinador = nombreCoordinador; }

    public void configurarNuevoEscenario(Escenario nuevoEscenario, int indice) {
        if (indice < 0 || indice >= 5) {
            throw new IllegalArgumentException("El índice debe estar entre 0 y 4.");
        }
        if (escenarios[indice] != null) {
            throw new IllegalArgumentException("Esa posicion ya está ocupada por otro escenario. Por favor, elija otra posición.");
        }
        escenarios[indice] = nuevoEscenario;
    }

    public Escenario[] consultarEscenarios() {
        return escenarios;
    }

    public Escenario consultarEscenario(int indice) {
        if (indice < 0 || indice >= 5) throw new IllegalArgumentException("Índice fuera de rango.");
        if (escenarios[indice] == null) throw new IllegalArgumentException("No hay escenario configurado en esta posición.");
        return escenarios[indice];
    }

    public void modificarEscenario(int indice, int capacidadMaxima, String estado) {
        Escenario esc = consultarEscenario(indice); 
        esc.setMaxAsistente(capacidadMaxima); 
        esc.setEstado(estado);
    }

    public void retirarEscenario(int indice) {
        if (indice < 0 || indice >= 5) throw new IllegalArgumentException("Índice fuera de rango.");
        if (escenarios[indice] == null) throw new IllegalArgumentException("No hay escenario configurado en esta posición.");
        escenarios[indice] = null;
    }

    public void registrarArtista(Artista artista) {
        for (Artista a : artistas) {
            if (a.getId() == artista.getId()) {
                throw new IllegalArgumentException("Ya existe un artista registrado con el código " + artista.getId());
            }
        }
        artistas.add(artista);
    }

    public ArrayList<Artista> consultarArtistas() {
        return artistas;
    }

    public Artista buscarArtista(int id) {
        for (Artista a : artistas) {
            if (a.getId() == id) return a;
        }
        throw new IllegalArgumentException("No se encontró ningún artista con el código " + id);
    }

    public void modificarArtista(int id, String nombreArtistico, String generoMusical, double duracionPresentacion, int estAsistente) {
        Artista a = buscarArtista(id);
        a.setNombreArtistico(nombreArtistico);
        a.setGeneroMusical(generoMusical);
        a.setDuracionPresentacion(duracionPresentacion);
        a.setEstAsistente(estAsistente);
    }

    public void cancelarArtista(int id) {
        Artista a = buscarArtista(id);
        artistas.remove(a);
    }

    public int calcularEscenConfigurados() {
        int contador = 0;
        for (Escenario e : escenarios) {
            if (e != null) contador++;
        }
        return contador;
    }

    public int calcularCantEspaciosDisponibles() {
        return 5 - calcularEscenConfigurados();
    }

    public Escenario encontrarEscenMaxAsistentes() {
        Escenario max = null;
        for (Escenario e : escenarios) {
            if (e != null) {
                if (max == null || e.getMaxAsistente() > max.getMaxAsistente()) {
                    max = e;
                }
            }
        }
        return max;
    }

    public int calcularArtistasRegistrados() {
        return artistas.size();
    }

    public Artista encontrarArtistasPresentMaxDuracion() {
        if (artistas.isEmpty()) return null;
        Artista max = artistas.get(0);
        for (Artista a : artistas) {
            if (a.getDuracionPresentacion() > max.getDuracionPresentacion()) max = a;
        }
        return max;
    }

    public Artista encontrarArtistaMaxAsistentes() {
        if (artistas.isEmpty()) return null;
        Artista max = artistas.get(0);
        for (Artista a : artistas) {
            if (a.getEstAsistente() > max.getEstAsistente()) max = a;
        }
        return max;
    }

    public double calcularPromedioDuracionPresentaciones() {
        if (artistas.isEmpty()) return 0.0;
        double suma = 0;
        for (Artista a : artistas) {
            suma += a.getDuracionPresentacion();
        }
        return suma / artistas.size();
    }
}