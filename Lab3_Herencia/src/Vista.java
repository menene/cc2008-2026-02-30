import java.util.ArrayList;
import java.util.Scanner;

/* Clase de la vista. Es la unica que imprime y lee los datos del usuario. */
public class Vista {

    private EmpresaMensajeria empresa;
    private Scanner scanner;

    /* Constructor. Prepara el lector de la consola, crea la empresa y carga los datos iniciales */
    public Vista() {
        scanner = new Scanner(System.in);
        empresa = new EmpresaMensajeria();

        cargarDatosIniciales();
    }

    /* Muestra el menu y repite hasta que el usuario escoja salir. Atrapa los errores de cada operacion */
    public void mostrarMenu() {
        System.out.println("ENVIAGT - SISTEMA DE MENSAJERIA");

        int opcion = 0;

        while (opcion != 12) {
            System.out.println("");
            System.out.println("MENU");
            System.out.println("1. Cotizar envio");
            System.out.println("2. Registrar envio");
            System.out.println("3. Registrar vehiculo");
            System.out.println("4. Crear despacho");
            System.out.println("5. Asignar envio a un despacho");
            System.out.println("6. Retirar envio de un despacho");
            System.out.println("7. Hacer salir un despacho");
            System.out.println("8. Registrar resultados de entrega");
            System.out.println("9. Consultar envios");
            System.out.println("10. Consultar vehiculos");
            System.out.println("11. Reportes");
            System.out.println("12. Salir");

            opcion = leerEntero("Opcion: ");

            try {
                if (opcion == 1) {
                    cotizarEnvio();
                } else if (opcion == 2) {
                    registrarEnvio();
                } else if (opcion == 3) {
                    registrarVehiculo();
                } else if (opcion == 4) {
                    crearDespacho();
                } else if (opcion == 5) {
                    asignarEnvio();
                } else if (opcion == 6) {
                    retirarEnvio();
                } else if (opcion == 7) {
                    salirDespacho();
                } else if (opcion == 8) {
                    registrarResultados();
                } else if (opcion == 9) {
                    consultarEnvios();
                } else if (opcion == 10) {
                    consultarVehiculos();
                } else if (opcion == 11) {
                    mostrarReportes();
                } else if (opcion == 12) {
                    System.out.println("Adios");
                } else {
                    System.out.println("La opcion debe estar entre 1 y 12");
                }
            } catch (IllegalArgumentException error) {
                System.out.println("Error: " + error.getMessage() + ". No se modifico ningun dato");
            } catch (IllegalStateException error) {
                System.out.println("Error: " + error.getMessage() + ". No se modifico ningun dato");
            }
        }

        scanner.close();
    }

    /* Dos envios de cada categoria en bodega y tres vehiculos. Nada se cobra, el programa empieza sin ingresos */
    private void cargarDatosIniciales() {
        /* Sobre urbano (Q20, 1 dia) y sobre departamental en el limite de 0.5 kg (Q35, 2 dias) */
        empresa.agregarEnvioInicial(new Sobre("SOB-01", "Ana Lopez", "Luis Perez", 0.3, "urbano"));
        empresa.agregarEnvioInicial(new Sobre("SOB-02", "Banco Central", "Maria Gomez", 0.5, "departamental"));

        /* Paquete del enunciado: el volumetrico (4.8 kg) supera al real (3.2 kg), se cobran 5 kg = Q65 */
        empresa.agregarEnvioInicial(new Paquete("PAQ-01", "Carlos Ruiz", "Sofia Mendez", 3.2, "urbano", 40, 30, 20));
        /* Paquete departamental donde manda el peso real: 6.3 kg se cobra como 7 kg = Q40 + Q56 = Q96 */
        empresa.agregarEnvioInicial(new Paquete("PAQ-02", "Tienda La Economica", "Jorge Castillo", 6.3, "departamental", 30, 20, 10));

        /* Paquete fragil del enunciado: Q65 + Q15 + Q36 = Q116, 3 dias */
        empresa.agregarEnvioInicial(new PaqueteFragil("FRA-01", "Elena Morales", "Pedro Garcia", 3.2, "urbano", 40, 30, 20, 1200));
        /* Fragil departamental: 2 kg = Q40 + Q16 = Q56, mas Q15 y Q15 de seguro = Q86, 5 dias */
        empresa.agregarEnvioInicial(new PaqueteFragil("FRA-02", "Vidrios GT", "Rosa Hernandez", 2.0, "departamental", 20, 20, 20, 500));

        /* Cargas refrigeradas urbanas: Q25 + Q12 x kg + Q60 */
        empresa.agregarEnvioInicial(new CargaRefrigerada("REF-01", "Farmacia Salud", "Hospital Central", 10, "urbano", 4));
        empresa.agregarEnvioInicial(new CargaRefrigerada("REF-02", "Carnes del Valle", "Restaurante El Fogon", 2.5, "urbano", -18));

        /* Un camion sin refrigeracion, uno refrigerado y una moto con poca capacidad para probar el limite */
        empresa.registrarVehiculo(new Vehiculo("P123ABC", 500, false));
        empresa.registrarVehiculo(new Vehiculo("C456DEF", 800, true));
        empresa.registrarVehiculo(new Vehiculo("M789GHI", 5, false));
    }

