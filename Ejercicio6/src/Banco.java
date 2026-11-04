import java.math.BigDecimal;

// Banco con transferencias y consultas simuladas.
public class Banco extends Integracion implements Consultable, Transaccional, Auditable {
    private final String codigoBancario;
    private final String monedaTransferencia;

    public Banco(int id, String nombre, EstadoConexion estadoConexion,
            double latenciaPromedioMs, String urlApi, int tiempoEsperaMs,
            TipoAutenticacion tipoAutenticacion, String aliasCredencial,
            String codigoBancario, String monedaTransferencia) {
        super(id, nombre, estadoConexion, latenciaPromedioMs, urlApi,
                tiempoEsperaMs, tipoAutenticacion, aliasCredencial);
        if (codigoBancario == null || codigoBancario.trim().isEmpty()) {
            throw new IllegalArgumentException("El codigo bancario es obligatorio.");
        }
        if (monedaTransferencia == null || monedaTransferencia.trim().isEmpty()) {
            throw new IllegalArgumentException("La moneda de transferencia es obligatoria.");
        }
        this.codigoBancario = codigoBancario;
        this.monedaTransferencia = monedaTransferencia;
    }

    @Override
    public String consultar(String referencia) {
        if (referencia == null || referencia.trim().isEmpty()) {
            return "La referencia de la transferencia es obligatoria.";
        }
        if (getEstadoConexion() != EstadoConexion.ACTIVA) {
            return "No se puede consultar: la integracion no esta activa.";
        }
        return "Consulta bancaria simulada | Referencia: " + referencia.trim()
                + " | Banco: " + codigoBancario;
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
            return "La referencia de la transferencia es obligatoria.";
        }
        if (getEstadoConexion() != EstadoConexion.ACTIVA) {
            return "No se puede consultar el registro: la integracion no esta activa.";
        }
        return "Registro bancario simulado | Referencia: " + referencia.trim()
                + " | Banco: " + codigoBancario
                + " | Moneda: " + monedaTransferencia;
    }

    @Override
    public String obtenerConfiguracion() {
        return super.obtenerConfiguracion()
                + "\nCodigo bancario: " + codigoBancario
                + "\nMoneda de transferencia: " + monedaTransferencia;
    }
}
