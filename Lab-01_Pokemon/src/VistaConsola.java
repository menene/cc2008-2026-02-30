public class VistaConsola {

    public void mostrarPokemones(
        Entrenador entrenador1,
        Entrenador entrenador2
    ) {
        System.out.println("\n====== POKEMONES SELECCIONADOS ======");
        System.out.println("\n" + entrenador1.getNombre() + ":");
        Pokemon[] pokemones1 = entrenador1.getPokemones();

        for (int i = 0; i < pokemones1.length; i++){
            System.out.println(": " + pokemones1[i].getNombre() + " (" + pokemones1[i].getTipo() + ")");
            
        }

        System.out.println("\n" + entrenador2.getNombre() + ":");
        
        Pokemon[] pokemones2 = entrenador2.getPokemones();

        for (int i = 0; i < pokemones2.length; i++){
            System.out.println(": " + pokemones2[i].getNombre() + " (" + pokemones2[i].getTipo() + ")");

        }

    }

    public void mostrarInicioRonda(
        int Ronda, Pokemon atacante, Pokemon defensor, Entrenador entrenadorAtacante, 
        Entrenador entrenadorDefensor
    ) {
        System.out.println("\n====== RONDA " + Ronda + " ======");

        System.out.println("\n" + entrenadorAtacante.getNombre() + " Ataca con " + atacante.getNombre() 
        + " (" + atacante.getTipo() + ")");

        System.out.println(entrenadorDefensor.getNombre() + " Defiende con " + defensor.getNombre() 
        + " (" + defensor.getTipo() + ")");

     }

     public void mostrarAtaque(
        Pokemon atacante, boolean habilidadActiva, int porcentaje, double bonoAtaque, double ataqueEfectivo){

            System.out.println("\n--- Ataque ---");

            System.out.println(atacante.getNombre() + " tiene " + atacante.getAtaque() + " de ataque base");

            if(habilidadActiva) {

                System.out.println("La habilidad " + atacante.getHabilidadEspecial().getNombre() + " se activo");

                System.out.println("Potenciador obtenido: " + porcentaje + "%");

                System.out.println("Bono de ataque: +" + bonoAtaque);

            } else{
                System.out.println("La habilidad " + atacante.getHabilidadEspecial().getNombre() + " no se activa");
            }

            System.out.println("Ataque efectivo: " + ataqueEfectivo);
        }

        public void mostrarDefensa(
            Pokemon defensor, boolean habilidadActiva, int porcentaje, double bonoDefensa, double defensaEfectiva){

                System.out.println("\n--- Defensa ---");

                System.out.println(defensor.getNombre() + " tiene " + defensor.getDefensa() + " de defenda base");

                if (habilidadActiva){
                    System.out.println("La habilidad " + defensor.getHabilidadEspecial().getNombre() + " se activa");

                    System.out.println("Porcentaje obtenido: " + porcentaje + "%");

                    System.out.println("Bono de defensa: +" + bonoDefensa);
                } else{

                    System.out.println("La habilidad " + defensor.getHabilidadEspecial().getNombre() + " no se activa");
                }

                System.out.println("Defensa efectiva: " + defensaEfectiva);

        }

        public void mostrarBonoTipo(
        Pokemon atacante, Pokemon defensor, int bonoTipo){

                if(bonoTipo > 0){

                    System.out.println("\n--- EFectividad de Tipo ---");

                    System.out.println(atacante.getNombre() + " tiene ventaja de tipo en " 
                    + defensor.getNombre());

                    System.out.println("Bono de tipo: +" + bonoTipo);
                } else if (bonoTipo < 0) {

                    System.out.println("\n--- Efectividad de Tipo ---");

                    System.out.println(atacante.getNombre() + " obtiene ventaja de tipo contra "
                    + defensor.getNombre());

                    System.out.println("Bono de tipo: " + bonoTipo);
                }
        }

            public void mostrarResultadoRonda(
                double ataqueEfectivo, int bonoTipo, double defensaEfectiva, double ataqueTotal, Entrenador ganador){

                    System.out.println("\n--- Resultado de la ronda ---");

                    System.out.println(ataqueEfectivo + " + (" + bonoTipo + ") - " + defensaEfectiva
                    + " = " + ataqueTotal);

                    if (ganador != null){

                        System.out.println("Ganador de la ronda: " + ganador.getNombre());
                    } else{

                        System.out.println("La ronda termina en empate");
                    }
            }

            public void mostrarResultadoFinal(Batalla batalla){

                System.out.println("\n=== RESULTADO FINAL ===");

                System.out.println(batalla.getEntrenador1().getNombre() + ": " + batalla.getVictoriasEntrenador1() + " rondas ganadas");

                System.out.println(batalla.getEntrenador2().getNombre() + ": " + batalla.getVictoriasEntrenador2() + " rondas ganadas");

                Entrenador ganador = batalla.getGanador();

                if(ganador != null){

                    System.out.println("Ganador de batalla: " + ganador.getNombre());

                    
                } else{

                    System.out.println("La batalla termina en empate");
                }
            }

}