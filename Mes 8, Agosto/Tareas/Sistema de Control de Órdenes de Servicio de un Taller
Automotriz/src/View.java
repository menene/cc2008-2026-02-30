import java.util.Scanner;
import java.util.List;
import java.util.InputMismatchException;

public class View{
    // Se agregó el atributo de la instancia controller y escaner que probablemente por 
    // cansancio se olvidó plantearlo en el análisis.
    private OrdersController controller;
    private Scanner sc;

    public View(OrdersController controller){
        this.controller = controller;
        this.sc = new Scanner(System.in);
    }

    public Order getNewOrder(){
        int orderNumber;
        String ownerName;
        String vehicleLicensePlate;
        String serviceDescription;
        double estimatedCost;

        while(true){
            System.out.print("Ingrese el número de orden: ");

            try{
                orderNumber = sc.nextInt();

                if(controller.searchOrder(orderNumber)==null){
                    break;
                }
                else{
                    System.out.println("Error, el número de orden ya se encuentra existente, por favor ingrese otro");
                }
            }
            catch(InputMismatchException e){
                showException(e);
            }
            finally{
                sc.nextLine();
            }
        }

        while (true){
            System.out.print("Ingrese el nombre del dueño: ");
            ownerName = sc.nextLine();

            if(!ownerName.isEmpty()){
                break;
            }

            System.out.println("Error, el nombre no puede estar vacío");
        }

        while(true){
            System.out.print("Ingrese la placa del vehículo: ");
            vehicleLicensePlate = sc.nextLine();

            if(!vehicleLicensePlate.isEmpty()){
                break;
            }

            System.out.println("Error, la placa no puede estar vacía");
        }

        while(true){
            System.out.print("Ingrese la descripción del servicio: ");
            serviceDescription = sc.nextLine();

            if(!serviceDescription.isEmpty()){
                break;
            }

            System.out.println("Error, la descripción no puede estar vacía");
        }

        while(true){
            System.out.print("Ingrese el costo estimado: ");

            try{
                estimatedCost = sc.nextDouble();

                if(estimatedCost > 0){
                    break;
                }
                else{
                    System.out.println("Error el costo no puede ser cero o menor que cero");
                }
            }
            catch(InputMismatchException e){
                showException(e);
            }
            finally{
                sc.nextLine();
            }
        }

        Order order = new Order(
            orderNumber,
            ownerName,
            vehicleLicensePlate,
            serviceDescription,
            estimatedCost
        );

        return order;
    }

    public int getOrderNumber(){
        int orderNumber;

        while(true){
            System.out.print("Ingrese el número de orden: ");

            try{
                orderNumber = sc.nextInt();
                return orderNumber;
            }
            catch(InputMismatchException e){
                showException(e);
            }
            finally{
                sc.nextLine();
            }
        }
    }

    public double getNewEstimatedOrderCost(){
        double estimatedCost;

        while(true){
            System.out.print("Ingrese el nuevo costo estimado: ");

            try{
                estimatedCost = sc.nextDouble();

                if(estimatedCost > 0){
                    return estimatedCost;
                }
                else{
                    System.out.println("Error el costo no puede ser cero o menor que cero");
                }
            }
            catch(InputMismatchException e){
                showException(e);
            }
            finally{
                sc.nextLine();
            }
        }
    }

    public String getNewServiceDescription(){
        String serviceDescription;

        while(true){
            System.out.print("Ingrese la nueva descripción del servicio: ");
            serviceDescription = sc.nextLine();

            if(!serviceDescription.isEmpty()){
                return serviceDescription;
            }

            System.out.println("Error, la descripción no puede estar vacía");
        }
    }

    public String getVehicleLicensePlate(){
        String vehicleLicensePlate;

        while(true){
            System.out.print("Ingrese la placa del vehículo: ");
            vehicleLicensePlate = sc.nextLine();

            if(!vehicleLicensePlate.isEmpty()){
                return vehicleLicensePlate;
            }

            System.out.println("Error, la placa no puede estar vacía");
        }
    }

    // se optó por darle este enfoque para darle más utilidad a la función en vez de solo hacer otro print más
    public void showException(Exception e) {

        if (e instanceof InputMismatchException) {
            System.out.println("Error: debe ingresar un número.");

        } else if (e instanceof IllegalArgumentException) {
            System.out.println("Error: " + e.getMessage());

        } else if (e instanceof IndexOutOfBoundsException) {
            System.out.println("Error: posición inexistente.");

        } else {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    public int showMenu(){
        System.out.println("1. Registrar orden");
        System.out.println("2. Consultar órdenes");
        System.out.println("3. Buscar orden");
        System.out.println("4. Modificar orden");
        System.out.println("5. Cancelar orden");
        System.out.println("6. Consultar órdenes por placa");
        System.out.println("7. Reporte de costos");
        System.out.println("8. Orden de mayor costo");
        System.out.println("9. Cantidad de órdenes");
        System.out.println("10. Salir");

        int selection;

        while(true){
            System.out.print("Ingrese su selección: ");

            try{
                selection = sc.nextInt();

                if(selection >= 1 && selection <= 10){
                    return selection;
                }

                System.out.println("Error, seleccione una opción entre 1 y 10");
            }
            catch(InputMismatchException e){
                showException(e);
            }
            finally{
                sc.nextLine();
            }
        }
    }

    public void showResult(String message, double value){
        System.out.println(message+": "+value);
    }

    public void showOrders(List<Order> orders){
        System.out.println("========== Ordenes ==========");

        for(Order order : orders){
            showOrder(order);
        }
    }

    public void showOrder(Order order){
        System.out.println("========== Orden ==========");
        System.out.println("No. de orden: " + order.getOrderNumber());
        System.out.println("Nombre del dueño: " + order.getOwnerName());
        System.out.println("Placa del vehículo: " + order.getVehicleLicensePlate());
        System.out.println("Descripción del servicio: " + order.getServiceDescription());
        System.out.println("Costo estimado: " + order.getEstimatedCost());
        System.out.println("===========================");
    }

    public void showMessage(String message){
        System.out.println(message);
    }
}