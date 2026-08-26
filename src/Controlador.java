
import java.util.ArrayList;

public class Controlador {
    private ArrayList<Orden> ordenes = new ArrayList<>();
    private Vista vista = new Vista(); 
    

    public void iniciar(){
        
        boolean continuar = true;

        while (continuar) {
            try {
                int opcion = vista.mostrarMenu();
                

                if (opcion ==1 ) {
                    registrarOrden();
                } else if (opcion == 2) {
                    consultarOrdenes();
                } else if (opcion == 3) {
                    busquedaOrden(); 
                } else if (opcion == 4) {
                    modificarOrden();
                } else if (opcion == 5){
                    cancelarOrden(); 
                } else if (opcion == 6){
                    consultaOrdenPlaca(); 
                } else if (opcion == 7){
                    consultaReporteCostos(); 
                } else if (opcion == 8){
                    consultarCostoMayor(); 
                } else if (opcion == 9){
                    cantidadOrdenes(); 
                } else if (opcion == 10) {
                    continuar = false;
                    
                } else {
                    vista.error("Opcion invalida. Intentalo nuevamente");
                }
            } catch (NumberFormatException e ) {
                vista.error("Se debe ingresar un numero");
            }
        }
    }

    public void registrarOrden() {
        try { 
            Orden nuevoRegistro = vista.leerOrden(); 

            for (Orden orden : ordenes ) {
                if (orden.getNumeroOrden() == nuevoRegistro.getNumeroOrden()) {
                    throw new IllegalArgumentException ("La orden ya está registrada" ); 
                }
            } 
        ordenes.add(nuevoRegistro); 
        vista.mensaje("Orden registrada"); 

        } catch (NumberFormatException e) {
            vista.error("En número de orden y costo se aceptan solo valores numericos"); 

        }catch (IllegalArgumentException e){
            vista.error("No se puede registrar");
        }
        finally {
            vista.mensaje("Finalizó el intento de registro");
        }
        
    }
    public void consultarOrdenes() {
        if (ordenes.isEmpty()){
            vista.mensaje("Sin ordenes registradas"); 
        } else{
            vista.mostrarOrdenes(ordenes);
        }
    }
    public void busquedaOrden() {
        try {
            int numeroOr = vista.leerNumeroOrden(); 
            Orden orden = buscarOrdenNumero(numeroOr); 
            vista.mostrarOrden(orden);
            
        } catch (IllegalArgumentException e) {
            vista.error("La orden no se encuentra en el sistema");
        } finally {
            vista.mensaje("Se ha finalizado la búsqueda");
        }
    }

    
    public void modificarOrden() {
        try {
            int numeroOr = vista.leerNumeroOrden(); 
            Orden orden = buscarOrdenNumero(numeroOr); 
            String servicio = vista.leerNuevaInfoServicio(); 
            double costo = vista.leerNuevoCostoEstimado(); 
            orden.setInfoServicio(servicio); 
            orden.setCostoEstimado(costo); 
            vista.mensaje("Modificación completa");

            
         } catch (NumberFormatException e) {
            vista.error("El costo debe ser numérico.");
        } catch (IllegalArgumentException e) {
            vista.error("Error en la modificacion");
        }

    }
    public void cancelarOrden() {
        try {
            int numero = vista.leerNumeroOrden();
            Orden orden = buscarOrdenNumero(numero);
            ordenes.remove(orden);
            vista.mensaje("la orden fue cancelada.");
        } catch (NumberFormatException e) {
            vista.error("El número debe ser numérico.");
        } catch (IllegalArgumentException e) {
            vista.error("No se puede cancelar");
        }
    }

    public void consultaOrdenPlaca(){
        String placa = vista.leerPlacaVehiculo();
        ArrayList<Orden> ordenCoincide = buscarOrdenPlaca(placa);



        if (ordenCoincide.isEmpty()) {
            vista.error("No hay ordenes asociadas a esa placa.");
        } else {
            vista.mostrarOrdenPlaca(ordenCoincide);
        }

    }

    public void consultaReporteCostos() {
         if (ordenes.isEmpty()) {
            vista.mensaje("No se puede calcular sin ordenes");
        
         } else {
            vista.mostrarValorOrdenesActivas(calculoTotalOrdenes());
            vista.mostrarPromedio(calculoPromedioOrdenes()); 
         }


    }

    public void consultarCostoMayor() {
        try {
            vista.mostrarCostoMayor(determinarMayorCosto()); 

        } catch (IllegalArgumentException e){
            vista.error("No se encuentra el valor");
        }

    }

    public void cantidadOrdenes(){
        vista.mostrarCantidadOrdenes(ordenes.size()); 

    }
    public void salir(){
        vista.mensaje("Gestión finalizada"); 
    }


    //Calculos 
    private Orden buscarOrdenNumero (int numeroOrden) {
        for (Orden orden: ordenes) {
            if( orden.getNumeroOrden() == numeroOrden){
                return orden; 
            }
        }
        throw new IllegalArgumentException("Orden inexistente");
    }

    private ArrayList<Orden> buscarOrdenPlaca(String placaVehiculo){
         ArrayList<Orden> ordenCoincide = new ArrayList<>();

        for (Orden orden : ordenes) {
            if (orden.getPlacaVehiculo().equalsIgnoreCase(placaVehiculo)) {
                ordenCoincide.add(orden);
            }
        } return ordenCoincide; 


    }

    private double calculoTotalOrdenes(){
        double total = 0; 

        for (Orden orden : ordenes) {
            total += orden.getCostoEstimado(); 

        }return total; 

    }
    private double calculoPromedioOrdenes(){
        if (ordenes.isEmpty()) {
            return 0; 
        }
        return calculoTotalOrdenes()/ ordenes.size();  

    }

    private Orden determinarMayorCosto() {
        if (ordenes.isEmpty()) {
            throw new IllegalArgumentException("Sin ordenes registradas");
        }
        Orden mayor = ordenes.get(0);

        for (Orden orden : ordenes) {
            if (orden.getCostoEstimado() > mayor.getCostoEstimado()) {
                mayor = orden;
            }
        }

        return mayor;
    }
}
