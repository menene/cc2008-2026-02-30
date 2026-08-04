public class Localidad {
    private int localidad;
    private int precioLocalidad;
    private int capacidadMaxima;
    private int boletosVendidos;
    

    //vacio primero
    public Localidad() {

    }

    public Localidad(int localidad, int precioLocalidad, int capacidadMaxima, int boletosVendidos) {
        this.localidad = localidad;
        this.precioLocalidad = precioLocalidad;
        this.capacidadMaxima = capacidadMaxima;
        this.boletosVendidos = boletosVendidos;
    }

    //localidad
    public int getLocalidad() {
        return localidad;
    }

    public void setLocalidad(int localidad) {
        this.localidad = localidad;
    }

    //precioLocalidad
    public int getPrecioLocalidad() {
        return precioLocalidad;
    }

    public void setPrecioLocalidad(int precioLocalidad) {
        this.precioLocalidad = precioLocalidad;
    }

    //capacidadMaxima
    public int capacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    //boletosVendidos
    public int getBoletosVendidos() {
        return boletosVendidos;
    }

    public void setBoletosVendidos(int boletosVendidos) {
        this.boletosVendidos = boletosVendidos;
    }


    //verificar si hay espacio disponible
    public boolean hayEspacio() {
        return boletosVendidos < capacidadMaxima;
        //true si hay menos boletos vendidos que capacidad
        //sino, false
    }    


    //boletos disponibles
    public int boletosDisponibles() {
        return capacidadMaxima - boletosVendidos;
        //los restantes
    }


    

}
