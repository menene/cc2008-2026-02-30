// CC2008 - Ejercicio 6. Pruebas ejecutables sin dependencias externas.
package pruebas;

import controlador.ControladorIntegraciones;
import inicializacion.InicializadorIntegraciones;
import modelo.*;
import java.util.Iterator;

/** Cada fallo termina con AssertionError; no imprime fuera de Principal. */
public class PruebasIntegraciones {
    public static void main(String[] args) {
        CatalogoIntegraciones catalogo = new CatalogoIntegraciones();
        InicializadorIntegraciones.cargar(catalogo);
        MotorCheckout motor = new MotorCheckout();
        ControladorIntegraciones controlador = new ControladorIntegraciones(catalogo, motor);
        verificar(catalogo.cantidad() == 10, "Diez integraciones iniciales");
        verificar(!catalogo.agregar(null), "No registrar null");
        verificar(!catalogo.agregar(controlador.buscar("PAG-001")), "No duplicar id");
        verificar(controlador.buscar("nada") == null && controlador.buscar(null) == null, "Búsqueda inexistente");
        verificar(!controlador.buscar("LOG-002").isConectada(), "Logística Central desconectada");
        verificar(controlador.buscar("LOG-002").isActiva(), "Activa y conectada son independientes");

        for (IntegracionAPI api : controlador.listar()) {
            verificar(api.isActiva(), "Carga inicial activa");
            verificar(api instanceof Auditable, "Auditoría heredada");
            verificar(api.registrarEvento("Prueba").contains(api.getId()), "Registro identifica proveedor");
            if (api instanceof Transaccional) {
                estado(motor.solicitarCobro((Transaccional) api, 25.5, "C-1"), EstadoResultado.EXITOSA);
                estado(controlador.reintegrar(api.getId(), 10, "R-1"), EstadoResultado.EXITOSA);
                estado(((Transaccional) api).cobrar(Double.NaN, "X"), EstadoResultado.FALLIDA);
                estado(((Transaccional) api).reintegrar(0, "X"), EstadoResultado.FALLIDA);
            } else {
                estado(controlador.reintegrar(api.getId(), 10, "R-2"), EstadoResultado.IGNORADA);
            }
        }
        // Se obtiene una vista viva sin posibilidad de eliminar del catálogo.
        Iterable<IntegracionAPI> vista = catalogo.listar();
        Iterator<IntegracionAPI> it = vista.iterator();
        it.next();
        boolean bloqueado = false;
        try { it.remove(); } catch (UnsupportedOperationException ex) { bloqueado = true; }
        verificar(bloqueado && catalogo.cantidad() == 10, "Iterator de solo lectura");

        controlador.ordenarPorLatencia();
        double anterior = -1;
        for (IntegracionAPI api : vista) {
            verificar(api.getLatenciaPromedioMs() >= anterior, "Orden ascendente sobre la misma lista");
            anterior = api.getLatenciaPromedioMs();
        }
        verificar(vista.iterator().next().getId().equals("PAG-004"), "Primera latencia: 75 ms");
        IntegracionAPI tarjeta = controlador.buscar("PAG-001");
        IntegracionAPI beta = controlador.buscar("PAG-002");
        beta.setLatenciaPromedioMs(tarjeta.getLatenciaPromedioMs());
        verificar(tarjeta.compareTo(beta) < 0, "Desempate por id");
        controlador.ordenarPorLatencia();
        String previo = "";
        anterior = -1;
        for (IntegracionAPI api : controlador.listar()) {
            if (anterior == api.getLatenciaPromedioMs()) {
                verificar(previo.compareTo(api.getId()) < 0, "Empate ordenado en catálogo");
            }
            previo = api.getId(); anterior = api.getLatenciaPromedioMs();
        }
        IntegracionAPI mismoId = new PasarelaTarjeta("PAG-001", "Otra", "https://otra.example.test", "Ninguna", 10, 999, true, true);
        verificar(tarjeta.equals(mismoId) && tarjeta.hashCode() == mismoId.hashCode(), "Identidad y hash por id");
        verificar(!tarjeta.equals(null) && !tarjeta.equals("PAG-001"), "Igualdad con otros tipos");
        verificar(!catalogo.agregar(mismoId), "Duplicado con diferente configuración");

        estado(controlador.reintegrar("NO-EXISTE", 10, "R"), EstadoResultado.FALLIDA);
        estado(controlador.reintegrar("PAG-001", 0, "R"), EstadoResultado.FALLIDA);
        estado(controlador.reintegrar("PAG-001", -10, "R"), EstadoResultado.FALLIDA);
        estado(controlador.reintegrar("PAG-001", Double.NaN, "R"), EstadoResultado.FALLIDA);
        estado(controlador.reintegrar("PAG-001", Double.POSITIVE_INFINITY, "R"), EstadoResultado.FALLIDA);
        estado(controlador.reintegrar("PAG-001", 10, " "), EstadoResultado.FALLIDA);
        estado(controlador.reintegrar("PAG-001", 10, null), EstadoResultado.FALLIDA);
        estado(controlador.reintegrar("LOG-001", 0, "R"), EstadoResultado.FALLIDA);
        tarjeta.setConectada(false);
        estado(controlador.reintegrar("PAG-001", 10, "R"), EstadoResultado.FALLIDA);
        estado(motor.solicitarCobro((Transaccional) tarjeta, 10, "R"), EstadoResultado.FALLIDA);
        tarjeta.setConectada(true); tarjeta.setActiva(false);
        estado(controlador.reintegrar("PAG-001", 10, "R"), EstadoResultado.FALLIDA);
        tarjeta.setActiva(true);
        estado(motor.solicitarReintegro((Transaccional) tarjeta, 10, "R", null), EstadoResultado.EXITOSA);
        verificar(motor.solicitarReintegro((Transaccional) tarjeta, 10, "R", "Cancelación").getMensaje().contains("Cancelación"), "Motivo de sobrecarga");
        estado(motor.solicitarReintegro((Transaccional) null, 10, "R", ""), EstadoResultado.FALLIDA);
        estado(motor.solicitarCobro(null, 10, "R"), EstadoResultado.FALLIDA);

        verificar(controlador.consultar("LOG-001", "ENV-1").startsWith("EXITOSA"), "Consulta logística");
        verificar(controlador.consultar("CON-001", "ENV-1").startsWith("EXITOSA"), "Consulta rastreo");
        verificar(controlador.consultar("LOG-002", "ENV-1").startsWith("FALLIDA"), "Consulta desconectada");
        verificar(controlador.consultar("PAG-001", "ENV-1").startsWith("IGNORADA"), "Consulta incompatible");
        verificar(controlador.generarDocumento("CON-001", "X").startsWith("IGNORADA"), "Rastreo no documenta");
        verificar(controlador.generarDocumento("LOG-002", "X").startsWith("FALLIDA"), "Documento desconectado");
        verificar(controlador.generarDocumento("LOG-001", "ENV-1").startsWith("<GuiaEnvio"), "Guía logística");
        verificar(controlador.generarDocumento("FEL-001", "A<&\"'").contains("A&lt;&amp;&quot;&apos;"), "Escape XML");
        verificar(controlador.generarDocumento("FEL-002", "F-2").startsWith("<FEL"), "Segunda FEL");
        verificar(controlador.generarDocumento("FEL-001", "\u0000").startsWith("FALLIDA"), "Rechazo de control XML");
        verificar(motor.solicitarConsulta(null, "R").startsWith("FALLIDA"), "Consulta nula");
        verificar(motor.solicitarDocumento(null, "R").startsWith("FALLIDA"), "Documento nulo");
        verificar(controlador.generarDocumento("NO", "R").startsWith("FALLIDA"), "Documento inexistente");
        estado(controlador.cobrar("LOG-001", 10, "R"), EstadoResultado.IGNORADA);
        estado(controlador.cobrar("NO", 10, "R"), EstadoResultado.FALLIDA);
        estado(controlador.cobrar("PAG-001", 10, "R"), EstadoResultado.EXITOSA);

        rechaza(() -> tarjeta.setTimeoutMs(0));
        rechaza(() -> tarjeta.setLatenciaPromedioMs(Double.NaN));
        rechaza(() -> tarjeta.setLatenciaPromedioMs(Double.POSITIVE_INFINITY));
        rechaza(() -> tarjeta.setLatenciaPromedioMs(-1));
        rechaza(() -> tarjeta.setNombre(" "));
        rechaza(() -> tarjeta.setEndpoint("https://usuario:clave@example.test"));
        rechaza(() -> tarjeta.setEndpoint("https://example.test?token=secreto"));
        rechaza(() -> tarjeta.setEndpoint("ftp://example.test"));
        verificar(tarjeta.getTimeoutMs() == 5000, "Setter inválido conserva valor anterior");
        verificar(!tarjeta.obtenerConfiguracion().contains("secreto"), "Configuración sin credenciales rechazadas");

        // Nueva clase registrada sin tocar MotorCheckout: prueba de extensión real.
        verificar(controlador.registrar(new UltimaMilla()), "Registrar nueva capacidad");
        verificar(catalogo.cantidad() == 11, "Mismo catálogo extensible");
        verificar(controlador.consultar("NUEVA-001", "R").equals("Última milla R"), "Despacho polimórfico nuevo");
        verificar(controlador.generarDocumento("NUEVA-001", "R").equals("Guía nueva R"), "Documento nuevo");
        estado(controlador.reintegrar("NUEVA-001", 10, "R"), EstadoResultado.IGNORADA);
        estado(controlador.reintegrar("PAG-001", 10, "DESPUES"), EstadoResultado.EXITOSA);

        Transaccional roto = new Transaccional() {
            public ResultadoOperacion cobrar(double monto, String ref) { throw new IllegalStateException("Fallo simulado"); }
            public ResultadoOperacion reintegrar(double monto, String ref) { throw new IllegalStateException("Fallo simulado"); }
        };
        estado(motor.solicitarReintegro(roto, 10, "R", ""), EstadoResultado.FALLIDA);
        estado(motor.solicitarCobro(roto, 10, "R"), EstadoResultado.FALLIDA);
        verificar(motor.solicitarConsulta(ref -> { throw new IllegalStateException(); }, "R").startsWith("FALLIDA"), "Fallo consulta aislado");
        verificar(motor.solicitarDocumento(ref -> null, "R").startsWith("FALLIDA"), "Documento sin respuesta");
        estado(controlador.reintegrar("PAG-001", 10, "CONTINUA"), EstadoResultado.EXITOSA);
    }
    private static void verificar(boolean condicion, String caso) {
        if (!condicion) { throw new AssertionError(caso); }
    }
    private static void estado(ResultadoOperacion resultado, EstadoResultado esperado) {
        verificar(resultado.getEstado() == esperado, "Esperado " + esperado + ", recibido " + resultado);
    }
    private static void rechaza(Runnable accion) {
        boolean rechazado = false;
        try { accion.run(); } catch (IllegalArgumentException ex) { rechazado = true; }
        verificar(rechazado, "Rechazo de configuración inválida");
    }
    private static class UltimaMilla extends IntegracionAPI implements Consultable, Documentable {
        UltimaMilla() { super("NUEVA-001", "Última milla", "https://ultima.example.test", "Ninguna", 1000, 20, true, true); }
        public String consultar(String ref) { return "Última milla " + ref; }
        public String generarDocumento(String ref) { return "Guía nueva " + ref; }
    }
}
