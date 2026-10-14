/* Clase de la carga refrigerada. Guarda la temperatura y pide un vehiculo refrigerado. */
public class CargaRefrigerada extends Envio {

    private double temperaturaRequerida;
    private static final double TEMPERATURA_MINIMA = -25;
    private static final double TEMPERATURA_MAXIMA = 8;
    private static final double PRECIO_POR_KG = 12;
    private static final double CARGO_CADENA_FRIO = 60;

    /* Constructor. Envio revisa los datos comunes y aqui se revisa la temperatura y que el destino sea urbano */
    public CargaRefrigerada(String codigo, String remitente, String destinatario, double pesoReal, String tipoDestino,
            double temperaturaRequerida) {
        super(codigo, remitente, destinatario, pesoReal, tipoDestino);

        if (temperaturaRequerida < TEMPERATURA_MINIMA || temperaturaRequerida > TEMPERATURA_MAXIMA) {
            throw new IllegalArgumentException("La temperatura debe estar entre " + TEMPERATURA_MINIMA + " y " + TEMPERATURA_MAXIMA + " grados");
        }

        if (esUrbano() == false) {
            throw new IllegalArgumentException("Solo se aceptan cargas refrigeradas con destino urbano");
        }

        this.temperaturaRequerida = temperaturaRequerida;
    }

    public double getTemperaturaRequerida() {
        return temperaturaRequerida;
    }

    /* Tarifa base mas Q12 por kilogramo de peso real y Q60 por la cadena de frio */
    @Override
    public double calcularCosto() {
        return getTarifaBase() + PRECIO_POR_KG * getPesoReal() + CARGO_CADENA_FRIO;
    }

    /* Siempre 1 dia */
    @Override
    public int calcularDiasEntrega() {
        return 1;
    }

    /* Un solo intento porque despues la cadena de frio ya se rompio */
    @Override
    public int getMaxIntentos() {
        return 1;
    }

    /* Esta carga solo puede ir en un vehiculo refrigerado */
    @Override
    public boolean requiereRefrigeracion() {
        return true;
    }

    @Override
    public String getCategoria() {
        return "Carga refrigerada";
    }

    /* Agrega la temperatura a los datos comunes */
    @Override
    public String toString() {
        return super.toString() + " | Temperatura: " + temperaturaRequerida + " C";
    }
}
