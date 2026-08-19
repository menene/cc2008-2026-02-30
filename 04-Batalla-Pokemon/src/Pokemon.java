public class Pokemon {

    // Atributos
    private String nombre;
    private int tipo;
    private int ataque;
    private int defensa;
    private HabilidadEspecial habilidadEspecial;
    private boolean agotado;

    // Constructor
    public Pokemon(String nombre, String tipo, int ataque, int defensa,
                   HabilidadEspecial habilidadEspecial) {

        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidadEspecial = habilidadEspecial;
        this.agotado = false;

        // Convertir el tipo de String a int
        if (tipo.equalsIgnoreCase("Fuego")) {
            this.tipo = 1;
        } else if (tipo.equalsIgnoreCase("Agua")) {
            this.tipo = 2;
        } else if (tipo.equalsIgnoreCase("Planta")) {
            this.tipo = 3;
        } else if (tipo.equalsIgnoreCase("Electrico")) {
            this.tipo = 4;
        }
    }

    // Getters

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        if (tipo == 1) {
            return "Fuego";
        } else if (tipo == 2) {
            return "Agua";
        } else if (tipo == 3) {
            return "Planta";
        } else if (tipo == 4) {
            return "Electrico";
        }

        return "Desconocido";
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public HabilidadEspecial getHabilidadEspecial() {
        return habilidadEspecial;
    }

    public boolean getAgotado() {
        return agotado;
    }

    // Setter para indicar si el Pokemon ya participo
    public void setAgotado(boolean agotado) {
        this.agotado = agotado;
    }

    // Calcula el ataque efectivo
    public float atacar() {
        return ataque;
}

    public float defender() {
        return defensa;
}
}