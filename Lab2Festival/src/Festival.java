import java.util.ArrayList;

public class Festival {

    // Datos del festival
    private String nombreFest;
    private int codigoIdent;
    private String nombreDelC;

    // Arreglo fijo de escenarios y ArrayList dinamico de artistas
    private Escenario[] escenarios;
    private ArrayList<Artista> artistas;

    private int posicionGuard;

    // Constructor
    public Festival(String nombreFest, int codigoIdent, String nombreDelC) {

        this.nombreFest = nombreFest;
        this.codigoIdent = codigoIdent;
        this.nombreDelC = nombreDelC;

        this.escenarios = new Escenario[5];
        this.artistas = new ArrayList<>();

        this.posicionGuard = -1;
    }

    public void configurarEscenario(int posicion, Escenario escenario) {

        if (posicion < 0 || posicion >= escenarios.length) {
            throw new IllegalArgumentException(
                    "Lo sentimos, la posicion no es valida. :("
            );
        }

        if (escenarios[posicion] != null) {
            throw new IllegalArgumentException(
                    "La posicion ya contiene un escenario."
            );
        }

        escenarios[posicion] = escenario;

        posicionGuard = posicion;
    }

    public Escenario consultarEscenario(int posicion) {

        // Validar los limites del arreglo
        if (posicion < 0 || posicion >= escenarios.length) {
            throw new IllegalArgumentException(
                    "La posicion indicada no es valida."
            );
        }

        // Validar que exista un escenario en esa posicion
        if (escenarios[posicion] == null) {
            throw new IllegalArgumentException(
                    "No hay un escenario configurado en esa posicion."
            );
        }

        return escenarios[posicion];
    }
    //GG EZ modificar
        public void modificarEscenario(int posicion, int capacidad, boolean estado) {

        Escenario escenario = consultarEscenario(posicion);

        escenario.setCapacidad(capacidad);
        escenario.setEstado(estado);
    }
    //Aun mas facil retirar escenario ezzz
    public void retirarEscenario(int posicion) {

        consultarEscenario(posicion);

        escenarios[posicion] = null;
    }
    //La reutilizadora de Metodos

    //Obtener escenarios
    public Escenario[] obtenerEscenarios() {
        return escenarios;
    }
    //Cantidad escenarios
    public int cantidadEscenarios() {

        int cantidad = 0;

        for (int i = 0; i < escenarios.length; i++) {

            if (escenarios[i] != null) {
                cantidad++;
            }
        }

        return cantidad;
    }

    //cantidad de espacios 
    public int cantidadEspaciosDisponibles() {
        return escenarios.length - cantidadEscenarios();
    }

    public Artista buscarArtista(int codigo) {

        for (Artista artista : artistas) {

            if (artista.getCodigo() == codigo) {
                return artista;
            }
        }

        return null;
    }


    public Artista registrarArtista(Artista artista) {

        if (buscarArtista(artista.getCodigo()) != null) {
            throw new IllegalArgumentException(
                    "Ya existe un artista con ese codigo."
            );
        }

        artistas.add(artista);

        return artista;
    }
    public void modificarArtista(int codigo, String nombre, String genero, int duracion, int asistentes) {

        Artista artista = buscarArtista(codigo);

        if (artista == null) {
            throw new IllegalArgumentException(
                    "No existe un artista con ese codigo."
            );
        }

        artista.setNombreArtistico(nombre);
        artista.setGeneroMusical(genero);
        artista.setDuracion(duracion);
        artista.setCantidadAsistentes(asistentes);
    }


    public void cancelarArtista(int codigo) {

        Artista artista = buscarArtista(codigo);

        if (artista == null) {
            throw new IllegalArgumentException(
                    "No existe un artista con ese codigo."
            );
        }

        artistas.remove(artista);
    }


    public ArrayList<Artista> obtenerArtistas() {
        return artistas;
    }

    // Devuelve la cantidad de artistas registrados
    public int cantidadArtistas() {
        return artistas.size();
    }


    // Busca el artista con la presentacion de mayor duracion
    public Artista artistaMayorDuracion() {

        if (artistas.isEmpty()) {
            return null;
        }

        Artista mayor = artistas.get(0);

        for (Artista artista : artistas) {

            if (artista.getDuracion() > mayor.getDuracion()) {
                mayor = artista;
            }
        }

        return mayor;
        }


// Busca el artista con mayor cantidad estimada de asistentes
    public Artista artistaMayorAsistencia() {

        if (artistas.isEmpty()) {
            return null;
        }

        Artista mayor = artistas.get(0);

        for (Artista artista : artistas) {

            if (artista.getCantidadAsistentes()
                    > mayor.getCantidadAsistentes()) {

                mayor = artista;
            }
        }

        return mayor;
    }


    // Calcula el promedio de duracion de las presentaciones
    public int promedioDuracion() {

        if (artistas.isEmpty()) {
            return 0;
        }

        int suma = 0;

        for (Artista artista : artistas) {
            suma += artista.getDuracion();
        }

        return suma / artistas.size();
    }

}