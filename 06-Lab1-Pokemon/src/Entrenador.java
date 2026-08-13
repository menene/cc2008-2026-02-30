public class Entrenador {
    private String nombreEntrenador;
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Pokemon pokemon3;
    private Pokemon pokemon4;

    public Entrenador(String nombreEntrenador, Pokemon pokemon1, Pokemon pokemon2, Pokemon pokemon3, Pokemon pokemon4) {
        this.nombreEntrenador = nombreEntrenador;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.pokemon3 = pokemon3;
        this.pokemon4 = pokemon4;
    }

    public String getNombreEntrenador() {
        return nombreEntrenador;
    }

    public Pokemon seleccionarPokemon() {
        
        Pokemon pokemonEscogido;

        do {
            int numero = (int) (Math.random() * 4) + 1;

            if (numero == 1){
                pokemonEscogido = pokemon1;
            } else if (numero == 2) {
                pokemonEscogido = pokemon2;
            } else if (numero == 3) {
                pokemonEscogido = pokemon3;
            } else {
                pokemonEscogido = pokemon4;
            }
        } while (pokemonEscogido.getYaPeleo());

        pokemonEscogido.marcarComoPeleado();

        return pokemonEscogido;
    }
}