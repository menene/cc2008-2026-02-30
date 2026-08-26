// Excepcion propia del sistema, se usa cuando algo sale mal
// con una orden (no existe, esta repetida o los datos no son validos)
public class OrdenException extends Exception {

    public OrdenException(String mensaje) {
        super(mensaje);
    }
}
