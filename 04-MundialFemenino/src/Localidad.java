public class Localidad {

//Atributos
    private int Num_loc;
    private int Capacidad_loc;
    private int Boletos_vendidos;
    private float Precio_loc;


//Constructor
public Localidad(int Num_loc, int Capacidad_loc, float Precio_loc) {

    this.Num_loc = Num_loc;
    this.Capacidad_loc = Capacidad_loc;
    this.Precio_loc = Precio_loc;
    this.Boletos_vendidos = 0; // El contador de boletos vendidos inicia en 0 al crear una nueva localidad

}

//Metodos
public boolean Hay_espacio() {
    
    return Boletos_vendidos < Capacidad_loc; // Regresa un true si hay espacio disponible y un false si ya no hay

}

public int Boletos_disponibles() {

    return Capacidad_loc - Boletos_vendidos; // Regresa la cantidad de boletos disponibles en la localidad
}

public int Venta_boletos(int cantidad) {

    int Boletos_disponibles = Boletos_disponibles();

    if (cantidad <= Boletos_disponibles) {
        
        Boletos_vendidos += cantidad; // Le suma al contador de boletos vendidos
        return cantidad; // Regresa la cantidad de boletos vendidos

    } else {
        Boletos_vendidos += Boletos_disponibles; // Vende la cantidad de boletos disponibles si la cantidad solicitada es mayor
        return Boletos_disponibles; // Regresa la cantidad de boletos vendidos

}
}

public float getPrecio() {

    return Precio_loc; // Regresa el precio de la localidad

}

public int getNumero() {

    return Num_loc; // Regresa el número de la localidad

}

public int getBoletos_vendidos() {

    return Boletos_vendidos; // Regresa la cantidad de boletos vendidos en la localidad

}

}

