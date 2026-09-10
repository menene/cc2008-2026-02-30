import java.util.ArrayList;
public class FestivalController {
    private Festival festival;
    private VistaFC vistaFC;
    private CrudController crudController;

    public FestivalController() {
        this.vistaFC = new VistaFC();
        this.crudController = new CrudController();
    }

    public void iniciar() {
        crearNuevoFestival();
        Menu(); 
    }

    private void crearNuevoFestival() {
        vistaFC.ImprTitulosGen("Creacion Inicial del Festival");
        String nombre = vistaFC.InputText("Nombre del festival: ");
        String codigo = vistaFC.InputText("Codigo del festival: ");
        String coordinador = vistaFC.InputText("Nombre del coordinador: ");

        this.festival = new Festival(codigo, nombre, coordinador);
        vistaFC.ImprTextoGen("\n");
    }

    public void Menu() {
        int opcion = 0;
        do {
            try {
                opcion = vistaFC.Menu();
                if (festival == null && opcion != 1 && opcion != 13) {
                    vistaFC.ImprTextoGen("Debe crear el festival ");
                    continue; 
                }
                switch (opcion) {
                    case 1:
                        crearNuevoFestival();
                        break;
                    case 2:
                        configurarEscenario();
                        break;
                    case 3:
                        crudController.consultarEscenarios(festival);
                        break;
                    case 4:
                        int posConsulta = crudController.getVistaCrud().pedirPosicion();
                        crudController.consultarUnEscenario(festival, posConsulta);
                        break;
                    case 5:
                        modificarEscenario();
                        break;
                    case 6:
                        int posRetiro = crudController.getVistaCrud().pedirPosicion();
                        crudController.retirarEscenario(festival, posRetiro);
                        break;
                    case 7:
                        registrarArtista();
                        break;
                    case 8:
                        crudController.consultarArtistas(festival);
                        break;
                    case 9:
                        buscarArtista();
                        break;
                    case 10:
                        modificarArtista();
                        break;
                    case 11:
                        String codCancelar = crudController.getVistaCrud().pedirCodigo();
                        crudController.cancelarParticipacion(festival, codCancelar);
                        break;
                    case 12:
                        MostrarReporte();
                        break;
                    case 13:
                        vistaFC.ImprTextoGen("Fuera del sistema");
                        break;
                    default:
                        vistaFC.ImprTextoGen("Opcion invalida");
                }
            } catch (Exception e) {
                vistaFC.ImprTextoGen("Esta mal en algo " + e.getMessage());
            } finally {
                System.out.println("\n");
            }
        } while (opcion != 13);
    }

    private void configurarEscenario() {
        try {
            int pos = crudController.getVistaCrud().pedirPosicion();
            Escenario nuevoEsc = crudController.getVistaCrud().pedirDatosEscenario();
            crudController.configurarEscenario(festival, pos, nuevoEsc);
        } catch (IllegalArgumentException e) {
            vistaFC.ImprTextoGen("Error al crear el escenario: " + e.getMessage());
        }
    }

    private void registrarArtista() {
        try {
            Artista nuevoArt = crudController.getVistaCrud().pedirDatosArtista();
            crudController.registrarArtista(festival, nuevoArt);
        } catch (IllegalArgumentException e) {
            vistaFC.ImprTextoGen("Error al registrar el artista: " + e.getMessage());
        }
    }

    private void modificarEscenario() {
        int pos = crudController.getVistaCrud().pedirPosicion();
        int cap = crudController.getVistaCrud().pedirEntero("Ingrese la nueva capacidad: ");
        String est = crudController.getVistaCrud().pedirTexto("Ingrese el nuevo estado: ");
        crudController.modificarEscenario(festival, pos, cap, est);
    }

    private void buscarArtista() {
        String cod = crudController.getVistaCrud().pedirCodigo();
        Artista a = crudController.buscarArtista(festival, cod);
        if (a != null) {
            crudController.getVistaCrud().mostrarArtista(a);
        } else {
            vistaFC.ImprTextoGen("No se encontro ningun artista con el codigo " + cod);
        }
    }

