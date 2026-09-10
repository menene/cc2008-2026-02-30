import java.util.ArrayList;

public class Festival {

    private String nombreFest;
    private String codigoFest;
    private String coordinaforFest;
    private Escenario[] escenarios;
    private ArrayList<Artista> artistas;

    public Festival(String nombreFest, String codigoFest, String coordinaforFest) {
        this.nombreFest = nombreFest;
        this.codigoFest = codigoFest;
        this.coordinaforFest = coordinaforFest;
        this.escenarios = new Escenario[5];
        this.artistas = new ArrayList<Artista>();
    }

    public String getNombre() {
        return nombreFest;
    }

    public String getCodigo() {
        return codigoFest;
    }

    public String getCoordinador() {
        return coordinaforFest;
    }

    public void configurarEscenario(int posicion, Escenario escenario) {
        if (!posicionValida(posicion)) {
            throw new IllegalArgumentException("La posición indicada está fuera de los límites");
        }
        if (!posicionDisponible(posicion)) {
            throw new IllegalArgumentException("La posición seleccionada ya se encuentra ocupada por otro escenario");
        }
        if (escenario == null) {
            throw new IllegalArgumentException("El escenario proporcionado no es válido");
        }
        escenarios[posicion] = escenario;
    }

//consutla de los escenarios
    public String consultarEscenarios() {
        StringBuilder sb = new StringBuilder();
        boolean hayEscenarios = false;
        for (int i = 0; i < escenarios.length; i++) {
            if (escenarios[i] != null) {
                hayEscenarios = true;
                sb.append("Posición ").append(i + 1).append(" -> ").append(detalleEscenario(escenarios[i])).append("\n");
            }
        }

        if (!hayEscenarios) {
            return "No hay escenarios configurados actualmente."; //por si no hay escenarios
        }
        return sb.toString();
    }
//escenario específico
    public String consultarEscenario(int posicion) {
        if (!posicionValida(posicion)) {
            return "La posición indicada no es válida. Debe estar entre 1 y " + escenarios.length;
        }
        Escenario e = escenarios[posicion];
        if (e == null) {
            return "La posición " + (posicion + 1) + " se encuentra vacía (sin escenario configurado)";
        }
        return detalleEscenario(e);
    }
//para modificar un escenario
    public void modificarEscenario(int posicion, int nuevaCapacidadMaximaEsc, String nuevoEstadoEsc) {
        if (!posicionValida(posicion)) {
            throw new IllegalArgumentException("La posición indicada está fuera de los límites del arreglo de escenarios");
        }
        Escenario e = escenarios[posicion];
        if (e == null) {
            throw new IllegalArgumentException("No se puede modificar: la posición indicada no contiene un escenario");
        }
        e.setCapacidadMaxima(nuevaCapacidadMaximaEsc);
        e.setEstado(nuevoEstadoEsc);
    }

    public void retirarEscenario(int posicion) {

        if (posicionValida(posicion)) {
            escenarios[posicion] = null;
        }
    }

    public void registrarArtista(Artista artista) {

        if (artista == null) {
            throw new IllegalArgumentException("El artista proporcionado no es válido");
        }

        if (buscarIndiceArtista(artista.getCodigo()) != -1) {
            throw new IllegalArgumentException("Ya existe un artista registrado con el código " + artista.getCodigo());
        }
        artistas.add(artista);
    }

//ahora los procesos, pero con artista
    public String consultarArtistas() {

        if (artistas.isEmpty()) {
            return "No hay artistas registrados actualmente.";
        }
        StringBuilder sb = new StringBuilder();
        for (Artista a : artistas) {
            sb.append(detalleArtista(a)).append("\n");
        }
        return sb.toString();
    }

    public Artista buscarArtista(String codigoArt) {
        int indice = buscarIndiceArtista(codigoArt);
        if (indice == -1) {
            return null;
        }
        return artistas.get(indice);
    }

    public void modificarArtista(String codigoArt, String nombreArt, String generoArt, int duracionArt, int asistentesArt) {
        int indice = buscarIndiceArtista(codigoArt);
        if (indice == -1) {
            throw new IllegalArgumentException("No existe un artista registrado con el código " + codigoArt);
        }

        Artista a = artistas.get(indice);
        a.setDuracionPresentacion(duracionArt);
        a.setCantidadAsistentes(asistentesArt);
        a.setNombreArtistico(nombreArt);
        a.setGeneroMusical(generoArt);
    }

