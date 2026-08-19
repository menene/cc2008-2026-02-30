package Model;

public class Combate {

    private Entrenador entrenadorA;
    private Entrenador entrenadorB;
    private Ronda[] rondas;
    private int victoriasA;
    private int victoriasB;

    public Combate(
            Entrenador entrenadorA,
            Entrenador entrenadorB) {

        this.entrenadorA = entrenadorA;
        this.entrenadorB = entrenadorB;
        this.rondas = new Ronda[4];
        this.victoriasA = 0;
        this.victoriasB = 0;
    }

    public void registrarVictoriaA() {
        victoriasA++;
    }

    public void registrarVictoriaB() {
        victoriasB++;
    }

    public String determinarGanador() {

        if (victoriasA > victoriasB) {
            return entrenadorA.getNombreEntrenador();
        }

        if (victoriasB > victoriasA) {
            return entrenadorB.getNombreEntrenador();
        }

        return "Empate";
    }

    public Entrenador getEntrenadorA() {
        return entrenadorA;
    }

    public Entrenador getEntrenadorB() {
        return entrenadorB;
    }

    public Ronda[] getRondas() {
        return rondas;
    }

    public int getVictoriasA() {
        return victoriasA;
    }

    public int getVictoriasB() {
        return victoriasB;
    }
} 