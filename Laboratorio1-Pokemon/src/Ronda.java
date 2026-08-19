public class Ronda {
    //atributos
    private Pokemon atacante;
    private Pokemon defensor;

    //constructor
    public Ronda(Pokemon atacante, Pokemon defensor) {
        this.atacante = atacante;
        this.defensor = defensor;
    }

    public byte ejecutarTurno() {
        //se obtiene el poder de cada pokemon llamando a sus metodos
        float poderAtacante = atacante.calcularAtaqueEfectivo();
        float poderDefensor = defensor.calcularDefensaEfectiva();

        //calculo de ventaja de tipo
        byte bonoTipo = calcularBonoTipo(atacante.getTipo(), defensor.getTipo());

        //se suma o resta los puntos correspondientes (+20 efectivo, -10 debil, 0 neutral)
        poderAtacante = poderAtacante + bonoTipo;

        //Comparamos poderes finales para decidir el ganador de la ronda
        if (poderAtacante > poderDefensor) {
            return 1; //gana el atacante
        } 
        else if (poderDefensor > poderAtacante) {
            return 2; //gana el defensor
        } 
        else{
            return 0; //empate
        } 
    }
    
    private byte calcularBonoTipo(String tipoAtacante, String tipoDefensor) {
        //logica de tipos, ventaja
        if (tipoAtacante.equals("Fuego") && tipoDefensor.equals("Planta")) return 20;
        if (tipoAtacante.equals("Agua") && tipoDefensor.equals("Fuego")) return 20;
        if (tipoAtacante.equals("Planta") && tipoDefensor.equals("Agua")) return 20;
        if (tipoAtacante.equals("Eléctrico") && tipoDefensor.equals("Agua")) return 20;

        //logica de tipos, desventaja
        if (tipoAtacante.equals("Fuego") && tipoDefensor.equals("Agua")) return -10;
        if (tipoAtacante.equals("Agua") && tipoDefensor.equals("Planta")) return -10;
        if (tipoAtacante.equals("Planta") && tipoDefensor.equals("Fuego")) return -10;

        //si no se cumple ninguna de las condiciones entonces la ventaja es neutra
        return 0;
    }
}