public class Pokemon {
    //parametros (en el análisis los puse en el getter de nombre por accidente, perdooon)
    private String nombre;
    private int tipo; 
    private HabilidadEsp habilidadEsp; 
    private int ataque;
    private int defensa; 
    private Boolean estado; 

    //constructor del pokemon
    public Pokemon(String nombre, int tipo, HabilidadEsp habilidadEsp, int ataque, int defensa){
        this.nombre = nombre; 
        this.tipo = tipo; 
        this.habilidadEsp = habilidadEsp; 
        this.ataque = ataque;
        this.defensa = defensa;
        //El pokemon está disponible cuando no se ha utilizado
        this.estado = true; 
    }
    
    // nombre del pokemon- getter
    public String getNombre() {
        return nombre; 
    }

    // tipo de pokemon (agua, planta, fuego, electrico)
    public int getTipo() {
        return tipo; 
    }

    // obtener la habilidad especial 
    public HabilidadEsp getHabilidadEsp() {
        return habilidadEsp;
    }

    //obtener el ataque del pokemon
    public int getAtaque() {
        return ataque;
    }

    //Obtener la defensa del pokemon
    public int getDefensa() {
        return defensa; 
    }

    //Determinar si el pokemon fue utilizado anteriormente
    public Boolean getEstado() {
        return estado; 
    }

    //Evitar que un pokemon sea utilizado más de una vez 
    public void darDisponibilidad() {
        estado = false; 
    }
}

