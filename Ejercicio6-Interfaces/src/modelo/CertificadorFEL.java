// CC2008 - Ejercicio 6: Polimorfismo via Interfaces.
// Prototipo educativo: operaciones simuladas, sin llamadas de red.
package modelo;

/** Servicio simulado; no implementa Transaccional. */
public class CertificadorFEL extends IntegracionAPI implements Documentable {

    public CertificadorFEL(String id, String nombre, String endpoint, String tipoAutenticacion,
                 int timeoutMs, double latenciaPromedioMs, boolean activa, boolean conectada) {
        super(id, nombre, endpoint, tipoAutenticacion, timeoutMs, latenciaPromedioMs, activa, conectada);
    }

    @Override
    public String generarDocumento(String ref) {
        String error = validarSolicitud(ref);
        if (error != null) { return error; }
        // Representación de prueba, sin validez fiscal ni certificación real.
        return "<FEL simulada=\"true\"><Referencia>" + escaparXml(ref)
                + "</Referencia></FEL>";
    }
    private String escaparXml(String texto) {
        return texto.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")
                .replace("\"", "&quot;").replace("'", "&apos;");
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
