import java.util.NoSuchElementException;

public class ControladorFestival {
    private Festival festival;
    private ControladorEscenario controladorEscenario;
    private ControladorArtista controladorArtista;
    private VistaFestival vista;

    // Constructor: crea el ControladorEscenario, el ControladorArtista y la VistaFestival; la instancia de Festival se crea posteriormente cuando el usuario registra los datos del festival mediante la opcion Nuevo festival.
    public ControladorFestival() {
        controladorEscenario = new ControladorEscenario();
        controladorArtista = new ControladorArtista();
        vista = new VistaFestival();
    }

    // Muestra el menu principal dentro de un ciclo y delega cada opcion elegida a los metodos privados correspondientes; despues de manejar cualquier excepcion el ciclo continua y regresa al menu principal, sin que el programa finalice inesperadamente.
    public void iniciar() {
        boolean continuar = true;
        int opcion;


        while (continuar == true){
            vista.mostrarBienvenida();
            try {
                opcion = vista.leerOpcion();
                if (opcion == 1){
                    crearNuevoFestival();
                }
                else if (opcion == 2){
                    configurarEscenario();
                }
                else if (opcion == 3){
                    consultarEscenarios();
                }
                else if (opcion == 4){
                    consultarEscenario();
                }
                else if (opcion == 5){
                    modificarEscenario();
                }
                else if (opcion == 6){
                    retirarEscenario();
                }
                else if (opcion == 7){
                    registrarArtista();
                }
                else if (opcion == 8){
                    consultarArtistas();
                }
                else if (opcion == 9){
                    buscarArtistaPorCodigo();
                }
                else if (opcion == 10){
                    modificarArtista();
                }
                else if (opcion == 11){
                    cancelarParticipacion();
                }
                else if (opcion == 12){
                    mostrarReporteFestival();
                }
                else if (opcion == 13){
                    continuar = false;
                    vista.mostrarMensaje("Programa finalizado");
                }
                else{
                    vista.mostrarMensaje("Opcion no valida");
                }
            }
            catch (Exception e) {
                vista.mostrarMensaje("Error: " + e.getMessage());
            }
        }
    }

    // Pide a la vista el nombre, codigo y coordinador del festival, y crea una nueva instancia de Festival que reemplaza la actual, iniciando sin escenarios configurados y sin artistas registrados.
    private void crearNuevoFestival() {
        String nombre = vista.leerTexto("Ingrese el nombre del festival: ");
        String codigo = vista.leerTexto("Ingrese el codigo del festival: ");
        String nombreCoordinador = vista.leerTexto("Ingrese el nombre del coordinador: ");

        festival = new Festival(nombre, codigo, nombreCoordinador);
        vista.mostrarMensaje("Festival creado correctamente");
    }

    // Pide a la vista la posicion y los datos del nuevo escenario; dentro de un try-catch valida que la posicion este dentro de los limites del arreglo y que se encuentre disponible (null), delega la validacion de los datos a controladorEscenario y, si todo es correcto, crea el Escenario y lo agrega al festival; el bloque finally informa que el proceso de configuracion termino, se haya guardado el escenario o no.
    private void configurarEscenario() {
        try{
            if (festival == null){
                throw new IllegalStateException("Primero debe crear un festival");
            }
            int posicion = vista.leerEntero("Ingrese la posicion del escenario: ");
            int indice = posicion - 1;

            if (indice < 0 || indice >= festival.getEscenarios().length){
                throw new ArrayIndexOutOfBoundsException("Posicion fuera del rango permitido");
            }
            if (festival.getEscenario(indice) != null){
                throw new IllegalStateException("La posicion ya tiene un escenario configurado");
            }

            String codigo = vista.leerTexto("Ingrese el codigo del escenario: ");
            String nombre = vista.leerTexto("Ingrese el nombre del escenario: ");
            String ubicacion = vista.leerTexto("Ingrese la ubicacion del escenario: ");
            int capacidad = vista.leerEntero("Ingrese la capacidad del escenario: ");
            String estado = vista.leerTexto("Ingrese el estado del escenario: ");
            controladorEscenario.validarDatosEscenario(codigo, nombre, ubicacion, capacidad, estado);
            Escenario escenario = new Escenario(codigo, nombre, ubicacion, capacidad, estado);
            festival.configurarEscenario(indice, escenario);
            vista.mostrarMensaje("Escenario configurado correctamente");
        }
        catch (IllegalArgumentException | IllegalStateException | ArrayIndexOutOfBoundsException e){
            vista.mostrarMensaje("Error: " + e.getMessage());
        }
        finally{
            vista.mostrarMensaje("Proceso de configuracion termino");
        }   
    }

