public class Comprador{
    // atributos
    private String nombre;
    private String email;
    private int boletosQuerer;
    private int presupuesto;
    private int ticket;
    private boolean esApto;
    private Localidad localidad;
    private int boletosTener;

    // métodos
    public Comprador(String nombre, String email, int boletosQuerer, int  presupuesto){
        this.nombre = nombre;
        this.email = email;
        this.boletosQuerer = boletosQuerer;
        this.presupuesto = presupuesto;
    }

    public String getNombre(){
        return nombre;
    }

    public String getEmail(){
        return email;
    }

    public int getBoletosQuerer(){
        return boletosQuerer;
    }

    public int getPresupuesto(){
        return presupuesto;
    }

    public int getTicket(){
        return ticket;
    }

    public void setTicket(int ticket){
        this.ticket = ticket;
    }

    public boolean getEsApto(){
        return esApto;
    }

    public void setEsApto(boolean esApto){
        this.esApto = esApto;
    }

    public Localidad getLocalidad(){
        return localidad;
    }

    public void setLocalidad(Localidad localidad){
        this.localidad = localidad;
    }

    public int getBoletosTener(){
        return boletosTener;
    }

    public void setBoletosTener(int boletosTener){
        this.boletosTener = boletosTener;
    }

}
