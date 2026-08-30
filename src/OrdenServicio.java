public class OrdenServicio {
    //atributos
    private int numeroOrden;
    private String propietario;
    private String placa;
    private String descripcion;
    private double costoEstimado;

    //constructor que recibe los datos iniciales de la orden de servicio
    public OrdenServicio(int numero, String prop, String placa, String desc, double costo) {
        this.numeroOrden = numero;
        this.propietario = prop;
        this.placa = placa;
        this.descripcion = desc;
        this.costoEstimado = costo;
    }

    //devuelve el numero que identifica la orden
    public int getNumeroOrden() {
        return numeroOrden;
    }

    //devuelve la placa del vehiculo asociado a la orden
    public String getPlaca() {
        return placa;
    }

    //devuelve el costo estimado del servicio
    public double getCostoEstimado() {
        return costoEstimado;
    }

    //reemplaza la descripcion actual del servicio
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //reemplaza el costo estimado actual del servicio
    public void setCostoEstimado(double costo) {
        this.costoEstimado = costo;
    }

    //devuelve todos los datos de la orden en un solo texto
    public String toString() {
        return "Numero de orden: " + numeroOrden
                + "\nPropietario: " + propietario
                + "\nPlaca: " + placa
                + "\nDescripcion: " + descripcion
                + "\nCosto estimado: Q" + costoEstimado;
    }
}
