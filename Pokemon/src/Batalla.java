public class Batalla {
    private Entrenador j1;
    private Entrenador j2;
    private int victoriasJ1;
    private int victoriasJ2;
    private boolean habilidadAtaqueActivada;
    private boolean habilidadDefensaActivada;
    private float potenciadorAtaque;
    private float potenciadorDefensa;
    private String ganador;

    public Batalla(Entrenador j1, Entrenador j2) {

        this.j1 = j1;
        this.j2 = j2;

        victoriasJ1 = 0;
        victoriasJ2 = 0;
        ganador = "";
    }


    private int efectividad(Pokemon atacante, Pokemon defensor) {

        String ataque = atacante.getTipo();
        String defensa = defensor.getTipo();

        if (ataque.equalsIgnoreCase("Fuego")
                && defensa.equalsIgnoreCase("Planta")) {
            return 20;

        } else if (ataque.equalsIgnoreCase("Agua")
                && defensa.equalsIgnoreCase("Fuego")) {
            return 20;

        } else if (ataque.equalsIgnoreCase("Planta")
                && defensa.equalsIgnoreCase("Agua")) {
            return 20;

        } else if (ataque.equalsIgnoreCase("Electrico")
                && defensa.equalsIgnoreCase("Agua")) {
            return 20;
        }

        else if (ataque.equalsIgnoreCase("Fuego")
                && defensa.equalsIgnoreCase("Agua")) {
            return -10;

        } else if (ataque.equalsIgnoreCase("Agua")
                && defensa.equalsIgnoreCase("Planta")) {
            return -10;

        } else if (ataque.equalsIgnoreCase("Planta")
                && defensa.equalsIgnoreCase("Fuego")) {
            return -10;
        }

        return 0;
    }


    private double ataqueTotal(Pokemon atacante, int efectividad) {

        double ataque = atacante.getAtaque();

        Habilidad habilidad = atacante.getHabilidad();

        habilidadAtaqueActivada = habilidad.activarHabilidad();

        if (habilidadAtaqueActivada) {

            potenciadorAtaque = habilidad.getPotenciador();

            ataque = ataque
                    + (ataque * potenciadorAtaque / 100);
        } else {

            potenciadorAtaque = 0;
        }

        return ataque + efectividad;
    }


    private double defensaTotal(Pokemon defensor) {

        double defensa = defensor.getDefensa();

        Habilidad habilidad = defensor.getHabilidad();

        habilidadDefensaActivada = habilidad.activarHabilidad();

        if (habilidadDefensaActivada) {

            potenciadorDefensa = habilidad.getPotenciador();

            defensa = defensa
                    + (defensa * potenciadorDefensa / 100);
        } else {

            potenciadorDefensa = 0;
        }

        return defensa;
    }


    public int ronda(Pokemon atacante, Pokemon defensor) {

        int efectividad = efectividad(atacante, defensor);

        double ataque = ataqueTotal(
                atacante,
                efectividad
        );

        double defensa = defensaTotal(defensor);

        double resultado = ataque - defensa;

        if (resultado > 0) {
            return 1;

        } else if (resultado < 0) {
            return 2;

        } else {
            return 0;
        }
    }


    public void victoriaJ1() {
        victoriasJ1++;
    }


    public void victoriaJ2() {
        victoriasJ2++;
    }


    public String ganador() {

        if (victoriasJ1 > victoriasJ2) {

            ganador = j1.getNombre();

        } else if (victoriasJ2 > victoriasJ1) {

            ganador = j2.getNombre();

        } else {

            ganador = "Empate";
        }

        return ganador;
    }

    public Entrenador getJ1() {
        return j1;
    }

    public Entrenador getJ2() {
        return j2;
    }

    public boolean getHabilidadAtaqueActivada() {
    return habilidadAtaqueActivada;
    }

    public boolean getHabilidadDefensaActivada() {
        return habilidadDefensaActivada;
    }

    public float getPotenciadorAtaque() {
        return potenciadorAtaque;
    }

    public float getPotenciadorDefensa() {
        return potenciadorDefensa;
    }
    
}