public class ResultadoOperacion {

    private String idIntegracion;
    private String operacion;
    private EstadoOperacion estado;
    private double monto;
    private String mensaje;
    private String detalle;

    // Constructor completo: guarda cómo terminó una petición
    public ResultadoOperacion(String idIntegracion, String operacion, EstadoOperacion estado,
                              double monto, String mensaje, String detalle) {
        this.idIntegracion = idIntegracion;
        this.operacion = operacion;
        this.estado = estado;
        this.monto = monto;
        this.mensaje = mensaje;
        this.detalle = (detalle == null) ? "" : detalle;
    }

    // Overloading del constructor para resultados sin monto ni detalle
    public ResultadoOperacion(String idIntegracion, String operacion, EstadoOperacion estado,
                              String mensaje) {
        this(idIntegracion, operacion, estado, 0, mensaje, "");
    }

    public String getIdIntegracion() {
        return idIntegracion;
    }

    public String getOperacion() {
        return operacion;
    }

    public EstadoOperacion getEstado() {
        return estado;
    }

    public double getMonto() {
        return monto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getDetalle() {
        return detalle;
    }

    // Devuelve true si el estado es exitosa
    public boolean fueExitosa() {
        return estado == EstadoOperacion.EXITOSA;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s | %s | Q%.2f | %s",
                estado, operacion, idIntegracion, monto, mensaje);
    }
}
