public class Resultado {
    private int ataqueFinal; 
    private int defensaFinal; 
    private Jugador ganador;


    //calcular los bonos segun tipo de pokemon, fuego es 1, agua 2, electricidad 3 y planta 4
    private int calculoBonos(int tipoAtaca, int tipoDefiende) {
        if (tipoAtaca ==1){
            if (tipoDefiende == 1){
                return 0; 
            } else if (tipoDefiende == 2){
                return -10;
            } else if (tipoDefiende == 3){
                return 0;
            } else if (tipoDefiende == 4){
                return +20; 
            }
        }else if (tipoAtaca ==2){
            if (tipoDefiende == 1){
                return +20; 
            } else if (tipoDefiende == 2){
                return 0;
            } else if (tipoDefiende == 3){
                return 0;
            } else if (tipoDefiende == 4){
                return -10; 
            }
        }else if (tipoAtaca ==3){
            if (tipoDefiende == 1){
                return 0; 
            } else if (tipoDefiende == 2){
                return +20;
            } else if (tipoDefiende == 3){
                return 0;
            } else if (tipoDefiende == 4){
                return 0;
            }
        }else if (tipoAtaca ==4){
            if (tipoDefiende == 1){
                return -10; 
            } else if (tipoDefiende == 2){
                return +20;
            } else if (tipoDefiende == 3){
                return 0;
            } else if (tipoDefiende == 4){
                return 0;
            }
        } return 0; 
    }

    //calcular el potenciador del atacante y defensor
    public void calculoResultado(Jugador turnoAtaca, Jugador turnoDefiende, Pokemon atacaPokemon, Pokemon defiendePokemon) {
        int potenciadorAtaca = atacaPokemon.getHabilidadEsp().sorteoHabilidad();
        int potenciadorDefiende = defiendePokemon.getHabilidadEsp().sorteoHabilidad();
        //calcular el ataque final 
        double ataque = atacaPokemon.getAtaque() + (atacaPokemon.getAtaque() * (potenciadorAtaca/100.00));
        double defensa = defiendePokemon.getDefensa() + (defiendePokemon.getDefensa() *(potenciadorDefiende/100.00));
        //dar los resultados tal como la variable (int) 
        ataqueFinal = (int) ataque; 
        defensaFinal = (int) defensa; 
        //agregarle al ataque y defensa los bonos por tipo
        int bonoPorTipo = calculoBonos(atacaPokemon.getTipo(), defiendePokemon.getTipo()); 

        //calcular lo que sucedio en la ronda (ataque + bono) -defensa
        int totalAtaque = (ataqueFinal + bonoPorTipo ) - defensaFinal; 
        if (totalAtaque > 0){
            ganador = turnoAtaca;
            turnoAtaca.agregarLogro();
        }else if (totalAtaque < 0) {
            ganador = turnoDefiende; 
            turnoDefiende.agregarLogro(); 
        } else {
            ganador = null; 
        }
    }

    //Determinar al ganador
    public Jugador getGanador(){
        return ganador; 
    }

    //Obtener el ataque final
    public int getAtaqueFinal() {
        return ataqueFinal; 
    }

    //Obtener la defensa final
    public int getDefensaFinal() {
        
        return defensaFinal; 
    }
}