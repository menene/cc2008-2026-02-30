public class ControladorTorneo{

    // atributos

    Torneo torneo;
    ControladorAtleta controladorAtleta;
    VistaTorneo vista;
    
    // métodos
    
    // constructor: crea el Torneo, el ControladorAtleta y la VistaTorneo
    public ControladorTorneo(){
        this.torneo = new Torneo("Carrera UVG");
        this.controladorAtleta = new ControladorAtleta();
        this.vista = new VistaTorneo();
    }
    
    // iniciar el programa, contiene todos los metodos para llamarlos en el momento indicado
    public void iniciar(){

        boolean continuar = true;
        int opcion;

        while(continuar){
            vista.mostrarBiembenida();
            opcion = vista.leerOpcion();

            if (opcion == 1) {
                registrarNuevoAtleta();
            }
            else if (opcion > 1 && opcion < 9){
                boolean permitir = hayAtletaActivo();
                
                if (permitir == true){
                    if (opcion == 2) {
                        registrarIntento();
                    } 
                    else if (opcion == 3) {
                        consultarTiempo();
                    } 
                    else if (opcion == 4){
                        consultarIntentoEspecifico();
                    }
                    else if (opcion == 5){
                        modificarTiempo();
                    }
                    else if (opcion == 6) {
                        mostrarPromedio();
                    }
                    else if (opcion == 7) {
                        mostrarMejorYPeorIntento();
                    }
                    else if (opcion == 8) {
                        mostrarIntentosDisponibles();
                    }
                }
                else{
                    vista.mostrarMensaje("Primero registre un atleta por favor");
                }
            }

            else if (opcion == 9) {
                continuar = false;
                vista.mostrarMensaje("Gracias por utilizar el programa, hasta la próxima");
            }
            else{
                vista.mostrarMensaje("El numero que ingreso no corresponde al menú, intentolo de nuevo");
            }
        }
    }

    // pide a la vista nombre, numero de participante y edad; crea un Atleta y lo guarda en torneo
    public void registrarNuevoAtleta(){
        vista.mostrarMensaje("Ingresa los datos para registar al nuevo atleta: ");

        String nombre = vista.leerTexto("Ingresa el nombre del atleta: ");
        int noParticipante = vista.leerEntero("Ingresa el número de participante: ");
        int edad = vista.leerEntero("Ingresa la edad del participante");

        Atleta atletaActivo = new Atleta(nombre, noParticipante, edad);
        torneo.setAtletaActivo(atletaActivo);
        vista.mostrarMensaje("Atleta registrado correctamente, te invitamos a registrar sus intetnos");
    }

    // pide el tiempo a la vista; valida que sea mayor que 0; si es valido lo pasa a controladorAtleta
    public void registrarIntento(){
        int intento = vista.leerEntero("Cual es el tiempo en segundos a registrar");

        if(intento > 0){
            boolean registrado = controladorAtleta.registrarIntentos(torneo.atletaActivo.getIntentos(), intento);

            if (registrado == true){
                vista.mostrarMensaje("Intento registrado correctamente");
            }
            else{
                vista.mostrarMensaje("No se pudo completar el registro porque los intentos ya estan completos, intente modificar un intento");
            }
        }
        else{
            vista.mostrarMensaje("No es valido registrar un tiempo igual o menor a 0 segundos, intentelo de nuevo");
        }

    }

    // obtiene de controladorAtleta los tiempos registrados y los envia a la vista
    public void consultarTiempo(){
        int[] intentosValidos = controladorAtleta.intentosRealizados(torneo.atletaActivo.getIntentos());
        if (intentosValidos.length == 0){
            vista.mostrarMensaje("Aún no ha registrado intentos");
        }
        else{
            vista.mostrarIntentos(intentosValidos);
        }
    }
    
    // pide el numero de intento (valida rango 1-10), llama a controladorAtleta y envia el resultado a la vista
    public void consultarIntentoEspecifico(){
        int numeroIntentoConsultar = vista.leerEntero("Ingrese el número de intento que desea consultar");
        
        if(numeroIntentoConsultar > 0 && numeroIntentoConsultar <= 10){
            int tiempo = controladorAtleta.mostrarIntento(torneo.atletaActivo.getIntentos(), numeroIntentoConsultar);

            if ( tiempo == -1 ){
                vista.mostrarMensaje("El intento que desea consultar aún no ha sido registrado");
            }
            else{
                vista.mostrarIntentoEspecifico(numeroIntentoConsultar, tiempo);
            }
        }

        else{
            vista.mostrarMensaje("El intento a consular debe corresponder a un número entre 1 y 10");
        }
    }

    // pide numero de intento y nuevo tiempo; valida que el nuevo tiempo sea mayor que 0; llama a controladorAtleta
    public void modificarTiempo(){
        int numeroIntentoModificar = vista.leerEntero("Ingresa el número de intento a modificar");

        if (numeroIntentoModificar > 0 && numeroIntentoModificar <= 10){
            int[] intentos = torneo.atletaActivo.getIntentos();

            if (intentos[numeroIntentoModificar - 1] != 0){
                int nuevoTiempo = vista.leerEntero("Ingrese el nuevo tiempo");

                if (nuevoTiempo != 0){
                    controladorAtleta.modificarIntento(intentos, numeroIntentoModificar, nuevoTiempo);
                    vista.mostrarMensaje("Intento modificado correctamente");

                }
                else{
                    vista.mostrarMensaje("No es valido registrar un nuevo tiempo igual o menor a 0 segundos, intentelo de nuevo");
                }
            }
            else{
                vista.mostrarMensaje("Este intento no puede ser moficado porque aún no se a registrado");
            }
        }
        else{
            vista.mostrarMensaje("El intento a modificar debe corresponder a un número entre 1 y 10");
        }

    }
    

    // llama a controladorAtleta y envia el resultado a la vista
    public void mostrarPromedio(){
        int promedio = controladorAtleta.calcularPromedo(controladorAtleta.intentosRealizados(torneo.atletaActivo.getIntentos()));
        
        if(promedio == 0){
            vista.mostrarMensaje("No se han registrado intentos aún");
        }
        else{
            vista.mostrarPromedio(promedio);
        }
    }

    // llama a controladorAtleta y envia el resultado a la vista
    public void mostrarMejorYPeorIntento(){
        int mejorTiempo = controladorAtleta.mejorTiempo(controladorAtleta.intentosRealizados(torneo.atletaActivo.getIntentos()));
        int peorTiempo = controladorAtleta.peorTiempo(controladorAtleta.intentosRealizados(torneo.atletaActivo.getIntentos()));

        if(mejorTiempo == 0 && peorTiempo == 0){
            vista.mostrarMensaje("Aún no se han registrado intentos");
        }
        else{
            vista.mostrarMejorYPeorTiempo(mejorTiempo, peorTiempo);
        }
    }

    // llama a controladorAtleta y envia el resultado a la vista
    public void mostrarIntentosDisponibles(){
        String nombre = torneo.atletaActivo.getNombre();
        int [] intentos = controladorAtleta.intentosDisponibles(torneo.atletaActivo.getIntentos());
        vista.mostrarIntentosDisponibles(intentos);
    }
    
    // valida que el atleta del torneo no sea null antes de permitir operaciones sobre intentos
    public boolean hayAtletaActivo(){
        Atleta validacion = torneo.getAtletaActivo();

        if( validacion == null){
            return false;
        }
        else{
            return true;
        }
    }


}