public class Localidad{
    private int numero;
    private int precio;
    private int disponibles;

    public Localidad(int numero, int precio ){
        this.numero = numero;
        this.precio = precio;
        this.disponibles = 20;
    }
    public boolean hayEspacio(){
        if (disponibles > 0){
            return false;
        }
        return true;
    }
    //getters
    
    public int getNumero(){
        return numero;
    }
    public int getprecio(){
        return precio;
    }
    public int getdisponibles(){
        return disponibles;
    }
    //setters
    public void setPrecio(int precio){
        this.precio = precio;
    }
    public void setnumero(int numero){
        this.numero = numero;
    }
    public void setdisponibles(int disponibles){
        this.disponibles = disponibles;
    }

    public void venderBoletos(int cantidad){
        disponibles = disponibles - cantidad;

    }



}