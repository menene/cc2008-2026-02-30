import java.util.Random;
public class Sistema_Juego{
    private Usuario Jugador_1;
    private Usuario Jugador_2;
    private Vista vista;
    private String ganador;
    private Batalla batalla;
    public Sistema_Juego(){
        crear_Jugador();
        vista= new Vista();
        Random random = new Random();
        int numero = random.nextInt(1)+1;
        if (numero == 1) {
            batalla = new Batalla(Jugador_1,Jugador_2);
        }
        else{
            batalla = new Batalla(Jugador_2,Jugador_1);
        }
        

    }
    private void crear_Jugador(){
        // Jugador 1
        Habilidad_Especial habilidad_1 = new Habilidad_Especial("Llama la cabra", 30);
        Habilidad_Especial habilidad_2 = new Habilidad_Especial("Boeeee del final", 40);
        Habilidad_Especial habilidad_3 = new Habilidad_Especial("Siuuuu supremo", 20);
        Habilidad_Especial habilidad_4 = new Habilidad_Especial("Meeesi", 35);

        Pokemones pokemon_1 = new Pokemones("Ferran", 20, "Fuego", 30, habilidad_1);
        Pokemones pokemon_2 = new Pokemones("LaCobra", 35, "Agua", 30, habilidad_2);
        Pokemones pokemon_3 = new Pokemones("Penaldo", 45, "Planta", 30, habilidad_3);
        Pokemones pokemon_4 = new Pokemones("Pessi", 50, "Electrico", 20, habilidad_4);
        Jugador_1 = new Usuario(pokemon_1, pokemon_2, pokemon_3, pokemon_4);

        //Jugador 2
        Habilidad_Especial habilidad_5 = new Habilidad_Especial("Mufa Extrema", 20);
        Habilidad_Especial habilidad_6 = new Habilidad_Especial("La Taquiza Curativa", 10);
        Habilidad_Especial habilidad_7 = new Habilidad_Especial("Sandwich de Hostia", 20);
        Habilidad_Especial habilidad_8 = new Habilidad_Especial("six seven Aura + 1000", 35);

        Pokemones pokemon_5 = new Pokemones("Will", 20, "Fuego", 30, habilidad_1);
        Pokemones pokemon_6 = new Pokemones("Javetas", 35, "Agua", 30, habilidad_2);
        Pokemones pokemon_7 = new Pokemones("Ibai", 45, "Planta", 30, habilidad_3);
        Pokemones pokemon_8 = new Pokemones("Andrea", 50, "Electrico", 20, habilidad_4);
        Jugador_2 = new Usuario(pokemon_5, pokemon_6, pokemon_7,  pokemon_8);
    }
    public void iniciar_Juego(){
        batalla.iniciar();
        vista.mostrar_Resultado(batalla.get_Ganador());
    }
    public Usuario getJugador_1(){
        return Jugador_1;
    }
    public Usuario getJugador_2(){
        return Jugador_2;
    }
    public Batalla get_Batalla(){
        return batalla;
    }
}
