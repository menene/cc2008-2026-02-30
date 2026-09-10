package model;

import java.util.ArrayList;

public class Festival {
    public static final int MAXIMO_ESCENARIOS = 5;

    private final String nombre;
    private final String codigo;
    private final String coordinador;
    private final Escenario[] escenarios;
    private final ArrayList<Artista> artistas;

    public Festival(String nombre, String codigo, String coordinador) {
        this.nombre = validarTexto(nombre, "El nombre del festival");
        this.codigo = validarTexto(codigo, "El código del festival");
        this.coordinador = validarTexto(coordinador, "El coordinador");
        escenarios = new Escenario[MAXIMO_ESCENARIOS];
        artistas = new ArrayList<Artista>();
    }

    private static String validarTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " no puede estar vacío.");
        }
        return valor.trim();
    }

    private void validarPosicion(int posicion) {
        if (posicion < 0 || posicion >= escenarios.length) {
            throw new IllegalArgumentException("La posición debe estar entre 1 y " + escenarios.length + ".");
        }
    }

    public void configurarEscenario(int posicion, Escenario escenario) {
        validarPosicion(posicion);
        if (escenario == null) {
            throw new IllegalArgumentException("El escenario no puede ser null.");
        }
        if (escenarios[posicion] != null) {
            throw new IllegalStateException("La posición seleccionada ya está ocupada.");
        }
        escenarios[posicion] = escenario;
    }

    public Escenario[] consultarEscenarios() { 
        return escenarios.clone(); 
    }

    public Escenario consultarEscenario(int posicion) {
        validarPosicion(posicion);
        if (escenarios[posicion] == null) {
            throw new IllegalStateException("La posición seleccionada está vacía.");
        }
        return escenarios[posicion];
    }

    public void modificarEscenario(int posicion, int nuevaCapacidad, String nuevoEstado) {
        Escenario escenario = consultarEscenario(posicion);
        escenario.setCapacidadMaxima(nuevaCapacidad);
        escenario.setEstado(nuevoEstado);
    }

    public void retirarEscenario(int posicion) {
        consultarEscenario(posicion);
        escenarios[posicion] = null;
    }

    public void registrarArtista(Artista artista) {
        if (artista == null) {
            throw new IllegalArgumentException("El artista no puede ser null.");
        }
        if (buscarArtista(artista.getCodigo()) != null) {
            throw new IllegalStateException("Ya existe un artista con ese código.");
        }
        artistas.add(artista);
    }

    public ArrayList<Artista> consultarArtistas() {
        return new ArrayList<Artista>(artistas);
    }

    public Artista buscarArtista(int codigo) {
        for (int i = 0; i < artistas.size(); i++) {
            if (artistas.get(i).getCodigo() == codigo) {
                return artistas.get(i);
            }
        }
        return null;
    }

    private Artista obtenerArtista(int codigo) {
        Artista artista = buscarArtista(codigo);
        if (artista == null) {
            throw new IllegalStateException("No se encontró un artista con el código indicado.");
        }
        return artista;
    }

    public void modificarArtista(int codigo, String nombreArtistico, String generoMusical, int duracion, int asistentes) {
        Artista artista = obtenerArtista(codigo);
        artista.setNombreArtistico(nombreArtistico);
        artista.setGeneroMusical(generoMusical);
        artista.setDuracionPresentacion(duracion);
        artista.setCantidadEstimadaAsistentes(asistentes);
    }

    public void cancelarArtista(int codigo) {
        Artista artista = obtenerArtista(codigo);
        artistas.remove(artista);
    }

    public int cantidadEscenariosConfigurados() {
        int cantidad = 0;
        for (int i = 0; i < escenarios.length; i++) {
            if (escenarios[i] != null) cantidad++;
        }
        return cantidad;
    }

    public int cantidadEspaciosDisponibles() {
        return escenarios.length - cantidadEscenariosConfigurados();
    }

    public Escenario escenarioMayorCapacidad() {
        Escenario mayor = null;
        for (int i = 0; i < escenarios.length; i++) {
            if (escenarios[i] != null &&
                (mayor == null || escenarios[i].getCapacidadMaxima() > mayor.getCapacidadMaxima())) {
                mayor = escenarios[i];
            }
        }
        return mayor;
    }

    public int cantidadArtistasRegistrados() { 
        return artistas.size(); 
    }

    public Artista artistaMayorDuracion() {
        if (artistas.isEmpty()) return null;
        Artista mayor = artistas.get(0);
        for (int i = 1; i < artistas.size(); i++) {
            if (artistas.get(i).getDuracionPresentacion() > mayor.getDuracionPresentacion()) {
                mayor = artistas.get(i);
            }
        }
        return mayor;
    }

    public Artista artistaMayorAsistencia() {
        if (artistas.isEmpty()) return null;
        Artista mayor = artistas.get(0);
        for (int i = 1; i < artistas.size(); i++) {
            if (artistas.get(i).getCantidadEstimadaAsistentes() >
                mayor.getCantidadEstimadaAsistentes()) {
                mayor = artistas.get(i);
            }
        }
        return mayor;
    }

    public double promedioDuracionPresentaciones() {
        if (artistas.isEmpty()) return 0.0;
        int total = 0;
        for (int i = 0; i < artistas.size(); i++) {
            total += artistas.get(i).getDuracionPresentacion();
        }
        return (double) total / artistas.size();
    }

    public String getNombre() { 
        return nombre; 
    }

    public String getCodigo() { 
        return codigo; 
    }

    public String getCoordinador() { 
        return coordinador; 
    }

    public Escenario[] getEscenarios() { 
        return escenarios.clone(); 
    }

    public ArrayList<Artista> getArtistas() { 
        return new ArrayList<Artista>(artistas); 
    }
}