public class Torneo{

    // atributos

    String nombre;
    Atleta atletaActivo = null;

    // métodos

    //constructor, inicializa el nombre del torneo; atletaActivo inicia en null
    public Torneo(String nombre){
        this.nombre = nombre;
    }
    
    //retorna el nombre del torneo
    public String getNombre(){
        return nombre;
    }
    
    //retorna el atleta actualmente activo
    public Atleta getAtletaActivo(){
        return atletaActivo;
    }
    
    //reemplaza el atleta activo por uno nuevo
    public void setAtletaActivo(Atleta atletaActivo){
        this.atletaActivo = atletaActivo;
    }
    

}