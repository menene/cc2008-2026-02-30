//se importa la funcion "Random" de java.util para hacer la aleatorizacion
import java.util.Random;

public class Ticket {
    
    //Atributos
    private int Numero_Ticket;

    //numeros aleatorios a y b para la validacion
    private int Limite_Inferior;
    private int Limite_Superior;

    //guarda true si gano el derecho a comprar y false si no
    private boolean Validacion;
}

public void generarYValidarAleatorios() {
    //mecanismo para generar numeros aleatorios
    Random aleatorio = new Random();

    //Generamos numero del 1 al 15 000
    //Cambiar el numero entre parentesis si se requiere de otro valor
    this.Numero_Ticket = aleaotorio.nextInt(15000) + 1;
    int a = aleatorio.nextInt(15000) + 1;
    int b = aleatorio.nextInt(15000) + 1;

    //Se necesita saber cual es el limite pequeño y cual el grande
   
    //caso a, el numero a es mas pequeño que el b
    // entonces el limite inferior es el a y el superior el b
    if(a < b){
        this.Limite_Inferior = a;
        this.Limite_Superior = b;
    }
    //caso b, el numero b es mas pequeño que el a, por lo que 
    //el limite inferior sera el b y el superior el a
    else {
        this.Limite_Inferior = b;
        this.Limite_Superior = a;
    }
//se verifica si el ticket quedo entre los dos limites con el operativo and (&&)
    if (this.Numero_Ticket >= this.Limite_Inferior && this.Numero_Ticket <= this.Limite_Superior) {
        this.Validacion = true; //en este caso si se cumplio y se puede comprar
    }
    else {
        this.Validacion = false; // en este caso no se cumplio por lo que no se podra comprar
    }
}

//getters que el controlador leera

//devuelve el numero de ticket generado
public int getNumero_Ticket() {
    return this.Numero_Ticket;
}

//retorna si el ticket es valido o no
public boolean esAptoParaCompra() {
    return this.Validacion
}