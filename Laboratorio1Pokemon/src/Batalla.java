public class Batalla{
    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private Vista vista;

    private int victorias1;
    private int victorias2;


    public Batalla(Entrenador entrenador1, Entrenador entrenador2){
        this.entrenador1= entrenador1;
        this.entrenador2 = entrenador2;

        this.victorias1 = 0;
        this.victorias2 = 0;
        this.vista = new Vista();


    }
    private int calcularBono(Pokemon atacante, Pokemon defensor){
        String tipoAtacante = atacante.getTipo();
        String tipoDefensor = defensor.getTipo();

        if (tipoAtacante.equals("Fuego")&& tipoDefensor.equals("Planta")){
            return 20;
        }
        if (tipoAtacante.equals("Fuego")&& tipoDefensor.equals("Agua")){
            return -10;
        }

        if (tipoAtacante.equals("Agua")&& tipoDefensor.equals("Fuego")){
            return 20;
        }
        if (tipoAtacante.equals("Agua")&& tipoDefensor.equals("Planta")){
            return -10;
        }

        if (tipoAtacante.equals("Planta")&& tipoDefensor.equals("Agua")){
            return 20;
        }
        if (tipoAtacante.equals("Planta")&& tipoDefensor.equals("Fuego")){
            return -10;
        }

        if (tipoAtacante.equals("Electrico")&& tipoDefensor.equals("Agua")){
            return 20;
        }
        //los demas q no estan son 0 asi q ahi va el 0
        return 0;
    }
    private float calcularAtaqueTotal(Pokemon atacante, Pokemon defensor){

        float ataqueEfectivo = atacante.getAtaque();
        float defensaEfectiva = defensor.getDefensa();

        Habilidadespecial habilidadAtacante = atacante.getHabilidadEspecial();
        Habilidadespecial habilidadDefensor = defensor.getHabilidadEspecial();
        //habilidad del atacante 
        if (habilidadAtacante.activarHabilidad()){
            int potenciador = habilidadAtacante.generarPotenciador();

            ataqueEfectivo = ataqueEfectivo + (ataqueEfectivo*potenciador/100);
            System.out.println(atacante.getNombre()+" activo "+ habilidadAtacante.getNombreHabilidad()+" con "+ potenciador + "%");

        }
        // habilidad defensor
        if (habilidadDefensor.activarHabilidad()){
            int potenciador = habilidadDefensor.generarPotenciador();

            defensaEfectiva = defensaEfectiva + (defensaEfectiva*potenciador/100);
            System.out.println(defensor.getNombre()+" activo "+ habilidadDefensor.getNombreHabilidad()+" con "+ potenciador + "%");

        }

        int bonoTipo = calcularBono(atacante, defensor);
        float ataqueTotal   = ataqueEfectivo + bonoTipo - defensaEfectiva;

        return ataqueTotal;

    }
    private int jugarRonda(Pokemon atacante, Pokemon defensor){
        float ataqueTotal = calcularAtaqueTotal(atacante,defensor);
        System.out.println("Atacante: " + atacante.getNombre());
        System.out.println("Defensor: " + defensor.getNombre());
        System.out.println("Ataque total: " + ataqueTotal);

        if (ataqueTotal>0){
            System.out.println("Gana atacante");
            return 1;
        }

        if (ataqueTotal<0){
            System.out.println("Gana el defensor");
            return 2;
        }

        System.out.println("EMPATEEEEEE");
        return 0;

    }
    public void iniciarBatalla(){
        for (int ronda=0; ronda<4;ronda++){
            System.out.println("\n-------------RONDA"+(ronda+1)+"-----------------");
            Pokemon pokemon1 = entrenador1.getEquipo().get(ronda);
            Pokemon pokemon2 = entrenador2.getEquipo().get(ronda);
            int resultado;

            if (ronda%2==0){

                resultado = jugarRonda(pokemon1,pokemon2);
                if (resultado==1){
                    victorias1++;
                }

                if (resultado==2){
                    victorias2++;
                }


            }else{

                resultado = jugarRonda(pokemon2,pokemon1);

                if (resultado==1){
                    victorias2++;
                }

                if (resultado==2){
                    victorias2++;
                }
            }
        }
    }

    public int getVictorias1() {
        return victorias1;
    }

    public int getVictorias2() {
        return victorias2;
    }
}