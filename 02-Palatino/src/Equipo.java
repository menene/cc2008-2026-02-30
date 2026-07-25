public class Equipo {
    private String nombre;
    private int lugar;
    private int tirosEsquina;
    private int juegosGanados;
    private int juegosPerdidos;
    private int tirosAGol;
    private int goles;
    private int tarjetasAmarillas;
    private int tarjetasRojas;
    private int faltas;

    public Equipo(String nombre, int lugar, int tirosEsquina, int juegosGanados,
                  int juegosPerdidos, int tirosAGol, int goles,
                  int tarjetasAmarillas, int tarjetasRojas, int faltas) {
        this.nombre = nombre;
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

    public int getJuegosGanados() {
        return juegosGanados;
    }
    
    public int getJuegosPerdidos() {
        return juegosPerdidos;
    }
    
    public int getLugar() {
        return lugar;
    }

    public int getFaltas() {
        return faltas;
    }

    public int getTirosAGol() {
        return tirosAGol;
    }

    public String resumen() {
        return "----- ESTADISTICAS DE " + nombre + " -----\n"
             + "Puesto:             " + lugar + "\n"
             + "Juegos ganados:     " + juegosGanados + "\n"
             + "Juegos perdidos:    " + juegosPerdidos + "\n"
             + "Tiros a gol:        " + tirosAGol + "\n"
             + "Goles:              " + goles + "\n"
             + "Tiros de esquina:   " + tirosEsquina + "\n"
             + "Tarjetas amarillas: " + tarjetasAmarillas + "\n"
             + "Tarjetas rojas:     " + tarjetasRojas + "\n"
             + "Faltas:             " + faltas;

    }
}
