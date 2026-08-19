public class Torneo{

    // atributos 

    Jugador jugador1;
    Jugador jugador2;
    Ronda ronda1;
    Ronda ronda2;
    Ronda ronda3;
    Ronda ronda4;
    String ganadorTorneo;


    // métodos

    // gettes de los datos de la clase "Torneo"

    public Jugador getJugador1(){
        return jugador1;
    }


    public Jugador getJugador2(){
        return jugador2;
    }

    public Ronda getRonda1(){
        return ronda1;
    }


    public Ronda getRonda2(){
        return ronda2;
    }


    public Ronda getRonda3(){
        return ronda3;
    }


    public Ronda getRonda4(){
        return ronda4;
    }

    
    // setters de los datos de la clase "Torneo"

    public void setJugador1(Jugador jugador1){
        this.jugador1 = jugador1;
    }

    public void setJugador2(Jugador jugador2){
        this.jugador2 = jugador2;
    }

    public void setRonda1(Ronda ronda1){
        this.ronda1 = ronda1;
    }


    public void setRonda2(Ronda ronda2){
        this.ronda2 = ronda2;
    }


    public void setRonda3(Ronda ronda3){
        this.ronda3 = ronda3;
    }


    public void setRonda4(Ronda ronda4){
        this.ronda4 = ronda4;
    }

    public void setGanadorTorneo(String ganadorTorneo){
        this.ganadorTorneo = ganadorTorneo;
    }

}
