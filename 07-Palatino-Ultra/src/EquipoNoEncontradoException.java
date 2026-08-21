public class EquipoNoEncontradoException extends TorneoException {

    public EquipoNoEncontradoException(String busqueda) {
        super("No existe ningun equipo con el nombre o alias \"" + busqueda + "\".");
    }
}
