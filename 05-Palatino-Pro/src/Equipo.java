public class Equipo {
    private String nombre;
    private String alias;
    private int lugar;
    private int tirosEsquina;
    private int juegosGanados;
    private int juegosPerdidos;
    private int tirosAGol;
    private int goles;
    private int tarjetasAmarillas;
    private int tarjetasRojas;
    private int faltas;

    public Equipo(String nombre, String alias, int lugar, int tirosEsquina, int juegosGanados,
                  int juegosPerdidos, int tirosAGol, int goles,
                  int tarjetasAmarillas, int tarjetasRojas, int faltas) {
        this.nombre = nombre;
        this.alias = alias;
        this.lugar = lugar;
        this.tirosEsquina = tirosEsquina;
        this.juegosGanados = juegosGanados;
        this.juegosPerdidos = juegosPerdidos;
        this.tirosAGol = tirosAGol;
        this.goles = goles;
        this.tarjetasAmarillas = tarjetasAmarillas;
        this.tarjetasRojas = tarjetasRojas;
        this.faltas = faltas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAlias() {
        return alias;
    }

    public int getGoles() {
        return goles;
    }

    public int getTirosEsquina() {
        return tirosEsquina;
    }

    public int getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }

    public int getTarjetasRojas() {
        return tarjetasRojas;
    }

    public boolean coincideCon(String texto) {
        return nombre.equalsIgnoreCase(texto) || alias.equalsIgnoreCase(texto);
    }

    public double efectividad() {
        if (tirosAGol == 0) {
            return 0.0;
        }
        double porcentaje = (double) goles / tirosAGol * 100;
        double redondeado = Math.round(porcentaje * 10.0) / 10.0;
        return Math.min(100.0, redondeado);
    }

    public NivelRendimiento nivel() {
        return NivelRendimiento.clasificar(efectividad());
    }

    @Override
    public String toString() {
        return nombre + " (" + alias + ")";
    }

    public String resumen() {
        return String.format(
                "----- ESTADISTICAS DE %s (%s) -----%n"
              + "Lugar:              %d%n"
              + "Goles:              %d%n"
              + "Tiros a gol:        %d%n"
              + "Efectividad:        %.1f%%  [%s]%n"
              + "Tiros de esquina:   %d%n"
              + "Tarjetas amarillas: %d%n"
              + "Tarjetas rojas:     %d",
                nombre, alias, lugar, goles, tirosAGol, efectividad(), nivel(),
                tirosEsquina, tarjetasAmarillas, tarjetasRojas);
    }
}
