import java.util.ArrayList;

public class Torneo {
    private String nombre;
    private ArrayList<Equipo> equipos;

    public Torneo(String nombre) {
        this.nombre = nombre;
        this.equipos = new ArrayList<>();
    }

    public void agregarEquipo(Equipo nuevo) throws EquipoDuplicadoException {
        if (nuevo == null) {
            throw new IllegalArgumentException("No se puede agregar un equipo nulo.");
        }

        for (Equipo e : equipos) {
            if (e.coincideCon(nuevo.getNombre()) || e.coincideCon(nuevo.getAlias())) {
                throw new EquipoDuplicadoException(nuevo.getNombre());
            }
        }

        equipos.add(nuevo);
    }

    public Equipo eliminarEquipo(String texto) throws EquipoNoEncontradoException {
        Equipo encontrado = buscarEquipo(texto);
        equipos.remove(encontrado);
        renumerarLugares();
        return encontrado;
    }

    private void renumerarLugares() {
        for (int i = 0; i < equipos.size(); i++) {
            equipos.get(i).setLugar(i + 1);
        }
    }

    public Equipo buscarEquipo(String texto) throws EquipoNoEncontradoException {
        for (Equipo e : equipos) {
            if (e.coincideCon(texto)) {
                return e;
            }
        }
        throw new EquipoNoEncontradoException(texto);
    }

    public int cantidadEquipos() {
        return equipos.size();
    }

    public String listaEquipos() {
        if (equipos.isEmpty()) {
            return "El torneo no tiene equipos inscritos.";
        }

        String texto = "";
        for (int i = 0; i < equipos.size(); i++) {
            texto += (i + 1) + ". " + equipos.get(i).nombreCompleto();
            if (i < equipos.size() - 1) {
                texto += "\n";
            }
        }
        return texto;
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
                nombre, equipos.size(), totalGoles, totalTirosEsquina,
                totalTarjetasAmarillas, totalTarjetasRojas);
    }
}
