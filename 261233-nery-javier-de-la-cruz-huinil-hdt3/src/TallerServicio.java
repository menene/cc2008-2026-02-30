import java.util.ArrayList;
import java.util.List;

/* Clase administradora. Tiene la lista de ordenes y todo lo que se hace con ellas. */
public class TallerServicio {

    private List<OrdenServicio> ordenes;

    /* Constructor. Deja la coleccion vacia y lista para recibir el primer registro */
    public TallerServicio() {
        ordenes = new ArrayList<OrdenServicio>();
    }

    /* Agrega una orden nueva, pero antes valida que los datos esten bien */
    public void registrarOrden(OrdenServicio orden) {
        if (orden == null) {
            throw new IllegalArgumentException("La orden no puede estar vacia.");
        }
        if (orden.getNumeroOrden() <= 0) {
            throw new IllegalArgumentException("El numero de orden debe ser mayor a cero.");
        }
        if (existeNumero(orden.getNumeroOrden())) {
            throw new IllegalArgumentException("Ya existe una orden con el numero "
                    + orden.getNumeroOrden() + ".");
        }
        if (orden.getPropietario() == null || orden.getPropietario().trim().isEmpty()) {
            throw new IllegalArgumentException("El propietario no puede quedar vacio.");
        }
        if (orden.getPlaca() == null || orden.getPlaca().trim().isEmpty()) {
            throw new IllegalArgumentException("La placa no puede quedar vacia.");
        }
        if (orden.getDescripcion() == null || orden.getDescripcion().trim().isEmpty()) {
            throw new IllegalArgumentException("La descripcion no puede quedar vacia.");
        }
        if (orden.getCostoEstimado() < 0) {
            throw new IllegalArgumentException("El costo estimado no puede ser negativo.");
        }
        ordenes.add(orden);
    }

    /* Busca una orden por su numero. Devuelve null si no la encuentra */
    public OrdenServicio buscarPorNumero(int numeroOrden) {
        for (OrdenServicio orden : ordenes) {
            if (orden.getNumeroOrden() == numeroOrden) {
                return orden;
            }
        }
        return null;
    }

    /* Revisa si un numero de orden ya fue usado, para no repetir registros */
    private boolean existeNumero(int numeroOrden) {
        return buscarPorNumero(numeroOrden) != null;
    }

    /* Cambia la descripcion y el costo de una orden que ya esta registrada */
    public void modificarOrden(int numeroOrden, String nuevaDescripcion, double nuevoCosto) {
        OrdenServicio orden = buscarPorNumero(numeroOrden);
        if (orden == null) {
            throw new IllegalArgumentException("No existe la orden #" + numeroOrden + ".");
        }
        if (nuevaDescripcion == null || nuevaDescripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripcion no puede quedar vacia.");
        }
        if (nuevoCosto < 0) {
            throw new IllegalArgumentException("El costo estimado no puede ser negativo.");
        }
        orden.setDescripcion(nuevaDescripcion);
        orden.setCostoEstimado(nuevoCosto);
    }

    /* Saca del sistema una orden que se cancelo */
    public void cancelarOrden(int numeroOrden) {
        OrdenServicio orden = buscarPorNumero(numeroOrden);
        if (orden == null) {
            throw new IllegalArgumentException("No existe la orden #" + numeroOrden + ".");
        }
        ordenes.remove(orden);
    }

    /* Junta todas las ordenes de un mismo vehiculo, sin importar mayusculas */
    public List<OrdenServicio> consultarPorPlaca(String placa) {
        List<OrdenServicio> encontradas = new ArrayList<OrdenServicio>();
        if (placa == null) {
            return encontradas;
        }
        for (OrdenServicio orden : ordenes) {
            if (orden.getPlaca().equalsIgnoreCase(placa.trim())) {
                encontradas.add(orden);
            }
        }
        return encontradas;
    }

    /* Entrega el listado completo de ordenes */
    public List<OrdenServicio> listarOrdenes() {
        return ordenes;
    }

    /* Suma el costo de todas las ordenes */
    public double calcularTotal() {
        double total = 0;
        for (OrdenServicio orden : ordenes) {
            total = total + orden.getCostoEstimado();
        }
        return total;
    }

    /* Saca el costo promedio. Revisa que la lista no este vacia para no dividir entre cero */
    public double calcularPromedio() {
        if (ordenes.isEmpty()) {
            throw new IllegalStateException("No hay ordenes registradas para calcular el promedio.");
        }
        return calcularTotal() / ordenes.size();
    }

    /* Busca la orden mas cara. Devuelve null si todavia no hay ordenes */
    public OrdenServicio obtenerMayorCosto() {
        if (ordenes.isEmpty()) {
            return null;
        }
        OrdenServicio mayor = ordenes.get(0);
        for (OrdenServicio orden : ordenes) {
            if (orden.getCostoEstimado() > mayor.getCostoEstimado()) {
                mayor = orden;
            }
        }
        return mayor;
    }

    /* Dice cuantas ordenes hay registradas en este momento */
    public int cantidadOrdenes() {
        return ordenes.size();
    }
}
