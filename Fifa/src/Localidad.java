public class Localidad {
    private int cantBoletos; 
    private String nombre;
    private float precioBoleto;
    private int boletosVendidos; 
    private float caja;



    public Localidad(String nombre, float precioBoleto) {
       cantBoletos = 20;
       boletosVendidos = 0;
       caja = 0; 
       this.nombre = nombre;
       this.precioBoleto = precioBoleto; 

    }

    public float getPrecioBoleto() {
        return precioBoleto;
    }

    public int getBoletosVendidos() {
        return boletosVendidos;
    }

    public float getCaja() {
        return caja;
    }
    
    public boolean validarPresupuesto(float presupuestoMax) {
        if (presupuestoMax >= precioBoleto) {
            return true;
        } else {
            return false;
        }
    }

    public int espaciosDisponibles(){
        int espaciosDisponibles = cantBoletos - boletosVendidos;  
        return espaciosDisponibles;
    }
        
    public int boletosDisponibles(int cantidadBoletos) {
        int boletosDisponibles = espaciosDisponibles();
        if (cantidadBoletos <= boletosDisponibles) {
            return cantidadBoletos;
        } else {
            return boletosDisponibles;
        }
    }

    public void agregarVentas(int boletosComprados) {
        boletosVendidos += boletosComprados;
        caja += (boletosComprados * precioBoleto);
    }

}