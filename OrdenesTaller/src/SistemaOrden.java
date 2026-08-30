//para poder usar todo lo de las listas y excepciones
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class SistemaOrden {

    //la lista de orden que se va a usar y en la que se van a guardar
    private List<Orden> ordenes;

    public SistemaOrden() 
    {
        this.ordenes = new ArrayList<>();
    }

    //Los errores que pueden pasar y el mesaje que muestra
    public boolean registrarOrden(int numOrden, String nombre, String placa,String descripcion, double costo) {
        if (existeOrden(numOrden)) 
        {
            throw new IllegalArgumentException("Ya existe una orden registrada con el numero " + numOrden);
        }
        if (nombre == null || nombre.trim().isEmpty()) 
        {
            throw new IllegalArgumentException("El nombre del propietario no puede estar vacío");
        }
        if (placa == null || placa.trim().isEmpty()) 
        {
            throw new IllegalArgumentException("La placa del vehiculo no puede estar vacía");
        }
        if (descripcion == null || descripcion.trim().isEmpty()) 
        {
            throw new IllegalArgumentException("La descripción del servicio no puede estar vacía");
        }
        if (costo <= 0) 
        {
            throw new IllegalArgumentException("El costo estimado debe ser mayor que 0");
        }

        Orden nuevaOrden = new Orden(numOrden, nombre, placa, descripcion, costo);
        return ordenes.add(nuevaOrden);
    }

    //Busca una orden por su numero y la retorna, también está pendiente de NoSuchElementException por si la orden no existe
    public Orden buscarOrden(int numeroOrden) {
        for (Orden orden : ordenes) {
            if (orden.getNumOrden() == numeroOrden) 
            {
                return orden;
            }
        }
        throw new NoSuchElementException("No existe ninguna orden registrada con el numero " + numeroOrden);
    }

    //Para modificar descripción y costo
    public void modificarOrden(int numOrden, String descServicio, double costoEstimado) {
        Orden orden = buscarOrden(numOrden); //excepcion por si no existe

        if (descServicio == null || descServicio.trim().isEmpty()) 
        {
            throw new IllegalArgumentException("La nueva descripcion no puede estar vacia.");
        }
        if (costoEstimado <= 0) 
        {
            throw new IllegalArgumentException("El nuevo costo estimado debe ser mayor que 0.");
        }

        orden.setDescripcion(descServicio);
        orden.setCosto(costoEstimado);
    }

    //Para eliminar la orden
    public void cancelarOrden(int numeroOrden) 
    {
        Orden orden = buscarOrden(numeroOrden); //también excepcion por si no existe
        ordenes.remove(orden);
    }

    //manda todas las ordenes asociadas con la placa ingresada
    public List<Orden> consultaOrdenesPlaca(String placa) {
        List<Orden> resultado = new ArrayList<>();
        for (Orden orden : ordenes) {
            if (orden.getPlaca().equalsIgnoreCase(placa)) 
            {
                resultado.add(orden);
            }
        }
        return resultado;
    }

    //esto para la suma de los costos estimados de todas las ordenes
    public double calculoCostoTotal() {
        double total = 0.0;
        for (Orden orden : ordenes) {
            total += orden.getCosto();
        }
        return total;
    }

    //esto para el promedio de los costos estimados de todas las ordenes
    public double calculoCostoPromedio() {
        if (ordenes.isEmpty()) 
        {
            return 0.0;
        }
        return calculoCostoTotal() / ordenes.size(); //devuelde la suma total dividido tamaño (el promedio)
    }

    //recorre todo y devuelve la que tenga mayor costo
    public Orden consultaMayorCosto() {
        if (ordenes.isEmpty()) 
        {
            throw new NoSuchElementException("No hay ordenes registradas actualmente.");
        }

        Orden mayor = ordenes.get(0);

        for (Orden orden : ordenes) {
            if (orden.getCosto() > mayor.getCosto()) 
            {
                mayor = orden;
            }
        }
        return mayor;
    }

    //la cantidad de ordenes
    public int consultaCantidadOrden() {
        return ordenes.size();
    }

    //imprimir todas las ordenes
    public List<Orden> consultaOrden() {
        return ordenes;
    }

    //para cuando detecta si ya existe una orden con el número ingresado
    private boolean existeOrden(int numOrden) {
        for (Orden orden : ordenes) {
            if (orden.getNumOrden() == numOrden) 
            {
                return true;
            }
        }
        return false;
    }
}
