public class Ronda {
     // Atributos
    private Pokemon atacante;
    private Pokemon defensor;
    private Pokemon ganador;
    private int ataqueFinal;
    private int defensaFinal;

    // Constructor de la clase que settea datos
    public Ronda(Pokemon atacante, Pokemon defensor) {
        this.atacante = atacante;
        this.defensor = defensor;
        this.ganador = null;
        this.ataqueFinal = 0;
        this.defensaFinal = 0;
    }

    // Este método ejecuta la batalla o enfrentamiento entre los pokemones
    public void iniciarBatalla() {
        ataqueFinal = calcularAtaqueEfectivo();
        defensaFinal = calcularDefensaEfectiva();

        int diferencia = getDiferencia();
        
        if (diferencia > 0) {
            ganador = atacante;
        } else if (diferencia < 0) {
            ganador = defensor;
        } else {
            ganador = null;
        }
    }

    // Usé el siguiente código para los elementos
    // 1 es Fuego
    // 2 es Agua
    // 3 es Planta
    // 4 es Electricidad

    // Calcula el bono que se aplicará dependiendo de los elementos que se estén enfrentando
    private int calcularBonoTipo() {
        int tipoAtacante = atacante.getTipo();
        int tipoDefensor = defensor.getTipo();

        // Si atacante es fuego
        if (tipoAtacante == 1) {
            // Si defensor es Agua
            if (tipoDefensor == 2) {
                return -10;
            } else if (tipoDefensor == 3) { // Si el defensor es Planta
                return 20;
            }
        }

        // Si el atacante es Agua
        else if (tipoAtacante == 2) {
            // Si defensor es Fuego
            if (tipoDefensor == 1) {
                return 20;
            } else if (tipoDefensor == 3) { // Si el defensor es Planta
                return -10;
            }
        }

        // Si el atacante es Planta
        else if (tipoAtacante == 3) {
            // Si defensor es Fuego
            if (tipoDefensor == 1) {
                return -10;
            } else if (tipoDefensor == 2) { // Si el defensor es Planta
                return 20;
            }
        }

        // Si el atacante es Eléctrico
        else if (tipoAtacante == 3) {
            // Si defensor es Agua
            if (tipoDefensor == 2) {
                return 20;
            } 
        }
        // El resto de las combinaciones no suman ni restan
        return 0;
    }

    // Calcula el ataque efectivo verificando si se activa la habilidad
    public int calcularAtaqueEfectivo() {
        int ataque = atacante.getAtaque();

        HabilidadEspecial habilidad = atacante.getHabilidadEspecial();

        if (habilidad.seActiva()) {
            int potenciador = habilidad.generarPotenciador();
            ataque = Math.round(ataque + ataque*(potenciador/100));
        }

        return ataque;
    }
    // Calcula la defensa efectiva verificando si se activa la habilidad
    public int calcularDefensaEfectiva() {
        int defensa = defensor.getAtaque();

        HabilidadEspecial habilidad = defensor.getHabilidadEspecial();

        if (habilidad.seActiva()) {
            int potenciador = habilidad.generarPotenciador();
            defensa = Math.round(defensa + defensa*(potenciador/100));
        }

        return defensa;
    }

    // Getters

    public Pokemon getGanador() {
        return ganador;
    }

    public int getAtaqueFinal() {
        return ataqueFinal;
    }

    public int getDefensaFinal() {
        return defensaFinal;
    }

    // Se obtiene la diferencia sumandole al ataque final el bono y restando la defensa final
    public int getDiferencia() {
        return ataqueFinal + calcularBonoTipo() - defensaFinal;
    }
}
