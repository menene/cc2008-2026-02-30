public class PasarelaTransferencia extends PasarelaPago {

    private static final double MONTO_MINIMO = 100;

    private String bancoAfiliado;
    private String cuentaComercio;

    // Constructor: valida banco y cuenta no vacíos
    public PasarelaTransferencia(String identificador, String nombreProveedor, String urlEndpoint,
                                 String versionApi, int timeoutMs, double latenciaPromedioMs,
                                 EstadoConexion estado, double comisionPorcentaje,
                                 String bancoAfiliado, String cuentaComercio) {
        super(identificador, nombreProveedor, urlEndpoint, versionApi, timeoutMs,
                latenciaPromedioMs, estado, comisionPorcentaje);
        this.bancoAfiliado = validarTexto(bancoAfiliado, "banco afiliado");
        this.cuentaComercio = validarTexto(cuentaComercio, "cuenta del comercio");
    }

    public String getBancoAfiliado() {
        return bancoAfiliado;
    }

    public String getCuentaComercio() {
        return cuentaComercio;
    }

    // Rechaza montos menores que Q100
    @Override
    protected String motivoRechazoCobro(double monto) {
        if (monto < MONTO_MINIMO) {
            return String.format("Las transferencias requieren un monto mínimo de Q%.2f.", MONTO_MINIMO);
        }
        return "";
    }

    @Override
    public String getTipoServicio() {
        return "Pasarela de pago - Transferencia";
    }

    @Override
    public String describirConfiguracion() {
        return super.describirConfiguracion()
                + String.format("%nBanco afiliado    : %s%nCuenta comercio   : %s%nMonto mínimo      : Q%.2f",
                        bancoAfiliado, cuentaComercio, MONTO_MINIMO);
    }
}
