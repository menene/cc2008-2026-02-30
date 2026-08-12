import java.util.Random;

public class Jugador {
    // Atributos
    private String nombre;
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Pokemon pokemon3;
    private Pokemon pokemon4;
    private int rondasGanadas;

    // Constructor de la clase 
    public Jugador(String nombre, Pokemon pokemon1, Pokemon pokemon2,
                   Pokemon pokemon3, Pokemon pokemon4) {

        this.nombre = nombre;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.pokemon3 = pokemon3;
        this.pokemon4 = pokemon4;
        this.rondasGanadas = 0;
    }

    // Getter del nombre
    public String getNombre() {
        return nombre;
    }

    public Pokemon seleccionarPokemon() {
        Random random = new Random();
        Pokemon seleccionado = null;

        while (seleccionado == null) {
            int numero = random.nextInt(4) + 1;

            switch (numero) {
                case 1:
                    if (!pokemon1.estaUsado()) {
                        seleccionado = pokemon1;
                    }
                    break;
                case 2:
                    if (!pokemon2.estaUsado()) {
                        seleccionado = pokemon2;
                    }
                    break;
                case 3:
                    if (!pokemon3.estaUsado()) {
                        seleccionado = pokemon3;
                    }
                    break;
                case 4:
                    if (!pokemon4.estaUsado()) {
                        seleccionado = pokemon4;
                    }
                    break;
            }
        }

        seleccionado.marcarComoUsado();
        return seleccionado;
    }
    
    // Obtiene rondas ganadas
    public int getRondasGanadas() {
        return rondasGanadas;
    }

    // Incrementa las rondas ganadas en 1
    public void aumentarRondasGanadas() {
        rondasGanadas++;
    }
}
