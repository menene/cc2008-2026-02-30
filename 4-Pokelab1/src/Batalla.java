public class Batalla {

    private Entrenador jugador;
    private Entrenador npc;
    private int rondaActual;

    public Batalla(Entrenador jugador, Entrenador npc) {
        this.jugador = jugador;
        this.npc = npc;
        this.rondaActual = 1;
    }


    public double calcularAtaqueEfectivo(Pokemon pokemon, int potenciador) {
        return pokemon.getAtaque() + (pokemon.getAtaque() * potenciador / 100.0);
    }


    public double calcularDefensaEfectiva(Pokemon pokemon, int potenciador) {
        return pokemon.getDefensa() + (pokemon.getDefensa() * potenciador / 100.0);
    }

   
    public int calcularEfectividadTipo(String tipoAtacante, String tipoDefensor) {
        if (tipoAtacante.equals("Fuego")) {
            if (tipoDefensor.equals("Agua")) return -10;
            if (tipoDefensor.equals("Planta")) return 20;
            return 0;
        }
        if (tipoAtacante.equals("Agua")) {
            if (tipoDefensor.equals("Fuego")) return 20;
            if (tipoDefensor.equals("Planta")) return -10;
            return 0;
        }
        if (tipoAtacante.equals("Planta")) {
            if (tipoDefensor.equals("Fuego")) return -10;
            if (tipoDefensor.equals("Agua")) return 20;
            return 0;
        }
        if (tipoAtacante.equals("Electrico")) {
            if (tipoDefensor.equals("Agua")) return 20;
            return 0;
        }
        return 0;
    }


    public double calcularResultadoRonda(double ataqueEfectivo, int bonoTipo, double defensaEfectiva) {
        return ataqueEfectivo + bonoTipo - defensaEfectiva;
    }

    public Entrenador getJugador() {
        return jugador;
    }

    public Entrenador getNpc() {
        return npc;
    }

    public int getRondaActual() {
        return rondaActual;
    }

    public void avanzarRonda() {
        rondaActual++;
    }
}
