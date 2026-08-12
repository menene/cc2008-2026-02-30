public class Combate {
    //atributos
    private Ronda ronda1;
    private Ronda ronda2;
    private Ronda ronda3;
    private Ronda ronda4;

    //metodo para coordinar el combate
    public void coordinarCombate(Jugador jugador1, Jugador jugador2) {
        
        //ronda 1, jugador 1 ataca y jugador 2 defiende
        Pokemon p1 = jugador1.seleccionarPokemonAleatorio();
        Pokemon p2 = jugador2.seleccionarPokemonAleatorio();
        
        //se marcan como usados para que no repitan
        p1.marcarComoUsado();
        p2.marcarComoUsado();
        
        ronda1 = new Ronda(p1, p2);
        byte resultado1 = ronda1.ejecutarTurno();
        
        //se registra la victoria segun el resultado de la ronda
        if (resultado1 == 1) {
            jugador1.registrarVictoria(); //gana el atacante
        } else if (resultado1 == 2) {
            jugador2.registrarVictoria(); //gana el defensor
        }

        //ronda 2, jugador 2 ataca y jugador 1 defiende
        p1 = jugador1.seleccionarPokemonAleatorio();
        p2 = jugador2.seleccionarPokemonAleatorio();
        
        p1.marcarComoUsado();
        p2.marcarComoUsado();
        
        //se envia p2 primero para que sea el atacante
        ronda2 = new Ronda(p2, p1); 
        byte resultado2 = ronda2.ejecutarTurno();
        
        if (resultado2 == 1) {
            jugador2.registrarVictoria(); //gana el atacante
        } else if (resultado2 == 2) {
            jugador1.registrarVictoria(); //gana el defensor
        }

        //ronda 3, jugador 1 ataca y jugador 2 defiende
        p1 = jugador1.seleccionarPokemonAleatorio();
        p2 = jugador2.seleccionarPokemonAleatorio();
        
        p1.marcarComoUsado();
        p2.marcarComoUsado();
        
        ronda3 = new Ronda(p1, p2);
        byte resultado3 = ronda3.ejecutarTurno();
        
        if (resultado3 == 1) {
            jugador1.registrarVictoria(); //gana el atacante
        } else if (resultado3 == 2) {
            jugador2.registrarVictoria(); //gana el defensor
        }

        //ronda 4, jugador 2 ataca y jugador 1 defiende
        p1 = jugador1.seleccionarPokemonAleatorio();
        p2 = jugador2.seleccionarPokemonAleatorio();
        
        p1.marcarComoUsado();
        p2.marcarComoUsado();
        
        ronda4 = new Ronda(p2, p1);
        byte resultado4 = ronda4.ejecutarTurno();
        
        if (resultado4 == 1) {
            jugador2.registrarVictoria(); //gana el atacante
        } else if (resultado4 == 2) {
            jugador1.registrarVictoria(); //gana el defensor
        }
    }
}