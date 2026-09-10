import java.util.ArrayList;

public class Festival {
    private String nombreFest; 
    private int codigoFest; 
    private String nombreCoor; 
    private Escenario[] escenarios; 
    private ArrayList<Artista> artistas; 


    public Festival( String nombreFest, int codigoFest, String nombreCoor){
        this.nombreFest = nombreFest; 
        this.codigoFest = codigoFest; 
        this.nombreCoor = nombreCoor; 
        escenarios = new Escenario[5]; 
        artistas = new ArrayList<>(); 
    }

    public String getNombreFest(){
        return nombreFest; 
    }

    public int getCodigoFest(){
        return codigoFest; 
    }

    public String getNombreCoor(){
        return nombreCoor; 
    }

    public void nuevoEscenario(int posicion, int codigoEsc, String nombreEsc, String ubicacionEsc, int capMaxAsist, boolean estado){
        if (posicion < 1 || posicion > escenarios.length){
            throw new IndexOutOfBoundsException("La posicion a elegir debe ser entre 1 a 5");
        }

        int posicionLista = posicion -1; 

        if (escenarios[posicionLista] != null) {
            throw new IllegalArgumentException("No se puede elegir dicha posición, ya está ocupada");
        }
        
        escenarios[posicionLista] = new Escenario(codigoEsc, nombreEsc, ubicacionEsc, capMaxAsist, estado);

    }

    public Escenario[] consultaEscenarios(){
        return escenarios; 
    }

    public Escenario consultaEscenarioEsp(int posicion){

        if (posicion < 1 || posicion > escenarios.length){
            throw new IndexOutOfBoundsException("La posicion a elegir debe ser entre 1 a 5");
        }

        int posicionLista = posicion -1; 

        if (escenarios[posicionLista] == null) {
            throw new IllegalArgumentException("No se puede elegir dicho escenario, no existe en el registro");
        }
        return escenarios[posicionLista]; 
    }

    public void modificarEscenario(int posicion, int capMaxAsist, boolean estado){
        Escenario escenarioModificar = consultaEscenarioEsp(posicion); 
        escenarioModificar.setCapMaxAsist(capMaxAsist); 
        escenarioModificar.setEstado(estado);
    }

    public void eliminarEscenario(int posicion){
        if (posicion < 1 || posicion > escenarios.length){
            throw new IndexOutOfBoundsException("La posicion a elegir debe ser entre 1 a 5");
        }

        int posicionLista = posicion -1; 
        
        if (escenarios[posicionLista] == null) {
            throw new IllegalArgumentException("No se puede elegir dicha posición, no existe el escenario");
        }

        escenarios[posicionLista] = null;
    }
    
    public int numEscenarios(){
        int conteo = 0;

        for (int i = 0; i < escenarios.length; i++){
            if(escenarios[i] != null ){
                conteo += 1;
            }
        }
        return conteo; 
    }

    public int espaciosDisponibles(){
        return escenarios.length - numEscenarios();
    }

    public Escenario escMayorCapacidad(){
        Escenario mayorCapaz = null; 

        for (int i = 0; i < escenarios.length; i++) {
            if (escenarios[i] != null){
                if (mayorCapaz == null || escenarios[i].getCapMaxAsist() > mayorCapaz.getCapMaxAsist()){
                    mayorCapaz = escenarios[i];
                }
            }
        } return mayorCapaz;
    }

    public void nuevoArtista(int codigoArt, String nombreArt, String generoMusc, int duracionMin, int cantidadEst){
        for (int i = 0; i < artistas.size(); i++) {
            Artista registroArtista = artistas.get(i);
            if (registroArtista.getCodigoArt() == codigoArt){
                throw new IllegalArgumentException("EL codigo fue registrado, no puede agregarse el artista");
            }
        } 
        Artista nuevoArtista = new Artista(codigoArt, nombreArt, generoMusc, duracionMin, cantidadEst);
        artistas.add(nuevoArtista); 
    }

    public ArrayList<Artista> consultarArtistas() {
        return new ArrayList<>(artistas); 
    }

    public Artista consultarArtista(int codigoArt){
        for (Artista artista : artistas){ 
            if (artista.getCodigoArt() == codigoArt){
                return artista; 
            }
        }
        return null; 
    }

    public void modificarArtista(int codigoArt, String nombreArt, String generoMusc, int duracionMin, int cantidadEst){
        Artista artistaModificar = consultarArtista(codigoArt);
        if (artistaModificar == null){
            throw new IllegalArgumentException("No se puede modificar. El artista con dicho cofigo no existe");
        }
        if (duracionMin <= 0) {
        throw new IllegalArgumentException("La duración tiene que ser mayor que 0");
        }

        if (cantidadEst < 0) {
            throw new IllegalArgumentException("La cantidad estimada no puede exitir en valores negativos");
        }
        artistaModificar.setNombreArt(nombreArt);
        artistaModificar.setGeneroMusc(generoMusc);
        artistaModificar.setDuracionMin(duracionMin);
        artistaModificar.setCantidadEst(cantidadEst);
    }

    public void eliminarArtista(int codigoArt){
        Artista artistaPorEliminar = consultarArtista(codigoArt);
        if (artistaPorEliminar == null){
            throw new IllegalArgumentException("No se puede eliminar el artista si no existe"); 
        }
        artistas.remove(artistaPorEliminar);
    }

    public int numArtistas(){
        return artistas.size();
    }

    public Artista mayorDuracionArt(){
        Artista artistaMayorDuracion = null; 
        for (Artista artista: artistas) {
            if (artistaMayorDuracion == null || artista.getDuracionMin() > artistaMayorDuracion.getDuracionMin()){
                    artistaMayorDuracion = artista; 
                }
        }
        return artistaMayorDuracion;
    }

    public Artista mayorCantidadEst(){
        Artista artistaMayorCant = null; 

        for (Artista artista : artistas) {
            if( artistaMayorCant == null || artista.getCantidadEst() > artistaMayorCant.getCantidadEst()){
                artistaMayorCant = artista; 
            }
        }
        return artistaMayorCant;
    }

    public double promedioDuracion(){
        if (artistas.isEmpty()){
            return 0.00; 
        }
        double suma = 0; 
        for (Artista artista: artistas){
            suma += artista.getDuracionMin(); 
        }
        return suma / artistas.size();
    }
}
