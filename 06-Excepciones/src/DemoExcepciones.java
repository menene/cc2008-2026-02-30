public class DemoExcepciones {

    public static void manejada() {
        System.out.println("\n--- 1. EXCEPCION MANEJADA ---");
        System.out.println("El error ocurre y se resuelve en este mismo metodo.");

        String[] entradas = { "150", "abc", "42" };

        for (String entrada : entradas) {
            System.out.println("\nConvirtiendo \"" + entrada + "\" a numero...");
            try {
                int numero = Integer.parseInt(entrada);
                System.out.println("  [ok] El doble de " + numero + " es " + (numero * 2));
            } catch (NumberFormatException e) {
                System.out.println("  [catch] " + e.getClass());
                System.out.println("  [catch] Mensaje: " + e.getMessage());
                System.out.println("  [catch] Se usara 0 en su lugar.");
            } finally {
                System.out.println("  [finally] Esto se ejecuta siempre, con error o sin error.");
            }
        }

        System.out.println("\nEl programa continua normalmente.");
    }

    public static void propagada() {
        System.out.println("\n--- 2. EXCEPCION PROPAGADA ---");
        System.out.println("La excepcion nace abajo y sube hasta quien la atrape.");
        System.out.println("Se muestran los dos casos: SIN throws y CON throws.");

        propagadaSinThrows();
        propagadaConThrows();
    }

    // ---------- Parte A: excepcion UNCHECKED, el throws es opcional ----------

    private static void propagadaSinThrows() {
        System.out.println("\n  PARTE A: ArithmeticException es UNCHECKED (extends RuntimeException).");
        System.out.println("  Cadena: propagada() -> nivelUno() -> nivelDos() -> nivelTres()");
        System.out.println("  Solo nivelTres lanza y solo propagada atrapa.");
        System.out.println("  NINGUN metodo declara throws y aun asi compila y propaga igual.\n");

        try {
            nivelUno();
        } catch (ArithmeticException e) {
            System.out.println("\n  [catch en propagada] " + e.getClass().getSimpleName()
                    + ": " + e.getMessage());
            System.out.println("  La excepcion nacio en nivelTres y subio hasta aqui.");
            System.out.println("  Recorrido (stack trace), del mas reciente al mas antiguo:");
            for (StackTraceElement linea : e.getStackTrace()) {
                System.out.println("      " + linea);
            }
        }
    }

    private static void nivelUno() {
        System.out.println("  nivelUno: llamo a nivelDos y NO atrapo nada.");
        nivelDos();
        System.out.println("  nivelUno: esta linea nunca se imprime.");
    }

    private static void nivelDos() {
        System.out.println("  nivelDos: llamo a nivelTres y NO atrapo nada.");
        nivelTres();
        System.out.println("  nivelDos: esta linea nunca se imprime.");
    }

    private static void nivelTres() {
        System.out.println("  nivelTres: aqui va a tronar (division entre cero).");
        int cero = 0;
        int resultado = 10 / cero;
        System.out.println("  nivelTres: resultado = " + resultado);
    }

    // ---------- Parte B: excepcion CHECKED, el throws es OBLIGATORIO ----------

    private static void propagadaConThrows() {
        System.out.println("\n  PARTE B: SaldoInsuficienteException es CHECKED (extends Exception).");
        System.out.println("  Cadena: propagada() -> cajeroUno() -> cajeroDos() -> cajeroTres()");
        System.out.println("  Solo cajeroTres lanza y solo propagada atrapa, igual que en la parte A.");
        System.out.println("  PERO los tres cajeros deben declarar 'throws SaldoInsuficienteException'.");
        System.out.println("  Si le borra el throws a cualquiera de ellos, el programa NO COMPILA.\n");

        try {
            cajeroUno();
        } catch (SaldoInsuficienteException e) {
            System.out.println("\n  [catch en propagada] " + e.getClass().getSimpleName()
                    + ": " + e.getMessage());
            System.out.printf("  Faltaban Q%.2f.%n", e.getFaltante());
            System.out.println("  Aqui muere la obligacion: propagada() la atrapo,");
            System.out.println("  por eso propagada() NO necesita declarar throws.");
            System.out.println("  Recorrido (stack trace), del mas reciente al mas antiguo:");
            for (StackTraceElement linea : e.getStackTrace()) {
                System.out.println("      " + linea);
            }
        }
    }

    private static void cajeroUno() throws SaldoInsuficienteException {
        System.out.println("  cajeroUno: llamo a cajeroDos y NO atrapo nada, solo declaro throws.");
        cajeroDos();
        System.out.println("  cajeroUno: esta linea nunca se imprime.");
    }

    private static void cajeroDos() throws SaldoInsuficienteException {
        System.out.println("  cajeroDos: llamo a cajeroTres y NO atrapo nada, solo declaro throws.");
        cajeroTres();
        System.out.println("  cajeroDos: esta linea nunca se imprime.");
    }

    private static void cajeroTres() throws SaldoInsuficienteException {
        CuentaBancaria cuenta = new CuentaBancaria("Alan Turing", 300.0);
        System.out.println("  cajeroTres: " + cuenta);
        System.out.println("  cajeroTres: aqui va a tronar (retiro de Q900.00).");
        cuenta.retirar(900.0);
        System.out.println("  cajeroTres: esta linea nunca se imprime.");
    }

    public static void personalizada() {
        System.out.println("\n--- 3. EXCEPCION PERSONALIZADA ---");

        CuentaBancaria cuenta = new CuentaBancaria("Ana Lopez", 500.0);
        System.out.println(cuenta);

        System.out.println("\nRetirando Q200.00...");
        try {
            cuenta.retirar(200.0);
            System.out.println("  [ok] Retiro exitoso. " + cuenta);
        } catch (SaldoInsuficienteException e) {
            System.out.println("  [catch] " + e.getMessage());
        }

        System.out.println("\nRetirando Q1000.00...");
        try {
            cuenta.retirar(1000.0);
            System.out.println("  [ok] Retiro exitoso. " + cuenta);
        } catch (SaldoInsuficienteException e) {
            System.out.println("  [catch] " + e.getClass().getSimpleName());
            System.out.println("  [catch] Mensaje: " + e.getMessage());
            System.out.printf("  [catch] Faltan Q%.2f para completar el retiro.%n", e.getFaltante());
        }

        System.out.println("\nRetirando Q-50.00...");
        try {
            cuenta.retirar(-50.0);
            System.out.println("  [ok] Retiro exitoso. " + cuenta);
        } catch (SaldoInsuficienteException e) {
            System.out.println("  [catch] " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("  [catch] " + e.getClass().getSimpleName());
            System.out.println("  [catch] Mensaje: " + e.getMessage());
        }

        System.out.println("\nEstado final -> " + cuenta);
    }

    public static void sinManejar() {
        System.out.println("\n--- 4. EXCEPCION SIN MANEJAR ---");
        System.out.println("Nadie la atrapa en el camino: sale de aqui, pasa por el menu");
        System.out.println("y aterriza en main. Observe como se corta todo.");
        System.out.println("Esta es la ultima linea de este metodo...");

        throw new IllegalStateException("Excepcion lanzada a proposito desde DemoExcepciones.sinManejar()");
    }
}
