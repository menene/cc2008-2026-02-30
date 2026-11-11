package arenagt.dominio;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

final class Agenda {
    private final Copa copa;
    private Programacion actual;

    Agenda(Copa copa) { this.copa = Objects.requireNonNull(copa, "Se requiere una copa."); }
    Optional<Programacion> getActual() { return Optional.ofNullable(actual); }

    void programar(Programable evento, LocalDate fecha, int hora, String sede) {
        Programacion candidata = new Programacion(fecha, hora, sede);
        copa.validarAgenda(evento, candidata);
        actual = candidata;
    }
}
