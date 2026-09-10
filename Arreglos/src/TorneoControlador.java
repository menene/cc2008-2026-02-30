public class TorneoControlador {
    private Atleta atletaActivo;
    private VistaAtleta vista;

    public TorneoControlador() {
        this.vista = new VistaAtleta();
    }

    public void iniciar() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.pedirEntero("Seleccione una opción: ");

            //Esto es por si no hay atleta creado
            if (opcion >= 2 && opcion <= 8 && atletaActivo == null) {
                vista.mostrarMensaje("Error: Debe registrar un atleta primero (Opción 1).");
                continue;
            }

            switch (opcion) {
                //opción 1
                case 1:

                    String nombre = vista.pedirCadena("Ingrese el nombre del atleta: ");
                    int numero = vista.pedirEntero("Ingrese el número de participante: ");
                    int edad = vista.pedirEntero("Ingrese la edad: ");
                    
                    atletaActivo = new Atleta(nombre, numero, edad);
                    vista.mostrarMensaje("¡Nuevo atleta registrado exitosamente!");
                    break;

                //opción 2
                case 2:

                    if (atletaActivo.getIntentosRegistrados() < 10) {
                        double tiempo;
                        //Para saber que el tiempo es mayor a 0
                        do {
                            tiempo = vista.pedirDouble("Ingrese el tiempo en segundos: ");
                            if (tiempo <= 0) {
                                vista.mostrarMensaje("Error: El tiempo ingresado debe ser mayor a 0.");
                            }
                        } while (tiempo <= 0);
                        
                        atletaActivo.registrarTiempo(tiempo);
                        vista.mostrarMensaje("¡Intento registrado con éxito!");
                    } 
                    else 
                    {
                        vista.mostrarMensaje("Error: El atleta ya ha realizado el máximo de 10 intentos.");
                    }
                    break;

                //opción 3
                case 3:

                    vista.mostrarListaTiempos(atletaActivo.getTiempos(), atletaActivo.getIntentosRegistrados());
                    break;

                //opción 4
                case 4:

                    int cantidad = atletaActivo.getIntentosRegistrados();

                    if (cantidad == 0) {
                        vista.mostrarMensaje("Aún no hay intentos registrados.");
                    } 
                    else 
                    {
                        int numeroIntento = vista.pedirEntero("Ingrese el número de intento a consultar (1 a " + cantidad + "): ");

                        if (numeroIntento >= 1 && numeroIntento <= cantidad) 
                        {
                            double tiempoIntento = atletaActivo.getTiempos()[numeroIntento - 1];
                            vista.mostrarMensaje("El tiempo del intento " + numeroIntento + " es: " + tiempoIntento + " segundos.");
                        } 
                        else 
                        {
                            vista.mostrarMensaje("Error: El intento " + numeroIntento + " no existe o no ha sido registrado.");
                        }
                    }
                    break;

                //opción 5
                case 5:

                    int cantMod = atletaActivo.getIntentosRegistrados();

                    if (cantMod == 0) 
                    {
                        vista.mostrarMensaje("No hay intentos registrados para modificar");
                    } 
                    else 
                    {
                        int numIntentoMod = vista.pedirEntero("Ingrese el número de intento a modificar (1 a " + cantMod + "): ");
                        
                        if (numIntentoMod >= 1 && numIntentoMod <= cantMod) {
                            double nuevoTiempo;
                            do {
                                nuevoTiempo = vista.pedirDouble("Ingrese el nuevo tiempo (mayor a 0): ");
                                if (nuevoTiempo <= 0) {
                                    vista.mostrarMensaje("Error: El tiempo se ingrese debe ser mayor que 0.");
                                }
                            } while (nuevoTiempo <= 0);
                            
                            atletaActivo.modificarTiempo(numIntentoMod - 1, nuevoTiempo);
                            vista.mostrarMensaje("¡Tiempo modificado exitosamente!");
                        } else {
                            vista.mostrarMensaje("Error: El intento no existe o no ha sido registrado todavía.");
                        }
                    }
                    break;

                //opción 6
                case 6:

                    if (atletaActivo.getIntentosRegistrados() == 0) {
                        vista.mostrarMensaje("No hay tiempos suficientes para calcular el promedio.");
                    } else {
                        vista.mostrarMensaje("El tiempo promedio es de: " + atletaActivo.calcularPromedio() + " segundos.");
                    }
                    break;

                //opción 7
                case 7:

                    if (atletaActivo.getIntentosRegistrados() == 0) {
                        vista.mostrarMensaje("No hay tiempos registrados para evaluar");
                    } else {
                        vista.mostrarMensaje("Mejor tiempo (más bajo): " + atletaActivo.obtenerMejorTiempo() + " segundos.");
                        vista.mostrarMensaje("Tiempo más alto (peor): " + atletaActivo.obtenerMayorTiempo() + " segundos.");
                    }
                    break;

                //opción 8
                case 8:

                    int registrados = atletaActivo.getIntentosRegistrados();
                    int disponibles = 10 - registrados;
                    vista.mostrarMensaje("Intentos realizados: " + registrados);
                    vista.mostrarMensaje("Intentos restantes disponibles: " + disponibles);
                    break;

                //opción 9
                case 9:

                    vista.mostrarMensaje("Saliendo del programa ¡vuelva pronto!");
                    break;

                //por si ingresan uno incorrecto
                default:
                    
                    vista.mostrarMensaje("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 9);
    }
}