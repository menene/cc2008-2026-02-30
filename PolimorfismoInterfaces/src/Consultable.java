public interface Consultable {

    //Calcula el costo de un envío sin cambiar nada
    ResultadoOperacion cotizarEnvio(double pesoKg, String destino);

    //Consulta el estado de un paquete
    ResultadoOperacion rastrearEnvio(String codigoGuia);
}
