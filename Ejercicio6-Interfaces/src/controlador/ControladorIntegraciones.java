// CC2008 - Ejercicio 6: Polimorfismo via Interfaces.
// Prototipo educativo: operaciones simuladas, sin llamadas de red.
package controlador;


import java.util.Objects;
import modelo.*;

/** Coordina la vista y el modelo sin leer ni imprimir y sin almacenar otras listas. */
public class ControladorIntegraciones {
    private final CatalogoIntegraciones catalogo;
    private final MotorCheckout checkout;

    public ControladorIntegraciones(CatalogoIntegraciones catalogo, MotorCheckout checkout) {
        this.catalogo = Objects.requireNonNull(catalogo);
        this.checkout = Objects.requireNonNull(checkout);
    }
    public Iterable<IntegracionAPI> listar() { return catalogo.listar(); }
    public IntegracionAPI buscar(String id) { return catalogo.buscarPorId(id); }
    public void ordenarPorLatencia() { catalogo.ordenarPorLatencia(); }
    public ResultadoOperacion reintegrar(String id, double monto, String ref) {
        return checkout.solicitarReintegro(buscar(id), monto, ref);
    }
    public boolean registrar(IntegracionAPI api) { return catalogo.agregar(api); }

    // Delegaciones adicionales documentadas previamente en docs/PRECISIONES-DISENO.md.
    public ResultadoOperacion cobrar(String id, double monto, String ref) {
        IntegracionAPI api = buscar(id);
        if (api == null) { return new ResultadoOperacion(EstadoResultado.FALLIDA, "Integración inexistente.", ref); }
        if (!(api instanceof Transaccional)) {
            return new ResultadoOperacion(EstadoResultado.IGNORADA, "La integración no admite cobros.", ref);
        }
        return checkout.solicitarCobro((Transaccional) api, monto, ref);
    }
    public String consultar(String id, String ref) {
        IntegracionAPI api = buscar(id);
        if (api == null) { return "FALLIDA | Integración inexistente."; }
        return api instanceof Consultable ? checkout.solicitarConsulta((Consultable) api, ref)
                : "IGNORADA | La integración no admite consultas.";
    }
    public String generarDocumento(String id, String ref) {
        IntegracionAPI api = buscar(id);
        if (api == null) { return "FALLIDA | Integración inexistente."; }
        return api instanceof Documentable ? checkout.solicitarDocumento((Documentable) api, ref)
                : "IGNORADA | La integración no genera documentos.";
    }
}
