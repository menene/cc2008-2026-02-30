/* Clase del sobre. Pone sus reglas de peso maximo, costo, dias e intentos. */
public class Sobre extends Envio {

    private static final double PESO_MAXIMO = 0.5;
    private static final double COSTO_URBANO = 20;
    private static final double COSTO_DEPARTAMENTAL = 35;

    /* Constructor. Los datos comunes los revisa Envio y aqui solo se revisa el peso maximo */
    public Sobre(String codigo, String remitente, String destinatario, double pesoReal, String tipoDestino) {
        super(codigo, remitente, destinatario, pesoReal, tipoDestino);

        if (getPesoReal() > PESO_MAXIMO) {
            throw new IllegalArgumentException("Un sobre no puede pesar mas de " + PESO_MAXIMO + " kg");
        }
    }

    /* Q20 si es urbano y Q35 si es departamental, sin importar el peso */
    @Override
    public double calcularCosto() {
        if (esUrbano() == true) {
            return COSTO_URBANO;
        }

        return COSTO_DEPARTAMENTAL;
    }

    /* 1 dia si es urbano y 2 si es departamental */
    @Override
    public int calcularDiasEntrega() {
        if (esUrbano() == true) {
            return 1;
        }

        return 2;
    }

    @Override
    public int getMaxIntentos() {
        return 3;
    }

    @Override
    public String getCategoria() {
        return "Sobre";
    }
}
