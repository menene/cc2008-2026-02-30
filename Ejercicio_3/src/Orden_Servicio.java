public class Orden_Servicio {

    private double num_orden;
    private String nombre_propietario;
    private String placa_vehiculo;
    private String descripcion;
    private double costo;

    public Orden_Servicio(double num_orden, String nombre_propietario,
            String placa_vehiculo, String descripcion, double costo) {
        this.num_orden = num_orden;
        this.nombre_propietario = nombre_propietario;
        this.placa_vehiculo = placa_vehiculo;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public double getNum_Orden() {
        return num_orden;
    }

    public String getNombre() {
        return nombre_propietario;
    }

    public String getPlaca() {
        return placa_vehiculo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setNombre(String nombre) {
        this.nombre_propietario = nombre;
    }

    public void setPlaca(String placa) {
        this.placa_vehiculo = placa;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}