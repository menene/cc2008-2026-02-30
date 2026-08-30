public class OrdenServicio {

    private int numeroOrden;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private String descripcionServicio;
    private double costoEstimado;

    public OrdenServicio(int numeroOrden, Cliente cliente, Vehiculo vehiculo,
                          String descripcionServicio, double costoEstimado) {
        this.numeroOrden = numeroOrden;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.descripcionServicio = descripcionServicio;
        this.costoEstimado = costoEstimado;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public double getCostoEstimado() {
        return costoEstimado;
    }

    public void setCostoEstimado(double costoEstimado) {
        this.costoEstimado = costoEstimado;
    }

    public void mostrarInformacion() {
        System.out.println("----------------------------------------");
        System.out.println("Orden #" + numeroOrden);
        System.out.println("Propietario: " + cliente.getNombre());
        System.out.println("Placa: " + vehiculo.getPlaca());
        System.out.println("Servicio: " + descripcionServicio);
        System.out.println("Costo estimado: Q" + costoEstimado);
        System.out.println("----------------------------------------");
    }
}
