public class Torneo {
    private String nombre;
    private Equipo[] equipos;

    public Torneo(String nombre, Equipo[] equipos) {
        this.nombre = nombre;
        this.equipos = equipos;
    }

    @Override
    public String toString() {
        int totalGoles = 0;
        int totalTirosEsquina = 0;
        int totalTarjetasAmarillas = 0;
        int totalTarjetasRojas = 0;

        for (Equipo e : equipos) {
            totalGoles += e.getGoles();
            totalTirosEsquina += e.getTirosEsquina();
            totalTarjetasAmarillas += e.getTarjetasAmarillas();
            totalTarjetasRojas += e.getTarjetasRojas();
        }

        return String.format(
                "Torneo: %s%n"
              + "Equipos participantes:       %d%n"
              + "Total de goles del torneo:   %d%n"
              + "Total de tiros de esquina:   %d%n"
              + "Total de tarjetas amarillas: %d%n"
              + "Total de tarjetas rojas:     %d",
                nombre, equipos.length, totalGoles, totalTirosEsquina,
                totalTarjetasAmarillas, totalTarjetasRojas);
    }

    public String resumen() {
        return toString();
    }

    public String listaEquipos() {
        String texto = "";
        for (int i = 0; i < equipos.length; i++) {
            texto += (i + 1) + ". " + equipos[i];
            if (i < equipos.length - 1) {
                texto += "\n";
            }
        }
        return texto;
    }

    public Equipo[] getEquipos() {
        return equipos;
    }

    public Equipo buscarEquipo(String nombre) {
        for (Equipo e : equipos) {
            if (e.coincideCon(nombre)) {
                return e;
            }
        }
        return null;
    }

    public String estadisticasEquipo(String nombre) {
        Equipo e = buscarEquipo(nombre);
        if (e == null) {
            return "No se encontro ningun equipo con ese nombre o alias.";
        }
        return e.resumen();
    }

    public void setNombre(String nombre) {
        // validaciones
        this.nombre = nombre;
    }
}
