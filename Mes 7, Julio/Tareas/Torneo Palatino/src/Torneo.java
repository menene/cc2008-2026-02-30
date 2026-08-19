public class Torneo {
    private String nombre;
    private Equipo[] equipos;


    public Torneo(String nombre, Equipo[] equipos) {
        this.nombre = nombre;
        this.equipos = equipos;
    }

    public String resumen() {

        int totalGoles=0,totalTirosEsquina=0,totalTarjetasAmarillas=0,totalTarjetasRojas = 0;
        for(Equipo e: equipos){
            totalGoles += e.getGoles();
            totalTirosEsquina += e.getTirosEsquina();
            totalTarjetasAmarillas += e.getTarjetasAmarillas();
            totalTarjetasRojas += e.getTarjetasRojas();
        }

        String texto = "Torneo: " + nombre + "\n";
        texto += "Total de goles del torneo:   " + totalGoles + "\n";
        texto += "Total de tiros de esquina:   " + totalTirosEsquina + "\n";
        texto += "Total de tarjetas amarillas: " + totalTarjetasAmarillas + "\n";
        texto += "Total de tarjetas rojas:     " + totalTarjetasRojas;

        return texto;
    }

    public String listaEquipos() {
        String lista ="";
        for(int i = 0;i<equipos.length; i++){
            lista += (i+1)+". "+ equipos[i].getNombre()+"\n";
        }

        return lista;
    }

    public String estadisticasEquipo(int numero) {
        
       if(numero <= equipos.length && numero> 0){
         return equipos[numero-1].resumen();
       }
       return "Numero de equipo invalido.";
    }

    public void setNombre(String nombre) {
        // validaciones
        this.nombre = nombre;
    }
}
