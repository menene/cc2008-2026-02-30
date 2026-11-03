// CC2008 - Ejercicio 6: Polimorfismo via Interfaces.
// Prototipo educativo: operaciones simuladas, sin llamadas de red.
package modelo;


import java.net.URI;
import java.util.Objects;

/**
 * Configuración común e identidad de cualquier proveedor.
 * El orden natural (latencia, id) puede diferir de equals (id), como en el diseño.
 * El catálogo evita identidades duplicadas. No contiene claves ni tokens.
 */
public abstract class IntegracionAPI implements Auditable, Comparable<IntegracionAPI> {
    private final String id;
    private String nombre;
    private String endpoint;
    private String tipoAutenticacion;
    private int timeoutMs;
    private double latenciaPromedioMs;
    private boolean activa;
    private boolean conectada;

    public IntegracionAPI(String id, String nombre, String endpoint, String tipoAutenticacion,
                         int timeoutMs, double latenciaPromedioMs, boolean activa, boolean conectada) {
        this.id = validarTexto(id, "Identificador");
        // No invocar métodos sobreescribibles durante la construcción de subclases.
        this.nombre = validarTexto(nombre, "Nombre");
        this.endpoint = validarEndpoint(endpoint);
        this.tipoAutenticacion = validarTexto(tipoAutenticacion, "Tipo de autenticación");
        this.timeoutMs = validarTimeout(timeoutMs);
        this.latenciaPromedioMs = validarLatencia(latenciaPromedioMs);
        this.activa = activa;
        this.conectada = conectada;
    }
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEndpoint() { return endpoint; }
    public String getTipoAutenticacion() { return tipoAutenticacion; }
    public int getTimeoutMs() { return timeoutMs; }
    public double getLatenciaPromedioMs() { return latenciaPromedioMs; }
    public boolean isActiva() { return activa; }
    public boolean isConectada() { return conectada; }
    public void setNombre(String valor) { nombre = validarTexto(valor, "Nombre"); }
    public void setEndpoint(String valor) {
        endpoint = validarEndpoint(valor);
    }
    private static String validarEndpoint(String valor) {
        String texto = validarTexto(valor, "Endpoint");
        URI uri = URI.create(texto);
        if (!("https".equalsIgnoreCase(uri.getScheme()) || "http".equalsIgnoreCase(uri.getScheme()))
                || uri.getHost() == null || uri.getRawUserInfo() != null
                || uri.getRawQuery() != null || uri.getRawFragment() != null) {
            throw new IllegalArgumentException("Use una URL base HTTP(S), sin credenciales, consulta ni fragmento.");
        }
        return texto;
    }
    public void setTipoAutenticacion(String valor) {
        tipoAutenticacion = validarTexto(valor, "Tipo de autenticación");
    }
    public void setTimeoutMs(int valor) {
        timeoutMs = validarTimeout(valor);
    }
    private static int validarTimeout(int valor) {
        if (valor <= 0) { throw new IllegalArgumentException("El timeout debe ser positivo."); }
        return valor;
    }
    public void setLatenciaPromedioMs(double valor) {
        latenciaPromedioMs = validarLatencia(valor);
    }
    private static double validarLatencia(double valor) {
        if (!Double.isFinite(valor) || valor < 0) {
            throw new IllegalArgumentException("La latencia debe ser finita y no negativa.");
        }
        return valor == 0 ? 0 : valor;
    }
    public void setActiva(boolean valor) { activa = valor; }
    public void setConectada(boolean valor) { conectada = valor; }
    public String obtenerConfiguracion() {
        return "Id: " + id + "\nNombre: " + nombre + "\nEndpoint: " + endpoint
                + "\nAutenticación (solo tipo): " + tipoAutenticacion + "\nTimeout: " + timeoutMs + " ms"
                + "\nLatencia: " + latenciaPromedioMs + " ms\nActiva: " + activa
                + "\nConectada: " + conectada;
    }
    @Override
    public String registrarEvento(String evento) {
        // Registro devuelto al solicitante: el diseño no almacena una lista de eventos.
        return "[AUDITORÍA " + id + "] " + validarTexto(evento, "Evento");
    }
    @Override
    public int compareTo(IntegracionAPI otra) {
        Objects.requireNonNull(otra, "La integración es obligatoria.");
        int comparacion = Double.compare(latenciaPromedioMs, otra.latenciaPromedioMs);
        return comparacion != 0 ? comparacion : id.compareTo(otra.id);
    }
    @Override
    public boolean equals(Object obj) {
        return this == obj || (obj instanceof IntegracionAPI && id.equals(((IntegracionAPI) obj).id));
    }
    @Override
    public int hashCode() { return id.hashCode(); }
    @Override
    public String toString() {
        return id + " | " + nombre + " | " + latenciaPromedioMs + " ms | "
                + (activa ? "activa" : "inactiva") + " | "
                + (conectada ? "conectada" : "desconectada");
    }
    private static String validarTexto(String valor, String campo) {
        if (valor == null || valor.isBlank() || valor.codePoints().anyMatch(Character::isISOControl)) {
            throw new IllegalArgumentException(campo + " es obligatorio y no admite caracteres de control.");
        }
        return valor.trim();
    }
}
