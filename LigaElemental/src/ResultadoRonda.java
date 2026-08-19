public class ResultadoRonda {
    private int numeroRonda;
    private Pokemon pokemonAtacante;
    private Pokemon pokemonDefensor;
    private double ataqueEfectivo;
    private double defensaEfectiva;
    private int bonoTipo;
    private double ataqueTotal;
    private String ganadorRonda; 

    public ResultadoRonda(int numeroRonda, Pokemon pokemonAtacante, Pokemon pokemonDefensor,
                           double ataqueEfectivo, double defensaEfectiva, int bonoTipo) {
        this.numeroRonda = numeroRonda;
        this.pokemonAtacante = pokemonAtacante;
        this.pokemonDefensor = pokemonDefensor;
        this.ataqueEfectivo = ataqueEfectivo;
        this.defensaEfectiva = defensaEfectiva;
        this.bonoTipo = bonoTipo;
    }

    public void calcularResultado() {
        ataqueTotal = ataqueEfectivo + bonoTipo - defensaEfectiva;

        if (ataqueTotal > 0) {
            ganadorRonda = "Atacante";
        } 
        else if (ataqueTotal < 0) {
            ganadorRonda = "Defensor";
        } 
        else {
            ganadorRonda = "Empate";
        }
    }

    public String getGanadorRonda() {
        return ganadorRonda;
    }

    // Getters adicionales - No estaban en la tabla de análisis -
    // Imprimén los detalles de cada ronda
    public int getNumeroRonda() {
        return numeroRonda;
    }

    public Pokemon getPokemonAtacante() {
        return pokemonAtacante;
    }

    public Pokemon getPokemonDefensor() {
        return pokemonDefensor;
    }

    public double getAtaqueTotal() {
        return ataqueTotal;
    }
}