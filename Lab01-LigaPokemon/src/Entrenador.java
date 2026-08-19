import java.util.Random;

public class Entrenador {

    private String nombre;
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Pokemon pokemon3;
    private Pokemon pokemon4;

    public Entrenador(String nombre, Pokemon pokemon1, Pokemon pokemon2, Pokemon pokemon3, Pokemon pokemon4) {
        this.nombre = nombre;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.pokemon3 = pokemon3;
        this.pokemon4 = pokemon4;
    }

    public Pokemon obtenerPokemonDisponible() {
        Random random = new Random();
        Pokemon elegido = null;

        while (elegido == null) {
            int indice = random.nextInt(4) + 1;

            switch (indice) {
                case 1:
                    if (pokemon1.isDisponible()) {
                        elegido = pokemon1;
                    }
                    break;
                case 2:
                    if (pokemon2.isDisponible()) {
                        elegido = pokemon2;
                    }
                    break;
                case 3:
                    if (pokemon3.isDisponible()) {
                        elegido = pokemon3;
                    }
                    break;
                case 4:
                    if (pokemon4.isDisponible()) {
                        elegido = pokemon4;
                    }
                    break;
            }
        }

        return elegido;
    }

    
    public String getNombre() {
        return nombre;
    }
    
}