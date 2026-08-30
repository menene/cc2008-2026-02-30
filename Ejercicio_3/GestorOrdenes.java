import java.util.ArrayList;
import java.util.List;

// Esta clase maneja la lista de ordenes del taller
public class GestorOrdenes {

    private List<OrdenServicio> ordenes;

    public GestorOrdenes() {
        ordenes = new ArrayList<OrdenServicio>();
    }

    // Agrega una nueva orden si los datos son validos
    public void registrarOrden(OrdenServicio orden) throws OrdenException {

        if (orden.getNombrePropietario().equals("")) {
            throw new OrdenException("El nombre del propietario no puede estar vacio.");
        }
        if (orden.getPlacaVehiculo().equals("")) {
            throw new OrdenException("La placa no puede estar vacia.");
        }
        if (orden.getDescripcionServicio().equals("")) {
            throw new OrdenException("La descripcion no puede estar vacia.");
        }
        if (orden.getCostoEstimado() <= 0) {
            throw new OrdenException("El costo debe ser mayor que 0.");
        }

        // Revisamos que el numero de orden no exista ya
        for (int i = 0; i < ordenes.size(); i++) {
            if (ordenes.get(i).getNumeroOrden() == orden.getNumeroOrden()) {
                throw new OrdenException("Ya existe una orden con ese numero.");
            }
        }

        ordenes.add(orden);
    }

    // Devuelve la lista completa de ordenes
    public List<OrdenServicio> consultarOrdenes() {
        return ordenes;
    }

    // Busca una orden por su numero
    public OrdenServicio buscarOrden(int numeroOrden) throws OrdenException {
        for (int i = 0; i < ordenes.size(); i++) {
            if (ordenes.get(i).getNumeroOrden() == numeroOrden) {
                return ordenes.get(i);
            }
        }
        throw new OrdenException("No existe una orden con el numero " + numeroOrden);
    }

    // Cambia la descripcion y el costo de una orden ya registrada
    public void modificarOrden(int numeroOrden, String nuevaDescripcion, double nuevoCosto) throws OrdenException {
        OrdenServicio orden = buscarOrden(numeroOrden);

        if (nuevaDescripcion.equals("")) {
            throw new OrdenException("La descripcion no puede estar vacia.");
        }
        if (nuevoCosto <= 0) {
            throw new OrdenException("El costo debe ser mayor que 0.");
        }

        orden.setDescripcionServicio(nuevaDescripcion);
        orden.setCostoEstimado(nuevoCosto);
    }

    // Elimina una orden de la lista
    public void cancelarOrden(int numeroOrden) throws OrdenException {
        OrdenServicio orden = buscarOrden(numeroOrden);
        ordenes.remove(orden);
    }

    // Devuelve las ordenes que tengan la misma placa
    public List<OrdenServicio> consultarPorPlaca(String placa) {
        List<OrdenServicio> resultado = new ArrayList<OrdenServicio>();
        for (int i = 0; i < ordenes.size(); i++) {
            if (ordenes.get(i).getPlacaVehiculo().equalsIgnoreCase(placa)) {
                resultado.add(ordenes.get(i));
            }
        }
        return resultado;
    }

    // Suma el costo de todas las ordenes
    public double calcularValorTotal() {
        double total = 0;
        for (int i = 0; i < ordenes.size(); i++) {
            total = total + ordenes.get(i).getCostoEstimado();
        }
        return total;
    }

    // Calcula el promedio del costo de las ordenes
    public double calcularCostoPromedio() {
        if (ordenes.size() == 0) {
            return 0;
        }
        return calcularValorTotal() / ordenes.size();
    }

    // Busca la orden con el costo mas alto
    public OrdenServicio obtenerOrdenMayorCosto() throws OrdenException {
        if (ordenes.size() == 0) {
            throw new OrdenException("No hay ordenes registradas.");
        }
        OrdenServicio mayor = ordenes.get(0);
        for (int i = 1; i < ordenes.size(); i++) {
            if (ordenes.get(i).getCostoEstimado() > mayor.getCostoEstimado()) {
                mayor = ordenes.get(i);
            }
        }
        return mayor;
    }

    // Devuelve cuantas ordenes hay
    public int cantidadOrdenes() {
        return ordenes.size();
    }
}
