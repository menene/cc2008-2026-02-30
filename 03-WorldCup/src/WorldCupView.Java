import java.util.Scanner;
public class WorldCupView{
    public int MostrarMenu(){
        System.out.println("Sistema de Tickets patrocinados por ACME");
        System.out.println("1. Ingresar nuevo comprador");
        System.out.println("2. Hacer una nueva solicitud de compra");
        System.out.println("3. ver disponivilidad total");
        System.out.println("4. Ver Dsiponibilidad Individual");
        System.out.println("5. Ver reporte de caja");
        System.out.println("6. Salir del programa y cerrar");
        
        Scanner scannerLoco= new Scanner(System.in);
        int opcionSeleccionada = scannerLoco.nextInt();
        return opcionSeleccionada;
   }

   public Comprador datosComprador(){
        Scanner s1 = new Scanner(System.in);
        System.out.println("Escribe tu nombre completo aqui porfavor:");
        String nombreUser = s1.nextLine();

        System.out.println("Escribe tu correo aqui porfavor:");
        String correoUser = s1.nextLine();

        System.out.println("¿Cuantos Boletos quieres comprar?:");
        byte boletosUser = s1.nextByte();

        System.out.println("¿Cúal es el precupuesto maximo?:");
        float dineroUser = s1.nextFloat();

        return new Comprador(nombreUser, correoUser, boletosUser, dineroUser);
   }

   public int datosLocalidad() {
        Scanner s = new Scanner(System.in);
        System.out.println("Cual localidad quieres? (1 para Localidad 1, 2 para Localidad 2, 3 para Localidad 3):");
        return s.nextInt();
    }

    public void mensaje (String mensaje){
        System.out.println(mensaje);
    }

    public void disponivilidad (Localidad[] localidades){
        System.out.println(localidades[0].getNombre()+" tiene: " + localidades[0].getBoletosDisponibles());
        System.out.println(localidades[1].getNombre()+" tiene: " + localidades[1].getBoletosDisponibles());
        System.out.println(localidades[2].getNombre()+" tiene: " + localidades[2].getBoletosDisponibles());
    }

    public void MostrarCaja(float total){
        System.out.println("El dinero total es: " + total);
    }
    public void mostrarCajaLocalidad(Contabilidad contabilidad){
        System.out.println("Localidad 1 hizo "+ contabilidad.obtenerCajaLocalidad("Localidad 1"));
        System.out.println("Localidad 2 hizo "+ contabilidad.obtenerCajaLocalidad("Localidad 2"));
        System.out.println("Localidad 3 hizo "+ contabilidad.obtenerCajaLocalidad("Localidad 3"));
    }
}

