public class Vista {

    public void mostrarInicio() {

        System.out.println("==========================================");
        System.out.println("     FESTIVAL UNIVERSITARIO DE MUSICA");
        System.out.println("==========================================");
    }

    public void mostrarMenu(String nombreFestival) {

        System.out.println("\nFestival actual: " + nombreFestival);
        System.out.println("1. Nuevo festival");
        System.out.println("2. Configurar escenario");
        System.out.println("3. Consultar escenarios");
        System.out.println("4. Consultar un escenario");
        System.out.println("5. Modificar escenario");
        System.out.println("6. Retirar escenario");
        System.out.println("7. Registrar artista");
        System.out.println("8. Consultar artistas");
        System.out.println("9. Buscar artista");
        System.out.println("10. Modificar artista");
        System.out.println("11. Cancelar participacion");
        System.out.println("12. Mostrar reporte del festival");
        System.out.println("13. Salir");
    }

    public void solicitar(String mensaje) {

        System.out.print(mensaje);
    }

    public void mostrarMensaje(String mensaje) {

        System.out.println(mensaje);
    }

    public void mostrarEscenario(int posicion, Escenario escenario) {

        System.out.println("Posicion " + (posicion + 1) + ": " + escenario.toString());
    }

    public void mostrarArtista(Artista artista) {

        System.out.println(artista.toString());
    }

    public void mostrarReporte(String reporte) {

        System.out.println("\n=============== REPORTE ===============");
        System.out.println(reporte);
        System.out.println("=======================================");
    }

    public void mostrarFinOperacion() {

        System.out.println("Operacion finalizada.");
    }

    public void mostrarDespedida() {

        System.out.println("Programa finalizado.");
    }
}
