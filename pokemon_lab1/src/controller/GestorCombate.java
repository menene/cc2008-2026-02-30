package controller;
 
import java.util.ArrayList;
 
import model.Entrenador;
import model.Pokemon;
import model.Pokemon.TipoPokemon;
import model.Ronda;

public class GestorCombate {
 
    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private ArrayList<Ronda> rondas;

    private static final int[][] MATRIZ_EFECTIVIDAD_TIPO = {
            /*FUEGO  AGUA  PLANTA  ELECTRICO */
            /* FUEGO      */ { 0, -10, 20, 0 },
            /* AGUA       */ { 20, 0, -10, 0 },
            /* PLANTA     */ { -10, 20, 0, 0 },
            /* ELECTRICO  */ { 0, 20, 0, 0 }
    };
 
    public GestorCombate(Entrenador entrenador1, Entrenador entrenador2) {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
        this.rondas = new ArrayList<>();
    }

    public void iniciarCombate() {
        boolean atacaEntrenador1 = true;
        for (int numeroRonda = 1; numeroRonda <= 4; numeroRonda++) {
            Entrenador atacante = atacaEntrenador1 ? entrenador1 : entrenador2;
            Entrenador defensor = atacaEntrenador1 ? entrenador2 : entrenador1;
 
            Ronda ronda = jugarRonda(numeroRonda, atacante, defensor);
            rondas.add(ronda);
 
            atacaEntrenador1 = !atacaEntrenador1;
        }
    }
 
    private Ronda jugarRonda(int numeroRonda, Entrenador atacante, Entrenador defensor) {
        Pokemon pokemonAtacante = atacante.seleccionarPokemonDisponible();
        Pokemon pokemonDefensor = defensor.seleccionarPokemonDisponible();
 
        int potenciadorAtaque = pokemonAtacante.intentarActivarHabilidad();
        int potenciadorDefensa = pokemonDefensor.intentarActivarHabilidad();
 
        int bonoTipo = calcularBonoTipo(pokemonAtacante.getTipo(), pokemonDefensor.getTipo());
 
        Ronda ronda = new Ronda(numeroRonda, atacante, defensor, pokemonAtacante, pokemonDefensor);
        ronda.calcularResultado(bonoTipo, potenciadorAtaque, potenciadorDefensa);
        return ronda;
    }

    private int calcularBonoTipo(TipoPokemon tipoAtacante, TipoPokemon tipoDefensor) {
        return MATRIZ_EFECTIVIDAD_TIPO[tipoAtacante.ordinal()][tipoDefensor.ordinal()];
    }

    public String obtenerGanadorCombate() {
        int victorias1 = 0;
        int victorias2 = 0;
 
        for (Ronda ronda : rondas) {
            if (ronda.getResultado().equals("EMPATE")) {
                continue;
            }
            Entrenador ganadorRonda = ronda.getResultado().equals("ATACANTE")
                    ? ronda.getEntrenadorAtacante()
                    : ronda.getEntrenadorDefensor();
 
            if (ganadorRonda == entrenador1) {
                victorias1++;
            } else {
                victorias2++;
            }
        }
 
        if (victorias1 > victorias2) {
            return entrenador1.getNombre();
        } else if (victorias2 > victorias1) {
            return entrenador2.getNombre();
        } else {
            return "Empate";
        }
    }
 
    public ArrayList<Ronda> getRondas() {
        return rondas;
    }
}
