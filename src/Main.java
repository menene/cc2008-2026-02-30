import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Scanner;

// Inicia el sistema y maneja la entrada y salida de consola.
public class Main {
    public static void main(String[] args) {
        RepositorioIntegraciones catalogo = new CatalogoIntegraciones();
        cargarDatosIniciales(catalogo);
        ControladorIntegraciones controlador = new ControladorIntegraciones(catalogo);
        VistaConsola vista = new VistaConsola();
        System.out.println("Prototipo: las respuestas de las APIs son simuladas.");

        try (Scanner entrada = new Scanner(System.in)) {
            ejecutarMenu(entrada, controlador, vista);
        }
    }

    private static void cargarDatosIniciales(RepositorioIntegraciones repositorio) {
        repositorio.registrar(new PasarelaPago(1, "Pasarela Uno", EstadoConexion.ACTIVA,
                120, "https://api.ejemplo.test/pasarela-uno", 3000,
                TipoAutenticacion.TOKEN, "token-pasarela-uno", "COM-001", "GTQ"));
        repositorio.registrar(new PasarelaPago(2, "Pasarela Dos", EstadoConexion.ACTIVA,
                95, "https://api.ejemplo.test/pasarela-dos", 3000,
                TipoAutenticacion.API_KEY, "clave-pasarela-dos", "COM-002", "USD"));

        repositorio.registrar(new Banco(3, "Banco Uno", EstadoConexion.ACTIVA,
                180, "https://api.ejemplo.test/banco-uno", 5000,
                TipoAutenticacion.TOKEN, "token-banco-uno", "BAN-001", "GTQ"));
        repositorio.registrar(new Banco(4, "Banco Dos", EstadoConexion.ERROR,
                250, "https://api.ejemplo.test/banco-dos", 5000,
                TipoAutenticacion.API_KEY, "clave-banco-dos", "BAN-002", "USD"));

        repositorio.registrar(new BilleteraDigital(5, "Billetera Uno", EstadoConexion.ACTIVA,
                80, "https://api.ejemplo.test/billetera-uno", 2500,
                TipoAutenticacion.TOKEN, "token-billetera-uno", "BIL-001", "GTQ"));
        repositorio.registrar(new BilleteraDigital(6, "Billetera Dos", EstadoConexion.INACTIVA,
                210, "https://api.ejemplo.test/billetera-dos", 2500,
                TipoAutenticacion.TOKEN, "token-billetera-dos", "BIL-002", "USD"));

        repositorio.registrar(new ProveedorLogistico(7, "Envios Uno", EstadoConexion.ACTIVA,
                140, "https://api.ejemplo.test/envios-uno", 4000,
                TipoAutenticacion.API_KEY, "clave-envios-uno", "Guatemala", "Estandar"));
        repositorio.registrar(new ProveedorLogistico(8, "Envios Dos", EstadoConexion.ACTIVA,
                300, "https://api.ejemplo.test/envios-dos", 4000,
                TipoAutenticacion.NINGUNA, "", "Centroamerica", "Expreso"));

        repositorio.registrar(new CertificadorFEL(9, "Certificador Uno", EstadoConexion.ACTIVA,
                110, "https://api.ejemplo.test/fel-uno", 3500,
                TipoAutenticacion.TOKEN, "token-fel-uno", "1.0", AmbienteFEL.PRUEBAS));
        repositorio.registrar(new CertificadorFEL(10, "Certificador Dos", EstadoConexion.ACTIVA,
                160, "https://api.ejemplo.test/fel-dos", 3500,
                TipoAutenticacion.API_KEY, "clave-fel-dos", "1.1", AmbienteFEL.PRODUCCION));
    }

    private static void ejecutarMenu(Scanner entrada, ControladorIntegraciones controlador,
            VistaConsola vista) {
        int opcion = -1;
        while (opcion != 0) {
            System.out.print(vista.obtenerMenu());
            try {
                opcion = Integer.parseInt(entrada.nextLine().trim());
                switch (opcion) {
                    case 0:
                        System.out.println("Hasta luego.");
                        break;
                    case 1:
                        System.out.println(vista.formatearListado(controlador.listarIntegraciones()));
                        break;
                    case 2: {
                        System.out.print("ID de la integracion: ");
                        int id = Integer.parseInt(entrada.nextLine().trim());
                        System.out.println(vista.formatearConfiguracion(
                                controlador.buscarIntegracion(id)));
                        break;
                    }
                    case 3:
                        System.out.println(vista.formatearListado(controlador.listarPorLatencia()));
                        break;
                    case 4: {
                        System.out.print("ID de la integracion: ");
                        int id = Integer.parseInt(entrada.nextLine().trim());
                        System.out.print("Referencia para consultar: ");
                        String referencia = entrada.nextLine();
                        System.out.println(vista.formatearResultado(
                                controlador.solicitarConsulta(id, referencia)));
                        break;
                    }
                    case 5: {
                        System.out.print("ID de la integracion: ");
                        int id = Integer.parseInt(entrada.nextLine().trim());
                        System.out.print("Monto del cobro: ");
                        BigDecimal monto = new BigDecimal(entrada.nextLine().trim());
                        System.out.println(vista.formatearResultado(
                                controlador.solicitarCobro(id, monto)));
                        break;
                    }
                    case 6: {
                        System.out.print("ID de la integracion: ");
                        int id = Integer.parseInt(entrada.nextLine().trim());
                        System.out.print("Monto del reintegro: ");
                        BigDecimal monto = new BigDecimal(entrada.nextLine().trim());
                        System.out.println(vista.formatearResultado(
                                controlador.solicitarReintegro(id, monto)));
                        break;
                    }
                    case 7: {
                        System.out.print("ID de la integracion: ");
                        int id = Integer.parseInt(entrada.nextLine().trim());
                        System.out.print("Referencia del documento: ");
                        String referencia = entrada.nextLine();
                        System.out.println(vista.formatearResultado(
                                controlador.solicitarDocumento(id, referencia)));
                        break;
                    }
                    case 8: {
                        System.out.print("ID de la integracion: ");
                        int id = Integer.parseInt(entrada.nextLine().trim());
                        System.out.print("Referencia de auditoria: ");
                        String referencia = entrada.nextLine();
                        System.out.println(vista.formatearResultado(
                                controlador.solicitarAuditoria(id, referencia)));
                        break;
                    }
                    default:
                        System.out.println("Opcion no valida.");
                        break;
                }
            } catch (NumberFormatException error) {
                System.out.println("Ingrese un numero valido.");
            } catch (NoSuchElementException error) {
                System.out.println("\nEntrada finalizada.");
                opcion = 0;
            }
        }
    }
}
