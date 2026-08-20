public class Torneo {
    private Atleta[] atletas; 


    public Torneo(Atleta[] atletas){

        this.atletas = new Atleta[1];
        atletas[0] = new Atleta("Juan", 17, 1, 10);
    
    }
    public Atleta getAtleta(int numeroParticipante){

        return atletas[(numeroParticipante - 1)];
    }
    public String toString(){
        return "waza";
    }
        

}
