public interface Documentable {

    ResultadoOperacion generarDocumento(String referencia);

    ResultadoOperacion generarDocumento(String referencia, double monto);

    String getTipoDocumento();
}
