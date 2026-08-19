
import java.util.Random;

public class Controlador { //El cerebro del programa. Toma decisiones.

    //objetos
    private Comprador comprador;
    private Localidad localidad1;
    private Localidad localidad5;
    private Localidad localidad10;

    public Controlador(){
        //instancio localidades
        localidad1 = new Localidad(1, 100, 20);
        localidad5 = new Localidad(5,500,20);
        localidad10 = new Localidad(10,1000,20);

    }
    public void setComprador(Comprador comprador){

    this.comprador = comprador;

    }

    //generar ticket
    public int generarTicket(){
        Random random= new Random(); //Objeto Random
        int ticket= random.nextInt(15000) + 1; //creo el numero random
        comprador.setTicket(ticket); //seteo ticket en comprador. WOOOOW
        return ticket;
    }

    private boolean validarTicket(){
        Random random= new Random();
        //creo 2 numeros aleatorios
        int a = random.nextInt(15000) + 1;
        int b = random.nextInt(15000) + 1;
        //PRIMERO ENCUENTRO EL MAYOR, luego comparo 
        int menor= Math.min(a, b);
        int mayor= Math.max(a, b);
        //validar
        int ticket= comprador.getTicket(); //obtengo el valor del ticket
        return ticket >= menor && ticket <= mayor; //valida que el ticket este dentro del rango permitido
    }

    public Localidad generarLocalidad(){ //devuelve un objeto Localidad, asi no tengo que validar de nuevo
        Random random= new Random();
        int opcion = random.nextInt(3);

        //Determinar localidad y devolver
        if (opcion==0){
            return localidad1;
        }

        if (opcion== 1){
            return localidad5;
        }

        return localidad10;
    }

    public boolean validarEspacio(Localidad localidad){ //obtengo la localidad (1, 5 o 10)
        // valida que exista espacio
        if (localidad.getDisponibles() > 0) {
            return true;
        }

        return false;
    }
    //armar rompecabezas
    public boolean validarPresupuesto(Localidad localidad){
        //compara el presupuesto con el precio de la localidad que le toco
        if (comprador.getPresupuestoMaximo() >= localidad.getPrecio()) {
        return true;
        }

        return false;
    }
    public void compra() {

        generarTicket();
        if (comprador == null) {
        System.out.println("Primero debe registrar un comprador.");
        return;
        }

        if (!validarTicket()) {
        System.out.println("El ticket no fue seleccionado para comprar boletos.");
        return;
        }

        Localidad localidad = generarLocalidad();

    if (!validarEspacio(localidad)) {
        System.out.println("La localidad está llena.");
        return;
        }

    if (!validarPresupuesto(localidad)) {
        System.out.println("El presupuesto no alcanza para esta localidad.");
        return;
        }

    int cantidadAVender;

    if (comprador.getCantidadBoletos() > localidad.getDisponibles()) {
        cantidadAVender = localidad.getDisponibles();
    } else {
        cantidadAVender = comprador.getCantidadBoletos();
        }

        localidad.venderBoletos(cantidadAVender);

        System.out.println("Compra realizada con éxito.");
        System.out.println("Localidad: " + localidad.getNumero());
        System.out.println("Boletos comprados: " + cantidadAVender);

    }

    public void consultarDisponibilidadTotal() {

        System.out.println("LOCALIDAD 1");
        System.out.println("Vendidos: " + localidad1.getBoletosVendidos());
        System.out.println("Disponibles: " + localidad1.getDisponibles());

        System.out.println();

        System.out.println("LOCALIDAD 5");
        System.out.println("Vendidos: " + localidad5.getBoletosVendidos());
        System.out.println("Disponibles: " + localidad5.getDisponibles());

        System.out.println();

        System.out.println("LOCALIDAD 10");
        System.out.println("Vendidos: " + localidad10.getBoletosVendidos());
        System.out.println("Disponibles: " + localidad10.getDisponibles());

    }
    public void consultarDisponibilidadIndividual(int numero) {

        if (numero == 1) {

            System.out.println("Disponibles: " + localidad1.getDisponibles());

        } else if (numero == 5) {

            System.out.println("Disponibles: " + localidad5.getDisponibles());

        } else if (numero == 10) {

            System.out.println("Disponibles: " + localidad10.getDisponibles());

        } else {

            System.out.println("Localidad no existe.");

        }

    }

    public void reporteCaja() {

        double total = 0;

        total += localidad1.getBoletosVendidos() * localidad1.getPrecio();
        total += localidad5.getBoletosVendidos() * localidad5.getPrecio();
        total += localidad10.getBoletosVendidos() * localidad10.getPrecio();

        System.out.println("Total generado: $" + total);

    }
    
}
