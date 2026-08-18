public class Atleta {
    private String nombre;
    private int edad, numeroParticipante, numIntentos;
    private float[] tiempos; 

    public Atleta(String nombre, int edad, int numeroParticipante, int numIntentos) {
        this.nombre = nombre;
        this.edad = edad;
        this.numeroParticipante = numeroParticipante;
        this.tiempos = new float[numIntentos];
        this.numIntentos = numIntentos;
    }

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

    public int getIntentosRealizados() {
        int contador = 0;

        for (float tiempo: tiempos) {
            if (tiempo != 0.0) {
                contador++;
            }
        }

        return contador;
    }

    public int getDisponibles() {
        return numIntentos - getIntentosRealizados();
    }

    public String toString() {
        return String.format(
            "Nombre de Atleta: %s%n" +
            "Número de Participane: %d%n" +
            "Edad del "
        );
    }
}
