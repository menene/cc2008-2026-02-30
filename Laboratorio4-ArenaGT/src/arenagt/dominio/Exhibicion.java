package arenagt.dominio;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

public final class Exhibicion implements Programable {
    private final String id;
    private final String titulo;
    private final Agenda agenda;

    Exhibicion(String id, String titulo, Copa copa) {
        this.id = Texto.requerido(id, "id");
        this.titulo = Texto.requerido(titulo, "título");
        agenda = new Agenda(copa);
    }

    public String getId() { return id; }
    public String getDescripcion() { return titulo; }
    public Set<Equipo> getEquiposOcupados() { return Set.of(); }
    public Optional<Programacion> getProgramacion() { return agenda.getActual(); }
    public EstadoExhibicion getEstado() {
        return getProgramacion().isPresent() ? EstadoExhibicion.PROGRAMADA : EstadoExhibicion.SIN_PROGRAMAR;
    }

    public void programar(LocalDate fecha, int hora, String sede) {
        agenda.programar(this, fecha, hora, sede);
    }
}
