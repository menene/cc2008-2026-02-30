 import java.util.ArrayList;
 public class Sistema_Ordenes{
    private Ordenes ordenes;
    private Vista vista;
    public Sistema_Ordenes(){
        vista = new Vista();
        ordenes = new Ordenes();
    }
    public void iniciar() {
        int opcion = 0;
        while (opcion != 10) {
            try {
                opcion = vista.Mostrar_Menu();
                if (opcion == 1) {
                    if (RegistrarOrden(vista.PedirNumeroOrden(), vista.PedirNombre(), vista.PedirPlaca(), vista.PedirDescripcion(), vista.PedirCosto())) {
                        vista.MostrarMensaje("Orden registrada correctamente");
                    }
                } else if (opcion == 2) {
                    vista.MostrarOrdenes(ConsultarOrdenes());
                } else if (opcion == 3) {
                    try {
                        vista.MostrarOrden(BuscarOrden(vista.PedirNumeroOrden()));
                    } finally {
                        vista.MostrarMensaje("El proceso de búsqueda ha finalizado");
                    }
                } else if (opcion == 4) {
                    double numorden = vista.PedirNumeroOrden();
                    int opcion2 = vista.MostrarMenuModificar();
                    if (opcion2 == 1) {
                        ModificarNombre(numorden, vista.PedirNombre());
                    } else if (opcion2 == 2) {
                        ModificarPlaca(numorden, vista.PedirPlaca());
                    } else if (opcion2 == 3) {
                        ModificarDescripcion(numorden, vista.PedirDescripcion());
                    } else if (opcion2 == 4) {
                        ModificarCosto(numorden, vista.PedirCosto());
                    } else {
                        vista.MostrarMensaje("Opción inválida");
                    }
                } else if (opcion == 5) {
                    if (CancelarOrden(vista.PedirNumeroOrden())) {
                        vista.MostrarMensaje("Orden cancelada correctamente");
                    }
                } else if (opcion == 6) {
                    vista.MostrarOrdenes(BusquedaPorPlaca(vista.PedirPlaca()));
                } else if (opcion == 7) {
                    vista.MostrarCostoTotal(CostoTotal());
                    vista.MostrarCostoPromedio(CostoPromedio());
                } else if (opcion == 8) {
                    Orden_Servicio ordenMax = CostoMax();
                    if (ordenMax != null) {
                        vista.MostrarOrden(ordenMax);
                    } else {
                        vista.MostrarMensaje("No hay órdenes registradas");
                    }
                } else if (opcion == 9) {
                    vista.MostrarMensaje("Cantidad de órdenes: " + CantidadOrdenes());
                } else if (opcion == 10) {
                    vista.MostrarMensaje("Saliendo del sistema..");
                } else {
                    vista.MostrarMensaje("Opción inválida");
                }
            } catch (java.util.InputMismatchException e) {
                vista.MostrarMensaje("Debe ingresar un valor numérico");
                vista.LimpiarScanner();
            } catch (IllegalArgumentException e) {
                vista.MostrarMensaje(e.getMessage());
            }
        }
    }
    public boolean RegistrarOrden(double numero_orden, String nombre, String placa, String descripcion, double costo){
        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (placa.isEmpty()) {
            throw new IllegalArgumentException("La placa no puede estar vacía");
        }

        if (descripcion.isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía");
        }

        if (costo <= 0) {
            throw new IllegalArgumentException("El costo debe ser mayor que 0");
        }

        for (Orden_Servicio orden : ordenes.getOrdenes()) {
            if (orden.getNum_Orden() == numero_orden) {
                throw new IllegalArgumentException("El número de orden ya está registrado");
            }
        }
        Orden_Servicio nueva_orden = new Orden_Servicio(numero_orden, nombre, placa, descripcion, costo);
        ordenes.getOrdenes().add(nueva_orden);
        return true;
    }
    public ArrayList<Orden_Servicio> ConsultarOrdenes() {
        ArrayList<Orden_Servicio> listaOrdenes = ordenes.getOrdenes();
        return listaOrdenes;
    }
    public Orden_Servicio BuscarOrden(double numOrden) {
        for (Orden_Servicio orden : ordenes.getOrdenes()) {
            if (orden.getNum_Orden() == numOrden) {
                return orden;
            }
        }
        throw new IllegalArgumentException("No se encontró una orden con el número: " + numOrden);
    }
    public boolean ModificarDescripcion(double numOrden, String descripcion) {
        if (descripcion.isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía");
        }
        Orden_Servicio orden = BuscarOrden(numOrden);
        orden.setDescripcion(descripcion);
        return true;
    }
    public boolean ModificarNombre(double numOrden, String nombre) {
        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        Orden_Servicio orden = BuscarOrden(numOrden);
        orden.setNombre(nombre);
        return true;
    }
    public boolean ModificarPlaca(double numOrden, String placa) {
        if (placa.isEmpty()) {
            throw new IllegalArgumentException("La placa no puede estar vacía");
        }
        Orden_Servicio orden = BuscarOrden(numOrden);
        orden.setPlaca(placa);
        return true;
    }
    public boolean ModificarCosto(double numOrden, double costo) {
        if (costo <= 0) {
            throw new IllegalArgumentException(
                "El costo debe ser mayor que 0"
            );
        }
        Orden_Servicio orden = BuscarOrden(numOrden);
        orden.setCosto(costo);
        return true;
    }
    public boolean CancelarOrden(double numOrden) {
        Orden_Servicio orden = BuscarOrden(numOrden);
        ordenes.getOrdenes().remove(orden);
        return true;
    }
    public double CostoTotal() {
        double total = 0;
        for (Orden_Servicio orden : ordenes.getOrdenes()) {
            total += orden.getCosto();
        }
        return total;
    }
    public double CostoPromedio() {
        if (ordenes.getOrdenes().isEmpty()) {
            return 0;
        }
        double total = CostoTotal();
        double promedio = total / ordenes.getOrdenes().size();
        return promedio;
    }
    public Orden_Servicio CostoMax() {
        if (ordenes.getOrdenes().isEmpty()) {
            return null;
        }
        Orden_Servicio ordenMax = ordenes.getOrdenes().get(0);
        for (Orden_Servicio orden : ordenes.getOrdenes()) {
            if (orden.getCosto() > ordenMax.getCosto()) {
                ordenMax = orden;
            }
        }
        return ordenMax;
    }
    public int CantidadOrdenes() {
        int cantidad = ordenes.getOrdenes().size();
        return cantidad;
    }
    public ArrayList<Orden_Servicio> BusquedaPorPlaca(String placa) {
        ArrayList<Orden_Servicio> coincidencias = new ArrayList<Orden_Servicio>();
        for (Orden_Servicio orden : ordenes.getOrdenes()) {
            if (orden.getPlaca().equalsIgnoreCase(placa)) {
                coincidencias.add(orden);
            }
        }
        return coincidencias;
    }
}