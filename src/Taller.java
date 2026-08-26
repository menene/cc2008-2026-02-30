import java.util.ArrayList;
import java.util.List;

public class Taller {
    //lista dinamica que almacena todas las ordenes registradas
    private List<OrdenServicio> ordenes;

    //constructor que crea la lista vacia de ordenes
    public Taller() {
        ordenes = new ArrayList<OrdenServicio>();
    }

    //agrega una nueva orden a la coleccion
    public void agregarOrden(OrdenServicio orden) {
        ordenes.add(orden);
    }

    //verifica si un numero de orden ya se encuentra registrado
    public boolean existeOrden(int numero) {
        for (OrdenServicio orden : ordenes) {
            if (orden.getNumeroOrden() == numero) {
                return true;
            }
        }

        return false;
    }

    //devuelve todas las ordenes almacenadas actualmente
    public List<OrdenServicio> obtenerTodas() {
        return ordenes;
    }

    //busca una orden utilizando su numero
    public OrdenServicio buscarPorNumero(int numero) {
        for (OrdenServicio orden : ordenes) {
            if (orden.getNumeroOrden() == numero) {
                return orden;
            }
        }

        throw new IllegalArgumentException("No existe una orden con ese numero.");
    }

    //modifica la descripcion y el costo de una orden registrada
    public void modificarOrden(int numero, String desc, double costo) {
        OrdenServicio orden = buscarPorNumero(numero);
        orden.setDescripcion(desc);
        orden.setCostoEstimado(costo);
    }

    //elimina de la coleccion la orden indicada
    public void cancelarOrden(int numero) {
        OrdenServicio orden = buscarPorNumero(numero);
        ordenes.remove(orden);
    }

    //devuelve las ordenes que pertenecen a una placa especifica
    public List<OrdenServicio> buscarPorPlaca(String placa) {
        List<OrdenServicio> coincidencias = new ArrayList<OrdenServicio>();

        for (OrdenServicio orden : ordenes) {
            if (orden.getPlaca().equalsIgnoreCase(placa)) {
                coincidencias.add(orden);
            }
        }

        return coincidencias;
    }

    //suma los costos estimados de todas las ordenes activas
    public double calcularTotal() {
        double total = 0;

        for (OrdenServicio orden : ordenes) {
            total += orden.getCostoEstimado();
        }

        return total;
    }

    //calcula el costo promedio de las ordenes activas
    public double calcularPromedio() {
        if (ordenes.size() == 0) {
            return 0;
        }

        return calcularTotal() / ordenes.size();
    }

    //devuelve la orden que posee el costo estimado mas alto
    public OrdenServicio obtenerMayorCosto() {
        if (ordenes.size() == 0) {
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

    //devuelve la cantidad actual de ordenes registradas
    public int obtenerCantidad() {
        return ordenes.size();
    }
}
