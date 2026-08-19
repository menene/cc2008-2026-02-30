public class Jugador {

    //atributos
    private String nombre;
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Pokemon pokemon3;
    private Pokemon pokemon4;
    private byte rondasGanadas; 

    //constructor
    public Jugador(String nombre, Pokemon p1, Pokemon p2, Pokemon p3, Pokemon p4) {
        this.nombre = nombre;
        this.pokemon1 = p1;
        this.pokemon2 = p2;
        this.pokemon3 = p3;
        this.pokemon4 = p4;
        this.rondasGanadas = 0;
    }

    public Pokemon seleccionarPokemonAleatorio() {
        Pokemon seleccionado = null;
        
        while (seleccionado == null) {
            // Genera un número aleatorio del 1 al 4
            byte random = (byte) ((Math.random() * 4) + 1); 
            
            if (random == 1 && !pokemon1.isHaPeleado()) {
                seleccionado = pokemon1;
            } else if (random == 2 && !pokemon2.isHaPeleado()) {
                seleccionado = pokemon2;
            } else if (random == 3 && !pokemon3.isHaPeleado()) {
                seleccionado = pokemon3;
            } else if (random == 4 && !pokemon4.isHaPeleado()) {
                seleccionado = pokemon4;
            }
        }
        return seleccionado;
    }

    public void registrarVictoria() {
        this.rondasGanadas++;
    }

    // Getters
    public String getNombre() { return nombre; }
    public byte getRondasGanadas() { return rondasGanadas; }
}