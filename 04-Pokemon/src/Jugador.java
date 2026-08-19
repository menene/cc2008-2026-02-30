public class Jugador{
    byte id;
    String nombre;
    byte victorias; 
    byte rol;
    EquipoPokemon equipo;

    public byte getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public byte getVictorias(){
        return victorias;
    }

    public byte getRol(){
        return rol;
    }
    
    public void Victoria() {
        victorias++;
    }


    public Jugador (byte id,String nombre,byte victorias,byte rol){
        this.id=id;
        this.nombre=nombre;
        this.victorias=victorias;
        this.rol= rol;
        equipo= new EquipoPokemon(id);
    }
}