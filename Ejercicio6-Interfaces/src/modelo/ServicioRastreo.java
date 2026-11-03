// CC2008 - Ejercicio 6: Polimorfismo via Interfaces.
// Prototipo educativo: operaciones simuladas, sin llamadas de red.
package modelo;

/** Servicio simulado; no implementa Transaccional. */
public class ServicioRastreo extends IntegracionAPI implements Consultable {

    public ServicioRastreo(String id, String nombre, String endpoint, String tipoAutenticacion,
                 int timeoutMs, double latenciaPromedioMs, boolean activa, boolean conectada) {
        super(id, nombre, endpoint, tipoAutenticacion, timeoutMs, latenciaPromedioMs, activa, conectada);
    }

    @Override
    public String consultar(String ref) {
        String error = validarSolicitud(ref);
        return error != null ? error : "EXITOSA | Seguimiento simulado en " + getNombre()
                + ": envío en tránsito | Referencia: " + ref;
    }

    private String validarSolicitud(String ref) {
        if (ref == null || ref.isBlank() || ref.codePoints().anyMatch(Character::isISOControl)) {
            return "FALLIDA | Referencia obligatoria, sin caracteres de control.";
        }
        if (!isActiva() || !isConectada()) {
            return "FALLIDA | Integración inactiva o desconectada.";
        }
        return null;
    }
}
