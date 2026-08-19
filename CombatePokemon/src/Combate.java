public class Combate {
    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private int numeroRonda;
    private boolean jugador1Ataca;
    
    public Combate(Entrenador entrenador1, Entrenador entrenador2) {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
        this.numeroRonda = 1;
        this.jugador1Ataca = true;
    }

    private int calcularEfectividadTipo(String tipoAtacante, String tipoDefensor) {
        
        //si el atacante es:
        //======= fuego =======
        if (tipoAtacante.equals("Fuego")) {
            if (tipoDefensor.equals("Planta")) {
                //porque en la tabla de instrucciones se tiene que:
                //si fuego ataca y planta defiende = +20
                //osea es Efectivo
                return 20;               
            } 
            else if (tipoDefensor.equals("Agua")) {
                //si fuego ataca y agua defiende = -10
                //osea Debil
                return -10;
            }
            else if (tipoDefensor.equals("Fuego")) {
                //Neutral
                return 0;
            }
            else if (tipoDefensor.equals("Electrico")) {
                //Neutral
                return 0;
            }           

        }

        //======== agua =========
        if (tipoAtacante.equals("Agua")) {
            if (tipoDefensor.equals("Fuego")) {
                //porque en la tabla de instrucciones se tiene que:
                //si agua ataca y fuego defiende = +20
                //osea es Efectivo
                return 20;               
            } 
            else if (tipoDefensor.equals("Planta")) {
                //si agua ataca y planta defiende = -10
                //osea Debil
                return -10;
            }
            else if (tipoDefensor.equals("Agua")) {
                //Neutral
                return 0;
            }
            else if (tipoDefensor.equals("Electrico")) {
                //Neutral
                return 0;
            }            

        }

        
        //======== planta =====
        if (tipoAtacante.equals("Planta")) {
            if (tipoDefensor.equals("Agua")) {
                //porque en la tabla de instrucciones se tiene que:
                //si planta ataca y agua defiende = +20
                //osea es Efectivo
                return 20;               
            } 
            else if (tipoDefensor.equals("Fuego")) {
                //si planta ataca y fuego defiende = -10
                //osea Debil
                return -10;
            }
            else if (tipoDefensor.equals("Planta")) {
                //Neutral
                return 0;
            }
            else if (tipoDefensor.equals("Electrico")) {
                //Neutral
                return 0;
            }            
        }

        //========== electrico =========
        if (tipoAtacante.equals("Electrico")) {
            if (tipoDefensor.equals("Agua")) {
                //porque en la tabla de instrucciones se tiene que:
                //si electrico ataca y agua defiende = +20
                //osea es Efectivo
                return 20;               
            } 
            else if (tipoDefensor.equals("Fuego")) {
                //Neutral
                return 0;
            }
            else if (tipoDefensor.equals("Planta")) {
                //Neutral
                return 0;
            }
            else if (tipoDefensor.equals("Electrico")) {
                //Neutral
                return 0;
            }
        }

        //por lo que entendi, este es para que por cualquier cosa,
        //si no se selecciona un tipo de esos 4, que se regrese 0,
        //xq java pide un valor de retorno int de este metodo
        return 0;
    
    }



    public String ejecutarRonda() {
        //definir bien quien ataca, quien defiende
        Pokemon pokemonAt;
        Pokemon pokemonDe;
        
        //ahora ver si el que ataca es el 1ro
        if (jugador1Ataca) { //osea que el jug1 si va primero
            pokemonAt = entrenador1.seleccionarPokemon();
            pokemonDe = entrenador2.seleccionarPokemon();
        } 
        else { //si no, entonces al reves
            pokemonDe = entrenador1.seleccionarPokemon();
            pokemonAt = entrenador2.seleccionarPokemon();
        }


        //ahora variables para saber si se activan las habilidades
        boolean habilidadAtacanteOn;
        boolean habilidadDefensorOn;

        //les asigno sus valores
        habilidadAtacanteOn = pokemonAt.getHabilidadEspecial().intentarActivacion();
        habilidadDefensorOn = pokemonDe.getHabilidadEspecial().intentarActivacion();


        //ahora variables para guardar los %
        //y empiezan en 0 porque si no se activa, pues no va a tener nada
        int potenciadorAtacante = 0;
        int potenciadorDefensor = 0;

        //reviso al 1er atacante
        if (habilidadAtacanteOn) { //osea, que si
            potenciadorAtacante = pokemonAt.getHabilidadEspecial().generarPotenciador();
        }
        else { //si es false, pues entonces es 0
            potenciadorAtacante = 0;
        }


        //ahora el potenciador
        if (habilidadDefensorOn) {
            potenciadorDefensor = pokemonDe.getHabilidadEspecial().generarPotenciador();
        }
        else {
            potenciadorDefensor = 0;
        }


        //ahora ataque y defensa
        double ataqueEfectivo = pokemonAt.calcularAtaqueEfectivo(potenciadorAtacante);
        double defensaEfectiva = pokemonDe.calcularDefensaEfectiva(potenciadorDefensor);


        //uso el metodo que acabo de hacer
        int bonoTipo = calcularEfectividadTipo(pokemonAt.getTipo(), pokemonDe.getTipo());


        //aca ya calculo el ataque total
        double ataqueTotal = ataqueEfectivo + bonoTipo - defensaEfectiva;


        //ahora si, guardar toda la informacion de la ronda
        String resultado = "";

        resultado += "Ronda " + numeroRonda + "\n";
        resultado += "Pokemon atacante: " + pokemonAt.getNombre() + "\n";
        resultado += "Pokemon defensor: " + pokemonDe.getNombre() + "\n";

        resultado += "Habilidad de " + pokemonAt.getNombre() + ": "
                + pokemonAt.getHabilidadEspecial().getNombre() + "\n";

        if (habilidadAtacanteOn) {
            resultado += "La habilidad se activo\n";
            resultado += "Potenciador: " + potenciadorAtacante + "%\n";
        }
        else {
            resultado += "La habilidad no se activo\n";
        }

        resultado += "Habilidad de " + pokemonDe.getNombre() + ": "
                + pokemonDe.getHabilidadEspecial().getNombre() + "\n";

        if (habilidadDefensorOn) {
            resultado += "La habilidad se activo\n";
            resultado += "Potenciador: " + potenciadorDefensor + "%\n";
        }
        else {
            resultado += "La habilidad no se activo\n";
        }


        //ahora si, determinar quien gano
        if (ataqueTotal > 0) {
            if (jugador1Ataca) {
                entrenador1.incrementarRondasGanadas();
                resultado += "Gana la ronda " + entrenador1.getNombre();
            }
            else {
                entrenador2.incrementarRondasGanadas();
                resultado += "Gana la ronda " + entrenador2.getNombre();
            }
        }
        else if (ataqueTotal < 0) {

            if (jugador1Ataca) {
                entrenador2.incrementarRondasGanadas();
                resultado += "Gana la ronda " + entrenador2.getNombre();
            }
            else {
                entrenador1.incrementarRondasGanadas();
                resultado += "Gana la ronda " + entrenador1.getNombre();
            }
        }
        else {
            resultado += "Empate";
        }


        //alternar atacante para la otra ronda
        //! es para decir que no es igual
        jugador1Ataca = !jugador1Ataca;

        //avanzar de ronda
        numeroRonda++;

        //devolver resultado
        return resultado;
    }


    

    //metodo determinar ganador
    public String determinarGanador() {

        //si gana el entrenador 1
        if (entrenador1.getRondasGanadas() > entrenador2.getRondasGanadas()) {
            return "Gana el combate " + entrenador1.getNombre();
        }
        //si gana el entrenador 2
        else if (entrenador2.getRondasGanadas() > entrenador1.getRondasGanadas()) {
            return "Gana el combate " + entrenador2.getNombre();
        }
        //si hay empatee
        else {
            return "El combate termina en empate";
        }
        
    }



    //metodo ejecutar combate
    public void ejecutarCombate() {

        for (int i = 0; i < 4; i++) {
            ejecutarRonda();
        }
    }



}