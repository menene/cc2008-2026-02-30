import java.math.BigDecimal;

// Pasarela de pago con operaciones simuladas.
public class PasarelaPago extends Integracion implements Transaccional, Auditable {
    private final String codigoComercio;
    private final String monedaLiquidacion;

    public PasarelaPago(int id, String nombre, EstadoConexion estadoConexion,
            double latenciaPromedioMs, String urlApi, int tiempoEsperaMs,
            TipoAutenticacion tipoAutenticacion, String aliasCredencial,
            String codigoComercio, String monedaLiquidacion) {
        super(id, nombre, estadoConexion, latenciaPromedioMs, urlApi,
                tiempoEsperaMs, tipoAutenticacion, aliasCredencial);
        if (codigoComercio == null || codigoComercio.trim().isEmpty()) {
            throw new IllegalArgumentException("El codigo de comercio es obligatorio.");
        }
        if (monedaLiquidacion == null || monedaLiquidacion.trim().isEmpty()) {
            throw new IllegalArgumentException("La moneda de liquidacion es obligatoria.");
        }
        this.codigoComercio = codigoComercio;
        this.monedaLiquidacion = monedaLiquidacion;
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
    public String obtenerRegistro(String referencia) {
        if (referencia == null || referencia.trim().isEmpty()) {
            return "La referencia de la operacion es obligatoria.";
        }
        if (getEstadoConexion() != EstadoConexion.ACTIVA) {
            return "No se puede consultar el registro: la integracion no esta activa.";
        }
        return "Registro de pago simulado | Referencia: " + referencia.trim()
                + " | Pasarela: " + getNombre()
                + " | Moneda: " + monedaLiquidacion;
    }

    @Override
    public String obtenerConfiguracion() {
        return super.obtenerConfiguracion()
                + "\nCodigo de comercio: " + codigoComercio
                + "\nMoneda de liquidacion: " + monedaLiquidacion;
    }
}
