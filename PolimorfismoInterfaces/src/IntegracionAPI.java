public abstract class IntegracionAPI implements Comparable<IntegracionAPI> {

    private String identificador;
    private String nombreProveedor;
    private String urlEndpoint;
    private String versionApi;
    private int timeoutMs;
    private double latenciaPromedioMs;
    private EstadoConexion estadoConexion;

    //Valida textos no vacíos, timeout > 0, latencia >= 0 y estado distinto de null.
    protected IntegracionAPI(String identificador, String nombreProveedor, String urlEndpoint,
                             String versionApi, int timeoutMs, double latenciaPromedioMs,
                             EstadoConexion estado) {
        this.identificador = validarTexto(identificador, "identificador");
        this.nombreProveedor = validarTexto(nombreProveedor, "nombre del proveedor");
        this.urlEndpoint = validarTexto(urlEndpoint, "URL del endpoint");
        this.versionApi = validarTexto(versionApi, "versión de la API");
        if (timeoutMs <= 0) {
            throw new IllegalArgumentException("El timeout debe ser mayor que cero.");
        }
        this.timeoutMs = timeoutMs;
        setLatenciaPromedioMs(latenciaPromedioMs);
        setEstadoConexion(estado);
    }

    //Valida que un texto no sea null ni vacío y lo devuelve sin espacios, etc.
    protected static String validarTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo '" + campo + "' no puede estar vacío.");
        }
        return valor.trim();
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public String getUrlEndpoint() {
        return urlEndpoint;
    }

    public String getVersionApi() {
        return versionApi;
    }

    public int getTimeoutMs() {
        return timeoutMs;
    }

    public double getLatenciaPromedioMs() {
        return latenciaPromedioMs;
    }

    public EstadoConexion getEstadoConexion() {
        return estadoConexion;
    }

    public void setEstadoConexion(EstadoConexion estado) {
        if (estado == null) {
            throw new IllegalArgumentException("El estado de conexión no puede ser null.");
        }
        this.estadoConexion = estado;
    }

    // Actualiza la latencia medida (>= 0)
    public void setLatenciaPromedioMs(double latencia) {
        if (latencia < 0) {
            throw new IllegalArgumentException("La latencia no puede ser negativa.");
        }
        this.latenciaPromedioMs = latencia;
    }

    public boolean estaDisponible() {
        return estadoConexion != EstadoConexion.DESCONECTADA;
    }

    public abstract String getTipoServicio();

    public abstract String describirConfiguracion();

    public final String getConfiguracion() {
        return String.format(
                "Identificador     : %s%n"
              + "Proveedor         : %s%n"
              + "Tipo de servicio  : %s%n"
              + "Endpoint          : %s%n"
              + "Versión API       : %s%n"
              + "Timeout           : %d ms%n"
              + "Latencia promedio : %.1f ms%n"
              + "Estado            : %s%n"
              + "--- Parámetros propios ---%n"
              + "%s",
                identificador, nombreProveedor, getTipoServicio(), urlEndpoint, versionApi,
                timeoutMs, latenciaPromedioMs, estadoConexion, describirConfiguracion());
    }

    // Latencia ascendente; si empatan, por identificador
    @Override
    public int compareTo(IntegracionAPI otra) {
        int porLatencia = Double.compare(this.latenciaPromedioMs, otra.getLatenciaPromedioMs());
        if (porLatencia != 0) {
            return porLatencia;
        }
        return this.identificador.compareToIgnoreCase(otra.getIdentificador());
    }

    //Dos integraciones son iguales si tienen el mismo identificador
    @Override
    public boolean equals(Object otro) {
        if (this == otro) {
            return true;
        }
        if (!(otro instanceof IntegracionAPI)) {
            return false;
        }
        IntegracionAPI otra = (IntegracionAPI) otro;
        return this.identificador.equalsIgnoreCase(otra.getIdentificador());
    }

    @Override
    public int hashCode() {
        return identificador.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return String.format("%-11s | %-20s | %-38s | %-12s | %7.1f ms",
                identificador, nombreProveedor, getTipoServicio(), estadoConexion,
                latenciaPromedioMs);
    }
}
