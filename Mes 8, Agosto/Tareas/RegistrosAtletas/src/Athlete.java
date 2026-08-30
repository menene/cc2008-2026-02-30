import java.util.Arrays;
public class Athlete{
    private String name;
    private int age;
    private int number;
    private int[] attemptTimes= new int[10];
    private int attemptsCounter;
    public Athlete(String name, int number, int age){
        this.name = name;
        this.number = number;
        this.age = age;
    }
    public String getName(){ return this.name; }
    public int getAge(){ return this.age; }
    public int getNumber(){ return this.number; }
    public void addAttempt(int time){
        this.attemptTimes[attemptsCounter]=time;
        attemptsCounter++;
    }
    public void changeAttemptTime(int index, int time){
        this.attemptTimes[index]=time;
    }
    public int getAttemptTime(int index){ return this.attemptTimes[index]; }
    public int getAvailableAttempts(){ return (10-attemptsCounter); }
    public int[] getAttempts(){ return attemptTimes; }
    public double getAverageTime(){ 
        double average=0;
        for(int i:attemptTimes){
            average+=i;
        }
        average/= attemptTimes.length;
        return average;
    }
    public int getBestTime(){
        int[] ordenar = attemptTimes.clone();
        Arrays.sort(ordenar);
        return ordenar[ordenar.length-1];
    }
}