import java.util.Random;
public class Batalla{
    private int victorias_Jugador1;
    private int victorias_Jugador2;
    private int numero_Ronda;
    private Usuario Jugador_1;
    private Usuario Jugador_2;
    private String ganador;
    private Random random;

    public Batalla(Usuario Jugador_1, Usuario Jugador_2){
        this.Jugador_1 = Jugador_1;
        this.Jugador_2 = Jugador_2;

        this.victorias_Jugador1 = 0;
        this.victorias_Jugador2 = 0;

        this.numero_Ronda = 1;
        this.ganador = null;
        this.random = new Random();
    }
    public void iniciar(){
        while (numero_Ronda<=4){
            realizar_ronda();
            numero_Ronda++;
        }
        determinar_ganador();
    }
    private void realizar_ronda(){
        Pokemones pokemon_jugador1 = seleccionar_pokemon(Jugador_1);
        Pokemones pokemon_jugador2 =  seleccionar_pokemon(Jugador_2);

        Ronda ronda;
    if ((numero_Ronda == 1) || (numero_Ronda == 3)){
        ronda = new Ronda(pokemon_jugador1,pokemon_jugador2);
    } else {
        ronda = new Ronda(pokemon_jugador2,pokemon_jugador1);
    }
    ronda.jugar_ronda();
    Pokemones ganador_ronda = ronda.get_GanadorRonda();
    if (ganador_ronda != null){
        if (ganador_ronda==pokemon_jugador1){
            victorias_Jugador1++;
        }
        else {
            victorias_Jugador2++;
        }
    }
    }
    private Pokemones seleccionar_pokemon(Usuario jugador) {
        int numero = random.nextInt(4) + 1;
        switch (numero) {
            case 1:
                return jugador.get_Pokemon1();

            case 2:
                return jugador.get_Pokemon2();

            case 3:
                return jugador.get_Pokemon3();

            default:
                return jugador.get_Pokemon4();
        }
    }
    private void determinar_ganador() {

        if (victorias_Jugador1 > victorias_Jugador2) {
            ganador = "Jugador 1";
        } else if (victorias_Jugador2 > victorias_Jugador1) {
            ganador = "Jugador 2";
        } else {
            ganador = null;
        }
    }
    public String get_Ganador() {
        return ganador;
    }
}

