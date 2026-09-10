import java.util.ArrayList;
public class Festival{
    private String codigo;
    private String nombre;
    private String nombre_coordinador;
    private Escenario[] escenarios;
    private ArrayList<Artista> artistas;
    public Festival(String codigo, String nombre, String nombre_coordinador, Escenario[] escenarios, ArrayList<Artista> artistas){
        this.codigo = codigo;
        this.nombre = nombre;
        this.nombre_coordinador = nombre_coordinador;
        this.escenarios = escenarios;
        this.artistas = artistas;
    }
    public String getNombre(){
        return nombre;
    }
    public String getCodigo(){
        return codigo;
    }
    public String getNombreCoordinador(){
        return nombre_coordinador;
    }
    public Escenario[] getEscenarios(){
        return escenarios;
    }
    public ArrayList<Artista> getArtistas(){
        return artistas;
    }
    public boolean ModificarEscenario(int posicion, int nueva_capacidad, String nuevo_estado){
            if (!PosicionValida(posicion)) {
            throw new IndexOutOfBoundsException("La posición debe estar entre 0 y 4.");
        }
        if (escenarios[posicion] == null) {
            throw new IllegalArgumentException(
                "No existe un escenario en esa posición.");
        }
        escenarios[posicion].setCapacidad(nueva_capacidad);
        escenarios[posicion].setEstado(nuevo_estado);
        return true;
    }
    public boolean RetirarEscenario(int posicion) {
        if (!PosicionValida(posicion)) {
            throw new IndexOutOfBoundsException(
                "La posición debe estar entre 0 y 4."
            );
        }

        if (escenarios[posicion] == null) {
            throw new IllegalArgumentException(
                "No existe un escenario en esa posición."
            );
        }

        escenarios[posicion] = null;
        return true;
    }
    public int ContarEscenarios(){
        int contador = 0;
        for (Escenario escenario : escenarios){
            if (escenario != null){
                contador++;
            }
        }
        return contador;
    }
    public int EspaciosDisponibles(){
        return escenarios.length - ContarEscenarios();
    }
    public Escenario EscenarioMayor(){
        Escenario mayor = null;
        for (Escenario escenario : escenarios){
            if (escenario != null){
                if (mayor == null || escenario.getCapacidadMaxima() > mayor.getCapacidadMaxima()){
                    mayor = escenario;
                }
            }
        }
        return mayor;
    }
    public boolean RegistrarArtista(Artista artista){
        if (artista == null){
            throw new IllegalArgumentException("El artista no puede ser null");
        }
        if (CodigoRepetido(artista.getCodigo())){
            return false;
        }
        artistas.add(artista);
        return true;
    }
    public Artista BuscarArtista(){
        if (artistas.isEmpty()){
            return null;
        }
        return artistas.get(0);
    }
    public boolean ModificarArtista(String codigo, String nombre, String genero, int duracion, int asistentes){
        for (int i=0; i<artistas.size(); i++){
            Artista artista = artistas.get(i);
             if (artista.getCodigo().equalsIgnoreCase(codigo)) {
                Artista artistaModificado = new Artista(codigo, nombre, genero, duracion, asistentes);
                artistas.set(i, artistaModificado);
                return true;
            }
        }
        return false;
    }
    public boolean CancelarParticipacion(String codigo){
        for (int i = 0; i < artistas.size(); i++) {
            if (artistas.get(i).getCodigo().equalsIgnoreCase(codigo)){
                artistas.remove(i);
                return true;
            }
        }
        return false;
    }
    public int ContarArtistas() {
        return artistas.size();
    }
    public Artista ArtistaMayorDuracion() {
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
    public double CalcularPromedioDuracion() {
        if (artistas.isEmpty()) {
            return 0;
        }
        int sumaDuraciones = 0;

        for (Artista artista : artistas) {
            sumaDuraciones += artista.getDuracion();
        }
        return (double) sumaDuraciones / artistas.size();
    }

    public boolean PosicionValida(int posicion) {
        return posicion >= 0 && posicion < escenarios.length;
    }

    public boolean CodigoRepetido(String codigo) {
        for (Artista artista : artistas) {
            if (artista.getCodigo().equalsIgnoreCase(codigo)) {
                return true;
            }
        }
        return false;
    }
}