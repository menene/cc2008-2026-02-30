public class Ticket {

    private int numeroTicket;
    private int a;
    private int b;
    private int cantidadBoletos;
    private float presupuesto;
    private Localidad localidadAsignada;
    private Comprador comprador;
    private int cantidadVendida;
    
    public Ticket(int cantidadBoletos, float presupuesto, Comprador comprador) {
        this.cantidadBoletos = cantidadBoletos;
        this.presupuesto = presupuesto;
        this.comprador = comprador;
        this.localidadAsignada = null; 
        this.cantidadVendida = 0; 

    }

    public void setNumeros(int numeroTicket, int a, int b) {
        this.numeroTicket = numeroTicket;
        this.a = a;
        this.b = b;
    }

    public void setLocalidadAsignada(Localidad localidad) {
        this.localidadAsignada = localidad;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public boolean esApto() {
        return localidadAsignada != null;
    }
    
    public int getNumeroTicket() {
        return numeroTicket;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    public float getPresupuesto() {
        return presupuesto;
    }

    public Localidad getLocalidadAsignada() {
        return localidadAsignada;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }
    
} 