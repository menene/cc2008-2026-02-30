public class ControladorTorneo {

    private Torneo torneo;
    private VistaTorneo vista = new VistaTorneo();

    public void iniciar() {
        sembrarEquipos();

        boolean continuar = true;

        while (continuar) {
            int opcion = vista.mostrarMenu();

            if (opcion == 1) {
                resumen();
            } else if (opcion == 2) {
                consultaEquipo();
            } else if (opcion == 0) {
                continuar = false;
            } else {
                System.out.println("Opcion invalida. Intentalo nuevamente");
            }
        }
    }

    private void sembrarEquipos() {
        Equipo[] equipos = {
            //          nombre        alias         lugar esq  gan per tirosGol goles amar roj faltas
            new Equipo("Barcelona",   "Barca",        1,  45,  18,  4,  210,   62,  30,  3,  180),
            new Equipo("Real Madrid", "Merengues",    2,  40,  17,  5,  205,   58,  28,  4,  175),
            new Equipo("Atletico",    "Colchoneros",  3,  35,  15,  7,  190,   44,  40,  6,  200),
            new Equipo("Sevilla",     "Sevillistas",  4,  30,  12, 10,  160,   33,  35,  5,  185),
            new Equipo("Valencia",    "Che",          5,  25,   9, 13,  140,   24,  42,  7,  195),
        };

        torneo = new Torneo("Torneo Palatino Plus", equipos);
    }

    private void resumen() {
        vista.resumen(torneo);
    }

    private void consultaEquipo() {
        String nombre = vista.leerNombreEquipo(torneo);

        // encontrar equipo

        
        vista.estadisticasEquipo(torneo, nombre);
    }
}
