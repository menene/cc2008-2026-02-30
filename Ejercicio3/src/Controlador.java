import java.util.ArrayList;
import java.util.List;

public class Controlador {
    private List<FichaReparacion> registroFichas;

    public Controlador() {
        registroFichas = new ArrayList<>();
    }

    public void ingresarFicha(FichaReparacion ficha) throws Exception {
        for (FichaReparacion f : registroFichas) {
            if (f.getIdOrden() == ficha.getIdOrden()) {
                throw new Exception("Error: El identificador ya existe.");
            }
        }
        registroFichas.add(ficha);
    }

    public List<FichaReparacion> obtenerTodas() {
        return registroFichas;
    }

    public FichaReparacion localizarFicha(int id) throws Exception {
        for (FichaReparacion f : registroFichas) {
            if (f.getIdOrden() == id) {
                return f;
            }
        }
        throw new Exception("Aviso: No se encontro el ID " + id);
    }

    public void editarFicha(int id, String detalle, double precio) throws Exception {
        FichaReparacion ficha = localizarFicha(id);
        ficha.actualizarDetalle(detalle);
        ficha.actualizarPrecio(precio);
    }

    public void eliminarFicha(int id) throws Exception {
        FichaReparacion ficha = localizarFicha(id);
        registroFichas.remove(ficha);
    }

    public List<FichaReparacion> filtrarPorMatricula(String placa) {
        List<FichaReparacion> resultados = new ArrayList<>();
        for (FichaReparacion f : registroFichas) {
            if (f.getMatricula().equalsIgnoreCase(placa)) {
                resultados.add(f);
            }
        }
        return resultados;
    }

    public double sumarIngresos() {
        double total = 0;
        for (FichaReparacion f : registroFichas) {
            total += f.getPrecioCalculado();
        }
        return total;
    }

    public double promediarPrecios() {
        if (registroFichas.isEmpty()) {
            return 0;
        }
        return sumarIngresos() / registroFichas.size();
    }

    public FichaReparacion encontrarMasCara() throws Exception {
        if (registroFichas.isEmpty()) {
            throw new Exception("Base de datos vacia.");
        }
        FichaReparacion mayor = registroFichas.get(0);
        for (FichaReparacion f : registroFichas) {
            if (f.getPrecioCalculado() > mayor.getPrecioCalculado()) {
                mayor = f;
            }
        }
        return mayor;
    }

    public int contarFichas() {
        return registroFichas.size();
    }
}