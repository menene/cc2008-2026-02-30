public class Comprador {

    private String nombre;
    private String email;
    private byte cantidad_Boletos;
    private short presupuesto;

    public Comprador(String nombre, String email, byte cantidad_Boletos, short presupuesto) {

        this.nombre = nombre;
        this.email = email;
        this.cantidad_Boletos = cantidad_Boletos;
        this.presupuesto = presupuesto;

    }

    public String getNombre() {

        return nombre;

    }

    public String getEmail() {

        return email;

    }

    public byte getCantidad_Boletos() {

        return cantidad_Boletos;

    }

    public short getPresupuesto() {

        return presupuesto;

    }

}