public class Escenario {
    private int codigoEsc; 
    private String nombreEsc;
    private String ubicacion; 
    private int capMaxAsist; 
    private boolean estado; 


    public Escenario( int codigoEsc, String nombreEsc, String ubicacion, int capMaxAsist, boolean estado){
        this.codigoEsc = codigoEsc; 
        this.nombreEsc = nombreEsc;
        this.ubicacion = ubicacion; 
        setCapMaxAsist(capMaxAsist); 
        this.estado = estado; 
    }


    public int getCodigoEsc(){
        return codigoEsc; 
    }

    public String getNombreEsc(){
        return nombreEsc; 
    }

    public String getUbicacion(){
        return ubicacion; 
    }

    public int getCapMaxAsist(){
        return capMaxAsist; 
    }

    public boolean getEstado(){
        return estado; 
    }

    public void setCapMaxAsist(int capMaxAsist){
        if (capMaxAsist <= 0){
            throw new IllegalArgumentException("No se aceptan valores menores a 0");
        } 
        this.capMaxAsist = capMaxAsist; 
        

    }
    
    public void setEstado(boolean estado) {
        this.estado = estado; 

    }
}
