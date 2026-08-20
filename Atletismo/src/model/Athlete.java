package model;

import java.util.Arrays;

/* Clase del atleta. Guarda sus datos y el arreglo con los tiempos de sus intentos. */
public class Athlete {

    private String name;
    private int number;
    private int age;
    private int[] attemptTimes;
    private int attemptsCounter;
    private final int MAX_ATTEMPTS = 10;

    /* Constructor. Recibe los datos del atleta y crea el arreglo de tiempos en 0 */
    public Athlete(String name, int number, int age) {
        this.name = name;
        this.number = number;
        this.age = age;
        attemptTimes = new int[MAX_ATTEMPTS];
        Arrays.fill(attemptTimes, 0);
        attemptsCounter = 0;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getAge() {
        return age;
    }

    /* Dice cuantos intentos ya registro el atleta */
    public int getAttemptsCounter() {
        return attemptsCounter;
    }

    /* Dice cuantas posiciones del arreglo siguen libres */
    public int getAvailableAttempts() {
        return MAX_ATTEMPTS - attemptsCounter;
    }

    /* Guarda un tiempo nuevo en la siguiente posicion disponible del arreglo */
    public void addAttempt(int time) {
        if (time > 0 && attemptsCounter < MAX_ATTEMPTS) {
            attemptTimes[attemptsCounter] = time;
            attemptsCounter = attemptsCounter + 1;
        }
    }

    /* Cambia el tiempo de un intento que ya estaba registrado */
    public void changeAttemptTime(int time, int number) {
        if (time > 0 && number >= 1 && number <= attemptsCounter) {
            attemptTimes[number - 1] = time;
        }
    }

    /* Devuelve el tiempo de un intento. Devuelve -1 si ese intento no existe */
    public int getAttemptTime(int number) {
        if (number >= 1 && number <= attemptsCounter) {
            return attemptTimes[number - 1];
        }
        return -1;
    }

    /* Devuelve una copia del arreglo, solo con las posiciones ya usadas */
    public int[] getAttemptTimes() {
        return Arrays.copyOf(attemptTimes, attemptsCounter);
    }

    /* Suma los tiempos registrados y saca el promedio usando casting */
    public double getAverageTime() {
        if (attemptsCounter == 0) {
            return 0.0;
        }

        int sumaTiempos = 0;

        for (int i = 0; i < attemptsCounter; i++) {
            sumaTiempos = sumaTiempos + attemptTimes[i];
        }

        return (double) sumaTiempos / attemptsCounter;
    }

    /* Recorre el arreglo y busca el tiempo mas bajo, que es el mejor */
    public int getBestTime() {
        if (attemptsCounter == 0) {
            return -1;
        }

        int mejorTiempo = attemptTimes[0];

        for (int i = 1; i < attemptsCounter; i++) {
            if (attemptTimes[i] < mejorTiempo) {
                mejorTiempo = attemptTimes[i];
            }
        }

        return mejorTiempo;
    }

    /* Recorre el arreglo y busca el tiempo mas alto */
    public int getHighestTime() {
        if (attemptsCounter == 0) {
            return -1;
        }

        int tiempoMasAlto = attemptTimes[0];

        for (int i = 1; i < attemptsCounter; i++) {
            if (attemptTimes[i] > tiempoMasAlto) {
                tiempoMasAlto = attemptTimes[i];
            }
        }

        return tiempoMasAlto;
    }
}
