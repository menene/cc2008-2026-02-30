import java.util.ArrayList;

public class Festival {

    private String nombre;
    private String codigoIdentificacion;
    private String nombreCoordinador;
    private Escenario[] escenarios;
    private ArrayList<Artista> artistas;

    private static final int MAX_ESCENARIOS = 5;

    public Festival(
            String nombre,
            String codigoIdentificacion,
            String nombreCoordinador) {

        this.nombre = nombre;
        this.codigoIdentificacion = codigoIdentificacion;
        this.nombreCoordinador = nombreCoordinador;

        escenarios = new Escenario[MAX_ESCENARIOS];
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

    public Escenario[] getEscenarios() {
        return escenarios;
    }

    public ArrayList<Artista> getArtistas() {
        return artistas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigoIdentificacion(
            String codigoIdentificacion) {

        this.codigoIdentificacion = codigoIdentificacion;
    }

    public void setNombreCoordinador(
            String nombreCoordinador) {

        this.nombreCoordinador = nombreCoordinador;
    }

    @Override
    public String toString() {
        return "Nombre del festival: " + nombre
                + "\nCódigo de identificación: "
                + codigoIdentificacion
                + "\nCoordinador: " + nombreCoordinador;
    }
}