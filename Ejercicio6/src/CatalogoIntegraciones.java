import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Mantiene la unica lista de integraciones del sistema.
public class CatalogoIntegraciones implements RepositorioIntegraciones {
    private final List<Integracion> integraciones = new ArrayList<>();

    @Override
    public boolean registrar(Integracion integracion) {
        if (integracion == null || buscar(integracion.getId()) != null) {
            return false;
        }
        integraciones.add(integracion);
        return true;
    }

    @Override
    public Integracion buscar(int id) {
        for (Integracion integracion : integraciones) {
            if (integracion.getId() == id) {
                return integracion;
            }
        }
        return null;
    }

    @Override
    public Integracion buscar(String nombre) {
        for (Integracion integracion : integraciones) {
            if (integracion.coincideNombre(nombre)) {
                return integracion;
            }
        }
        return null;
    }

    @Override
    public List<Integracion> listar() {
        return Collections.unmodifiableList(integraciones);
    }

    @Override
    public List<Integracion> listarOrdenadasPorLatencia() {
        integraciones.sort(null);
        return listar();
    }
}
