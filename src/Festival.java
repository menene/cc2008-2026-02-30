import java.util.ArrayList;

public class Festival {

    private String nombre;
    private String codigoIdentificacion;
    private String nombreCoordinador;
    private Escenario[] escenarios;
    private ArrayList<Artista> artistas;

    public Festival(String nombre, String codigoIdentificacion,
                    String nombreCoordinador) {

        this.nombre = nombre;
        this.codigoIdentificacion = codigoIdentificacion;
        this.nombreCoordinador = nombreCoordinador;

        escenarios = new Escenario[5];
        artistas = new ArrayList<Artista>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigoIdentificacion() {
        return codigoIdentificacion;
    }

    public String getNombreCoordinador() {
        return nombreCoordinador;
    }

    public boolean configurarEscenario(int posicion, Escenario escenario) {

        if (posicion < 0 || posicion >= escenarios.length) {
            return false;
        }

        if (escenarios[posicion] != null) {
            return false;
        }

        escenarios[posicion] = escenario;
        return true;
    }

    public Escenario obtenerEscenario(int posicion) {

        if (posicion < 0 || posicion >= escenarios.length) {
            return null;
        }

        return escenarios[posicion];
    }

    public boolean modificarEscenario(int posicion, int capacidadMaxima,
                                      String estado) {

        if (posicion < 0 || posicion >= escenarios.length) {
            return false;
        }

        if (escenarios[posicion] == null) {
            return false;
        }

        escenarios[posicion].setCapacidadMaxima(capacidadMaxima);
        escenarios[posicion].setEstado(estado);

        return true;
    }

    public boolean retirarEscenario(int posicion) {

        if (posicion < 0 || posicion >= escenarios.length) {
            return false;
        }

        if (escenarios[posicion] == null) {
            return false;
        }

        escenarios[posicion] = null;
        return true;
    }

    public boolean registrarArtista(Artista artista) {

        if (buscarArtista(artista.getCodigo()) != null) {
            return false;
        }

        artistas.add(artista);
        return true;
    }

    public void mostrarArtistas() {

        if (artistas.isEmpty()) {
            System.out.println("No hay artistas registrados.");
            return;
        }

        for (Artista artista : artistas) {
            System.out.println(artista);
            System.out.println();
        }
    }

    public Artista buscarArtista(String codigo) {

        for (Artista artista : artistas) {

            if (artista.getCodigo().equals(codigo)) {
                return artista;
            }
        }

        return null;
    }

    public boolean eliminarArtista(String codigo) {

        for (int i = 0; i < artistas.size(); i++) {

            if (artistas.get(i).getCodigo().equals(codigo)) {
                artistas.remove(i);
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

                if (mayor == null
                        || escenarios[i].getCapacidadMaxima()
                        > mayor.getCapacidadMaxima()) {

                    mayor = escenarios[i];
                }
            }
        }

        return mayor;
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

            if (artistas.get(i).getDuracionPresentacion()
                    > mayor.getDuracionPresentacion()) {

                mayor = artistas.get(i);
            }
        }

        return mayor;
    }

    public Artista artistaMayorAsistencia() {

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

    public double promedioDuracion() {

        if (artistas.isEmpty()) {
            return 0;
        }

        int suma = 0;

        for (Artista artista : artistas) {
            suma += artista.getDuracionPresentacion();
        }

        return (double) suma / artistas.size();
    }
}