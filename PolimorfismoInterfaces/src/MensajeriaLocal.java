public class MensajeriaLocal extends ProveedorLogistica {

    private double pesoMaximoKg;

    public MensajeriaLocal(String identificador, String nombreProveedor, String urlEndpoint,
                           String versionApi, int timeoutMs, double latenciaPromedioMs,
                           EstadoConexion estado, String zonaCobertura, double tarifaBase,
                           double tarifaPorKg, double pesoMaximoKg) {
        super(identificador, nombreProveedor, urlEndpoint, versionApi, timeoutMs,
                latenciaPromedioMs, estado, zonaCobertura, tarifaBase, tarifaPorKg);
        if (pesoMaximoKg <= 0) {
            throw new IllegalArgumentException("El peso máximo debe ser mayor que cero.");
        }
        this.pesoMaximoKg = pesoMaximoKg;
    }

    public double getPesoMaximoKg() {
        return pesoMaximoKg;
    }

    //True si el peso no pasa el máximo
    @Override
    protected boolean admitePeso(double pesoKg) {
        return pesoKg <= pesoMaximoKg;
    }

    @Override
    protected double calcularRecargo(double pesoKg) {
        return 0;
    }

    @Override
    public String getTipoServicio() {
        return "Logística - Mensajería local";
    }

    @Override
    public String describirConfiguracion() {
        return super.describirConfiguracion()
                + String.format("%nPeso máximo       : %.2f kg", pesoMaximoKg);
    }
}
