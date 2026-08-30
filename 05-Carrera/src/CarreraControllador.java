public class CarreraControllador {
    VistaCarrera Vista = new VistaCarrera();
    Carrera c = new Carrera();

    public void inicio() {
        boolean continuar = true;
        while (continuar) {
            int opc = Vista.inicio();

            if (opc == 1) {
                int tiempo = Vista.Ingreso(" nuevo Tiempo");
                c.RegistrarTiempo(tiempo);

            } else if (opc == 2) {
                c.VerIntentos();

            } else if (opc == 3) {
                int indice = Vista.Ingreso("numero de intento a Revisar");
                c.VerIntento(indice);
            }else if(opc==4){
                int indice = Vista.Ingreso("nuemero de intento a Editar");
                int tiempo = Vista.Ingreso("Nuevo tiempo");
                c.EditarTiempo(indice-1, tiempo);
            }else if (opc == 5){
                c.Promedio();
            }else if (opc == 6){
                c.MostrarMejortiempo();
            }else if (opc == 7){
                c.Disponibles();
            }else if (opc == 8){
                continuar = false;
                Vista.toString("Vallase a dormir");// bueno terminamos, a mimir :D
            }

        }

    }
}