    // Recorre con for el arreglo de escenarios del festival, omite las posiciones que contienen null y envia cada escenario configurado a la vista junto con la posicion que ocupa.
    private void consultarEscenarios() {
        if (festival == null){
            vista.mostrarMensaje("Primero debe crear un festival");
            return;
        }

        Escenario[] escenarios = festival.getEscenarios();
        boolean hayEscenarios = false;
        for(int i = 0; i < escenarios.length; i++){
            if(escenarios[i] != null){
                hayEscenarios = true;
                vista.mostrarEscenario(i + 1, escenarios[i].getCodigo(), escenarios[i].getNombre(), escenarios[i].getUbicacion(), escenarios[i].getCapacidadMaxima(), escenarios[i].getEstado());
            }
        }
        if (!hayEscenarios){
            vista.mostrarMensaje("No hay escenarios configurados");
        }
    }
     

    // Pide la posicion a consultar; dentro de un try-catch valida que este dentro de los limites del arreglo y que no contenga null, informando al usuario si la posicion no es valida o esta vacia; si el escenario existe, envia su informacion a la vista.
    private void consultarEscenario() {
        try {
            if (festival == null){
                throw new IllegalStateException("Primero debe crear un festival");
            }
            int posicion = vista.leerEntero("Ingrese la posicion del escenario a consultar: ");
            int indice = posicion - 1;

            if (indice < 0 || indice >= festival.getEscenarios().length){
                throw new ArrayIndexOutOfBoundsException("Posicion fuera del rango permitido");
            }

            Escenario escenario = festival.getEscenario(indice);
            if (escenario == null){
                throw new IllegalStateException("La posicion no tiene un escenario configurado");
            }

            vista.mostrarEscenario(posicion, escenario.getCodigo(), escenario.getNombre(), escenario.getUbicacion(), escenario.getCapacidadMaxima(), escenario.getEstado());
        }
        catch (IllegalStateException | ArrayIndexOutOfBoundsException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        }
    }

    // Pide la posicion del escenario a modificar; dentro de un try-catch valida que la posicion exista y no contenga null, informando al usuario en caso contrario; si el escenario existe, pide la nueva capacidad y el nuevo estado a la vista y delega la validacion y actualizacion a controladorEscenario.
    private void modificarEscenario() {
        try {
            if (festival == null){
                throw new IllegalStateException("Primero debe crear un festival");
            }
            int posicion = vista.leerEntero("Ingrese la posicion del escenario a modificar: ");
            int indice = posicion - 1;

            if (indice < 0 || indice >= festival.getEscenarios().length){
                throw new ArrayIndexOutOfBoundsException("Posicion fuera del rango permitido");
            }

            Escenario escenario = festival.getEscenario(indice);
            if (escenario == null){
                throw new IllegalStateException("La posicion no tiene un escenario configurado");
            }

            int nuevaCapacidad = vista.leerEntero("Ingrese la nueva capacidad del escenario: ");
            String nuevoEstado = vista.leerTexto("Ingrese el nuevo estado del escenario: ");
            controladorEscenario.modificarDatosEscenario(escenario, nuevaCapacidad, nuevoEstado);
            vista.mostrarMensaje("Escenario modificado correctamente");
        }
        catch (IllegalArgumentException | IllegalStateException | ArrayIndexOutOfBoundsException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        }
    }

