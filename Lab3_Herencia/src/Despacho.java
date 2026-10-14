import java.util.ArrayList;

/* Clase del despacho. Administra la asignacion, la salida, los resultados de entrega y el cierre. */
public class Despacho {

    public static final String EN_PREPARACION = "En preparacion";
    public static final String EN_RUTA = "En ruta";
    public static final String CERRADO = "Cerrado";

    private int numero;
    private static int contadorDespachos = 0;
    private Vehiculo vehiculo;
    private ArrayList<Envio> envios;
    private String estado;

    /* Constructor. El vehiculo tiene que estar libre. Le da el siguiente numero y lo deja en preparacion */
    public Despacho(Vehiculo vehiculo) {
        if (vehiculo == null) {
            throw new IllegalArgumentException("No hay vehiculo para el despacho");
        }

        if (vehiculo.estaLibre() == false) {
            throw new IllegalStateException("El vehiculo " + vehiculo.getPlaca() + " ya tiene un despacho sin cerrar");
        }

        contadorDespachos = contadorDespachos + 1;
        this.numero = contadorDespachos;
        this.vehiculo = vehiculo;
        this.envios = new ArrayList<Envio>();
        this.estado = EN_PREPARACION;

        vehiculo.ocupar(this);
    }

    public int getNumero() {
        return numero;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public String getEstado() {
        return estado;
    }

    /* Copia de los envios del despacho para consultarlos sin poder cambiarlos */
    public ArrayList<Envio> getEnvios() {
        return new ArrayList<Envio>(envios);
    }

    /* Suma los pesos reales de los envios. Nunca usa el peso volumetrico */
    public double calcularPesoCargado() {
        double total = 0;

        for (int i = 0; i < envios.size(); i++) {
            total = total + envios.get(i).getPesoReal();
        }

        return total;
    }

    /* Capacidad del vehiculo menos el peso cargado */
    public double calcularCapacidadDisponible() {
        return vehiculo.getCapacidadMaxima() - calcularPesoCargado();
    }

    /* Revisa todas las condiciones antes de cambiar algo. Si una falla, lanza el error y no asigna */
    public void asignarEnvio(Envio envio) {
        if (envio == null) {
            throw new IllegalArgumentException("No hay envio que asignar");
        }

        if (estado.equals(EN_PREPARACION) == false) {
            throw new IllegalStateException("El despacho #" + numero + " no esta en preparacion (estado: " + estado + ")");
        }

        if (envio.puedeAsignarse() == false) {
            throw new IllegalStateException("El envio " + envio.getCodigo() + " no esta disponible en bodega (estado: " + envio.getEstado() + ")");
        }

        /* Se deja un margen muy pequeno por los decimales de double, por ejemplo 0.1 + 0.2 */
        if (calcularPesoCargado() + envio.getPesoReal() > vehiculo.getCapacidadMaxima() + 0.000001) {
            throw new IllegalStateException("El envio " + envio.getCodigo() + " pesa " + String.format("%.2f", envio.getPesoReal())
                    + " kg y solo quedan " + String.format("%.2f", calcularCapacidadDisponible()) + " kg disponibles en el vehiculo " + vehiculo.getPlaca());
        }

        if (vehiculo.puedeTransportar(envio) == false) {
            throw new IllegalStateException("El envio " + envio.getCodigo() + " requiere un vehiculo refrigerado y el vehiculo "
                    + vehiculo.getPlaca() + " no lo es");
        }

        envio.asignar();
        envios.add(envio);
    }

    /* Quita un envio mientras el despacho esta en preparacion y lo regresa a bodega. No toca los ingresos */
    public void retirarEnvio(String codigo) {
        if (estado.equals(EN_PREPARACION) == false) {
            throw new IllegalStateException("Solo se pueden retirar envios de un despacho en preparacion (estado: " + estado + ")");
        }

        Envio envio = buscarEnvio(codigo);

        if (envio == null) {
            throw new IllegalArgumentException("El envio " + codigo + " no esta en el despacho #" + numero);
        }

        envio.retirar();
        envios.remove(envio);
    }

    /* Saca todos los envios a ruta. Aqui se registra el cargo por reintento. Devuelve el total de cargos */
    public double salir() {
        if (estado.equals(EN_PREPARACION) == false) {
            throw new IllegalStateException("El despacho #" + numero + " no esta en preparacion (estado: " + estado + ")");
        }

        if (envios.size() == 0) {
            throw new IllegalStateException("No puede salir un despacho vacio");
        }

        double cargos = 0;

        for (int i = 0; i < envios.size(); i++) {
            cargos = cargos + envios.get(i).salirARuta();
        }

        estado = EN_RUTA;

        return cargos;
    }

    /* Registra si un envio fue entregado o fallo. Cuando todos tienen resultado se cierra el despacho */
    public void registrarResultado(String codigo, boolean entregado) {
        if (estado.equals(EN_RUTA) == false) {
            throw new IllegalStateException("El despacho #" + numero + " no esta en ruta (estado: " + estado + ")");
        }

        Envio envio = buscarEnvio(codigo);

        if (envio == null) {
            throw new IllegalArgumentException("El envio " + codigo + " no esta en el despacho #" + numero);
        }

        if (envio.estaEnRuta() == false) {
            throw new IllegalStateException("El envio " + envio.getCodigo() + " ya tiene resultado registrado (estado: " + envio.getEstado() + ")");
        }

        if (entregado == true) {
            envio.registrarEntregaExitosa();
        } else {
            envio.registrarEntregaFallida();
        }

        if (todosConResultado() == true) {
            cerrar();
        }
    }

    /* Recorre los envios del despacho comparando codigos. Devuelve null si ninguno coincide */
    private Envio buscarEnvio(String codigo) {
        if (codigo == null) {
            return null;
        }

        for (int i = 0; i < envios.size(); i++) {
            if (envios.get(i).getCodigo().equalsIgnoreCase(codigo.trim()) == true) {
                return envios.get(i);
            }
        }

        return null;
    }

    /* Revisa si ya ningun envio esta en ruta */
    private boolean todosConResultado() {
        for (int i = 0; i < envios.size(); i++) {
            if (envios.get(i).estaEnRuta() == true) {
                return false;
            }
        }

        return true;
    }

    /* Cierra el despacho y deja libre el vehiculo */
    private void cerrar() {
        estado = CERRADO;
        vehiculo.liberar();
    }

    /* Dice si el despacho ya esta cerrado */
    public boolean estaCerrado() {
        if (estado.equals(CERRADO) == true) {
            return true;
        }

        return false;
    }

    /* Junta el numero, el vehiculo, el estado, los pesos y los envios */
    @Override
    public String toString() {
        String texto = "Despacho #" + numero
                + " | Vehiculo: " + vehiculo.getPlaca()
                + " | Estado: " + estado
                + " | Peso cargado: " + String.format("%.2f", calcularPesoCargado()) + " kg"
                + " | Capacidad disponible: " + String.format("%.2f", calcularCapacidadDisponible()) + " kg";

        if (envios.size() == 0) {
            return texto + "\n    (sin envios)";
        }

        for (int i = 0; i < envios.size(); i++) {
            Envio envio = envios.get(i);
            texto = texto + "\n    - " + envio.getCodigo() + " (" + envio.getCategoria() + ", "
                    + String.format("%.2f", envio.getPesoReal()) + " kg) - " + envio.getEstado();
        }

        return texto;
    }
}
