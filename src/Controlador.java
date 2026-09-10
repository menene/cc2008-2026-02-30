import java.util.ArrayList;

public class Controlador {
    private Vista vista = new Vista(); 
    private Festival festival; 

    public void iniciar() {
        boolean continuar = true; 
        try {
            nuevoFestival();

            while (continuar) {
                int opcion = vista.mostrarMenu();

                if (opcion ==1 ) {
                    nuevoFestival();
                } else if (opcion == 2) {
                    configurarEscenario();
                } else if (opcion == 3) {
                    consultarEscenarios(); 
                } else if (opcion == 4) {
                    consultarEscenario();
                } else if (opcion == 5){
                    modificarEscenario(); 
                } else if (opcion == 6) {
                    retirarEscenario(); 
                } else if (opcion == 7) {
                    registrarArtista();
                } else if (opcion == 8){
                    consultarArtistas(); 
                } else if (opcion == 9) {
                    buscarArtista(); 
                } else if (opcion == 10) {
                    modificarArtista();
                } else if (opcion == 11){
                    cancelarParticipacion(); 
                } else if (opcion == 12) {
                    mostrarReporte(); 
                } else if (opcion == 13) {
                    continuar = false;
                } else { 
                    vista.error("Ingresa un numero entre 1 a 13");
                }
            }    
        } finally {
            salir();
        }
    } 

    public void nuevoFestival() {
        String nombre = vista.pedirTexto("NOmbre del festival: ");
        int codigo = vista.pedirDatosNumericos("Código del festival: "); 
        String coordinador = vista.pedirTexto("Nombre del coodinador del festival"); 

        festival = new Festival(nombre, codigo, coordinador);
        vista.mensaje("Se creó el festival, bienvenido al registro de escenarios y artistas");
    }

