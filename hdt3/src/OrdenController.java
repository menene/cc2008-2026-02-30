import java.util.ArrayList;

public class OrdenController {
    ArrayList<Orden> Ordenes = new ArrayList<>();
    OrdenView Vista = new OrdenView();

    public void RegistrarOrden() {
        int numeroorden = Vista.NumerosIngreso("Numero de orden");
        String nombre = Vista.TextoIngreso("Nombre");
        String placa = Vista.TextoIngreso("Placa");
        String descripcion = Vista.TextoIngreso("Descripcion del sercivio");
        double costo = Vista.DoubleIngreso("Costo estimado po rservicio");

        Orden orden = new Orden(numeroorden, nombre, placa, descripcion, costo);
        Ordenes.add(orden);

    }

    public void ConsultarOrden() {
        for (Orden orden : Ordenes) {
            Vista.mostrarOrden(orden);
        }
    }

    public boolean Buscar(int indice) {
        try {
            Ordenes.get(indice);
            return true;
        } catch (StackOverflowError e) {
            Vista.TextoGenerico("Error; indice invalido");
            return false;
        } finally {
            Vista.TextoGenerico("Busqueda finalizada");
        }
    }

    public void BuscarOrden() {
        int indice = Vista.buscarOrdenes();
        if (Buscar(indice) == true) {
            Orden registro = Ordenes.get(indice);
            Vista.mostrarOrden(registro);
        }
    }

    public int buscarIndicePorNumero(int numeroOrden) {
        for (int i = 0; i < Ordenes.size(); i++) {
            if (Ordenes.get(i).getNumeroOrden() == numeroOrden) {
                return i;
            }
        }
        return -1;
    }

    public void ModificarOrden() {
        int busqueda = Vista.buscarOrdenes();
        int indice = buscarIndicePorNumero(busqueda);

        if (indice == -1) {
            Vista.TextoGenerico("Orden no encontrada");
            return;
        }

        try {
            Orden registro = Ordenes.get(indice);
            Vista.mostrarOrden(registro);

            Vista.TextoGenerico("===== Ingrese los nuevos datos =====");
            String nombre = Vista.TextoIngreso("Nombre Actualizado");
            String placa = Vista.TextoIngreso("Placa actualizada");
            String descripcion = Vista.TextoIngreso("Nueva Descripcion del sercivio");
            double precio = Vista.DoubleIngreso("Nuevo Costo estimado po rservicio");
            if (registro.getDescripcion().equalsIgnoreCase(descripcion) && registro.getCostoEstimado() == precio) {
                Vista.TextoGenerico("Se requieren cambios en costo y descripcion para Editar la orden");
            } else {
                registro.setNombrePropietario(nombre);
                registro.setPlacaVehiculo(placa);
                registro.setDescripcion(descripcion);
                registro.setCosto(precio);
                Vista.TextoGenerico("Editado con exito!!");
            }
            // creo que esta algo raro esto .-.
        } catch (IllegalArgumentException e) {
            Vista.TextoGenerico("Error al modificar" + e.getMessage());
        } catch (Exception e) {
            Vista.TextoGenerico("Ha ocurrido un error durante la modificacion");
        }

    }

    public void CancelarOrden() {
        int busqueda = Vista.buscarOrdenes();
        int indice = buscarIndicePorNumero(busqueda);
        Vista.TextoGenerico("===== Canmcelar orden =====");
        // se cayo el sistema :v
        if (indice == -1) {
            Vista.TextoGenerico("Orden no encontrada");
            return;
        }
        try {
            Orden registro = Ordenes.get(indice);
            Vista.mostrarOrden(registro);
            Ordenes.remove(indice);
            Vista.TextoGenerico("Registro eliminado con exito");
        } catch (IndexOutOfBoundsException e) {
            Vista.TextoGenerico("indice invalido");
        } catch (Exception e) {
            Vista.TextoGenerico("no se pudo cancelar la orden " + e.getMessage());

        }
    }

