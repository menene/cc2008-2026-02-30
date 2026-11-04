
// Datos y comportamiento comunes de todos los proveedores.
public abstract class Integracion implements Comparable<Integracion> {
    private final int id;
    private final String nombre;
    private EstadoConexion estadoConexion;
    private double latenciaPromedioMs;
    private final String urlApi;
    private final int tiempoEsperaMs;
    private final TipoAutenticacion tipoAutenticacion;
    private final String aliasCredencial;

    protected Integracion(int id, String nombre, EstadoConexion estadoConexion,
            double latenciaPromedioMs, String urlApi, int tiempoEsperaMs,
            TipoAutenticacion tipoAutenticacion, String aliasCredencial) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser positivo.");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio.");
        }
        if (urlApi == null || urlApi.trim().isEmpty()) {
            throw new IllegalArgumentException("La URL de la API es obligatoria.");
        }
        if (tiempoEsperaMs <= 0) {
            throw new IllegalArgumentException("El tiempo de espera debe ser positivo.");
        }
        if (tipoAutenticacion == null || aliasCredencial == null) {
            throw new IllegalArgumentException("La autenticacion debe estar definida.");
        }
        if (tipoAutenticacion != TipoAutenticacion.NINGUNA
                && aliasCredencial.trim().isEmpty()) {
            throw new IllegalArgumentException("La credencial debe tener un alias.");
        }

        this.id = id;
        this.nombre = nombre;
        this.urlApi = urlApi;
        this.tiempoEsperaMs = tiempoEsperaMs;
        this.tipoAutenticacion = tipoAutenticacion;
        this.aliasCredencial = aliasCredencial;
        setEstadoConexion(estadoConexion);
        setLatenciaPromedioMs(latenciaPromedioMs);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public EstadoConexion getEstadoConexion() {
        return estadoConexion;
    }

    public void setEstadoConexion(EstadoConexion estadoConexion) {
        if (estadoConexion == null) {
            throw new IllegalArgumentException("El estado de conexion es obligatorio.");
        }
        this.estadoConexion = estadoConexion;
    }

    public double getLatenciaPromedioMs() {
        return latenciaPromedioMs;
    }

    public void setLatenciaPromedioMs(double latenciaPromedioMs) {
        if (!Double.isFinite(latenciaPromedioMs) || latenciaPromedioMs < 0) {
            throw new IllegalArgumentException("La latencia debe ser un numero no negativo.");
        }
        this.latenciaPromedioMs = latenciaPromedioMs;
    }

    public String getUrlApi() {
        return urlApi;
    }

    public int getTiempoEsperaMs() {
        return tiempoEsperaMs;
    }

    public TipoAutenticacion getTipoAutenticacion() {
        return tipoAutenticacion;
    }

    public String getAliasCredencial() {
        return aliasCredencial;
    }

    public String obtenerConfiguracion() {
        return "URL de la API: " + urlApi + "\n"
                + "Tiempo de espera (ms): " + tiempoEsperaMs + "\n"
                + "Autenticacion: " + tipoAutenticacion + "\n"
                + "Alias de credencial: "
                + (aliasCredencial.isEmpty() ? "No aplica" : aliasCredencial);
    }

    @Override
    public int compareTo(Integracion otra) {
        int comparacion = Double.compare(latenciaPromedioMs, otra.latenciaPromedioMs);
        return comparacion != 0 ? comparacion : Integer.compare(id, otra.id);
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }
        if (!(objeto instanceof Integracion)) {
            return false;
        }
        Integracion otra = (Integracion) objeto;
        return id == otra.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " | " + estadoConexion
                + " | " + latenciaPromedioMs + " ms";
    }
}
