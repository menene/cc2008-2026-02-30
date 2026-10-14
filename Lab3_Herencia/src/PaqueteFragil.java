/* Clase del paquete fragil. Es un paquete que ademas paga embalaje y seguro. */
public class PaqueteFragil extends Paquete {

    private double valorDeclarado;
    private static final double CARGO_EMBALAJE = 15;
    private static final double PORCENTAJE_SEGURO = 0.03;

    /* Constructor. Paquete revisa las medidas, Envio los datos comunes y aqui solo el valor declarado */
    public PaqueteFragil(String codigo, String remitente, String destinatario, double pesoReal, String tipoDestino,
            double largo, double ancho, double alto, double valorDeclarado) {
        super(codigo, remitente, destinatario, pesoReal, tipoDestino, largo, ancho, alto);

        if (valorDeclarado <= 0) {
            throw new IllegalArgumentException("El valor declarado debe ser mayor que 0");
        }

        this.valorDeclarado = valorDeclarado;
    }

    public double getValorDeclarado() {
        return valorDeclarado;
    }

    /* 3 % del valor declarado */
    public double calcularSeguro() {
        return valorDeclarado * PORCENTAJE_SEGURO;
    }

    /* El costo de un paquete normal mas Q15 de embalaje y el seguro */
    @Override
    public double calcularCosto() {
        return super.calcularCosto() + CARGO_EMBALAJE + calcularSeguro();
    }

    /* Un dia mas que un paquete normal con el mismo destino */
    @Override
    public int calcularDiasEntrega() {
        return super.calcularDiasEntrega() + 1;
    }

    @Override
    public int getMaxIntentos() {
        return 2;
    }

    @Override
    public String getCategoria() {
        return "Paquete fragil";
    }

    /* Agrega el valor declarado y el seguro a los datos del paquete */
    @Override
    public String toString() {
        return super.toString()
                + " | Valor declarado: Q" + String.format("%,.2f", valorDeclarado)
                + " | Seguro: Q" + String.format("%,.2f", calcularSeguro());
    }
}