    public void cancelarParticipacion(String codigoArt) {

        int indice = buscarIndiceArtista(codigoArt);
        if (indice != -1) {
            artistas.remove(indice);
        }
    }

//para generar todas las estadísticas y otras cosas en el reporte
    public String generarReporte() {
        StringBuilder sb = new StringBuilder();

        int espaciosDisponibles = contarEspaciosDisponibles();
        int escenariosConfigurados = escenarios.length - espaciosDisponibles;

        sb.append("Cantidad de escenarios configurados: ").append(escenariosConfigurados).append("\n");
        sb.append("Cantidad de espacios disponibles para escenarios: ").append(espaciosDisponibles).append("\n");

        Escenario mayorCapacidad = obtenerEscenarioMayorCapacidad();
        if (mayorCapacidad != null) {
            sb.append("Escenario con mayor capacidad máxima: ")
              .append(mayorCapacidad.getNombre())
              .append(" (").append(mayorCapacidad.getCapacidadMaxima()).append(" personas)\n");
        } else {
            sb.append("Escenario con mayor capacidad máxima: no hay escenarios configurados.\n");
        }

        sb.append("Cantidad de artistas registrados: ").append(artistas.size()).append("\n");

        Artista mayorDuracion = obtenerArtistaMayorDuracion();
        if (mayorDuracion != null) {
            sb.append("Artista con la presentación de mayor duración: ")
              .append(mayorDuracion.getNombreArtistico())
              .append(" (").append(mayorDuracion.getDuracionPresentacion()).append(" min)\n");
        } else {
            sb.append("Artista con la presentación de mayor duración: no hay artistas registrados.\n");
        }

        Artista mayorAsistencia = obtenerArtistaMayorAsistencia();
        if (mayorAsistencia != null) {
            sb.append("Artista con mayor cantidad estimada de asistentes: ")
              .append(mayorAsistencia.getNombreArtistico())
              .append(" (").append(mayorAsistencia.getCantidadEstimadaAsistentes()).append(" asistentes)\n");
        } else {
            sb.append("Artista con mayor cantidad estimada de asistentes: no hay artistas registrados.\n");
        }

        sb.append("Promedio de duración de las presentaciones: ")
          .append(String.format("%.2f", calcularPromedioDuracion())).append(" min\n");

        return sb.toString();
    }

    private boolean posicionValida(int posicion) {
        return posicion >= 0 && posicion < escenarios.length;
    }

    private boolean posicionDisponible(int posicion) {
        return escenarios[posicion] == null;
    }

    private int buscarIndiceArtista(String codigoArt) {

        for (int i = 0; i < artistas.size(); i++) {

            if (artistas.get(i).getCodigo().equals(codigoArt)) {
                return i;
            }
        }
        return -1;
    }

    private int contarEspaciosDisponibles() {

        int contador = 0;

        for (Escenario e : escenarios) {
            if (e == null) {
                contador++;
            }
        }
        return contador;
    }

    private Escenario obtenerEscenarioMayorCapacidad() {
        Escenario mayor = null;
        for (Escenario e : escenarios) {
            if (e != null) {
                if (mayor == null || e.getCapacidadMaxima() > mayor.getCapacidadMaxima()) {
                    mayor = e;
                }
            }
        }
        return mayor;
    }

    private Artista obtenerArtistaMayorDuracion() {
        Artista mayor = null;

        for (Artista a : artistas) {
            if (mayor == null || a.getDuracionPresentacion() > mayor.getDuracionPresentacion()) {
                mayor = a;
            }
        }
        return mayor;
    }

    private Artista obtenerArtistaMayorAsistencia() {
        Artista mayor = null;

        for (Artista a : artistas) {
            if (mayor == null || a.getCantidadEstimadaAsistentes() > mayor.getCantidadEstimadaAsistentes()) {
                mayor = a;
            }
        }
        return mayor;
    }

    private double calcularPromedioDuracion() {

        if (artistas.isEmpty()) {
            return 0.0;
        }
        int sumaDuraciones = 0;
        for (Artista a : artistas) {
            sumaDuraciones += a.getDuracionPresentacion();
        }
        return (double) sumaDuraciones / artistas.size();
    }

    private String detalleEscenario(Escenario e) {
        return "Código: " + e.getCodigo() + ", Nombre: " + e.getNombre() + ", Ubicación: " + e.getUbicacion() + ", Capacidad Máxima: " + e.getCapacidadMaxima() + ", Estado: " + e.getEstado();
    }

    private String detalleArtista(Artista a) {
        return "Código: " + a.getCodigo() + ", Nombre Artístico: " + a.getNombreArtistico() + ", Género Musical: " + a.getGeneroMusical()+ ", Duración: " + a.getDuracionPresentacion() + " min" + ", Asistentes Estimados: " + a.getCantidadEstimadaAsistentes();
    }
}