    private void modificarArtista() {
        String cod = crudController.getVistaCrud().pedirCodigo();
        if (crudController.buscarArtista(festival, cod) != null) {
            String nom = crudController.getVistaCrud().pedirTexto("Nuevo nombre artistico: ");
            String gen = crudController.getVistaCrud().pedirTexto("Nuevo genero musical: ");
            int dur = crudController.getVistaCrud().pedirEntero("Nueva duracion (min): ");
            int asi = crudController.getVistaCrud().pedirEntero("Nueva cantidad de asistentes: ");
            crudController.modificarArtista(festival, cod, nom, gen, dur, asi);
        } else {
            vistaFC.ImprTextoGen("El artista con codigo " + cod + " no existe.");
        }
    }

    public void EscenariosConfigurados() {
        vistaFC.ImprTextoGen("Escenarios configurados: " + contarEscenarios());
    }

    public void EspacioDispEscenario() {
        vistaFC.ImprTextoGen("Espacios disponibles para escenarios: " + (5 - contarEscenarios()));
    }

    public void EscMaxAssistants() {
        Escenario[] escenarios = festival.getEscenarios();
        Escenario mayor = null;

        for (int i = 0; i < escenarios.length; i++) {
            if (escenarios[i] != null) {
                if (mayor == null || escenarios[i].getCapacidad() > mayor.getCapacidad()) {
                    mayor = escenarios[i];
                }
            }
        }

        if (mayor != null) {
            vistaFC.ImprTextoGen("Escenario con mayor capacidad: " + mayor.getNombre() + " (Capacidad: " + mayor.getCapacidad() + ")");
        } else {
            vistaFC.ImprTextoGen("Escenario con max cap");
        }
    }

    public void CantArtistas() {
        vistaFC.ImprTextoGen("Artistas registrados: " + festival.getArtistas().size());
    }

    public void ArtsmaxDuracion() {
        ArrayList<Artista> artistas = festival.getArtistas();
        if (artistas.isEmpty()) {
            vistaFC.ImprTextoGen("Artista con mayor duracion");
            return;
        }

        Artista mayor = artistas.get(0);
        for (int i = 1; i < artistas.size(); i++) {
            if (artistas.get(i).getDuracion() > mayor.getDuracion()) {
                mayor = artistas.get(i);
            }
        }
        vistaFC.ImprTextoGen("Artista con mayor duracion: " + mayor.getNombre() + " " + mayor.getDuracion()+"min");
    }

    public void ArtistaMaxAssistans() {
        ArrayList<Artista> artistas = festival.getArtistas();
        if (artistas.isEmpty()) {
            vistaFC.ImprTextoGen("Artista con mas asistentes:");
            return;
        }

        Artista mayor = artistas.get(0);
        for (int i = 1; i < artistas.size(); i++) {
            if (artistas.get(i).getAsistentes() > mayor.getAsistentes()) {
                mayor = artistas.get(i);
            }
        }
        vistaFC.ImprTextoGen("Artista con mayor mas asistentes: " + mayor.getNombre() + " " + mayor.getAsistentes() + " asistentes");
    }

    public void PromedioPresentaciones() {
        ArrayList<Artista> artistas = festival.getArtistas();
        if (artistas.isEmpty()) {
            vistaFC.ImprTextoGen("Promedio de duracion de presentaciones: 0.0 min");
            return;
        }

        int suma = 0;
        for (int i = 0; i < artistas.size(); i++) {
            suma += artistas.get(i).getDuracion();
        }
        double promedio = (double) suma / artistas.size();
        vistaFC.ImprTextoGen("Promedio de duracion de presentaciones: " + String.format("%.2f", promedio) + " min");
    }

    public void MostrarReporte() {
        vistaFC.ImprTitulosGen("REPORTE GENERAL DEL FESTIVAL");
        vistaFC.ImprTextoGen("Festival: " + festival.getNombre() + " -> " + festival.getCodigo() );
        vistaFC.ImprTextoGen("Coordinador: " + festival.getNombreCoordinador());
        System.out.println("\n");
        EscenariosConfigurados();
        EspacioDispEscenario();
        EscMaxAssistants();
        System.out.println("\n");
        CantArtistas();
        ArtsmaxDuracion();
        ArtistaMaxAssistans();
        PromedioPresentaciones();
    }

    private int contarEscenarios() {
        Escenario[] escenarios = festival.getEscenarios();
        int contador = 0;
        for (int i = 0; i < escenarios.length; i++) {
            if (escenarios[i] != null) {
                contador++;
            }
        }
        return contador;
    }
}