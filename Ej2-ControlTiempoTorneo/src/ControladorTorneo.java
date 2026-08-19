public class ControladorTorneo {
    // Atributos
    private Torneo torneo;
    private VistaTorneo vista;

    // Constructor del controlador
    public ControladorTorneo() {
        // Se crean los atletas y se asignan los valores
        Atleta[] atletas = new Atleta[2];

        atletas[0] = new Atleta("Emily Menchú", 21, 1111, 10);
        atletas[1] = new Atleta("Daniel Nájera", 67, 6767, 10);

        this.torneo = new Torneo(atletas);;
        this.vista = new VistaTorneo;
    }

    // Muestra los atletas disponibles y retorna el atleta seleccionado.
    public void mostraMenuAtletas() {
        int opcion;

        do {
            opcion = 0;

            if (opcion > 0) {

                Atleta atleta = null;

                if (atleta != null) {
                    iniciarTomaTiempos(atleta);
                }
            }

        } while (opcion != 0);
    }

    // Maneja el menú principal
    public void iniciarTomaTiempos(Atleta atleta) {
        
        int opcion;

        do {
            opcion = mostrarMenu(atleta.toString());
            switch (opcion) {
                case 1: 
                    registrarTiempo(atleta.getTiempos(), atleta.getDisponibles() > 0);
                    break;
                case 2: 
                    mostrarTiempo(atleta.getTiempos(), true);
                    break;
                case 3: 
                    mostrarTiempo(atleta.getTiempos(), false);
                    break;
                case 4: 
                    modificarTiempo(atleta.getTiempos());
                    break;
                case 5: 
                    calcularPromedio(atleta.getTiempos());
                    break;
                case 6: 
                    mejorYMayorTiempo(atleta.getTiempos());
                    break;
                case 7: 
                    // Para salir del menú del atleta
                    break;
                default:
                    //PENDIENTE
                    break;
            }
        } while (opcion != 7);
    }

    // Llama a la vista para que muestre el menú y retorne la opción escogida. 
    private int mostrarMenu(String datosAtleta) {
        //PENDIENTE
        return 0;
    }

    // Registra un nuevo tiempo en la siguiente posición disponible
    private void registrarTiempo(float[] tiempos, boolean disponible) {
        if (!disponible) {
            //PENDIENTE mostrar mensaje de error
            return;
        }

        // PENDIENTE pedir a la vista el tiempo ingresado

        float tiempo = 0;

        if (tiempo <= 0) {
            // PENDIENTE mensaje del erro valor 0
            return;
        }

        for (int i = 0; i < tiempos.length; i++) {

            if (tiempos[i] == 0) {

                tiempos[i] = tiempo;

                //PENDIENTE mostrar mensaje de tiempo guardado
                return;
            }
        }
    }

    public void modificarTiempo(float[] tiempos) {
        // PENDIENTE pedir el intento que se desea modificarf
        int intento = 0;

        ind indice = intento - 1;

        if (indice < 0 || indice >= tiempos.length) {
            // PENDIENTE mostrar mensaje de intento inválido
            return;
        }

        if (tiempo[indice] == 0) {
            // Pendiente mensaje de intento no ha sido registrado
            return
        }

        // PENDIENTE pedir el tiempo desde vista
        float nuevoTiempo = 0;

        if (nuevoTiempo <= 0) {

            // PENDIENTE mensaje tiempo debe ser mayor a 0

            return;
        }

        tiempos[indice] = nuevoTiempo;
         // PENDIENTE mostrar mensaje de guardado
    }

    private void mostrarTiempo(float[] tiempos, boolean todos) {
        if (todos) {
            boolean hayTiempos = false;

            for (int i = 0; i < tiempos.length; i++) {

                if (tiempos[i] > 0) {

                    hayTiempos = true;

                    // PENDIENTE imprimir tiempos
                }
            }

            if (!hayTiempos) {
                // PENDIENTE mostrar en vista mensaje de que no hay tiempos
            }
        } else {
            // PENDIENTE pedir numero de intento

            int intento = 0;

            int indice = intento - 1;

            if (indice < 0 || indice >= tiempos.length) {

                // PENDIENTE mostrar numero ingresado inválido

                return;
            }

            if (tiempos[indice] == 0) {
                // PENDIENTE mostrar mediante vista que el intento no ha sido registrado
                return;
            }

            // PENDIENTE mostrar el tiempo
        }
    }

    private void calcularPromedio(float[] tiempos) {
        float suma = 0;
        int cantidad = 0;

        for (int i = 0; i < tiempos.length; i++ ) {
            if (tiempos[i] > 0) {
                suma += tiempos[i];
                cantidad++;
            }
        }

        if (cantidad == 0) {
            // PENDIENTE mostrar mensaje de que no hay tiempos registrados
            return;
        }

        float promedio = suma / cantidad;

        // PENDIENTE mostrar promedio
    }

    private void mejorYMayorTiempo(float[] tiempos) {

        // Se va a buscar que haya un primer tiempo registrado, sino se queda con ese valor invalido lo que indica que no hay registros.
        int primeraPosicion = -1;

        // Se busca que algun valor sea mayor a cero 
        for (int i = 0; i < tiempos.length; i++) {
            if (tiempos[i] > 0) {
                primeraPosicion = i;
                break;
            }
        }

        if (primeraPosicion == -1) {
            //PENDIENTE mostrar mensaje sin tiempos
            return;
        }

        float mejor = tiempos[primeraPosicion];
        float mayor = tiempos[primeraPosicion];

        for (int i = primeraPosicion + 1; i < tiempos.length; i++) {
            if (tiempos[i] > 0) {

                if (tiempos[i] < mejor) {
                    mejor = tiempos[i];
                }

                if (tiempos[i] > mayor) {
                    mayor = tiempos[i];
                }
            }
        }

        // PENDIENTE mostrar por vista los tiempos
    }
}