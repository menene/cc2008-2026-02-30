public  class Orden {
    private int numeroOrden;
    private String nombrePropietario; 
    private String placaVehiculo;
    private String descripcionServicio;
    private double costoEstimado; 

    public Orden (int numorden,String nombre, String placVehiculo, String desc, double costo){
        if (costo < 0 || nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El costo no puede ser negativo y el nombre no puede estar vacío.");
        }
        this.numeroOrden=numorden;
        this.nombrePropietario=nombre;
        this.placaVehiculo=placVehiculo;
        this.descripcionServicio=desc;
        this.costoEstimado=costo;
    }

    public int getNumeroOrden (){
        return numeroOrden;
    }
    public String getNombrePropietario(){
        return nombrePropietario;
    }
    public String getPlacaVehiculo(){
        return placaVehiculo;
    }
    public String getDescripcion(){
        return descripcionServicio;
    }
    public double getCostoEstimado(){
        return costoEstimado; 
    }

    public void setNumeroOrden(int numero){
        this.numeroOrden=numero;
    }
    public void setNombrePropietario(String nombre){
        this.nombrePropietario= nombre;
    }
    public void setPlacaVehiculo(String placa){
        this.placaVehiculo=placa;
    }
    public void setDescripcion(String desc){
        this.descripcionServicio=desc;
    }
    public void setCosto(double costo){
        this.costoEstimado=costo;
    }

    public void mostrarResumen() {
        System.out.println("Orden: " + numeroOrden + " Propietario: " + nombrePropietario + " placa: " + placaVehiculo + " Desc: " + descripcionServicio + "costo: $" + costoEstimado);
    }
}
