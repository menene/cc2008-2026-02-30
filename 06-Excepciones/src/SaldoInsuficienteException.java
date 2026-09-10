public class SaldoInsuficienteException extends Exception {

    private double saldo;
    private double solicitado;

    public SaldoInsuficienteException(double saldo, double solicitado) {
        super(String.format("Saldo insuficiente: se pidieron Q%.2f y solo hay Q%.2f.",
                solicitado, saldo));
        this.saldo = saldo;
        this.solicitado = solicitado;
    }

    public double getFaltante() {
        return solicitado - saldo;
    }
}
