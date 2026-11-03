// CC2008 - Ejercicio 6: Polimorfismo via Interfaces.
// Prototipo educativo: operaciones simuladas, sin llamadas de red.
package modelo;


/** Motor extensible: conoce capacidades y nunca nombres de proveedores concretos. */
public class MotorCheckout {
    public ResultadoOperacion solicitarReintegro(IntegracionAPI api, double monto, String ref) {
        if (api == null) { return fallida("Integración inexistente.", ref); }
        String error = validarDatos(monto, ref);
        if (error != null) { return fallida(error, ref); }
        if (!(api instanceof Transaccional)) {
            // No se realiza un cast inválido ni se lanza una excepción por incompatibilidad.
            return new ResultadoOperacion(EstadoResultado.IGNORADA,
                    "La integración " + api.getId() + " no admite reintegros; el checkout continúa.", ref);
        }
        return solicitarReintegro((Transaccional) api, monto, ref, "Solicitud del administrador");
    }
    /** Sobrecarga con cuatro parámetros: evita ambigüedad con la entrada genérica. */
    public ResultadoOperacion solicitarReintegro(Transaccional servicio, double monto, String ref, String motivo) {
        String error = validarDatos(monto, ref);
        if (error == null) { error = validarServicio(servicio); }
        if (error != null) { return fallida(error, ref); }
        try {
            ResultadoOperacion resultado = servicio.reintegrar(monto, ref);
            if (resultado == null) { return fallida("El proveedor no devolvió un resultado.", ref); }
            String detalle = motivo == null || motivo.isBlank() ? "" : " | Motivo: " + motivo.trim();
            return new ResultadoOperacion(resultado.getEstado(), resultado.getMensaje() + detalle, resultado.getReferencia());
        } catch (RuntimeException ex) {
            // Frontera de proveedor: un fallo de un adaptador no interrumpe el checkout.
            return fallida("El proveedor no pudo procesar el reintegro.", ref);
        }
    }
    public ResultadoOperacion solicitarCobro(Transaccional servicio, double monto, String ref) {
        String error = validarDatos(monto, ref);
        if (error == null) { error = validarServicio(servicio); }
        if (error != null) { return fallida(error, ref); }
        try {
            ResultadoOperacion resultado = servicio.cobrar(monto, ref);
            return resultado == null ? fallida("El proveedor no devolvió un resultado.", ref) : resultado;
        } catch (RuntimeException ex) {
            return fallida("El proveedor no pudo procesar el cobro.", ref);
        }
    }
    public String solicitarDocumento(Documentable servicio, String ref) {
        String error = validarReferencia(ref);
        if (error == null) { error = validarServicio(servicio); }
        if (error != null) { return "FALLIDA | " + error; }
        try {
            String resultado = servicio.generarDocumento(ref);
            return resultado == null ? "FALLIDA | Proveedor sin respuesta." : resultado;
        } catch (RuntimeException ex) {
            return "FALLIDA | El proveedor no pudo generar el documento.";
        }
    }
    public String solicitarConsulta(Consultable servicio, String ref) {
        String error = validarReferencia(ref);
        if (error == null) { error = validarServicio(servicio); }
        if (error != null) { return "FALLIDA | " + error; }
        try {
            String resultado = servicio.consultar(ref);
            return resultado == null ? "FALLIDA | Proveedor sin respuesta." : resultado;
        } catch (RuntimeException ex) {
            return "FALLIDA | El proveedor no pudo realizar la consulta.";
        }
    }
    private String validarDatos(double monto, String ref) {
        if (!Double.isFinite(monto) || monto <= 0) { return "El monto debe ser positivo y finito."; }
        return validarReferencia(ref);
    }
    private String validarReferencia(String ref) {
        return ref == null || ref.isBlank() || ref.codePoints().anyMatch(Character::isISOControl)
                ? "La referencia es obligatoria y no admite caracteres de control." : null;
    }
    private String validarServicio(Object servicio) {
        if (servicio == null) { return "Servicio inexistente."; }
        if (servicio instanceof IntegracionAPI) {
            IntegracionAPI api = (IntegracionAPI) servicio;
            if (!api.isActiva()) { return "Integración inactiva."; }
            if (!api.isConectada()) { return "Integración desconectada."; }
        }
        return null;
    }
    private ResultadoOperacion fallida(String mensaje, String ref) {
        return new ResultadoOperacion(EstadoResultado.FALLIDA, mensaje, ref);
    }
}
