package arenagt.dominio;

import java.time.LocalDate;

public final class Programacion {
    private final LocalDate fecha;
    private final int hora;
    private final String sede;

    public Programacion(LocalDate fecha, int hora, String sede) {
        if (fecha == null) throw new IllegalArgumentException("La fecha es obligatoria.");
        if (hora < 0 || hora > 23) throw new IllegalArgumentException("La hora debe estar entre 0 y 23.");
        this.fecha = fecha;
        this.hora = hora;
        this.sede = Texto.requerido(sede, "sede");
    }

    public LocalDate getFecha() { return fecha; }
    public int getHora() { return hora; }
    public String getSede() { return sede; }
}
