public class ControladorRonda{

    // métodos

    // Pide el pokemon al azar de cada jugador, calcula el ataque y la defensa efectivos, calcula el bono de tipo, calcula el ataque total y define el ganador, guarda todo dentro del objeto ronda
    public void jugarRonda(Ronda ronda){

        // seleccionar al azar el pokemon del atacante y del defensor
        Pockemon pokemonAtacante = ronda.getJugadorAtacante().seleccionarPockemonAleatorio();
        Pockemon pokemonDefensor = ronda.getJugadorDefensor().seleccionarPockemonAleatorio();
        ronda.setPokemonAtacante(pokemonAtacante);
        ronda.setPokemonDefensor(pokemonDefensor);

        // marcar a los dos pokemon como que ya pelearon para que no vuelvan a ser elegidos
        pokemonAtacante.setHaPeleado(true);
        pokemonDefensor.setHaPeleado(true);

        // cada pokemon intenta activar su habilidad especial
        boolean posibilidad1 = pokemonAtacante.intentarActivarHabilidad();
        boolean posibilidad2 = pokemonDefensor.intentarActivarHabilidad();

        // el ataque efectivo inicia siendo igual al ataque base del pokemon atacante
        int ataqueEfectivo = pokemonAtacante.getAtaque();

        // la defensa efectiva inicia siendo igual a la defensa base del pokemon defensor
        int defensaEfectiva = pokemonDefensor.getDefensa();

        // si la habilidad del atacante se activa se le suma el porcentaje de potenciador a su ataque
        if (posibilidad1 == true){
            int potenciador = pokemonAtacante.generarPotenciador();
            ataqueEfectivo = ataqueEfectivo + (ataqueEfectivo * potenciador / 100);
        }
        // si la habilidad del defensor se activa se le suma el porcentaje de potenciador a su defensa
        if (posibilidad2 == true){
            int potenciador = pokemonDefensor.generarPotenciador();
            defensaEfectiva = defensaEfectiva + (defensaEfectiva * potenciador / 100);
        }

        ronda.setAtaqueEfectivo(ataqueEfectivo);
        ronda.setDefensaEfectiva(defensaEfectiva);

        // calcular el bono de tipo entre el pokemon atacante y el pokemon defensor
        int bonoTipo = calcularBonoTipo(pokemonAtacante, pokemonDefensor);
        ronda.setBonoTipo(bonoTipo);

        // calcular el ataque total de la ronda
        int ataqueTotal = calcularAtaqueTotal(ronda);
        ronda.setAtaqueTotal(ataqueTotal);

        // definir el ganador de la ronda segun el ataque total y sumarle la ronda ganada al jugador correspondiente
        if (ataqueTotal > 0){
            ronda.setGanadorRonda(ronda.getJugadorAtacante().getNombre());
            ronda.getJugadorAtacante().rondasGanadas++;
        }
        if (ataqueTotal < 0){
            ronda.setGanadorRonda(ronda.getJugadorDefensor().getNombre());
            ronda.getJugadorDefensor().rondasGanadas++;
        }
        if (ataqueTotal == 0){
            ronda.setGanadorRonda("Empate");
        }
    }

    // Calcula el bono de efectividad segun la matriz de tipos entre el pokemon que ataca y el pokemon que defiende
    public int calcularBonoTipo(Pockemon pokemonAtacante, Pockemon pokemonDefensor){
        if (pokemonAtacante.getTipo().equals("Fuego") && pokemonDefensor.getTipo().equals("Fuego")){
            return 0;
        }
        if (pokemonAtacante.getTipo().equals("Fuego") && pokemonDefensor.getTipo().equals("Agua")){
            return -10;
        }
        if (pokemonAtacante.getTipo().equals("Fuego") && pokemonDefensor.getTipo().equals("Planta")){
            return 20;
        }
        if (pokemonAtacante.getTipo().equals("Fuego") && pokemonDefensor.getTipo().equals("Electrico")){
            return 0;
        }
        if (pokemonAtacante.getTipo().equals("Agua") && pokemonDefensor.getTipo().equals("Fuego")){
            return 20;
        }
        if (pokemonAtacante.getTipo().equals("Agua") && pokemonDefensor.getTipo().equals("Agua")){
            return 0;
        }
        if (pokemonAtacante.getTipo().equals("Agua") && pokemonDefensor.getTipo().equals("Planta")){
            return -10;
        }
        if (pokemonAtacante.getTipo().equals("Agua") && pokemonDefensor.getTipo().equals("Electrico")){
            return 0;
        }
        if (pokemonAtacante.getTipo().equals("Planta") && pokemonDefensor.getTipo().equals("Fuego")){
            return -10;
        }
        if (pokemonAtacante.getTipo().equals("Planta") && pokemonDefensor.getTipo().equals("Agua")){
            return 20;
        }
        if (pokemonAtacante.getTipo().equals("Planta") && pokemonDefensor.getTipo().equals("Planta")){
            return 0;
        }
        if (pokemonAtacante.getTipo().equals("Planta") && pokemonDefensor.getTipo().equals("Electrico")){
            return 0;
        }
        if (pokemonAtacante.getTipo().equals("Electrico") && pokemonDefensor.getTipo().equals("Fuego")){
            return 0;
        }
        if (pokemonAtacante.getTipo().equals("Electrico") && pokemonDefensor.getTipo().equals("Agua")){
            return 20;
        }
        if (pokemonAtacante.getTipo().equals("Electrico") && pokemonDefensor.getTipo().equals("Planta")){
            return 0;
        }
        if (pokemonAtacante.getTipo().equals("Electrico") && pokemonDefensor.getTipo().equals("Electrico")){
            return 0;
        }
        // caso de seguridad en caso ningun tipo coincida con los anteriores
        return 0;
    }
    
    // Calcula el ataque total de la ronda sumando el ataque efectivo y el bono de tipo, y restando la defensa efectiva
    public int calcularAtaqueTotal(Ronda ronda){
        int ataqueTotal = ronda.getAtaqueEfectivo() - ronda.getDefensaEfectiva() + ronda.getBonoTipo();
        return ataqueTotal;
    }
}
