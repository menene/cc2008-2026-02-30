public class Order{
    private int orderNumber;
    private String ownerName;
    private String vehicleLicensePlate;
    private String serviceDescription;
    private double estimatedCost;

    public Order(int orderNumber, String ownerName, String vehicleLicensePlate, String serviceDescription, double estimatedCost){
        this.orderNumber = orderNumber;
        this.ownerName = ownerName;
        this.vehicleLicensePlate = vehicleLicensePlate;
        this.serviceDescription = serviceDescription;
        this.estimatedCost = estimatedCost;
    }

    public String getOwnerName(){ return this.ownerName; }
    public int getOrderNumber(){ return this.orderNumber; }
    public String getVehicleLicensePlate(){ return this.vehicleLicensePlate; }
    public String getServiceDescription(){ return this.serviceDescription; }
    public double getEstimatedCost(){ return this.estimatedCost; }
    public void setNewServiceDescription( String serviceDescription){ this.serviceDescription = serviceDescription;}
    public void setNewEstimatedCost( double estimatedCost){ this.estimatedCost = estimatedCost; }
}