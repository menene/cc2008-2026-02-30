public class Localidad {
    private String numLocalidad;
    private int boletosDisponibles;
    private float precio;

    public Localidad(String numLocalidad, int boletosDisponibles, float precio) {
        this.numLocalidad = numLocalidad;
        this.boletosDisponibles = boletosDisponibles;
        this.precio = precio;
    }

    public String GetNumLocalidad() {
        return this.numLocalidad;
    }

    public int GetBoletosDisponibles() {
        return this.boletosDisponibles;
    }

    public float GetPrecio() {
        return this.precio;
    }

    public void SetBoletosDisponibles(int cantidad) {
        this.boletosDisponibles = cantidad;
    }

    public String Disponibilidad() {
        int boletosVendidos = 20 - this.GetBoletosDisponibles();
        int boletosDisponibles = this.GetBoletosDisponibles();
        String texto = "Boletos vendidos: " + boletosVendidos + "\n";
        texto += "Boletos disponibles: " + boletosDisponibles;
        return texto;
    }

    public float Ganancia() {
        float ganancia = (20 - this.GetBoletosDisponibles()) * this.GetPrecio();
        return ganancia;
    }
}