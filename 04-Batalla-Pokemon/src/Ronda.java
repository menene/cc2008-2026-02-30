public class Ronda {

    private Pokemon atacante;
    private Pokemon defensor;
    private String ganador;

    private float ataqueEfectivo;
    private float defensaEfectiva;

    private float potenciadorAtacante;
    private float potenciadorDefensor;

    private boolean habilidadAtacanteActivada;
    private boolean habilidadDefensorActivada;

    private int efectoTipo;
    private float ataqueTotal;


    // Constructor
    public Ronda(Pokemon atacante, Pokemon defensor) {

        this.atacante = atacante;
        this.defensor = defensor;

        this.ganador = "Empate";

        this.ataqueEfectivo = atacante.getAtaque();
        this.defensaEfectiva = defensor.getDefensa();

        this.potenciadorAtacante = 0;
        this.potenciadorDefensor = 0;

        this.habilidadAtacanteActivada = false;
        this.habilidadDefensorActivada = false;

        this.efectoTipo = 0;
        this.ataqueTotal = 0;
    }


    public int calcularEfectoTipo(Pokemon atacante, Pokemon defensor) {

        String tipoAtacante = atacante.getTipo();
        String tipoDefensor = defensor.getTipo();


        // Fuego
        if (tipoAtacante.equals("Fuego")
                && tipoDefensor.equals("Agua")) {

            return -10;

        } else if (tipoAtacante.equals("Fuego")
                && tipoDefensor.equals("Planta")) {

            return 20;
        }


        // Agua
        else if (tipoAtacante.equals("Agua")
                && tipoDefensor.equals("Fuego")) {

            return 20;

        } else if (tipoAtacante.equals("Agua")
                && tipoDefensor.equals("Planta")) {

            return -10;
        }


        // Planta
        else if (tipoAtacante.equals("Planta")
                && tipoDefensor.equals("Fuego")) {

            return -10;

        } else if (tipoAtacante.equals("Planta")
                && tipoDefensor.equals("Agua")) {

            return 20;
        }


        // Electrico
        else if (tipoAtacante.equals("Electrico")
                && tipoDefensor.equals("Agua")) {

            return 20;
        }


        // Cualquier otro enfrentamiento es neutral
        return 0;
    }


    public String ejecutarRonda() {

        // =====================================
        // ATAQUE Y DEFENSA BASE
        // =====================================

        ataqueEfectivo = atacante.atacar();
        defensaEfectiva = defensor.defender();


        // =====================================
        // HABILIDAD DEL ATACANTE
        // =====================================

        habilidadAtacanteActivada =
                atacante.getHabilidadEspecial().intentarActivacion();

        if (habilidadAtacanteActivada) {

            potenciadorAtacante =
                    atacante.getHabilidadEspecial().generarPotenciador();

            ataqueEfectivo =
                    ataqueEfectivo
                    + (ataqueEfectivo
                    * potenciadorAtacante / 100);
        }


        // =====================================
        // HABILIDAD DEL DEFENSOR
        // =====================================

        habilidadDefensorActivada =
                defensor.getHabilidadEspecial().intentarActivacion();

        if (habilidadDefensorActivada) {

            potenciadorDefensor =
                    defensor.getHabilidadEspecial().generarPotenciador();

            defensaEfectiva =
                    defensaEfectiva
                    + (defensaEfectiva
                    * potenciadorDefensor / 100);
        }


        // =====================================
        // EFECTO DE TIPO
        // =====================================

        efectoTipo =
                calcularEfectoTipo(atacante, defensor);


        // =====================================
        // ATAQUE TOTAL
        // =====================================

        ataqueTotal =
                ataqueEfectivo
                + efectoTipo
                - defensaEfectiva;


        // =====================================
        // GANADOR
        // =====================================

        if (ataqueTotal > 0) {

            ganador = atacante.getNombre();

        } else if (ataqueTotal < 0) {

            ganador = defensor.getNombre();

        } else {

            ganador = "Empate";
        }


        return ganador;
    }


    // =====================================
    // GETTERS
    // =====================================

    public Pokemon getAtacante() {
        return atacante;
    }

    public Pokemon getDefensor() {
        return defensor;
    }

    public String getGanador() {
        return ganador;
    }

    public float getAtaqueEfectivo() {
        return ataqueEfectivo;
    }

    public float getDefensaEfectiva() {
        return defensaEfectiva;
    }

    public float getPotenciadorAtacante() {
        return potenciadorAtacante;
    }

    public float getPotenciadorDefensor() {
        return potenciadorDefensor;
    }

    public boolean getHabilidadAtacanteActivada() {
        return habilidadAtacanteActivada;
    }

    public boolean getHabilidadDefensorActivada() {
        return habilidadDefensorActivada;
    }

    public int getEfectoTipo() {
        return efectoTipo;
    }

    public float getAtaqueTotal() {
        return ataqueTotal;
    }
}