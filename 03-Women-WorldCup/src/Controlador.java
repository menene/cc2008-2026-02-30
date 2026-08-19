import java.util.Scanner;
import java.util.Random;

public class Controlador{

    private Vista vista;
    private Usuario usuario;
    private Random random = new Random();
    private int caja = 0;

    private Localidad localidad1;
    private Localidad localidad5;
    private Localidad localidad10;
    private Scanner sc = new Scanner(System.in);


    public Controlador(){
        vista = new Vista();

        localidad1 = new Localidad(1,100);
        localidad5 = new Localidad(5,500);
        localidad10 = new Localidad(10,1000);


    }

    public void iniciar(){
        
        int opcion = 0;
        while (opcion != 6){

            vista.mostarMenu();

            System.out.println("Selecciones una opcion: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch(opcion){

                case 1:
                    NuevoComprador();
                    pausa();
                    break;
                
                case 2:
                    if (usuario == null){
                        System.out.println("Primero genera un usuario");
                        return;
                    }
               
                    nuevaSolicitud();
                    pausa();
                    break;

                case 3:
                    disponibilidadTotal();
                    pausa();
                    break;
                case 4:
                    disponibilidadIndividual();
                    pausa();
                    break;
                case 5:
                    reporteCaja();
                    pausa();
                    break;
                case 6:
                    //slair
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }
        

    }

    //lo que hay en el menu
    public void NuevoComprador(){
        System.out.print("Ingrese el nombre:");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el email:");
        String email = sc.nextLine();
        System.out.print("Ingrese el boletos:");
        int boletos = Integer.parseInt(sc.nextLine());
        System.out.print("Ingrese su presupuesto:");
        int presupuesto = Integer.parseInt(sc.nextLine());

        usuario = new Usuario(nombre,email,boletos,presupuesto);
        System.out.println("Ingresado correctamente");
    }

    public int generarTicket(){

        int ticket = random.nextInt(15000)+1;
        return ticket;
    }

    public boolean validarTicket(int ticket){
        int a = random.nextInt(15000)+1;
        int b = random.nextInt(15000)+1;

        int menor = Math.min(a,b);
        int mayor = Math.max(a,b);

        if(ticket >= menor && ticket <= mayor){
            return true;
        }
        return false;
    }

    public void nuevaSolicitud(){
        int ticket = generarTicket();
        System.out.println("Su ticket es "+ ticket);

        if (validarTicket(ticket)){
            System.out.println("Su ticket fue seleccionado");
            Localidad localidad = generarlocalidad();

            System.out.println("Localidad a la cual se le asigno es "+ localidad.getNumero());

            if (!localidad.hayEspacio()){
                System.out.println("No hay espacio pruebe de nuevo ");
                return;
            }

            int boletos = usuario.getcantidadBoleto();

            if(boletos > localidad.getdisponibles()){
                boletos = localidad.getdisponibles();

            int total = boletos * localidad.getprecio();

            if(total > usuario.getpresupuesto()){
                System.out.println("No tiene suficiente presupuesto.");
                return;
            }  
            localidad.venderBoletos(boletos); 
            caja = caja + total;
}
        }else{
            System.out.println("Su ticket NOOOO fue seleccionado");
            return;
        }
        

    }
    public void pausa(){

        System.out.println("\nPresione ENTER para continuar...");
        sc.nextLine();

    }

    public void disponibilidadTotal(){
        System.out.println("Localidad 1 "+ localidad1.getdisponibles());
        System.out.println("Localidad 5 "+ localidad5.getdisponibles());
        System.out.println("Localidad 10 "+ localidad10.getdisponibles());
    }

    public void disponibilidadIndividual(){
        System.out.println("Ingrese la localidad (1,5 y 10)");
        int opcion = Integer.parseInt(sc.nextLine());

        if (opcion == 1){
            System.out.println(localidad1.getdisponibles());
        }
        else if (opcion == 5){
            System.out.println(localidad5.getdisponibles());
        }
        else if (opcion == 10){
            System.out.println(localidad10.getdisponibles());
        }
        else{
            System.out.println("Localidad es invalida");
        }

    }

    public Localidad generarlocalidad(){
        int opcion = random.nextInt(3);
        if (opcion == 0){
            return localidad1;
        }else if (opcion ==1){
            return localidad5;
        }else{
            return localidad10;
        }
    }

    public void reporteCaja(){
        System.out.println("Dinero recaudado: $" + caja);

    }

    

}