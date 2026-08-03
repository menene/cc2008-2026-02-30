public class Evento{
    private String Nombre;
    private Localidad[] Localidades= new Localidad[3];
    private int contador =0;

    public Evento (String nombre){
        this.Nombre= nombre;

    }

    public void agregarLocalidad(Localidad localidad){
        if (contador==0){
            Localidades[0]= localidad;
            contador ++;

        }else if(contador==1){
            Localidades[1]= localidad;
            contador ++;
        }else if(contador==2){
            Localidades[2]= localidad;
            contador ++;
        }
        
    }

    public Localidad obtenerLocalidad(String nombre){
        if (Localidades[0].getNombre().equals(nombre)) return Localidades[0];
        if (Localidades[1].getNombre().equals(nombre)) return Localidades[1];
        if (Localidades[2].getNombre().equals(nombre)) return Localidades[2];
        return null;
    }

    public Localidad[] obtenerLocalidades(){
        return Localidades;
    }

    public Localidad localidadAleatoria(){
        return Localidades[0]; // ni modos 
    }
}