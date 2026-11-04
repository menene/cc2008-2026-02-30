import java.math.BigDecimal;

// Billetera digital con consultas y pagos simulados.
public class BilleteraDigital extends Integracion implements Consultable, Transaccional {
    private final String idComercio;
    private final String monedaSaldo;

    public BilleteraDigital(int id, String nombre, EstadoConexion estadoConexion,
            double latenciaPromedioMs, String urlApi, int tiempoEsperaMs,
            TipoAutenticacion tipoAutenticacion, String aliasCredencial,
            String idComercio, String monedaSaldo) {
        super(id, nombre, estadoConexion, latenciaPromedioMs, urlApi,
                tiempoEsperaMs, tipoAutenticacion, aliasCredencial);
        if (idComercio == null || idComercio.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID de comercio es obligatorio.");
        }
        if (monedaSaldo == null || monedaSaldo.trim().isEmpty()) {
            throw new IllegalArgumentException("La moneda del saldo es obligatoria.");
        }
        this.idComercio = idComercio;
        this.monedaSaldo = monedaSaldo;
    }

    @Override
    public String consultar(String referencia) {
        if (referencia == null || referencia.trim().isEmpty()) {
            return "La referencia de la operacion es obligatoria.";
        }
        if (getEstadoConexion() != EstadoConexion.ACTIVA) {
            return "No se puede consultar: la integracion no esta activa.";
        }
        return "Consulta de billetera simulada | Referencia: " + referencia.trim()
                + " | Comercio: " + idComercio;
    }

    @Override
    public ResultadoOperacion cobrar(BigDecimal monto) {
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0
                || getEstadoConexion() != EstadoConexion.ACTIVA) {
            return ResultadoOperacion.RECHAZADO;
        }
        return ResultadoOperacion.EXITOSO;
    }

    @Override
    public ResultadoOperacion reintegrar(BigDecimal monto) {
        if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0
                || getEstadoConexion() != EstadoConexion.ACTIVA) {
            return ResultadoOperacion.RECHAZADO;
        }
        return ResultadoOperacion.EXITOSO;
    }

    @Override
    public String obtenerConfiguracion() {
        return super.obtenerConfiguracion()
                + "\nID de comercio: " + idComercio
                + "\nMoneda del saldo: " + monedaSaldo;
    }
}
