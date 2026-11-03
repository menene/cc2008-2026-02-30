// CC2008 - Ejercicio 6: Polimorfismo via Interfaces.
// Prototipo educativo: operaciones simuladas, sin llamadas de red.
package modelo;

/** Contrato de capacidad; no obliga a implementar operaciones incompatibles. */
public interface Transaccional {
    ResultadoOperacion cobrar(double monto, String ref);
    ResultadoOperacion reintegrar(double monto, String ref);
}
