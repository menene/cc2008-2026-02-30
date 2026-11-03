// CC2008 - Ejercicio 6: Polimorfismo via Interfaces.
// Prototipo educativo: operaciones simuladas, sin llamadas de red.
package modelo;

/** Contrato de capacidad; no obliga a implementar operaciones incompatibles. */
public interface Auditable {
    String registrarEvento(String evento);
}
