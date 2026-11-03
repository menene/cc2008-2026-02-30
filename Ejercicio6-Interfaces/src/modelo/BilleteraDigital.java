// CC2008 - Ejercicio 6: Polimorfismo via Interfaces.
// Prototipo educativo: operaciones simuladas, sin llamadas de red.
package modelo;


/** Proveedor financiero simulado que cumple únicamente el contrato Transaccional. */
public class BilleteraDigital extends IntegracionAPI implements Transaccional {

    public BilleteraDigital(String id, String nombre, String endpoint, String tipoAutenticacion,
                 int timeoutMs, double latenciaPromedioMs, boolean activa, boolean conectada) {
        super(id, nombre, endpoint, tipoAutenticacion, timeoutMs, latenciaPromedioMs, activa, conectada);
    }

    @Override
    public ResultadoOperacion cobrar(double monto, String ref) {
        return procesar("Cobro", monto, ref);
    }
    @Override
    public ResultadoOperacion reintegrar(double monto, String ref) {
        return procesar("Reintegro", monto, ref);
    }
    // Ayudante privado: valida también llamadas directas al contrato.
    private ResultadoOperacion procesar(String operacion, double monto, String ref) {
        if (!Double.isFinite(monto) || monto <= 0 || ref == null || ref.isBlank()) {
            return new ResultadoOperacion(EstadoResultado.FALLIDA, "Monto positivo finito y referencia obligatorios.", ref);
        }
        if (!isActiva() || !isConectada()) {
            return new ResultadoOperacion(EstadoResultado.FALLIDA, "Integración inactiva o desconectada.", ref);
        }
        return new ResultadoOperacion(EstadoResultado.EXITOSA,
                registrarEvento(operacion + " simulado por billetera digital: " + monto), ref);
    }
}
