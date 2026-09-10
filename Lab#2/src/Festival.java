import java.util.ArrayList;

public class Festival {
    private String codigo;
    private String nombre;
    private String nombreCoordinador;
    private Escenario[] escenarios;
    private ArrayList<Artista> artistas;

    public Festival(String cod, String nom, String nombreC) {
        this.codigo = cod;
        this.nombre = nom;
        this.nombreCoordinador = nombreC;
        this.escenarios = new Escenario[5];
        this.artistas = new ArrayList<Artista>();
    }

    public String GetFestival() {
        return ("Festival \n - codigo: " + codigo + "\n - nombre: " + nombre + "\n - Nombre del Coordinador: "
                + nombreCoordinador);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCoordinador() {
        return nombreCoordinador;
    }

    public void setNombreCoordinador(String nombreCoordinador) {
        this.nombreCoordinador = nombreCoordinador;
    }

    public Escenario[] getEscenarios() {
        return escenarios;
    }

    public ArrayList<Artista> getArtistas() {
        return artistas;
    }

}