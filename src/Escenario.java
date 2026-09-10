import java.util.ArrayList;

public class Escenario {

    public int codigoEscenario;
    public String nombreEscenario;
    public String ubicacionEscenario;
    public int capacidadEscenario;
    public String estadoEscenario;
    public ArrayList<Artista> artistas;

    public Escenario(int codigoEscenario, String nombreEscenario, String ubicacionEscenario, int capacidadEscenario, String estadoEscenario) {

        validarTexto(nombreEscenario, "El nombre del escenario no puede estar vacio.");
        validarTexto(ubicacionEscenario, "La ubicacion del escenario no puede estar vacia.");
        validarTexto(estadoEscenario, "El estado del escenario no puede estar vacio.");

        if (capacidadEscenario <= 0) {
            throw new IllegalArgumentException("La capacidad del escenario debe ser mayor que 0.");
        }

        this.codigoEscenario = codigoEscenario;
        this.nombreEscenario = nombreEscenario;
        this.ubicacionEscenario = ubicacionEscenario;
        this.capacidadEscenario = capacidadEscenario;
        this.estadoEscenario = estadoEscenario;
        artistas = new ArrayList<Artista>();
    }

    public void cambiarCapacidad(int capacidadEscenario) {

        if (capacidadEscenario <= 0) {
            throw new IllegalArgumentException("La capacidad del escenario debe ser mayor que 0.");
        }

        this.capacidadEscenario = capacidadEscenario;
    }

    public void cambiarEstado(String estadoEscenario) {

        validarTexto(estadoEscenario, "El estado del escenario no puede estar vacio.");
        this.estadoEscenario = estadoEscenario;
    }

    private void validarTexto(String texto, String mensaje) {

        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException(mensaje);
        }
    }

    public String toString() {

        return "Codigo: " + codigoEscenario
            + " | Nombre: " + nombreEscenario
            + " | Ubicacion: " + ubicacionEscenario
            + " | Capacidad: " + capacidadEscenario
            + " | Estado: " + estadoEscenario;
    }
}
