// CC2008 - Ejercicio 6: Polimorfismo via Interfaces.
// Prototipo educativo: operaciones simuladas, sin llamadas de red.
package inicializacion;


import modelo.*;

/** Carga exactamente las diez instancias propuestas en la tabla 1.5 del Word. */
public class InicializadorIntegraciones {
    public static void cargar(CatalogoIntegraciones catalogo) {
        if (catalogo == null || catalogo.cantidad() != 0) {
            throw new IllegalArgumentException("La carga inicial requiere un catálogo vacío.");
        }
        catalogo.agregar(new PasarelaTarjeta("PAG-001", "Tarjeta Alfa",
                "https://pag-001.example.test/api", "OAuth2 (simulado)", 5000, 120, true, true));
        catalogo.agregar(new PasarelaTarjeta("PAG-002", "Tarjeta Beta",
                "https://pag-002.example.test/api", "OAuth2 (simulado)", 5000, 95, true, true));
        catalogo.agregar(new PasarelaTransferencia("PAG-003", "Transferencia Uno",
                "https://pag-003.example.test/api", "OAuth2 (simulado)", 5000, 180, true, true));
        catalogo.agregar(new BilleteraDigital("PAG-004", "Billetera Río",
                "https://pag-004.example.test/api", "OAuth2 (simulado)", 5000, 75, true, true));
        catalogo.agregar(new BilleteraDigital("PAG-005", "Billetera Sur",
                "https://pag-005.example.test/api", "OAuth2 (simulado)", 5000, 90, true, true));
        catalogo.agregar(new ProveedorLogistico("LOG-001", "Envíos Express",
                "https://log-001.example.test/api", "OAuth2 (simulado)", 5000, 245, true, true));
        catalogo.agregar(new ProveedorLogistico("LOG-002", "Logística Central",
                "https://log-002.example.test/api", "OAuth2 (simulado)", 5000, 210, true, false));
        catalogo.agregar(new ServicioRastreo("CON-001", "Seguimiento Global",
                "https://con-001.example.test/api", "OAuth2 (simulado)", 5000, 160, true, true));
        catalogo.agregar(new CertificadorFEL("FEL-001", "FEL Uno",
                "https://fel-001.example.test/api", "OAuth2 (simulado)", 5000, 300, true, true));
        catalogo.agregar(new CertificadorFEL("FEL-002", "FEL Dos",
                "https://fel-002.example.test/api", "OAuth2 (simulado)", 5000, 285, true, true));
    }
}
