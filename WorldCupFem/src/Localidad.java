public class Localidad {

    private String localidad;
    private int boletosDisponibles, precio;

    public Localidad(String localidad, int precio) {

        this.localidad = localidad;
        this.precio = precio;
        this.boletosDisponibles = 20;

    }

    public String getLocalidad() {
        return localidad;
    }

    public int getPrecio() {
        return precio;
    }

    public int getBoletosDisponibles() {
        return boletosDisponibles;
    }

    public boolean venderBoletos(int cantidad) {

        if (cantidad <= boletosDisponibles) {
            boletosDisponibles -= cantidad;
            return true;
        }else{
            return false;
        }
    }

    public int getBoletosVendidos() {
        return 20 - boletosDisponibles;
    }
}