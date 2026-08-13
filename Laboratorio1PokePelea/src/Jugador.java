import java.util.Random;
public class Jugador {
    private String nombreJugador; 
    private Pokemon pokemon1; 
    private Pokemon pokemon2; 
    private Pokemon pokemon3; 
    private Pokemon pokemon4; 
    private int rondaGanada;


    //constructor
    public Jugador(String nombreJugador, Pokemon pokemon1, Pokemon pokemon2, Pokemon pokemon3, Pokemon pokemon4) {
        this.nombreJugador = nombreJugador; 
        this.pokemon1 = pokemon1; 
        this.pokemon2 = pokemon2; 
        this.pokemon3 = pokemon3; 
        this.pokemon4 = pokemon4; 
        this.rondaGanada = 0; 
    }

    //nombre de jugador 
    public String getNombreJugador() {
        return nombreJugador; 
    }

    //darle uno de los cuatro pokemones al jugador. 
    public Pokemon darPokemon() {
        Random random = new Random();
        boolean seguir = true;
        Pokemon resultadoPokemon = null;
        
        while (seguir) {
            int numeroPokemon = random.nextInt(4) + 1;
            if(numeroPokemon == 1){
                if (pokemon1.getEstado() == true) {
                    resultadoPokemon = pokemon1; 
                    pokemon1.darDisponibilidad(); 
                    seguir = false;
                }
            }else if(numeroPokemon == 2){
                if (pokemon2.getEstado() == true) {
                    resultadoPokemon = pokemon2; 
                    pokemon2.darDisponibilidad(); 
                    seguir = false;
                }
            }else if(numeroPokemon == 3){
                if (pokemon3.getEstado() == true) {
                    resultadoPokemon = pokemon3; 
                    pokemon3.darDisponibilidad(); 
                    seguir = false;
                }
            }else if(numeroPokemon == 4){
                if (pokemon4.getEstado() == true) {
                    resultadoPokemon = pokemon4; 
                    pokemon4.darDisponibilidad(); 
                    seguir = false;
                }
            }
        }
        return resultadoPokemon;  
    }

    //Agregar ronda ganada al jugador, ya sea atacante o defensor
    public void agregarLogro() {
        rondaGanada += 1; 
    }
    //Obtener las rondas ganadas del jugador de 4
    public int getRondaGanada() {
        return rondaGanada; 
    }
}

