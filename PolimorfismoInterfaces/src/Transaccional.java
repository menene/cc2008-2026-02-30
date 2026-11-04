public interface Transaccional {

    //Ejecuta un cobro y devuelve cómo terminó
    ResultadoOperacion cobrar(double monto, String referencia);

    //Devuelve dinero de un cobro anterior
    ResultadoOperacion reintegrar(double monto, String referencia);
}
