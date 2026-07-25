public class Torneo {
    private String nombre;
    //private Equipo e1, e2, e3;
    private Equipo[] equipos;
    // aqui lo hice en una lista para que sea mas escalable


    public Torneo(String nombre, Equipo[] equipos) {
        this.nombre = nombre;
        this.equipos = equipos;
    }

    public String resumen() {

        int totalGoles = 0;
        int totalTirosEsquina = 0;
        int totalTarjetasAmarillas = 0;
        int totalTarjetasRojas = 0;

        for (Equipo e: equipos) {
            totalGoles += e.getGoles();
            totalTirosEsquina += e.getTirosEsquina();
            totalTarjetasAmarillas += e.getTarjetasAmarillas();
            totalTarjetasRojas += e.getTarjetasRojas();
        }

        // int totalGoles = e1.getGoles() + e2.getGoles() + e3.getGoles();
        // int totalTirosEsquina = e1.getTirosEsquina() + e2.getTirosEsquina();
        // int totalTarjetasAmarillas = e1.getTarjetasAmarillas() + e2.getTarjetasAmarillas();
        // int totalTarjetasRojas = e1.getTarjetasRojas() + e2.getTarjetasRojas();

        // aqui en lugar de hacerlo uno por uno use la lista para hacerlo mas sencillo con un for each

        String texto = "Torneo: " + nombre + "\n";
        texto += "Total de goles del torneo:   " + totalGoles + "\n";
        texto += "Total de tiros de esquina:   " + totalTirosEsquina + "\n";
        texto += "Total de tarjetas amarillas: " + totalTarjetasAmarillas + "\n";
        texto += "Total de tarjetas rojas:     " + totalTarjetasRojas;

        return texto;
    }

    public String listaEquipos() {
        String texto = "";
        for (int i = 0; i < equipos.length; i++) {
            texto += (i + 1) + ". " +equipos[i].getNombre() + "\n";
            // en lugar de escribir cada equipo uno por uno, el for recorre todos los equipos de la lista
        }
        return texto;
    }

    public String estadisticasEquipo(int numero) {
        if (numero >= 1 && numero <= equipos.length) {
            return equipos[numero - 1].resumen();
        } else {
            return "Numero de equipo invalido.";
        }
        
    }
    
    public void setNombre(String nombre) {
        // validaciones
        this.nombre = nombre;
    }
}