    // Pide la posicion del escenario a retirar; dentro de un try-catch valida que la posicion exista y no contenga null, informando al usuario en caso contrario; si el escenario existe, llama a festival.retirarEscenario para dejar la posicion en null; el bloque finally confirma que el proceso de retiro termino, se haya retirado el escenario o no.
    private void retirarEscenario() {
        try {
            if (festival == null){
                throw new IllegalStateException("Primero debe crear un festival");
            }
            int posicion = vista.leerEntero("Ingrese la posicion del escenario a retirar: ");
            int indice = posicion - 1;

            if (indice < 0 || indice >= festival.getEscenarios().length){
                throw new ArrayIndexOutOfBoundsException("Posicion fuera del rango permitido");
            }
            if (festival.getEscenario(indice) == null){
                throw new IllegalStateException("La posicion no tiene un escenario configurado");
            }

            festival.retirarEscenario(indice);
            vista.mostrarMensaje("Escenario retirado correctamente");
        }
        catch (IllegalStateException | ArrayIndexOutOfBoundsException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        }
        finally {
            vista.mostrarMensaje("Proceso de retiro termino");
        }
    }

    // Pide a la vista el codigo, nombre artistico, genero musical, duracion y cantidad estimada de asistentes del nuevo artista; recorre con for-each el ArrayList para verificar que el codigo no este repetido; delega la validacion de los datos a controladorArtista y, si todo es correcto, crea el Artista y lo agrega al festival; el bloque finally informa que el proceso de registro termino, se haya guardado el artista o no.
    private void registrarArtista() {
        try {
            if (festival == null){
                throw new IllegalStateException("Primero debe crear un festival");
            }
            String codigo = vista.leerTexto("Ingrese el codigo del artista: ");
            for (Artista artista : festival.getArtistas()){
                if (artista.getCodigo().equals(codigo)){
                    throw new IllegalStateException("Ya existe un artista con ese codigo");
                }
            }

            String nombreArtistico = vista.leerTexto("Ingrese el nombre artistico: ");
            String generoMusical = vista.leerTexto("Ingrese el genero musical: ");
            int duracionPresentacion = vista.leerEntero("Ingrese la duracion de la presentacion: ");
            int cantidadEstimadaAsistentes = vista.leerEntero("Ingrese la cantidad estimada de asistentes: ");

            controladorArtista.validarDatosArtista(codigo, nombreArtistico, generoMusical, duracionPresentacion, cantidadEstimadaAsistentes);
            Artista artista = new Artista(codigo, nombreArtistico, generoMusical, duracionPresentacion, cantidadEstimadaAsistentes);
            festival.agregarArtista(artista);
            vista.mostrarMensaje("Artista registrado correctamente");
        }
        catch (IllegalArgumentException | IllegalStateException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        }
        finally {
            vista.mostrarMensaje("Proceso de registro termino");
        }
    }

    // Recorre con for-each la coleccion dinamica de artistas del festival y envia cada uno a la vista; si la coleccion esta vacia, informa la situacion al usuario sin producir errores.
    private void consultarArtistas() {
        if (festival == null){
            vista.mostrarMensaje("Primero debe crear un festival");
            return;
        }
        if (festival.getArtistas().isEmpty()){
            vista.mostrarMensaje("No hay artistas registrados");
            return;
        }

        for (Artista artista : festival.getArtistas()){
            vista.mostrarArtista(artista.getCodigo(), artista.getNombreArtistico(), artista.getGeneroMusical(), artista.getDuracionPresentacion(), artista.getCantidadEstimadaAsistentes());
        }
    }

    // Pide el codigo del artista a buscar y recorre con for-each el ArrayList comparando el codigo de cada artista; dentro de un try-catch, si no encuentra coincidencia lanza y captura una excepcion e informa al usuario sin finalizar el programa; si lo encuentra, envia su informacion a la vista.
    private void buscarArtistaPorCodigo() {
        try {
            if (festival == null){
                throw new IllegalStateException("Primero debe crear un festival");
            }
            String codigo = vista.leerTexto("Ingrese el codigo del artista a buscar: ");
            Artista encontrado = null;

            for (Artista artista : festival.getArtistas()){
                if (artista.getCodigo().equals(codigo)){
                    encontrado = artista;
                    break;
                }
            }
            if (encontrado == null){
                throw new NoSuchElementException("El artista no existe");
            }

            vista.mostrarArtista(encontrado.getCodigo(), encontrado.getNombreArtistico(), encontrado.getGeneroMusical(), encontrado.getDuracionPresentacion(), encontrado.getCantidadEstimadaAsistentes());
        }
        catch (IllegalStateException | NoSuchElementException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        }
    }

