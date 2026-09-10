import java.util.ArrayList;

public class Festival {
    private String nombre;
    private String codigo;
    private String nombreCoordinador;
    private Escenario[] escenarios;
    private ArrayList<Artista> artistas;

    // Constructor: inicializa los datos generales del festival, crea el arreglo escenarios de tamano fijo 5 con todas sus posiciones en null, y crea la coleccion dinamica artistas mediante new ArrayList<>().
    public Festival(String nombre, String codigo, String nombreCoordinador) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.nombreCoordinador = nombreCoordinador;
        this.escenarios = new Escenario[5];
        this.artistas = new ArrayList<Artista>();
    }

    // Retorna el nombre del festival.
    public String getNombre() {
        return nombre;
    }

    // Retorna el codigo de identificacion del festival.
    public String getCodigo() {
        return codigo;
    }

    // Retorna el nombre del coordinador del festival.
    public String getNombreCoordinador() {
        return nombreCoordinador;
    }

    // Retorna el arreglo basico completo de escenarios; es el arreglo que se recorre para consultar, modificar y retirar escenarios, y para calcular la cantidad de configurados, los espacios disponibles y el de mayor capacidad.
    public Escenario[] getEscenarios() {
        return escenarios;
    }

    // Retorna el escenario almacenado en la posicion indicada del arreglo, o null si la posicion se encuentra vacia.
    public Escenario getEscenario(int posicion) {
        return escenarios[posicion];
    }

    // Almacena el escenario recibido en la posicion indicada del arreglo; asi es como se agrega un escenario a la estructura basica.
    public void configurarEscenario(int posicion, Escenario escenario) {
        escenarios[posicion] = escenario;
    }

    // Restablece a null la posicion indicada del arreglo cuando un escenario es retirado; asi es como se elimina un escenario de la estructura basica.
    public void retirarEscenario(int posicion) {
        escenarios[posicion] = null;
    }

    // Retorna la coleccion dinamica completa de artistas registrados; es el ArrayList que se recorre para consultar, buscar por codigo, modificar, calcular el promedio de duracion y determinar el artista de mayor duracion y de mayor cantidad de asistentes.
    public ArrayList<Artista> getArtistas() {
        return artistas;
    }

    // Agrega el nuevo artista al final de la coleccion dinamica utilizando el metodo add() de ArrayList; asi es como se agrega un artista a la estructura dinamica.
    public void agregarArtista(Artista artista) {
        artistas.add(artista);
    }

    // Elimina el objeto correspondiente de la coleccion dinamica utilizando el metodo remove() de ArrayList cuando la participacion de un artista es cancelada; asi es como se elimina un artista de la estructura dinamica.
    public void eliminarArtista(Artista artista) {
        artistas.remove(artista);
    }
}
