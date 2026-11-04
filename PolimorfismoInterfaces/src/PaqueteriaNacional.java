import java.util.Locale;

public class PaqueteriaNacional extends ProveedorLogistica implements Documentable {

    private static final double LIMITE_SOBREPESO = 20;
    private static final double RECARGO_SOBREPESO = 50;

    private String prefijoGuia;
    private int correlativoGuia;

    //Valida prefijo no vacío; correlativo en 1
    public PaqueteriaNacional(String identificador, String nombreProveedor, String urlEndpoint,
                              String versionApi, int timeoutMs, double latenciaPromedioMs,
                              EstadoConexion estado, String zonaCobertura, double tarifaBase,
                              double tarifaPorKg, String prefijoGuia) {
        super(identificador, nombreProveedor, urlEndpoint, versionApi, timeoutMs,
                latenciaPromedioMs, estado, zonaCobertura, tarifaBase, tarifaPorKg);
        this.prefijoGuia = validarTexto(prefijoGuia, "prefijo de guía").toUpperCase();
        this.correlativoGuia = 1;
    }

    public String getPrefijoGuia() {
        return prefijoGuia;
    }

    @Override
    protected double calcularRecargo(double pesoKg) {
        return (pesoKg > LIMITE_SOBREPESO) ? RECARGO_SOBREPESO : 0;
    }

    @Override
    public ResultadoOperacion generarDocumento(String referencia) {
        return generarDocumento(referencia, 0);
    }

    @Override
    public ResultadoOperacion generarDocumento(String referencia, double monto) {
        String operacion = getTipoDocumento();
        if (!estaDisponible()) {
            return new ResultadoOperacion(getIdentificador(), operacion, EstadoOperacion.RECHAZADA,
                    "El proveedor logístico está desconectado.");
        }
        String codigo = String.format("%s-%04d", prefijoGuia, correlativoGuia);
        correlativoGuia++;
        String xml = String.format(Locale.US,
                "<GuiaEnvio>%n"
              + "  <Codigo>%s</Codigo>%n"
              + "  <Proveedor>%s</Proveedor>%n"
              + "  <Referencia>%s</Referencia>%n"
              + "  <CostoEnvio moneda=\"GTQ\">%.2f</CostoEnvio>%n"
              + "</GuiaEnvio>",
                codigo, getNombreProveedor(), referencia, monto);
        return new ResultadoOperacion(getIdentificador(), operacion, EstadoOperacion.EXITOSA, monto,
                "Guía generada: " + codigo, xml);
    }

    @Override
    public String getTipoDocumento() {
        return "Guía de envío";
    }

    @Override
    public String getTipoServicio() {
        return "Logística - Paquetería nacional";
    }

    @Override
    public String describirConfiguracion() {
        return super.describirConfiguracion()
                + String.format("%nPrefijo de guía   : %s%nSiguiente guía    : %s-%04d",
                        prefijoGuia, prefijoGuia, correlativoGuia);
    }
}
