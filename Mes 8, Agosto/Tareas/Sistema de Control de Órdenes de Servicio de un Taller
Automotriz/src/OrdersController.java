import java.util.List;
import java.util.ArrayList;
public class OrdersController{
    private List<Order> orders;
    //Se removio ordersCounter, ya que según el ejercicio el usuario ingresa el número, pero no se percató de eso.
    
    public OrdersController(){ orders = new ArrayList<>(); }
    public void addOrder(Order order){
        orders.add(order);
    }
    public Order searchOrder(int orderNumber){
        for(Order order : orders){
            if(order.getOrderNumber() == orderNumber){
                return order;
            }
        }
        return null;
    }
    public void updateOrder(String serviceDescription, double estimatedCost, int orderNumber){
        Order order = searchOrder(orderNumber);
        order.setNewEstimatedCost(estimatedCost);
        order.setNewServiceDescription(serviceDescription);
    }
    public void cancelOrder(int orderNumber){
        orders.remove(searchOrder(orderNumber));
    }
    public List<Order> searchOrdersByVehicleLicensePlate(String vehicleLicensePlate){
        List<Order> result = new ArrayList<>();
        for(Order order : orders){
            if(order.getVehicleLicensePlate().equals(vehicleLicensePlate)){
                result.add(order);
            }
        }
        return result;
    }
    public double getBigestEstimatedCost(){
        double n = orders.get(0).getEstimatedCost();
        for(Order order : orders){
            if(order.getEstimatedCost()> n){
                n = order.getEstimatedCost();
            }
        }
        return n;
    }
    public double getOrdersCostsAverage(){
        return getTotalOrdersValue() / orders.size();
    }
    public int getTotalRegisteredOrders(){
        return orders.size();
    }
    public double getTotalOrdersValue(){
        double n = 0;
        for(Order order : orders){
            n+=order.getEstimatedCost();
        }
        return n;
    }
    // Probablemente se olvido agregar en el análisis inicial, pero necesario por el mismo análisis
    public List<Order> getOrders(){
        return orders;
    }
}