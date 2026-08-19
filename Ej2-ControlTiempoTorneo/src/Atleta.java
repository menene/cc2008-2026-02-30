public class Atleta {
    // Atributos
    private String nombre;
    private int edad, numeroParticipante, numIntentos;
    private float[] tiempos; 

    // Método constructor
    public Atleta(String nombre, int edad, int numeroParticipante, int numIntentos) {
        this.nombre = nombre;
        this.edad = edad;
        this.numeroParticipante = numeroParticipante;
        this.tiempos = new float[numIntentos];
        this.numIntentos = numIntentos;
    }

    // Getters
    public String getNombre() {
        return this.nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public int numeroParticipante() {
        return this.numeroParticipante;
    }

    public float[] getTiempos() {
        return this.getTiempos();
    }

    // Calcula la cantidad de intentos realizados recorriendo la lista de tiempos y contando aquellos valores superiores a 0.
    public int getIntentosRealizados() {
        int contador = 0;

        for (float tiempo: tiempos) {
            if (tiempo > 0.0) {
                contador++;
            }
        }

        return contador;
    }

    // Calcula y retorna la cantidad de intentos disponibles, restando al número de intentos total del atleta, los intentos realizados.
    public int getDisponibles() {
        return numIntentos - getIntentosRealizados();
    }

    // Sobreescribimos este método para que retorne un String de la información del atleta y de los intentos realizados y disponibles para que sea más fácil para el usuario estar informado.
    @Override
    public String toString() {
        return String.format(
            """
            +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-
                        ATLETA ACTIVO
            +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-
            Nombre:                  %s
            Número de participante:  %d
            Edad:                    %d
            Intentos realizados:     %d
            Intentos disponibles:    %d
            +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-
            """,
            nombre,
            numeroParticipante,
            edad,
            getIntentosRealizados(),
            getDisponibles()
        );
    }
}
