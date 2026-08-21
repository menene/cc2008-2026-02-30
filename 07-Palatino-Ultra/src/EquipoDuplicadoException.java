public class EquipoDuplicadoException extends TorneoException {

    public EquipoDuplicadoException(String nombre) {
        super("El equipo \"" + nombre + "\" ya esta inscrito en el torneo.");
    }
}
