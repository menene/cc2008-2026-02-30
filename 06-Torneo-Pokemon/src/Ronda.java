public class Ronda {

    private int numeroRonda;
    private Entrenador entrenadorAtacante;
    private Entrenador entrenadorDefensor;
    private Pokemon pokemonAtacante;
    private Pokemon pokemonDefensor;
    private int bonoTipo;
    private double ataqueTotal;
    private String resultado;

    public Ronda(int numeroRonda,
                 Entrenador atacante,
                 Entrenador defensor,
                 Pokemon pokemonAtacante,
                 Pokemon pokemonDefensor) {

        this.numeroRonda = numeroRonda;
        this.entrenadorAtacante = atacante;
        this.entrenadorDefensor = defensor;
        this.pokemonAtacante = pokemonAtacante;
        this.pokemonDefensor = pokemonDefensor;
    }

    public void calcularResultado(int bonoTipo,
                                  int potenciadorAtaque,
                                  int potenciadorDefensa) {

        this.bonoTipo = bonoTipo;

        double ataqueEfectivo =
            pokemonAtacante.getAtaque()
            + (pokemonAtacante.getAtaque() * potenciadorAtaque / 100.0);

        double defensaEfectiva =
            pokemonDefensor.getDefensa()
            + (pokemonDefensor.getDefensa() * potenciadorDefensa / 100.0);

        ataqueTotal = ataqueEfectivo + bonoTipo - defensaEfectiva;

        if (ataqueTotal > 0) {
            resultado = "ATACANTE";
        } else if (ataqueTotal < 0) {
            resultado = "DEFENSOR";
        } else {
            resultado = "EMPATE";
        }
    }

    public String getResultado() {
        return resultado;
    }

    public double getAtaqueTotal() {
        return ataqueTotal;
    }

    public Pokemon getPokemonAtacante() {
        return pokemonAtacante;
    }

    public Pokemon getPokemonDefensor() {
        return pokemonDefensor;
    }

   @Override
public String toString() {

    String mensajeResultado;

    if (resultado.equals("ATACANTE")) {
        mensajeResultado = "Ganó el jugador atacante";
    } else if (resultado.equals("DEFENSOR")) {
        mensajeResultado = "Ganó el jugador defensor";
    } else {
        mensajeResultado = "Empate";
    }

    return "Ronda " + numeroRonda
        + ": " + entrenadorAtacante.getNombre()
        + " ataca con " + pokemonAtacante.getNombre()
        + " contra " + pokemonDefensor.getNombre()
        + " de " + entrenadorDefensor.getNombre()
        + " | Resultado: " + mensajeResultado;
    }
}