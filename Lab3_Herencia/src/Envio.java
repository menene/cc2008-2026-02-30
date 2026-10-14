/* Clase abstracta del envio. Guarda los datos comunes, controla el estado, los intentos y los cobros. */
public abstract class Envio {

    public static final String EN_BODEGA = "En bodega";
    public static final String ASIGNADO = "Asignado";
    public static final String EN_RUTA = "En ruta";
    public static final String ENTREGADO = "Entregado";
    public static final String DEVUELTO = "Devuelto al remitente";

    private String codigo;
    private String remitente;
    private String destinatario;
    private double pesoReal;
    private String tipoDestino;
    private String estado;
    private int intentos;
    private double montoRegistro;
    private double cargosReintento;
    private static final double CARGO_REINTENTO = 15;
    protected static final double TARIFA_BASE_URBANA = 25;
    protected static final double TARIFA_BASE_DEPARTAMENTAL = 40;

    /* Constructor. Revisa los datos comunes. Todo envio nuevo empieza en bodega, con 0 intentos y sin cobros */
    protected Envio(String codigo, String remitente, String destinatario, double pesoReal, String tipoDestino) {
        if (codigo == null || codigo.trim().length() == 0) {
            throw new IllegalArgumentException("El codigo no puede quedar vacio");
        }

        if (remitente == null || remitente.trim().length() == 0) {
            throw new IllegalArgumentException("El remitente no puede quedar vacio");
        }

        if (destinatario == null || destinatario.trim().length() == 0) {
            throw new IllegalArgumentException("El destinatario no puede quedar vacio");
        }

        if (pesoReal <= 0) {
            throw new IllegalArgumentException("El peso real debe ser mayor que 0");
        }

        if (tipoDestino == null) {
            throw new IllegalArgumentException("El tipo de destino no puede quedar vacio");
        }

        String destino = tipoDestino.trim().toLowerCase();

        if (destino.equals("urbano") == false && destino.equals("departamental") == false) {
            throw new IllegalArgumentException("El tipo de destino debe ser urbano o departamental");
        }

        this.codigo = codigo.trim().toUpperCase();
        this.remitente = remitente.trim();
        this.destinatario = destinatario.trim();
        this.pesoReal = pesoReal;
        this.tipoDestino = destino;
        this.estado = EN_BODEGA;
        this.intentos = 0;
        this.montoRegistro = 0;
        this.cargosReintento = 0;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getRemitente() {
        return remitente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public double getPesoReal() {
        return pesoReal;
    }

    public String getTipoDestino() {
        return tipoDestino;
    }

    public String getEstado() {
        return estado;
    }

    public int getIntentos() {
        return intentos;
    }

    public double getMontoRegistro() {
        return montoRegistro;
    }

    public double getCargosReintento() {
        return cargosReintento;
    }

    /* Dice si el destino es urbano. Lo usan las subclases para elegir tarifa y dias */
    protected boolean esUrbano() {
        if (tipoDestino.equals("urbano") == true) {
            return true;
        }

        return false;
    }

    /* Q25 si es urbano y Q40 si es departamental. La usan Paquete y CargaRefrigerada */
    protected double getTarifaBase() {
        if (esUrbano() == true) {
            return TARIFA_BASE_URBANA;
        }

        return TARIFA_BASE_DEPARTAMENTAL;
    }

    /* Costo del envio. Cada categoria cobra distinto */
    public abstract double calcularCosto();

    /* Dias habiles estimados de entrega de la categoria */
    public abstract int calcularDiasEntrega();

    /* Intentos de entrega que permite la categoria */
    public abstract int getMaxIntentos();

    /* Nombre de la categoria para mostrar y para agrupar los reportes */
    public abstract String getCategoria();

    /* Por defecto un envio puede ir en cualquier vehiculo. Solo la carga refrigerada lo cambia */
    public boolean requiereRefrigeracion() {
        return false;
    }

    /* Solo se puede asignar si esta en bodega y le quedan intentos */
    public boolean puedeAsignarse() {
        if (estado.equals(EN_BODEGA) == true && intentos < getMaxIntentos()) {
            return true;
        }

        return false;
    }

    /* Guarda el monto completo cuando el cliente acepta. No se puede cobrar dos veces */
    public void cobrarRegistro() {
        if (montoRegistro > 0) {
            throw new IllegalStateException("El envio " + codigo + " ya fue cobrado");
        }

        montoRegistro = calcularCosto();
    }

    /* Pasa el envio de bodega a asignado */
    public void asignar() {
        if (puedeAsignarse() == false) {
            throw new IllegalStateException("El envio " + codigo + " no puede asignarse (estado: " + estado + ")");
        }

        estado = ASIGNADO;
    }

    /* Regresa a bodega un envio retirado de un despacho. No cambia intentos ni montos */
    public void retirar() {
        if (estado.equals(ASIGNADO) == false) {
            throw new IllegalStateException("El envio " + codigo + " no esta asignado (estado: " + estado + ")");
        }

        estado = EN_BODEGA;
    }

    /* Suma un intento y pasa a en ruta. Desde el segundo intento cobra Q15. Devuelve el cargo generado */
    public double salirARuta() {
        if (estado.equals(ASIGNADO) == false) {
            throw new IllegalStateException("El envio " + codigo + " no esta asignado (estado: " + estado + ")");
        }

        intentos = intentos + 1;
        estado = EN_RUTA;

        double cargo = 0;

        if (intentos > 1) {
            cargo = CARGO_REINTENTO;
            cargosReintento = cargosReintento + cargo;
        }

        return cargo;
    }

    /* Deja el envio entregado. Solo se puede si estaba en ruta */
    public void registrarEntregaExitosa() {
        if (estaEnRuta() == false) {
            throw new IllegalStateException("El envio " + codigo + " no esta en ruta (estado: " + estado + ")");
        }

        estado = ENTREGADO;
    }

    /* Si ya uso todos sus intentos queda devuelto al remitente; si no, regresa a bodega */
    public void registrarEntregaFallida() {
        if (estaEnRuta() == false) {
            throw new IllegalStateException("El envio " + codigo + " no esta en ruta (estado: " + estado + ")");
        }

        if (intentos >= getMaxIntentos()) {
            estado = DEVUELTO;
        } else {
            estado = EN_BODEGA;
        }
    }

    /* Dice si el envio esta en ruta, o sea que todavia no tiene resultado */
    public boolean estaEnRuta() {
        if (estado.equals(EN_RUTA) == true) {
            return true;
        }

        return false;
    }

    /* Junta los datos comunes, el estado, los intentos y los montos */
    @Override
    public String toString() {
        return getCategoria() + " " + codigo
                + " | De: " + remitente + " | Para: " + destinatario
                + " | Peso real: " + String.format("%.2f", pesoReal) + " kg"
                + " | Destino: " + tipoDestino
                + " | Estado: " + estado
                + " | Intentos: " + intentos + " de " + getMaxIntentos()
                + " | Costo: Q" + String.format("%,.2f", calcularCosto())
                + " | Dias: " + calcularDiasEntrega()
                + " | Cobrado: Q" + String.format("%,.2f", montoRegistro)
                + " | Reintentos: Q" + String.format("%,.2f", cargosReintento);
    }
}
