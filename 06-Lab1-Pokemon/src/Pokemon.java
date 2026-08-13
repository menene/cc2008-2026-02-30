public class Pokemon {
    private String nombrePokemon;
    private String tipo;
    private int ataque;
    private int defensa;
    private HabilidadEspecial habilidadEspecial;
    private boolean yaPeleo;

    public Pokemon(String nombrePokemon, String tipo, int ataque, int defensa, HabilidadEspecial habilidadEspecial) {
        this.nombrePokemon = nombrePokemon;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidadEspecial = habilidadEspecial;
        this.yaPeleo = false;
    }

    public String getNombrePokemon() {
        return nombrePokemon;
    }

    public String getTipoPokemon() {
        return tipo;
    }

    public int getAtaquePokemon() {
        return ataque;
    }

    public int getDefensaPokemon() {
        return defensa;
    }

    public HabilidadEspecial getHabilidadEspecial() {
        return habilidadEspecial;
    }

    public double calcularAtaqueEfectivo(int porcentajePotenciador) {
        return ataque + (ataque * porcentajePotenciador / 100.00);
    }

    public double calcularDefensaEfectiva(int porcentajePotenciador) {
        return defensa + (defensa * porcentajePotenciador / 100.00);
    }

    public int calcularEfectividadTipo(String tipoDefensor) {

        if (tipo.equalsIgnoreCase("Fuego")) {
            if (tipoDefensor.equalsIgnoreCase("Agua")) {
                return -10;
            } else if (tipoDefensor.equalsIgnoreCase("Planta")) {
                return 20;
            } else {
                return 0;
            }
        }

        else if (tipo.equalsIgnoreCase("Agua")) {
            if (tipoDefensor.equalsIgnoreCase("Fuego")) {
                return 20;
            } else if (tipoDefensor.equalsIgnoreCase("Planta")) {
                return -10;
            } else {
                return 0;
            }
        }

        else if (tipo.equalsIgnoreCase("Planta")) {
            if (tipoDefensor.equalsIgnoreCase("Fuego")) {
                return -10;
            } else if (tipoDefensor.equalsIgnoreCase("Agua")) {
                return 20;
            }
        }

        else if (tipo.equalsIgnoreCase("Eléctrico")) {
            if(tipoDefensor.equalsIgnoreCase("Agua")) {
                return 20;
            }
        }

        return 0;
    }

    public boolean getYaPeleo() {
        return yaPeleo;
    }

    public void marcarComoPeleado() {
        yaPeleo = true;
    }

    public double calcularResultadoAtaque(double ataqueEfectivo, int bonoTipo, double defensaEfectiva) {
        return ataqueEfectivo + bonoTipo - defensaEfectiva;
    }
}