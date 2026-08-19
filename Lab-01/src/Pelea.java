public class Pelea {

    private Entrenador entrenador1;
    private Entrenador entrenador2;

    private int rondasGanadas1;
    private int rondasGanadas2;

    private int numeroRonda;
    private boolean ataca1;

    public Pelea(Entrenador entrenador1, Entrenador entrenador2) {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;

        this.rondasGanadas1 = 0;
        this.rondasGanadas2 = 0;

        this.numeroRonda = 1;
        this.ataca1 = true;
    }

    public String ejecutarRonda() {
        Pokemon atacante;
        Pokemon defensor;

        if (ataca1) {
            atacante = entrenador1.seleccionPokemon();
            defensor = entrenador2.seleccionPokemon();
        }
        else {
            atacante = entrenador2.seleccionPokemon();
            defensor = entrenador1.seleccionPokemon();
        }

        boolean habilidadAtacante = atacante.getHabilidadE().activacion();
        boolean habilidadDefensor = defensor.getHabilidadE().activacion();

        int potenciaAtaque = 0;
        int potenciaDefensa = 0;

        if (habilidadAtacante) {
            potenciaAtaque = atacante.getHabilidadE().potencia();
        }

        if (habilidadDefensor) {
            potenciaDefensa = defensor.getHabilidadE().potencia();
        }

        float ataqueEfectivo = calcularFinal(atacante.getAtaque(), potenciaAtaque);

        float defensaEfectiva = calcularFinal(defensor.getDefensa(), potenciaDefensa);

        int bono = calcularBono(atacante.getTipo(), defensor.getTipo());

        float ataqueTotal = ataqueEfectivo + bono - defensaEfectiva;

        String resultado = "\n========== RONDA " + numeroRonda + " ==========\n";

        if (ataca1) {
            resultado += entrenador1.getNombre() + " ATACA\n";
            resultado += entrenador2.getNombre() + " DEFIENDE\n";
        }
        else {
            resultado += entrenador2.getNombre() + " ATACA\n";
            resultado += entrenador1.getNombre() + " DEFIENDE\n";
        }

        resultado += "\nAtacante: " + atacante.getNombre() + " (" + atacante.getTipo() + ")\n";

        resultado += "Defensor: " + defensor.getNombre() + " (" + defensor.getTipo() + ")\n";
        
        if (habilidadAtacante) {
            resultado += "\nHabilidad activada de " + atacante.getNombre() + ": " + atacante.getHabilidadE().getNombre() + "\n";
            resultado += "Potenciador de ataque: +" + potenciaAtaque + "%\n";

        } 
        else {
            resultado += "\nLa habilidad de " + atacante.getNombre() + " no se activo.\n";
        }

        if (habilidadDefensor) {
            resultado += "Habilidad activada de " + defensor.getNombre() + ": " + defensor.getHabilidadE().getNombre() + "\n";
            resultado += "Potenciador de defensa: +" + potenciaDefensa + "%\n";
        } 
        else {
            resultado += "La habilidad de " + defensor.getNombre() + " no se activo.\n";
        }

        resultado += "\nAtaque efectivo: " + ataqueEfectivo;

        resultado += "\nBono de tipo: " + bono;

        resultado += "\nDefensa efectiva: " + defensaEfectiva;

        resultado += "\nAtaque total: " + ataqueTotal + "\n";

        if (ataqueTotal > 0) {
            resultado += "\nGanador de la ronda: " + atacante.getNombre();
        } 
        else if (ataqueTotal < 0) {
            resultado += "\nGanador de la ronda: " + defensor.getNombre();
        } 
        else {
            resultado += "\nLa ronda termino en empate.";
        }

        registrarResultado(ataqueTotal);

        numeroRonda++;

        alternarAtacante();

        return resultado;
    }

    private int calcularBono(String tipoAtacante, String tipoDefensor) {

        if (tipoAtacante.equals("Fuego")) {
            if (tipoDefensor.equals("Agua")) {
                return -10;
            }
            if (tipoDefensor.equals("Planta")) {
                return 20;
            }
        }

        if (tipoAtacante.equals("Agua")) {
            if (tipoDefensor.equals("Fuego")) {
                return 20;
            }
            if (tipoDefensor.equals("Planta")) {
                return -10;
            }
        }

        if (tipoAtacante.equals("Planta")) {
            if (tipoDefensor.equals("Fuego")) {
                return -10;
            }
            if (tipoDefensor.equals("Agua")) {
                return 20;
            }
        }

        if (tipoAtacante.equals("Electrico")) {

            if (tipoDefensor.equals("Agua")) {
                return 20;
            }
        }

        return 0;
    }

    private float calcularFinal(float estadisticaBase, int porcentaje) {
        return estadisticaBase + (estadisticaBase * porcentaje / 100.0f);
    }

     private void registrarResultado(float ataqueTotal) {

        if (ataqueTotal > 0) {
            if (ataca1) {
                rondasGanadas1++;
            } 
            else {
                rondasGanadas2++;
            }

        } 
        else if (ataqueTotal < 0) {
            if (ataca1) {
                rondasGanadas2++;
            } 
            else {
                rondasGanadas1++;
            }
        }
    }

    private void alternarAtacante() {
        ataca1 = !ataca1;
    }

     public String determinarGanador() {

        String resultado = "";

        resultado += entrenador1.getNombre() + ": " + rondasGanadas1 + " rondas ganadas\n";
        resultado += entrenador2.getNombre() + ": " + rondasGanadas2 + " rondas ganadas\n";

        if (rondasGanadas1 > rondasGanadas2) {
            resultado += "Ganador de la batalla: " + entrenador1.getNombre();
        } 
        else if (rondasGanadas2 > rondasGanadas1) {
            resultado += "Ganador de la batalla: " + entrenador2.getNombre();
        } 
        else {
            resultado += "La batalla termino en empate.";
        }

        return resultado;
    }
}   