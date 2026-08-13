public class Batalla {

    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private int victoriasEntrenador1;
    private int victoriasEntrenador2;

    public Batalla(Entrenador entrenador1, Entrenador entrenador2){

        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;
        this.victoriasEntrenador1 = 0;
        this.victoriasEntrenador2 = 0;
    }

    public double calcularBono(double valorBase, int porcentaje) {

        return valorBase * (porcentaje / 100.0);
    }

    public int calcularBonoTipo(Pokemon atacante, Pokemon defensor){

        String tipoAtacante = atacante.getTipo();
        String tipoDefensor = defensor.getTipo();

        if(tipoAtacante.equals("Fuego")){

            if(tipoDefensor.equals("Agua")){
                return -10;
            }
            if(tipoDefensor.equals("Planta")){
                return 20;
            }
        } else if (tipoAtacante.equals("Agua")){

            if(tipoDefensor.equals("Fuego")){
                return 20;
            }
            if(tipoDefensor.equals("Planta")){
                return -10;
            }
        } else if (tipoAtacante.equals("Planta")){

            if(tipoDefensor.equals("Fuego")){
                return -10;
            }
            if(tipoDefensor.equals("Agua")){
                return 20;
            }
        } else if(tipoAtacante.equals("Electrico")){

            if(tipoDefensor.equals("Agua")){
                return 20;
            }
        }

        return 0;
    }
    public double calcularAtaqueTotal(

        double ataqueEfectivo,
        int bonoTipo,
        double defensaEfectiva
    ) {
        return ataqueEfectivo + bonoTipo - defensaEfectiva;
    }

    public void registrarVictoria(Entrenador ganador){

        if(ganador == entrenador1){
            victoriasEntrenador1++;
        } else if (ganador == entrenador2){
            victoriasEntrenador2++;
        }

    }

    public Entrenador getEntrenador1(){
        return entrenador1;
    }

    public Entrenador getEntrenador2(){
        return entrenador2;
    }

    public int getVictoriasEntrenador1(){
        return victoriasEntrenador1;
    }

    public int getVictoriasEntrenador2(){
        return victoriasEntrenador2;
    }

    public Entrenador getGanador(){

        if(victoriasEntrenador1 > victoriasEntrenador2){
            return entrenador1;

        } else if(victoriasEntrenador2 > victoriasEntrenador1){
            return entrenador2;
        }

        return null;
    }
     
}