public class Atleta {
    
    private String nombreAtleta;
    public double[] tiempos;
    private int intentos;
    private int numeroAtleta;
    private int edadAtleta;

    public Atleta(String nombreAtleta, int numeroAtleta, int edadAtleta){
        this.nombreAtleta=nombreAtleta;
        this.numeroAtleta=numeroAtleta;
        this.edadAtleta=edadAtleta;
        intentos=10;
        tiempos=new double[10];
    }

    public int getIntentos(){
        return intentos;
    }
}
