public class SistemaAtletismo{

    private Atleta atletaActivo;
    private VistaConsola vista;

    public SistemaAtletismo(){

        vista = new VistaConsola();
    }

    private void crearAtleta(){

        String nombre = vista.solicitarNombre();
        int numero = vista.solicitarNumeroParticipante();
        int edad = vista.solicitarEdad();

        atletaActivo = new Atleta(nombre, numero, edad);

        vista.mostrarMensaje("Atleta añadido");
    }

    public void iniciar(){

        vista.mostrarMensaje("===== Torneo de Atletismo =====");

        crearAtleta();

        int opcion = 0;

        while (opcion != 9){

            opcion = vista.mostrarMenu();

            if (opcion != 9){

                procesarOpcion(opcion);
            }
        }

        vista.mostrarMensaje("Torneo finalizado");
    }

    private void registrarIntento(){

        double tiempo = vista.solicitarTiempo();
        boolean registrado = atletaActivo.registrarTiempo(tiempo);

        if(registrado){
            vista.mostrarMensaje("Intento registrado");
        } else{
            vista.mostrarMensaje("No se pudo registrar el intento");
        }
    }

    private void consultarTiempos(){

        int cantidad = atletaActivo.getCantidadIntentos();

        if(cantidad == 0){
            vista.mostrarMensaje("No hay intentos registrados");
            return;
        }

        for (int i = 1; i <= cantidad; i++){

            double tiempo = atletaActivo.consultarTiempo(i);

            vista.mostrarTiempo(i, tiempo);
        }
    
    }

    private void consultarIntento() {

        int numeroIntento = vista.solicitarNumeroIntento();
        double tiempo = atletaActivo.consultarTiempo(numeroIntento);

        if (tiempo == -1) {
        vista.mostrarMensaje("El intento indicado no existe.");
        } else {
        vista.mostrarTiempo(numeroIntento, tiempo);
        }
    }

    private void modificarTiempo(){

        int numeroIntento = vista.solicitarNumeroIntento();
        double nuevoTiempo = vista.solicitarTiempo();

        boolean modificado = atletaActivo.modificarTiempo(numeroIntento, nuevoTiempo);

        if(modificado) {
            vista.mostrarMensaje("Tiempo modificado");
        }else {
            vista.mostrarMensaje("No se pudo modificar el tiempo");
        }
    }

    private void mostrarPromedio(){

        double promedio = atletaActivo.calcularPromedio();

        if (promedio == -1){
            vista.mostrarMensaje("No hay intentos registrados");
        } else {
            vista.mostrarMensaje("Promedio " + promedio + " segundos");
        }
    }
    private void mostrarMejorYMayor() {

        double mejor = atletaActivo.obtenerMejorTiempo();
        double mayor = atletaActivo.obtenerMayorTiempo();

        if (mejor == -1) {
            vista.mostrarMensaje("No hay intentos registrados.");
        } else {
            vista.mostrarMensaje("Mejor tiempo: " + mejor + " segundos");
            vista.mostrarMensaje("Mayor tiempo: " + mayor + " segundos");
        }
    }

    private void mostrarIntentosDisponibles(){

        int realizados = atletaActivo.getCantidadIntentos();
        int disponibles = atletaActivo.obtenerIntentosDisponibles();

        vista.mostrarMensaje("Intentos realizados: " + realizados);
        vista.mostrarMensaje("Intentos disponibles: " + disponibles);
    }
    

    private void procesarOpcion(int opcion){

       

        switch (opcion) {

            case 1:
                crearAtleta();
                break;

            case 2:
                registrarIntento();
                break;

            case 3:
                consultarTiempos();
                break;

            case 4:
                consultarIntento();
                break;

            case 5:
                modificarTiempo();
                break;
            case 6:
                mostrarPromedio();
                break;

            case 7:
                mostrarMejorYMayor();
                break;

            case 8:
                mostrarIntentosDisponibles();
                break;

            default:
                vista.mostrarMensaje("Opción inválida.");
                break;
        
        
        }
        
    }

}