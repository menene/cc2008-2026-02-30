import java.util.ArrayList;

/* Clase de la empresa. Guarda los envios, los vehiculos y los despachos, evita duplicados y arma los reportes. */
public class EmpresaMensajeria {

    private ArrayList<Envio> envios;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Despacho> despachos;

    /* Constructor. Empieza sin envios, sin vehiculos y sin despachos */
    public EmpresaMensajeria() {
        envios = new ArrayList<Envio>();
        vehiculos = new ArrayList<Vehiculo>();
        despachos = new ArrayList<Despacho>();
    }

    /* Muestra el costo y los dias. No guarda el envio ni cobra nada */
    public String cotizar(Envio envio) {
        if (envio == null) {
            throw new IllegalArgumentException("No hay envio que cotizar");
        }

        return "Cotizacion " + envio.getCategoria() + " (" + envio.getTipoDestino() + ")"
                + " | Costo: Q" + String.format("%,.2f", envio.calcularCosto())
                + " | Tiempo estimado: " + envio.calcularDiasEntrega() + " dia(s) habil(es)";
    }

    /* Registra el envio y cobra el monto completo. No acepta codigos repetidos */
    public void registrarEnvio(Envio envio) {
        if (envio == null) {
            throw new IllegalArgumentException("No hay envio que registrar");
        }

        if (existeCodigoEnvio(envio.getCodigo()) == true) {
            throw new IllegalArgumentException("Ya existe un envio con el codigo " + envio.getCodigo());
        }

        envio.cobrarRegistro();
        envios.add(envio);
    }

    /* Agrega un envio de los datos iniciales sin cobrarlo, porque el programa empieza sin ingresos */
    public void agregarEnvioInicial(Envio envio) {
        if (envio == null) {
            throw new IllegalArgumentException("No hay envio que agregar");
        }

        if (existeCodigoEnvio(envio.getCodigo()) == true) {
            throw new IllegalArgumentException("Ya existe un envio con el codigo " + envio.getCodigo());
        }

        envios.add(envio);
    }

    /* Dice si algun envio ya tiene ese codigo */
    private boolean existeCodigoEnvio(String codigo) {
        if (buscarEnvio(codigo) != null) {
            return true;
        }

        return false;
    }

    /* Recorre los envios comparando codigos. Devuelve null si ninguno coincide */
    public Envio buscarEnvio(String codigo) {
        if (codigo == null) {
            return null;
        }

        for (int i = 0; i < envios.size(); i++) {
            if (envios.get(i).getCodigo().equalsIgnoreCase(codigo.trim()) == true) {
                return envios.get(i);
            }
        }

        return null;
    }

    /* Agrega un vehiculo a la flotilla. No acepta placas repetidas */
    public void registrarVehiculo(Vehiculo vehiculo) {
        if (vehiculo == null) {
            throw new IllegalArgumentException("No hay vehiculo que registrar");
        }

        if (existePlaca(vehiculo.getPlaca()) == true) {
            throw new IllegalArgumentException("Ya existe un vehiculo con la placa " + vehiculo.getPlaca());
        }

        vehiculos.add(vehiculo);
    }

    /* Dice si algun vehiculo ya tiene esa placa */
    private boolean existePlaca(String placa) {
        if (buscarVehiculo(placa) != null) {
            return true;
        }

        return false;
    }

