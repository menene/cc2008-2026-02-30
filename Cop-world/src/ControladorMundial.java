import java.util.Random;

public class ControladorMundial{
    // atributos
    private Localidad l1, l5, l10;
    private Comprador comprador;
    private final int rangoMin = 1;
    private final int rangoMax = 15000;
    private VistaMundial vista;
    private Random random = new Random();

    // métodos
    public ControladorMundial(){
        // se crean las 3 localidades del piloto, 60 boletos repartidos en partes iguales
        l1 = new Localidad("Localidad 1", 100, 20);
        l5 = new Localidad("Localidad 5", 500, 20);
        l10 = new Localidad("Localidad 10", 1000, 20);
        vista = new VistaMundial();
    }

    public void iniciar(){
        // Ciclo del menú
        boolean continuar = true;
        int opcion;

        while(continuar){
            vista.mostrarMenu();
            opcion = vista.leerOpcion();

            if (opcion == 1) {
                nuevoComprador();
            } 
            else if (opcion == 2) {
                procesarSolicitud();
            } 
            else if (opcion == 3) {
                consultarDisponibilidadTotal();
            } 
            else if (opcion ==4){
                consultarDisponibilidadIndividual();
            }
            else if (opcion == 5){
                vista.mostarReporte(totalRecaudado());
            }
            else if (opcion == 6) {
                continuar = false;
                System.out.println("Gracias por preferirnos.");
            }
            else{
                System.out.println("Opcion invalida. Intentalo nuevamente");
            }
        }
    }

    // iniciar()
    public void nuevoComprador(){
        // reemplaza la instancia actual del comprador activo
        String[] datos = vista.pedirDatosComprador();

        String nombre = datos[0];
        String email = datos[1];
        int boletosQuerer = Integer.parseInt(datos[2]);
        int presupuesto = Integer.parseInt(datos[3]);

        comprador = new Comprador(
            nombre,
            email,
            boletosQuerer,
            presupuesto);
    }

    // iniciar()
    // procesarSolicitud()
    private int generarTicket(){
        // generá el ticket y lo asigna al comprador
        int ticket = random.nextInt(rangoMax - rangoMin + 1) + rangoMin;
        return ticket;
    }

    // procesarSolicitud()
    private boolean esApto(int ticket){
        // genera los dos números para comparar, verifica, y asigna al comprador si es apto o no para continuar
        int a = random.nextInt(rangoMax - rangoMin + 1) + rangoMin;
        int b = random.nextInt(rangoMax - rangoMin + 1) + rangoMin;

        if (a > b){
            return ticket <= a && ticket >= b;
        }
        else{
            return ticket <= b && ticket >= a;
        }
    }

    // procesarSolicitud()
    // asigna la localidad aleatoria al comprador
    private Localidad asignarLocalidad(){
        int indice = random.nextInt(3);

        if (indice == 0){
            return l1;
        }
        else if (indice == 1){
            return l5;
        }
        else{
            return l10;
        }
    }

    // procesarSolicitud()
    // valida disponibilidad de los boletos deseados: si no alcanzan, devulve los que aún quedan

    private int boletosDisponibles(int capacidad, int boletosVendidos, int boletosQuerer){
        int espacio = capacidad - boletosVendidos;

        if (boletosQuerer <= espacio){
            return boletosQuerer;
        }
        else{
            return espacio;
        }
    }

    // procesarSolicitud()
    // valida que el presupuesto alcance para el precio de la localidad
    private boolean compararPresupuesto(int presupuesto, int precio, int boletosTener){
        int costoTotal = precio * boletosTener;
        return presupuesto >= costoTotal;
    }

    // iniciar()
    public void procesarSolicitud(){
        // Generar el ticket, verificar si es apto y guardar los datos en el comprador
        int ticket = generarTicket();
        comprador.setTicket(ticket);

        boolean apto = esApto(ticket);
        comprador.setEsApto(apto);

        if (apto){
            // Seleccionar aleatoriamente la localidad
            Localidad localidadAsignada = asignarLocalidad();
            comprador.setLocalidad(localidadAsignada);

            // Validar espacios disponibles
            if (localidadAsignada.getBoletosDisponibles() > 0){

                // Validar disponibilidad de los boletos deseados
                int boletos = boletosDisponibles(
                    localidadAsignada.getCapacidad(),
                    localidadAsignada.getBoletosVendidos(),
                    comprador.getBoletosQuerer());


                // Validar precio contra el presupuesto del comprador
                if (compararPresupuesto(comprador.getPresupuesto(), localidadAsignada.getPrecio(), boletos)){
                    localidadAsignada.venderBoletos(boletos);
                    comprador.setBoletosTener(boletos);
                }
            }
        }

        vista.mostrarMensaje(compradorFinal());
    }

    public Comprador compradorFinal(){
        return comprador;
    }


    // inicar()
    public void consultarDisponibilidadTotal(){
        String[] nombres = {l1.getNombre(), l5.getNombre(), l10.getNombre()};
        int[] vendidos = {l1.getBoletosVendidos(), l5.getBoletosVendidos(), l10.getBoletosVendidos()};
        int[] disponibles = {l1.getBoletosDisponibles(), l5.getBoletosDisponibles(), l10.getBoletosDisponibles()};

        vista.mostrarDisponibles(nombres, vendidos, disponibles);
    }

    public void consultarDisponibilidadIndividual(){
        String nombre = vista.pedirNombreLocalidad();
        Localidad localidad = buscarLocalidad(nombre);

        if (localidad != null){
            String[] nombres = {localidad.getNombre()};
            int[] vendidos = {localidad.getBoletosVendidos()};
            int[] disponibles = {localidad.getBoletosDisponibles()};
            vista.mostrarDisponibles(nombres, vendidos, disponibles);
        }
        else{
            System.out.println("Localidad no encontrada.");
        }
    }

    private Localidad buscarLocalidad(String nombre){
        if (nombre.equals(l1.getNombre())){
            return l1;
        }
        else if (nombre.equals(l5.getNombre())){
            return l5;
        }
        else if (nombre.equals(l10.getNombre())){
            return l10;
        }
        else{
            return null;
        }
    }

    public int totalRecaudado(){
        int total = (l1.getPrecio() * l1.getBoletosVendidos())
                  + (l5.getPrecio() * l5.getBoletosVendidos())
                  + (l10.getPrecio() * l10.getBoletosVendidos());
        return total;
    }

}
