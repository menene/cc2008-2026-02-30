import java.util.Random;
public class Arbitro{
    private Entrenador[] entrenadores;
    private String resultados;
    public Arbitro(Entrenador[] entrenadores){
        this.entrenadores=entrenadores;
        this.resultados = "";
    }
    public void iniciarCombate(){
        Random r= new Random();
        boolean[][] Pusados = new boolean[2][4];
        int J1=0;
        int J2=0;
        for(int i = 1; i<5; i++){
            resultados+="========== RONDA "+i+" ==========\n";
            Entrenador defensor;
            Entrenador atacante;
            Pokémon PATK;
            Pokémon PDEF;
            int n1 = r.nextInt(4);
            int n2 = r.nextInt(4);
            while(Pusados[0][n1] ){
                n1 = r.nextInt(4);
            }
            while(Pusados[1][n2] ){
                n2 = r.nextInt(4);
            }
            Pusados[0][n1]=true;
            Pusados[1][n2]=true;
            if(entrenadores[0].getRolActual()){
                atacante = entrenadores[0];
                defensor = entrenadores[1];
                PATK = atacante.getPokemones()[n1];
                PDEF = defensor.getPokemones()[n2];
            }
            else{
                atacante = entrenadores[1];
                defensor = entrenadores[0];
                PATK = atacante.getPokemones()[n2];
                PDEF = defensor.getPokemones()[n1];
            }
            resultados+=atacante.getName()+" ataca con: "+PATK.getName()+"\n"+defensor.getName()+" defiende con: "+ PDEF.getName()+"\n";
            int ATKtot=PATK.getATK()-PDEF.getDEF();
            if(r.nextInt(101)<=(int)(PATK.getEspecialAbility().getProb())){
                int pot = r.nextInt(26);
                ATKtot += (int)Math.round(PATK.getATK()*(pot/100.0));
                resultados+= PATK.getName()+" activa: "+PATK.getEspecialAbility().getName()+" con un potenciador de "
    + pot + "%\n";
            }
            if(r.nextInt(101)<=(int)(PDEF.getEspecialAbility().getProb())){
                int pot = r.nextInt(26);
                ATKtot -= (int)Math.round(PDEF.getDEF()*(pot/100.0));
                resultados+= PDEF.getName()+" activa: "+PDEF.getEspecialAbility().getName()+" con un potenciador de "
    + pot + "%\n";
            }
            resultados+=PATK.getName()+" tipo: "+PATK.getType()+"\n";
            resultados+=PDEF.getName()+" tipo: "+PDEF.getType()+"\n";
            String efectoATK = PATK.getType();
            String efectoDEF = PDEF.getType();
            if(efectoATK.equals("Fuego")){
                if(efectoDEF.equals("Agua")){
                    ATKtot-=10;
                    resultados+=PDEF.getName()+" obtiene efecto tipo: "+PDEF.getType()+", -10 ATK"+"\n";
                }
                else if(efectoDEF.equals("Planta")){
                    ATKtot+=20;
                    resultados+=PATK.getName()+" obtiene efecto tipo: "+PATK.getType()+", +20 ATK"+"\n";
                }
            }
            else if(efectoATK.equals("Agua")){
                if(efectoDEF.equals("Fuego")){
                    ATKtot+=20;
                    resultados+=PATK.getName()+" obtiene efecto tipo: "+PATK.getType()+", +20 ATK"+"\n";
                }
                else if(efectoDEF.equals("Planta")){
                    ATKtot-=10;
                    resultados+=PDEF.getName()+" obtiene efecto tipo: "+PDEF.getType()+", -10 ATK"+"\n";
                }
            }
            else if(efectoATK.equals("Planta")){
                if(efectoDEF.equals("Fuego")){
                    ATKtot-=10;
                    resultados+=PDEF.getName()+" obtiene efecto tipo: "+PDEF.getType()+", -10 ATK"+"\n";
                }
                else if(efectoDEF.equals("Agua")){
                    ATKtot+=20;
                    resultados+=PATK.getName()+" obtiene efecto tipo: "+PATK.getType()+", +20 ATK"+"\n";
                }
            }
            else if(efectoATK.equals("Eléctrico")){
                if(efectoDEF.equals("Agua")){
                    ATKtot+=20;
                    resultados+=PATK.getName()+" obtiene efecto tipo: "+PATK.getType()+", +20 ATK"+"\n";
                }
            }
            if(ATKtot>0){
                resultados+="El ataque total ha sido: "+ATKtot+", "+atacante.getName()+" gana la ronda\n";
                if(entrenadores[0].getRolActual()){
                    J1++;
                }
                else{
                    J2++;
                }
            }
            else if(ATKtot<0){
                resultados+="El ataque total ha sido: "+ATKtot+", "+defensor.getName()+" gana la ronda\n";
                if(!entrenadores[0].getRolActual()){
                    J1++;
                }
                else{
                    J2++;
                }
            }
            else{
                resultados+="El ataque total ha sido: "+ATKtot+". Empate!!!!\n";
            }
            resultados+="---------- Rondas Ganadas ----------\n"+entrenadores[0].getName()+": "+J1+"\n"+entrenadores[1].getName()+": "+J2+"\n";
            entrenadores[0].changeRol();
            entrenadores[1].changeRol();
        }
        resultados+="++++++++++ RESULTADO FINAL ----------\n";
        if(J1==J2){
            resultados+="EMPATE!!!!!";
        }
        else if(J1>J2){
            resultados+=entrenadores[0].getName()+" GANA!!!!!";
        }
        else{
            resultados+=entrenadores[1].getName()+" GANA!!!!!";
        }
    }
    
    public String getResultados(){ return this.resultados; }
}