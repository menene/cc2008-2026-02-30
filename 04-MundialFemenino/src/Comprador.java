public class Comprador {

//Atributos
    private String Nombre;
    private String Email;
    private int Cant_boletos;
    private float Presupuesto_max;

//Constructor
public Comprador(String Nombre, String Email, int Cant_boletos, float Presupuesto_max) {

    this.Nombre = Nombre;
    this.Email = Email;
    this.Cant_boletos = Cant_boletos;
    this.Presupuesto_max = Presupuesto_max;

}

public void setNombre(String Nombre) {

    this.Nombre = Nombre; //Setea el nombre del comprador
    
}

public void setEmail(String Email) {

    this.Email = Email; //Setea el email del comprador
    
}

public void setCant_boletos(int Cant_boletos) {

    this.Cant_boletos = Cant_boletos; //Setea la cantidad de boletos que el comprador desea comprar
    
}

public void setPresupuesto_max(float Presupuesto_max) {

    this.Presupuesto_max = Presupuesto_max; //Setea el presupuesto maximo que el comprador tiene para gastar en boletos
    
}

public String getNombre() {

    return Nombre; //Regresa el nombre del comprador

}

public String getEmail() {

    return Email; //Regresa el email del comprador

}

public int getCant_boletos() {

    return Cant_boletos; //Regresa la cantidad de boletos que el comprador desea comprar

}

public float getPresupuesto_max() {

    return Presupuesto_max; //Regresa el presupuesto maximo que el comprador tiene para gastar en boletos

}
}