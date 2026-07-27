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

        int totalGoles = e1.getGoles() + e2.getGoles() + e3.getGoles() + e4.getGoles() + e5.getGoles();
        int totalTirosEsquina = e1.getTirosEsquina() + e2.getTirosEsquina() + e3.getTirosEsquina() + e4.getTirosEsquina() + e5.getTirosEsquina();
        int totalTarjetasAmarillas = e1.getTarjetasAmarillas() + e2.getTarjetasAmarillas() + e4.getTarjetasAmarillas() + e5.getTarjetasAmarillas();
        int totalTarjetasRojas = e1.getTarjetasRojas() + e2.getTarjetasRojas() + e3.getTarjetasRojas() + e4.getTarjetasRojas() + e5.getTarjetasRojas();

        String texto = "Torneo: " + nombre + "\n";
        texto += "Total de goles del torneo:   " + totalGoles + "\n";
        texto += "Total de tiros de esquina:   " + totalTirosEsquina + "\n";
        texto += "Total de tarjetas amarillas: " + totalTarjetasAmarillas + "\n";
        texto += "Total de tarjetas rojas:     " + totalTarjetasRojas;

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
        if (numero == 1) {
            return e1.resumen();
        }
        if (numero == 2) {
            return e2.resumen();
        }
        if (numero == 3) {
            return e3.resumen();
        }
        if (numero == 4) {
            return e4.resumen();
        }
        if (numero == 5) {
            return e5.resumen();
        }
        return "Numero de equipo invalido.";
    }

    public void setNombre(String nombre) {
        // validaciones
        this.nombre = nombre;
    }
}
