public class Combate {
    private Entrenador entrenador1;
    private Entrenador entrenador2;

    public Combate(Entrenador entrenador1, Entrenador entrenador2) {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
    }

    public Entrenador GetEntrenador1() {
        return this.entrenador1;
    }

    public Entrenador GetEntrenador2() {
        return this.entrenador2;
    }
}