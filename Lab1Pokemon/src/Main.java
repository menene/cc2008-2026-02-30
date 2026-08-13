public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        //Habilidades especiales
        Especial espFuego = new Especial("Temperatura del Sol", 25);
        Especial espPlanta = new Especial("Semillas", 25);
        Especial espElec = new Especial("Impactrueno",25);
        Especial espAgua = new Especial("Burbujas", 25);

        //Equipo del jugador 1
        Pokemon p1 = new Pokemon("Chikorita", "Planta", 50, 50, espPlanta); 
        Pokemon p2 = new Pokemon("Pikachu", "Eléctrico", 51, 51, espElec);
        Pokemon p3 = new Pokemon("Charizard", "Fuego", 52, 52, espFuego);
        Pokemon p4 = new Pokemon("Squirtle", "Agua", 53, 53, espAgua);
        Jugador jugador1 = new Jugador(1, p1, p2, p3, p4);

        //Equipo jugador 2
        Pokemon p5 = new Pokemon("Moltres", "Fuego", 50, 50, espFuego);
        Pokemon p6 = new Pokemon("Mudkip", "Agua", 51, 51, espAgua);
        Pokemon p7 = new Pokemon("Bulbasaur", "Planta", 52, 52, espPlanta);
        Pokemon p8 = new Pokemon("Pichu", "Eléctrico", 53, 53, espElec);
        Jugador jugador2 = new Jugador(2, p5, p6, p7, p8);

        System.out.println("---------- INICIA EL COMBATE POKÉMON ----------");

        //ronda 1 jugador 1 ataca
        System.out.println("\n--- Ronda 1 ---");
        jugarRonda(sistema, jugador1.getPoke1(), jugador2.getPoke1(), jugador1, jugador2);

        //ronda 2 jugador 2 ataca
        System.out.println("\n--- Ronda 2 ---");
        jugarRonda(sistema, jugador2.getPoke2(), jugador1.getPoke2(), jugador2, jugador1);

        //ronda 3 jugador 1 ataca
        System.out.println("\n--- Ronda 3 ---");
        jugarRonda(sistema, jugador1.getPoke3(), jugador2.getPoke3(), jugador1, jugador2);

        //ronda 4 jugador 2 ataca
        System.out.println("\n--- Ronda 4 ---");
        jugarRonda(sistema, jugador2.getPoke4(), jugador1.getPoke4(), jugador2, jugador1);

        System.out.println("\n-------------------------------");
        System.out.println("RESULTADOS FINALES:");
        System.out.println("Rondas ganadas jugador 1: " + jugador1.getGanados());
        System.out.println("Rondas ganadas jugador 2: " + jugador2.getGanados());

        if (jugador1.getGanados() > jugador2.getGanados()) {

            System.out.println("Jugador 1 ha ganado");

        } else if (jugador2.getGanados() > jugador1.getGanados()) {

            System.out.println("Jugador 2 ha ganado");

        } else {

            System.out.println("El resultado es un empate");

        }
    }

    public static void jugarRonda(Sistema sistema, Pokemon atacante, Pokemon defensor, Jugador jAtaca, Jugador jDefiende) {

        System.out.println("Ataca: " + atacante.getNombrePokemon() + " (" + atacante.getTipo() + ")");
        System.out.println("Defiende: " + defensor.getNombrePokemon() + " (" + defensor.getTipo() + ")");

        //Ataque efectivo base
        int ataqueEfectivo = atacante.getAtaque();
        int numPorcAtq = sistema.GenerarNumPorcentaje();
        
        if (numPorcAtq <= atacante.getAtaqueEspecial().getPorcentajeAct()) 
        {
            int pot = sistema.GenerarPotenciador();
            ataqueEfectivo += (atacante.getAtaque() * pot) / 100;
            System.out.println("ALGO INCREÍBLE, ¡La habilidad de " + atacante.getNombrePokemon() + " se ha activado! (+" + pot + "%)");
        }

        //Defensa efectiva base
        int defensaEfectiva = defensor.getDefensa();
        int numPorcDef = sistema.GenerarNumPorcentaje();

        if (numPorcDef <= defensor.getAtaqueEspecial().getPorcentajeAct()) 
        {
            int pot = sistema.GenerarPotenciador();
            defensaEfectiva += (defensor.getDefensa() * pot) / 100;
            System.out.println("ALGO INCREÍBLE, ¡La habilidad de " + defensor.getNombrePokemon() + " se ha activado! (+" + pot + "%)");
        }

        //Bono de tipo y cálculo
        int bono = sistema.BonoTipo(atacante.getTipo(), defensor.getTipo());
        int resultado = sistema.ResultadoRonda(ataqueEfectivo, bono, defensaEfectiva);
        int ganadorRonda = sistema.ValidarGanador(resultado);

        if (ganadorRonda == 1) 
        {
            System.out.println("Resultado: ganó la ronda el atacante.");
            jAtaca.setGanados(jAtaca.getGanados() + 1);
        } 
        else if (ganadorRonda == -1) 
        {
            System.out.println("Resultado: ganó la ronda el defensor.");
            jDefiende.setGanados(jDefiende.getGanados() + 1);
        } 
        else 
        {
            System.out.println("Resultado: fue un empate.");
        }
    }
}