    // Busca el artista por codigo recorriendo el ArrayList con for-each dentro de un try-catch; si no existe, captura la excepcion e informa al usuario; si existe, pide los nuevos valores a la vista y delega la validacion y actualizacion a controladorArtista.
    private void modificarArtista() {
        try {
            if (festival == null){
                throw new IllegalStateException("Primero debe crear un festival");
            }
            String codigo = vista.leerTexto("Ingrese el codigo del artista a modificar: ");
            Artista encontrado = null;

            for (Artista artista : festival.getArtistas()){
                if (artista.getCodigo().equals(codigo)){
                    encontrado = artista;
                    break;
                }
            }
            if (encontrado == null){
                throw new NoSuchElementException("El artista no existe");
            }

            String nuevoNombreArtistico = vista.leerTexto("Ingrese el nuevo nombre artistico: ");
            String nuevoGeneroMusical = vista.leerTexto("Ingrese el nuevo genero musical: ");
            int nuevaDuracion = vista.leerEntero("Ingrese la nueva duracion: ");
            int nuevaCantidadAsistentes = vista.leerEntero("Ingrese la nueva cantidad estimada de asistentes: ");

            controladorArtista.modificarDatosArtista(encontrado, nuevoNombreArtistico, nuevoGeneroMusical, nuevaDuracion, nuevaCantidadAsistentes);
            vista.mostrarMensaje("Artista modificado correctamente");
        }
        catch (IllegalArgumentException | IllegalStateException | NoSuchElementException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        }
    }

    // Busca el artista por codigo recorriendo el ArrayList con for-each dentro de un try-catch; si no existe, captura la excepcion e informa al usuario sin finalizar el programa; si existe, elimina el objeto correspondiente llamando a festival.eliminarArtista; el bloque finally confirma que el proceso de cancelacion termino, se haya cancelado el artista o no.
    private void cancelarParticipacion() {
        try {
            if (festival == null){
                throw new IllegalStateException("Primero debe crear un festival");
            }
            String codigo = vista.leerTexto("Ingrese el codigo del artista a cancelar: ");
            Artista encontrado = null;

            for (Artista artista : festival.getArtistas()){
                if (artista.getCodigo().equals(codigo)){
                    encontrado = artista;
                    break;
                }
            }
            if (encontrado == null){
                throw new NoSuchElementException("El artista no existe");
            }

            festival.eliminarArtista(encontrado);
            vista.mostrarMensaje("Participacion cancelada correctamente");
        }
        catch (IllegalStateException | NoSuchElementException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        }
        finally {
            vista.mostrarMensaje("Proceso de cancelacion termino");
        }
    }

