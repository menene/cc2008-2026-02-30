package view;
 
import model.Ronda;

public class Menu {
 
    public void mostrarResultadoRonda(Ronda ronda) {
        System.out.println(ronda.toString());
    }
 
    public void mostrarResultadoFinal(String ganador) {
        System.out.println("=========================================");
        if (ganador.equals("Empate")) {
            System.out.println("Resultado final: el combate termino EMPATADO");
        } else {
            System.out.println("Resultado final: gana el combate " + ganador);
        }
        System.out.println("=========================================");
    }
}
