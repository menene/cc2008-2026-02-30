package arenagt.dominio;

import java.util.*;

public final class Copa implements Iterable<Programable> {
    private final Map<String, Equipo> equipos = new LinkedHashMap<>();
    private final Map<String, Programable> eventos = new LinkedHashMap<>();
    private final Map<String, Puntuable> puntuables = new HashMap<>();

    public Equipo registrarEquipo(String codigo, String nombre, String empresa) {
        Equipo nuevo = new Equipo(codigo, nombre, empresa);
        if (equipos.putIfAbsent(nuevo.getCodigo(), nuevo) != null) {
            throw new IllegalArgumentException("Código de equipo repetido: " + nuevo.getCodigo());
        }
        return nuevo;
    }

    private String validarId(String id) {
        String clave = Texto.requerido(id, "id de evento");
        if (eventos.containsKey(clave)) throw new IllegalArgumentException("Id de evento repetido: " + clave);
        return clave;
    }

    private Equipo buscarEquipo(String codigo) {
        Equipo equipo = equipos.get(Texto.requerido(codigo, "código"));
        if (equipo == null) throw new IllegalArgumentException("Equipo desconocido: " + codigo);
        return equipo;
    }

    public FutbolSala crearFutbolSala(String id, String codA, String codB) {
        return guardar(new FutbolSala(validarId(id), buscarEquipo(codA), buscarEquipo(codB), this));
    }

    public Baloncesto crearBaloncesto(String id, String codA, String codB) {
        return guardar(new Baloncesto(validarId(id), buscarEquipo(codA), buscarEquipo(codB), this));
    }

    private <T extends Encuentro> T guardar(T encuentro) {
        eventos.put(encuentro.getId(), encuentro);
        puntuables.put(encuentro.getId(), encuentro);
        return encuentro;
    }

    public Exhibicion crearExhibicion(String id, String titulo) {
        Exhibicion nueva = new Exhibicion(validarId(id), titulo, this);
        eventos.put(nueva.getId(), nueva);
        return nueva;
    }

    public Programable buscarEvento(String id) {
        Programable evento = eventos.get(Texto.requerido(id, "id de evento"));
        if (evento == null) throw new IllegalArgumentException("Evento desconocido: " + id);
        return evento;
    }

    public Puntuable buscarPuntuable(String id) {
        Programable evento = buscarEvento(id);
        Puntuable puntuable = puntuables.get(evento.getId());
        if (puntuable == null) throw new IllegalArgumentException("Este evento no admite resultados.");
        return puntuable;
    }

    void validarAgenda(Programable evento, Programacion candidata) {
        if (eventos.get(evento.getId()) != evento) throw new IllegalArgumentException("Evento ajeno a la copa.");
        for (Programable otro : eventos.values()) {
            if (otro == evento || otro.getProgramacion().isEmpty()) continue;
            Programacion reserva = otro.getProgramacion().get();
            if (!reserva.getFecha().equals(candidata.getFecha()) || reserva.getHora() != candidata.getHora()) continue;
            if (reserva.getSede().equals(candidata.getSede())) {
                throw new IllegalArgumentException("Sede ocupada por " + otro.getId() + ".");
            }
            if (!Collections.disjoint(evento.getEquiposOcupados(), otro.getEquiposOcupados())) {
                throw new IllegalArgumentException("Un equipo ya juega a esa hora en " + otro.getId() + ".");
            }
        }
    }

    public List<Equipo> getTabla() {
        return equipos.values().stream().sorted().toList();
    }

    @Override
    public Iterator<Programable> iterator() {
        return eventos.values().stream().filter(e -> e.getProgramacion().isPresent()).sorted().toList().iterator();
    }
}
