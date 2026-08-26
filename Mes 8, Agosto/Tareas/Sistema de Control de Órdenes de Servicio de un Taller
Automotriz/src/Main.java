import java.util.List;

public class Main {

    public static void main(String[] args) {

        OrdersController controller = new OrdersController();
        View view = new View(controller);

        int selection;

        do {

            selection = view.showMenu();

            switch (selection) {

                // Registrar orden
                case 1:

                    Order newOrder = view.getNewOrder();

                    controller.addOrder(newOrder);

                    view.showMessage("Orden registrada correctamente.");

                    break;


                // Consultar todas las ordenes
                case 2:

                    if (controller.getTotalRegisteredOrders() == 0) {

                        view.showMessage("No hay órdenes registradas.");

                    }
                    else {

                        view.showOrders(controller.getOrders());

                    }

                    break;


                // Buscar orden
                case 3:

                    int searchOrderNumber = view.getOrderNumber();

                    try {

                        Order order = controller.searchOrder(searchOrderNumber);

                        if (order == null) {

                            throw new IllegalArgumentException(
                                "La orden ingresada no existe."
                            );

                        }

                        view.showOrder(order);

                    }
                    catch (IllegalArgumentException e) {

                        view.showException(e);

                    }

                    break;


                // Modificar orden
                case 4:

                    int updateOrderNumber = view.getOrderNumber();

                    Order orderToUpdate =
                        controller.searchOrder(updateOrderNumber);

                    if (orderToUpdate == null) {

                        view.showMessage(
                            "Error, la orden ingresada no existe."
                        );

                    }
                    else {

                        String newServiceDescription =
                            view.getNewServiceDescription();

                        double newEstimatedCost =
                            view.getNewEstimatedOrderCost();

                        controller.updateOrder(
                            newServiceDescription,
                            newEstimatedCost,
                            updateOrderNumber
                        );

                        view.showMessage(
                            "Orden modificada correctamente."
                        );

                    }

                    break;


                // Cancelar orden
                case 5:

                    int cancelOrderNumber = view.getOrderNumber();

                    Order orderToCancel =
                        controller.searchOrder(cancelOrderNumber);

                    if (orderToCancel == null) {

                        view.showMessage(
                            "Error, la orden ingresada no existe."
                        );

                    }
                    else {

                        controller.cancelOrder(cancelOrderNumber);

                        view.showMessage(
                            "Orden cancelada correctamente."
                        );

                    }

                    break;


                // Consultar ordenes por placa
                case 6:

                    String vehicleLicensePlate =
                        view.getVehicleLicensePlate();

                    List<Order> ordersByPlate =
                        controller.searchOrdersByVehicleLicensePlate(
                            vehicleLicensePlate
                        );

                    if (ordersByPlate.isEmpty()) {

                        view.showMessage(
                            "No existen órdenes asociadas a esa placa."
                        );

                    }
                    else {

                        view.showOrders(ordersByPlate);

                    }

                    break;


                // Reporte de costos
                case 7:

                    if (controller.getTotalRegisteredOrders() == 0) {

                        view.showMessage(
                            "No hay órdenes registradas."
                        );

                    }
                    else {

                        view.showResult(
                            "Valor total de las órdenes",
                            controller.getTotalOrdersValue()
                        );

                        view.showResult(
                            "Costo promedio de las órdenes",
                            controller.getOrdersCostsAverage()
                        );

                    }

                    break;


                // Orden de mayor costo
                case 8:

                    if (controller.getTotalRegisteredOrders() == 0) {

                        view.showMessage(
                            "No hay órdenes registradas."
                        );

                    }
                    else {

                        view.showResult(
                            "Mayor costo estimado",
                            controller.getBigestEstimatedCost()
                        );

                    }

                    break;


                // Cantidad de ordenes
                case 9:

                    view.showResult(
                        "Cantidad de órdenes registradas",
                        controller.getTotalRegisteredOrders()
                    );

                    break;


                // Salir
                case 10:

                    view.showMessage("Programa finalizado.");

                    break;
            }

        } while (selection != 10);
    }
}