import java.util.ArrayList;
import java.util.Random;

public class Ronda {

    private Pokemon pokemonAtaque;
    private Pokemon pokemonDefensa;

    private boolean ataqueValido;
    private int porcentajeAtaque;
    private int cantidadAtaque;

    private boolean defensaValida;
    private int porcentajeDefensa;
    private int cantidadDefensa;

    private int bonoTipo;
    private int resultado;

    private String ganadorRonda;

    private Random random;


    public Ronda() {

        pokemonAtaque = null;
        pokemonDefensa = null;

        ataqueValido = false;
        porcentajeAtaque = 0;
        cantidadAtaque = 0;

        defensaValida = false;
        porcentajeDefensa = 0;
        cantidadDefensa = 0;

        bonoTipo = 0;
        resultado = 0;

        ganadorRonda = "";

        random = new Random();
    }


    public Pokemon generarPokemonAtaque(Entrenador entrenador) {

        ArrayList<Pokemon> pokemones =
                entrenador.getEleccion_pokemon();

        if (!pokemones.isEmpty()) {

            int posicion = random.nextInt(pokemones.size());

            pokemonAtaque = pokemones.get(posicion);

            return pokemonAtaque;
        }

        return null;
    }


    public Pokemon generarPokemonDefensa(Entrenador entrenador) {

        ArrayList<Pokemon> pokemones =
                entrenador.getEleccion_pokemon();

        if (!pokemones.isEmpty()) {

            int posicion = random.nextInt(pokemones.size());

            pokemonDefensa = pokemones.get(posicion);

            return pokemonDefensa;
        }

        return null;
    }


    public boolean validarAtaqueValido(Pokemon pokemon) {

        if (pokemon == null) {
            ataqueValido = false;
            return false;
        }

        int numeroAtaque = random.nextInt(101);

        ataqueValido =
                numeroAtaque <= pokemon.getProbabilidadHabilidad();

        return ataqueValido;
    }


    public void generarPorcentajeAtaque() {

        if (ataqueValido) {
            porcentajeAtaque = random.nextInt(26);
        } else {
            porcentajeAtaque = 0;
        }
    }


    public void generarAtaqueBonificado(Pokemon pokemon) {

        if (pokemon == null) {
            cantidadAtaque = 0;
            return;
        }

        cantidadAtaque = pokemon.getAtaque();

        if (ataqueValido) {

            cantidadAtaque =
                    pokemon.getAtaque()
                    + (pokemon.getAtaque()
                    * porcentajeAtaque / 100);
        }
    }


    public boolean validarDefensaValida(Pokemon pokemon) {

        if (pokemon == null) {
            defensaValida = false;
            return false;
        }

        int numeroDefensa = random.nextInt(101);

        defensaValida =
                numeroDefensa <= pokemon.getProbabilidadHabilidad();

        return defensaValida;
    }


    public void generarPorcentajeDefensa() {

        if (defensaValida) {
            porcentajeDefensa = random.nextInt(26);
        } else {
            porcentajeDefensa = 0;
        }
    }


    public void generarDefensaBonificada(Pokemon pokemon) {

        if (pokemon == null) {
            cantidadDefensa = 0;
            return;
        }

        cantidadDefensa = pokemon.getDefensa();

        if (defensaValida) {

            cantidadDefensa =
                    pokemon.getDefensa()
                    + (pokemon.getDefensa()
                    * porcentajeDefensa / 100);
        }
    }


    public int calcularBonoTipo(
            Pokemon atacante,
            Pokemon defensor) {

        if (atacante == null || defensor == null) {
            return 0;
        }

        String tipoAtaque = atacante.getTipo();
        String tipoDefensa = defensor.getTipo();


        if (tipoAtaque.equals("Fuego")
                && tipoDefensa.equals("Planta")) {

            return 20;
        }

        if (tipoAtaque.equals("Fuego")
                && tipoDefensa.equals("Agua")) {

            return -10;
        }


        if (tipoAtaque.equals("Agua")
                && tipoDefensa.equals("Fuego")) {

            return 20;
        }

        if (tipoAtaque.equals("Agua")
                && tipoDefensa.equals("Planta")) {

            return -10;
        }


        if (tipoAtaque.equals("Planta")
                && tipoDefensa.equals("Agua")) {

            return 20;
        }

        if (tipoAtaque.equals("Planta")
                && tipoDefensa.equals("Fuego")) {

            return -10;
        }


        if (tipoAtaque.equals("Electrico")
                && tipoDefensa.equals("Agua")) {

            return 20;
        }



        return 0;
    }



    public String calcularResultado(
            Pokemon atacante,
            Pokemon defensor) {

        bonoTipo = calcularBonoTipo(atacante, defensor);

        resultado =
                cantidadAtaque
                + bonoTipo
                - cantidadDefensa;


        if (resultado > 0) {

            ganadorRonda = "Atacante";

        } else if (resultado < 0) {

            ganadorRonda = "Defensor";

        } else {

            ganadorRonda = "Empate";
        }

        return ganadorRonda;
    }


    public String realizarRonda(
            Entrenador atacante,
            Entrenador defensor) {

        Pokemon pokemonAtacante =
                generarPokemonAtaque(atacante);

        Pokemon pokemonDefensor =
                generarPokemonDefensa(defensor);



        validarAtaqueValido(pokemonAtacante);

        generarPorcentajeAtaque();

        generarAtaqueBonificado(pokemonAtacante);


        validarDefensaValida(pokemonDefensor);

        generarPorcentajeDefensa();

        generarDefensaBonificada(pokemonDefensor);


        return calcularResultado(
                pokemonAtacante,
                pokemonDefensor);
    }


    public Pokemon getPokemonAtaque() {
        return pokemonAtaque;
    }

    public Pokemon getPokemonDefensa() {
        return pokemonDefensa;
    }

    public int getCantidadAtaque() {
        return cantidadAtaque;
    }

    public int getCantidadDefensa() {
        return cantidadDefensa;
    }

    public int getPorcentajeAtaque() {
        return porcentajeAtaque;
    }

    public int getPorcentajeDefensa() {
        return porcentajeDefensa;
    }

    public int getBonoTipo() {
        return bonoTipo;
    }

    public int getResultado() {
        return resultado;
    }

    public String getGanadorRonda() {
        return ganadorRonda;
    }
}