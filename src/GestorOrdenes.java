import java.util.ArrayList;
import java.util.List;

public class GestorOrdenes {

    //aca declaro la coleccion solo con List
    private List<OrdenServicio> ordenes;

    public GestorOrdenes() {
        //y aca ya uso ArrayList para almacenar los objetos ordenes, sin importar su tamaño 
        ordenes = new ArrayList<OrdenServicio>();
    }

    //metodo para cuando hallan errores al agregar una orden
    public void agregarOrden(OrdenServicio orden) {
        if (buscarOrden(orden.getNumeroOrden()) != null) {
            throw new IllegalArgumentException("El número de orden ya se encuentra registrado.");
        }

        if (orden.getPropietario().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del propietario no puede estar vacío.");
        }

        if (orden.getPlaca().trim().isEmpty()) {
            throw new IllegalArgumentException("La placa no puede estar vacía.");
        }

        if (orden.getDescripcionServicio().trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción del servicio no puede estar vacía.");
        }

        if (orden.getCostoEstimado() <= 0) {
            throw new IllegalArgumentException("El costo estimado debe ser mayor que 0.");
        }

        ordenes.add(orden);
    }

    //metodo que busca segun el numero de orden
    public OrdenServicio buscarOrden(int numeroOrden) {
        for (OrdenServicio orden : ordenes) {
            if (orden.getNumeroOrden() == numeroOrden) {
                return orden;
            }
        }

        return null;
    }

    public List<OrdenServicio> obtenerOrdenes() {
        return ordenes;
    }

    public void modificarOrden(int numeroOrden, String descripcionServicio, double costoEstimado) {
        OrdenServicio orden = buscarOrden(numeroOrden);

        if (orden == null) {
            throw new IllegalArgumentException("La orden no se encuentra registrada.");
        }

        if (descripcionServicio.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción del servicio no puede estar vacía.");
        }

        if (costoEstimado <= 0) {
            throw new IllegalArgumentException("El costo estimado debe ser mayor que 0.");
        }

        orden.setDescripcionServicio(descripcionServicio);
        orden.setCostoEstimado(costoEstimado);
    }
    

    public void cancelarOrden(int numeroOrden) {
        OrdenServicio orden = buscarOrden(numeroOrden);

        if (orden == null) {
            throw new IllegalArgumentException("La orden no se encuentra registrada.");
        }

        ordenes.remove(orden);
    }


    public List<OrdenServicio> buscarPorPlaca(String placa) {
        List<OrdenServicio> coincidencias = new ArrayList<OrdenServicio>();

        for (OrdenServicio orden : ordenes) {
            if (orden.getPlaca().equalsIgnoreCase(placa)) {
                coincidencias.add(orden);
            }
        }

        return coincidencias;
    }


    public double calcularTotal() {
        double total = 0;

        for (OrdenServicio orden : ordenes) {
            total += orden.getCostoEstimado();
        }

        return total;
    }

    public double calcularPromedio() {
        if (ordenes.isEmpty()) {
            return 0;
        }

        return calcularTotal() / ordenes.size();
    }

    public OrdenServicio obtenerOrdenMayorCosto() {
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

    public int cantidadOrdenes() {
        return ordenes.size();
    }

}