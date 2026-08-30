public class ControladorAtleta {
    private Atleta atleta;
    private VistaAtleta vista;
    private boolean ejecutar;

    public ControladorAtleta(){
        vista = new VistaAtleta();
        ejecutar = true;
    }
    public void iniciar(){
        while (ejecutar){
            vista.mostrarMenu();
            int opcion =  vista.solicitarOpcion();
            procesarOpcion(opcion);
        }
    }
    private void procesarOpcion(int opcion){
        switch(opcion){
            case 1:
                agregarAtleta();
                break;
            case 2:
                registrarIntento();
                break;
            case 3:
                mostrarTiempos();
                break;
            case 4:
                modificarIntento();
                break;
            case 5:
                mostrarPromedio();
                break;
            case 6:
                mostrarMejorTiempo();
                break;
            case 7:
                mostrarMayorTiempo();
                break;
            case 8:
                mostrarIntentosDisponibles();
                break;
            case 9:
                salir();
                break;
            default:
                vista.MostrarMensaje("Opcion no valida");
        }
    }
    private void registrarIntento(){
        double tiempo= vista.solicitarTiempo();
        boolean registrado = atleta.getControlTiempos().registrarIntento(tiempo);
        if (registrado){
            vista.MostrarMensaje("Intento registrado correctamente");
        } else {
            vista.MostrarMensaje("No se pudo registrar el intento, Verifica los intentos disponibles");
        }
    }
    private void mostrarTiempos(){
        int cantidad = atleta.getControlTiempos().getCantidadIntentos();
        if (cantidad == 0){
            vista.MostrarMensaje("No hay intentos registrados");
            return ;
        }
        for (int i=1; i<=cantidad; i++){
            double tiempo = atleta.getControlTiempos().obtenerTiempo(i);
            vista.mostrarTiempo(i, tiempo);
        }
    }
    private void modificarIntento(){
        int numeroIntento = vista.solicitarNumeroIntento();
        double nuevoTiempo = vista.solicitarTiempo();
        boolean modificado = atleta.getControlTiempos().modificarTiempo(numeroIntento, nuevoTiempo);
        if(modificado){
            vista.MostrarMensaje("Tiempo modificado correctamente");
        } else {
            vista.MostrarMensaje("No se pudo modificar el tiempo, que tiempo quieres modificar");
        }
    }
    private void mostrarPromedio(){
        if (atleta.getControlTiempos().getCantidadIntentos()==0){
            vista.MostrarMensaje("No hay tiempos registrados");
            return ;
        } else {
            double promedio = atleta.getControlTiempos().calcularPromedio();
            vista.MostrarMensaje("Promedio: "+ promedio);
        }
    }
    private void mostrarMejorTiempo(){
        if (atleta.getControlTiempos().getCantidadIntentos() == 0){
            vista.MostrarMensaje("No hay tiempos registrados");
            return;
        } else {
            double mejorTiempo = atleta.getControlTiempos().obtenerMejorTiempo();
            vista.mostrarResultado("Mejor tiempo:", mejorTiempo);
        }
    }
    private void mostrarMayorTiempo(){
        if (atleta.getControlTiempos().getCantidadIntentos()==0){
            vista.MostrarMensaje("No hay tiempos registrados");
            return;
        } else {
            double mayorTiempo = atleta.getControlTiempos().obtenerMayorTiempo();
            vista.MostrarMensaje("Mayor tiempo: "+mayorTiempo);
        }
    }
    private void mostrarIntentosDisponibles(){
        int disponibles = atleta.getControlTiempos().obtenerIntentosDisponibles();
        vista.MostrarMensaje("Tienes: "+ disponibles+ " intentos disponibles");
    }
    private void agregarAtleta(){
        String nombre = vista.solicitarNombre();
        int numeroParticipante = vista.solicitarNumeroParticipante();
        int edad = vista.solicitarEdad();
        atleta = new Atleta(nombre, numeroParticipante, edad);
        vista.MostrarMensaje("Atleta agregado correctamente");
    }
    private void salir(){
        ejecutar= false;
        vista.MostrarMensaje("Adios");
    }
}