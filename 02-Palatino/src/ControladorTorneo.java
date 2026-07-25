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
                    System.out.println("Opcion invalida. Intentalo nuevamente");
            }

            // if (opcion == 1) {
            //     resumen();
            // } else if (opcion == 2) {
            //     consultaEquipo();
            // } else if (opcion == 0) {
            //     continuar = false;
            // } else {
            //     System.out.println("Opcion invalida. Intentalo nuevamente");
            // }

            // esto siempre se va a ejecutar aunque el usuario
            // seleccione 0
        }
    }

    private void registrarEquipos() {
        Equipo[] equipos = new Equipo[5];
        String nombre = vista.leerNombreTorneo();
        for (int i = 0; i < equipos.length; i++) {
            equipos[i] = vista.leerDatosEquipo();
        }
        torneo = new Torneo(nombre, equipos);
        // en lugar de leer datos de equipo uno por uno, use un for para que recorriera todos los equipos y sea mas escalable
    }

    private void resumen() {
        vista.resumen(torneo);
    }

    private void consultaEquipo() {
        int numero = vista.leerNumeroEquipo(torneo);
        vista.estadisticasEquipo(torneo, numero);
    }
}