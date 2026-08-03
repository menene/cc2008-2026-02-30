public class Localidad {
    private int localidadNumero;
    private double precio;
    private int capacidad;
    private int disponibilidadEspacios;

    public Localidad() {
    }

    public Localidad(int localidadNumero, double precio, int capacidad, int disponibilidadEspacios) {
        this.localidadNumero = localidadNumero;
        this.precio = precio;
        this.capacidad = capacidad;
        this.disponibilidadEspacios = disponibilidadEspacios;
    }

    public int getLocalidadNumero() {
        return localidadNumero;
    }

    public void setLocalidadNumero(int localidadNumero) {
        this.localidadNumero = localidadNumero;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getDisponibilidadEspacios() {
        return disponibilidadEspacios;
    }

    public void setDisponibilidadEspacios(int disponibilidadEspacios) {
        this.disponibilidadEspacios = disponibilidadEspacios;
    }   
}
