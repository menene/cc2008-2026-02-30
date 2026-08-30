package controller;

import java.util.Arrays;
import model.Athlete;

/* Clase del controlador. Guarda los atletas del torneo y hace los calculos generales. */
public class Controller {

    private Athlete[] athletes;
    private int athletesCounter;
    private Athlete activeAthlete;
    private final int MAX_ATHLETES = 5;

    /* Constructor. Crea el arreglo de atletas vacio y deja el contador en 0 */
    public Controller() {
        athletes = new Athlete[MAX_ATHLETES];
        Arrays.fill(athletes, null);
        athletesCounter = 0;
        activeAthlete = null;
    }

    /* Dice si todavia hay espacio en el arreglo de atletas */
    public boolean hasSpace() {
        if (athletesCounter < MAX_ATHLETES) {
            return true;
        }
        return false;
    }

    /* Guarda el atleta en la siguiente posicion libre y lo deja como atleta activo */
    public void addAthlete(Athlete athlete) {
        if (hasSpace()) {
            athletes[athletesCounter] = athlete;
            athletesCounter = athletesCounter + 1;
            activeAthlete = athlete;
        }
    }

    /* Devuelve el atleta con el que se esta trabajando */
    public Athlete getActiveAthlete() {
        return activeAthlete;
    }

    /* Devuelve cuantos atletas hay registrados */
    public int getAthletesCounter() {
        return athletesCounter;
    }

    /* Busca la posicion de un atleta por su numero. Devuelve -1 si no existe */
    private int findAthleteIndex(int number) {
        for (int i = 0; i < athletesCounter; i++) {
            if (athletes[i].getNumber() == number) {
                return i;
            }
        }
        return -1;
    }

    /* Devuelve el objeto atleta que tenga ese numero. Devuelve null si no existe */
    public Athlete getAthlete(int number) {
        int posicion = findAthleteIndex(number);

        if (posicion == -1) {
            return null;
        }

        return athletes[posicion];
    }

    /* Saca el promedio de todos los tiempos de todos los atletas del torneo */
    public double getOverallAverage() {
        int sumaTiempos = 0;
        int cantidadTiempos = 0;

        for (int i = 0; i < athletesCounter; i++) {
            int[] tiempos = athletes[i].getAttemptTimes();

            for (int j = 0; j < tiempos.length; j++) {
                sumaTiempos = sumaTiempos + tiempos[j];
                cantidadTiempos = cantidadTiempos + 1;
            }
        }

        if (cantidadTiempos == 0) {
            return 0.0;
        }

        return (double) sumaTiempos / cantidadTiempos;
    }

    /* Busca el atleta que tenga el mejor tiempo del torneo */
    public Athlete getWinner() {
        Athlete ganador = null;

        for (int i = 0; i < athletesCounter; i++) {
            Athlete atleta = athletes[i];

            if (atleta.getBestTime() != -1) {
                if (ganador == null) {
                    ganador = atleta;
                } else if (atleta.getBestTime() < ganador.getBestTime()) {
                    ganador = atleta;
                }
            }
        }

        return ganador;
    }

    /* Arma el texto con todos los atletas, sus tiempos y sus promedios */
    public String getResults() {
        if (athletesCounter == 0) {
            return "No hay atletas registrados";
        }

        String resultados = "";

        for (int i = 0; i < athletesCounter; i++) {
            Athlete atleta = athletes[i];

            resultados = resultados + "Atleta No. " + atleta.getNumber() + " - " + atleta.getName() + "\n";
            resultados = resultados + "  Tiempos: " + Arrays.toString(atleta.getAttemptTimes()) + "\n";
            resultados = resultados + "  Intentos: " + atleta.getAttemptsCounter() + "\n";
            resultados = resultados + "  Promedio: " + atleta.getAverageTime() + "\n";
            resultados = resultados + "  Mejor tiempo: " + atleta.getBestTime() + "\n";
        }

        resultados = resultados + "Promedio general del torneo: " + getOverallAverage();

        return resultados;
    }
}
