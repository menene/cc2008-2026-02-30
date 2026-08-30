public class OrdenServicio {
    private int numOrden;
    private String propietario;
    private String placa;
    private String descripcion;
    private double costo;

    public OrdenServicio(int numOrden, String propietario, String placa, String descripcion, double costo) {
        this.numOrden = numOrden;
        this.propietario = propietario;
        this.placa = placa;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public int GetNumOrden() {
        return this.numOrden;
    }

    public String GetPropietario() {
        return this.propietario;
    }

    public String GetPlaca() {
        return this.placa;
    }

    public String GetDescripcion() {
        return this.descripcion;
    }

    public double GetCosto() {
        return this.costo;
    }

    public void SetDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void SetCosto(double costo) {
        this.costo = costo;
    }
}