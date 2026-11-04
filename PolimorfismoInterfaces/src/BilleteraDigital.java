public class BilleteraDigital extends PasarelaPago {

    private double limitePorTransaccion;

    public BilleteraDigital(String identificador, String nombreProveedor, String urlEndpoint,
                            String versionApi, int timeoutMs, double latenciaPromedioMs,
                            EstadoConexion estado, double comisionPorcentaje,
                            double limitePorTransaccion) {
        super(identificador, nombreProveedor, urlEndpoint, versionApi, timeoutMs,
                latenciaPromedioMs, estado, comisionPorcentaje);
        if (limitePorTransaccion <= 0) {
            throw new IllegalArgumentException("El límite por transacción debe ser mayor que cero.");
        }
        this.limitePorTransaccion = limitePorTransaccion;
    }

    public double getLimitePorTransaccion() {
        return limitePorTransaccion;
    }

    @Override
    protected String motivoRechazoCobro(double monto) {
        if (monto > limitePorTransaccion) {
            return String.format("El monto supera el límite por transacción (Q%.2f).", limitePorTransaccion);
        }
        return "";
    }

    @Override
    public String getTipoServicio() {
        return "Pasarela de pago - Billetera digital";
    }

    @Override
    public String describirConfiguracion() {
        return super.describirConfiguracion()
                + String.format("%nLímite por cobro  : Q%.2f", limitePorTransaccion);
    }
}
