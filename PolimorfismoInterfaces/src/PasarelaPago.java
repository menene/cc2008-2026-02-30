import java.util.ArrayList;

public abstract class PasarelaPago extends IntegracionAPI implements Transaccional, Auditable {

    private double comisionPorcentaje;
    private double totalProcesado;
    private ArrayList<String> bitacora;

    //Llama a super y valida la comisión entre 0 y 100
    protected PasarelaPago(String identificador, String nombreProveedor, String urlEndpoint,
                           String versionApi, int timeoutMs, double latenciaPromedioMs,
                           EstadoConexion estado, double comisionPorcentaje) {
        super(identificador, nombreProveedor, urlEndpoint, versionApi, timeoutMs,
                latenciaPromedioMs, estado);
        if (comisionPorcentaje < 0 || comisionPorcentaje > 100) {
            throw new IllegalArgumentException("La comisión debe estar entre 0 y 100.");
        }
        this.comisionPorcentaje = comisionPorcentaje;
        this.totalProcesado = 0;
        this.bitacora = new ArrayList<>();
    }

    public double getComisionPorcentaje() {
        return comisionPorcentaje;
    }

    public double getTotalProcesado() {
        return totalProcesado;
    }

    // Devuelve monto x comisionPorcentaje / 100
    public double calcularComision(double monto) {
        return monto * comisionPorcentaje / 100;
    }

    @Override
    public ResultadoOperacion cobrar(double monto, String referencia) {
        String operacion = "Cobro";
        if (!estaDisponible()) {
            return new ResultadoOperacion(getIdentificador(), operacion, EstadoOperacion.RECHAZADA,
                    monto, "La pasarela está desconectada.", "");
        }
        if (monto <= 0) {
            return new ResultadoOperacion(getIdentificador(), operacion, EstadoOperacion.RECHAZADA,
                    monto, "El monto debe ser mayor que cero.", "");
        }
        String motivo = motivoRechazoCobro(monto);
        if (!motivo.isEmpty()) {
            return new ResultadoOperacion(getIdentificador(), operacion, EstadoOperacion.RECHAZADA,
                    monto, motivo, "");
        }
        double comision = calcularComision(monto);
        totalProcesado += monto;
        registrarEvento(String.format("COBRO     %s | Q%.2f | comisión Q%.2f",
                referencia, monto, comision));
        return new ResultadoOperacion(getIdentificador(), operacion, EstadoOperacion.EXITOSA, monto,
                String.format("Cobro aprobado. Comisión retenida: Q%.2f", comision),
                "Referencia: " + referencia);
    }

    @Override
    public ResultadoOperacion reintegrar(double monto, String referencia) {
        String operacion = "Reintegro";
        if (!estaDisponible()) {
            return new ResultadoOperacion(getIdentificador(), operacion, EstadoOperacion.RECHAZADA,
                    monto, "La pasarela está desconectada.", "");
        }
        if (monto <= 0) {
            return new ResultadoOperacion(getIdentificador(), operacion, EstadoOperacion.RECHAZADA,
                    monto, "El monto debe ser mayor que cero.", "");
        }
        if (monto > totalProcesado) {
            return new ResultadoOperacion(getIdentificador(), operacion, EstadoOperacion.RECHAZADA,
                    monto, String.format("El reintegro supera lo procesado (Q%.2f).", totalProcesado), "");
        }
        totalProcesado -= monto;
        registrarEvento(String.format("REINTEGRO %s | Q%.2f", referencia, monto));
        return new ResultadoOperacion(getIdentificador(), operacion, EstadoOperacion.EXITOSA, monto,
                "Reintegro aplicado.", "Referencia: " + referencia);
    }

    //Regla propia de cada pasarela; devuelve "" si no hay problema
    protected String motivoRechazoCobro(double monto) {
        return "";
    }

    @Override
    public void registrarEvento(String evento) {
        bitacora.add(evento);
    }

    // Devuelve una copia para que nadie modifique la bitácora desde afuera
    @Override
    public ArrayList<String> getBitacora() {
        return new ArrayList<>(bitacora);
    }

    @Override
    public String describirConfiguracion() {
        return String.format("Comisión          : %.2f %%%nTotal procesado   : Q%.2f",
                comisionPorcentaje, totalProcesado);
    }
}
