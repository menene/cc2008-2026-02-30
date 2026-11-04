import java.util.ArrayList;

public class PasarelaTarjeta extends PasarelaPago {

    private ArrayList<String> marcasAceptadas;
    private int maximoCuotas;

    //Valida al menos una marca y cuotas >= 1
    public PasarelaTarjeta(String identificador, String nombreProveedor, String urlEndpoint,
                           String versionApi, int timeoutMs, double latenciaPromedioMs,
                           EstadoConexion estado, double comisionPorcentaje,
                           ArrayList<String> marcasAceptadas, int maximoCuotas) {
        super(identificador, nombreProveedor, urlEndpoint, versionApi, timeoutMs,
                latenciaPromedioMs, estado, comisionPorcentaje);
        if (marcasAceptadas == null || marcasAceptadas.isEmpty()) {
            throw new IllegalArgumentException("La pasarela debe aceptar al menos una marca.");
        }
        if (maximoCuotas < 1) {
            throw new IllegalArgumentException("El máximo de cuotas debe ser al menos 1.");
        }
        this.marcasAceptadas = new ArrayList<>(marcasAceptadas);
        this.maximoCuotas = maximoCuotas;
    }

    // Devuelve una copia de las marcas
    public ArrayList<String> getMarcasAceptadas() {
        return new ArrayList<>(marcasAceptadas);
    }

    public int getMaximoCuotas() {
        return maximoCuotas;
    }

    //Valida las cuotas entre 1 y el máximo y luego usa el cobro normal
    public ResultadoOperacion cobrar(double monto, String referencia, int cuotas) {
        if (cuotas < 1 || cuotas > maximoCuotas) {
            return new ResultadoOperacion(getIdentificador(), "Cobro", EstadoOperacion.RECHAZADA,
                    monto, "Las cuotas deben estar entre 1 y " + maximoCuotas + ".", "");
        }
        return cobrar(monto, referencia);
    }

    @Override
    public String getTipoServicio() {
        return "Pasarela de pago - Tarjeta";
    }

    @Override
    public String describirConfiguracion() {
        return super.describirConfiguracion()
                + String.format("%nMarcas aceptadas  : %s%nMáximo de cuotas  : %d",
                        String.join(", ", marcasAceptadas), maximoCuotas);
    }
}
