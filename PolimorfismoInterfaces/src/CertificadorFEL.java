import java.util.ArrayList;
import java.util.Locale;

public class CertificadorFEL extends IntegracionAPI implements Documentable, Auditable {

    private String nitCertificador;
    private String ambiente;
    private int correlativoFactura;
    private ArrayList<String> bitacora;

    //Constructor: valida NIT no vacío y ambiente PRUEBAS o PRODUCCION
    public CertificadorFEL(String identificador, String nombreProveedor, String urlEndpoint,
                           String versionApi, int timeoutMs, double latenciaPromedioMs,
                           EstadoConexion estado, String nitCertificador, String ambiente) {
        super(identificador, nombreProveedor, urlEndpoint, versionApi, timeoutMs,
                latenciaPromedioMs, estado);
        this.nitCertificador = validarTexto(nitCertificador, "NIT del certificador");
        String amb = validarTexto(ambiente, "ambiente").toUpperCase();
        if (!amb.equals("PRUEBAS") && !amb.equals("PRODUCCION")) {
            throw new IllegalArgumentException("El ambiente debe ser PRUEBAS o PRODUCCION.");
        }
        this.ambiente = amb;
        this.correlativoFactura = 1;
        this.bitacora = new ArrayList<>();
    }

    //Overloading del constructor: usa el ambiente PRUEBAS por defecto
    public CertificadorFEL(String identificador, String nombreProveedor, String urlEndpoint,
                           String versionApi, int timeoutMs, double latenciaPromedioMs,
                           EstadoConexion estado, String nitCertificador) {
        this(identificador, nombreProveedor, urlEndpoint, versionApi, timeoutMs,
                latenciaPromedioMs, estado, nitCertificador, "PRUEBAS");
    }

    public String getNitCertificador() {
        return nitCertificador;
    }

    public String getAmbiente() {
        return ambiente;
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
                    "El certificador FEL está desconectado.");
        }
        String numero = String.format("FEL-%06d", correlativoFactura);
        correlativoFactura++;
        String xml = String.format(Locale.US,
                "<DTE ambiente=\"%s\">%n"
              + "  <NumeroFactura>%s</NumeroFactura>%n"
              + "  <NITCertificador>%s</NITCertificador>%n"
              + "  <Referencia>%s</Referencia>%n"
              + "  <Total moneda=\"GTQ\">%.2f</Total>%n"
              + "</DTE>",
                ambiente, numero, nitCertificador, referencia, monto);
        registrarEvento(String.format("FACTURA   %s | %s | Q%.2f", numero, referencia, monto));
        return new ResultadoOperacion(getIdentificador(), operacion, EstadoOperacion.EXITOSA, monto,
                "Factura certificada: " + numero, xml);
    }

    @Override
    public String getTipoDocumento() {
        return "Factura FEL";
    }

    @Override
    public void registrarEvento(String evento) {
        bitacora.add(evento);
    }

    //Devuelve una copia de la bitácora
    @Override
    public ArrayList<String> getBitacora() {
        return new ArrayList<>(bitacora);
    }

    @Override
    public String getTipoServicio() {
        return "Certificador FEL";
    }

    @Override
    public String describirConfiguracion() {
        return String.format("NIT certificador  : %s%nAmbiente          : %s%nSiguiente factura : FEL-%06d",
                nitCertificador, ambiente, correlativoFactura);
    }
}