    public void configurarEscenario(){
        try {
            int posicion = vista.pedirDatosNumericos("Ingresa la posición a configurar el escenario (de 1 a 5: ");
            if (posicion < 1 || posicion > 5) { 
                throw new IndexOutOfBoundsException("La posición debe estar entre 1 y 5.");
            }
            int codigo = vista.pedirDatosNumericos("Ingresa el codigo del escenario: ");
            String nombre = vista.pedirTexto("Ingresa el nombre del escenario: "); 
            String ubicacion = vista.pedirTexto("Ingresa la ubicacion del escenario: "); 
            int capacidadMax = vista.pedirDatosNumericos("Ingresa la capacidad maxima del escenario"); 
            if (capacidadMax <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que 0.");
            }
            String estadoEsc = vista.pedirTexto("Ingresa el estado del escenario (disponible / no disponible)"); 
            boolean estado;
            if (estadoEsc.equalsIgnoreCase("disponible")) {
                estado = true;
            } else if (estadoEsc.equalsIgnoreCase("no disponible")) {
                estado = false;
            } else {
                throw new IllegalArgumentException("El estado deberia ser disponible o no disponible" );
            }

            festival.nuevoEscenario(posicion, codigo, nombre, ubicacion, capacidadMax, estado);
            vista.mensaje("El escenario fue registrado"); 

        } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
            vista.error(e.getMessage());
        }
    }

    public void consultarEscenarios() {
        Escenario [] escenariosRegistrados = festival.consultaEscenarios(); 
        vista.mostrarEscenarios(escenariosRegistrados);

    }

    public void consultarEscenario() {
        try {
            int posicionEsc = vista.pedirDatosNumericos("Ingresa la posicion del escenario a consultar (De 1 a 5): ");
            Escenario encontrarEsc = festival.consultaEscenarioEsp(posicionEsc); 
            vista.mostrarEscenarioEsp(encontrarEsc, posicionEsc); 

        } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
            vista.error(e.getMessage());
        }
    }

    public void modificarEscenario(){
        try {
            int posicionEsc = vista.pedirDatosNumericos("Ingrese la posicion del escenario a modificar"); 
            Escenario escenarioModificar = festival.consultaEscenarioEsp(posicionEsc);
            vista.mostrarEscenarioEsp(escenarioModificar, posicionEsc);

            int nuevaCapacidadMax = vista.pedirDatosNumericos("Ingresa la nueva capacidad maxima");
            String nuevoEstado = vista.pedirTexto("Ingresa el nuevo estado: " ); 
            boolean estado;
            if (nuevoEstado.equalsIgnoreCase("disponible")) {
                estado = true;
            } else if (nuevoEstado.equalsIgnoreCase("no disponible")) {
                estado = false;
            } else {
                throw new IllegalArgumentException("El estado deberia ser disponible o no disponible" );
            }
            festival.modificarEscenario(posicionEsc, nuevaCapacidadMax, estado);
            vista.mensaje("CAmbios realizados al escenario"); 

            } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
                vista.error(e.getMessage());
            }
    }

    public void retirarEscenario() {
        try {
            int posicion = vista.pedirDatosNumericos("Ingresa la posicion del escenario a retirar: ");
            Escenario escenario = festival.consultaEscenarioEsp(posicion); 
            vista.mostrarEscenarioEsp(escenario, posicion);
            festival.eliminarEscenario(posicion);
            vista.mensaje("Se retiro el escenario");

        } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
            vista.error(e.getMessage());
        }
    }

    public void registrarArtista() {
        try {  
        int codigo = vista.pedirDatosNumericos("Ingresa el codigo del artista: "); 
        String nombreArt = vista.pedirTexto("Ingresa el nombre artístico: ");
        String genero = vista.pedirTexto("Ingresa el genero musical del artista: ");
        int duracion = vista.pedirDatosNumericos("Ingresa la duración de la presentación: ");
        int cantidad = vista.pedirDatosNumericos("Indica la cantidad estimada de asistentes: ");
        
        festival.nuevoArtista(codigo, nombreArt, genero, duracion, cantidad);
        vista.mensaje("Se registró el artista"); 

        } catch (IllegalArgumentException e) {
            vista.error(e.getMessage());
        } 
    }

    public void consultarArtistas() {
           ArrayList<Artista> registroArtistas = festival.consultarArtistas();  
           vista.mostrarArtistas(registroArtistas);
    }

    public void buscarArtista(){
        int codigo = vista.pedirDatosNumericos("Ingresa el codigo que identifica al artista: "); 
        Artista artista = festival.consultarArtista(codigo); 

        if (artista == null) {
            vista.error("No hay un artista registrado con ese codigo"); 
        } else {
            vista.mostrarArtista(artista);
        }
    }

    public void modificarArtista() {
        try {
            int codigo = vista.pedirDatosNumericos("Ingresa el codigo del artista que quieres modificar: "); 
            Artista artista = festival.consultarArtista(codigo); 

            if(artista == null) {
                throw new IllegalArgumentException("No hay un artista con dicho codigo"); 
            }
            vista.mostrarArtista(artista); 
            String nuevoNombreArt = vista.pedirTexto("Ingresa el nuevo nombre artístico: ");
            String nuevoGenero = vista.pedirTexto("Ingresa el nuevo genero musical del artista: ");
            int nuevaDuracion = vista.pedirDatosNumericos("Ingrese la nueva duración: ");
            int nuevaCantidad = vista.pedirDatosNumericos("Indica la nueva cantidad estimada de asistentes: ");
            festival.modificarArtista(codigo, nuevoNombreArt, nuevoGenero, nuevaDuracion, nuevaCantidad);
             vista.mensaje("Se realizaron los cambios en artista ");

        } catch (IllegalArgumentException e) {
            vista.error(e.getMessage());
        }
    }

    public void cancelarParticipacion() {
        try {
            int codigo = vista.pedirDatosNumericos("Ingrese el codigo del artista a cancelar participacion: "); 
            Artista artista = festival.consultarArtista(codigo); 

            if(artista == null) {
                throw new IllegalArgumentException("No hay un artista con dicho codigo"); 
            }
            vista.mostrarArtista(artista);
            festival.eliminarArtista(codigo);
            vista.mensaje("Se canceló la participacion del arista ");

        } catch (IllegalArgumentException e) {
            vista.error(e.getMessage());
        }
    }

    public void mostrarReporte() {
        int numEscenarios = festival.numEscenarios(); 
        int espaciosDisponibles = festival.espaciosDisponibles();
        Escenario escMayorCapacidad = festival.escMayorCapacidad();
        int numArtistas = festival.numArtistas(); 
        Artista mayorDuracionArt = festival.mayorDuracionArt(); 
        Artista mayorCantidadEst = festival.mayorCantidadEst();
        double promedioDuracion = festival.promedioDuracion();

        vista.mostrarReporte(numEscenarios, espaciosDisponibles, escMayorCapacidad, numArtistas, mayorDuracionArt, mayorCantidadEst, promedioDuracion);
    }

    public void salir(){
        vista.mensaje("Gracias por utilizar el programa.");
    }
}
