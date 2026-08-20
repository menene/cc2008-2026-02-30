public class VistaResultados {

    public void mostrarTiempos(double[] tiempos) {
        if (tiempos.length == 0) {
            System.out.println("Todavía no hay tiempos registrados.");
            return;
        }

        System.out.println("Tiempos registrados:");
        for (int i = 0; i < tiempos.length; i++) {
            System.out.println("Intento " + (i + 1) + ": " + tiempos[i] + " s");
        }
    }

    // Muestra el resumen completo
    public void mostrarResumen(double promedio, double mejor, double peor, int disponibles){
        System.out.println("Promedio: " + promedio + " s");
        System.out.println("Mejor tiempo: " + mejor + " s");
        System.out.println("Peor tiempo: " + peor + " s");
        System.out.println("Intentos disponibles: " + disponibles);
    }

    // Mensaje genérico
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}