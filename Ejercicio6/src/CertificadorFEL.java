// Certificador con generacion y auditoria FEL simuladas.
public class CertificadorFEL extends Integracion implements Documentable, Auditable {
    private final String versionEsquemaFEL;
    private final AmbienteFEL ambiente;

    public CertificadorFEL(int id, String nombre, EstadoConexion estadoConexion,
            double latenciaPromedioMs, String urlApi, int tiempoEsperaMs,
            TipoAutenticacion tipoAutenticacion, String aliasCredencial,
            String versionEsquemaFEL, AmbienteFEL ambiente) {
        super(id, nombre, estadoConexion, latenciaPromedioMs, urlApi,
                tiempoEsperaMs, tipoAutenticacion, aliasCredencial);
        if (versionEsquemaFEL == null || versionEsquemaFEL.trim().isEmpty()) {
            throw new IllegalArgumentException("La version del esquema FEL es obligatoria.");
        }
        if (ambiente == null) {
            throw new IllegalArgumentException("El ambiente FEL es obligatorio.");
        }
        this.versionEsquemaFEL = versionEsquemaFEL;
        this.ambiente = ambiente;
    }

    @Override
    public String generarDocumento(String referencia) {
        if (referencia == null || referencia.trim().isEmpty()) {
            return "La referencia de la factura es obligatoria.";
        }
        if (getEstadoConexion() != EstadoConexion.ACTIVA) {
            return "No se puede generar la factura: la integracion no esta activa.";
        }
        return "XML FEL simulado | Referencia: " + referencia.trim()
                + " | Version: " + versionEsquemaFEL
                + " | Ambiente: " + ambiente;
    }

    @Override
    public String obtenerRegistro(String referencia) {
        if (referencia == null || referencia.trim().isEmpty()) {
            return "La referencia de la factura es obligatoria.";
        }
        if (getEstadoConexion() != EstadoConexion.ACTIVA) {
            return "No se puede consultar el registro: la integracion no esta activa.";
        }
        return "Registro de auditoria simulado | Referencia: " + referencia.trim()
                + " | Certificador: " + getNombre()
                + " | Ambiente: " + ambiente;
    }

    @Override
    public String obtenerConfiguracion() {
        return super.obtenerConfiguracion()
                + "\nVersion del esquema FEL: " + versionEsquemaFEL
                + "\nAmbiente FEL: " + ambiente;
    }
}
