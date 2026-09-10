public class CuentaBancaria {
    private String titular;
    private double saldo;

    public CuentaBancaria(String titular, double saldo) {
        if (titular == null || titular.trim().isEmpty()) {
            throw new IllegalArgumentException("La cuenta necesita un titular.");
        }
        if (saldo < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
        }

        this.titular = titular;
        this.saldo = saldo;
    }

    public void retirar(double monto) throws SaldoInsuficienteException {
        if (monto <= 0) {
            // unchecked
            throw new IllegalArgumentException("El retiro debe ser mayor a cero.");
        }
        if (monto > saldo) {
            // checked
            throw new SaldoInsuficienteException(saldo, monto);
        }
        saldo -= monto;
    }

    @Override
    public String toString() {
        return String.format("Cuenta de %s | Saldo: Q%.2f", titular, saldo);
    }
}