    public void BuscarPorPlaca() {
        Vista.TextoGenerico("===== Buscar por Placa =====");
        String placaBuscar = Vista.TextoIngreso("Placa a buscar");
        boolean encontrada = false;

        for (Orden registro : Ordenes) {
            if (registro.getPlacaVehiculo().equalsIgnoreCase(placaBuscar)) {
                Vista.mostrarOrden(registro);
                encontrada = true;
            }
        }

        if (!encontrada) {
            Vista.TextoGenerico("-> No se encontraron órdenes asociadas a la placa: " + placaBuscar);
        }
    }

    public void EliminarPorPlaca() {
        Vista.TextoGenerico("===== Buscar y Eliminar por Placa =====");
        String placaBuscar = Vista.TextoIngreso("Plkaca de vehiculo a eliminar");
        int coincidencias = 0;
        for (Orden registro : Ordenes) {
            if (registro.getPlacaVehiculo().equalsIgnoreCase(placaBuscar)) {
                Vista.mostrarOrden(registro);
                coincidencias++;
            }
        }

        if (coincidencias == 0) {
            Vista.TextoGenerico("No hay concidencias" + placaBuscar);
            return;
        }

        int numOrdenEliminar = Vista.NumerosIngreso("Numero de orden a cancelar");
        int indice = buscarIndicePorNumero(numOrdenEliminar);

        if (indice != -1 && Ordenes.get(indice).getPlacaVehiculo().equalsIgnoreCase(placaBuscar)) {
            Ordenes.remove(indice);
            Vista.TextoGenerico("--> ¡Orden N° " + numOrdenEliminar + " eliminada con éxito!");
        } else {
            Vista.TextoGenerico("El número de orden no existe o no corresponde a la placa ingresada.");
        }
    }

    public void ReporteCostos() {
        Vista.TextoGenerico("===== reporte =====");

        if (Ordenes.isEmpty()) {
            Vista.TextoGenerico("No hay órdenes registradas para calcular el reporte.");
            return;
        }

        double totalCostos = 0.0;
        for (Orden orden : Ordenes) {
            totalCostos += orden.getCostoEstimado();
        }

        double promedioCosto = totalCostos / Ordenes.size();

        Vista.TextoGenerico("Suma total de costos:" + totalCostos);
        Vista.TextoGenerico("Costo promedio por orden: " + promedioCosto);
    }

    public void OrdenMayorCosto() {
        Vista.TextoGenerico("===== Orden de mayor costo =====");

        if (Ordenes.isEmpty()) {
            Vista.TextoGenerico("No hay ordenes.");
            return;
        }

        Orden mayorOrden = Ordenes.get(0);

        for (int i = 1; i < Ordenes.size(); i++) {
            if (Ordenes.get(i).getCostoEstimado() > mayorOrden.getCostoEstimado()) {
                mayorOrden = Ordenes.get(i);
            }
        }

        Vista.TextoGenerico("Orden con mayor costo:");
        Vista.mostrarOrden(mayorOrden);
    }

    public void CantidadOrdenes() {
        Vista.TextoGenerico("===== Todas las ordenes =====");
        int total = Ordenes.size();
        Vista.TextoGenerico("todas las ordenes: " + total);
    }

    // nota mental me falta el menu
    public void inicio (){
        boolean continuar = true;
        int opcion=0;
        while (continuar){
            if (opcion==1){
                RegistrarOrden();
            }else if (opcion==2){
                ConsultarOrden();
            }else if (opcion ==3){
                BuscarOrden();
            }else if (opcion ==4){
                ModificarOrden();
            }else if(opcion ==5){
                CancelarOrden();
            }else if (opcion ==6){
                BuscarPorPlaca();
            }else if(opcion==7){
                ReporteCostos();
            }else if(opcion==8){
                continuar=false;
            }

        }
    }
}