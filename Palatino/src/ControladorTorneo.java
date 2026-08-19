public class ControladorTorneo {

    private Torneo torneo;
    private VistaTorneo vista = new VistaTorneo();

    public void iniciar() {
        registrarEquipos();

        boolean continuar = true;

        while (continuar) {
            int opcion = vista.mostrarMenu();

            switch (opcion) {
                case 1:
                    resumen();
                    break;

                case 2:
                    consultaEquipo();
                    break;

                case 0:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción invalida. Inténtalo nuevamente");
            }
        }
    }

    private void registrarEquipos() {
        String nombre = vista.leerNombreTorneo();

        Equipo e1 = vista.leerDatosEquipo();
        Equipo e2 = vista.leerDatosEquipo();
        Equipo e3 = vista.leerDatosEquipo();
        Equipo e4 = vista.leerDatosEquipo();
        Equipo e5 = vista.leerDatosEquipo();

        torneo = new Torneo(nombre, e1, e2, e3, e4, e5);
    }

    private void resumen() {
        vista.resumen(torneo);
    }

    private void consultaEquipo() {
        int numero = vista.leerNumeroEquipo(torneo);
        vista.estadisticasEquipo(torneo, numero);
    }
}