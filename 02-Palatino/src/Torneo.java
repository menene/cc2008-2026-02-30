public class Torneo {
    private String nombre;
    private EquipoPokemon e1, e2, e3, e4, e5;


    public Torneo(String nombre, EquipoPokemon e1, EquipoPokemon e2, EquipoPokemon e3, EquipoPokemon e4, EquipoPokemon e5) {
        this.nombre = nombre;
        this.e1 = e1;
        this.e2 = e2;
        this.e3 = e3;
        this.e4 = e4;
        this.e5 = e5;
    }

    public String resumen() {

        int totalGoles = e1.getGoles() + e2.getGoles() + e3.getGoles() + e4.getGoles() + e5.getGoles();
        int totalTirosEsquina = e1.getTirosEsquina() + e2.getTirosEsquina()+ e4.getGoles()+ e5.getGoles();
        int totalTarjetasAmarillas = e1.getTarjetasAmarillas() + e2.getTarjetasAmarillas() + e3.getGoles() + e4.getGoles() + e5.getGoles();
        int totalTarjetasRojas = e1.getTarjetasRojas() + e2.getTarjetasRojas()+ e3.getGoles() + e4.getGoles() + e5.getGoles() ;

        String texto = "Torneo: " + nombre + "\n";
        texto += "Total de goles del torneo:   " + totalGoles + "\n";
        texto += "Total de tiros de esquina:   " + totalTirosEsquina + "\n";
        texto += "Total de tarjetas amarillas: " + totalTarjetasAmarillas + "\n";
        texto += "Total de tarjetas rojas:     " + totalTarjetasRojas;

        return texto;
    }

    public String listaEquipos() {
        return "1. " + e1.getNombre() + "\n"
             + "2. " + e2.getNombre()+ "\n"
             + "3. " + e3.getNombre()+ "\n"
             + "4. " + e4.getNombre()+ "\n"
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
        if (numero ==5) {
            return e5.resumen();
        }
        return "Numero de equipo invalido.";
    }

    public void setNombre(String nombre) {
        // validaciones
        this.nombre = nombre;
    }
}
