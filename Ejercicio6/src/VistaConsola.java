import java.util.List;

// Prepara textos para que Main los muestre en consola.
public class VistaConsola {
    public String obtenerMenu() {
        return "\n--- Menu de integraciones ---\n"
                + "1. Listar integraciones\n"
                + "2. Buscar integracion por ID\n"
                + "3. Ordenar por latencia\n"
                + "4. Consultar una referencia\n"
                + "5. Realizar un cobro\n"
                + "6. Solicitar un reintegro\n"
                + "7. Generar un documento\n"
                + "8. Consultar auditoria\n"
                + "0. Salir\n"
                + "Seleccione una opcion: ";
    }

    public String formatearListado(List<Integracion> integraciones) {
        if (integraciones == null || integraciones.isEmpty()) {
            return "No hay integraciones registradas.";
        }
        StringBuilder texto = new StringBuilder("--- Integraciones ---\n");
        for (Integracion integracion : integraciones) {
            texto.append(integracion).append('\n');
        }
        return texto.toString();
    }

    public String formatearConfiguracion(Integracion integracion) {
        if (integracion == null) {
            return "Integracion no encontrada.";
        }
        return "--- Configuracion de " + integracion.getNombre() + " ---\n"
                + "ID: " + integracion.getId() + "\n"
                + integracion.obtenerConfiguracion();
    }

    public String formatearResultado(ResultadoOperacion resultado) {
        if (resultado == null) {
            return "Resultado no disponible.";
        }
        switch (resultado) {
            case EXITOSO:
                return "Operacion simulada exitosa (sin conexion a una API real).";
            case RECHAZADO:
                return "Operacion rechazada.";
            case NO_SOPORTADO:
                return "Esta integracion no admite la operacion.";
            case INTEGRACION_NO_ENCONTRADA:
                return "Integracion no encontrada.";
            default:
                return "Resultado desconocido.";
        }
    }

    public String formatearResultado(String resultado) {
        if (resultado == null || resultado.trim().isEmpty()) {
            return "Resultado no disponible.";
        }
        return resultado;
    }
}
