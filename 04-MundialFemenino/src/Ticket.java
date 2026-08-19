import java.util.Random;
public class Ticket {
//se debe importar la clase Random para generar numeros aleatorios


//atributos
private int Num_ticket;
private int Limite_superior;
private int Limite_inferior;
private Localidad Localidad_asignada;
private boolean Puede_comprar;

//Metodos
public Ticket() {
    // Constructor
}

public void Generar_ticket(){

    Random random = new Random();

    Num_ticket = random.nextInt(15000) + 1; // Genera un número aleatorio entre 1 y 15000

}

public void Generar_rango(){

    Random random = new Random();

    Limite_superior = random.nextInt(15000) + 1; // Genera un número aleatorio entre 1 y 15000
    Limite_inferior = random.nextInt(Limite_superior) + 1; // Genera un número aleatorio entre 1 y el límite superior

}

public boolean Validacion_ticket(){

    if (Num_ticket >= Limite_inferior && Num_ticket <= Limite_superior) {
        Puede_comprar = true;
    } else {
        Puede_comprar = false; //Compara si el numero de ticket esta dentro del rango de los limites superior e inferior
    }

    return Puede_comprar;

}

public void Generar_loc(Localidad[] Localidades){

    Random random = new Random();

    int indice = random.nextInt(Localidades.length); // Genera un índice aleatorio dentro del rango del arreglo

    Localidad_asignada = Localidades[indice]; // Asigna la localidad aleatoria al ticket

}

public Localidad getLocalidad_asignada() {

    return Localidad_asignada; //Regresa la localidad asignada al ticket para poder seguir con el proceso en el controlador

}
}