public class Torneo {
    private String nombre;
    private Equipo e1, e2, e3, e4, e5;

    public Torneo(String nombre, Equipo e1, Equipo e2, Equipo e3, Equipo e4, Equipo e5) {
        this.nombre = nombre;
        this.e1 = e1;
        this.e2 = e2;
        this.e3 = e3;
        this.e4 = e4;
        this.e5 = e5;
    }

    public String resumen() {
        Equipo[] equipos = {e1, e2, e3, e4, e5};

        int totalGoles = 0;
        int totalTirosEsquina = 0;
        int totalTarjetasAmarillas = 0;
        int totalTarjetasRojas = 0;

        for (Equipo e : equipos) {
            totalGoles += e.getGoles();
            totalTirosEsquina += e.getTirosEsquina();
            totalTarjetasAmarillas += e.getTarjetasAmarillas();
            totalTarjetasRojas += e.getTarjetasRojas();
        }

        String texto = "Torneo: " + nombre + "\n";
        texto += "Total de goles del torneo: " + totalGoles + "\n";
        texto += "Total de tiros de esquina: " + totalTirosEsquina + "\n";
        texto += "Total de tarjetas amarillas: " + totalTarjetasAmarillas + "\n";
        texto += "Total de tarjetas rojas: " + totalTarjetasRojas;

        return texto;
    }

    public String listaEquipos() {
        return "1. " + e1.getNombre() + "\n"
             + "2. " + e2.getNombre() + "\n"
             + "3. " + e3.getNombre() + "\n"
             + "4. " + e4.getNombre() + "\n"
             + "5. " + e5.getNombre();
    }

    public String estadisticasEquipo(int numero) {
        switch (numero) {
            case 1: return e1.resumen();
            case 2: return e2.resumen();
            case 3: return e3.resumen();
            case 4: return e4.resumen();
            case 5: return e5.resumen();
            default: return "Numero de equipo invalido.";
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}