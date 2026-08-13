import java.util.Random;

public class Entrenador {
    private String nombre;
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Pokemon pokemon3;
    private Pokemon pokemon4;
    private int rondasGanadas;
    private Random random;

    //constructor entrenador
    public Entrenador(String nombre, Pokemon pokemon1, Pokemon pokemon2, 
                      Pokemon pokemon3, Pokemon pokemon4) {
        this.nombre = nombre;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.pokemon3 = pokemon3;
        this.pokemon4 = pokemon4;
        //rondas inicia en 0 al principio
        this.rondasGanadas = 0;
        this.random = new Random();
    }

    //G&S nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //G&S pokemon1
    public Pokemon getPokemon1() {
        return pokemon1;
    }

    public void setPokemon1(Pokemon pokemon1) {
        this.pokemon1 = pokemon1;
    }

    //G&S pokemon 2
    public Pokemon getPokemon2() {
        return pokemon2;
    }

    public void setPokemon2(Pokemon pokemon2) {
        this.pokemon2 = pokemon2;
    }

    //G&S pokemon3
    public Pokemon getPokemon3() {
        return pokemon3;
    }

    public void setPokemon3(Pokemon pokemon3) {
        this.pokemon3 = pokemon3;
    }

    //G&S pokemon4
    public Pokemon getPokemon4() {
        return pokemon4;
    }

    public void setPokemon4(Pokemon pokemon4) {
        this.pokemon4 = pokemon4;
    }

    //G rondas ganadas
    public int getRondasGanadas() {
        return rondasGanadas;
    }

    //S rondas ganadas, aumentarle
    public void incrementarRondasGanadas() {
        //para sumarle 1 a la misma variable
        rondasGanadas ++;
    }

    //seleccionar pokemon
    public Pokemon seleccionarPokemon() {
        while (true) {
            //numero random 1 al 4, no del 0 al 3
            int numPok = random.nextInt(4) + 1;

            switch (numPok) {

                case 1:
                    //si no ha peleado, lo marco como true
                    if (pokemon1.getHaPeleado() == false) {
                        pokemon1.setHaPeleado(true);
                        return pokemon1;
                    }
                    break;

                case 2:
                    if (pokemon2.getHaPeleado() == false) {
                        pokemon2.setHaPeleado(true);
                        return pokemon2;
                    }
                    break;

                case 3:
                    if (pokemon3.getHaPeleado() == false) {
                        pokemon3.setHaPeleado(true);
                        return pokemon3;
                    }
                    break;

                case 4:
                    if (pokemon4.getHaPeleado() == false) {
                        pokemon4.setHaPeleado(true);
                        return pokemon4;
                    }
                    break;
            }
        }
        
        //================ no se si esto funciona haha ===========
        // //numero random 1 al 4, no del 0 al 3
        // int numPok = random.nextInt(4) + 1;

        // //switch case
        // switch (numPok) {
        //     case 1:
        //         //si no ha peleado, lo marco como true
        //         if (pokemon1.getHaPeleado() == false) {
        //             pokemon1.setHaPeleado(true);
        //             return pokemon1;                    
        //         }                            
        //         break;
            
        //     case 2:
        //         if (pokemon2.getHaPeleado() == false) {
        //             pokemon2.setHaPeleado(true);
        //             return pokemon2;
        //         }
        //         break;
            
        //     case 3:
        //         if (pokemon3.getHaPeleado() == false) {
        //             pokemon3.setHaPeleado(true);
        //             return pokemon3;                    
        //         }
        //         break;

        //     case 4:
        //         if (pokemon4.getHaPeleado() == false) {
        //             pokemon4.setHaPeleado(true);
        //             return pokemon4;
        //         }
        //         break;
                
        
        //     default:
        //         break;
        // }
        // //puedo volver a llamar mismo metodo (creo)
        // //porque si el pokemno que llama ya peleo, entonces no entra al switch
        // //y si vuelvo a llamarlo es escoger otro random y ojala ese no haya peleado
        // return seleccionarPokemon();        

    }
    
}
