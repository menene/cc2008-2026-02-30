public class Controlador {
    private Atleta[] atleta;
    private Vista vista;
    private Atleta atletaActual;

    public Controlador() {
        this.atleta = new Atleta[5];
        this.vista = new Vista();
        this.atletaActual = null;

    }
    
    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    nuevoAtleta(); 
                    break;
                case 2:
                    nuevoIntento();
                    break;
                case 3:
                    consultaTiempos();
                    break;
                case 4:
                    consultarIntento();
                    break;
                case 5:
                    modificarTiempo();
                    break;
                case 6:
                    consultaPromedioIntentos();
                    break;
                case 7:
                    mejorPeor();
                    break;
                case 8:
                    consultaDisponibles();
                    break;
                case 9:
                    salir();
                    break;
                default:
                    System.out.println("Opcion invalida. Intentalo nuevamente");; 
            }
        } while (opcion != 9);
    }

    public void nuevoAtleta() {
        Atleta nuevoAtleta = vista.leerAtleta();
        for (int i = 0; i < this.atleta.length; i++) {

            if (this.atleta[i] == null) {
                this.atleta[i] = nuevoAtleta;
                this.atletaActual = nuevoAtleta;
                break;
            }
        }
    }

    public void nuevoIntento() {
        if (atletaActual == null) {
            return;
        }
        int tiempo = vista.solicitarTiempo();
        atletaActual.agregarIntento(tiempo);
    
    }

    public void consultaTiempos() {
        if (atletaActual == null) {
            
            return;
        }
        int[] intentos = atletaActual.getIntentos();
        int cantidadIntentos = atletaActual.getCantidadIntentos(); 
        vista.mostrarTiempos(intentos, cantidadIntentos);
    }

    public void consultarIntento() {
        if (atletaActual == null) {
            return;
        }
        int numeroIntento = vista.pedirNumeroIntento();
        int tiempo = atletaActual.getIntento(numeroIntento); 
        vista.mostrarIntento(numeroIntento, tiempo);
    } 
        
    

    public void modificarTiempo() {
        if (atletaActual == null) {
            return;
        }
        int numeroIntento = vista.pedirNumeroIntento();
        int tiempoActual = atletaActual.getIntento(numeroIntento);

        if (tiempoActual== 0){
            vista.mostrarIntento(numeroIntento, tiempoActual);
            return; 
        }
        int tiempoNuevo = vista.solicitarTiempo();
        atletaActual.modificarIntento(numeroIntento, tiempoNuevo);
    }
    


    public void consultaPromedioIntentos() {
        if (atletaActual == null) {
            
            return;
        }
        int promedio = atletaActual.promedioIntentos();
        vista.mostrarPromedioIntentos(promedio);
    }

    public void mejorPeor() {
        if (atletaActual == null) {
            return;
        }
        int mejorTiempo = atletaActual.mejorTiempo();
        int peorTiempo = atletaActual.peorTiempo();
        vista.mostrarMejorTiempo(mejorTiempo);
        vista.mostrarPeorTiempo(peorTiempo);
    }

    public void consultaDisponibles() {

        if (atletaActual == null) {
            return;
        }

        int intentosRealizados = atletaActual.intentosRealizados();
        int intentosRestantes = atletaActual.intentosRestantes();

        vista.mostrarDisponibles(
            intentosRealizados,
            intentosRestantes
        );
    }
    public void salir() {
        
    }
}