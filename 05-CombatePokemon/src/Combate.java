public class Combate {

    // Atributos
    private Entrenador entrenador1;
    private Entrenador entrenador2;

    private int rondasGanadasE1;
    private int rondasGanadasE2;
    private int rondaActual;

    // Constructor
    public Combate(Entrenador entrenador1, Entrenador entrenador2) {

        // Inicializa los entrenadores
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;

        // Inicializa las rondas ganadas y la ronda actual
        this.rondasGanadasE1 = 0;
        this.rondasGanadasE2 = 0;
        this.rondaActual = 1;
    }

    // Suma una ronda ganada al Entrenador 1
    public void sumarRondaE1() {
        rondasGanadasE1++;
    }

    // Suma una ronda ganada al Entrenador 2
    public void sumarRondaE2() {
        rondasGanadasE2++;
    }

    // Avanza a la siguiente ronda
    public void avanzarRonda() {
        rondaActual++;
    }

    // Getters
    public Entrenador getEntrenador1() {
        return entrenador1;
    }

    public Entrenador getEntrenador2() {
        return entrenador2;
    }

    public int getRondasGanadasE1() {
        return rondasGanadasE1;
    }

    public int getRondasGanadasE2() {
        return rondasGanadasE2;
    }

    public int getRondaActual() {
        return rondaActual;
    }
}