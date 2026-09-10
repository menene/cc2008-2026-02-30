import java.util.InputMismatchException;
import java.util.ArrayList;

public class ControladorFestival {
    private Festival miFestival;
    private VistaFestival vista;

    public ControladorFestival() {
        this.vista = new VistaFestival();
    }

    public void iniciarSistema() {
        int opcion = 0;
        do {
            try {
                opcion = vista.mostrarMenuPrincipal();
                // Validar que exista el festival antes de operar, excepto al salir o crear un nuevo festival
                if (miFestival == null && opcion != 1 && opcion != 13) {
                    vista.mostrarMensaje("Error: Primero debe crear un Nuevo Festival (Opcion 1).");
                    continue;
                }
                
                switch (opcion) {
                    case 1: ejecutarNuevoFestival(); break;
                    case 2: ejecutarConfigurarEscenario(); break;
                    case 3: ejecutarConsultarEscenarios(); break;
                    case 4: ejecutarConsultarUnEscenario(); break;
                    case 5: ejecutarModificarEscenario(); break;
                    case 6: ejecutarRetirarEscenario(); break;
                    case 7: ejecutarRegistrarArtista(); break;
                    case 8: ejecutarConsultarArtistas(); break;
                    case 9: ejecutarBuscarArtista(); break;
                    case 10: ejecutarModificarArtista(); break;
                    case 11: ejecutarCancelarParticipacion(); break;
                    case 12: ejecutarMostrarReporte(); break;
                    case 13: vista.mostrarMensaje("Saliendo del sistema..."); break;
                    default: vista.mostrarMensaje("Opcion no valida.");
                }
            } catch (InputMismatchException e) {
                vista.limpiarEntrada();
                vista.mostrarMensaje("Error: Ha ingresado texto donde se esperaba un numero.");
            } catch (Exception e) {
                vista.mostrarMensaje("Error inesperado: " + e.getMessage());
            }
        } while (opcion != 13);
    }

    public void ejecutarNuevoFestival() {
        try {
            int id = vista.pedirEntero("Ingrese el codigo del festival:");
            String nom = vista.pedirTexto("Ingrese nombre del festival:");
            String coord = vista.pedirTexto("Ingrese nombre del coordinador:");
            miFestival = new Festival(id, nom, coord);
            vista.mostrarMensaje("Nuevo festival creado con exito.");
        } catch (InputMismatchException e) {
            vista.limpiarEntrada();
            vista.mostrarMensaje("Error: Formato numerico incorrecto.");
        }
    }

    public void ejecutarConfigurarEscenario() {
        try {
            int pos = vista.pedirEntero("Ingrese la posicion del escenario (1-5):");
            Escenario nuevo = vista.leerNuevoEscenario();
            miFestival.configurarNuevoEscenario(nuevo, pos - 1);
            vista.mostrarMensaje("Escenario configurado exitosamente.");
        } catch (InputMismatchException e) {
            vista.limpiarEntrada();
            vista.mostrarMensaje("Error: Se esperaba un numero.");
        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje("Error de validacion: " + e.getMessage());
        }
    }

