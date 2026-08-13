public class Pokemon {

    private String nombre;
    private String tipo;
    private int ataque;
    private int defensa;
    private AtaqueEspecial ataqueEspecial;
    private boolean disponible;

    public Pokemon(String nombre, String tipo, int ataque, int defensa, AtaqueEspecial ataqueEspecial) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataqueEspecial = ataqueEspecial;
        this.disponible = true;
    }

    public void marcarComoUsado() {
        this.disponible = false;
    }

    public String getNombre() {
        return nombre;  
    }
 
    public String getTipo() {
        return tipo;
    }
 
    public int getAtaque() {
        return ataque;
    }
 
    public int getDefensa() {
        return defensa;
    }
 
    public AtaqueEspecial getAtaqueEspecial() {
        return ataqueEspecial;
    }
 
    public boolean isDisponible() {
        return disponible;
    }
        
}