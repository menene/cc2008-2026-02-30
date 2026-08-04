public class ControladorVenta {

//Atributos
private Comprador Comprador_actual;
private Localidad[] Localidades;
private Ticket Ticket_actual;


//Constructor para las localidades
public ControladorVenta(){

    Localidades = new Localidad[3];

    Localidades[0] = new Localidad(1,20,100);
    Localidades[1] = new Localidad(5,20,500);
    Localidades[2] = new Localidad(10,20,1000);

}

//Metodos

//El metodo para registrar comprador requiere recibir la informacion del comprador desde la clase comprador.
public void Registrar_comprador(String Nombre, String Email, int Cant_boletos, float Presupuesto_max){

    Comprador_actual = new Comprador(Nombre, Email, Cant_boletos, Presupuesto_max);

}

public void Solicitar_compra(){

    if (Comprador_actual == null) {

        System.out.println("Debe de registrar al comprador.");
        return;
    }

    Ticket_actual = new Ticket(); //Gener un nuevo ticket para el comprador actual

    Ticket_actual.Generar_ticket();
    Ticket_actual.Generar_rango();

    if (!Ticket_actual.Validacion_ticket()) {

        System.out.println("El ticket no fue escogido para realizar la compra, vuelva a intentarlo.");
        return;

    }

    Ticket_actual.Generar_loc(Localidades);

    Localidad localidad_asignada = Ticket_actual.getLocalidad_asignada(); //Obtiene la localidad asignada al ticket para poder seguir con el proceso de compra

    if (!localidad_asignada.Hay_espacio()) {

        System.out.println("No queda espacio en la localidad que se le fue asignada.");
        return;

    }

    //Se realiza la venta de boletos y se calcula el total de la compra
    int vendidos = localidad_asignada.Venta_boletos(Comprador_actual.getCant_boletos());

    float total = vendidos * localidad_asignada.getPrecio();

    if (total > Comprador_actual.getPresupuesto_max()) {

        System.out.println("El presupuesto del comprador no es suficiente para poder realizar la compra.");
        return;
        //Si el total de la compra es mayor al presupuesto del comprador, se cancela la compra

    }

    System.out.println("La compra fue realizada con exito.");
    System.out.println("Se vendieron " + vendidos + " boletos en la localidad " + localidad_asignada.getNumero() + ".");
    System.out.println("El total de la compra es: $" + total + ".");

}

public void Consultar_dispoTotal(){

    System.out.println("\nDisponibilidad de boletos por localidad:"); //Se muestra la disponibilidad de boletos, se muestra la cantidad disponible, la cantidad vendida y el precio de cada localidad

    for(int i = 0; i < Localidades.length; i++) {

        System.out.println("Localidad " + Localidades[i].getNumero() + ": " 
        + Localidades[i].Boletos_disponibles() + " boletos disponibles." 
        + "\n Boletos vendidos: " + Localidades[i].getBoletos_vendidos() 
        + "\nPrecio: $" + Localidades[i].getPrecio() + "\n");

        System.out.println("--------------------------------------------------");
    }

}

public void Consultar_DispoIndividual(int numLocalidad){ 

    for (int i = 0; i < Localidades.length; i++) {

        if (Localidades[i].getNumero() == numLocalidad) {

            System.out.println("Boletos disponibles en la localidad " + Localidades[i].Boletos_disponibles());

            //Se muestra la cantidad de boletos disponibles, la cantidad vendida y el precio de la localidad solicitada
            return;
        }
    }

    System.out.println("No se encontró la localidad solicitada.");

}

//Se muestra el total de dinero recaudado en caja, multiplicando la cantidad de boletos vendidos por el precio de cada localidad
public float Reporte_caja() {

    float totalCaja = 0;

    for (int i = 0; i < Localidades.length; i ++){

        totalCaja += Localidades[i].getBoletos_vendidos() * Localidades[i].getPrecio();

    }

    return totalCaja;

}
}