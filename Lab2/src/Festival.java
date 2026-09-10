public class Festival {
    private String nombre;
    private String codigo;
    private String coordinador;
    private Escenario[] escenarios;

    public Festival(String nombre, String codigo, String coordinador) {
        validarTexto(nombre, "El nombre");
        validarTexto(codigo, "El código");
        validarTexto(coordinador, "El coordinador");

        this.nombre = nombre;
        this.codigo = codigo;
        this.coordinador = coordinador;
        this.escenarios = new Escenario[5];
    }

    private void validarTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " no puede estar vacío");
        }
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
        return escenarios;
    }

    private void validarPosicion(int posicion) {
        if (posicion < 0 || posicion >= escenarios.length) {
            throw new IndexOutOfBoundsException("La posición debe estar entre 1 y 5");
        }
    }

    public Escenario obtenerEscenario(int posicion) {
        validarPosicion(posicion);
        return escenarios[posicion];
    }

    public void configurarEscenario(int posicion, Escenario escenario) {
        validarPosicion(posicion);

        if (escenarios[posicion] != null) {
            throw new IllegalStateException("La posición ya contiene un escenario");
        }

        if (escenario == null) {
            throw new IllegalArgumentException("El escenario no puede ser null");
        }

        escenarios[posicion] = escenario;
    }

    public void retirarEscenario(int posicion) {
        validarPosicion(posicion);

        if (escenarios[posicion] == null) {
            throw new IllegalStateException("La posición está vacía");
        }

        escenarios[posicion] = null;
    }

    public int contarEscenarios() {
        int cantidad = 0;

        for (Escenario escenario : escenarios) {
            if (escenario != null) {
                cantidad++;
            }
        }

        return cantidad;
    }

    public Escenario escenarioMayorCapacidad() {
        Escenario mayor = null;

        for (Escenario escenario : escenarios) {
            if (escenario != null) {
                if (mayor == null || escenario.getCapacidad() > mayor.getCapacidad()) {
                    mayor = escenario;
                }
            }
        }

        return mayor;
    }
}