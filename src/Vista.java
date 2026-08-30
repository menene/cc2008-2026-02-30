import java.util.ArrayList;
import java.util.Scanner;

public class Vista{
    private Scanner sc = new Scanner(System.in); 
        

    public int mostrarMenu() {
        System.out.println("\n======== MENÚ DEL TALLER AUTOMÓTRIZ ========");
        System.out.println("1. Registrar una nueva orden ");
        System.out.println("2. Consultar las ordenes de servicio registradas");
        System.out.println("3. Buscar orden por el número de orden");
        System.out.println("4. Modificar una orden previamente registrada");
        System.out.println("5. Cancelar orden de servicio");
        System.out.println("6. Consultar ordenes asociadas a una placa específica ");
        System.out.println("7. Consultar reporte de costos");
        System.out.println("8. Consutlar orden de mayor costo ");
        System.out.println("9. Consulta de cantidad de ordenes registradas");
        System.out.println("10. Salir"); 

        return Integer.parseInt(sc.nextLine());
    }

    public Orden leerOrden() {
        System.out.println("Número de orden: ");
        int numeroOrden = Integer.parseInt(sc.nextLine()); 
        System.out.println("Nombre del propietario");
        String nombrePropietario = sc.nextLine(); 
        System.out.println("Placa: ");
        String placaVehiculo = sc.nextLine(); 
        System.out.println("Descripción de servicio: "); 
        String infoServicio = sc.nextLine(); 
        System.out.println("Costo estimado: "); 
        double costoEstimado = Double.parseDouble(sc.nextLine()); 

        return new Orden( numeroOrden, nombrePropietario, placaVehiculo, infoServicio, costoEstimado) ;
    }

    public int leerNumeroOrden() {
        System.out.println("Número de orden: ");
         return Integer.parseInt(sc.nextLine());

    }

    public String leerPlacaVehiculo() {
        System.out.println("Placa del vehículo: ");
        return sc.nextLine(); 

    }

    public String leerNuevaInfoServicio() {
        System.out.println("Descripción del servicio: ");
        return sc.nextLine(); 

    }

    public double leerNuevoCostoEstimado() {
        System.out.println("Costo estimado: ");
        return Double.parseDouble(sc.nextLine()); 

    }

    public void mostrarOrdenes(ArrayList<Orden> ordenes ){
        System.out.println("=====ORDENES REGISTRADAS EN EL SISTEMA");
        for (Orden orden : ordenes){
            mostrarOrden(orden); 
        }
        
    }

    public void mostrarOrden(Orden orden){
        System.out.println("Número de orden: " + orden.getNumeroOrden());
        System.out.println("Propietario: " + orden.getNombrePropietario());
        System.out.println("Placa: " +orden.getPlacaVehiculo());
        System.out.println("Servicio: "+ orden.getInfoServicio());
        System.out.println("Costo estimado: " + orden.getCostoEstimado());  
    }

    public void mostrarOrdenPlaca(ArrayList<Orden> ordenes){
        System.out.println("======ORDENES ASOCIADAS A UNA MISMA PLACA=======");
        for (Orden orden : ordenes){
            mostrarOrden(orden);
        }

    }

    public void mostrarValorOrdenesActivas(double total){
        System.out.println("Total de ordenes activas: $" + total); 
    }

    public void mostrarPromedio(double promedio){
        System.out.println("Promedio de costo de las ordenes: $" + promedio); 
    }

    public void mostrarCostoMayor( Orden orden){
        System.out.println("Información de la orden con mayor costo registrada");
        mostrarOrden(orden); 

    }

    public void mostrarCantidadOrdenes (int cantidadOrdenes){
        System.out.println("La cantidad de ordenes registradas es: " + cantidadOrdenes);
    }

    public void mensaje(String texto) { 
        System.out.println(texto);

    }

    public void error(String texto) {
        System.out.println(texto);
    }


}