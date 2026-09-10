import java.util.ArrayList;

public class Festival {
    private ArrayList<Artista> artista;
    private Escenario[] escenario;
    private String nombre;
    private String codigo;
    private String nombre_coordinador;

    public Festival(String codigo, String nombre, String nombre_coordinador) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nombre_coordinador = nombre_coordinador;
        escenario = new Escenario[5];
        artista = new ArrayList<Artista>();
    }

    public String Getnombre() {
        return nombre;
    }

    public String Getcodigo() {
        return codigo;
    }

    public String Getnombre_coordinador() {
        return nombre_coordinador;
    }

    public Escenario[] getEscenarios() {
        return escenario;
    }

    public ArrayList<Artista> getArtistas() {
        return artista;
    }

    public void agregarEscenario(int posicion, Escenario escenario) {
        if (posicion < 0 || posicion >= this.escenario.length) {
            throw new IllegalArgumentException(
                "La posición del escenario no es válida."
            );
        }

        if (this.escenario[posicion] != null) {
            throw new IllegalArgumentException(
                "La posición ya contiene un escenario."
            );
        }

        this.escenario[posicion] = escenario;
    }

    public void retirarEscenario(int posicion) {
        if (posicion < 0 || posicion >= escenario.length) {
            throw new IllegalArgumentException(
                "La posición del escenario no es válida."
            );
        }

        if (escenario[posicion] == null) {
            throw new IllegalArgumentException(
                "No hay un escenario en esta posición."
            );
        }

        escenario[posicion] = null;
    }

    public void agregarArtista(Artista artista) {
        for (Artista artistaActual : this.artista) {
            if (artistaActual.GetCodigo_id()
                    .equals(artista.GetCodigo_id())) {
                throw new IllegalArgumentException(
                    "Ya existe un artista con ese código."
                );
            }
        }

        this.artista.add(artista);
    }

    public void eliminarArtista(String codigo) {

        for (int i = 0; i < artista.size(); i++) {

            if (artista.get(i).GetCodigo_id().equals(codigo)) {

                artista.remove(i);
                return;
            }
        }

        throw new IllegalArgumentException(
            "No se encontró un artista con ese código."
        );
    }
}