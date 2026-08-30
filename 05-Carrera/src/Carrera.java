public class Carrera {
    Atleta atleta = new Atleta(1, "Juan", 10);
    VistaCarrera Vista = new VistaCarrera();
    

    public String RegistrarTiempo(int tiempo){
        String mensaje = atleta.AgregarIntento(tiempo);
        Vista.toString(mensaje);
        return mensaje;
    }

    public void VerIntentos(){
        int [] verintentos= atleta.VerArray();
        String mensaje = "Ver todos los intentos";
        Vista.VerIntentos(verintentos, mensaje);
    }

    public void VerIntento(int indice){
        int [] verintentos= atleta.VerArray();
        Vista.VerIntento(indice-1,verintentos);
    }

    public String EditarTiempo(int indice, int nuevointento){
        String mensaje = atleta.EditarIntento(indice,nuevointento );
        Vista.toString(mensaje);
        return mensaje;
    }

    public void Promedio (){
        int [] array = atleta.VerArray();
        String mensaje;
        if (array == null || array.length == 0) {
            mensaje = "no se puede realizar el promedio";
            Vista.toString(mensaje); // por lo visto esta parte quedara en intencion :v
        }else{
            long suma =0;
            for (int tiempo: array){
                suma += tiempo;
            }
            double promedio = suma /array.length;
            mensaje = "Promedio de tiempo";
            Vista.toString(mensaje);
            Vista.MostrarPromedio(promedio);
        }

    }

    public void MostrarMejortiempo(){
        int [] array = atleta.VerArray();
        int mayor = array [0];
        for (int i = 0; i < array.length; i++){
            if (array[i] < mayor){
                mayor = array[i];
            }
        }
        Vista.MostrarMayor(mayor);
    }

    public void Disponibles(){
        int disponibles = atleta.contadorDisponibles();
        Vista.mostrarDisponibles(disponibles);
    }

}
