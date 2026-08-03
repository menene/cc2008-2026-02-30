public class Localidad {
    private String Nombre;
    private int BoletosDisponibles;
    private float PrecioBoletos;

    public Localidad (String n, int b, float p){
        this.Nombre=n;
        this.BoletosDisponibles=b;
        this.PrecioBoletos=p;
    }

    public boolean hayDisponibles(){
        if (BoletosDisponibles > 0) {
            return true;
        }else{
            return false;
        }
    }

    public void Ventas (int cantidad){
        int contador=0;
        while(contador<cantidad){
            BoletosDisponibles=BoletosDisponibles -1;
            contador = contador+1;
        }
    }

    public float calcularCosto(int cantidad){
        float total_acumulado_por_si_acaso=0.0f;
        int i =0;
        while(i<cantidad){
            total_acumulado_por_si_acaso +=PrecioBoletos;
            i+=1;

        }
        return total_acumulado_por_si_acaso;
    }

    public int getBoletosDisponibles(){
        return BoletosDisponibles;
    }
    public float getPrecio (){
        return PrecioBoletos;
    }
    public String getNombre (){
        return Nombre;
    }


}