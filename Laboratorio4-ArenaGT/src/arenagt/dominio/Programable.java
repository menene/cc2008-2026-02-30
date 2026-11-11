package arenagt.dominio;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

public interface Programable extends Comparable<Programable> {
    String getId();
    String getDescripcion();
    Set<Equipo> getEquiposOcupados();
    Optional<Programacion> getProgramacion();
    void programar(LocalDate fecha, int hora, String sede);

    @Override
    default int compareTo(Programable otro) {
        Optional<Programacion> a = getProgramacion();
        Optional<Programacion> b = otro.getProgramacion();
        if (a.isEmpty() || b.isEmpty()) {
            return Boolean.compare(a.isEmpty(), b.isEmpty());
        }
        Programacion primera = a.get(), segunda = b.get();
        int orden = primera.getFecha().compareTo(segunda.getFecha());
        if (orden == 0) orden = Integer.compare(primera.getHora(), segunda.getHora());
        if (orden == 0) orden = primera.getSede().compareTo(segunda.getSede());
        return orden;
    }
}
