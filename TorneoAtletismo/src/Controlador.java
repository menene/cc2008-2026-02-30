public class Controlador {

    private Competencia competencia;
    private Vista vista = new Vista();
    private Atleta atleta;
    private boolean loop;
    private boolean loop2;

    public void iniciarCompetencia(){
        crearAtleta();
        loop=true;
        while(loop){
            int opcion=vista.mostrarMenu();
            if(opcion==1){
                crearAtleta();
            }else if (opcion==2){
                loop2=true;
                while (loop2){
                    double tiempo=vista.pedirTiempo();
                    if (tiempo<=0 || !competencia.registrarTiempo(tiempo)){
                        vista.error();
                        if(competencia.intentosDisponibles()==0){
                            loop2=false;
                        }
                    }else{
                        vista.exito();
                        loop2=false;
                    }
                }
            }else if (opcion==3){
                vista.mostrarTiempos(competencia.consultarTiempos(), competencia.consultarIntentos());
            }else if (opcion==4){
                int intento=vista.pedirIntento();
                double tiempo=competencia.consultarUnIntento(intento);
                if(tiempo==-1){
                    vista.error();
                }else{
                    vista.mostrarIntento(intento, tiempo);
                }
            }else if (opcion==5){
                int intento=vista.pedirIntento();
                double tiempo=vista.pedirTiempo();
                if(competencia.modificarTiempo(intento, tiempo)){
                    vista.exito();
                }else{
                    vista.error();
                }
            }else if (opcion==6){
                double promedio=competencia.consultarPromedio();
                if(promedio==-1){
                    vista.error();
                }else{
                    vista.mostrarPromedio(promedio);
                }
            }else if (opcion==7){
                double mejor=competencia.mejorTiempo();
                double mayor=competencia.mayorTiempo();
                if(mejor==-1){
                    vista.error();
                }else{
                    vista.mostrarMinMax(mejor, mayor);
                }
            }else if (opcion==8){
                vista.mostrarIntentos(competencia.consultarIntentos(), competencia.intentosDisponibles());
            }else if (opcion==9){
                loop=false;
            }else{
                vista.error();
            }
        }
    }

    private void crearAtleta(){
        loop2=true;
        while (loop2){
            String nombre = vista.pedirNombre();
            int numero = vista.pedirNumero();
            int edad = vista.pedirEdad();
            
            if(nombre==null || nombre.isEmpty() || numero<=0 || edad<=0){
                vista.error();
            }else{
                atleta=new Atleta(nombre, numero, edad);
                if(competencia==null){
                    competencia=new Competencia(atleta);
                }else{
                    competencia.cambiarAtleta(atleta);
                }
                loop2=false;
            }
        }
    }
}
