public class Combate {
    //atributos
    private Ronda ronda1;
    private Ronda ronda2;
    private Ronda ronda3;
    private Ronda ronda4;

    //metodo para coordinar el combate
    public String coordinarCombate(Jugador jugador1, Jugador jugador2) {
        String bitacora = "";
        
        //ronda 1, jugador 1 ataca y jugador 2 defiende
        Pokemon p1 = jugador1.seleccionarPokemonAleatorio();
        Pokemon p2 = jugador2.seleccionarPokemonAleatorio();
        
        //se marcan como usados para que no repitan
        p1.marcarComoUsado();
        p2.marcarComoUsado();
        
        bitacora += "\n--- RONDA 1 ---\n";
        bitacora += "[Ataca] " + jugador1.getNombre() + " envia a " + p1.getNombre() + " (Tipo: " + p1.getTipo() + ")\n";
        bitacora += "[Defiende] " + jugador2.getNombre() + " envia a " + p2.getNombre() + " (Tipo: " + p2.getTipo() + ")\n";
        
        ronda1 = new Ronda(p1, p2);
        byte resultado1 = ronda1.ejecutarTurno();
        
        //se registra la victoria segun el resultado de la ronda
        if (resultado1 == 1) {
            jugador1.registrarVictoria(); //gana el atacante
            bitacora += "¡" + p1.getNombre() + " rompe la defensa con un ataque fulminante y gana la ronda!\n";
        } else if (resultado1 == 2) {
            jugador2.registrarVictoria(); //gana el defensor
            bitacora += "¡" + p2.getNombre() + " resiste como una muralla y se lleva la victoria!\n";
        } else {
            bitacora += "¡Ambos poderes chocan con la misma intensidad! Es un empate.\n";
        }

        //ronda 2, jugador 2 ataca y jugador 1 defiende
        p1 = jugador1.seleccionarPokemonAleatorio();
        p2 = jugador2.seleccionarPokemonAleatorio();
        
        p1.marcarComoUsado();
        p2.marcarComoUsado();
        
        bitacora += "\n--- RONDA 2 ---\n";
        bitacora += "[Ataca] " + jugador2.getNombre() + " envia a " + p2.getNombre() + " (Tipo: " + p2.getTipo() + ")\n";
        bitacora += "[Defiende] " + jugador1.getNombre() + " envia a " + p1.getNombre() + " (Tipo: " + p1.getTipo() + ")\n";
        
        //se envia p2 primero para que sea el atacante
        ronda2 = new Ronda(p2, p1); 
        byte resultado2 = ronda2.ejecutarTurno();
        
        if (resultado2 == 1) {
            jugador2.registrarVictoria(); //gana el atacante
            bitacora += "¡" + p2.getNombre() + " lanza un golpe devastador y domina la ronda!\n";
        } else if (resultado2 == 2) {
            jugador1.registrarVictoria(); //gana el defensor
            bitacora += "¡" + p1.getNombre() + " esquiva y contraataca perfectamente para ganar!\n";
        } else {
            bitacora += "¡Una explosion neutraliza ambos ataques! Es un empate.\n";
        }

        //ronda 3, jugador 1 ataca y jugador 2 defiende
        p1 = jugador1.seleccionarPokemonAleatorio();
        p2 = jugador2.seleccionarPokemonAleatorio();
        
        p1.marcarComoUsado();
        p2.marcarComoUsado();
        
        bitacora += "\n--- RONDA 3 ---\n";
        bitacora += "[Ataca] " + jugador1.getNombre() + " envia a " + p1.getNombre() + " (Tipo: " + p1.getTipo() + ")\n";
        bitacora += "[Defiende] " + jugador2.getNombre() + " envia a " + p2.getNombre() + " (Tipo: " + p2.getTipo() + ")\n";
        
        ronda3 = new Ronda(p1, p2);
        byte resultado3 = ronda3.ejecutarTurno();
        
        if (resultado3 == 1) {
            jugador1.registrarVictoria(); //gana el atacante
            bitacora += "¡" + p1.getNombre() + " demuestra su superioridad ofensiva y triunfa!\n";
        } else if (resultado3 == 2) {
            jugador2.registrarVictoria(); //gana el defensor
            bitacora += "¡" + p2.getNombre() + " soporta el embate y gana por resistencia!\n";
        } else {
            bitacora += "¡Ninguno cede terreno! La ronda termina en empate.\n";
        }

        //ronda 4, jugador 2 ataca y jugador 1 defiende
        p1 = jugador1.seleccionarPokemonAleatorio();
        p2 = jugador2.seleccionarPokemonAleatorio();
        
        p1.marcarComoUsado();
        p2.marcarComoUsado();
        
        bitacora += "\n--- RONDA 4 ---\n";
        bitacora += "[Ataca] " + jugador2.getNombre() + " envia a " + p2.getNombre() + " (Tipo: " + p2.getTipo() + ")\n";
        bitacora += "[Defiende] " + jugador1.getNombre() + " envia a " + p1.getNombre() + " (Tipo: " + p1.getTipo() + ")\n";
        
        ronda4 = new Ronda(p2, p1);
        byte resultado4 = ronda4.ejecutarTurno();
        
        if (resultado4 == 1) {
            jugador2.registrarVictoria(); //gana el atacante
            bitacora += "¡" + p2.getNombre() + " asegura la ronda con una ofensiva letal!\n";
        } else if (resultado4 == 2) {
            jugador1.registrarVictoria(); //gana el defensor
            bitacora += "¡" + p1.getNombre() + " bloquea el golpe final y se queda con el punto!\n";
        } else {
            bitacora += "¡El ultimo choque termina en tablas! Empate.\n";
        }

        return bitacora;
    }
}