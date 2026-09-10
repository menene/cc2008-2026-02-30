public class Artista {
    private int codigoArt; 
    private String nombreArt; 
    private String generoMusc; 
    private int duracionMin; 
    private int cantidadEst; 

    public Artista(int codigoArt, String nombreArt, String generoMusc, int duracionMin, int cantidadEst){
        this.codigoArt = codigoArt; 
        this.nombreArt = nombreArt; 
        this.generoMusc = generoMusc; 
        setDuracionMin(duracionMin);
        setCantidadEst(cantidadEst);
    }
    

    public int getCodigoArt() {
        return codigoArt; 
    }

    public String getNombreArt(){
        return nombreArt; 
    }

    public String getGeneroMusc(){
        return generoMusc; 
    }

    public int getDuracionMin(){
        return duracionMin;
    }

    public int getCantidadEst(){
        return cantidadEst;
    }

    public void setNombreArt(String nombreArt){
        this.nombreArt = nombreArt; 
    }

    public void setGeneroMusc( String generoMusc){
        this.generoMusc = generoMusc; 
    }

    public void setDuracionMin(int duracionMin) {
        if (duracionMin <= 0){
            throw new IllegalArgumentException("No se aceptan valores menores a 0");
        } else{
            this.duracionMin = duracionMin; 
        }
    }

    public void setCantidadEst(int cantidadEst){
        if (cantidadEst < 0){
            throw new IllegalArgumentException("No se aceptan valores menores a 0");
        } else{
            this.cantidadEst = cantidadEst; 
        }
    }
}
