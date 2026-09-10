package model;

public class Ronda {
    private int numeroRonda;
    private Entrenador entrenadorAtacante;
    private Entrenador entrenadorDefensor;
    private Pokemon pokemonAtacante;
    private Pokemon pokemonDefensor;
    private int bonoTipo;
    private double ataqueTotal;
    private String resultado;
   
    public Ronda(int numeroRonda, Entrenador entrenadorAtacante, Entrenador entrenadorDefensor,
                 Pokemon pokemonAtacante, Pokemon pokemonDefensor) {
        this.numeroRonda = numeroRonda;
        this.entrenadorAtacante = entrenadorAtacante;
        this.entrenadorDefensor = entrenadorDefensor;
        this.pokemonAtacante = pokemonAtacante;
        this.pokemonDefensor = pokemonDefensor;
    }

    public void calcularResultado(int bonoTipo, int potenciadorAtaque, int potenciadorDefensa) {
        this.bonoTipo = bonoTipo;
        double ataqueEfectivo = pokemonAtacante.getAtaque()
                + (pokemonAtacante.getAtaque() * potenciadorAtaque / 100.0);
        double defensaEfectiva = pokemonDefensor.getDefensa()
                + (pokemonDefensor.getDefensa() * potenciadorDefensa / 100.0);
 
        this.ataqueTotal = ataqueEfectivo + bonoTipo - defensaEfectiva;
 
        if (ataqueTotal > 0) {
            this.resultado = "ATACANTE";
        } else if (ataqueTotal < 0) {
            this.resultado = "DEFENSOR";
        } else {
            this.resultado = "EMPATE";
        }
    }
 
    public int getNumeroRonda() {
        return numeroRonda;
    }
 
    public Entrenador getEntrenadorAtacante() {
        return entrenadorAtacante;
    }
 
    public Entrenador getEntrenadorDefensor() {
        return entrenadorDefensor;
    }
 
    public Pokemon getPokemonAtacante() {
        return pokemonAtacante;
    }
 
    public Pokemon getPokemonDefensor() {
        return pokemonDefensor;
    }
 
    public int getBonoTipo() {
        return bonoTipo;
    }
 
    public double getAtaqueTotal() {
        return ataqueTotal;
    }
 
    public String getResultado() {
        return resultado;
    }
 
    @Override
    public String toString() {
        String ganador;
        if (resultado.equals("ATACANTE")) {
            ganador = entrenadorAtacante.getNombre();
        } else if (resultado.equals("DEFENSOR")) {
            ganador = entrenadorDefensor.getNombre();
        } else {
            ganador = "Nadie (empate)";
        }
 
        return String.format(
                "Ronda %d: %s (%s) ataca -> %s (%s) defiende | bono tipo: %+d | ataque total: %.2f | gana: %s",
                numeroRonda,
                entrenadorAtacante.getNombre(), pokemonAtacante.getNombre(),
                entrenadorDefensor.getNombre(), pokemonDefensor.getNombre(),
                bonoTipo, ataqueTotal, ganador);
    }

}
