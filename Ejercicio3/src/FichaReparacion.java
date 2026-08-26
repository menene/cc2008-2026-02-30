public class FichaReparacion {
    private int idOrden;
    private String cliente;
    private String matricula;
    private String detalleTrabajo;
    private double precioCalculado;

    public FichaReparacion(int idOrden, String cliente, String matricula, String detalleTrabajo, double precioCalculado) {
        this.idOrden = idOrden;
        this.cliente = cliente;
        this.matricula = matricula;
        this.detalleTrabajo = detalleTrabajo;
        this.precioCalculado = precioCalculado;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getPrecioCalculado() {
        return precioCalculado;
    }

    public void actualizarDetalle(String nuevoDetalle) {
        this.detalleTrabajo = nuevoDetalle;
    }

    public void actualizarPrecio(double nuevoPrecio) {
        this.precioCalculado = nuevoPrecio;
    }

    @Override
    public String toString() {
        return "ID: " + idOrden + " | Cliente: " + cliente + 
               " | Placa: " + matricula + " | Trabajo: " + detalleTrabajo + 
               " | Total: Q" + precioCalculado;
    }
}