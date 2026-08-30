public class Competencia {

    private Atleta atleta;

    public Competencia(Atleta atleta){
        this.atleta=atleta;
    }

    public void cambiarAtleta(Atleta atleta){
        this.atleta=atleta;
    }

    public int consultarIntentos(){
        int a=0;
        for (double numero:atleta.tiempos){
            if (numero!=0){
                a++;
            }
        }
        return a;
    }

    public double[] consultarTiempos(){
        return atleta.tiempos;
    }

    public double consultarUnIntento(int numeroIntento){
        if(numeroIntento>0 && numeroIntento<=consultarIntentos()){
            return atleta.tiempos[numeroIntento-1];
        }
        return -1;
    }

    public double consultarPromedio(){
        int intentos=consultarIntentos();
        if(intentos==0){
            return -1;
        }
        double suma=0;
        for(int i=0;i<intentos;i++){
            suma+=atleta.tiempos[i];
        }
        return suma/intentos;
    }

    public double mejorTiempo(){
        int intentos=consultarIntentos();
        if(intentos==0){
            return -1;
        }
        double menor=atleta.tiempos[0];
        for(int i=1;i<intentos;i++){
            if(atleta.tiempos[i]<menor){
                menor=atleta.tiempos[i];
            }
        }
        return menor;
    }

    public double mayorTiempo(){
        int intentos=consultarIntentos();
        if(intentos==0){
            return -1;
        }
        double mayor=atleta.tiempos[0];
        for(int i=1;i<intentos;i++){
            if(atleta.tiempos[i]>mayor){
                mayor=atleta.tiempos[i];
            }
        }
        return mayor;
    }

    public boolean registrarTiempo(double tiempo){
        int intentos=consultarIntentos();
        if(tiempo>0 && intentos<atleta.getIntentos()){
            atleta.tiempos[intentos]=tiempo;
            return true;
        }
        return false;
    }

    public boolean modificarTiempo(int numeroIntento, double tiempo){
        if(numeroIntento>0 && numeroIntento<=consultarIntentos() && tiempo>0){
            atleta.tiempos[numeroIntento-1]=tiempo;
            return true;
        }
        return false;
    }

    public int intentosDisponibles(){
        return atleta.getIntentos()-consultarIntentos();
    }
}
