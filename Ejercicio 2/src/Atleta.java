/**
 * Clase Atleta
 * Almacena los datos personales del atleta activo dentro del torneo.
 */
public class Atleta {

    private String nombre;
    private int numeroParticipante;
    private int edad;

    /**
     * Crea un objeto Atleta sin inicializar sus datos personales.
     */
    public Atleta() {
    }

    /**
     * Crea un atleta inicializando su nombre, número de participante y edad.
     */
    public Atleta(String nombre, int numeroParticipante, int edad) {
        this.nombre = nombre;
        this.numeroParticipante = numeroParticipante;
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNumeroParticipante(int numeroParticipante) {
        this.numeroParticipante = numeroParticipante;
    }

    public int getNumeroParticipante() {
        return numeroParticipante;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }
}