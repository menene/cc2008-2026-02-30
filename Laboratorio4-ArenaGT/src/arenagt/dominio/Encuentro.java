package arenagt.dominio;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

public abstract class Encuentro implements Programable, Puntuable {
    private final String id;
    private final Equipo equipoA;
    private final Equipo equipoB;
    private final Agenda agenda;
    private Integer marcadorA;
    private Integer marcadorB;

    Encuentro(String id, Equipo a, Equipo b, Copa copa) {
        this.id = Texto.requerido(id, "id");
        if (a == null || b == null || a == b) {
            throw new IllegalArgumentException("El encuentro requiere dos equipos distintos.");
        }
        equipoA = a;
        equipoB = b;
        agenda = new Agenda(copa);
    }

    public String getId() { return id; }
    public Set<Equipo> getEquiposOcupados() { return Set.of(equipoA, equipoB); }
    public Optional<Programacion> getProgramacion() { return agenda.getActual(); }
    public Optional<Integer> getMarcadorA() { return Optional.ofNullable(marcadorA); }
    public Optional<Integer> getMarcadorB() { return Optional.ofNullable(marcadorB); }

    public EstadoEncuentro getEstado() {
        if (marcadorA != null) return EstadoEncuentro.FINALIZADO;
        return getProgramacion().isPresent() ? EstadoEncuentro.PROGRAMADO : EstadoEncuentro.SIN_PROGRAMAR;
    }

    public String getDescripcion() {
        String resultado = marcadorA == null ? "" : " (" + marcadorA + "–" + marcadorB + ")";
        return getDeporte() + " | " + equipoA.getNombre() + " vs. " + equipoB.getNombre() + resultado;
    }

    public final void programar(LocalDate fecha, int hora, String sede) {
        if (getEstado() == EstadoEncuentro.FINALIZADO) {
            throw new IllegalStateException("Un encuentro finalizado no se puede reprogramar.");
        }
        agenda.programar(this, fecha, hora, sede);
    }

    public final void registrarResultado(int a, int b) {
        if (getEstado() == EstadoEncuentro.FINALIZADO) throw new IllegalStateException("El encuentro ya está finalizado.");
        if (getEstado() == EstadoEncuentro.SIN_PROGRAMAR) throw new IllegalStateException("Primero debe programar el encuentro.");
        if (a < 0 || b < 0) throw new IllegalArgumentException("Los marcadores deben ser enteros no negativos.");
        validarDeporte(a, b);
        int puntosA = puntosPara(a, b);
        int puntosB = puntosPara(b, a);
        validarAcumulado(equipoA, puntosA);
        validarAcumulado(equipoB, puntosB);
        equipoA.acumular(puntosA);
        equipoB.acumular(puntosB);
        marcadorA = a;
        marcadorB = b;
    }

    private static void validarAcumulado(Equipo equipo, int puntos) {
        if (puntos < 0 || puntos > Integer.MAX_VALUE - equipo.getPuntosTabla()) {
            throw new IllegalArgumentException("Los puntos exceden el rango permitido.");
        }
    }

    protected abstract void validarDeporte(int a, int b);
    protected abstract int puntosPara(int favor, int contra);
    protected abstract String getDeporte();
}
