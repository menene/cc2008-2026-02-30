public class Escenario {

    private int codigo;
    private String nombre;
    private String ubicacion;
    private int capacidadMax;
    private boolean estado;

    public Escenario(int codigo, String nombre, String ubicacion, int capacidadMax, boolean estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        setCapacidadMax(capacidadMax);
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setCapacidadMax(int capacidadMax) {
        if (capacidadMax <= 0) {
            throw new IllegalArgumentException("La capacidad máxima debe ser mayor que cero.");
        }
        this.capacidadMax = capacidadMax;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        
        String textoEstado;

        if (estado) {
            textoEstado = "Activo";
        } 
        else {
            textoEstado = "Inactivo";
        }

        return "Código: " + codigo + "\nNombre: " + nombre + "\nUbicación: " + ubicacion 
            + "\nCapacidad máxima: " + capacidadMax + "\nEstado: " + textoEstado;
    }
}