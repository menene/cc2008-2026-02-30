public class Pokemon {
    private String nombre;
    private String tipo;
    private int ataque;
    private int defensa;
    private HabilidadEspecial habilidadEspecial;
    private boolean haPeleado;
    
    //constructor de pokemon
    public Pokemon(String nombre, String tipo, int ataque, 
                   int defensa, HabilidadEspecial habilidadEspecial) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidadEspecial = habilidadEspecial;
        //inicializar si ha peleado en false primero
        this.haPeleado = false;

    }

    //G&S nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //G&S tipo
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //G&S ataque
    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    //G&S defensa
    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    //G&S habilidad especial
    public HabilidadEspecial getHabilidadEspecial() {
        return habilidadEspecial;
    }

    public void setHabilidadEspecial(HabilidadEspecial habilidadEspecial) {
        this.habilidadEspecial = habilidadEspecial;
    }

    //G&S ha peleado
    //este lo uso para numPok en Entrenador
    public boolean getHaPeleado() {
        return haPeleado;
    }

    public void setHaPeleado(boolean haPeleado) {
        this.haPeleado = haPeleado;
    }

    //metodo calcular ataque efectivo
    public double calcularAtaqueEfectivo(int porcentaje) {
        double bonoAt;

        //primero obtengo cuanto le voy a sumar segun el %
        bonoAt = (ataque * porcentaje) / 100.0; //y uso 100.0 para que use decimales
        //se lo sumo
        bonoAt = ataque + bonoAt;
        return bonoAt;
    }

    //metodo calcular defensa efectiva
    public double calcularDefensaEfectiva(int porcentaje) {
        double bonoDef;
        
        //igual aca
        bonoDef = (defensa * porcentaje) / 100.0;
        bonoDef = defensa + bonoDef;
        return bonoDef;
    }

}
