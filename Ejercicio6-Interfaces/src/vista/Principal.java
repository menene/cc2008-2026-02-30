// CC2008 - Ejercicio 6: Polimorfismo via Interfaces.
// Prototipo educativo: operaciones simuladas, sin llamadas de red.
package vista;


import java.util.Scanner;
import java.util.NoSuchElementException;
import controlador.ControladorIntegraciones;
import inicializacion.InicializadorIntegraciones;
import modelo.*;

/** Única clase que lee entradas e imprime mensajes al usuario. */
public class Principal {
    private final Scanner scanner;
    // Precisión MVC documentada antes de implementar: referencia, nunca un catálogo adicional.
    private final ControladorIntegraciones controlador;

    private Principal(ControladorIntegraciones controlador) {
        this.scanner = new Scanner(System.in, java.nio.charset.StandardCharsets.UTF_8);
        this.controlador = controlador;
    }
    public static void main(String[] args) {
        CatalogoIntegraciones catalogo = new CatalogoIntegraciones();
        InicializadorIntegraciones.cargar(catalogo);
        Principal vista = new Principal(new ControladorIntegraciones(catalogo, new MotorCheckout()));
        vista.mostrarMenu();
    }
    private void mostrarMenu() {
        boolean continuar = true;
        System.out.println("EJERCICIO 6 | Catálogo de 10 integraciones | MODO SIMULADO");
        do {
            System.out.println("\n1. Listar activas y conexión\n2. Buscar configuración por id"
                    + "\n3. Ordenar catálogo por latencia\n4. Solicitar reintegro"
                    + "\n5. Solicitar cobro\n6. Consultar envío\n7. Generar guía o FEL\n0. Salir");
            try {
                String opcion = leer("Seleccione una opción:");
                switch (opcion) {
                    case "0" -> continuar = false;
                    case "1" -> mostrarIntegraciones();
                    case "2" -> mostrarDetalle(controlador.buscar(leer("Id (ejemplo PAG-001):")));
                    case "3" -> {
                        controlador.ordenarPorLatencia();
                        System.out.println("Catálogo completo ordenado por latencia ascendente:");
                        for (IntegracionAPI api : controlador.listar()) { System.out.println(api); }
                    }
                    case "4", "5" -> {
                        String id = leer("Id de integración:");
                        double monto = Double.parseDouble(leer("Monto positivo (punto decimal, ejemplo 25.50):"));
                        String ref = leer("Referencia de operación:");
                        ResultadoOperacion resultado = opcion.equals("4")
                                ? controlador.reintegrar(id, monto, ref) : controlador.cobrar(id, monto, ref);
                        System.out.println(resultado);
                    }
                    case "6" -> {
                        String id = leer("Id de integración (LOG-001 o CON-001):");
                        System.out.println(controlador.consultar(id, leer("Referencia del envío:")));
                    }
                    case "7" -> {
                        String id = leer("Id de integración (LOG-001 o FEL-001):");
                        System.out.println(controlador.generarDocumento(id, leer("Referencia del documento:")));
                    }
                    default -> System.out.println("Opción inválida. Ingrese un número de 0 a 7.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Monto inválido. Use un número con punto decimal. Operación cancelada.");
            } catch (IllegalArgumentException ex) {
                System.out.println("Datos inválidos: " + ex.getMessage());
            } catch (NoSuchElementException ex) {
                System.out.println("Fin de la entrada. Operación pendiente cancelada.");
                continuar = false;
            }
        } while (continuar);
        System.out.println("Sesión finalizada.");
    }
    private void mostrarIntegraciones() {
        int cantidad = 0;
        for (IntegracionAPI api : controlador.listar()) {
            if (api.isActiva()) { System.out.println(api); cantidad++; }
        }
        System.out.println("Integraciones activas: " + cantidad);
    }
    private void mostrarDetalle(IntegracionAPI api) {
        System.out.println(api == null ? "Integración no encontrada." : api.obtenerConfiguracion());
    }
    private String leer(String mensaje) {
        System.out.println(mensaje);
        return scanner.nextLine().trim();
    }
}
