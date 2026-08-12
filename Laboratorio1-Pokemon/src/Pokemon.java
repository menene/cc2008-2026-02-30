public class Pokemon {
    //atributos de la clase pokemon
    private String nombre;
    private String tipo;
    private short ataque;
    private short defensa;
    private Habilidad Especial habilidad;
    private boolean haPeleado;

    //constructor del pokemon
    public Pokemon(String nombre, String tipo, short ataque, short defensa, HabilidadEspecial habilidad){
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidad = habilidad;
        this.haPeleado = false;
        //todo pokemon se construye listo para pelear al declarar su atributo
        //"haPeleado" como false
    }

    //calculo del daño total sumando el ataque base + el porcentaje
    //extra si se activa la habilidad
    public float calcularAtaqueEfectivo() {
        float bono = habilidad.obtenerBonoPorcentaje
        return ataque + (ataque * bono);
    }

    //calculo de la defensa total sumando la defensa base + el porcentaje
    //extra si se activa la habilidad
    public float calculardefensaEfectiva() {
        float bono = habilidad.obtenerBonoPorcentaje();
        return defensa + (defensa * bono);
    }

    //cambio de estado del Pokemon para que no se pueda volver a usar
    publlic void marcarComoUsado() {
        this.haPeleado = true;
    }

    //getters para consultar datos sin hacerlos publicos
    public boolean isHaPeleado() {
        return haPeleado;
    }
    public String getTipo() {
        return tipo;
    }
    public String getNombre() {
        return nombre;
    }
}