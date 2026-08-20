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
        this.vista = new VistaTorneo();
    }

    // Muestra los atletas disponibles y retorna el atleta seleccionado.
    public void mostraMenuAtletas() {

        boolean salir = false;

        while (!salir) {
            int numeroAtleta = vista.mostrarMenuAtletas(torneo.toString());

            if (numeroAtleta == 0) {
                salir = true;
            } else {
                Atleta atleta = torneo.getAtleta(numeroAtleta);

                if (atleta != null) {
                    boolean terminarPrograma = iniciarTomaTiempos(atleta);

                    if (terminarPrograma) {
                        salir = true;
                    }
                } else {
                    vista.imprimirMensaje("Ingresó una opción inválida. Inténtelo otra vez :)");
                }
            }
        }
    }

    // Maneja el menú principal
    public boolean iniciarTomaTiempos(Atleta atleta) {
        
        int opcion;

        do {
            opcion = mostrarMenu(atleta.toString());
            switch (opcion) {
                case 0: 
                    return true;
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
                    mostrarIntentosDisponibles(atleta);
                    break;
                case 8:
                    return false;
                default:
                    vista.imprimirMensaje("Ingresó una opción inválida. Inténtelo otra vez UwU");
                    break;
            }
        } while (true);
    }

    // Llama a la vista para que muestre el menú y retorne la opción escogida. 
    private int mostrarMenu(String datosAtleta) {
        return vista.mostrarMenu(datosAtleta);
    }

    // Registra un nuevo tiempo en la siguiente posición disponible
    private void registrarTiempo(float[] tiempos, boolean disponible) {
        if (!disponible) {
            vista.imprimirMensaje("No hay intentos disponibles :(");
            return;
        }

        float tiempo = vista.pedirTiempo("Ingrese el tiempo obtenido: ");

        if (tiempo <= 0) {
            vista.imprimirMensaje("El tiempo debe ser mayor a 0 XD.");
            return;
        }

        for (int i = 0; i < tiempos.length; i++) {

            if (tiempos[i] == 0) {

                tiempos[i] = tiempo;

                vista.imprimirMensaje("El tiempo ha sido guardado UwU");
                return;
            }
        }
    }

    public void modificarTiempo(float[] tiempos) {

        int intento = vista.pedirIntento();

        int indice = intento - 1;

        if (indice < 0 || indice >= tiempos.length) {
            vista.imprimirMensaje("Número de intento inválido :/");
            return;
        }

        if (tiempos[indice] == 0) {
            vista.imprimirMensaje("El intento todavía no ha sido registrado, entonces no se puede modificar algo que no existe.");
            return;
        }

        float nuevoTiempo = vista.pedirTiempo("Ingrese el nuevo tiempo: ");

        if (nuevoTiempo <= 0) {
            vista.imprimirMensaje("El tiempo debe ser mayor a 0 XD. No se modificó el tiempo.");
            return;
        }

        tiempos[indice] = nuevoTiempo;
        vista.imprimirMensaje("Tiempo modificado correctamente :D");
    }

    private void mostrarTiempo(float[] tiempos, boolean todos) {
        if (todos) {
            boolean hayTiempos = false;

            String encabezado = """
                        +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-
                                        TIEMPOS
                        +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-
                        """;

            vista.imprimirMensaje(encabezado);

            for (int i = 0; i < tiempos.length; i++) {

                if (tiempos[i] > 0) {

                    hayTiempos = true;
                    
                    vista.imprimirMensaje("Intento " + (i + 1) + ": " + tiempos[i] + " segundos");
                }
            }
            

            if (!hayTiempos) {
                vista.imprimirMensaje("No hay tiempos registrados para mostrar :/");
            }
        } else {
            int intento = vista.pedirIntento();

            int indice = intento - 1;

            if (indice < 0 || indice >= tiempos.length) {

                vista.imprimirMensaje("Número de intento inválido :/");

                return;
            }

            if (tiempos[indice] == 0) {
                vista.imprimirMensaje("El tiempo todavía no se ha registrado :(.");
                return;
            }

            vista.imprimirMensaje("Intento " + intento+ ": " + tiempos[indice] + " segundos");
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
            vista.imprimirMensaje("No hay tiempos registrados para calcular el promedio :(");
            return;
        }

        float promedio = suma / cantidad;

        vista.imprimirMensaje(String.format("Tiempo promedio: %.2f segundos", promedio));
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
            vista.imprimirMensaje("No hay tiempos registrados para mostrar el mejor y el mayor tiempo :(");
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

        vista.imprimirMensaje(String.format("Mejor tiempo: %.2f segundos" + "\nMayor tiempo: %.2f segundos", mejor, mayor));
    }

    private void mostrarIntentosDisponibles(Atleta atleta) {
        vista.imprimirMensaje("Intentos realizados: " + atleta.getIntentosRealizados() + "\nIntentos disponibles: " + atleta.getDisponibles());
    }
}