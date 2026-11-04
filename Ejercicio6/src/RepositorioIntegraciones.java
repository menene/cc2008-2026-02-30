import java.util.List;

// Contrato para registrar y consultar integraciones.
public interface RepositorioIntegraciones {
    boolean registrar(Integracion integracion);

    Integracion buscar(int id);

    Integracion buscar(String nombre);

    List<Integracion> listar();

    List<Integracion> listarOrdenadasPorLatencia();
}