    /* Pide la categoria y los datos, y crea el objeto de esa subclase. Es la unica parte que conoce las subclases */
    private Envio leerDatosEnvio() {
        System.out.println("Categorias: 1. Sobre  2. Paquete  3. Paquete fragil  4. Carga refrigerada");
        int categoria = leerEntero("Categoria: ");

        if (categoria < 1 || categoria > 4) {
            throw new IllegalArgumentException("La categoria debe estar entre 1 y 4");
        }

        String codigo = leerTexto("Codigo del envio: ");
        String remitente = leerTexto("Remitente: ");
        String destinatario = leerTexto("Destinatario: ");
        double pesoReal = leerDecimal("Peso real (kg): ");

        System.out.println("Destinos: 1. Urbano  2. Departamental");
        int destino = leerEntero("Destino: ");
        String tipoDestino = "";

        if (destino == 1) {
            tipoDestino = "urbano";
        } else if (destino == 2) {
            tipoDestino = "departamental";
        } else {
            throw new IllegalArgumentException("El destino debe ser 1 o 2");
        }

        if (categoria == 1) {
            return new Sobre(codigo, remitente, destinatario, pesoReal, tipoDestino);
        }

        if (categoria == 4) {
            double temperatura = leerDecimal("Temperatura requerida (C): ");
            return new CargaRefrigerada(codigo, remitente, destinatario, pesoReal, tipoDestino, temperatura);
        }

        double largo = leerDecimal("Largo (cm): ");
        double ancho = leerDecimal("Ancho (cm): ");
        double alto = leerDecimal("Alto (cm): ");

        if (categoria == 2) {
            return new Paquete(codigo, remitente, destinatario, pesoReal, tipoDestino, largo, ancho, alto);
        }

        double valorDeclarado = leerDecimal("Valor declarado (Q): ");
        return new PaqueteFragil(codigo, remitente, destinatario, pesoReal, tipoDestino, largo, ancho, alto, valorDeclarado);
    }

    /* 1. Muestra el costo y los dias sin registrar nada */
    private void cotizarEnvio() {
        Envio envio = leerDatosEnvio();

        System.out.println(empresa.cotizar(envio));
        System.out.println("Solo es una cotizacion. No se registro el envio ni se cobro nada");
    }

    /* 2. Muestra la cotizacion y, si el cliente acepta, registra y cobra el envio */
    private void registrarEnvio() {
        Envio envio = leerDatosEnvio();

        if (empresa.buscarEnvio(envio.getCodigo()) != null) {
            System.out.println("Error: ya existe un envio con el codigo " + envio.getCodigo() + ". No se modifico ningun dato");
            return;
        }

        System.out.println(empresa.cotizar(envio));

        boolean acepta = leerSiNo("El cliente acepta? (s/n): ");

        if (acepta == false) {
            System.out.println("Registro cancelado. No se modifico ningun dato");
            return;
        }

        empresa.registrarEnvio(envio);

        System.out.println("Envio registrado y cobrado: Q" + String.format("%,.2f", envio.getMontoRegistro()));
        System.out.println(envio.toString());
    }

    /* 3. Pide los datos del vehiculo y lo agrega a la flotilla */
    private void registrarVehiculo() {
        String placa = leerTexto("Placa: ");

        if (empresa.buscarVehiculo(placa) != null) {
            System.out.println("Error: ya existe un vehiculo con la placa " + placa.toUpperCase() + ". No se modifico ningun dato");
            return;
        }

        double capacidad = leerDecimal("Capacidad maxima (kg): ");
        boolean refrigerado = leerSiNo("Tiene refrigeracion? (s/n): ");

        Vehiculo vehiculo = new Vehiculo(placa, capacidad, refrigerado);
        empresa.registrarVehiculo(vehiculo);

        System.out.println("Vehiculo registrado: " + vehiculo.toString());
    }

    /* 4. Pide la placa y crea un despacho en preparacion */
    private void crearDespacho() {
        String placa = leerTexto("Placa del vehiculo: ");
        Despacho despacho = empresa.crearDespacho(placa);

        System.out.println("Despacho #" + despacho.getNumero() + " creado en preparacion");
        System.out.println(despacho.toString());
    }

    /* 5. Pide el despacho y el envio, y lo asigna */
    private void asignarEnvio() {
        int numero = leerEntero("Numero de despacho: ");
        String codigo = leerTexto("Codigo del envio: ");

        empresa.asignarEnvio(numero, codigo);

        System.out.println("Envio asignado");
        System.out.println(empresa.buscarDespacho(numero).toString());
    }

    /* 6. Pide el despacho y el envio, y lo regresa a bodega */
    private void retirarEnvio() {
        int numero = leerEntero("Numero de despacho: ");
        String codigo = leerTexto("Codigo del envio: ");

        empresa.retirarEnvio(numero, codigo);

        System.out.println("Envio retirado, regreso a bodega. Los ingresos no cambian");
        System.out.println(empresa.buscarDespacho(numero).toString());
    }

