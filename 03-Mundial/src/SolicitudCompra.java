import java.util.Random;

public class SolicitudCompra {
    private int cantidadBoletos;
    private double presupuestoMaximo;
    private int numeroTicket;

    public SolicitudCompra(int cantidadBoletos, double presupuestoMaximo) {
        this.cantidadBoletos = cantidadBoletos;
        this.presupuestoMaximo = presupuestoMaximo;
        this.numeroTicket = generarNumeroAleatorio();
    }

    private int generarNumeroAleatorio() {
        Random random = new Random();
        return random.nextInt(15000) + 1;
    }

    public boolean esTicketApto() {
        int a = generarNumeroAleatorio();
        int b = generarNumeroAleatorio();

        int limiteMenor = Math.min(a, b);
        int limiteMayor = Math.max(a, b);

        return numeroTicket >= limiteMenor
                && numeroTicket <= limiteMayor;
    }

    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    public double getPresupuestoMaximo() {
        return presupuestoMaximo;
    }

    public int getNumeroTicket() {
        return numeroTicket;
    }
}