public class Ticket {
    public int NunmeroTicket;
    public int LimiteSuperior;
    public int LimiteInferior;

    public boolean isTrue(){
        boolean resultado = false;
        if(NunmeroTicket>= LimiteInferior){
            if(NunmeroTicket<=LimiteSuperior){
                resultado=true;
            }
            resultado=false;
        }
        return resultado;
    }
}