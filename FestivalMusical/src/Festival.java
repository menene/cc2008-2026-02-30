import java.util.ArrayList;

/* Clase del festival. Guarda los escenarios en un arreglo basico y los artistas en un ArrayList. */
public class Festival {

    private String nombre;
    private String codigoIdentificacion;
    private String nombreCoordinador;
    private Escenario[] escenarios;
    private static final int MAX_ESCENARIOS = 5;
    private ArrayList<Artista> artistas;

    /* Constructor. Crea el arreglo de 5 escenarios, que queda todo en null, y el ArrayList vacio */
    public Festival(String nombre, String codigoIdentificacion, String nombreCoordinador) {
        this.nombre = nombre;
        this.codigoIdentificacion = codigoIdentificacion;
        this.nombreCoordinador = nombreCoordinador;
        escenarios = new Escenario[MAX_ESCENARIOS];
        artistas = new ArrayList<Artista>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigoIdentificacion() {
        return codigoIdentificacion;
    }

    public String getNombreCoordinador() {
        return nombreCoordinador;
    }

    /* Guarda un escenario en la posicion indicada. La posicion debe existir y estar libre */
    public void configurarEscenario(int posicion, Escenario escenario) {
        if (posicionValida(posicion) == false) {
            throw new ArrayIndexOutOfBoundsException("La posicion " + posicion + " no existe, debe estar entre 0 y " + (MAX_ESCENARIOS - 1));
        }

        if (escenarios[posicion] != null) {
            throw new IllegalArgumentException("La posicion " + posicion + " ya tiene un escenario configurado");
        }

        escenarios[posicion] = escenario;
    }

    /* Revisa si el numero que dio el usuario esta dentro del arreglo, o sea entre 0 y 4 */
    private boolean posicionValida(int posicion) {
        if (posicion >= 0 && posicion < MAX_ESCENARIOS) {
            return true;
        }

        return false;
    }

    /* Revisa si esa posicion ya tiene un escenario guardado o si todavia esta en null */
    public boolean posicionOcupada(int posicion) {
        if (posicionValida(posicion) == false) {
            throw new ArrayIndexOutOfBoundsException("La posicion " + posicion + " no existe, debe estar entre 0 y " + (MAX_ESCENARIOS - 1));
        }

        if (escenarios[posicion] != null) {
            return true;
        }

        return false;
    }

    /* Devuelve el escenario guardado en esa posicion. Si la posicion esta vacia devuelve null */
    public Escenario getEscenario(int posicion) {
        if (posicionValida(posicion) == false) {
            throw new ArrayIndexOutOfBoundsException("La posicion " + posicion + " no existe, debe estar entre 0 y " + (MAX_ESCENARIOS - 1));
        }

        return escenarios[posicion];
    }

    /* Recorre el arreglo y arma el texto con los escenarios configurados. Se salta los null */
    public String listarEscenarios() {
        String listado = "";

        for (int i = 0; i < MAX_ESCENARIOS; i++) {
            if (escenarios[i] != null) {
                listado = listado + "Posicion " + i + ": " + escenarios[i].toString() + "\n";
            }
        }

        if (listado.length() == 0) {
            return "Todavia no hay escenarios configurados";
        }

        return listado;
    }

    /* Cambia la capacidad y el estado de un escenario ya configurado */
    public void modificarEscenario(int posicion, int nuevaCapacidad, String nuevoEstado) {
        if (posicionValida(posicion) == false) {
            throw new ArrayIndexOutOfBoundsException("La posicion " + posicion + " no existe, debe estar entre 0 y " + (MAX_ESCENARIOS - 1));
        }

        if (escenarios[posicion] == null) {
            throw new IllegalArgumentException("La posicion " + posicion + " esta vacia, no hay escenario que modificar");
        }

        escenarios[posicion].setCapacidadMaxima(nuevaCapacidad);
        escenarios[posicion].setEstado(nuevoEstado);
    }

    /* Deja la posicion otra vez en null, con lo que el escenario se quita del festival */
    public void retirarEscenario(int posicion) {
        if (posicionValida(posicion) == false) {
            throw new ArrayIndexOutOfBoundsException("La posicion " + posicion + " no existe, debe estar entre 0 y " + (MAX_ESCENARIOS - 1));
        }

        if (escenarios[posicion] == null) {
            throw new IllegalArgumentException("La posicion " + posicion + " ya esta vacia");
        }

        escenarios[posicion] = null;
    }

    /* Recorre el arreglo y cuenta cuantas posiciones tienen un escenario guardado */
    public int contarEscenarios() {
        int contador = 0;

        for (int i = 0; i < MAX_ESCENARIOS; i++) {
            if (escenarios[i] != null) {
                contador = contador + 1;
            }
        }

        return contador;
    }

    /* Cuenta cuantas posiciones del arreglo todavia estan en null */
    public int espaciosDisponibles() {
        return MAX_ESCENARIOS - contarEscenarios();
    }

    /* Recorre el arreglo comparando capacidades y devuelve el escenario mas grande */
    public Escenario getEscenarioMayorCapacidad() {
        Escenario mayor = null;

        for (int i = 0; i < MAX_ESCENARIOS; i++) {
            if (escenarios[i] != null) {
                if (mayor == null) {
                    mayor = escenarios[i];
                } else if (escenarios[i].getCapacidadMaxima() > mayor.getCapacidadMaxima()) {
                    mayor = escenarios[i];
                }
            }
        }

        return mayor;
    }

    /* Agrega un artista al ArrayList. Antes revisa que su codigo no lo tenga ya otro artista */
    public void registrarArtista(Artista artista) {
        if (existeCodigoArtista(artista.getCodigo()) == true) {
            throw new IllegalArgumentException("Ya existe un artista registrado con el codigo " + artista.getCodigo());
        }

        artistas.add(artista);
    }

    /* Recorre el ArrayList comparando codigos. Devuelve null si ninguno coincide */
    public Artista buscarArtista(String codigo) {
        for (int i = 0; i < artistas.size(); i++) {
            if (artistas.get(i).getCodigo().equalsIgnoreCase(codigo) == true) {
                return artistas.get(i);
            }
        }

        return null;
    }

    /* Revisa si algun artista ya tiene ese codigo, para no repetirlos */
    private boolean existeCodigoArtista(String codigo) {
        if (buscarArtista(codigo) != null) {
            return true;
        }

        return false;
    }

    /* Busca al artista por su codigo y lo saca del ArrayList */
    public boolean cancelarParticipacion(String codigo) {
        for (int i = 0; i < artistas.size(); i++) {
            if (artistas.get(i).getCodigo().equalsIgnoreCase(codigo) == true) {
                artistas.remove(i);
                return true;
            }
        }

        return false;
    }

    /* Recorre el ArrayList y arma el texto con la informacion de todos los artistas */
    public String listarArtistas() {
        if (artistas.size() == 0) {
            return "Todavia no hay artistas registrados";
        }

        String listado = "";

        for (int i = 0; i < artistas.size(); i++) {
            listado = listado + artistas.get(i).toString() + "\n";
        }

        return listado;
    }

    /* Devuelve cuantos artistas hay registrados en el ArrayList */
    public int contarArtistas() {
        return artistas.size();
    }

    /* Recorre el ArrayList comparando duraciones y devuelve la presentacion mas larga */
    public Artista getArtistaMayorDuracion() {
        Artista mayor = null;

        for (int i = 0; i < artistas.size(); i++) {
            if (mayor == null) {
                mayor = artistas.get(i);
            } else if (artistas.get(i).getDuracionMinutos() > mayor.getDuracionMinutos()) {
                mayor = artistas.get(i);
            }
        }

        return mayor;
    }

    /* Recorre el ArrayList comparando asistentes y devuelve al artista que atrae a mas gente */
    public Artista getArtistaMayorAsistentes() {
        Artista mayor = null;

        for (int i = 0; i < artistas.size(); i++) {
            if (mayor == null) {
                mayor = artistas.get(i);
            } else if (artistas.get(i).getAsistentesEstimados() > mayor.getAsistentesEstimados()) {
                mayor = artistas.get(i);
            }
        }

        return mayor;
    }

    /* Suma las duraciones y las divide entre la cantidad de artistas. Si la lista esta vacia no divide */
    public double getPromedioDuracion() {
        if (artistas.size() == 0) {
            return 0.0;
        }

        int sumaDuraciones = 0;

        for (int i = 0; i < artistas.size(); i++) {
            sumaDuraciones = sumaDuraciones + artistas.get(i).getDuracionMinutos();
        }

        return (double) sumaDuraciones / artistas.size();
    }

    /* Junta en un solo texto todos los datos del reporte del festival */
    public String generarReporte() {
        String reporte = "";

        reporte = reporte + "REPORTE DEL FESTIVAL\n";
        reporte = reporte + "Festival: " + nombre + " (" + codigoIdentificacion + ")\n";
        reporte = reporte + "Coordinador: " + nombreCoordinador + "\n";
        reporte = reporte + "Escenarios configurados: " + contarEscenarios() + "\n";
        reporte = reporte + "Espacios disponibles: " + espaciosDisponibles() + "\n";

        Escenario mayorCapacidad = getEscenarioMayorCapacidad();

        if (mayorCapacidad == null) {
            reporte = reporte + "Escenario con mayor capacidad: todavia no hay escenarios\n";
        } else {
            reporte = reporte + "Escenario con mayor capacidad: " + mayorCapacidad.getNombre()
                    + " (" + mayorCapacidad.getCapacidadMaxima() + " asistentes)\n";
        }

        reporte = reporte + "Artistas registrados: " + contarArtistas() + "\n";

        Artista mayorDuracion = getArtistaMayorDuracion();

        if (mayorDuracion == null) {
            reporte = reporte + "Presentacion mas larga: todavia no hay artistas\n";
        } else {
            reporte = reporte + "Presentacion mas larga: " + mayorDuracion.getNombreArtistico()
                    + " (" + mayorDuracion.getDuracionMinutos() + " minutos)\n";
        }

        Artista mayorAsistentes = getArtistaMayorAsistentes();

        if (mayorAsistentes == null) {
            reporte = reporte + "Artista con mas asistentes: todavia no hay artistas\n";
        } else {
            reporte = reporte + "Artista con mas asistentes: " + mayorAsistentes.getNombreArtistico()
                    + " (" + mayorAsistentes.getAsistentesEstimados() + " asistentes)\n";
        }

        reporte = reporte + "Promedio de duracion: " + getPromedioDuracion() + " minutos";

        return reporte;
    }
}
