public abstract class ProveedorLogistica extends IntegracionAPI implements Consultable {

    private String zonaCobertura;
    private double tarifaBase;
    private double tarifaPorKg;

    //Constructor que valida zona no vacía y tarifas > 0
    protected ProveedorLogistica(String identificador, String nombreProveedor, String urlEndpoint,
                                 String versionApi, int timeoutMs, double latenciaPromedioMs,
                                 EstadoConexion estado, String zonaCobertura, double tarifaBase,
                                 double tarifaPorKg) {
        super(identificador, nombreProveedor, urlEndpoint, versionApi, timeoutMs,
                latenciaPromedioMs, estado);
        this.zonaCobertura = validarTexto(zonaCobertura, "zona de cobertura");
        if (tarifaBase <= 0 || tarifaPorKg <= 0) {
            throw new IllegalArgumentException("Las tarifas deben ser mayores que cero.");
        }
        this.tarifaBase = tarifaBase;
        this.tarifaPorKg = tarifaPorKg;
    }

    public String getZonaCobertura() {
        return zonaCobertura;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public double getTarifaPorKg() {
        return tarifaPorKg;
    }

    @Override
    public ResultadoOperacion cotizarEnvio(double pesoKg, String destino) {
        String operacion = "Cotización de envío";
        if (!estaDisponible()) {
            return new ResultadoOperacion(getIdentificador(), operacion, EstadoOperacion.RECHAZADA,
                    "El proveedor logístico está desconectado.");
        }
        if (pesoKg <= 0) {
            return new ResultadoOperacion(getIdentificador(), operacion, EstadoOperacion.RECHAZADA,
                    "El peso debe ser mayor que cero.");
        }
        if (destino == null || destino.trim().isEmpty()) {
            return new ResultadoOperacion(getIdentificador(), operacion, EstadoOperacion.RECHAZADA,
                    "El destino no puede estar vacío.");
        }
        if (!admitePeso(pesoKg)) {
            return new ResultadoOperacion(getIdentificador(), operacion, EstadoOperacion.RECHAZADA,
                    String.format("El proveedor no acepta paquetes de %.2f kg.", pesoKg));
        }
        double recargo = calcularRecargo(pesoKg);
        double costo = tarifaBase + tarifaPorKg * pesoKg + recargo;
        return new ResultadoOperacion(getIdentificador(), operacion, EstadoOperacion.EXITOSA, costo,
                "Envío cotizado.",
                String.format("Destino: %s | Peso: %.2f kg | Recargo: Q%.2f", destino.trim(), pesoKg, recargo));
    }

    //Devuelve el estado simulado del paquete
    @Override
    public ResultadoOperacion rastrearEnvio(String codigoGuia) {
        String operacion = "Rastreo de envío";
        if (!estaDisponible()) {
            return new ResultadoOperacion(getIdentificador(), operacion, EstadoOperacion.RECHAZADA,
                    "El proveedor logístico está desconectado.");
        }
        if (codigoGuia == null || codigoGuia.trim().isEmpty()) {
            return new ResultadoOperacion(getIdentificador(), operacion, EstadoOperacion.RECHAZADA,
                    "El código de guía no puede estar vacío.");
        }
        String[] estados = {"Recibido en bodega", "En tránsito", "En ruta de entrega", "Entregado"};
        // El mismo código siempre devuelve el mismo estado.
        int indice = Math.floorMod(codigoGuia.trim().toUpperCase().hashCode(), estados.length);
        return new ResultadoOperacion(getIdentificador(), operacion, EstadoOperacion.EXITOSA, 0,
                "Paquete localizado.",
                "Guía " + codigoGuia.trim().toUpperCase() + ": " + estados[indice]);
    }

    protected boolean admitePeso(double pesoKg) {
        return true;
    }

    //Recargo propio de cada proveedor
    protected abstract double calcularRecargo(double pesoKg);

    @Override
    public String describirConfiguracion() {
        return String.format("Zona de cobertura : %s%nTarifa base       : Q%.2f%nTarifa por kg     : Q%.2f",
                zonaCobertura, tarifaBase, tarifaPorKg);
    }
}