    // Obtiene la cantidad de escenarios configurados, los espacios disponibles, el escenario de mayor capacidad, la cantidad de artistas registrados, el artista de mayor duracion, el artista con mayor cantidad de asistentes y el promedio de duracion, y envia toda esta informacion a la vista para mostrar el reporte del festival.
    private void mostrarReporteFestival() {
        if (festival == null){
            vista.mostrarMensaje("Primero debe crear un festival");
            return;
        }

        Escenario escenarioMayor = obtenerEscenarioMayorCapacidad();
        Artista artistaMayorDuracion = obtenerArtistaMayorDuracion();
        Artista artistaMayorAsistentes = obtenerArtistaMayorAsistentes();
        String escenarioMayorCapacidad = "No hay escenarios configurados";
        String nombreArtistaMayorDuracion = "No hay artistas registrados";
        String nombreArtistaMayorAsistentes = "No hay artistas registrados";

        if (escenarioMayor != null){
            escenarioMayorCapacidad = escenarioMayor.getNombre() + " (" + escenarioMayor.getCapacidadMaxima() + ")";
        }
        if (artistaMayorDuracion != null){
            nombreArtistaMayorDuracion = artistaMayorDuracion.getNombreArtistico() + " (" + artistaMayorDuracion.getDuracionPresentacion() + " minutos)";
        }
        if (artistaMayorAsistentes != null){
            nombreArtistaMayorAsistentes = artistaMayorAsistentes.getNombreArtistico() + " (" + artistaMayorAsistentes.getCantidadEstimadaAsistentes() + " asistentes)";
        }

        vista.mostrarReporteFestival(calcularCantidadEscenariosConfigurados(), calcularEspaciosDisponibles(), escenarioMayorCapacidad, festival.getArtistas().size(), nombreArtistaMayorDuracion, nombreArtistaMayorAsistentes, calcularPromedioDuracion());
    }

    // Recorre con for el arreglo de escenarios contando las posiciones distintas de null; asi se calcula la cantidad de escenarios configurados.
    private int calcularCantidadEscenariosConfigurados() {
        int cantidad = 0;
        Escenario[] escenarios = festival.getEscenarios();

        for (int i = 0; i < escenarios.length; i++){
            if (escenarios[i] != null){
                cantidad++;
            }
        }

        return cantidad;
    }

    // Resta la cantidad de escenarios configurados al tamaño total del arreglo; asi se calcula la cantidad de espacios disponibles para escenarios.
    private int calcularEspaciosDisponibles() {
        return festival.getEscenarios().length - calcularCantidadEscenariosConfigurados();
    }

    // Recorre con for el arreglo de escenarios, omitiendo las posiciones en null, comparando la capacidad maxima de cada uno contra la mayor encontrada hasta el momento, y retorna el escenario con la capacidad mas alta.
    private Escenario obtenerEscenarioMayorCapacidad() {
        Escenario mayor = null;
        Escenario[] escenarios = festival.getEscenarios();

        for (int i = 0; i < escenarios.length; i++){
            if (escenarios[i] != null && (mayor == null || escenarios[i].getCapacidadMaxima() > mayor.getCapacidadMaxima())){
                mayor = escenarios[i];
            }
        }

        return mayor;
    }

    // Recorre con for-each el ArrayList de artistas sumando la duracion de cada presentacion y divide el total entre la cantidad de artistas registrados; si la coleccion esta vacia, se maneja mediante try-catch para evitar una division entre cero.
    private double calcularPromedioDuracion() {
        try {
            if (festival.getArtistas().isEmpty()){
                throw new ArithmeticException("No hay artistas registrados");
            }
            int suma = 0;
            for (Artista artista : festival.getArtistas()){
                suma += artista.getDuracionPresentacion();
            }
            return (double) suma / festival.getArtistas().size();
        }
        catch (ArithmeticException e) {
            return 0.0;
        }
    }

    // Recorre con for-each el ArrayList de artistas comparando la duracion de la presentacion de cada uno contra la mayor encontrada hasta el momento, y retorna el artista con la presentacion mas larga.
    private Artista obtenerArtistaMayorDuracion() {
        Artista mayor = null;

        for (Artista artista : festival.getArtistas()){
            if (mayor == null || artista.getDuracionPresentacion() > mayor.getDuracionPresentacion()){
                mayor = artista;
            }
        }

        return mayor;
    }

    // Recorre con for-each el ArrayList de artistas comparando la cantidad estimada de asistentes de cada uno contra la mayor encontrada hasta el momento, y retorna el artista con mayor cantidad estimada de asistentes.
    private Artista obtenerArtistaMayorAsistentes() {
        Artista mayor = null;

        for (Artista artista : festival.getArtistas()){
            if (mayor == null || artista.getCantidadEstimadaAsistentes() > mayor.getCantidadEstimadaAsistentes()){
                mayor = artista;
            }
        }

        return mayor;
    }

}
