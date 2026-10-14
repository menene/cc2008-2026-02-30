/* Clase del paquete. Guarda las medidas y calcula el peso volumetrico y el facturable. */
public class Paquete extends Envio {

    private double largo;
    private double ancho;
    private double alto;
    private static final double PRECIO_POR_KG = 8;
    private static final double FACTOR_VOLUMETRICO = 5000;

    /* Constructor. Los datos comunes los revisa Envio y aqui se revisan las medidas */
    public Paquete(String codigo, String remitente, String destinatario, double pesoReal, String tipoDestino,
            double largo, double ancho, double alto) {
        super(codigo, remitente, destinatario, pesoReal, tipoDestino);

        if (largo <= 0 || ancho <= 0 || alto <= 0) {
            throw new IllegalArgumentException("El largo, el ancho y el alto deben ser mayores que 0");
        }

        this.largo = largo;
        this.ancho = ancho;
        this.alto = alto;
    }

    public double getLargo() {
        return largo;
    }

    public double getAncho() {
        return ancho;
    }

    public double getAlto() {
        return alto;
    }

    /* largo x ancho x alto / 5000 */
    public double calcularPesoVolumetrico() {
        return largo * ancho * alto / FACTOR_VOLUMETRICO;
    }

    /* El mayor entre el peso real y el volumetrico, redondeado hacia arriba porque se cobra por kg o fraccion */
    public int calcularPesoFacturable() {
        double mayor = Math.max(getPesoReal(), calcularPesoVolumetrico());

        return (int) Math.ceil(mayor);
    }

    /* Tarifa base segun el destino mas Q8 por cada kilogramo facturable */
    @Override
    public double calcularCosto() {
        return getTarifaBase() + PRECIO_POR_KG * calcularPesoFacturable();
    }

    /* 2 dias si es urbano y 4 si es departamental */
    @Override
    public int calcularDiasEntrega() {
        if (esUrbano() == true) {
            return 2;
        }

        return 4;
    }

    @Override
    public int getMaxIntentos() {
        return 3;
    }

    @Override
    public String getCategoria() {
        return "Paquete";
    }

    /* Agrega las medidas y los pesos a los datos comunes */
    @Override
    public String toString() {
        return super.toString()
                + " | Medidas: " + largo + " x " + ancho + " x " + alto + " cm"
                + " | Peso volumetrico: " + String.format("%.2f", calcularPesoVolumetrico()) + " kg"
                + " | Peso facturable: " + calcularPesoFacturable() + " kg";
    }
}
