public class PokeControlador {
    private Batalla batalla; 
    private PokeVista vista = new PokeVista(); 

    public void iniciar(){

        //instanciar habilidades 
        HabilidadEsp megaLlama = new HabilidadEsp("Mega Llama", 30);
        HabilidadEsp olaDesastroza = new HabilidadEsp("Ola desastroza", 25);
        HabilidadEsp tormentaElectrica = new HabilidadEsp("Tormenta eléctrica", 20);
        HabilidadEsp naturalPunch = new HabilidadEsp("Natural Punch", 40);

        //instanciar pokemones
        Pokemon charmander = new Pokemon("Charmander", 1, megaLlama, 82, 46);
        Pokemon vulpix = new Pokemon("Vulpix", 1, megaLlama, 52, 50);
        Pokemon blastoise = new Pokemon("Blastoise", 2, olaDesastroza, 43, 26);
        Pokemon poliwag = new Pokemon("Poliwag", 2, olaDesastroza, 56, 24);
        Pokemon pikachu = new Pokemon("Pikachu", 3, tormentaElectrica, 65, 64);
        Pokemon raichu = new Pokemon("Raichu", 3, tormentaElectrica, 78, 70);
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 4, naturalPunch, 60, 55);
        Pokemon venusaur = new Pokemon("Venusaur", 4, naturalPunch, 51, 29);

        //instanciar jugadores 
        Jugador jugador1 = new Jugador("Entrenador 1", charmander, blastoise, pikachu, bulbasaur);
        Jugador jugador2 = new Jugador("Entrenador 2", vulpix, poliwag,raichu, venusaur);

        //Instanciar batalla nueva 
        batalla = new Batalla(jugador1, jugador2); 

        //Mostrar el inicio de la batalla
        vista.mostrarInicioBatalla();

        //Instanciar rondas (y orden de turnos) 
        Ronda ronda1 = new Ronda(1, jugador1, jugador2);
        Ronda ronda2 = new Ronda(2, jugador2, jugador1);
        Ronda ronda3 = new Ronda(3, jugador1, jugador2);
        Ronda ronda4 = new Ronda(4, jugador2, jugador1);

        //Llevar rondas a ejecución
        generarRonda(ronda1);
        generarRonda(ronda2);
        generarRonda(ronda3);
        generarRonda(ronda4);

        //Llamar al final de la batalla 
        finBatalla();
 
    }   
    //Generar una ronda (en el análisis está el parámetro, se me fue colorcarlo en el UML :( ))
   //dar inicio a la ronda, guardar datos y obtener resultados
    private void generarRonda(Ronda ronda){
        ronda.inicioRonda();
        batalla.datosRondas(ronda, ronda.getRondaNumero());
        vista.mostrarEstadoBatalla(ronda); 
        vista.mostrarResultadosRondas(ronda.getResultado());
        
    }

    //Darle fin a la batalla
    private void finBatalla() {
        Jugador ganadorBatalla = batalla.darGanador();
        vista.mostrarGanadorBatalla(ganadorBatalla); 
    }
}