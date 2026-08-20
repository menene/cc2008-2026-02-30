public class Torneo {

    private Atleta[] atletas;

    public Torneo(Atleta[] atletas){
        this.atletas = atletas;
    }

    public Atleta getAtleta(int numeroParticipante){
        for (int i = 0; i < atletas.length; i++) {
            if (atletas[i].numeroParticipante() == numeroParticipante){
                return atletas[i];
            }
        }

        return null;
    }

    public String toString(){
        String resultado = "";

        for (int i = 0; i < atletas.length; i++) {
            resultado += atletas[i].toString() + "\n";
        }

        return resultado;
    }
}