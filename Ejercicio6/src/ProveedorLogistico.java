// Proveedor de envios con consulta y generacion de guias.
public class ProveedorLogistico extends Integracion implements Consultable, Documentable {
    private final String zonaCobertura;
    private final String tipoServicio;

    public ProveedorLogistico(int id, String nombre, EstadoConexion estadoConexion,
            double latenciaPromedioMs, String urlApi, int tiempoEsperaMs,
            TipoAutenticacion tipoAutenticacion, String aliasCredencial,
            String zonaCobertura, String tipoServicio) {
        super(id, nombre, estadoConexion, latenciaPromedioMs, urlApi,
                tiempoEsperaMs, tipoAutenticacion, aliasCredencial);
        if (zonaCobertura == null || zonaCobertura.trim().isEmpty()) {
            throw new IllegalArgumentException("La zona de cobertura es obligatoria.");
        }
        if (tipoServicio == null || tipoServicio.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de servicio es obligatorio.");
        }
        this.zonaCobertura = zonaCobertura;
        this.tipoServicio = tipoServicio;
    }

    @Override
    public String consultar(String referencia) {
        if (referencia == null || referencia.trim().isEmpty()) {
            return "La referencia del envio es obligatoria.";
        }
        if (getEstadoConexion() != EstadoConexion.ACTIVA) {
            return "No se puede consultar: la integracion no esta activa.";
        }
        return "El envio " + referencia.trim() + " esta en transito en " + zonaCobertura + ".";
    }

    @Override
    public String generarDocumento(String referencia) {
        if (referencia == null || referencia.trim().isEmpty()) {
            return "La referencia del envio es obligatoria.";
        }
        if (getEstadoConexion() != EstadoConexion.ACTIVA) {
            return "No se puede generar la guia: la integracion no esta activa.";
        }
        return "Guia de envio | Proveedor: " + getNombre()
                + " | Referencia: " + referencia.trim()
                + " | Servicio: " + tipoServicio
                + " | Cobertura: " + zonaCobertura;
    }

    @Override
    public String obtenerConfiguracion() {
        return super.obtenerConfiguracion()
                + "\nZona de cobertura: " + zonaCobertura
                + "\nTipo de servicio: " + tipoServicio;
    }
}
