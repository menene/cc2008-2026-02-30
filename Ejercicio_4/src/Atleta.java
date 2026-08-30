public class Atleta{
    private String nombre;
    private int numeroParticipante;
    private int edad;
    private ControlTiempos controlTiempos;
    public Atleta(String nombre, int numeroParticipante, int edad) {
        this.nombre = nombre;
        this.numeroParticipante = numeroParticipante;
        this.edad = edad;
        controlTiempos = new ControlTiempos();
    }
    public String getNombre(){
        return nombre;
    }
    public int getNumeroParticipante(){
        return numeroParticipante;
    }
    public int getEdad(){
        return edad;
    }
    public ControlTiempos getControlTiempos(){
        return controlTiempos;
    }
}