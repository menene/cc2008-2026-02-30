public class Escenario {

    private String codigoEsc;
    private String nombreEsc;
    private String ubicacionEsc;
    private int capacidadMaximaEsc;
    private String estadoEsc;

    public Escenario(String codigoEsc, String nombreEsc, String ubicacionEsc, int capacidadMaximaEsc, String estadoEsc) {
        if (capacidadMaximaEsc <= 0) {
            throw new IllegalArgumentException("La capacidad máxima del escenario debe ser mayor que 0");
        }
        this.codigoEsc = codigoEsc;
        this.nombreEsc = nombreEsc;
        this.ubicacionEsc = ubicacionEsc;
        this.capacidadMaximaEsc = capacidadMaximaEsc;
        this.estadoEsc = estadoEsc;
    }

//getters y setters
    public String getCodigo() {
        return codigoEsc;
    }

    public String getNombre() {
        return nombreEsc;
    }

    public String getUbicacion() {
        return ubicacionEsc;
    }

    public int getCapacidadMaxima() {
        return capacidadMaximaEsc;
    }

    public String getEstado() {
        return estadoEsc;
    }

    public void setCapacidadMaxima(int capacidadMaximaEsc) {
        if (capacidadMaximaEsc <= 0) {
            throw new IllegalArgumentException("La capacidad máxima del escenario debe ser mayor que 0");
        }
        this.capacidadMaximaEsc = capacidadMaximaEsc;
    }

    public void setEstado(String estadoEsc) {
        this.estadoEsc = estadoEsc;
    }
}
