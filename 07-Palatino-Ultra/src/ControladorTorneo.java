public class ControladorTorneo {

    private Torneo torneo;
    private VistaTorneo vista = new VistaTorneo();

    public void iniciar() {
        seed();

        boolean continuar = true;

        while (continuar) {
            int opcion = vista.mostrarMenu();

            if (opcion == 1) {
                resumen();
            } else if (opcion == 2) {
                consultaEquipo();
            } else if (opcion == 3) {
                agregarEquipo();
            } else if (opcion == 4) {
                eliminarEquipo();
            } else if (opcion == 5) {
                vista.listaEquipos(torneo);
            } else if (opcion == 0) {
                continuar = false;
                vista.mensaje("Hasta luego.");
            } else {
                vista.mensaje("Opcion invalida. Intentalo nuevamente");
            }
        }
    }

    private void seed() {
        torneo = new Torneo("Torneo Palatino Ultra");

        Equipo[] iniciales = {
            new Equipo("Barcelona",   "Barca",        1,  45,  18,  4,  210,   62,  30,  3,  180),
            new Equipo("Real Madrid", "Merengues",    2,  40,  17,  5,  205,   58,  28,  4,  175),
            new Equipo("Atletico",    "Colchoneros",  3,  35,  15,  7,  190,   44,  40,  6,  200),
            new Equipo("Sevilla",     "Sevillistas",  4,  30,  12, 10,  160,   33,  35,  5,  185),
            new Equipo("Valencia",    "Che",          5,  25,   9, 13,  140,   24,  42,  7,  195),
        };

        for (Equipo e : iniciales) {
            try {
                torneo.agregarEquipo(e);
            } catch (EquipoDuplicadoException ex) {
                vista.error("Equipo repetido en los datos iniciales: " + ex.getMessage());
            }
        }
    }

    private void resumen() {
        vista.resumen(torneo);
    }

    private void consultaEquipo() {
        String nombre = vista.leerNombreEquipo(torneo);

        try {
            vista.estadisticasEquipo(torneo.buscarEquipo(nombre));
        } catch (EquipoNoEncontradoException e) {
            vista.error(e.getMessage());
            vista.mensaje("  Revise la lista de equipos con la opcion 5.");
        }
    }

    private void agregarEquipo() {
        try {
            Equipo nuevo = vista.leerNuevoEquipo(torneo.cantidadEquipos() + 1);
            torneo.agregarEquipo(nuevo);

            vista.mensaje("\nEquipo agregado: " + nuevo.nombreCompleto());
            vista.mensaje("El torneo ahora tiene " + torneo.cantidadEquipos() + " equipos.");
        } catch (IllegalArgumentException e) {
            vista.error("Datos invalidos: " + e.getMessage());
            vista.mensaje("  El equipo NO se agrego al torneo.");
        } catch (EquipoDuplicadoException e) {
            vista.error(e.getMessage());
        }
    }

    private void eliminarEquipo() {
        if (torneo.cantidadEquipos() == 0) {
            vista.error("No hay equipos que eliminar.");
            return;
        }

        String nombre = vista.leerNombreEquipo(torneo);

        try {
            Equipo eliminado = torneo.eliminarEquipo(nombre);
            vista.mensaje("\nEquipo eliminado: " + eliminado.nombreCompleto());
            vista.mensaje("Quedan " + torneo.cantidadEquipos() + " equipos.");
        } catch (EquipoNoEncontradoException e) {
            vista.error(e.getMessage());
        }
    }
}