    /* Recorre la flotilla comparando placas. Devuelve null si ninguna coincide */
    public Vehiculo buscarVehiculo(String placa) {
        if (placa == null) {
            return null;
        }

        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getPlaca().equalsIgnoreCase(placa.trim()) == true) {
                return vehiculos.get(i);
            }
        }

        return null;
    }

    /* Crea un despacho con el vehiculo. El constructor de Despacho revisa que este libre */
    public Despacho crearDespacho(String placa) {
        Vehiculo vehiculo = buscarVehiculo(placa);

        if (vehiculo == null) {
            throw new IllegalArgumentException("No existe un vehiculo con la placa " + placa);
        }

        Despacho despacho = new Despacho(vehiculo);
        despachos.add(despacho);

        return despacho;
    }

    /* Recorre los despachos comparando numeros. Devuelve null si ninguno coincide */
    public Despacho buscarDespacho(int numero) {
        for (int i = 0; i < despachos.size(); i++) {
            if (despachos.get(i).getNumero() == numero) {
                return despachos.get(i);
            }
        }

        return null;
    }

    /* Busca el despacho, avisando si no existe */
    private Despacho obtenerDespacho(int numero) {
        Despacho despacho = buscarDespacho(numero);

        if (despacho == null) {
            throw new IllegalArgumentException("No existe el despacho #" + numero);
        }

        return despacho;
    }

    /* Busca el despacho y el envio, y le pide al despacho que lo asigne. Las validaciones las hace Despacho */
    public void asignarEnvio(int numeroDespacho, String codigoEnvio) {
        Despacho despacho = obtenerDespacho(numeroDespacho);
        Envio envio = buscarEnvio(codigoEnvio);

        if (envio == null) {
            throw new IllegalArgumentException("No existe un envio con el codigo " + codigoEnvio);
        }

        despacho.asignarEnvio(envio);
    }

    /* Busca el despacho y le pide que retire el envio */
    public void retirarEnvio(int numeroDespacho, String codigoEnvio) {
        obtenerDespacho(numeroDespacho).retirarEnvio(codigoEnvio);
    }

    /* Busca el despacho y lo hace salir. Los cargos por reintento quedan guardados en cada envio */
    public void hacerSalirDespacho(int numeroDespacho) {
        obtenerDespacho(numeroDespacho).salir();
    }

    /* Busca el despacho y le pide que registre el resultado de ese envio */
    public void registrarResultado(int numeroDespacho, String codigoEnvio, boolean entregado) {
        obtenerDespacho(numeroDespacho).registrarResultado(codigoEnvio, entregado);
    }

    /* Texto con todos los envios. Cada uno se describe con su propio toString */
    public String listarEnvios() {
        if (envios.size() == 0) {
            return "Todavia no hay envios registrados";
        }

        String texto = "ENVIOS";

        for (int i = 0; i < envios.size(); i++) {
            texto = texto + "\n" + envios.get(i).toString();
        }

        return texto;
    }

    /* Texto con todos los vehiculos de la flotilla */
    public String listarVehiculos() {
        if (vehiculos.size() == 0) {
            return "Todavia no hay vehiculos registrados";
        }

        String texto = "VEHICULOS";

        for (int i = 0; i < vehiculos.size(); i++) {
            texto = texto + "\n" + vehiculos.get(i).toString();
        }

        return texto;
    }

    /* Saca la lista de categorias que hay en los envios, sin repetir, en el orden en que aparecen */
    private ArrayList<String> obtenerCategorias() {
        ArrayList<String> categorias = new ArrayList<String>();

        for (int i = 0; i < envios.size(); i++) {
            String categoria = envios.get(i).getCategoria();

            if (categorias.contains(categoria) == false) {
                categorias.add(categoria);
            }
        }

        return categorias;
    }

    /* Cuenta los envios de cada categoria en cada estado, usando getCategoria() y getEstado() */
    public String reporteEnviosPorCategoriaYEstado() {
        if (envios.size() == 0) {
            return "Todavia no hay envios registrados";
        }

        String[] estados = {Envio.EN_BODEGA, Envio.ASIGNADO, Envio.EN_RUTA, Envio.ENTREGADO, Envio.DEVUELTO};
        ArrayList<String> categorias = obtenerCategorias();
        String reporte = "ENVIOS POR CATEGORIA Y ESTADO";

        for (int i = 0; i < categorias.size(); i++) {
            int total = 0;
            String detalle = "";

            for (int j = 0; j < estados.length; j++) {
                int cantidad = 0;

                for (int k = 0; k < envios.size(); k++) {
                    Envio envio = envios.get(k);

                    if (envio.getCategoria().equals(categorias.get(i)) == true && envio.getEstado().equals(estados[j]) == true) {
                        cantidad = cantidad + 1;
                    }
                }

                total = total + cantidad;
                detalle = detalle + " | " + estados[j] + ": " + cantidad;
            }

            reporte = reporte + "\n" + categorias.get(i) + ": " + total + " envios" + detalle;
        }

        reporte = reporte + "\nTotal de envios: " + envios.size();

        return reporte;
    }

    /* Suma lo cobrado al registrar cada envio */
    public double calcularIngresosRegistro() {
        double total = 0;

        for (int i = 0; i < envios.size(); i++) {
            total = total + envios.get(i).getMontoRegistro();
        }

        return total;
    }

    /* Suma los cargos por reintento de cada envio */
    public double calcularIngresosReintentos() {
        double total = 0;

        for (int i = 0; i < envios.size(); i++) {
            total = total + envios.get(i).getCargosReintento();
        }

        return total;
    }

    /* Ingresos por registro mas ingresos por reintentos */
    public double calcularIngresoTotal() {
        return calcularIngresosRegistro() + calcularIngresosReintentos();
    }

    /* Ingreso de cada categoria, separado en registro y reintentos */
    public String reporteIngresosPorCategoria() {
        if (envios.size() == 0) {
            return "Todavia no hay envios registrados";
        }

        ArrayList<String> categorias = obtenerCategorias();
        String reporte = "INGRESOS POR CATEGORIA";

        for (int i = 0; i < categorias.size(); i++) {
            double registro = 0;
            double reintentos = 0;

            for (int j = 0; j < envios.size(); j++) {
                if (envios.get(j).getCategoria().equals(categorias.get(i)) == true) {
                    registro = registro + envios.get(j).getMontoRegistro();
                    reintentos = reintentos + envios.get(j).getCargosReintento();
                }
            }

            reporte = reporte + "\n" + categorias.get(i) + ": Q" + String.format("%,.2f", registro + reintentos)
                    + " (registro: Q" + String.format("%,.2f", registro)
                    + " | reintentos: Q" + String.format("%,.2f", reintentos) + ")";
        }

        return reporte;
    }

    /* Despachos que no estan cerrados, con su vehiculo, su peso cargado y su capacidad disponible */
    public String reporteDespachosAbiertos() {
        String reporte = "DESPACHOS NO CERRADOS";
        int abiertos = 0;

        for (int i = 0; i < despachos.size(); i++) {
            if (despachos.get(i).estaCerrado() == false) {
                reporte = reporte + "\n" + despachos.get(i).toString();
                abiertos = abiertos + 1;
            }
        }

        if (abiertos == 0) {
            reporte = reporte + "\nNo hay despachos sin cerrar";
        }

        return reporte;
    }
}
