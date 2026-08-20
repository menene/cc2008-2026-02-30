public class Controller{
    private Athlete[] athletes;
    private int athletesCounter;
    public Controller(){
        athletes = new Athlete[5];
    }
    public void addAthlete(Athlete athlete){
        athletes[athletesCounter]=athlete;
        athletesCounter++;
    }
    public double getOverallAverage (){
        int sum=0;
        for(int i = 0; i<athletesCounter;i++){
            int[] ni = athletes[i].getAttempts();
            for(int ii : ni){
                sum+=ii;
            }
        }
        return (double)sum/(10*athletesCounter);
    }
    public Athlete getAthlete(int index){
        return athletes[index-1];
    }
    public  boolean hasSpace(){
        if(athletesCounter<athletes.length){
            return true;
        }
        return false;
    }
    public Athlete getWinner(){
        Athlete winner = athletes[0];
        for(int i =1 ; i < athletesCounter ; i++){
            if(athletes[i].getBestTime()> winner.getBestTime()){
                winner = athletes[i];
            }
        }
        return winner;
    }
    public String getResults(){
        String finalResults = "========== FINAL RESULTS ==========";
        for(int i = 0 ; i<athletesCounter; i++){
            Athlete athleteI = athletes[i];
            finalResults+="\nAthlete: "+athleteI.getName()+"\nAttempts: ";
            for(int attempt:athleteI.getAttempts()){
                if(attempt>0){
                    finalResults+=attempt+" ";
                }
            }
            finalResults+="\nBest time: "+athleteI.getBestTime()+"\n";
        }
        finalResults+="\nOverall average: "+getOverallAverage();
        finalResults+="\nWinner: "+getWinner().getName();
        return finalResults;
    }
    public int getAthleteNumber(){ return athletesCounter+1; }
    public Athlete[] getAthletes(){ return athletes; }
}