    public void ejecutarConsultarEscenarios() {
        Escenario[] array = miFestival.consultarEscenarios();
        vista.mostrarMensaje("\n--- Escenarios Configurados ---");
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                vista.mostrarMensaje("Posicion [" + (i + 1) + "]: " + array[i].toString());
            }
        }
    }

    public void ejecutarConsultarUnEscenario() {
        try {
            int pos = vista.pedirEntero("Ingrese la posicion a consultar (1-5):");
            Escenario esc = miFestival.consultarEscenario(pos - 1);
            vista.mostrarMensaje("Encontrado: " + esc.toString());
        } catch (InputMismatchException e) {
            vista.limpiarEntrada();
            vista.mostrarMensaje("Error: Ingrese un numero.");
        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        }
    }

    public void ejecutarModificarEscenario() {
        try {
            int pos = vista.pedirEntero("Ingrese la posicion del escenario a modificar (1-5):");
            int nuevaCap = vista.pedirEntero("Ingrese la nueva capacidad maxima:");
            String nuevoEst = vista.pedirTexto("Ingrese el nuevo estado:");
            miFestival.modificarEscenario(pos - 1, nuevaCap, nuevoEst);
            vista.mostrarMensaje("Escenario modificado exitosamente.");
        } catch (InputMismatchException e) {
            vista.limpiarEntrada();
            vista.mostrarMensaje("Error: Formato numerico incorrecto.");
        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje("Error de validacion: " + e.getMessage());
        }
    }

    public void ejecutarRetirarEscenario() {
        try {
            int pos = vista.pedirEntero("Ingrese la posicion a retirar (1-5):");
            miFestival.retirarEscenario(pos - 1);
            vista.mostrarMensaje("Escenario retirado exitosamente. Posicion liberada.");
        } catch (InputMismatchException e) {
            vista.limpiarEntrada();
            vista.mostrarMensaje("Error numerico.");
        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        }
    }

    public void ejecutarRegistrarArtista() {
        try {
            Artista nuevo = vista.leerNuevoArtista();
            miFestival.registrarArtista(nuevo);
            vista.mostrarMensaje("Artista registrado exitosamente.");
        } catch (InputMismatchException e) {
            vista.limpiarEntrada();
            vista.mostrarMensaje("Error: Los datos numericos son incorrectos.");
        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje("Error de validacion: " + e.getMessage());
        } finally {
            vista.mostrarMensaje("Proceso de registro de artista finalizado.");
        }
    }

    public void ejecutarConsultarArtistas() {
        ArrayList<Artista> lista = miFestival.consultarArtistas();
        if (lista.isEmpty()) {
            vista.mostrarMensaje("No hay artistas registrados actualmente.");
            return;
        }
        vista.mostrarMensaje("\n--- Artistas Registrados ---");
        for (Artista a : lista) {
            vista.mostrarMensaje(a.toString());
        }
    }

    public void ejecutarBuscarArtista() {
        try {
            int id = vista.pedirEntero("Ingrese el codigo del artista a buscar:");
            Artista a = miFestival.buscarArtista(id);
            vista.mostrarMensaje("Encontrado: " + a.toString());
        } catch (InputMismatchException e) {
            vista.limpiarEntrada();
            vista.mostrarMensaje("Error numerico.");
        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        }
    }

    public void ejecutarModificarArtista() {
        try {
            int id = vista.pedirEntero("Ingrese el codigo del artista a modificar:");
            String nombre = vista.pedirTexto("Nuevo nombre artistico:");
            String genero = vista.pedirTexto("Nuevo genero:");
            double duracion = vista.pedirDouble("Nueva duracion (minutos):");
            int asistentes = vista.pedirEntero("Nueva cantidad de asistentes:");
            
            miFestival.modificarArtista(id, nombre, genero, duracion, asistentes);
            vista.mostrarMensaje("Artista modificado con exito.");
        } catch (InputMismatchException e) {
            vista.limpiarEntrada();
            vista.mostrarMensaje("Error numerico.");
        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje("Error de validacion: " + e.getMessage());
        }
    }

    public void ejecutarCancelarParticipacion() {
        try {
            int id = vista.pedirEntero("Ingrese el codigo del artista a cancelar:");
            miFestival.cancelarArtista(id);
            vista.mostrarMensaje("Participacion del artista cancelada.");
        } catch (InputMismatchException e) {
            vista.limpiarEntrada();
            vista.mostrarMensaje("Error numerico.");
        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        }
    }

    public void ejecutarMostrarReporte() {
        vista.mostrarMensaje("\n========== REPORTE DEL FESTIVAL ==========");
        vista.mostrarMensaje("Escenarios configurados: " + miFestival.calcularEscenConfigurados());
        vista.mostrarMensaje("Espacios disponibles: " + miFestival.calcularCantEspaciosDisponibles());
        
        Escenario maxEsc = miFestival.encontrarEscenMaxAsistentes();
        vista.mostrarMensaje("Escenario con mayor capacidad: " + (maxEsc != null ? maxEsc.getNombre() + " (" + maxEsc.getMaxAsistente() + " personas)" : "Ninguno"));
        
        vista.mostrarMensaje("Artistas registrados: " + miFestival.calcularArtistasRegistrados());
        
        Artista maxDur = miFestival.encontrarArtistasPresentMaxDuracion();
        vista.mostrarMensaje("Artista con mayor duracion: " + (maxDur != null ? maxDur.getNombreArtistico() + " (" + maxDur.getDuracionPresentacion() + " min)" : "Ninguno"));
        
        Artista maxAsis = miFestival.encontrarArtistaMaxAsistentes();
        vista.mostrarMensaje("Artista con mas asistentes: " + (maxAsis != null ? maxAsis.getNombreArtistico() + " (" + maxAsis.getEstAsistente() + " personas)" : "Ninguno"));
        
        vista.mostrarMensaje("Promedio de duracion presentaciones: " + String.format("%.2f", miFestival.calcularPromedioDuracionPresentaciones()) + " min");
        vista.mostrarMensaje("==========================================");
    }
}