    /* 7. Hace salir el despacho y muestra los cargos por reintento que se generaron */
    private void salirDespacho() {
        int numero = leerEntero("Numero de despacho: ");
        double reintentosAntes = empresa.calcularIngresosReintentos();

        empresa.hacerSalirDespacho(numero);

        double cargos = empresa.calcularIngresosReintentos() - reintentosAntes;

        System.out.println("El despacho salio. Todos sus envios estan en ruta");
        System.out.println("Cargos por reintento generados: Q" + String.format("%,.2f", cargos));
        System.out.println(empresa.buscarDespacho(numero).toString());
    }

    /* 8. Pregunta el resultado de cada envio en ruta y despues los registra todos */
    private void registrarResultados() {
        int numero = leerEntero("Numero de despacho: ");
        Despacho despacho = empresa.buscarDespacho(numero);

        if (despacho == null) {
            System.out.println("Error: no existe el despacho #" + numero);
            return;
        }

        if (despacho.getEstado().equals(Despacho.EN_RUTA) == false) {
            System.out.println("Error: el despacho #" + numero + " no esta en ruta (estado: " + despacho.getEstado() + ")");
            return;
        }

        ArrayList<Envio> enRuta = new ArrayList<Envio>();
        ArrayList<Boolean> resultados = new ArrayList<Boolean>();
        ArrayList<Envio> envios = despacho.getEnvios();

        /* Primero se piden todas las respuestas, asi no queda un despacho a medias */
        for (int i = 0; i < envios.size(); i++) {
            if (envios.get(i).estaEnRuta() == true) {
                enRuta.add(envios.get(i));
                resultados.add(leerSiNo("El envio " + envios.get(i).getCodigo() + " fue entregado? (s/n): "));
            }
        }

        for (int i = 0; i < enRuta.size(); i++) {
            Envio envio = enRuta.get(i);
            empresa.registrarResultado(numero, envio.getCodigo(), resultados.get(i));

            System.out.println(envio.getCodigo() + " -> " + envio.getEstado() + " (intentos: " + envio.getIntentos() + " de " + envio.getMaxIntentos() + ")");
        }

        if (despacho.estaCerrado() == true) {
            System.out.println("Despacho #" + numero + " cerrado. El vehiculo " + despacho.getVehiculo().getPlaca() + " quedo libre");
        }
    }

    /* 9. Muestra todos los envios */
    private void consultarEnvios() {
        System.out.println(empresa.listarEnvios());
    }

    /* 10. Muestra todos los vehiculos */
    private void consultarVehiculos() {
        System.out.println(empresa.listarVehiculos());
    }

    /* 11. Muestra los reportes de envios, ingresos y despachos abiertos */
    private void mostrarReportes() {
        System.out.println(empresa.reporteEnviosPorCategoriaYEstado());
        System.out.println("");
        System.out.println("INGRESOS");
        System.out.println("Ingresos por registro: Q" + String.format("%,.2f", empresa.calcularIngresosRegistro()));
        System.out.println("Ingresos por reintentos: Q" + String.format("%,.2f", empresa.calcularIngresosReintentos()));
        System.out.println("Ingreso total: Q" + String.format("%,.2f", empresa.calcularIngresoTotal()));
        System.out.println("");
        System.out.println(empresa.reporteIngresosPorCategoria());
        System.out.println("");
        System.out.println(empresa.reporteDespachosAbiertos());
    }

    /* Lee un numero entero. Si el formato es incorrecto lo vuelve a pedir */
    private int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = scanner.nextLine().trim();

            try {
                return Integer.parseInt(texto);
            } catch (NumberFormatException error) {
                System.out.println("Eso no es un numero entero, intente de nuevo");
            }
        }
    }

    /* Lee un numero con decimales. Si el formato es incorrecto lo vuelve a pedir */
    private double leerDecimal(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = scanner.nextLine().trim();

            try {
                double numero = Double.parseDouble(texto);

                /* parseDouble acepta "NaN" e "Infinity", que no sirven como datos */
                if (Double.isNaN(numero) == false && Double.isInfinite(numero) == false) {
                    return numero;
                }
            } catch (NumberFormatException error) {
                /* Se avisa abajo */
            }

            System.out.println("Eso no es un numero valido, intente de nuevo");
        }
    }

    /* Lee un texto y no lo acepta vacio */
    private String leerTexto(String mensaje) {
        String texto = "";

        while (texto.length() == 0) {
            System.out.print(mensaje);
            texto = scanner.nextLine().trim();

            if (texto.length() == 0) {
                System.out.println("Este dato no puede quedar vacio, intente de nuevo");
            }
        }

        return texto;
    }

    /* Lee una respuesta de si o no. Solo acepta s o n */
    private boolean leerSiNo(String mensaje) {
        while (true) {
            String respuesta = leerTexto(mensaje);

            if (respuesta.equalsIgnoreCase("s") == true || respuesta.equalsIgnoreCase("si") == true) {
                return true;
            }

            if (respuesta.equalsIgnoreCase("n") == true || respuesta.equalsIgnoreCase("no") == true) {
                return false;
            }

            System.out.println("Responda s o n");
        }
    }
}
