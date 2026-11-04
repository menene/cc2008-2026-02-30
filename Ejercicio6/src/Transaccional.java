import java.math.BigDecimal;

// Permite cobrar y reintegrar.
public interface Transaccional {
    ResultadoOperacion cobrar(BigDecimal monto);

    ResultadoOperacion reintegrar(BigDecimal monto);
}
