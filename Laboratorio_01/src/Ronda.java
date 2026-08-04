public class Ronda{
    private Pokemones pokemon_ataque;
    private Pokemones pokemon_defensa;
    private double ataque_efectivo;
    private double defensa_efectiva;
    private int bono_tipo;
    private Pokemones ganador_ronda;
    public Ronda(Pokemones pokemon_ataque, Pokemones pokemon_defensa){
        this.pokemon_ataque = pokemon_ataque;
        this.pokemon_defensa = pokemon_defensa;
        this.ataque_efectivo = 0;
        this.defensa_efectiva = 0;
        this.bono_tipo = 0;
        this.ganador_ronda = null;
    }
    public void jugar_ronda(){
        ataque_efectivo = calcular_ataque();
        defensa_efectiva = calcular_defensa();
        bono_tipo = calcular_bono();
        double ataque_total = ataque_efectivo + bono_tipo - defensa_efectiva;
        if (ataque_total>0){
            ganador_ronda = pokemon_ataque;
        } else if (ataque_efectivo<0){
            ganador_ronda = pokemon_defensa;
        } else {
            ganador_ronda = null;
        }
    }
    private double calcular_ataque(){
        double ataque = pokemon_ataque.get_Ataque();
        Habilidad_Especial habilidad = pokemon_ataque.get_Habilidad_Especial();
        if (habilidad.activar_Habilidad()){
            int potenciador = habilidad.generar_Potenciador();
            ataque = ataque + (ataque * potenciador / 100.0);
        }
        return ataque;
    }
    private double calcular_defensa(){
        double defensa = pokemon_defensa.get_Defensa();
        Habilidad_Especial habilidad = pokemon_defensa.get_Habilidad_Especial();
        if (habilidad.activar_Habilidad()){
            int potenciador = habilidad.generar_Potenciador();
            defensa = defensa + (defensa*potenciador/100);
        }
        return defensa;
    }
    private int calcular_bono(){
        String tipo_Ataque = pokemon_ataque.get_Tipo();
        String tipo_Defensa = pokemon_defensa.get_Tipo();
        if (tipo_Ataque.equals("Fuego")){
            if (tipo_Defensa.equals("Planta")){
                return 20;
            }
            if (tipo_Defensa.equals("Agua")){
                return -10;
            }
        }
        if (tipo_Ataque.equals("Agua")){
            if (tipo_Defensa.equals("Fuego")){
                return 20;
            }
            if (tipo_Defensa.equals("Planta")){
                return -10;
            }
        }
        if (tipo_Ataque.equals("Planta")){
            if (tipo_Defensa.equals("Agua")){
                return 20;
            }
            if (tipo_Defensa.equals("Fuego")){
                return -10;
            }
        }
        if (tipo_Ataque.equals("Electrico")){
            if (tipo_Defensa.equals("Agua")){
                return 20;
            }
        }
        return 0;
    }
    public Pokemones get_GanadorRonda(){
        return ganador_ronda;
    }
}