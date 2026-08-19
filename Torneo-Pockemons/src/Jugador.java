import java.util.Random;
public class Jugador{
    
    // atributos

    String nombre;
    Pockemon pockemon1;
    Pockemon pockemon2;
    Pockemon pockemon3;
    Pockemon pockemon4;
    int rondasGanadas;
    Random random = new Random();

    
    // métodos 

    // Crea un jugador con su nombre y sus cuatro pokemon
    public Jugador(String nombre, Pockemon pockemon1, Pockemon pockemon2, Pockemon pockemon3, Pockemon pockemon4){
        this.nombre = nombre;
        this.pockemon1 = pockemon1;
        this.pockemon2 = pockemon2;
        this.pockemon3 = pockemon3;
        this.pockemon4 = pockemon4;
    }

    // Genera un numero al azar entre uno y cuatro y revisa con condicionales cual pokemon corresponde a ese numero, si ese pokemon ya peleo vuelve a generar otro numero hasta encontrar uno disponible y lo retorna
    public Pockemon seleccionarPockemonAleatorio(){

        int numeroPockemon = random.nextInt(4) + 1;

        boolean posibilidad1 = pockemon1.getHaPeleado();
        boolean posibilidad2 = pockemon2.getHaPeleado();
        boolean posibilidad3 = pockemon3.getHaPeleado();
        boolean posibilidad4 = pockemon4.getHaPeleado();

        // mientras el pokemon elegido al azar ya haya peleado se vuelve a generar otro numero
        while ((numeroPockemon == 1 && posibilidad1 == true) || (numeroPockemon == 2 && posibilidad2 == true) || (numeroPockemon == 3 && posibilidad3 == true) || (numeroPockemon == 4 && posibilidad4 == true)){
            numeroPockemon = random.nextInt(4) + 1;
            posibilidad1 = pockemon1.getHaPeleado();
            posibilidad2 = pockemon2.getHaPeleado();
            posibilidad3 = pockemon3.getHaPeleado();
            posibilidad4 = pockemon4.getHaPeleado();
        }
        
        //  si la posibilidad es verdadera el pockmeon ya peleo y no puede volver a participar
        if (numeroPockemon == 1 && posibilidad1 == false){
            return pockemon1;
        }
        if (numeroPockemon == 2 && posibilidad2 == false){
            return pockemon2;
        }
        if (numeroPockemon == 3 && posibilidad3 == false){
            return pockemon3;
        }
        // el ultimo caso disponible es el pockemon4
        return pockemon4;
    }

    // Suma uno al contador de rondas ganadas del jugador
    // PENDIENTE: como rondasGanadas no tiene modificador de visibilidad (es de paquete),
    // ControladorRonda le suma directamente al atributo cuando define el ganador de la ronda.

    // getters de los datos de la clase Jugador

    public String getNombre(){
        return nombre;
    }

    public Pockemon getPockemon1(){
        return pockemon1;
    }

    public Pockemon getPockemon2(){
        return pockemon2;
    }

    public Pockemon getPockemon3(){
        return pockemon3;
    }

    public Pockemon getPockemon4(){
        return pockemon4;
    }

    public int getRondasGanadas(){
        return rondasGanadas;
    }


}
