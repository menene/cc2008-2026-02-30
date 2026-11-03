// CC2008 - Ejercicio 6: Polimorfismo via Interfaces.
// Prototipo educativo: operaciones simuladas, sin llamadas de red.
package modelo;


import java.util.Objects;

/** Respuesta inmutable que el modelo entrega sin imprimir en consola. */
public class ResultadoOperacion {
    private final EstadoResultado estado;
    private final String mensaje;
    private final String referencia;

    public ResultadoOperacion(EstadoResultado estado, String mensaje, String referencia) {
        this.estado = Objects.requireNonNull(estado, "El estado es obligatorio.");
        this.mensaje = Objects.requireNonNull(mensaje, "El mensaje es obligatorio.");
        this.referencia = referencia == null ? "" : referencia;
    }
    public EstadoResultado getEstado() { return estado; }
    public String getMensaje() { return mensaje; }
    public String getReferencia() { return referencia; }
    @Override
    public String toString() {
        return estado + " | " + mensaje + " | Referencia: " + referencia;
    }
}
