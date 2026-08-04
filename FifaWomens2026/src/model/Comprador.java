package model;

/* Clase del comprador. Guarda sus datos y lo que ha comprado. */
public class Comprador {

    private String nombreComprador;
    private String emailComprador;
    private int boletosDeseados;
    private double presupuestoMaximo;
    private int boletosComprados;
    private double totalPagado;

    /* Constructor con solo el nombre y el email */
    public Comprador(String nombreComprador, String emailComprador) {
        this.nombreComprador = nombreComprador;
        this.emailComprador = emailComprador;
        boletosDeseados = 0;
        presupuestoMaximo = 0.0;
        boletosComprados = 0;
        totalPagado = 0.0;
    }

    /* Constructor sobrecargado, recibe tambien los boletos y el presupuesto */
    public Comprador(String nombreComprador, String emailComprador, int boletosDeseados, double presupuestoMaximo) {
        this.nombreComprador = nombreComprador;
        this.emailComprador = emailComprador;
        this.boletosDeseados = boletosDeseados;
        this.presupuestoMaximo = presupuestoMaximo;
        boletosComprados = 0;
        totalPagado = 0.0;
    }

    /* Anota que compro un boleto */
    public void comprarBoleto(double precioBoleto) {
        boletosComprados = boletosComprados + 1;
        totalPagado = totalPagado + precioBoleto;
    }

    /* Sobrecarga. Anota que compro varios boletos */
    public void comprarBoleto(int cantidadBoletos, double precioBoleto) {
        boletosComprados = boletosComprados + cantidadBoletos;
        totalPagado = totalPagado + (cantidadBoletos * precioBoleto);
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public String getEmailComprador() {
        return emailComprador;
    }

    public int getBoletosDeseados() {
        return boletosDeseados;
    }

    public double getPresupuestoMaximo() {
        return presupuestoMaximo;
    }

    public int getBoletosComprados() {
        return boletosComprados;
    }

    public double getTotalPagado() {
        return totalPagado;
    }
}
