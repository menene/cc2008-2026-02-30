import java.util.ArrayList;
import java.util.InputMismatchException;
public class ControladorFestival {
    private Festival festivalActual;
    private VistaFestival vista;
    public ControladorFestival(VistaFestival vista) {
        this.vista = vista;
        festivalActual = null;
    }
    public void iniciar() {
        int opcion = 0;
        try {
            do {
                try {
                    vista.mostrarMenu();
                    opcion = vista.leerEntero("Seleccione una opción: ");
                    ejecutarOpcion(opcion);
                } catch (InputMismatchException e) {
                    vista.limpiarEntrada();
                    vista.mostrarError("Debe ingresar un número entero.");
                } catch (IndexOutOfBoundsException | IllegalArgumentException | IllegalStateException e) {
                    vista.mostrarError(e.getMessage());
                }
            } while (opcion != 13);
        } finally {
            vista.cerrar();
            System.out.println("Programa finalizado.");
        }
    }
    private void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                nuevoFestival();
                break;
            case 2:
                configurarEscenario();
                break;
            case 3:
                consultarEscenarios();
                break;
            case 4:
                consultarUnEscenario();
                break;
            case 5:
                modificarEscenario();
                break;
            case 6:
                retirarEscenario();
                break;
            case 7:
                registrarArtista();
                break;
            case 8:
                consultarArtistas();
                break;
            case 9:
                buscarArtista();
                break;
            case 10:
                modificarArtista();
                break;
            case 11:
                cancelarParticipacion();
                break;
            case 12:
                mostrarReporte();
                break;
            case 13:
                salir();
                break;
            default:
                throw new IllegalArgumentException(
                    "La opción seleccionada no es válida."
                );
        }
    }
    private boolean verificarFestival() {
        if (festivalActual != null) return true;
        vista.mostrarError("Primero debe crear un festival.");
        return false;
    }
    private void salir() {
        vista.mostrarMensaje("Gracias por utilizar el sistema.");
    }
    private void nuevoFestival() {
        String nombre = vista.leerTexto("Nombre del festival: ");
        String codigo = vista.leerTexto("Código de identificación: ");
        String coordinador = vista.leerTexto("Nombre del coordinador: ");
        festivalActual = new Festival(nombre, codigo, coordinador);
        vista.mostrarMensaje("Festival creado correctamente.");
        vista.mostrarFestival(festivalActual);
    }
    private void validarPosicion(int posicion) {
        int limite = festivalActual.getEscenarios().length;
        if (posicion < 0 || posicion >= limite)
            throw new IndexOutOfBoundsException("La posición debe estar entre 0 y " + (limite - 1) + ".");
    }
    private void configurarEscenario() {
        if (!verificarFestival()) return;
        int posicion = vista.leerEntero("Posición del escenario (0-4): ");
        validarPosicion(posicion);
        Escenario[] escenarios = festivalActual.getEscenarios();
        if (escenarios[posicion] != null)
            throw new IllegalStateException("La posición ya está ocupada.");
        String codigo = vista.leerTexto("Código del escenario: ");
        String nombre = vista.leerTexto("Nombre del escenario: ");
        String ubicacion = vista.leerTexto("Ubicación: ");
        int capacidad = vista.leerEntero("Capacidad máxima: ");
        String estado = vista.leerTexto("Estado: ");
        escenarios[posicion] = new Escenario(codigo, nombre, ubicacion, capacidad, estado);
        vista.mostrarMensaje("Escenario configurado correctamente.");
    }
    private void consultarEscenarios() {
        if (!verificarFestival()) return;
        Escenario[] escenarios = festivalActual.getEscenarios();
        boolean encontrado = false;
        for (int i = 0; i < escenarios.length; i++) {
            if (escenarios[i] != null) {
                vista.mostrarEscenario(escenarios[i], i);
                encontrado = true;
            }
        }
        if (!encontrado) vista.mostrarMensaje("No existen escenarios configurados.");
    }
    private void consultarUnEscenario() {
        if (!verificarFestival()) return;
        int posicion = vista.leerEntero("Posición que desea consultar: ");
        validarPosicion(posicion);
        Escenario escenario = festivalActual.getEscenarios()[posicion];
        if (escenario == null)
            throw new IllegalStateException("La posición está vacía.");
        vista.mostrarEscenario(escenario, posicion);
    }
    private void modificarEscenario() {
        if (!verificarFestival()) return;
        int posicion = vista.leerEntero("Posición del escenario: ");
        validarPosicion(posicion);
        Escenario escenario = festivalActual.getEscenarios()[posicion];
        if (escenario == null)
            throw new IllegalStateException("La posición no contiene un escenario.");
        int capacidad = vista.leerEntero("Nueva capacidad máxima: ");
        String estado = vista.leerTexto("Nuevo estado: ");
        escenario.setCapacidadMaxima(capacidad);
        escenario.setEstado(estado);
        vista.mostrarMensaje("Escenario modificado correctamente.");
    }
    private void retirarEscenario() {
        if (!verificarFestival()) return;
        int posicion = vista.leerEntero("Posición del escenario: ");
        validarPosicion(posicion);
        Escenario[] escenarios = festivalActual.getEscenarios();
        if (escenarios[posicion] == null)
            throw new IllegalStateException("La posición está vacía.");
        escenarios[posicion] = null;
        vista.mostrarMensaje("Escenario retirado correctamente.");
    }
    private int buscarIndiceArtista(String codigo) {
        ArrayList<Artista> artistas = festivalActual.getArtistas();
        for (int i = 0; i < artistas.size(); i++)
            if (artistas.get(i).getCodigo().equalsIgnoreCase(codigo)) return i;
        return -1;
    }
    private boolean codigoArtistaExiste(String codigo) {
        return buscarIndiceArtista(codigo) != -1;
    }
    private void registrarArtista() {
        if (!verificarFestival()) return;
        String codigo = vista.leerTexto("Código del artista: ");
        if (codigoArtistaExiste(codigo))
            throw new IllegalArgumentException("Ya existe un artista con ese código.");
        String nombre = vista.leerTexto("Nombre artístico: ");
        String genero = vista.leerTexto("Género musical: ");
        int tiempo = vista.leerEntero("Tiempo de presentación: ");
        int publico = vista.leerEntero("Público estimado: ");
        festivalActual.getArtistas().add(new Artista(codigo, nombre, genero, tiempo, publico));
        vista.mostrarMensaje("Artista registrado correctamente.");
    }
    private void consultarArtistas() {
        if (!verificarFestival()) return;
        ArrayList<Artista> artistas = festivalActual.getArtistas();
        if (artistas.isEmpty()) {
            vista.mostrarMensaje("No existen artistas registrados.");
            return;
        }
        for (Artista artista : artistas) vista.mostrarArtista(artista);
    }
    private void buscarArtista() {
        if (!verificarFestival()) return;
        String codigo = vista.leerTexto("Código del artista: ");
        int indice = buscarIndiceArtista(codigo);
        if (indice == -1)
            throw new IllegalArgumentException("No existe un artista con ese código.");
        vista.mostrarArtista(festivalActual.getArtistas().get(indice));
    }
    private void modificarArtista() {
        if (!verificarFestival()) return;
        String codigo = vista.leerTexto("Código del artista: ");
        int indice = buscarIndiceArtista(codigo);
        if (indice == -1)
            throw new IllegalArgumentException("No existe un artista con ese código.");
        String nombre = vista.leerTexto("Nuevo nombre artístico: ");
        String genero = vista.leerTexto("Nuevo género musical: ");
        int tiempo = vista.leerEntero("Nuevo tiempo de presentación: ");
        int publico = vista.leerEntero("Nuevo público estimado: ");
        Artista datos = new Artista(codigo, nombre, genero, tiempo, publico);
        Artista artista = festivalActual.getArtistas().get(indice);
        artista.setNombreArtistico(datos.getNombreArtistico());
        artista.setGeneroMusical(datos.getGeneroMusical());
        artista.setTiempoPresentacion(datos.getTiempoPresentacion());
        artista.setPublico(datos.getPublico());
        vista.mostrarMensaje("Artista modificado correctamente.");
    }
    private void cancelarParticipacion() {
        if (!verificarFestival()) return;
        String codigo = vista.leerTexto("Código del artista: ");
        int indice = buscarIndiceArtista(codigo);
        if (indice == -1)
            throw new IllegalArgumentException("No existe un artista con ese código.");
        festivalActual.getArtistas().remove(indice);
        vista.mostrarMensaje("Participación cancelada correctamente.");
    }
    private int contarEscenariosConfigurados() {
        int contador = 0;
        for (Escenario escenario : festivalActual.getEscenarios())
            if (escenario != null) contador++;
        return contador;
    }
    private int contarEspaciosDisponibles() {
        return festivalActual.getEscenarios().length - contarEscenariosConfigurados();
    }
    private Escenario buscarEscenarioMayorCapacidad() {
        Escenario mayor = null;
        for (Escenario escenario : festivalActual.getEscenarios())
            if (escenario != null && (mayor == null ||
                    escenario.getCapacidadMaxima() > mayor.getCapacidadMaxima()))
                mayor = escenario;
        return mayor;
    }
    private Artista buscarArtistaMayorDuracion() {
        ArrayList<Artista> artistas = festivalActual.getArtistas();
        if (artistas.isEmpty()) return null;
        Artista mayor = artistas.get(0);
        for (int i = 1; i < artistas.size(); i++)
            if (artistas.get(i).getTiempoPresentacion() >
                    mayor.getTiempoPresentacion())
                mayor = artistas.get(i);
        return mayor;
    }
    private Artista buscarArtistaMayorAsistencia() {
        ArrayList<Artista> artistas = festivalActual.getArtistas();
        if (artistas.isEmpty()) return null;
        Artista mayor = artistas.get(0);
        for (int i = 1; i < artistas.size(); i++)
            if (artistas.get(i).getPublico() > mayor.getPublico())
                mayor = artistas.get(i);
        return mayor;
    }
    private double calcularPromedioDuracion() {
        ArrayList<Artista> artistas = festivalActual.getArtistas();
        if (artistas.isEmpty()) return 0.0;
        int suma = 0;
        for (Artista artista : artistas)
            suma += artista.getTiempoPresentacion();
        return (double) suma / artistas.size();
    }
    private void mostrarReporte() {
        if (!verificarFestival()) return;
        vista.mostrarReporte(
            contarEscenariosConfigurados(),
            contarEspaciosDisponibles(),
            buscarEscenarioMayorCapacidad(),
            festivalActual.getArtistas().size(),
            buscarArtistaMayorDuracion(),
            buscarArtistaMayorAsistencia(),
            calcularPromedioDuracion()
        );
    }
}