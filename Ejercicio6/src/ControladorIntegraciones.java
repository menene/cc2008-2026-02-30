import java.math.BigDecimal;
import java.util.List;

// Coordina el catalogo y las capacidades de cada proveedor.
public class ControladorIntegraciones {
    private final RepositorioIntegraciones catalogo;

    public ControladorIntegraciones(RepositorioIntegraciones catalogo) {
        if (catalogo == null) {
            throw new IllegalArgumentException("El catalogo es obligatorio.");
        }
        this.catalogo = catalogo;
    }

    public List<Integracion> listarIntegraciones() {
        return catalogo.listar();
    }

    public Integracion buscarIntegracion(int id) {
        return catalogo.buscar(id);
    }

    public List<Integracion> listarPorLatencia() {
        return catalogo.listarOrdenadasPorLatencia();
    }

    public String solicitarConsulta(int id, String referencia) {
        Integracion integracion = catalogo.buscar(id);
        if (integracion == null) {
            return "Integracion no encontrada.";
        }
        if (!(integracion instanceof Consultable)) {
            return "Esta integracion no admite consultas.";
        }
        return ejecutarConsulta((Consultable) integracion, referencia);
    }

    public ResultadoOperacion solicitarCobro(int id, BigDecimal monto) {
        Integracion integracion = catalogo.buscar(id);
        if (integracion == null) {
            return ResultadoOperacion.INTEGRACION_NO_ENCONTRADA;
        }
        if (!(integracion instanceof Transaccional)) {
            return ResultadoOperacion.NO_SOPORTADO;
        }
        return ejecutarCobro((Transaccional) integracion, monto);
    }

    public ResultadoOperacion solicitarReintegro(int id, BigDecimal monto) {
        Integracion integracion = catalogo.buscar(id);
        if (integracion == null) {
            return ResultadoOperacion.INTEGRACION_NO_ENCONTRADA;
        }
        if (!(integracion instanceof Transaccional)) {
            return ResultadoOperacion.NO_SOPORTADO;
        }
        return ejecutarReintegro((Transaccional) integracion, monto);
    }

    public String solicitarDocumento(int id, String referencia) {
        Integracion integracion = catalogo.buscar(id);
        if (integracion == null) {
            return "Integracion no encontrada.";
        }
        if (!(integracion instanceof Documentable)) {
            return "Esta integracion no genera documentos.";
        }
        return ejecutarDocumento((Documentable) integracion, referencia);
    }

    public String solicitarAuditoria(int id, String referencia) {
        Integracion integracion = catalogo.buscar(id);
        if (integracion == null) {
            return "Integracion no encontrada.";
        }
        if (!(integracion instanceof Auditable)) {
            return "Esta integracion no ofrece auditoria.";
        }
        return ejecutarAuditoria((Auditable) integracion, referencia);
    }

    private String ejecutarConsulta(Consultable proveedor, String referencia) {
        return proveedor.consultar(referencia);
    }

    private ResultadoOperacion ejecutarCobro(Transaccional proveedor, BigDecimal monto) {
        return proveedor.cobrar(monto);
    }

    private ResultadoOperacion ejecutarReintegro(Transaccional proveedor, BigDecimal monto) {
        return proveedor.reintegrar(monto);
    }

    private String ejecutarDocumento(Documentable proveedor, String referencia) {
        return proveedor.generarDocumento(referencia);
    }

    private String ejecutarAuditoria(Auditable proveedor, String referencia) {
        return proveedor.obtenerRegistro(referencia);
    }
}
