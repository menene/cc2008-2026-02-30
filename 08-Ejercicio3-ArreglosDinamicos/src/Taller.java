import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

//Se crea la clase del Taller
public class Taller {

    private List<OrdenServicio> ordenes;

    // Constructor que inicializa la lista de ordenes como un ArrayList.
    public Taller() {
        ordenes = new ArrayList<OrdenServicio>();
    }
 
    public void registrarOrden(OrdenServicio nuevaOrden) {
        validarOrden(nuevaOrden);

        if (existeNumeroOrden(nuevaOrden.getNumeroOrden())) {
            throw new IllegalArgumentException(
                    "El numero de orden ya se encuentra registrado.");
        }

        ordenes.add(nuevaOrden);
    }

    // Devuelve una copia de la lista de ordenes para evitar modificaciones externas.
    public List<OrdenServicio> obtenerOrdenes() {
        return new ArrayList<OrdenServicio>(ordenes);
    }

    // Busca una orden por su numero y devuelve la orden si se encuentra, de lo contrario lanza una excepcion.
    public OrdenServicio buscarOrden(int numeroOrden) {
        for (OrdenServicio orden : ordenes) {
            if (orden.getNumeroOrden() == numeroOrden) {
                return orden;
            }
        }

        throw new NoSuchElementException(
                "No existe una orden con el numero " + numeroOrden + ".");
    }

    //Modifica la descripción y el costo estimado de una orden existente, validando los datos antes de realizar la modificación.
    public void modificarOrden(int numeroOrden, String nuevaDescripcion,
            double nuevoCosto) {
        validarTexto(nuevaDescripcion, "La descripcion del servicio");
        validarCosto(nuevoCosto);

        OrdenServicio orden = buscarOrden(numeroOrden);
        orden.setDescripcionServicio(nuevaDescripcion.trim());
        orden.setCostoEstimado(nuevoCosto);
    }

    // Elimina de la coleccion la orden indicada.
    public void cancelarOrden(int numeroOrden) {
        OrdenServicio orden = buscarOrden(numeroOrden);
        ordenes.remove(orden);
    }

    // Busca todas las ordenes que coincidan con la placa del vehiculo proporcionada y devuelve una lista de coincidencias.
    public List<OrdenServicio> buscarOrdenesPorPlaca(String placa) {
        validarTexto(placa, "La placa del vehiculo");

        List<OrdenServicio> coincidencias = new ArrayList<OrdenServicio>();

        for (OrdenServicio orden : ordenes) {
            if (orden.getPlacaVehiculo().equalsIgnoreCase(placa.trim())) {
                coincidencias.add(orden);
            }
        }

        return coincidencias;
    }

    // Calcula el costo total de todas las ordenes registradas.
    public double calcularCostoTotal() {
        double total = 0;

        for (OrdenServicio orden : ordenes) {
            total += orden.getCostoEstimado();
        }

        return total;
    }

    // Calcula el costo promedio. Si no hay ordenes, devuelve cero.
    public double calcularCostoPromedio() {
        if (ordenes.isEmpty()) {
            return 0;
        }

        return calcularCostoTotal() / ordenes.size();
    }

    // Devuelve la orden con el costo estimado
    public OrdenServicio obtenerOrdenMayorCosto() {
        if (ordenes.isEmpty()) {
            throw new NoSuchElementException(
                    "No hay ordenes registradas para realizar la comparacion.");
        }

        OrdenServicio ordenMayorCosto = ordenes.get(0);

        for (OrdenServicio orden : ordenes) {
            if (orden.getCostoEstimado()
                    > ordenMayorCosto.getCostoEstimado()) {
                ordenMayorCosto = orden;
            }
        }

        return ordenMayorCosto;
    }

    // Devuelve la orden con el costo estimado menor
    public int obtenerCantidadOrdenes() {
        return ordenes.size();
    }

    // Devuelve la orden con el costo estimado menor
    private boolean existeNumeroOrden(int numeroOrden) {
        for (OrdenServicio orden : ordenes) {
            if (orden.getNumeroOrden() == numeroOrden) {
                return true;
            }
        }

        return false;
    }

    // Valida los datos de la orden antes de registrarla o modificarla, lanzando excepciones si los datos no son válidos.
    private void validarOrden(OrdenServicio orden) {
        if (orden == null) {
            throw new IllegalArgumentException("La orden no puede ser nula.");
        }

        if (orden.getNumeroOrden() <= 0) {
            throw new IllegalArgumentException(
                    "El numero de orden debe ser mayor que cero.");
        }

        validarTexto(orden.getNombrePropietario(),
                "El nombre del propietario");
        validarTexto(orden.getPlacaVehiculo(), "La placa del vehiculo");
        validarTexto(orden.getDescripcionServicio(),
                "La descripcion del servicio");
        validarCosto(orden.getCostoEstimado());
    }

    private void validarTexto(String texto, String nombreCampo) {
        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    nombreCampo + " no puede estar vacia.");
        }
    }

    private void validarCosto(double costo) {
        if (costo <= 0) {
            throw new IllegalArgumentException(
                    "El costo estimado debe ser mayor que cero.");
        }
    }
}