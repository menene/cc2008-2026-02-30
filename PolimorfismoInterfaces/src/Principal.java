import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Principal {

    private static Scanner scanner = new Scanner(System.in);
    private static GestorIntegraciones gestor = new GestorIntegraciones();

    private static final String LINEA =
            "------------------------------------------------------------------------------------------------------";

    public static void main(String[] args) {
        System.out.println("==============================================================");
        System.out.println("   GESTOR DE INTEGRACIONES - Plataforma de comercio electrónico");
        System.out.println("==============================================================");
        cargarCatalogoInicial();

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1 -> listarIntegraciones();
                case 2 -> buscarIntegracion();
                case 3 -> ordenarPorLatencia();
                case 4 -> simularCompra();
                case 5 -> procesarReintegro();
                case 6 -> rastrearEnvio();
                case 0 -> System.out.println("Saliendo del sistema. ¡Hasta pronto!");
                default -> System.out.println("Opción no válida. Elija un número del 0 al 6.");
            }
        } while (opcion != 0);
        scanner.close();
    }

    private static void cargarCatalogoInicial() {
        ArrayList<IntegracionAPI> iniciales = new ArrayList<>();

        // Pasarelas de pago (5)
        iniciales.add(new PasarelaTarjeta("PAY-VISA", "VisaNet Guatemala",
                "https://api.visanet.com.gt/payments", "v2.1", 5000, 180.5, EstadoConexion.CONECTADA,
                3.5, new ArrayList<>(Arrays.asList("Visa", "Mastercard")), 12));
        iniciales.add(new PasarelaTarjeta("PAY-CYB", "Cybersource",
                "https://api.cybersource.com/pts", "v1.0", 4000, 240.0, EstadoConexion.INESTABLE,
                2.9, new ArrayList<>(Arrays.asList("Visa", "Mastercard", "Amex")), 6));
        iniciales.add(new PasarelaTransferencia("PAY-TRF", "Banco Industrial",
                "https://api.bi.com.gt/transfer", "v3.0", 8000, 320.0, EstadoConexion.CONECTADA,
                1.0, "Banco Industrial", "001-123456-7"));
        iniciales.add(new BilleteraDigital("PAY-PPL", "PayPal",
                "https://api.paypal.com/v2/checkout", "v2", 6000, 410.2, EstadoConexion.CONECTADA,
                4.4, 5000));
        iniciales.add(new BilleteraDigital("PAY-TIGO", "Tigo Money",
                "https://api.tigomoney.com.gt/pay", "v1.4", 3000, 95.3, EstadoConexion.DESCONECTADA,
                2.0, 2000));

        // Proveedores de logística (3)
        iniciales.add(new MensajeriaLocal("LOG-MOTO", "Mensajeros Express",
                "https://api.mensajerosexpress.gt", "v1.2", 2500, 75.8, EstadoConexion.CONECTADA,
                "Ciudad de Guatemala", 25, 3, 15));
        iniciales.add(new PaqueteriaNacional("LOG-CEX", "Cargo Expreso",
                "https://api.cargoexpreso.com/envios", "v4.0", 7000, 260.4, EstadoConexion.CONECTADA,
                "Guatemala", 35, 5, "CEX"));
        iniciales.add(new PaqueteriaNacional("LOG-GTX", "Guatex",
                "https://api.guatex.com/v2", "v2.3", 7000, 510.9, EstadoConexion.INESTABLE,
                "Guatemala", 30, 6, "GTX"));

        iniciales.add(new CertificadorFEL("FEL-INFILE", "INFILE",
                "https://certificador.infile.com.gt/fel", "v1.0", 9000, 350.0, EstadoConexion.CONECTADA,
                "12521337", "PRODUCCION"));
        iniciales.add(new CertificadorFEL("FEL-DIGI", "Digifact",
                "https://felgtaws.digifact.com.gt/api", "v1.5", 9000, 290.7, EstadoConexion.CONECTADA,
                "77454820"));

        for (IntegracionAPI integracion : iniciales) {
            try {
                gestor.agregarIntegracion(integracion);
            } catch (IllegalArgumentException e) {
                System.out.println("No se pudo registrar una integración: " + e.getMessage());
            }
        }
        System.out.println("Catálogo cargado: " + gestor.listarIntegraciones().size() + " integraciones.");
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("========================= MENÚ PRINCIPAL =========================");
        System.out.println(" 1. Listar integraciones y su estado de conexión");
        System.out.println(" 2. Buscar una integración por identificador");
        System.out.println(" 3. Ordenar el catálogo por latencia promedio");
        System.out.println(" 4. Simular una compra (checkout)");
        System.out.println(" 5. Procesar un reintegro");
        System.out.println(" 6. Rastrear un envío");
        System.out.println(" 0. Salir");
        System.out.println("==================================================================");
    }

    //Muestra cada integración con toString()
    private static void listarIntegraciones() {
        ArrayList<IntegracionAPI> lista;
        String titulo;
        if (leerSiNo("¿Desea filtrar por estado de conexión? (s/n): ")) {
            EstadoConexion estado = leerEstadoConexion();
            lista = gestor.listarIntegraciones(estado);
            titulo = "INTEGRACIONES EN ESTADO " + estado;
        } else {
            lista = gestor.listarIntegraciones();
            titulo = "TODAS LAS INTEGRACIONES";
        }
        imprimirTabla(titulo, lista);
    }

    private static void buscarIntegracion() {
        String id = leerTexto("Identificador de la integración: ");
        IntegracionAPI integracion = gestor.buscarPorId(id);
        if (integracion == null) {
            System.out.println("No existe una integración con el identificador '" + id + "'.");
        } else {
            System.out.println();
            System.out.println("------------------- CONFIGURACIÓN -------------------");
            System.out.println(integracion.getConfiguracion());
            ArrayList<String> bitacora = gestor.obtenerBitacora(id);
            System.out.println("--------------------- BITÁCORA ----------------------");
            if (bitacora.isEmpty()) {
                System.out.println("(Sin eventos registrados o la integración no es auditable)");
            } else {
                for (String evento : bitacora) {
                    System.out.println("  " + evento);
                }
            }
        }
    }
    
    private static void ordenarPorLatencia() {
        boolean descendente = leerSiNo("¿Mostrar primero las más lentas (cuellos de botella)? (s/n): ");
        ArrayList<IntegracionAPI> ordenadas = gestor.ordenarPorLatencia(descendente);
        String titulo = descendente
                ? "CATÁLOGO POR LATENCIA (MAYOR A MENOR)"
                : "CATÁLOGO POR LATENCIA (MENOR A MAYOR)";
        imprimirTabla(titulo, ordenadas);
    }

    //Pide pasarela, logística, certificador, monto, peso y destino, y muestra cada resultado
    private static void simularCompra() {
        imprimirTabla("INTEGRACIONES DISPONIBLES", gestor.listarIntegraciones());
        String idPasarela = leerTexto("Identificador de la pasarela de pago: ");
        String idLogistica = leerTexto("Identificador del proveedor de logística: ");
        String idCertificador = leerTexto("Identificador del certificador FEL: ");
        double monto = leerDouble("Monto de la compra (Q): ");
        double peso = leerDouble("Peso del paquete (kg): ");
        String destino = leerTexto("Destino del envío: ");

        ArrayList<ResultadoOperacion> resultados =
                gestor.procesarCompra(idPasarela, idLogistica, idCertificador, monto, peso, destino);

        System.out.println();
        System.out.println("-------------------- RESULTADO DEL CHECKOUT --------------------");
        boolean huboRechazo = false;
        for (ResultadoOperacion resultado : resultados) {
            mostrarResultado(resultado);
            if (resultado.getEstado() == EstadoOperacion.RECHAZADA) {
                huboRechazo = true;
            }
        }
        System.out.println("----------------------------------------------------------------");
        if (huboRechazo) {
            System.out.println("La compra no se completó. Revise los pasos rechazados.");
        } else if (resultados.size() > 1 && resultados.get(1).fueExitosa()) {
            System.out.println("Compra procesada. Los pasos IGNORADOS no aplican a la integración elegida.");
        } else {
            System.out.println("La compra se detuvo: la integración elegida no soporta un paso obligatorio.");
        }
    }

    private static void procesarReintegro() {
        String id = leerTexto("Identificador de la integración: ");
        double monto = leerDouble("Monto a reintegrar (Q): ");
        String referencia = leerTexto("Referencia de la orden (ej. ORD-0001): ");
        mostrarResultado(gestor.procesarReintegro(id, monto, referencia));
    }

    //Pide los datos del rastreo y muestra el resultado
    private static void rastrearEnvio() {
        String id = leerTexto("Identificador del proveedor de logística: ");
        String guia = leerTexto("Código de guía (ej. CEX-0001): ");
        mostrarResultado(gestor.rastrearEnvio(id, guia));
    }

    //Imprime el resultado y su detalle si lo tiene
    private static void mostrarResultado(ResultadoOperacion resultado) {
        System.out.println(resultado);
        if (!resultado.getDetalle().isEmpty()) {
            for (String linea : resultado.getDetalle().split("\\R")) {
                System.out.println("      " + linea);
            }
        }
    }

    private static void imprimirTabla(String titulo, ArrayList<IntegracionAPI> lista) {
        System.out.println();
        System.out.println(titulo + " (" + lista.size() + ")");
        System.out.println(LINEA);
        System.out.println(String.format("%-11s | %-20s | %-38s | %-12s | %10s",
                "ID", "PROVEEDOR", "TIPO DE SERVICIO", "ESTADO", "LATENCIA"));
        System.out.println(LINEA);
        if (lista.isEmpty()) {
            System.out.println("(No hay integraciones para mostrar)");
        }
        for (IntegracionAPI integracion : lista) {
            System.out.println(integracion);
        }
        System.out.println(LINEA);
    }

    private static EstadoConexion leerEstadoConexion() {
        EstadoConexion[] estados = EstadoConexion.values();
        for (int i = 0; i < estados.length; i++) {
            System.out.println("  " + (i + 1) + ". " + estados[i]);
        }
        int opcion;
        do {
            opcion = leerEntero("Seleccione el estado: ");
            if (opcion < 1 || opcion > estados.length) {
                System.out.println("Debe elegir un número del 1 al " + estados.length + ".");
            }
        } while (opcion < 1 || opcion > estados.length);
        return estados[opcion - 1];
    }

    private static int leerEntero(String mensaje) {
        int valor = 0;
        boolean valido;
        do {
            System.out.print(mensaje);
            try {
                valor = Integer.parseInt(scanner.nextLine().trim());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Formato inválido: ingrese un número entero.");
                valido = false;
            }
        } while (!valido);
        return valor;
    }

    private static double leerDouble(String mensaje) {
        double valor = 0;
        boolean valido;
        do {
            System.out.print(mensaje);
            try {
                valor = Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Formato inválido: ingrese un número (ej. 150.50).");
                valido = false;
            }
        } while (!valido);
        return valor;
    }

    private static String leerTexto(String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = scanner.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("El valor no puede estar vacío.");
            }
        } while (texto.isEmpty());
        return texto;
    }

    private static boolean leerSiNo(String mensaje) {
        String respuesta;
        boolean valida;
        do {
            System.out.print(mensaje);
            respuesta = scanner.nextLine().trim().toLowerCase();
            valida = respuesta.equals("s") || respuesta.equals("n");
            if (!valida) {
                System.out.println("Responda 's' para sí o 'n' para no.");
            }
        } while (!valida);
        return respuesta.equals("s");
    }
}
