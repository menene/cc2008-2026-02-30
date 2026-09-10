public class Escenario {

    private String nombre_escenario;
    private String codigo_escenario;
    private String ubicacion;
    private short cap_max;
    private boolean estado;

    public Escenario(String codigo_escenario, String nombre_escenario,
                     String ubicacion, short cap_max) {

        if (cap_max <= 0) {
            throw new IllegalArgumentException(
                "La capacidad máxima debe ser mayor que 0."
            );
        }

        this.codigo_escenario = codigo_escenario;
        this.nombre_escenario = nombre_escenario;
        this.ubicacion = ubicacion;
        this.cap_max = cap_max;
        this.estado = true;
    }

    public String GetCodigo_escenario() {
        return codigo_escenario;
    }

    public String GetNombre_escenario() {
        return nombre_escenario;
    }

    public String GetUbicación() {
        return ubicacion;
    }

    public short GetCap_max() {
        return cap_max;
    }

    public boolean Getestado() {
        return estado;
    }
    
    public void Setestado(boolean estado) {
        this.estado = estado;
    }
}