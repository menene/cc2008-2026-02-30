// CC2008 - Ejercicio 6: Polimorfismo via Interfaces.
// Prototipo educativo: operaciones simuladas, sin llamadas de red.
package modelo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Único propietario de la lista polimórfica. No se crean catálogos por proveedor. */
public class CatalogoIntegraciones {
    private final List<IntegracionAPI> integraciones;

    public CatalogoIntegraciones() {
        integraciones = new ArrayList<IntegracionAPI>();
    }
    public boolean agregar(IntegracionAPI api) {
        if (api == null || buscarPorId(api.getId()) != null) { return false; }
        return integraciones.add(api);
    }
    public Iterable<IntegracionAPI> listar() {
        // Envoltura de lectura sobre la MISMA lista: sin copia y sin remove mediante iterator.
        return Collections.unmodifiableList(integraciones);
    }
    public IntegracionAPI buscarPorId(String id) {
        if (id == null) { return null; }
        for (IntegracionAPI api : integraciones) {
            if (api.getId().equals(id.trim())) { return api; }
        }
        return null;
    }
    public void ordenarPorLatencia() { Collections.sort(integraciones); }
    public int cantidad() { return integraciones.size(); }
}
