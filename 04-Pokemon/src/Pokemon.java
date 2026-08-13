public class Pokemon{
    HabilidadEspecial Habilidad;
    String nombre; 
    byte tipo; 
    byte ataque;
    byte defensa ;
    boolean hapeleado;
    byte entrenador;

    public String getNombre(){
        return nombre;
    }

    public byte Tipo(){
        return tipo;
    }
    public byte getAtaque(){
        return ataque;
    }
    public byte getDefensa(){
        return defensa;
    }
    public boolean gethaPeleado(){
        return hapeleado;
    }
    public byte getEntrenador(){
        return entrenador;
    }
    public HabilidadEspecial getHabilidad() {
        return Habilidad;
    }

    public byte Movimiento(boolean movimiento) {
        if (movimiento) {
            return (byte)(ataque + Habilidad.Habilidad(ataque));
        } else {
            return (byte)(defensa + Habilidad.Habilidad(defensa));
        }
    }
    

    public Pokemon(String nombre, byte tipo, byte ataque, byte defensa,  boolean hapeleado, byte entrenador, HabilidadEspecial Habilidad){
        this.nombre= nombre;
        this.tipo=tipo;
        if (ataque < 0) {
            this.ataque = 0;
        } else {
            this.ataque = ataque;
        }

        if (defensa < 0) {
            this.defensa = 0;
        } else {
            this.defensa = defensa;
        }
        this.hapeleado=hapeleado;
        this.entrenador=entrenador;
        this.Habilidad = Habilidad;
    }

    

}