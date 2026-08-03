public class Cliente {
    private String nombre;
    private String email;
    private int boletosComprar;
    private float presupuesto;

    public Cliente(String nombre, String email, int boletosComprar, float presupuesto) {
        this.nombre = nombre;
        this.email = email;
        this.boletosComprar = boletosComprar;
        this.presupuesto = presupuesto;

    }

    public int GetBoletosComprar() {
        return this.boletosComprar;
    }

    public float GetPresupuesto() {
        return this.presupuesto;
    }

    public void SetBoletosComprar(int cantidad) {
        this.boletosComprar = cantidad;
    }

    public void SetPresupuesto(float cantidad) {
        this.presupuesto = cantidad;
    }
}